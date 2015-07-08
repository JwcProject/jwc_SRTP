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
import org.apache.struts2.interceptor.SessionAware;
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
public class UserAction extends BaseAction implements SessionAware {
    private static final long serialVersionUID = -8331089822539279241L;

    public static final String NO_THIS_USER = "noThisUser";
    public static final String PASSWORD_WORRY = "passwordWorry";
    public static final String REDUNDANCY_USER = "redundancyUser";
    public static final String REDUNDANCY_EMAIL = "redundancyEmail";
    public static final String DATABASE_ERROR = "databaseError";
    public static final String EMAIL_WORRY = "emailWorry";


    @Resource
    private UserService userService;

    private TUser user;
    private List<TUser> listUsers;
    private String id;

    private String userId;
    private String userName;
    private String userRole;
    private String userState;
    private String validateCode;
    private String password;
    private String email;
    /**
     * 分页使用的参数
     */
    private int page = 1; // 初始页面
    private PageBean pageBean; // 分页用的bean
    private int totalPage = 1; // 总页面数
    private int totalNumber = 0; // 总数据条数
    private int pageCapacity = 14; // 每页显示条数


    private List<TAnnouncement> deanAnnounList;
    private List<TAnnouncement> unitAnnounList;
    private List<TAnnouncement> commonAnnounList;
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

    private String result;

    private Map<String, Object> session = null;

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    @Action(value = "login", results = {
            @Result(name = SUCCESS, type = "json")
    })
    public String login() {
        result = ERROR;
        switch (userService.checkUser(userName, password)) {
            case UserService.SUCCESS:
                TUser user = userService.getUser();
                session.put("user", user);
                session.put("role", userService.getUserRole(user));
                session.put("authorities"
                        , userService.getUserAuthorities(user));
                result = SUCCESS;
                break;
            case UserService.NO_THIS_USER:
                result = NO_THIS_USER;
                break;
            case UserService.PASSWORD_WORRY:
                result = PASSWORD_WORRY;
                break;
            case UserService.REDUNDANCY_USER:
            case UserService.REDUNDANCY_EMAIL:
            case UserService.DATABASE_ERROR:
                result = DATABASE_ERROR;
                break;
            default:
                result = ERROR;
        }
        return SUCCESS;
    }

    @Action(value = "register", results = {
            @Result(name = SUCCESS, type = "json", params = {"includeProperties", "result"})
    })
    public String register() {
        TUser user = new TUser();
        user.setPassword(password);
        user.setUsername(userName);
        user.setEmail(email);
        result = ERROR;
        switch (userService.registerUser(user)) {
            case UserService.SUCCESS:
                session.put("user", user);
                session.put("role", userService.getUserRole(user));
                session.put("authorities"
                        , userService.getUserAuthorities(user));
                result = SUCCESS;
            case UserService.REDUNDANCY_USER:
                result = REDUNDANCY_USER;
            case UserService.REDUNDANCY_EMAIL:
                result = REDUNDANCY_EMAIL;
        }
        return SUCCESS;
    }

    @Action(value = "logout")
    public String logout() {
        session.remove("user");
        session.remove("role");
        session.remove("authorities");
        return LOGIN;
    }

    @Action(value = "resetPassword", results = {
            @Result(name = SUCCESS, type = "json", params = {"includeProperties", "result"})
    })
    public String resetPassword() {
        result = ERROR;

        switch (userService.resetPassword(userName, email)) {
            case UserService.SUCCESS:
                result = SUCCESS;
                break;
            case UserService.NO_THIS_USER:
                result = NO_THIS_USER;
                break;
            case UserService.EMAIL_WORRY:
                result = EMAIL_WORRY;
                break;
            case UserService.REDUNDANCY_USER:
                result = REDUNDANCY_USER;
                break;
        }
        return SUCCESS;
    }

    @Action(value = "modify", results = {
            @Result(name = SUCCESS, type = "json", params = {"includeProperties", "result"})
    })
    public String modify() {
        if (session.get("user") == null) {
            return LOGIN;
        }
        userService.checkUser(((TUser) session.get("user")).getUsername(), password);
        return SUCCESS;
    }


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

        /*String sessionVaCode = (String) request.getSession().getAttribute("validateCode");
        if (!sessionVaCode.equals(validateCode)) {
            request.setAttribute("msg", "验证码错误！");
            return "login";
        }
        String md5Pwd = MD5Util.MD5(password);*/

