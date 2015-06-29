package edu.cqu.no1.action;

import edu.cqu.no1.domain.TAnnouncement;
import edu.cqu.no1.domain.TAnnouncementModel;
import edu.cqu.no1.domain.TAttachment;
import edu.cqu.no1.domain.TAnnounType;
import edu.cqu.no1.domain.TUser;
import edu.cqu.no1.service.AnnouncementService;
import edu.cqu.no1.service.RoleService;
import edu.cqu.no1.util.FileUtility;
import edu.cqu.no1.util.PageBean;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.io.File;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Controller

@Namespace("/")
@Scope("prototype")
@ParentPackage("base")
public class AnnouncementAction extends BaseAction {

    @Resource
	private AnnouncementService announcementService;
    @Resource
	private RoleService roleService;


	private TAnnouncement announcement;
	private List<TAnnouncementModel> listAnnouncementModels;
	private TAnnouncementModel announcementModel;
	private List<TAttachment> attachments;
	private String attachementId;
	
	private TUser tUser;
	private String number;// 学生学号，指导老师教职工号，教务处主管老师教职工号
	private String announId;
	private String announTitle;
	private String announContent;
	private String publishState;
	private Date publishTime;
	private TAnnounType TAnnounType;

	private String checkerCode;
	private Date checkTime;
	private String checkState;
	
	private String publisherName;
	private String announTypeName;
	private List<TAnnouncement> listAnnouncements;


	/**
	 * 分页使用的参数
	 */
	private int page = 1; // 初始页面
	private PageBean pageBean; // 分页用的bean
	private int totalPage = 1; // 总页面数
	private int totalNumber = 0; // 总数据条数
	private int pageCapacity = 14; // 每页显示条数

	// 上传文件 数组
	private File[] files;
	private String[] filesContentType;
	private String[] filesFileName;




	@Action(value = "ListStuTeaAnnoun", results = {
            @Result(name = "success", location = "/pages/announManage/person_announ_list.jsp")
    } )
	public String listStuTeaAnnouncement() throws Exception {

		try {
		    //获取当前用户的id
		    tUser = getSessionUser();
		    if(null==tUser)
		    {
		    	toLogin();
		    }
			number = tUser.getUserId();
			
			this.totalNumber = this.announcementService
					.getStuTeaAnnouncementCount(number);
			pageBean = new PageBean(page, totalNumber, pageCapacity);
			listAnnouncementModels = this.announcementService
					.listStuTeaAnnouncements(number, pageBean);
			totalPage = pageBean.getTotalPage();
			return SUCCESS;
		} catch (Exception e) {
			System.out.println("list student announcements exception:" + e);
			throw e;
		}
	}

    @Action(value = "ListUnitAnnouncement", results = {
            @Result(name = "success", location = "/pages/announManage/unit_announ_list.jsp")
    } )
	public String listUnitAnnouncement() throws Exception {
		try {
			
			 //获取当前用户(学院主管老师)的id
			tUser = getSessionUser();
			if(null==tUser)
		    {
		    	toLogin();
		    }
			number = tUser.getUserId();
			this.totalNumber = this.announcementService.getUnitAnnouncementCount(number);
			pageBean = new PageBean(page, totalNumber, pageCapacity);
			listAnnouncementModels = this.announcementService.listUnitAnnouncements(number, pageBean);
			totalPage = pageBean.getTotalPage();
			return SUCCESS;
		} catch (Exception e) {
			System.out.println("list unit announcements exception:" + e);
			throw e;
		}
	}

    @Action(value = "ListSchoolAnnouncement", results = {
            @Result(name = "success", location = "/pages/announManage/schoolTea_announ_list.jsp")
    } )
	public String listSchoolAnnouncement() throws Exception {
		try {
			this.totalNumber = this.announcementService.getSchoolAnnouncementCount();
			pageBean = new PageBean(page, totalNumber, pageCapacity);
			listAnnouncementModels = this.announcementService.listSchoolAnnouncements(pageBean);
			totalPage = pageBean.getTotalPage();
			return SUCCESS;
			
		} catch (Exception e) {
			System.out.println("list school announcements exception:" + e);
			throw e;
		}
	}

