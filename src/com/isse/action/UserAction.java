package com.isse.action;

/*********************************************
 * author: wudaowen
 * date  : 2013.7.16
 * comments: UserAction
 *********************************************/

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;

import com.util.MD5Util;
import com.util.PageBean;

import com.isse.model.TAnnouncement;
import com.isse.model.TAnnouncementModel;

import com.isse.model.TExpertTeacher;
import com.isse.model.TProject;

import com.isse.model.TStudent;
import com.isse.model.TTeacher;

import com.isse.model.TUnit;
import com.isse.model.TUser;
import com.isse.service.AnnouncementService;
import com.isse.service.ExpertTeacherService;
import com.isse.service.ProjectService;
import com.isse.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends BaseAction 
{

	private static final long serialVersionUID = -8331089822539279241L;
	private UserService userService;
	private TUser user;
	private List<TUser> listUsers;
	private String id;
	
	private String userId;
	private String userName;
	private String userType;
	private String userState;
	private String validateCode;
	private String password;
	
	/**
	 * 分页使用的参数
	 */
	private int page = 1; // 初始页面
	private PageBean pageBean; // 分页用的bean
	private int totalPage = 1; // 总页面数
	private int totalNumber = 0; // 总数据条数
	private int pageCapacity = 14; // 每页显示条数
	
	
	/**
	 * 获取教务处最近五条公告
	 * @return
	 */
	private List<TAnnouncementModel> announcements;
	private List<TAnnouncement> announcementList;
	private List<TAnnouncement> commonAnnouncement;
	private List<TExpertTeacher> expertTeachers;
	private List<TProject> projects;
	
	private AnnouncementService announcementService;
	private ExpertTeacherService expertTeacherService;
	private ProjectService projectService;
	

	

	private TStudent student;
	private TTeacher teacher;
	private String newPassword;
	private Boolean statu;
	
	public String changePassword(){
		String md5Pwd = MD5Util.MD5(password);
		if (userService.userLogin(userId, md5Pwd) == null) {
			statu = false;
		}else {
			String newMd5Pwd = MD5Util.MD5(newPassword);
			this.userService.changePassword(userId, newMd5Pwd);
			statu = true;
		}
		return SUCCESS;
	}
	public String findUserInfo(){
		try {
			user = getSessionUser();
			if(user == null || user.getUserId() == null
					|| user.getUserId().equals("")){
				toLogin();
			}else {
				System.out.println("060708".indexOf(user.getUserType().trim()));
				if ("060708".indexOf(user.getUserType().trim()) >= 0) {
					student = this.userService.getStudentByUserId(user.getUserId());
				}else {
					teacher = this.userService.getTeacherByUserId(user.getUserId());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			return "error";
		}
		
		return SUCCESS;
	}
	
		public String userLogin() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		Map session = ActionContext.getContext().getSession();
		String sessionVaCode = (String) request.getSession().getAttribute("validateCode");
		if (!sessionVaCode.equals(validateCode)) {
			request.setAttribute("msg", "验证码错误！");
			return "login";
		}
		String md5Pwd = MD5Util.MD5(password);
		if (userService.userLogin(userId, md5Pwd) == null) {
			request.setAttribute("msg", "用户名或密码错误！");
			return "login";
		} else {
			user = userService.userLogin(userId, md5Pwd);			
			session.put("user", user);
			userService.changeLoginState(user.getUserId(), "YY");
			request.setAttribute("msg", "登录成功!");
			String uType = user.getUserType();
			TUnit unit = userService.getUnitByUserId(user.getUserId(),uType);
			session.put("unit", unit);
			
			if ("06".equals(uType)||"07".equals(uType)||"08".equals(uType)){
				announcements = listIndexDeanAnnouncement();
				announcementList = listIndexUnitAnnouncement(user.getUserId());
				commonAnnouncement = listCommonAnnouncement();
				return "student";
			}else if ("02".equals(uType)||"03".equals(uType)||"04".equals(uType)||"05".equals(uType)) {
				expertTeachers = listHistoryExpert(user.getUserId());
				projects = listProjectByTeaCode(user.getUserId());
				return "teacher";
			}
			else if ("01".equals(uType)||"00".equals(uType))
			{
				announcements = listIndexDeanAnnouncement();
				return "jiaowuchu";
			}
			else{
				return "error";
			}    
		}
	}
	
	
	public String userLogout(){
		try {
			Map session = ActionContext.getContext().getSession();
			user =  (TUser)ActionContext.getContext().getSession().get("user");
			userService.changeLoginState(user.getUserId(), "NN");
			session.clear();
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
		
	}
	
	public String returnIndex(){
		try {
			user = getSessionUser();
			if(user == null || user.getUserId() == null
					|| user.getUserId().equals("")){
				toLogin();
			}
			String uType = user.getUserType();
			if ("06".equals(uType)||"07".equals(uType)||"08".equals(uType)){
				announcements = listIndexDeanAnnouncement();
				announcementList = listIndexUnitAnnouncement(user.getUserId());
				commonAnnouncement = listCommonAnnouncement();
				return "student";
			}else if ("02".equals(uType)||"03".equals(uType)||"04".equals(uType)||"05".equals(uType)) {
				expertTeachers = listHistoryExpert(user.getUserId());
				projects = listProjectByTeaCode(user.getUserId());
				return "teacher";
			}
			else if ("01".equals(uType)||"00".equals(uType))
			{
				announcements = listIndexDeanAnnouncement();
				return "jiaowuchu";
			}
			else
				return ERROR;
				
			
		} catch (Exception e) {
			return ERROR;
		}
	}
	
	public String listUser() throws Exception
	{
		try
		{
			this.totalNumber = this.userService.getAllTUserCount();
			
			// 构造分页对象
			pageBean = new PageBean(page,totalNumber,pageCapacity);
			      
			listUsers = this.userService.getAllTUser(pageBean);
			
			totalPage = this.pageBean.getTotalPage(); 
			
			/*System.out.println("getUserId: " + this.getUserId());
			System.out.println("\n getUserType: " + this.getUsertype());
			System.out.println("\n getUser: " + this.getSessionUser().getUserName());*/
			
			return "success";
		}
		catch (Exception e)
		{
			
			System.out.println("list exception: " + e.toString());
			return "listError";
		}
	}
	
	public String queryUser() throws Exception
	{
		try
		{
			this.totalNumber = this.userService.getTUserCountByMutiProperty(userId, userName, userType, userState);
			
			// 构造分页对象
			pageBean = new PageBean(page,totalNumber,pageCapacity);
			      
			listUsers = this.userService.getTUserByMutiProperty(userId, userName, userType, userState, pageBean);
			
			totalPage = this.pageBean.getTotalPage(); 
			
			return "success";
		}
		catch (Exception e)
		{
			
			System.out.println("query exception: " + e.toString());
			e.printStackTrace();
			return "queryError";
		}
	}
	
	public String addUser() throws Exception
	{
		try
		{
			this.userService.addTUser(user);
			
			return "success";
		}
		catch(Exception e)
		{
			System.out.println("add exception: " + e.toString());
			
			return "addError";
		}
	}
	
	
	public String preAddUser() throws Exception
	{
		return "success";
	}
	
	public String viewUser() throws Exception
	{
		try
		{
			user = this.userService.getTUser(id);
			
			return "success";
		}
		catch(Exception e)
		{
			return "viewError";
		}
	}
	
	public String updateUser() throws Exception
	{
		try
		{
			this.userService.updateTUser(user);
			
			return "success";
		}
		catch(Exception e)
		{
			System.out.println("update exception: " + e.toString());
			
			return "updateError";
		}
	}
	
	public String deleteUser() throws Exception
	{
		try
		{
			user = this.userService.getTUser(id);
			user.setIsdeleted("Y");
			this.userService.updateTUser(user);
			
			return "success";
		}
		catch(Exception e)
		{
			return "deleteError";
		}
	}
	public String listDeanRecentAnnouncement() throws Exception {
		try {
			pageBean = new PageBean(1, 5, 5);
			announcements = this.announcementService.getAnnounByType("教务处公告", pageBean);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	//教务处公告
	public List<TAnnouncementModel> listIndexDeanAnnouncement() throws Exception {
		try {
			pageBean = new PageBean(1, 6, 6);
			return this.announcementService.getAnnounByType("教务处公告", pageBean);
			
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	//学院公告
	public List<TAnnouncement> listIndexUnitAnnouncement(String stuCode) throws Exception {
		try {
			pageBean = new PageBean(1, 6, 6);
			return this.announcementService.getTAnnouncementByStuCode(stuCode, pageBean);
			
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	//普通教师及学生公告
	public List<TAnnouncement> listCommonAnnouncement() throws Exception {
		try {
			pageBean = new PageBean(1, 5, 5);
			return this.announcementService.getCommonStuAndTeaAnnoun(pageBean);
			
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}
	}

	
	//获取教师主页的历史专家库（申报）
	public List<TExpertTeacher> listHistoryExpert(String teaCode) throws Exception {
		try {
	        pageBean = new PageBean(1, 4, 4);
			return this.expertTeacherService.getExpertTeachersByTeaCode(teaCode, "01", pageBean);
		} catch (Exception e) {
			throw e;
		}
	}
	
	//获取教师主页中的项目信息
	public List<TProject> listProjectByTeaCode(String teaCode) throws Exception{
		try {
			pageBean = new PageBean(1, 10, 10);
			return this.projectService.getProjectByTeaCode(teaCode, pageBean);
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
	}
	/*****************************************************
	 *  get & set methods
	 * *************************************************/

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	@JSON(serialize=false)
	public TUser getUser() {
		return user;
	}
	
	public void setUser(TUser user) {
		this.user = user;
	}
	@JSON(serialize=false)
	public List<TUser> getListUsers() {
		return listUsers;
	}

	public void setListUsers(List<TUser> listUsers) {
		this.listUsers = listUsers;
	}
	@JSON(serialize=false)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	@JSON(serialize=false)
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
	@JSON(serialize=false)
	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}
	@JSON(serialize=false)
	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	@JSON(serialize=false)
	public int getTotalNumber() {
		return totalNumber;
	}

	public void setTotalNumber(int totalNumber) {
		this.totalNumber = totalNumber;
	}
	@JSON(serialize=false)
	public int getPageCapacity() {
		return pageCapacity;
	}

	public void setPageCapacity(int pageCapacity) {
		this.pageCapacity = pageCapacity;
	}
	@JSON(serialize=false)
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	@JSON(serialize=false)
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	@JSON(serialize=false)
	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}
	@JSON(serialize=false)
	public String getUserState() {
		return userState;
	}

	public void setUserState(String userState) {
		this.userState = userState;
	}
	@JSON(serialize=false)
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@JSON(serialize=false)
	public String getValidateCode() {
		return validateCode;
	}
	public void setValidateCode(String validateCode) {
		this.validateCode = validateCode;
	}
	@JSON(serialize=false)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public List<TAnnouncementModel> getAnnouncements() {
		return announcements;
	}
	public void setAnnouncements(List<TAnnouncementModel> announcements) {
		this.announcements = announcements;
	}
	public void setAnnouncementService(AnnouncementService announcementService) {
		this.announcementService = announcementService;
	}

	public List<TAnnouncement> getAnnouncementList() {
		return announcementList;
	}
	public void setAnnouncementList(List<TAnnouncement> announcementList) {
		this.announcementList = announcementList;
	}


	public List<TAnnouncement> getCommonAnnouncement() {
		return commonAnnouncement;
	}


	public void setCommonAnnouncement(List<TAnnouncement> commonAnnouncement) {
		this.commonAnnouncement = commonAnnouncement;
	}


	public ExpertTeacherService getExpertTeacherService() {
		return expertTeacherService;
	}


	public void setExpertTeacherService(ExpertTeacherService expertTeacherService) {
		this.expertTeacherService = expertTeacherService;
	}


	public UserService getUserService() {
		return userService;
	}


	public AnnouncementService getAnnouncementService() {
		return announcementService;
	}


	public List<TExpertTeacher> getExpertTeachers() {
		return expertTeachers;
	}


	public void setExpertTeachers(List<TExpertTeacher> expertTeachers) {
		this.expertTeachers = expertTeachers;
	}


	public ProjectService getProjectService() {
		return projectService;
	}


	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}


	public List<TProject> getProjects() {
		return projects;
	}


	public void setProjects(List<TProject> projects) {
		this.projects = projects;
	}
	
	public TStudent getStudent() {
		return student;
	}
	public void setStudent(TStudent student) {
		this.student = student;
	}
	public TTeacher getTeacher() {
		return teacher;
	}
	public void setTeacher(TTeacher teacher) {
		this.teacher = teacher;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public Boolean getStatu() {
		return statu;
	}
	public void setStatu(Boolean statu) {
		this.statu = statu;
	}

}
