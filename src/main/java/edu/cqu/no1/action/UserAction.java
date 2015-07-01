package edu.cqu.no1.action;

import com.opensymphony.xwork2.ActionContext;
import edu.cqu.no1.domain.*;
import edu.cqu.no1.service.AnnouncementService;
import edu.cqu.no1.service.ExpertTeacherService;
import edu.cqu.no1.service.ProjectService;
import edu.cqu.no1.service.UserService;
import edu.cqu.no1.util.MD5Util;
import edu.cqu.no1.util.PageBean;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller

@Namespace("/")
@Scope("prototype")
@ParentPackage("base")
public class UserAction extends BaseAction {
    private static final long serialVersionUID = -8331089822539279241L;

    @Resource
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
     *
     * @return
     */
    private List<TAnnouncementModel> announcements;
    private List<TAnnouncement> announcementList;
    private List<TAnnouncement> commonAnnouncement;
    private List<TExpertTeacher> expertTeachers;
    private List<TProject> projects;

    @Resource
    private AnnouncementService announcementService;
    @Resource
    private ExpertTeacherService expertTeacherService;
    @Resource
    private ProjectService projectService;

    private TStudent student;
    private TTeacher teacher;
    private String newPassword;
    private Boolean statu;


    @Action(value = "changePassword", results = {
            @Result(name = "success", type = "json", location = "statu")
    })
    public String changePassword() {
        String md5Pwd = MD5Util.MD5(password);
        if (userService.userLogin(userId, md5Pwd) == null) {
            statu = false;
        } else {
            String newMd5Pwd = MD5Util.MD5(newPassword);
            this.userService.changePassword(userId, newMd5Pwd);
            statu = true;
        }
        return SUCCESS;
    }