    @Action(value = "ListSchoolLeaderAnnouncement", results = {
            @Result(name = "success", location = "/pages/announManage/schoolLeader_announ_list.jsp")
    } )
	public String listSchoolLeaderAnnouncement() throws Exception {
		try {
			this.totalNumber = this.announcementService.getAnnounByTypeCount("教务处公告");
			pageBean = new PageBean(page, totalNumber, pageCapacity);
			listAnnouncementModels = this.announcementService.getAnnounByType("教务处公告", pageBean);
			totalPage = pageBean.getTotalPage();
		
				return SUCCESS;

			
		} catch (Exception e) {
			System.out.println("list school announcements exception:" + e);
			throw e;
		}
	}


    @Action(value = "QueryStuTeaAnnoun", results = {
            @Result(name = "success", location = "/pages/announManage/person_announ_list.jsp")
    } )
	public String queryStuTeaAnnoun() throws Exception {
		try {
			//System.out.println("jdjdjdj");
			tUser = getSessionUser();
			if(null==tUser)
		    {
		    	toLogin();
		    }
			number = tUser.getUserId();
			/*
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
			String timeString = sdf1.format(publishTime);
			System.out.println(timeString);
			Date timeDate = sdf1.parse(timeString);
			System.out.println(timeDate);
			publishTime = timeDate;*/
			
			this.totalNumber = this.announcementService.queryStuTeaAnnounCount(
					number, announTitle, publishTime);
			pageBean = new PageBean(page, totalNumber, pageCapacity);
			listAnnouncementModels = this.announcementService
					.queryStuTeaAnnoun(number, announTitle, publishTime,
							pageBean);
			totalPage = pageBean.getTotalPage();
			return SUCCESS;
		} catch (Exception e) {
			System.out.println("query StuTea Announcement exception: " + e);
			throw e;
		}
	}

    @Action(value = "QueryUnitAnnoun", results = {
            @Result(name = "success", location = "/pages/announManage/unit_announ_list.jsp")
    } )
	public String queryUnitAnnoun() throws Exception {
		try {
			tUser = getSessionUser();
			number= tUser.getUserId();

			this.totalNumber = this.announcementService.queryUnitAnnounCount(
					number, announTitle, publishTime);
			pageBean = new PageBean(page, totalNumber, pageCapacity);
			listAnnouncementModels = this.announcementService.queryUnitAnnoun(
					number, announTitle, publishTime, pageBean);
			totalPage = pageBean.getTotalPage();
			return SUCCESS;
		} catch (Exception e) {
			System.out.println("query Unit Announcement exception: " + e);
			throw e;
		}
	}


    @Action(value = "QuerySchoolAnnoun", results = {
            @Result(name = "successTea", location = "/pages/announManage/schoolTea_announ_list.jsp"),
            @Result(name = "successLeader", type = "redirect", location = "/pages/announManage/schoolLeader_announ_list.jsp")
    } )
	public String querySchoolAnnoun() throws Exception {
		try {
	//		System.out.println("123-->"+announTypeName);
			this.totalNumber = this.announcementService.querySchoolAnnounCount(announTitle, checkState, publishTime, publisherName, announTypeName);
			pageBean = new PageBean(page, totalNumber, pageCapacity);
			listAnnouncementModels = this.announcementService.querySchoolAnnoun(announTitle, checkState, publishTime, publisherName,announTypeName, pageBean);
			totalPage = pageBean.getTotalPage();
			
			return "successTea";
			
		} catch (Exception e) {
			System.out.println("query StuTea Announcement exception: " + e);
			throw e;
		}
	}


    @Action(value = "QuerySchoolLeaderAnnoun", results = {
            @Result(name = "success", location = "/pages/announManage/schoolLeader_announ_list.jsp")
    } )
	public String querySchoolLeaderAnnoun() throws Exception {
		try {
			
			announTypeName = "教务处公告";
			
			this.totalNumber = this.announcementService.querySchoolAnnounCount(
					announTitle, checkState, publishTime, publisherName, announTypeName);
			pageBean = new PageBean(page, totalNumber, pageCapacity);
			listAnnouncementModels = this.announcementService
					.querySchoolAnnoun(announTitle, checkState, publishTime, publisherName,
							announTypeName, pageBean);
			totalPage = pageBean.getTotalPage();
			
			return SUCCESS;
			
		} catch (Exception e) {
			System.out.println("query StuTea Announcement exception: " + e);
			throw e;
		}
	}


