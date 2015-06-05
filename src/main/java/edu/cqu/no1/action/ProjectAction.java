package edu.cqu.no1.action;

import edu.cqu.no1.datamodel.JieQiYear;
import edu.cqu.no1.domain.TJieqi;
import edu.cqu.no1.domain.TProfession;
import edu.cqu.no1.domain.TProject;
import edu.cqu.no1.domain.TUser;
import edu.cqu.no1.service.DeclarationService;
import edu.cqu.no1.service.ProfessionService;
import edu.cqu.no1.service.ProjectService;
import edu.cqu.no1.util.PageBean;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller

@Namespace("/")
@Scope("prototype")
@ParentPackage("base")
public class ProjectAction extends BaseAction {

    @Resource
    private DeclarationService declarationService;
    @Resource
    private ProfessionService professionService;
    @Resource
    private ProjectService projectService;
    private List<TProject> projectList;
    private TUser tUser;
    private Map<String, List<TJieqi>> qicis = new HashMap<String, List<TJieqi>>();
    private List<BigDecimal> years;
    private List<JieQiYear> jieQiYears;
    private List<TProfession> professions;

    private String jqQici;//得到届期ID
    private String jqYear;
    private String profession;
    private String projectNumber; //项目编号
    private String projectName;   //项目名称
    private String studentNums;   //学号
    private String unitName;
    /**
     * 分页使用的参数
     */
    private int page = 1; // 初始页面
    private PageBean pageBean; // 分页用的bean
    private int totalPage = 1; // 总页面数
    private int totalNumber = 0; // 总数据条数
    private int pageCapacity = 14; // 每页显示条数


    @Action(value = "ListProjectByUnitTeaCode", results = {
            @Result(name = "success", location = "/pages/projectManage/unit_project_list.jsp")
    })
    //根据当前教师所在学院获取学院项目信息
    public String listProjectByUnitTeaCode() throws Exception {
        try {
            tUser = getSessionUser();
            if (null == tUser) {
                toLogin();
            }
            String unitTeaCode = tUser.getUserId();

            this.totalNumber = this.projectService.getProjectByteaCodeCount(unitTeaCode);

            // 构造分页对象
            pageBean = new PageBean(page, totalNumber, pageCapacity);

            projectList = this.projectService.getProjectByTeaCode(unitTeaCode, pageBean);

            totalPage = this.pageBean.getTotalPage();

            getJieQiAndPro(unitTeaCode);

            return "success";
        } catch (Exception e) {

            System.out.println("query exception: " + e.toString());
            e.printStackTrace();
            return ERROR;
        }
    }

    @Action(value = "FindUnitProject", results = {
            @Result(name = "success", location = "/pages/projectManage/unit_project_list.jsp")
    })
    //多条件查询学院项目信息
    public String findUnitProject() throws Exception {
        try {
            //学院主管老师的教职工号
            tUser = getSessionUser();
            if (tUser == null || tUser.getUserId() == null
                    || tUser.getUserId().equals("")) {
                toLogin();
            }
            String teacherCodes = tUser.getUserId();
            this.totalNumber = this.projectService.findProjectByTeaCodeCount(teacherCodes, jqYear, jqQici, profession, studentNums, projectNumber, projectName);
            pageBean = new PageBean(page, totalNumber, pageCapacity);
            projectList = this.projectService.findProjectByTeaCode(teacherCodes, jqYear, jqQici, profession, studentNums, projectNumber, projectName, pageBean);
            totalPage = pageBean.getTotalPage();
            getJieQiAndPro(teacherCodes);
            return SUCCESS;
        } catch (Exception e) {
            //throw e;
            return ERROR;
        }
    }


