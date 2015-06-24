package edu.cqu.no1.action;


import edu.cqu.no1.datamodel.EndProject;
import edu.cqu.no1.datamodel.EndProjectProperty;
import edu.cqu.no1.datamodel.ExpertTeacher;
import edu.cqu.no1.datamodel.JieQiYear;
import edu.cqu.no1.domain.*;
import edu.cqu.no1.service.DeclarationService;
import edu.cqu.no1.service.EndProjectService;
import edu.cqu.no1.service.JieQiService;
import edu.cqu.no1.service.ProjectService;
import edu.cqu.no1.util.FileUtility;
import edu.cqu.no1.util.PageBean;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.*;

@Controller

@Namespace("/")
@Scope("prototype")
@ParentPackage("base")
public class EndProjectAction extends BaseAction {

    private static final long serialVersionUID = 1L;

    @Resource
    public ProjectService projectService;
    @Resource
    public JieQiService jieQiService;
    @Resource
    public EndProjectService endProjectService;
    @Resource
    public DeclarationService declarationService;

    public TProject project;
    public TEndProject endProject = new TEndProject();
    public TEndProjectJob endprojectJob = new TEndProjectJob();
    public TEndProjectJob endprojectJob1 = new TEndProjectJob();
    public TEndProjectJob endprojectJob2 = new TEndProjectJob();
    public List<TEndProject> endProjects;
    private String endprojectComment;

    public String endprojectId;
    public String proId;
    public String jieQiId;
    public String studentNumber;// 项目组长的学号
    public String studentNumber1;// 小组1号成员
    public String studentNumber2;// 小组2号成员

    private List<BigDecimal> years;
    private List<JieQiYear> jieQiYears;
    private Map<String, List<TJieqi>> qicis = new HashMap<String, List<TJieqi>>();

    //信息提示
    private String messageInfo;
    // 上传文件 数组
    private File[] files;
    private String[] filesContentType;
    private String[] filesFileName;
    //下载附件
    private List<TAttachment> attachments;

    /**
     * lsp
     */
    private TUser user;
    private EndProjectProperty properties = new EndProjectProperty();
    private List<JieQiYear> allYears = new ArrayList<JieQiYear>();
    private List<TUnit> colleges;
    private List<TProfession> professions;

    private int page = 1; // 初始页面
    private PageBean pageBean; // 分页用的bean
    private int totalPage = 1; // 总页面数
    private int totalNumber = 0; // 总数据条数
    private int rows = 14; // 每页显示条数

    private List<ExpertTeacher> expertTeachers;
    private String teaCode;
    private String ids;
    private String tids;
    private List<EndProject> endProjectForDispatch;
    private Boolean typeIned;
    private String lastScore;

    public String secondReviewResultTypeIn() {
        this.endProjectService.secondReviewResultTypeIn(ids, lastScore);
        return SUCCESS;
    }

    public String preSecReviewResultTypeIn() {
        getYearAndQicis();
        getAllColleges();
        return SUCCESS;
    }