	/**
	 *TODO 根据公告类别查询公告
	 */
	public String getAnnounByTypeName() throws Exception {
		try {
			this.totalNumber = this.announcementService
					.getAnnounByTypeCount(announTypeName);
			pageBean = new PageBean(page, totalNumber, pageCapacity);
			listAnnouncementModels = this.announcementService.getAnnounByType(
					announTypeName, pageBean);
			totalPage = pageBean.getTotalPage();
			return SUCCESS;
		} catch (Exception e) {
			System.out.println("query StuTea Announcement exception: " + e);
			throw e;
		}

	}

	private TAnnouncement saveFilesAndAnnouncement(TAnnouncement announcement)throws Exception{
    	TUser user = getSessionUser();
		if (user == null || user.getUserId() == null
				|| user.getUserId().equals("")) {
			toLogin();
		}
		if (files != null && filesFileName != null && filesContentType != null
				&& files.length == filesFileName.length
				&& filesFileName.length == filesContentType.length && files.length > 0) {
			List<String> fileUris = FileUtility.SaveFiles(files, filesFileName,
                    filesContentType);
			if (fileUris != null && fileUris.size() > 0) {
				List<TAttachment> tAttachments = new ArrayList<TAttachment>();
				for (int i=0; i<fileUris.size(); i++) {
					TAttachment tAttachment = new TAttachment();
					tAttachment.setFileName(filesFileName[i]);
					tAttachment.setFileFormat(filesContentType[i]);
					tAttachment.setFileSize(new BigDecimal(files[i].length()));
					tAttachment.setFileUrl(fileUris.get(i));
					tAttachment.setTUser(user);
					tAttachments.add(tAttachment);
				}
				return this.announcementService.addTAnnouncement(tAttachments, announcement);
			}else{
				return null;
			}
		}else{
			return this.announcementService.addTAnnouncement(announcement);
		}
    }