        String md5Pwd = password;
        user = userService.userLogin(userId, md5Pwd);
        if (user == null || user.getUserId() == null
                || user.getUserId().equals("")) {
            request.setAttribute("msg", "用户名或密码错误！");
            return "login";
        }
        session.put("user", user);
        userService.changeLoginState(user.getUserId(), "YY");
        request.setAttribute("msg", "登录成功!");
        String userType = user.getUserType();
        TUnit unit = userService.getUnitByUserId(user.getUserId(), userType);
        session.put("unit", unit);

        if ("06".equals(userType) || "07".equals(userType) || "08".equals(userType)) {
            deanAnnounList = listIndexDeanAnnouncement();
            unitAnnounList = listIndexUnitAnnouncement(user.getUserId());
            commonAnnounList = listCommonAnnouncement();
            return "student";
        } else if ("02".equals(userType) || "03".equals(userType) || "04".equals(userType) || "05".equals(userType)) {
            expertTeachers = listHistoryExpert(user.getUserId());
            projects = listProjectByTeaCode(user.getUserId());
            return "teacher";
        } else if ("01".equals(userType) || "00".equals(userType)) {
            deanAnnounList = listIndexDeanAnnouncement();
            return "jiaowuchu";
        } else {
            return ERROR;
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
            if (user == null) {
                toLogin();
            }
            String uRole = user.getUserType();
            if ("06".equals(uRole) || "07".equals(uRole) || "08".equals(uRole)) {
                deanAnnounList = listIndexDeanAnnouncement();
                unitAnnounList = listIndexUnitAnnouncement(user.getUserId());
                commonAnnounList = listCommonAnnouncement();
                return "student";
            } else if ("02".equals(uRole) || "03".equals(uRole) || "04".equals(uRole) || "05".equals(uRole)) {
                expertTeachers = listHistoryExpert(user.getUserId());
                projects = listProjectByTeaCode(user.getUserId());
                return "teacher";
            } else if ("01".equals(uRole) || "00".equals(uRole)) {
                deanAnnounList = listIndexDeanAnnouncement();
                return "jiaowuchu";
            } else {
                return ERROR;
            }


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
            this.totalNumber = this.userService.getTUserCountByMutiProperty(userId, userName, userRole, userState);

            // 构造分页对象
            pageBean = new PageBean(page, totalNumber, pageCapacity);

            listUsers = this.userService.getTUserByMutiProperty(userId, userName, userRole, userState, pageBean);

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
            deanAnnounList = this.announcementService.getAnnounByType("教务处公告", pageBean);
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    //教务处公告
    public List<TAnnouncement> listIndexDeanAnnouncement() throws Exception {
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

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public TUser getUser() {
        return user;
    }

    public void setUser(TUser user) {
        this.user = user;
    }

    public List<TUser> getListUsers() {
        return listUsers;
    }

    public void setListUsers(List<TUser> listUsers) {
        this.listUsers = listUsers;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserType() {
        return userRole;
    }

    public void setUserType(String userRole) {
        this.userRole = userRole;
    }

    public String getUserState() {
        return userState;
    }

    public void setUserState(String userState) {
        this.userState = userState;
    }

    public String getValidateCode() {
        return validateCode;
    }

    public void setValidateCode(String validateCode) {
        this.validateCode = validateCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public List<TAnnouncement> getDeanAnnounList() {
        return deanAnnounList;
    }

    public void setDeanAnnounList(List<TAnnouncement> deanAnnounList) {
        this.deanAnnounList = deanAnnounList;
    }

    public List<TAnnouncement> getUnitAnnounList() {
        return unitAnnounList;
    }

    public void setUnitAnnounList(List<TAnnouncement> unitAnnounList) {
        this.unitAnnounList = unitAnnounList;
    }

    public List<TAnnouncement> getCommonAnnounList() {
        return commonAnnounList;
    }

    public void setCommonAnnounList(List<TAnnouncement> commonAnnounList) {
        this.commonAnnounList = commonAnnounList;
    }

    public List<TExpertTeacher> getExpertTeachers() {
        return expertTeachers;
    }

    public void setExpertTeachers(List<TExpertTeacher> expertTeachers) {
        this.expertTeachers = expertTeachers;
    }

    public List<TProject> getProjects() {
        return projects;
    }

    public void setProjects(List<TProject> projects) {
        this.projects = projects;
    }

    public AnnouncementService getAnnouncementService() {
        return announcementService;
    }

    public void setAnnouncementService(AnnouncementService announcementService) {
        this.announcementService = announcementService;
    }

    public ExpertTeacherService getExpertTeacherService() {
        return expertTeacherService;
    }

    public void setExpertTeacherService(ExpertTeacherService expertTeacherService) {
        this.expertTeacherService = expertTeacherService;
    }

    public ProjectService getProjectService() {
        return projectService;
    }

    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
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


    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