    @Action(value = "ListSchoolProject", results = {
            @Result(name = "success", location = "/pages/projectManage/school_project_list.jsp")
    })
    //获取教务处项目列表
    public String listSchoolProject() throws Exception {
        try {
            tUser = getSessionUser();
            if (tUser == null || tUser.getUserId() == null
                    || tUser.getUserId().equals("")) {
                toLogin();
            }
            this.totalNumber = this.projectService.listSchoolProjectCount();
            pageBean = new PageBean(page, totalNumber, pageCapacity);
            projectList = this.projectService.listSchoolProject(pageBean);
            totalPage = pageBean.getTotalPage();
            getJieQiAndPro();
            return "success";

        } catch (Exception e) {
            return ERROR;
        }
    }


    @Action(value = "FindSchoolProject", results = {
            @Result(name = "success", location = "/pages/projectManage/school_project_list.jsp")
    })
    //多条件查询教务处项目列表
    public String findSchoolProject() throws Exception {
        try {
            tUser = getSessionUser();
            if (tUser == null || tUser.getUserId() == null
                    || tUser.getUserId().equals("")) {
                toLogin();
            }
            this.totalNumber = this.projectService.findSchoolProjectCount(jqYear, jqQici, unitName, studentNums, projectName);
            pageBean = new PageBean(page, totalNumber, pageCapacity);
            projectList = this.projectService.findSchoolProject(jqYear, jqQici, unitName, studentNums, projectName, pageBean);
            totalPage = pageBean.getTotalPage();
            getJieQiAndPro();
            return "success";

        } catch (Exception e) {
            return ERROR;
        }
    }


    @Action(value = "ListStuPersonalProject", results = {
            @Result(name = "success", location = "/pages/projectManage/stuPersonal_project_list.jsp")
    })
    //获取学生个人项目列表
    public String listStuPersonalProject() throws Exception {
        try {
            tUser = getSessionUser();
            if (tUser == null || tUser.getUserId() == null
                    || tUser.getUserId().equals("")) {
                toLogin();
            }
            String stuCode = tUser.getUserId();
            projectList = this.projectService.getStuProject(stuCode);
            return "success";
        } catch (Exception e) {
            return ERROR;
        }
    }

    @Action(value = "ListTeaPersonalProject", results = {
            @Result(name = "success", location = "/pages/projectManage/teaPersonal_project_list.jsp")
    })
    //获取教师个人项目列表
    public String listTeaPersonalProject() throws Exception {
        try {
            tUser = getSessionUser();
            if (tUser == null || tUser.getUserId() == null
                    || tUser.getUserId().equals("")) {
                toLogin();
            }
            String teaCode = tUser.getUserId();
            this.totalNumber = this.projectService.getTeaProjectCount(teaCode);
            pageBean = new PageBean(page, totalNumber, pageCapacity);
            projectList = this.projectService.getTeaProject(teaCode, pageBean);
            totalPage = pageBean.getTotalPage();
            return "success";
        } catch (Exception e) {
            return ERROR;
        }
    }


    @Action(value = "FindTeaPersonalProject", results = {
            @Result(name = "success", location = "/pages/projectManage/teaPersonal_project_list.jsp")
    })
    //多条件查询教师个人项目列表
    public String findTeaPersonalProject() throws Exception {
        try {
            tUser = getSessionUser();
            if (tUser == null || tUser.getUserId() == null
                    || tUser.getUserId().equals("")) {
                toLogin();
            }
            String teaCode = tUser.getUserId();
            this.totalNumber = this.projectService.findTeaProjectCount(teaCode, projectName, studentNums);
            pageBean = new PageBean(page, totalNumber, pageCapacity);
            projectList = this.projectService.findTeaProject(teaCode, projectName, studentNums, pageBean);
            totalPage = pageBean.getTotalPage();
            return "success";
        } catch (Exception e) {
            return ERROR;
        }
    }