    @Action(value = "SaveAnnouncement", results = {
            @Result(name = "personalSuccess", type = "redirect", location = "ListStuTeaAnnoun"),
            @Result(name = "unitSuccess", type = "redirect", location = "ListUnitAnnouncement"),
            @Result(name = "schoolSuccess", type = "redirect", location = "ListSchoolAnnouncement")
    } )
	// 保存公告
	public String saveAnnouncement() throws Exception {
		try {
			
			if(announcement==null)
			{
				return ERROR;
			}
			
			announcement.setPublishState("N");
			
			tUser = getSessionUser();
			if(null==tUser)
		    {
		    	toLogin();
		    }
			announcement.setPublisherCode(tUser.getUserId());
			String userType = tUser.getUserType();
			announcement.setPublisherRole(userType);
			
			
			if (userType.equals("06") || userType.equals("07") || userType.equals("08")) {
				   TAnnounType tAnnounType = this.announcementService.getTAnnounTypeByName("学生公告");
				   announcement.setTAnnounType(tAnnounType);
				   announcement = saveFilesAndAnnouncement(announcement);
				   
				   return "personalSuccess";
					
				   
			} 
			else if (userType.equals("05") || userType.equals("04")){
				   TAnnounType tAnnounType = this.announcementService.getTAnnounTypeByName("教师公告");
				   announcement.setTAnnounType(tAnnounType);
				   announcement = saveFilesAndAnnouncement(announcement);
				   
				   return "personalSuccess";
					
			}
			else if (userType.equals("03") || userType.equals("02")){
				   TAnnounType tAnnounType = this.announcementService.getTAnnounTypeByName("学院公告");
				   announcement.setTAnnounType(tAnnounType);
				   announcement = saveFilesAndAnnouncement(announcement);
				  
				   return "unitSuccess";
					
			}
			else if (userType.equals("01") || userType.equals("00")){
				   TAnnounType tAnnounType = this.announcementService.getTAnnounTypeByName("教务处公告");
				   announcement.setTAnnounType(tAnnounType);
				   announcement = saveFilesAndAnnouncement(announcement);
				   
				   return "schoolSuccess";
					
			}
			else {
				return ERROR;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

    @Action(value = "CommitAnnouncement", results = {
            @Result(name = "personalSuccess", type = "redirect", location = "ListStuTeaAnnoun"),
            @Result(name = "unitSuccess", type = "redirect", location = "ListUnitAnnouncement"),
            @Result(name = "schoolSuccess", type = "redirect", location = "ListSchoolAnnouncement")
    } )
	// 发布不用审核的公告
	public String commitAnnouncement() throws Exception {
		try {
			
			if(announcement==null)
			{
				return ERROR;
			}
			

			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式

			publishTime = df.parse(df.format(new Date()));// new Date()为获取当前系统时间

			announcement.setPublishTime((Timestamp) publishTime);

			tUser = getSessionUser();
			if(null==tUser)
		    {
		    	toLogin();
		    }
			//String roleName = this.roleService.findRoleNameByUserId(tUser.getUserId());
			announcement.setPublisherCode(tUser.getUserId());
			String userType = tUser.getUserType();
			announcement.setPublisherRole(userType);
			if (userType.equals("06") || userType.equals("07") || userType.equals("08")) {
				   TAnnounType tAnnounType = this.announcementService.getTAnnounTypeByName("学生公告");
				   announcement.setTAnnounType(tAnnounType);
				   announcement.setPublishState("Y");
				   announcement.setCheckState("CY");
				   announcement = saveFilesAndAnnouncement(announcement);
				   
				   return "personalSuccess";
					
				   
			} 
			else if (userType.equals("05") || userType.equals("04")){
				   TAnnounType tAnnounType = this.announcementService.getTAnnounTypeByName("教师公告");
				   announcement.setTAnnounType(tAnnounType);
				   announcement.setPublishState("Y");
				   announcement.setCheckState("CY");
				   announcement = saveFilesAndAnnouncement(announcement);
				   
				   return "personalSuccess";
					
			}
			else if (userType.equals("03") || userType.equals("02")){
				   TAnnounType tAnnounType = this.announcementService.getTAnnounTypeByName("学院公告");
				   announcement.setTAnnounType(tAnnounType);
				   announcement.setPublishState("Y");
				   announcement.setCheckState("CY");
				   announcement = saveFilesAndAnnouncement(announcement);
				  
				   return "unitSuccess";
					
			}
			else if (userType.equals("01") || userType.equals("00")){
				   TAnnounType tAnnounType = this.announcementService.getTAnnounTypeByName("教务处公告");
				   announcement.setTAnnounType(tAnnounType);
				   announcement.setPublishState("Y");
				   announcement.setCheckState("NC");
				   announcement = saveFilesAndAnnouncement(announcement);
				   
				   return "schoolSuccess";
					
			}
			else {
				return ERROR;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

    @Action(value = "CommitCheckingAnnouncement", results = {
            @Result(name = "success", location = "/pages/announManage/announ_commit.jsp")
     } )
	// 发布需审核的公告
	public String commitCheckingAnnouncement() throws Exception {
		try {
			announcement.setPublishState("Y");

			announcement.setCheckState("NC");

			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式

			publishTime = df.parse(df.format(new Date()));// new Date()为获取当前系统时间

			announcement.setPublishTime((Timestamp) publishTime);

			tUser = getSessionUser();
			if(null==tUser)
		    {
		    	toLogin();
		    }
			announcement.setPublisherCode(tUser.getUserId());
			//String roleName = this.roleService.findRoleNameByUserId(tUser.getUserId());
			String userType = tUser.getUserType();
			announcement.setPublisherRole(userType);
			if (userType.equals("06") || userType.equals("07") || userType.equals("08")) {
				   TAnnounType tAnnounType = this.announcementService.getTAnnounTypeByName("学生公告");
				   announcement.setTAnnounType(tAnnounType);
			} 
			else if (userType.equals("05") || userType.equals("04")){
				   TAnnounType tAnnounType = this.announcementService.getTAnnounTypeByName("教师公告");
				   announcement.setTAnnounType(tAnnounType);
			}
			else if (userType.equals("03") || userType.equals("02")){
				   TAnnounType tAnnounType = this.announcementService.getTAnnounTypeByName("学院公告");
				   announcement.setTAnnounType(tAnnounType);
			}
			else if (userType.equals("01") || userType.equals("00")){
				   TAnnounType tAnnounType = this.announcementService.getTAnnounTypeByName("教务处公告");
				   announcement.setTAnnounType(tAnnounType);
			}

			announcement = saveFilesAndAnnouncement(announcement);

			if(announcement == null ){
				return ERROR;
			}else {
				return SUCCESS;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}


    @Action(value = "CommitSavedAnnouncement", results = {
            @Result(name = "personalSuccess", type = "redirect", location = "ListStuTeaAnnoun"),
            @Result(name = "unitSuccess", type = "redirect", location = "ListUnitAnnouncement"),
            @Result(name = "schoolSuccess", type = "redirect", location = "ListSchoolAnnouncement")
    } )
	// 发布已保存的公告
	public String commitSavedAnnouncement() throws Exception {
		try {
			
			announcement = this.announcementService.getAnnouncement(announId);
			
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式

			publishTime = df.parse(df.format(new Date()));// new Date()为获取当前系统时间

			announcement.setPublishTime((Timestamp) publishTime);
			
			announcement.setPublishState("Y");
			
			tUser = getSessionUser();
			if(null==tUser)
		    {
		    	toLogin();
		    }
			
			String userType = tUser.getUserType();
			if (userType.equals("06") || userType.equals("07") || userType.equals("08")) {
				   announcement.setCheckState("CY");
				   this.announcementService.updateTAnnouncement(announcement);
				   return "personalSuccess";
					
				   
			} 
			else if (userType.equals("05") || userType.equals("04")){
				   announcement.setCheckState("CY");
				   this.announcementService.updateTAnnouncement(announcement);
				   return "personalSuccess";
					
			}
			else if (userType.equals("03") || userType.equals("02")){
				   announcement.setCheckState("CY");
				   this.announcementService.updateTAnnouncement(announcement);
				   return "unitSuccess";
					
			}
			else if (userType.equals("01") || userType.equals("00")){
				   announcement.setCheckState("NC");
				   this.announcementService.updateTAnnouncement(announcement);
				   return "schoolSuccess";
					
			}
			else {
				return ERROR;
			}
			
		} catch (Exception e) {
			System.out.println("add exception: " + e.toString());

			return ERROR;
		}
	}


    @Action(value = "CheckAnnouncement", results = {
            @Result(name = "success", location = "/pages/announManage/announ_check.jsp")
    } )
	// 审核公告
	public String checkAnnouncement() throws Exception {
		try {
			announcementModel = this.announcementService.getAnnounById(announId);
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}


    @Action(value = "UnpassedAnnouncement", results = {
            @Result(name = "success", type = "redirect", location = "ListSchoolLeaderAnnouncement")
    } )
	// 审核不通过
	public String unpassedAnnouncement() throws Exception {
		try {
			announcement = this.announcementService.getAnnouncement(announId);
			
			announcement.setCheckState("CN");

            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			
            checkTime = df.parse(df.format(new Date()));// new Date()为获取当前系统时间
            
            tUser = getSessionUser();
            
            announcement.setCheckerCode(tUser.getUserId());
            
            announcement.setCheckTime((Timestamp) checkTime);
			
			this.announcementService.updateTAnnouncement(announcement);

			return SUCCESS;
		} catch (Exception e) {
			System.out.println("update exception: " + e.toString());

			return ERROR;
		}
	}


    @Action(value = "PassedAnnouncement", results = {
            @Result(name = "success", type = "redirect", location = "ListSchoolLeaderAnnouncement")
    } )
	// 审核通过
	public String passedAnnouncement() throws Exception {
		try {
			
			announcement = this.announcementService.getAnnouncement(announId);
			
			announcement.setCheckState("CY");
			
			announcement.setPublishState("Y");

            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			
            checkTime = df.parse(df.format(new Date()));// new Date()为获取当前系统时间
            
            tUser = getSessionUser();
            if(null==tUser)
		    {
		    	toLogin();
		    }
            
            announcement.setCheckerCode(tUser.getUserId());
            
            announcement.setCheckTime((Timestamp) checkTime);
			
			this.announcementService.updateTAnnouncement(announcement);

			return SUCCESS;
		} catch (Exception e) {
			System.out.println("update exception: " + e.toString());

			return ERROR;
		}
	}



    @Action(value = "ViewAnnouncement", results = {
            @Result(name = SUCCESS, location = "/pages/announManage/announ_view.jsp")
     } )
	//查看公告
	public String viewAnnouncement() throws Exception 
	{
		try {
			announcementModel = this.announcementService.getAnnounById(announId);
			attachments = this.announcementService.getAttachmentsByAnnounceId(announId);
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}



    @Action(value = "ViewLoginAnnouncement", results = {
            @Result(name = "success", location = "/pages/announManage/announ_login_view.jsp")
    } )
	//登录页面的查看公告
	public String viewLoginAnnouncement() throws Exception 
	{
		try {
			announcementModel = this.announcementService.getAnnounById(announId);
			attachments = this.announcementService.getAttachmentsByAnnounceId(announId);
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}

    @Action(value = "EditAnnouncement", results = {
            @Result(name = "success", location = "/pages/announManage/announ_edit.jsp")
    } )
	//查看编辑公告
	public String editAnnouncement() throws Exception
	{
		try
		{
			announcement = this.announcementService.getAnnouncement(announId);
			attachments = this.announcementService.getAttachmentsByAnnounceId(announId);
			return SUCCESS;
		}
		catch(Exception e)
		{
			return ERROR;
		}
	}


    @Action(value = "UpdateAnnouncement", results = {
            @Result(name = "successStuTea", type = "redirect", location = "ListStuTeaAnnoun"),
            @Result(name = "successUnit", type = "redirect", location = "ListUnitAnnouncement"),
            @Result(name = "successSchool", type = "redirect", location = "ListSchoolAnnouncement")
    } )
	//保存编辑公告
	public String updateAnnouncement() throws Exception
	{
		try
		{
			//System.out.println("a");
			TUser user = getSessionUser();
			if (user == null || user.getUserId() == null
					|| user.getUserId().equals("")) {
				toLogin();
			}
            announcement = this.announcementService.getAnnouncement(announId);
			announcement.setAnnounContent(announContent);
			announcement.setAnnounTitle(announTitle);
			if (files != null && files.length > 0) {
				if (files != null && filesFileName != null
						&& filesContentType != null
						&& files.length == filesFileName.length
						&& filesFileName.length == filesContentType.length) {
					List<TAttachment> tAttachments = this.announcementService.getAttachmentsByAnnounceId(announId);
					for (TAttachment tAttachment : tAttachments) {
						FileUtility.DeleteFile(tAttachment.getFileUrl());
					}					
					List<String> fileUris = FileUtility.SaveFiles(files,
							filesFileName, filesContentType);
					if (fileUris != null && fileUris.size() > 0) {
						List<TAttachment> newAttachments = new ArrayList<TAttachment>();
						for (int i=0; i<fileUris.size(); i++) {
							TAttachment tAttachment = new TAttachment();
							tAttachment.setFileName(filesFileName[i]);
							tAttachment.setFileFormat(filesContentType[i]);
							tAttachment.setFileSize(new BigDecimal(files[i].length()));
							tAttachment.setFileUrl(fileUris.get(i));
							tAttachment.setTUser(user);
							newAttachments.add(tAttachment);
						}
						this.announcementService.updateTAnnouncement(newAttachments, announcement);
					}
				}
			} else {
				this.announcementService.updateTAnnouncement(announcement);	
			}
			//String a = announcement.getTAnnounType().getAnnounTypeName();
			
			
			String userType = user.getUserType();
			//String roleName = this.roleService.findRoleNameByUserId(tUser.getUserId());
			
			if (userType.equals("02") || userType.equals("03") || userType.equals("04") || userType.equals("05")) {
				return "successUnit";
			}
			else if ( userType.equals("00") || userType.equals("01")) {
				return "successSchool";
			}
			else {
				return "successStuTea";
			}
			
		} catch (Exception e) {
			System.out.println("update exception: " + e.toString());

			return ERROR;
		}
	}


    @Action(value = "DeleteAnnouncement", results = {
            @Result(name = "successStuTea", type = "redirect", location = "ListStuTeaAnnoun"),
            @Result(name = "successUnit", type = "redirect", location = "ListUnitAnnouncement"),
            @Result(name = "successSchool", type = "redirect", location = "ListSchoolAnnouncement")
    } )
	//删除公告
	public String deleteAnnouncement() throws Exception
	{
		try
		{

			announcement = this.announcementService.getAnnouncement(announId);
			
			announcement.setIsdeleted("Y");
			
			//String a = announcement.getTAnnounType().getAnnounTypeName();
			
			this.announcementService.updateTAnnouncement(announcement);
			
			tUser = getSessionUser();
			if(null==tUser)
			{
				toLogin();
			}
			String userType = tUser.getUserType();
			//String roleName = this.roleService.findRoleNameByUserId(tUser.getUserId());
			
			if (userType.equals("02") || userType.equals("03") || userType.equals("04") || userType.equals("05")) {
				return "successUnit";
			}
			else if ( userType.equals("00") || userType.equals("01")) {
				return "successSchool";
			}
			else {
				return "successStuTea";
			}
			
		} catch (Exception e) {
			return ERROR;
		}
	}


    @Action(value = "ListIndexDeanAnnouncement", results = {
            @Result(name = "success", location = "/pages/announManage/indexSchoolAnnounList.jsp")
    } )
	//教务处公告
	public String listIndexDeanAnnouncement() throws Exception {
		try {
			//获取当前用户的id
		    tUser = getSessionUser();
		    if(null==tUser)
		    {
		    	toLogin();
		    }
			this.totalNumber = this.announcementService.getAnnounByTypeCount("教务处公告");
			pageBean = new PageBean(page, totalNumber, pageCapacity);
			listAnnouncementModels = this.announcementService.getAnnounByType("教务处公告", pageBean);
			totalPage = pageBean.getTotalPage();
			return SUCCESS;
			
		} catch (RuntimeException e) {
			e.printStackTrace();
			return ERROR;
		}
	}


    @Action(value = "ListIndexUnitAnnouncement", results = {
            @Result(name = "success", location = "/pages/announManage/indexUnitAnnounList.jsp")
    } )
	//学院公告
	public String listIndexUnitAnnouncement() throws Exception {
		try {
			tUser = getSessionUser();
		    if(null==tUser)
		    {
		    	toLogin();
		    }
		    String stuCode = tUser.getUserId();
			this.totalNumber = this.announcementService.getTAnnouncementByStuCodeCount(stuCode);
			pageBean = new PageBean(page, totalNumber, pageCapacity);
			listAnnouncements = this.announcementService.getTAnnouncementByStuCode(stuCode, pageBean);
			totalPage = pageBean.getTotalPage();
			return SUCCESS;
			
		} catch (RuntimeException e) {
			e.printStackTrace();
			return ERROR;
		}
	}


    @Action(value = "ListCommonAnnouncement", results = {
            @Result(name = "success", location = "/pages/announManage/indexCommonAnnounList.jsp")
    } )
	//普通教师及学生公告
	public String listCommonAnnouncement() throws Exception {
		try {
			tUser = getSessionUser();
		    if(null==tUser)
		    {
		    	toLogin();
		    }
			this.totalNumber = this.announcementService.getCommonStuAndTeaAnnounCount();
			pageBean = new PageBean(page, totalNumber, pageCapacity);
			listAnnouncements = this.announcementService.getCommonStuAndTeaAnnoun(pageBean);
			totalPage = pageBean.getTotalPage();
			return SUCCESS;
			
		} catch (RuntimeException e) {
			e.printStackTrace();
			return ERROR;
		}
	}


    @Action(value = "FindIndexDeanAnnouncement", results = {
            @Result(name = "success", location = "/pages/announManage/indexSchoolAnnounList.jsp")
    } )
	//查询教务处公告
	public String findIndexDeanAnnouncement() throws Exception {
		try {
			//获取当前用户的id
		    tUser = getSessionUser();
		    if(null==tUser)
		    {
		    	toLogin();
		    }
			this.totalNumber = this.announcementService.findIndexSchoolAnnoumentCount(announTitle, publishTime, "教务处公告");
			pageBean = new PageBean(page, totalNumber, pageCapacity);
			listAnnouncementModels = this.announcementService.findIndexSchoolAnnoument(announTitle, publishTime, "教务处公告", pageBean);
			totalPage = pageBean.getTotalPage();
			return SUCCESS;
			
		} catch (RuntimeException e) {
			e.printStackTrace();
			return ERROR;
		}
	}


    @Action(value = "FindIndexUnitAnnouncement", results = {
            @Result(name = "success", location = "/pages/announManage/indexUnitAnnounList.jsp")
    } )
	//查询学院公告
	public String findIndexUnitAnnouncement() throws Exception {
		try {
			tUser = getSessionUser();
		    if(null==tUser)
		    {
		    	toLogin();
		    }
		    String stuCode = tUser.getUserId();
			this.totalNumber = this.announcementService.findTAnnouncementByStuCodeCount(stuCode, announTitle, publishTime);
			pageBean = new PageBean(page, totalNumber, pageCapacity);
			listAnnouncements = this.announcementService.findTAnnouncementByStuCode(stuCode, announTitle, publishTime, pageBean);
			totalPage = pageBean.getTotalPage();
			return SUCCESS;
			
		} catch (RuntimeException e) {
			e.printStackTrace();
			return ERROR;
		}
	}



    @Action(value = "FindCommonAnnouncement", results = {
            @Result(name = "success", location = "/pages/announManage/indexCommonAnnounList.jsp")
    } )
	//查询普通教师及学生公告
	public String findCommonAnnouncement() throws Exception {
		try {
			tUser = getSessionUser();
		    if(null==tUser)
		    {
		    	toLogin();
		    }
			this.totalNumber = this.announcementService.findCommonStuAndTeaAnnounCount(announTitle, announContent, publishTime);
			pageBean = new PageBean(page, totalNumber, pageCapacity);
			listAnnouncements = this.announcementService.findCommonStuAndTeaAnnoun(announTitle, announContent, publishTime, pageBean);
			totalPage = pageBean.getTotalPage();
			return SUCCESS;
			
		} catch (RuntimeException e) {
			e.printStackTrace();
			return ERROR;
		}
	}


	public String getAnnounId() {
		return announId;
	}

	public List<TAnnouncementModel> getListAnnouncementModels() {
		return listAnnouncementModels;
	}

	public void setListAnnouncementModels(
			List<TAnnouncementModel> listAnnouncementModels) {
		this.listAnnouncementModels = listAnnouncementModels;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalNumber() {
		return totalNumber;
	}

	public void setTotalNumber(int totalNumber) {
		this.totalNumber = totalNumber;
	}

	public int getPageCapacity() {
		return pageCapacity;
	}

	public void setPageCapacity(int pageCapacity) {
		this.pageCapacity = pageCapacity;
	}

	public void setAnnounId(String announId) {
		this.announId = announId;
	}

	public AnnouncementService getAnnouncementService() {
		return announcementService;
	}

	public void setAnnouncementService(AnnouncementService announcementService) {
		this.announcementService = announcementService;
	}

	public TAnnouncement getAnnouncement() {
		return announcement;
	}

	public void setAnnouncement(TAnnouncement announcement) {
		this.announcement = announcement;
	}

	public String getAnnounTitle() {
		return announTitle;
	}

	public void setAnnounTitle(String announTitle) {
		this.announTitle = announTitle;
	}

	public String getAnnounContent() {
		return announContent;
	}

	public void setAnnounContent(String announContent) {
		this.announContent = announContent;
	}

	public String getPublishState() {
		return publishState;
	}

	public void setPublishState(String publishState) {
		this.publishState = publishState;
	}

	public Date getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}


	public String getCheckerCode() {
		return checkerCode;
	}

	public void setCheckerCode(String checkerCode) {
		this.checkerCode = checkerCode;
	}

	public Date getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}

	public String getCheckState() {
		return checkState;
	}

	public void setCheckState(String checkState) {
		this.checkState = checkState;
	}
	
	
	


	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	public String getAnnounTypeName() {
		return announTypeName;
	}

	public void setAnnounTypeName(String announTypeName) {
		this.announTypeName = announTypeName;
	}

	public List<TAnnouncement> getListAnnouncements() {
		return listAnnouncements;
	}

	public void setListAnnouncements(List<TAnnouncement> listAnnouncements) {
		this.listAnnouncements = listAnnouncements;
	}

	public TAnnouncementModel getAnnouncementModel() {
		return announcementModel;
	}

	public void setAnnouncementModel(TAnnouncementModel announcementModel) {
		this.announcementModel = announcementModel;
	}

	public TAnnounType getTAnnounType() {
		return TAnnounType;
	}

	public void setTAnnounType(TAnnounType tAnnounType) {
		TAnnounType = tAnnounType;
	}

	public List<TAttachment> getAttachments() {
		return attachments;
	}

	public void setAttachments(List<TAttachment> attachments) {
		this.attachments = attachments;
	}

	public String getAttachementId() {
		return attachementId;
	}

	public void setAttachementId(String attachementId) {
		this.attachementId = attachementId;
	}

	public File[] getFiles() {
		return files;
	}

	public void setFiles(File[] files) {
		this.files = files;
	}

	public String[] getFilesContentType() {
		return filesContentType;
	}

	public void setFilesContentType(String[] filesContentType) {
		this.filesContentType = filesContentType;
	}

	public String[] getFilesFileName() {
		return filesFileName;
	}

	public void setFilesFileName(String[] filesFileName) {
		this.filesFileName = filesFileName;
	}

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public TUser gettUser() {
		return tUser;
	}

	public void settUser(TUser tUser) {
		this.tUser = tUser;
	}
	
	
}