    @Action(value = "findUserInfo", results = {
            @Result(name = "success", location = "/pages/PersonalCenter/password_maintenance.jsp")
    })
    public String findUserInfo() {
        try {
            user = getSessionUser();
            if (user == null || user.getUserId() == null
                    || user.getUserId().equals("")) {
                toLogin();
            } else {
                System.out.println("060708".indexOf(user.getUserType().trim()));
                if ("060708".indexOf(user.getUserType().trim()) >= 0) {
                    student = this.userService.getStudentByUserId(user.getUserId());
                } else {
                    teacher = this.userService.getTeacherByUserId(user.getUserId());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return ERROR;
        }

        return SUCCESS;
    }


    @Action(value = "userLogin", results = {
            @Result(name = "login", location = "/login.jsp"),
            @Result(name = "student", location = "/student_index.jsp"),
            @Result(name = "teacher", location = "/teacher_index.jsp"),
            @Result(name = "jiaowuchu", location = "/dean_index.jsp")
    })
    public String userLogin() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        Map session = ActionContext.getContext().getSession();
        String sessionVaCode = (String) request.getSession().getAttribute("validateCode");
        /*if (!sessionVaCode.equals(validateCode)) {
            request.setAttribute("msg", "验证码错误！");
            return "login";
        }*/
//        String md5Pwd = MD5Util.MD5(password);
        String md5Pwd = password;
        if (userService.userLogin(userId, md5Pwd) == null) {
            request.setAttribute("msg", "用户名或密码错误！");
            return "login";
        } else {
            user = userService.userLogin(userId, md5Pwd);
            session.put("user", user);
            userService.changeLoginState(user.getUserId(), "YY");
            request.setAttribute("msg", "登录成功!");
            String uType = user.getUserType();
            TUnit unit = userService.getUnitByUserId(user.getUserId(), uType);
            session.put("unit", unit);

            if ("06".equals(uType) || "07".equals(uType) || "08".equals(uType)) {
                announcements = listIndexDeanAnnouncement();
                announcementList = listIndexUnitAnnouncement(user.getUserId());
                commonAnnouncement = listCommonAnnouncement();
                return "student";
            } else if ("02".equals(uType) || "03".equals(uType) || "04".equals(uType) || "05".equals(uType)) {
                expertTeachers = listHistoryExpert(user.getUserId());
                projects = listProjectByTeaCode(user.getUserId());
                return "teacher";
            } else if ("01".equals(uType) || "00".equals(uType)) {
                announcements = listIndexDeanAnnouncement();
                return "jiaowuchu";
            } else {
                return ERROR;
            }
        }
    }


    @Action(value = "userLogoutAction", results = {
            @Result(name = "success", location = "/login.jsp"),
            @Result(name = "error", location = "/login.jsp")
    })
    public String userLogout() {
        try {
            Map session = ActionContext.getContext().getSession();
            user = (TUser) ActionContext.getContext().getSession().get("user");
            userService.changeLoginState(user.getUserId(), "NN");
            session.clear();
            return SUCCESS;
        } catch (Exception e) {
            return ERROR;
        }

    }


    @Action(value = "ReturnIndex", results = {
            @Result(name = "student", location = "/student_index.jsp"),
            @Result(name = "teacher", location = "/teacher_index.jsp"),
            @Result(name = "jiaowuchu", location = "/dean_index.jsp")
    })
    public String returnIndex() {
        try {
            user = getSessionUser();
            if (user == null || user.getUserId() == null
                    || user.getUserId().equals("")) {
                toLogin();
            }
            String uType = user.getUserType();
            if ("06".equals(uType) || "07".equals(uType) || "08".equals(uType)) {
                announcements = listIndexDeanAnnouncement();
                announcementList = listIndexUnitAnnouncement(user.getUserId());
                commonAnnouncement = listCommonAnnouncement();
                return "student";
            } else if ("02".equals(uType) || "03".equals(uType) || "04".equals(uType) || "05".equals(uType)) {
                expertTeachers = listHistoryExpert(user.getUserId());
                projects = listProjectByTeaCode(user.getUserId());
                return "teacher";
            } else if ("01".equals(uType) || "00".equals(uType)) {
                announcements = listIndexDeanAnnouncement();
                return "jiaowuchu";
            } else
                return ERROR;


        } catch (Exception e) {
            return ERROR;
        }
    }


    @Action(value = "ListUser", results = {
            @Result(name = "success", location = "/pages/systemManage/userManage/user_list.jsp")
    })
    public String listUser() throws Exception {
        try {
            this.totalNumber = this.userService.getAllTUserCount();

            // 构造分页对象
            pageBean = new PageBean(page, totalNumber, pageCapacity);

            listUsers = this.userService.getAllTUser(pageBean);

            totalPage = this.pageBean.getTotalPage();

			/*System.out.println("getUserId: " + this.getUserId());
            System.out.println("\n getUserType: " + this.getUsertype());
			System.out.println("\n getUser: " + this.getSessionUser().getUserName());*/

            return SUCCESS;
        } catch (Exception e) {

            System.out.println("list exception: " + e.toString());
            return ERROR;
        }
    }


    @Action(value = "QueryUser", results = {
            @Result(name = "success", location = "/pages/systemManage/userManage/user_list.jsp")
    })
    public String queryUser() throws Exception {
        try {
            this.totalNumber = this.userService.getTUserCountByMutiProperty(userId, userName, userType, userState);

            // 构造分页对象
            pageBean = new PageBean(page, totalNumber, pageCapacity);

            listUsers = this.userService.getTUserByMutiProperty(userId, userName, userType, userState, pageBean);

            totalPage = this.pageBean.getTotalPage();

            return SUCCESS;
        } catch (Exception e) {

            System.out.println("query exception: " + e.toString());
            e.printStackTrace();
            return ERROR;
        }
    }


    @Action(value = "AddUser", results = {
            @Result(name = "input", location = "/pages/systemManage/userManage/user_add.jsp"),
            @Result(name = "success", type = "redirect", location = "ListUser")
    })
    public String addUser() throws Exception {
        try {
            this.userService.addTUser(user);

            return SUCCESS;
        } catch (Exception e) {
            System.out.println("add exception: " + e.toString());

            return ERROR;
        }
    }

    @Action(value = "PreAddUser", results = {
            @Result(name = "success", location = "/pages/systemManage/userManage/user_add.jsp")
    })
    public String preAddUser() throws Exception {
        return SUCCESS;
    }


    @Action(value = "ViewUser", results = {
            @Result(name = "success", location = "/pages/systemManage/userManage/user_view.jsp")
    })
    public String viewUser() throws Exception {
        try {
            user = this.userService.getTUser(id);

            return SUCCESS;
        } catch (Exception e) {
            return ERROR;
        }
    }


    @Action(value = "UpdateUser", results = {
            @Result(name = "input", location = "/pages/systemManage/userManage/user_edit.jsp"),
            @Result(name = "success", type = "redirect", location = "ListUser")
    })
    public String updateUser() throws Exception {
        try {
            this.userService.updateTUser(user);

            return SUCCESS;
        } catch (Exception e) {
            System.out.println("update exception: " + e.toString());

            return ERROR;
        }
    }


    @Action(value = "DeleteUser", results = {
            @Result(name = "success", type = "redirect", location = "ListUser")
    })
    public String deleteUser() throws Exception {
        try {
            user = this.userService.getTUser(id);
            user.setIsdeleted("Y");
            this.userService.updateTUser(user);

            return SUCCESS;
        } catch (Exception e) {
            return ERROR;
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
    public List<TProject> listProjectByTeaCode(String teaCode) throws Exception {
        try {
            pageBean = new PageBean(1, 10, 10);
            return this.projectService.getProjectByTeaCode(teaCode, pageBean);
        } catch (Exception e) {
            // TODO: handle exception
            throw e;
        }
    }

    /**
     * **************************************************
     * get & set methods
     * ************************************************
     */

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @JSON(serialize = false)
    public TUser getUser() {
        return user;
    }

    public void setUser(TUser user) {
        this.user = user;
    }

    @JSON(serialize = false)
    public List<TUser> getListUsers() {
        return listUsers;
    }

    public void setListUsers(List<TUser> listUsers) {
        this.listUsers = listUsers;
    }

    @JSON(serialize = false)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @JSON(serialize = false)
    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    @JSON(serialize = false)
    public PageBean getPageBean() {
        return pageBean;
    }

    public void setPageBean(PageBean pageBean) {
        this.pageBean = pageBean;
    }

    @JSON(serialize = false)
    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    @JSON(serialize = false)
    public int getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(int totalNumber) {
        this.totalNumber = totalNumber;
    }

    @JSON(serialize = false)
    public int getPageCapacity() {
        return pageCapacity;
    }

    public void setPageCapacity(int pageCapacity) {
        this.pageCapacity = pageCapacity;
    }

    @JSON(serialize = false)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @JSON(serialize = false)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @JSON(serialize = false)
    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @JSON(serialize = false)
    public String getUserState() {
        return userState;
    }

    public void setUserState(String userState) {
        this.userState = userState;
    }

    @JSON(serialize = false)
    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    @JSON(serialize = false)
    public String getValidateCode() {
        return validateCode;
    }

    public void setValidateCode(String validateCode) {
        this.validateCode = validateCode;
    }

    @JSON(serialize = false)
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