    private void getJieQiAndPro(String teaCode) {
        years = this.declarationService.findAllYears();
        //获取专业列表
        professions = this.professionService.findTProfessionsByTeaCode(teaCode);
        jieQiYears = new ArrayList<JieQiYear>();
        //年份list 添加一个"所有",对应的key为"ALL"
        jieQiYears.add(new JieQiYear("", "所有"));
        TJieqi tJieqi = new TJieqi();
        tJieqi.setJqId("");
        tJieqi.setQici("所有");
        List<TJieqi> list = new ArrayList<TJieqi>();
        list.add(tJieqi);
        qicis.put("", list);
        for (BigDecimal year : years) {
            jieQiYears.add(new JieQiYear(year.toString(), year.toString()));
            list = this.declarationService.findJieqiByYear(year.toString());
            List<TJieqi> tmpJieqis = new ArrayList<TJieqi>();
            //期次list 添加一个"所有",对应的key为"ALL"
            tmpJieqis.add(tJieqi);
            for (TJieqi t : list) {
                tmpJieqis.add(t);
            }
            qicis.put(year.toString(), tmpJieqis);
        }
    }

    private void getJieQiAndPro() {
        years = this.declarationService.findAllYears();
        jieQiYears = new ArrayList<JieQiYear>();
        //年份list 添加一个"所有",对应的key为"ALL"
        jieQiYears.add(new JieQiYear("", "所有"));
        TJieqi tJieqi = new TJieqi();
        tJieqi.setJqId("");
        tJieqi.setQici("所有");
        List<TJieqi> list = new ArrayList<TJieqi>();
        list.add(tJieqi);
        qicis.put("", list);
        for (BigDecimal year : years) {
            jieQiYears.add(new JieQiYear(year.toString(), year.toString()));
            list = this.declarationService.findJieqiByYear(year.toString());
            List<TJieqi> tmpJieqis = new ArrayList<TJieqi>();
            //期次list 添加一个"所有",对应的key为"ALL"
            tmpJieqis.add(tJieqi);
            for (TJieqi t : list) {
                tmpJieqis.add(t);
            }
            qicis.put(year.toString(), tmpJieqis);
        }
    }

    /*
     * get and set method
     */
    public ProjectService getProjectService() {
        return projectService;
    }


    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }


    public List<TProject> getProjectList() {
        return projectList;
    }


    public void setProjectList(List<TProject> projectList) {
        this.projectList = projectList;
    }


    public TUser gettUser() {
        return tUser;
    }


    public void settUser(TUser tUser) {
        this.tUser = tUser;
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

    public DeclarationService getDeclarationService() {
        return declarationService;
    }

    public void setDeclarationService(DeclarationService declarationService) {
        this.declarationService = declarationService;
    }

    public ProfessionService getProfessionService() {
        return professionService;
    }

    public void setProfessionService(ProfessionService professionService) {
        this.professionService = professionService;
    }

    public Map<String, List<TJieqi>> getQicis() {
        return qicis;
    }

    public void setQicis(Map<String, List<TJieqi>> qicis) {
        this.qicis = qicis;
    }

    public List<BigDecimal> getYears() {
        return years;
    }

    public void setYears(List<BigDecimal> years) {
        this.years = years;
    }

    public List<JieQiYear> getJieQiYears() {
        return jieQiYears;
    }

    public void setJieQiYears(List<JieQiYear> jieQiYears) {
        this.jieQiYears = jieQiYears;
    }

    public List<TProfession> getProfessions() {
        return professions;
    }

    public void setProfessions(List<TProfession> professions) {
        this.professions = professions;
    }

    public String getJqQici() {
        return jqQici;
    }

    public void setJqQici(String jqQici) {
        this.jqQici = jqQici;
    }

    public String getJqYear() {
        return jqYear;
    }

    public void setJqYear(String jqYear) {
        this.jqYear = jqYear;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getProjectNumber() {
        return projectNumber;
    }

    public void setProjectNumber(String projectNumber) {
        this.projectNumber = projectNumber;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getStudentNums() {
        return studentNums;
    }

    public void setStudentNums(String studentNums) {
        this.studentNums = studentNums;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }


}