    public String listSecReviewResultEndPro() {
        try {
            if (getSessionUser() == null) {
                toLogin();
            } else {
                totalNumber = this.endProjectService.getEndProjectCountForResultTypeIn(properties, typeIned);
                pageBean = new PageBean(page, totalNumber, rows);
                endProjectForDispatch = this.endProjectService.getEndProjectsForResultTypeIn(properties, typeIned, pageBean);
                totalPage = pageBean.getTotalPage();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
        return SUCCESS;
    }

    public String dispatchExperTeacher() {
        try {
            this.endProjectService.dispatchExperTeacher(ids, tids);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    public String deleteExpertTeacher() {
        try {
            this.endProjectService.deleteExpertTeacher(ids);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    public String addExpertTeacher() {
        try {
//			System.out.println("teaCode: " + teaCode);
            String[] codes = teaCode.split(",");
            for (int i = 0; i < codes.length; ++i) {
                this.endProjectService.addExpertTeacher(jieQiId, codes[i], "03", getSessionUser());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    public String listExpertTeachers() {
        totalNumber = this.endProjectService.getExpTeaCountByQici(jieQiId, "03");
        pageBean = new PageBean(page, totalNumber, rows);
        expertTeachers = this.endProjectService.getExpertTeachersByQici(jieQiId, "03", pageBean);
        totalPage = pageBean.getTotalPage();
        return SUCCESS;
    }

    public String preDispatchExpForSecReview() {
        getYearAndQicis();
        getAllColleges();
        return SUCCESS;
    }

    public String preCreateExpForSecReview() {
        getYearAndQicis();
        return SUCCESS;
    }

    private void getYearAndQicis() {
        List<BigDecimal> list = this.endProjectService.getAllJieQiYear();
        for (BigDecimal year : list) {
            allYears.add(new JieQiYear(year.toString(), year.toString()));
            List<TJieqi> jieqis = this.endProjectService.getJieqisOfYear(year
                    .toString());
            qicis.put(year.toString(), jieqis);
        }
    }

    private void getAllColleges() {
        colleges = this.endProjectService.getAllColleges();
        TUnit temp = new TUnit();
        temp.setUnitId("0");
        temp.setUnitName("所有");
        colleges.add(0, temp);
    }

    public String listEndProjectForSecReview() {
        try {
            totalNumber = this.endProjectService.getEndProjectCountForSecReview(properties);
            pageBean = new PageBean(page, totalNumber, rows);
            endProjectForDispatch = this.endProjectService.getEndProjectForSecReview(properties, pageBean);
            totalPage = pageBean.getTotalPage();
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
        return SUCCESS;
    }

    public String listEndProjects() throws IOException {
        try {
            if (getSessionUser() == null) {
                toLogin();
            } else {
                user = getSessionUser();
                //System.out.println(user.getUserType());
                totalNumber = this.endProjectService.getEndProjectCountByMutiProperty(user, properties);
                pageBean = new PageBean(page, totalNumber, rows);
                endProjects = this.endProjectService.getEndProjectsByMutiProperty(user, properties, pageBean);
                totalPage = pageBean.getTotalPage();
                findYearsAndQicis();
                if ("02".equals(user.getUserType()) || "03".equals(user.getUserType())) {
                    professions = this.endProjectService.getProfessionsByTeacherId(user.getUserId());
                    TProfession temp = new TProfession();
                    temp.setProfessionId("0");
                    temp.setProfessionName("所有");
                    professions.add(0, temp);
                }
                if ("00".equals(user.getUserType()) || "01".equals(user.getUserType())) {
                    getAllColleges();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    private void findYearsAndQicis() {
        List<BigDecimal> list = this.endProjectService.getAllJieQiYear();
        JieQiYear tempYear = new JieQiYear("0", "所有");
        allYears.add(tempYear);
        TJieqi tempJieqi = new TJieqi();
        tempJieqi.setJqId("0");
        tempJieqi.setQici("所有");
        qicis.put("0", Arrays.asList(new TJieqi[]{tempJieqi}));
        for (BigDecimal year : list) {
            allYears.add(new JieQiYear(year.toString(), year.toString()));
            List<TJieqi> jieqis = this.endProjectService.getJieqisOfYear(year
                    .toString());
            jieqis.add(0, tempJieqi);
            qicis.put(year.toString(), jieqis);
        }
    }

    /**
     * TODO 生成我的结题申请页面 authoy lzh
     *
     * @return
     * @throws Exception
     */
    public String preEndProjectRequest() throws Exception {
        try {
            if (getSessionUser() == null) {
                toLogin();
            }
            // 项目组长的学号
            studentNumber = getSessionUser().getUserId();
            TJieqi jieqi = this.jieQiService.findJieQiNow();
            Date now = new Date();
            if (jieqi == null) {
                messageInfo = "当前时间不是可以申请结题的时间段";
                return "message";
            } else {
                TEndProject t = endProjectService.findByLeaderCode(studentNumber);
                if (t != null) {
                    messageInfo = "您已经申请结题，不能重复申请";
                    return "message";
                } else {
                    project = projectService.findByLeaderCode(studentNumber);
                    if (project == null) {
                        messageInfo = "您没有可以申请结题的项目";
                        return "message";
                    }
                }

            }
            return SUCCESS;
        } catch (Exception e) {
            System.out.println("preMyEndproject failed " + e);
            return ERROR;
        }
    }

    /**
     * TODO 生成组织结题评审页面 authoy lzh
     *
     * @return
     * @throws Exception
     */
    public String preOrganizeEndprojectReview() throws Exception {
        try {
            TUser user = getSessionUser();
            if (user == null || user.getUserId() == null
                    || user.getUserId().equals("")) {
                toLogin();
            }
            TJieqi jieqi = this.jieQiService.findJieQiNow();
            String year = jieqi.getJqYear().toString();
            jieQiYears = new ArrayList<JieQiYear>();
            jieQiYears.add(new JieQiYear(year, year));
            List<TJieqi> tmpJieqis = new ArrayList<TJieqi>();
            tmpJieqis.add(jieqi);
            qicis.put(year.toString(), tmpJieqis);
             /*
            years = this.declarationService.findAllYears();
			jieQiYears = new ArrayList<JieQiYear>();
			for (BigDecimal year : years) {
				jieQiYears.add(new JieQiYear(year.toString(), year.toString()));
				List<TJieqi> tmpJieqis = this.declarationService
						.findJieqiByYear(year.toString());
				qicis.put(year.toString(), tmpJieqis);
			}
			*/
            return SUCCESS;
        } catch (Exception e) {
            return ERROR;
        }
    }

    /**
     * TODO 提交结题申请
     *
     * @return
     * @throws Exception
     * @authoy lzh
     */
    public String addEndprojectRequest() throws Exception {
        try {
            TUser user = getSessionUser();
            if (user == null || user.getUserId() == null
                    || user.getUserId().equals("")) {
                toLogin();
            }

            /***********************************************
             * 2013.10.21
             * author: daowen.wu
             * remark: add unit for end project
             * code start with this line
             **********************************************/
            // 获取当前登陆人的学院ID，并判定是否为空
            TUnit unit = getSessionUnit();
            if (unit == null || unit.getUnitId() == null
                    || unit.getUnitId().trim().equals("")) {
                toLogin();
            }
            // 设置结题所在学院
            endProject.setTUnit(unit);
            /***********************************************
             * code end on this line
             ************************************************/

            endProject.setEndProjectState("01");
            endProject.setIsdeleted("N");
            //设置结题提交时间
            endProject.setSubmitTime((Timestamp) new Date());
            // 设置项目
            TProject p = this.projectService.findById(proId);
            endProject.setTProject(p);
            // 设置届期
            TJieqi jq = this.jieQiService.findTjieqiById(jieQiId);
            endProject.setTJieqi(jq);
            // 分工
            List<TEndProjectJob> epJobs = new ArrayList<TEndProjectJob>();
            TStudent student = new TStudent();
            // 设置学生ID
            if (studentNumber != null && !studentNumber.equals("")) {
                student = (TStudent) this.declarationService
                        .getStudentsByNumber(studentNumber).get(0);
                endprojectJob.setTStudent(student);
                epJobs.add(endprojectJob);
            }
            if (studentNumber1 != null && !studentNumber1.equals("")) {
                student = (TStudent) this.declarationService
                        .getStudentsByNumber(studentNumber1).get(0);
                endprojectJob1.setTStudent(student);
                epJobs.add(endprojectJob1);
            }
            if (studentNumber2 != null && !studentNumber2.equals("")) {
                student = (TStudent) this.declarationService
                        .getStudentsByNumber(studentNumber2).get(0);
                endprojectJob2.setTStudent(student);
                epJobs.add(endprojectJob2);
            }
            // 附件
            List<TAttachment> tAttachments = new ArrayList<TAttachment>();
            if (files != null && files.length > 0) {
                if (files != null && filesFileName != null
                        && filesContentType != null
                        && files.length == filesFileName.length
                        && filesFileName.length == filesContentType.length) {
                    List<String> fileUris = FileUtility.SaveFiles(files,
                            filesFileName, filesContentType);
                    if (fileUris != null && fileUris.size() > 0) {
                        for (int i = 0; i < fileUris.size(); i++) {
                            TAttachment tAttachment = new TAttachment();
                            tAttachment.setFileName(filesFileName[i]);
                            tAttachment.setFileFormat(filesContentType[i]);
                            tAttachment.setFileSize(new BigDecimal(files[i]
                                    .length()));
                            tAttachment.setFileUrl(fileUris.get(i));
                            tAttachment.setTUser(user);
                            tAttachments.add(tAttachment);
                        }
                    }
                }
            }
            this.endProjectService.addEndProjectRequest(tAttachments, endProject,
                    epJobs);

            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return "Error";
        }
    }

    /**
     * TODO 生成我的结题页面 authoy lzh
     *
     * @return
     * @throws Exception
     */
    public String preMyEndProjects() throws Exception {
        try {
            user = getSessionUser();
            if (user == null) {
                toLogin();
            }
            studentNumber = user.getUserId();
            endProjects = this.endProjectService
                    .findMyEndProjects(studentNumber);
            return SUCCESS;
        } catch (Exception e) {
            System.out.println("preMyEndProjects failed" + e);
            return ERROR;
        }
    }

    /**
     * TODO 查看结题的详细信息 authoy lzh
     *
     * @return
     * @throws Exception
     */
    public String endProjectDetail() throws Exception {
        try {
            user = getSessionUser();
            if (user == null) {
                toLogin();
            }
            //结题
            endProject = this.endProjectService.findEndProjectById(endprojectId);
            //分工
            List<TEndProjectJob> eJobs = this.endProjectService.findEndproJobsByEndProId(endprojectId);
            for (int i = 0; i < eJobs.size(); i++) {
                if (i == 0) {
                    endprojectJob = eJobs.get(i);
                }
                if (i == 1) {
                    endprojectJob1 = eJobs.get(i);
                }
                if (i == 2) {
                    endprojectJob2 = eJobs.get(i);
                }
            }
            //附件
            attachments = this.endProjectService.findAttachmentByEndProId(endprojectId);
            return SUCCESS;
        } catch (Exception e) {
            System.out.println("get endproject detail failed" + e);
            return ERROR;
        }
    }

    /**
     * TODO 学院主管教师添加结题评语
     * authoy lzh
     *
     * @return
     * @throws Exception
     */
    public String unitTeaAddEndProCom() throws Exception {
        try {
            user = getSessionUser();
            if (user == null) {
                toLogin();
            }
            TEndProject endProject = this.endProjectService.findEndProjectById(endprojectId);
            endProject.setEndProjectComment(endprojectComment);
            this.endProjectService.updateEndProjects(Arrays.asList(new TEndProject[]{endProject}));
            return SUCCESS;
        } catch (Exception e) {
            return ERROR;
        }
    }

    /**
     * *************************************
     * * get and set methods
     * *************************************
     */

    public TEndProject getEndProject() {
        return endProject;
    }

    public void setEndProject(TEndProject endProject) {
        this.endProject = endProject;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public TEndProjectJob getEndprojectJob() {
        return endprojectJob;
    }

    public void setEndprojectJob(TEndProjectJob endprojectJob) {
        this.endprojectJob = endprojectJob;
    }

    public TEndProjectJob getEndprojectJob1() {
        return endprojectJob1;
    }

    public void setEndprojectJob1(TEndProjectJob endprojectJob1) {
        this.endprojectJob1 = endprojectJob1;
    }

    public TEndProjectJob getEndprojectJob2() {
        return endprojectJob2;
    }

    public void setEndprojectJob2(TEndProjectJob endprojectJob2) {
        this.endprojectJob2 = endprojectJob2;
    }

    public String getJieQiId() {
        return jieQiId;
    }

    public void setJieQiId(String jieQiId) {
        this.jieQiId = jieQiId;
    }

    public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId;
    }

    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }

    public TProject getProject() {
        return project;
    }

    public void setProject(TProject project) {
        this.project = project;
    }

    public void setJieQiService(JieQiService jieQiService) {
        this.jieQiService = jieQiService;
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

    public void setEndProjectService(EndProjectService endProjectService) {
        this.endProjectService = endProjectService;
    }

    public String getStudentNumber1() {
        return studentNumber1;
    }

    public void setStudentNumber1(String studentNumber1) {
        this.studentNumber1 = studentNumber1;
    }

    public String getStudentNumber2() {
        return studentNumber2;
    }

    public void setStudentNumber2(String studentNumber2) {
        this.studentNumber2 = studentNumber2;
    }


    public void setDeclarationService(DeclarationService declarationService) {
        this.declarationService = declarationService;
    }

    public List<TEndProject> getEndProjects() {
        return endProjects;
    }

    public void setEndProjects(List<TEndProject> endProjects) {
        this.endProjects = endProjects;
    }

    public String getEndprojectId() {
        return endprojectId;
    }

    public void setEndprojectId(String endprojectId) {
        this.endprojectId = endprojectId;
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

    public Map<String, List<TJieqi>> getQicis() {
        return qicis;
    }

    public void setQicis(Map<String, List<TJieqi>> qicis) {
        this.qicis = qicis;
    }

    public TUser getUser() {
        return user;
    }

    public void setUser(TUser user) {
        this.user = user;
    }

    public EndProjectProperty getProperties() {
        return properties;
    }

    public void setProperties(EndProjectProperty properties) {
        this.properties = properties;
    }

    public List<JieQiYear> getAllYears() {
        return allYears;
    }

    public void setAllYears(List<JieQiYear> allYears) {
        this.allYears = allYears;
    }

    public List<TUnit> getColleges() {
        return colleges;
    }

    public void setColleges(List<TUnit> colleges) {
        this.colleges = colleges;
    }

    public List<TProfession> getProfessions() {
        return professions;
    }

    public void setProfessions(List<TProfession> professions) {
        this.professions = professions;
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

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public List<TAttachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<TAttachment> attachments) {
        this.attachments = attachments;
    }

    public List<ExpertTeacher> getExpertTeachers() {
        return expertTeachers;
    }

    public void setExpertTeachers(List<ExpertTeacher> expertTeachers) {
        this.expertTeachers = expertTeachers;
    }

    public String getTeaCode() {
        return teaCode;
    }

    public void setTeaCode(String teaCode) {
        this.teaCode = teaCode;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public List<EndProject> getEndProjectForDispatch() {
        return endProjectForDispatch;
    }

    public void setEndProjectForDispatch(List<EndProject> endProjectForDispatch) {
        this.endProjectForDispatch = endProjectForDispatch;
    }

    public String getTids() {
        return tids;
    }

    public void setTids(String tids) {
        this.tids = tids;
    }

    public Boolean getTypeIned() {
        return typeIned;
    }

    public void setTypeIned(Boolean typeIned) {
        this.typeIned = typeIned;
    }

    public String getLastScore() {
        return lastScore;
    }

    public void setLastScore(String lastScore) {
        this.lastScore = lastScore;
    }

    public String getMessageInfo() {
        return messageInfo;
    }

    public void setMessageInfo(String messageInfo) {
        this.messageInfo = messageInfo;
    }

    public String getEndprojectComment() {
        return endprojectComment;
    }

    public void setEndprojectComment(String endprojectComment) {
        this.endprojectComment = endprojectComment;
    }
}
