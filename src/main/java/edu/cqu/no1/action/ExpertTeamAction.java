package edu.cqu.no1.action;

import edu.cqu.no1.dao.TDeclCommentDAO;
import edu.cqu.no1.datamodel.EndProjectProperty;
import edu.cqu.no1.datamodel.JieQiYear;
import edu.cqu.no1.domain.*;
import edu.cqu.no1.service.*;
import edu.cqu.no1.util.PageBean;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.*;

@Controller

@Namespace("/")
@Scope("prototype")
@ParentPackage("base")
public class ExpertTeamAction extends BaseAction {

    private TUser tUser;
    @Resource
    private ExpertLibService expertLibService;
    @Resource
    private DeclarationService declarationService;
    private String teaCode; // 学院主管老师的教职工号
    private List<Integer> years;
    private List<JieQiYear> jieQiYears;
    private List<TTeacher> teachers;
    private Map<String, List<TJieqi>> qicis = new HashMap<String, List<TJieqi>>();

    @Resource
    private ExpertTeacherService expertTeacherService;
    @Resource
    private TeacherService teacherService;
    @Resource
    private JieQiService jieQiService;
    @Resource
    private ProfessionService professionService;
    @Resource
    private ExpertReviewService expertReviewService;
    @Resource
    private ProjectService projectService;
    @Resource
    private TDeclCommentDAO tDeclCommentDAO;

    private List<TDeclaration> declarations;

    private TDeclComment declComment = new TDeclComment();
    private List<TDeclComment> listTDeclComment;
    private String declarId; // 申报ID
    private String opinion; // 评审意见
    private String expLibId;// 专家库ID
    private String reviewResult;
    private String compEval;
    private List<TExpertTeacher> expertTeachers;

    private TUnit tunit;
    /**
     * 创建专家团队
     */
    private String jqYear;
    private String qici;
    private String experts;
    /**
     * 历史专家库查询
     */
    private String teacherCode;
    private String teacherName;
    private String teacherTitle;
    private String[] teacherCodes;
    private String teacherEmail;
    private String teacherAge;
    private String teacherSex;
    private String teacherTele;
    private String teacherRemark;
    private String teacherIntro;

    // 当前专家库
    private TExpertLib tExpertLib;

    // 分派专家团队
    private List<TProfession> professions;
    private String[] checkProjects;// 申报ID
    private List<TExpertLib> expertLibs;

    private String checkState; // 状态
    private String profession; // 专业
    private String proSerial; // 项目编号
    private String proName; // 项目名称
    private String studentNumebr; // 学生学号
    // 结题
    private List<TEndProject> endProjects;
    @Resource
    private EndProjectService endProjectService;
    @Resource
    private EndProjectExportService endProjectExportService;
    private TUser user;
    private EndProjectProperty property = new EndProjectProperty();
    private List<TEndProjectExport> endProjectExports;
    private String endprojectId; //结题ID

    // 结题网评
    private List<TEndProjectComment> endProjectComments;
    private String endProjectCommentsId;
    private TEndProjectComment endProjectComment;
    //附件
    private List<TAttachment> attachments;
    //信息提示
    private String messageInfo;

    /**
     * 分页使用的参数
     */
    private int page = 1; // 初始页面
    private PageBean pageBean; // 分页用的bean
    private int totalPage = 1; // 总页面数
    private int totalNumber = 0; // 总数据条数
    private int pageCapacity = 14; // 每页显示条数

    private String result;


    @Action(value = "checkHasTeacher", results = {
            @Result(name = "success", type = "json", params = {"contentType", "text/html", "includeProperties", "result"})
    })
    public String checkHasTeacher() throws Exception {
        try {
            TTeacher tmpTeacher = this.teacherService.findTeacherByTeaCode(teacherCode);

            if (null != tmpTeacher && null != tmpTeacher.getTeaId()) {
                result = "yes";
            } else {
                result = "no";
            }

            return SUCCESS;
        } catch (Exception e) {
            return ERROR;
        }
    }

    // ///////////////////////////结题//////////////////////////////

    /**
     * TODO 列出学院所有结题的专家团队 02为结题的专家团队
     */
    public String findEndproExpTeam() throws Exception {
        try {
            user = getSessionUser();
            if (user == null) {
                toLogin();
            }
            teaCode = user.getUserId();
            // 02为结题的专家团队
            totalNumber = this.expertLibService.findExpsCountByUnitTeaCode(
                    teaCode, "02");
            pageBean = new PageBean(page, totalNumber, pageCapacity);
            expertLibs = this.expertLibService.findExpsByUnitTeaCode(teaCode,
                    "02", pageBean);
            totalPage = pageBean.getTotalPage();
            return SUCCESS;
        } catch (Exception e) {
            return ERROR;
        }
    }


    /**
     * TODO 生成创建结题专家团队页面
     */
    @SuppressWarnings("unchecked")
    public String preCreateEndProExpertTeam() throws Exception {
        try {
            // 学院主管老师的教职工号
            user = getSessionUser();
            if (user == null) {
                toLogin();
            }
            teaCode = user.getUserId();
            // 获取当前届期
            TJieqi jieqi = this.jieQiService.findJieQiNow();
            /*********************************************************************
             * 判断当前届期是否存在有效的结题专家库，提示用户是否继续创建
             *********************************************************************/

            List<TExpertLib> tmpList = this.expertTeacherService.findExpertLibByJqid(jieqi.getJqId(), "02");
            if (null != tmpList && tmpList.size() > 0) {
                return "hadValue";
            } else {
                String year = jieqi.getJqYear().toString();
                jieQiYears = new ArrayList<JieQiYear>();
                jieQiYears.add(new JieQiYear(year, year));
                List<TJieqi> tmpJieqis = new ArrayList<TJieqi>();
                tmpJieqis.add(jieqi);
                qicis.put(year.toString(), tmpJieqis);
                teachers = this.teacherService.getCommonTeachers(teaCode, "02");
                expertTeachers = this.expertTeacherService.findAssignedExpertTeachers(jieqi.getJqId(), "02", teaCode);
                return SUCCESS;
            }

        } catch (Exception e) {
            return ERROR;
        }
    }

    @SuppressWarnings("unchecked")
    public String confirmCreateEndProExpertTeam() throws Exception {
        try {
            // 学院主管老师的教职工号
            user = getSessionUser();
            if (user == null) {
                toLogin();
            }
            teaCode = user.getUserId();
            // 获取当前届期
            TJieqi jieqi = this.jieQiService.findJieQiNow();
            String year = jieqi.getJqYear().toString();
            jieQiYears = new ArrayList<JieQiYear>();
            jieQiYears.add(new JieQiYear(year, year));
            List<TJieqi> tmpJieqis = new ArrayList<TJieqi>();
            tmpJieqis.add(jieqi);
            qicis.put(year.toString(), tmpJieqis);

            teachers = this.teacherService.getCommonTeachers(teaCode, "02");

            //expertTeachers = this.expertTeacherService.findAssignedExpertTeachers(jieqi.getJqId(), "02", teaCode);
            return SUCCESS;

        } catch (Exception e) {
            return ERROR;
        }
    }


    /**
     * TODO 创建结题的专家团队
     */
    public void createEndproExpTeam() throws Exception {
        try {
            user = getSessionUser();
            if (user == null) {
                toLogin();
            }
            teaCode = user.getUserId();
            TTeacher creater = this.teacherService.findTeacherByTeaCode(teaCode); // 根据主管教师code获取其对象
            Date date = new Date();
            TJieqi jieqi = this.jieQiService.findTjieqiById(qici);// 获取届期对象

            // 专家库对象
            TExpertLib tLib = new TExpertLib();
            tLib.setTTeacher(creater);
            tLib.setCreatOn((Timestamp) date);
            tLib.setTJieqi(jieqi);
            tLib.setIsdeleted("N");
            tLib.setType("02");// 02为结题的专家团队
            tLib.setTUnit(creater.getTUnit());
            List<TExpertTeacher> tExpertTeacherList = new ArrayList<TExpertTeacher>();
            String teas[] = experts.split(",");
            for (int i = 0; i < teas.length; i++) {
                String tea = teas[i].split("--")[1].trim();
                TTeacher eTeacher = this.teacherService.findTeacherByTeaCode(tea);// 根据教职工号获取教师对象
                TExpertTeacher exTeacher = new TExpertTeacher();
                exTeacher.setTTeacher(eTeacher);
                exTeacher.setIsdeleted("N");
                tExpertTeacherList.add(exTeacher);
            }
            // 02 用于标记临时邮件接收人的类型为结题的
            this.expertLibService.creatExpertLib(tLib, tExpertTeacherList, "02");
            //return SUCCESS;
        } catch (Exception e) {
            System.out.println("create expert team failed " + e);
            //return ERROR;
        }
    }


    /**
     * TODO 生成分派结题专家团队页面
     */
    @SuppressWarnings("unchecked")
    public String preAssignEndProExpert() throws Exception {
        try {
            // 学院主管老师的教职工号
            user = getSessionUser();
            if (user == null) {
                toLogin();
            }
            teaCode = user.getUserId();
            // 获取当前届期
            TJieqi jieqi = this.jieQiService.findJieQiNow();
            String year = jieqi.getJqYear().toString();
            jieQiYears = new ArrayList<JieQiYear>();
            jieQiYears.add(new JieQiYear(year, year));
            List<TJieqi> tmpJieqis = new ArrayList<TJieqi>();
            tmpJieqis.add(jieqi);
            qicis.put(year.toString(), tmpJieqis);
            // 专业
            professions = this.professionService.findTProfessionsByTeaCode(teaCode);
            // 未分派的项目
            // 状态为01，获取未分派专家的结题列表
            this.totalNumber = this.endProjectService.getUnitEndProjectsCount(teaCode, "01");
            pageBean = new PageBean(page, totalNumber, pageCapacity);
            endProjects = this.endProjectService.getUnitEndProjects(teaCode, "01", pageBean);
            totalPage = pageBean.getTotalPage();
            // 本期次专家团队，02为结题的专家团队
            expertTeachers = this.expertTeacherService.findAssignedExpertTeachers(jieqi.getJqId(), "02", teaCode);
            return SUCCESS;
        } catch (Exception e) {
            return ERROR;
        }
    }


    /**
     * TODO 分派结题评审专家
     */
    public void assignEndProExpert() throws Exception {
        try {
            user = getSessionUser();
            if (user == null) {
                toLogin();
            }
            List<TExpertTeacher> tExpertTeacher;
            String teas[] = experts.split(",");
            // checkProjects申报ID
            for (int i = 0; i < checkProjects.length; i++) {
                tExpertTeacher = new ArrayList<TExpertTeacher>();
                for (int j = 0; j < teas.length; j++) {
                    String tea = teas[j].split("--")[1].trim();
                    TExpertTeacher teacher = this.expertTeacherService
                            .findExpTeaByCode(tea);// 根据专家教师ID获取一个对象
                    tExpertTeacher.add(teacher);
                }
                TEndProject endProject = this.endProjectService
                        .findEndProjectById(checkProjects[i]);// 根据结题ID获取一个结题对象
                this.endProjectExportService.creatEndProExpertReview(
                        endProject, tExpertTeacher);
            }
        } catch (Exception e) {
        }
    }


    /**
     * TODO 分派专家团队页面的查询
     */
    @SuppressWarnings("unchecked")
    public String queryAssignEndProExpert() throws Exception {
        try {
            if (getSessionUser() == null) {
                toLogin();
            } else {
                user = getSessionUser();
                totalNumber = this.endProjectService
                        .getEndProjectCountByMutiProperty(user, property);
                pageBean = new PageBean(page, totalNumber, pageCapacity);
                endProjects = this.endProjectService
                        .getEndProjectsByMutiProperty(user, property, pageBean);
                totalPage = pageBean.getTotalPage();
                findYearsAndQicis();
                if ("01".equals(user.getUserType())) {
                    professions = this.endProjectService
                            .getProfessionsByTeacherId(user.getUserId());
                    TProfession temp = new TProfession();
                    temp.setProfessionId("0");
                    temp.setProfessionName("所有");
                    professions.add(0, temp);
                }
                // 本期次专家团队，02为结题的专家团队
                // 获取当前届期
                TJieqi jieqi = this.jieQiService.findJieQiNow();
                expertTeachers = this.expertTeacherService
                        .findAssignedExpertTeachers(jieqi.getJqId(), "02",
                                teaCode);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return ERROR;
        }
        return SUCCESS;
    }


    /**
     * TODO 成绩录入页面的查询 authoy lzh
     */
    @SuppressWarnings("unchecked")
    public String queryEndProScoreTypeIn() throws Exception {
        try {
            user = getSessionUser();
            if (user == null) {
                toLogin();
            } else {

                teaCode = user.getUserId();
                // 获取当前届期
                TJieqi jieqi = this.jieQiService.findJieQiNow();
                String year = jieqi.getJqYear().toString();
                jieQiYears = new ArrayList<JieQiYear>();
                jieQiYears.add(new JieQiYear(year, year));
                List<TJieqi> tmpJieqis = new ArrayList<TJieqi>();
                tmpJieqis.add(jieqi);
                qicis.put(year.toString(), tmpJieqis);
                // 专业
                professions = this.professionService.findTProfessionsByTeaCode(teaCode);

                totalNumber = this.endProjectService
                        .getEndProjectCountByMutiProperty(user, property);
                pageBean = new PageBean(page, totalNumber, pageCapacity);
                endProjects = this.endProjectService.getEndProjectsByMutiProperty(user, property, pageBean);
                totalPage = pageBean.getTotalPage();
                //findYearsAndQicis();
                if ("01".equals(user.getUserType())) {
                    professions = this.endProjectService.getProfessionsByTeacherId(user.getUserId());
                    TProfession temp = new TProfession();
                    temp.setProfessionId("0");
                    temp.setProfessionName("所有");
                    professions.add(0, temp);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return ERROR;
        }
        return SUCCESS;
    }

    private void findYearsAndQicis() {
        List<BigDecimal> list = this.endProjectService.getAllJieQiYear();
        JieQiYear tempYear = new JieQiYear("0", "所有");
        jieQiYears = new ArrayList<JieQiYear>();
        jieQiYears.add(tempYear);
        TJieqi tempJieqi = new TJieqi();
        tempJieqi.setJqId("0");
        tempJieqi.setQici("所有");
        qicis.put("0", Arrays.asList(new TJieqi[]{tempJieqi}));
        for (BigDecimal year : list) {
            jieQiYears.add(new JieQiYear(year.toString(), year.toString()));
            List<TJieqi> jieqis = this.endProjectService.getJieqisOfYear(year
                    .toString());
            jieqis.add(0, tempJieqi);
            qicis.put(year.toString(), jieqis);
        }
    }

    /**
     * TODO 列出学院的历史专家库教师（结题类型的） authoy lzh
     *
     * @return
     * @throws Exception
     */
    public String listEndProHistoryExpert() throws Exception {
        try {
            System.out.println("123");
            user = getSessionUser();
            if (user == null) {
                toLogin();
            }
            teaCode = user.getUserId();
            totalNumber = this.expertTeacherService.getExpertTeachersByTeaCodeCount(teaCode, "02");
            pageBean = new PageBean(page, totalNumber, pageCapacity);
            expertTeachers = this.expertTeacherService.getExpertTeachersByTeaCode(teaCode, "02", pageBean);
            totalPage = pageBean.getTotalPage();
            return SUCCESS;
        } catch (Exception e) {
            return "error";
        }
    }

    /**
     * TODO 查询学院的历史专家（结题类型的） 02 为结题类型的专家
     *
     * @return
     * @throws Exception
     */
    public String findEndProHistoryExpert() throws Exception {
        try {
            // 学院主管教师教职工号
            user = getSessionUser();
            if (user == null) {
                toLogin();
            }
            teaCode = user.getUserId();

            totalNumber = this.expertTeacherService.findExpertTeachersCount(teaCode, teacherName, teacherTitle, "02");
            pageBean = new PageBean(page, totalNumber, pageCapacity);
            expertTeachers = this.expertTeacherService.findExpertTeachers(
                    teaCode, teacherName, teacherTitle, "02", pageBean);
            totalPage = pageBean.getTotalPage();

            return SUCCESS;
        } catch (Exception e) {
            return ERROR;
        }
    }

    /**
     * TODO 从历史专家库添加至本期专家库(结题类型) authoy lzh
     *
     * @return
     * @throws Exception
     */
    public String createEndProExpFromHistory() throws Exception {
        try {
            user = getSessionUser();
            if (user == null) {
                toLogin();
            }
            List<TExpertTeacher> tExpertTeacher = new ArrayList<TExpertTeacher>();

            // 获取当前结题届期
            TJieqi jieqi = this.jieQiService.findJieQiNow();
            // 获取当前届期对应的专家库
            List<TExpertLib> tmpList = this.expertTeacherService.findUnitExpertLibByJqid(jieqi.getJqId(), "02", user.getUserId());
            if (null != tmpList && tmpList.size() > 0) {
                //TExpertLib tExpertLib = this.expertLibService.findNowJieQiExpLib("02");
                TExpertLib tExpertLib = tmpList.get(0);
                for (String teacodeStr : teacherCodes) {
                    TTeacher teacher = this.teacherService.findTeacherByTeaCode(teacodeStr);
                    TExpertTeacher exteacher = new TExpertTeacher();
                    exteacher.setTTeacher(teacher);
                    exteacher.setTExpertLib(tExpertLib);
                    exteacher.setIsdeleted("N");
                    tExpertTeacher.add(exteacher);
                }
                this.expertTeacherService.saveExpertTeacher(tExpertTeacher);
                result = "yes";

            } else {
                result = "noCurrentJieqi";
            }
            return SUCCESS;

        } catch (Exception e) {
            result = "error";
            return SUCCESS;
        }
    }

    /**
     * TODO 结题成绩录入页面生成 authoy lzh
     *
     * @return
     * @throws Exception
     */
    public String preEndProResultTypeIn() throws Exception {
        try {
            user = getSessionUser();
            if (user == null) {
                toLogin();
            }
            tunit = getSessionUnit();
            if (null == tunit) {
                toLogin();
            }
            teaCode = user.getUserId();
            // 获取当前届期
            TJieqi jieqi = this.jieQiService.findJieQiNow();
            String year = jieqi.getJqYear().toString();
            jieQiYears = new ArrayList<JieQiYear>();
            jieQiYears.add(new JieQiYear(year, year));
            List<TJieqi> tmpJieqis = new ArrayList<TJieqi>();
            tmpJieqis.add(jieqi);
            qicis.put(year.toString(), tmpJieqis);
            // 专业
            professions = this.professionService.findTProfessionsByTeaCode(teaCode);
            // 成绩录入页面，获取状态为03，已经分派专家的结题
            this.totalNumber = this.endProjectService.getUnitEndProjectsCount(teaCode, "03");
            pageBean = new PageBean(page, totalNumber, pageCapacity);
            endProjects = this.endProjectService.getUnitEndProjects(teaCode,
                    "03", pageBean);
            totalPage = pageBean.getTotalPage();
            return SUCCESS;
        } catch (Exception e) {
            System.out.println(e);
            return ERROR;
        }
    }

    /**
     * TODO 学院主管教师录入结题成绩 authoy lzh
     *
     * @return
     */
    public void endProScoreTypeIn() {
        try {
            user = getSessionUser();
            if (user == null) {
                toLogin();
            }
            String state = checkState;
            TEndProject endProject = null;
            List<TEndProject> eProjects = new ArrayList<TEndProject>();
            for (String project : checkProjects) {
                endProject = this.endProjectService.findEndProjectById(project);
                endProject.setEndProjectScore(state);
                // 学院录入成绩时间
                Date date = new Date();
                endProject.setUnitTypeinTime((Timestamp) date);
                endProject.setSchoolTypeinTime((Timestamp) date);
                eProjects.add(endProject);
            }

            this.endProjectService.updateEndProjects(eProjects);
        } catch (Exception e) {
        }
    }

    /**
     * 生成结题成绩审核页面 TODO authoy lzh
     *
     * @return
     */
    public String preEndProScoreAudit() {
        try {
            // 主管教师教职工号
            user = getSessionUser();
            if (user == null) {
                toLogin();
            }
            tunit = getSessionUnit();
            if (null == tunit) {
                toLogin();
            }
            teaCode = user.getUserId();
            // 获取当前届期
            TJieqi jieqi = this.jieQiService.findJieQiNow();
            String year = jieqi.getJqYear().toString();
            jieQiYears = new ArrayList<JieQiYear>();
            jieQiYears.add(new JieQiYear(year, year));
            List<TJieqi> tmpJieqis = new ArrayList<TJieqi>();
            tmpJieqis.add(jieqi);
            qicis.put(year.toString(), tmpJieqis);
            professions = this.professionService
                    .findTProfessionsByTeaCode(teaCode);
            // 成绩录入页面，获取状态为03，结题中的项目（已录入成绩）
            this.totalNumber = this.endProjectService.getUnitEndProjectsCount(teaCode, "03");
            pageBean = new PageBean(page, totalNumber, pageCapacity);
            endProjects = this.endProjectService.getUnitEndProjects(teaCode, "03", pageBean);
            totalPage = pageBean.getTotalPage();
            return SUCCESS;
        } catch (Exception e) {
            return ERROR;
        }
    }

    /**
     * TODO 学院主管教师将结题提交教务处审核 authoy lzh
     *
     * @return
     */
    public void endprojectUnitCheck() {
        try {
            user = getSessionUser();
            if (user == null) {
                toLogin();
            }
            TEndProject endProject = null;
            List<TEndProject> eProjects = new ArrayList<TEndProject>();
            for (String project : checkProjects) {
                endProject = this.endProjectService.findEndProjectById(project);
                endProject.setEndProjectState("04");// 提交教务处审核
                eProjects.add(endProject);
            }
            this.endProjectService.updateEndProjects(eProjects);
        } catch (Exception e) {
        }
    }

    /**
     * TODO 生成我的评审页面（结题列表） authoy lzh
     *
     * @return
     * @throws Exception
     */
    public String preMyEndProReview() throws Exception {
        try {
            // 评审教师教职号
            user = getSessionUser();
            if (user == null) {
                toLogin();
            }
            teacherCode = user.getUserId();
            // 获取当前届期
            TJieqi jieqi = this.jieQiService.findJieQiNow();
            Date now = new Date();
            if (jieqi == null) {
                messageInfo = "当前时间不是可以进行网评的时间段";
                return "message";
            } else {
                Date jtStart = jieqi.getJtStartOn();
                Date jtEnd = jieqi.getJtEndOn();
                if (now.getTime() < jtStart.getTime() || now.getTime() > jtEnd.getTime()) {
                    messageInfo = "当前时间不是可以进行网评的时间段";
                    return "message";
                }

                String year = jieqi.getJqYear().toString();
                jieQiYears = new ArrayList<JieQiYear>();
                jieQiYears.add(new JieQiYear(year, year));
                List<TJieqi> tmpJieqis = new ArrayList<TJieqi>();
                tmpJieqis.add(jieqi);
                qicis.put(year.toString(), tmpJieqis);
                // 专业
                professions = this.professionService.findTProfessionsByTeaCode(teacherCode);
                // 获取我可以评审的结题
//			this.totalNumber = this.endProjectExportService.findMyReviewEndPros(teacherCode, jieqi.getJqId());
                this.totalNumber = this.endProjectService
                        .findMyReviewEndProsCount(teacherCode);
                pageBean = new PageBean(page, totalNumber, pageCapacity);
//			endProjectExports = this.endProjectExportService.findMyReviewEndPros(teacherCode, jieqi.getJqId(), pageBean);
                endProjectComments = this.endProjectService.findMyReviewEndPros(
                        teacherCode, pageBean);
                totalPage = pageBean.getTotalPage();
                return SUCCESS;
            }
        } catch (Exception e) {
            return ERROR;
        }
    }

    /**
     * TODO 根据结题网评ID获取结题网评对象 authoy lzh
     * 生成结题网评页面
     *
     * @return
     * @throws Exception
     */
    public String findEndProComById() throws Exception {
        try {
            user = getSessionUser();
            if (user == null) {
                toLogin();
            }
            endProjectComment = this.endProjectService
                    .findEndProComById(endProjectCommentsId);
            //附件
            attachments = this.endProjectService.findAttachmentByEndProId(endProjectComment.getTEndProjectExport().getTEndProject().getEndProjectId());
            return SUCCESS;
        } catch (Exception e) {
            System.out.println("find endprojectcomment by id failed" + e);
            return ERROR;
        }
    }

    /**
     * TODO 评审专家添加网评
     * authoy lzh
     *
     * @return
     * @throws Exception
     */
    public String addEndProComment() throws Exception {
        try {
            user = getSessionUser();
            if (user == null) {
                toLogin();
            }
            //根据结题ID和教职工号获取结题专家评审对象
            TEndProjectExport t = this.endProjectExportService.findEndProExp(user.getUserId(), endprojectId);
            TEndProjectComment tc = endProjectComment;
            tc.setIsdeleted("N");
            tc.setTEndProjectExport(t);
            this.endProjectService.addEndProjectComment(tc);
            return SUCCESS;
        } catch (Exception e) {
            System.out.println("endproject expert add endproject comment failed" + e);
            return ERROR;
        }
    }

    /**
     * TODO 生成编辑结题学院专家团队页面 authoy lzh
     *
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public String preUpdateEndProExpTea() throws Exception {
        try {
            // 从session中获取教职工号
            user = getSessionUser();
            if (user == null) {
                toLogin();
            }
            teaCode = user.getUserId();
            // 01 为申报的专家教师，02为结题的专家教师
            teachers = this.teacherService.getCommonTeachers(teaCode, "02");
            expertTeachers = this.expertTeacherService.findExpTeaByExpLibId(expLibId);
            // 根据专家库id获取当前专家库
            tExpertLib = this.expertLibService.getById(expLibId);
            return SUCCESS;
        } catch (Exception e) {
            return ERROR;
        }
    }

    /**
     * TODO 编辑结题专家团队 authoy lzh
     *
     * @return
     * @throws Exception
     */
    public void updateEndProExpTea() throws Exception {
        try {
            user = getSessionUser();
            if (user == null) {
                toLogin();
            }
            TExpertLib tLib = this.expertLibService.getById(expLibId);
            List<TExpertTeacher> tExpertTeacherList = new ArrayList<TExpertTeacher>();
            String teas[] = experts.split(",");
            for (int i = 0; i < teas.length; i++) {
                String tea = teas[i].split("--")[1].trim();
                System.out.println(tea);
                TTeacher eTeacher = this.teacherService
                        .findTeacherByTeaCode(tea);// 根据教职工号获取教师对象
                TExpertTeacher exTeacher = new TExpertTeacher();
                exTeacher.setTTeacher(eTeacher);
                exTeacher.setIsdeleted("N");
                tExpertTeacherList.add(exTeacher);
            }
            this.expertLibService
                    .updateExperLib(tLib, tExpertTeacherList, "02");

        } catch (Exception e) {

        }
    }


    // ///////////////////////////申报//////////////////////////////

    @Action(value = "PreCreateExpert", results = {
            @Result(name = "success", location = "/pages/expertTeam/create_expert.jsp"),
            @Result(name = "hadValue", location = "/pages/expertTeam/decl_expert_had_existed.jsp")
    })
    /**
     * TODO 生成创建专家团队页面
     */
    @SuppressWarnings("unchecked")
    public String preCreateExpertTeam() throws Exception {
        try {
            // 学院主管老师的教职工号
            user = getSessionUser();
            if (user == null) {
                toLogin();
            }

            // 获取当前届期
            TJieqi jieqi = this.jieQiService.findCurrentJieQi();
            /*********************************************************************
             * 判断当前届期是否存在有效的结题专家库，提示用户是否继续创建
             *********************************************************************/
            List<TExpertLib> tmpList = this.expertTeacherService.findUnitExpertLibByJqid(jieqi.getJqId(), "01", user.getUserId());
            if (null != tmpList && tmpList.size() > 0) {
                return "hadValue";
            } else {
                teaCode = user.getUserId();

                String year = jieqi.getJqYear().toString();
                jieQiYears = new ArrayList<JieQiYear>();
                jieQiYears.add(new JieQiYear(year, year));
                List<TJieqi> tmpJieqis = new ArrayList<TJieqi>();
                tmpJieqis.add(jieqi);
                qicis.put(year.toString(), tmpJieqis);
                expertTeachers = this.expertTeacherService.findAssignedExpertTeachers(jieqi.getJqId(), "01", teaCode);
                teachers = this.teacherService.getCommonTeachers(teaCode, "01");
                return SUCCESS;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }


    /**
     * TODO 生成分派专家团队页面(申报) authoy lzh
     */
    @Action(value = "PreAssignExpert", results = {
            @Result(name = "success", location = "/pages/expertTeam/assign_expert.jsp")
    })
    @SuppressWarnings("unchecked")
    public String preAssignExpert() throws Exception {
        try {
            // 学院主管老师的教职工号
            user = getSessionUser();
            if (user == null) {
                toLogin();
            }
            teaCode = user.getUserId();
            // 获取当前届期
            TJieqi jieqi = this.jieQiService.findCurrentJieQi();
            String year = jieqi.getJqYear().toString();
            jieQiYears = new ArrayList<JieQiYear>();
            jieQiYears.add(new JieQiYear(year, year));
            List<TJieqi> tmpJieqis = new ArrayList<TJieqi>();
            tmpJieqis.add(jieqi);
            qicis.put(year.toString(), tmpJieqis);
            // 专业
            professions = this.professionService
                    .findTProfessionsByTeaCode(teaCode);
            // 未分派的项目
            // 状态为02，获取未分派专家的申报列表
            this.totalNumber = this.declarationService.getUnitDeclarationCount(
                    teaCode, "02", "02");
            pageBean = new PageBean(page, totalNumber, pageCapacity);
            declarations = this.declarationService.getUnitDeclaration(
                    teaCode, "02", "02", pageBean);
            totalPage = pageBean.getTotalPage();
            // 本期次专家团队
            expertTeachers = this.expertTeacherService
                    .findAssignedExpertTeachers(jieqi.getJqId(), "01", teaCode);
            return SUCCESS;
        } catch (Exception e) {
            return ERROR;
        }
    }


    /**
     * TODO 结果录入页面生成
     */
    @Action(value = "PreResultTypeIn", results = {
            @Result(name = "success", location = "/pages/declarationManage/result_typein.jsp"),
            @Result(name = "message", location = "message_info.jsp")
    })
    public String listResultTypeIn() throws Exception {
        try {
            // page = 1;
            user = getSessionUser();
            if (user == null) {
                toLogin();
            }
            teacherCode = user.getUserId();
            // 获取当前届期
            TJieqi jieqi = this.jieQiService.findJieQiNow();

            if (null == jieqi) {
                messageInfo = "当前时间不是可以进行结果录入的时间段";
                return MESSAGE;
            }

            String year = jieqi.getJqYear().toString();
            jieQiYears = new ArrayList<JieQiYear>();
            jieQiYears.add(new JieQiYear(year, year));
            List<TJieqi> tmpJieqis = new ArrayList<TJieqi>();
            tmpJieqis.add(jieqi);
            qicis.put(year.toString(), tmpJieqis);
            // 专业
            professions = this.professionService
                    .findTProfessionsByTeaCode(teacherCode);
            // 结果录入页面，获取状态为03，已经分派专家的申报
            this.totalNumber = this.declarationService.getUnitDeclarationCount(
                    teacherCode, "03", "03");
            pageBean = new PageBean(page, totalNumber, pageCapacity);
            declarations = this.declarationService.getUnitDeclaration(
                    teacherCode, "03", "03", pageBean);
            totalPage = pageBean.getTotalPage();
            return SUCCESS;
        } catch (Exception e) {
            // TODO: handle exception
            return ERROR;
        }
    }


    /**
     * TODO 结果录入页面查询
     */
    @Action(value = "QueryResultTypeIn", results = {
            @Result(name = "success", location = "/pages/declarationManage/result_typein.jsp")
    })
    public String findResultTypeIn() throws Exception {
        try {
            // page = 1;
            //System.out.println("findResultTypeIn");
            user = getSessionUser();
            if (user == null) {
                toLogin();
            }
            teacherCode = user.getUserId();
            years = this.declarationService.findAllYears();
            jieQiYears = new ArrayList<JieQiYear>();
            for (Integer year : years) {
                jieQiYears.add(new JieQiYear(year.toString(), year.toString()));
                List<TJieqi> tmpJieqis = this.declarationService
                        .findJieqiByYear(year.toString());
                qicis.put(year.toString(), tmpJieqis);
            }
            // 专业
            professions = this.professionService
                    .findTProfessionsByTeaCode(teacherCode);
            this.totalNumber = this.declarationService
                    .findUnitDeclarationsCount(teacherCode, jqYear, qici,
                            profession, studentNumebr, checkState, proSerial,
                            proName);
            pageBean = new PageBean(page, totalNumber, pageCapacity);
            declarations = this.declarationService.findUnitDeclarations(
                    teacherCode, jqYear, qici, profession, studentNumebr,
                    checkState, proSerial, proName, pageBean);
            totalPage = pageBean.getTotalPage();
            return SUCCESS;
        } catch (Exception e) {
            // TODO: handle exception
            return ERROR;
        }
    }


    /**
     * 学院主管教师审核申报
     */
    @Action(value = "ResultTypeInSubmit")
    public void unitCheck() {
        try {
            String state = checkState;
            if (state.equals("yes")) {
                for (String project : checkProjects) {
                    TDeclaration declaration = this.declarationService
                            .getTDeclaration(project);
                    // 设置申报的状态为学院评审通过
                    declaration.setCheckState("05");
                    declaration.setReviewResult("01");// 设置评审结果为待审核
                    this.declarationService.updateTDeclaration(declaration);
                }
            }
            if (state.equals("no")) {
                for (String project : checkProjects) {
                    TDeclaration declaration = this.declarationService
                            .getTDeclaration(project);
                    // 设置申报的状态为学院评审通过
                    declaration.setCheckState("04");
                    declaration.setReviewResult("02");// 设置评审结果为不通过
                    this.declarationService.updateTDeclaration(declaration);
                }
            }
        } catch (Exception e) {
        }
    }


    @Action(value = "UnitAudit")
    /**
     * 学院领导审核
     */
    public void unitAudit() {
        try {
            //System.out.println("dkkdk");
            for (String project : checkProjects) {
                TDeclaration declaration = this.declarationService
                        .getTDeclaration(project);
                // 设置申报的状态为学院评审通过
                declaration.setCheckState("06");
                this.declarationService.updateTDeclaration(declaration);
            }
        } catch (Exception e) {
        }
    }


    @Action(value = "SchoolCheck")
    /**
     * 教务处主管教师审核申报
     */
    public void schoolCheck() {
        try {
            String state = checkState;
            String jqId = this.jieQiService.findCurrentJieQi().getJqId();
            if (state.equals("yes")) {
                for (String project : checkProjects) {
                    TDeclaration declaration = this.declarationService
                            .getTDeclaration(project);
                    // 设置申报的状态为学院评审通过
                    if (declaration.getCheckState().equals("06")) {
                        declaration.setCheckState("08");
                        declaration.setReviewResult("03");
                        this.declarationService.updateTDeclaration(declaration);
                    }
                }
                this.projectService.creatProject(jqId);

            }
            if (state.equals("no")) {
                for (String project : checkProjects) {
                    TDeclaration declaration = this.declarationService
                            .getTDeclaration(project);
                    // 设置申报的状态为学院评审通过
                    if (declaration.getCheckState().equals("06"))
                        declaration.setCheckState("07");
                    declaration.setReviewResult("02");
                    this.declarationService.updateTDeclaration(declaration);
                }
            }
        } catch (Exception e) {
        }
    }


    /**
     * 获取学院评审通过的申报
     */
    @Action(value = "UnitResultAudit", results = {
            @Result(name = "success", location = "/pages/declarationManage/result_audit.jsp"),
            @Result(name = "message", location = "message_info.jsp")
    })
    public String unitResultAudit() {
        try {
            // 主管教师教职工号
            user = getSessionUser();
            // 获取所在学院
            tunit = getSessionUnit();
            if (user == null || null == tunit) {
                toLogin();
            }
            teaCode = user.getUserId();


            // 申报的状态
            // checkState="05";

            // 获取当前届期
            TJieqi jieqi = this.jieQiService.findJieQiNow();
            if (null == jieqi) {
                messageInfo = "当前时间不是可以进行结果审核的时间段";
                return MESSAGE;
            }

            String year = jieqi.getJqYear().toString();
            jieQiYears = new ArrayList<JieQiYear>();
            jieQiYears.add(new JieQiYear(year, year));
            List<TJieqi> tmpJieqis = new ArrayList<TJieqi>();
            tmpJieqis.add(jieqi);
            qicis.put(year.toString(), tmpJieqis);
            professions = this.professionService
                    .findTProfessionsByTeaCode(teaCode);

            this.totalNumber = this.declarationService.getUnitDeclarationCount(
                    teaCode, "03", "05");
            pageBean = new PageBean(page, totalNumber, pageCapacity);
            declarations = this.declarationService.getUnitDeclaration(teaCode,
                    "03", "05", pageBean);
            return SUCCESS;
        } catch (Exception e) {
            return ERROR;
        }
    }

    /**
     * 添加一个教师
     */
    @Action(value = "AddTeacher", results = {
            @Result(name = "success", type = "json", params = {"contentType", "text/html", "includeProperties", "result"}),
            @Result(name = "error", type = "json", params = {"contentType", "text/html", "includeProperties", "result"})

    })
    public String addTeacher() throws Exception {
        try {
            // 获取学院主管教师的教职工号
            user = getSessionUser();
            if (user == null) {
                toLogin();
            }
            teaCode = user.getUserId();
            TTeacher teacher = new TTeacher();
            TUnit unit = this.teacherService.findTeacherByTeaCode(teaCode)
                    .getTUnit();// 根据学院老师获取其所在的单位
            teacher.setTUnit(unit);
            teacher.setTeaName(teacherName);
            teacher.setTeaCode(teacherCode);
            //
            if (teacherAge != null && !teacherAge.trim().equals("")) {
                teacher.setTeaAge(new Double(teacherAge));
            }
            teacher.setTeaSex(teacherSex);
            teacher.setTeaTitle(teacherTitle);
            teacher.setTeaTele(teacherTele);
            teacher.setTeaEmail(teacherEmail);
            teacher.setTeaIntro(teacherIntro);
            teacher.setTeaRemark(teacherRemark);
            // 设置未删除
            teacher.setIsdeleted("N");
            // 添加的老师的状态未设置
            this.teacherService.addTTeacher(teacher);

            // 保存用户信息
            TUser tUser = new TUser();
            tUser.setUserId(teacherCode);
            tUser.setUserName(teacherName);
            tUser.setUserType("04");
            tUser.setUserPassword("c4ca4238a0b923820dcc509a6f75849b");

            this.teacherService.addUsers(tUser);

            result = "yes";
            return SUCCESS;
        } catch (Exception e) {
            result = "no";
            return ERROR;
        }
    }


    @Action(value = "AssignExpert")
    /**
     * 分派评审专家
     */
    public void assignExpert() throws Exception {
        try {
            user = getSessionUser();
            if (user == null) {
                toLogin();
            }
            List<TExpertTeacher> tExpertTeacher;
            String teas[] = experts.split(",");
            // checkProjects申报ID
            for (int i = 0; i < checkProjects.length; i++) {
                tExpertTeacher = new ArrayList<TExpertTeacher>();
                for (int j = 0; j < teas.length; j++) {
                    String tea = teas[j].split("--")[1].trim();
                    System.out.println(tea);
                    TExpertTeacher teacher = this.expertTeacherService
                            .findExpTeaByCode(tea);// 根据专家教师ID获取一个对象
                    tExpertTeacher.add(teacher);
                }
                TDeclaration declaration = this.declarationService
                        .getTDeclaration(checkProjects[i]);// 根据项目ID获取一个申报对象
                this.expertReviewService.creatExpertReview(declaration,
                        tExpertTeacher);
            }
        } catch (Exception e) {
        }
    }


    /**
     * 生成组织评审页面
     */
    @Action(value = "PreOrganizeReview", results = {
            @Result(name = "success", location = "/pages/declarationManage/organize_review.jsp")
    })
    public String preOrganizeReview() throws Exception {
        try {
            user = getSessionUser();
            if (user == null) {
                toLogin();
            }
            teaCode = user.getUserId();

            TJieqi jieqi = jieQiService.findCurrentJieQi();
            String year = jieqi.getJqYear().toString();
            jieQiYears = new ArrayList<JieQiYear>();
            jieQiYears.add(new JieQiYear(year, year));
            List<TJieqi> tmpJieqis = new ArrayList<TJieqi>();
            tmpJieqis.add(jieqi);
            qicis.put(year.toString(), tmpJieqis);

            return SUCCESS;
        } catch (Exception e) {
            return ERROR;
        }
    }


    /**
     * 列出学院的所有申报专家团队
     */
    @Action(value = "ListUnitExperTeam", results = {
            @Result(name = "success", location = "/pages/expertTeam/expert_team_list.jsp")
    })
    public String listUnitExperTeam() throws Exception {
        try {
            // 学院主管教师的教职工号
            user = getSessionUser();
            if (user == null) {
                toLogin();
            }
            teaCode = user.getUserId();
            // 01为申报的专家团队
            totalNumber = this.expertLibService.findExpsCountByUnitTeaCode(
                    teaCode, "01");
            pageBean = new PageBean(page, totalNumber, pageCapacity);
            expertLibs = this.expertLibService.findExpsByUnitTeaCode(teaCode,
                    "01", pageBean);
            totalPage = pageBean.getTotalPage();
            return SUCCESS;
        } catch (Exception e) {
            return ERROR;
        }
    }


    @Action(value = "ListHistoryExpert", results = {
            @Result(name = "success", location = "/pages/expertTeam/unit_history_expert.jsp")
    })
    public String listHistoryExpert() throws Exception {
        try {
            user = getSessionUser();
            if (user == null) {
                toLogin();
            }
            teaCode = user.getUserId();
            totalNumber = this.expertTeacherService.getExpertTeachersByTeaCodeCount(teaCode, "01");
            pageBean = new PageBean(page, totalNumber, pageCapacity);
            expertTeachers = this.expertTeacherService
                    .getExpertTeachersByTeaCode(teaCode, "01", pageBean);
            totalPage = pageBean.getTotalPage();
            return SUCCESS;
        } catch (Exception e) {
            return ERROR;
        }
    }

    @Action(value = "FindHistoryExpert", results = {
            @Result(name = "success", location = "/pages/expertTeam/unit_history_expert.jsp")
    })
    public String findHistoryExpert() throws Exception {
        try {
            // 学院主管教师教职工号
            user = getSessionUser();
            if (user == null) {
                toLogin();
            }
            teaCode = user.getUserId();
            totalNumber = this.expertTeacherService.findExpertTeachersCount(teaCode, teacherName, teacherTitle, "01");
            pageBean = new PageBean(page, totalNumber, pageCapacity);
            expertTeachers = this.expertTeacherService.findExpertTeachers(
                    teaCode, teacherName, teacherTitle, "01", pageBean);
            totalPage = pageBean.getTotalPage();
            return SUCCESS;
        } catch (Exception e) {
            return ERROR;
        }
    }

    @Action(value = "CreateExpFromHistory", results = {
            @Result(name = "success", type = "json", params = {"contentType", "text/html", "includeProperties", "result"})
    })
    public String createExpFromHistory() throws Exception {
        try {
            user = getSessionUser();
            if (user == null) {
                toLogin();
            }

            // 获取当前申报届期
            TJieqi jieqi = this.jieQiService.findCurrentJieQi();
            // 获取当前届期对应的专家库
            List<TExpertLib> tmpList = this.expertTeacherService.findUnitExpertLibByJqid(jieqi.getJqId(), "01", user.getUserId());
            if (null != tmpList && tmpList.size() > 0) {
                // 获取当前届期对应的专家库
                //TExpertLib tExpertLib = this.expertLibService.findNowJieQiExpLib("01");
                TExpertLib tExpertLib = tmpList.get(0);
                List<TExpertTeacher> tExpertTeacher = new ArrayList<TExpertTeacher>();
                for (String teacodeStr : teacherCodes) {
                    TTeacher teacher = this.teacherService.findTeacherByTeaCode(teacodeStr);
                    TExpertTeacher exteacher = new TExpertTeacher();
                    exteacher.setTTeacher(teacher);

                    exteacher.setTExpertLib(tExpertLib);
                    exteacher.setIsdeleted("N");
                    tExpertTeacher.add(exteacher);
                }
                this.expertTeacherService.saveExpertTeacher(tExpertTeacher);
                result = "yes";
            } else {
                result = "noCurrentJieqi";
            }
            return SUCCESS;
        } catch (Exception e) {
            result = "error";
            return SUCCESS;
        }
    }


    @Action(value = "CreateExpertTeam")
    public void createExpertTeam() throws Exception {
        try {
            user = getSessionUser();
            if (user == null) {
                toLogin();
            }
            teaCode = user.getUserId();
            TTeacher creater = this.teacherService.findTeacherByTeaCode(teaCode); // 根据主管教师code获取其对象
            TJieqi jieqi = this.jieQiService.findTjieqiById(qici);// 获取届期对象
            // 专家库对象
            TExpertLib tLib = new TExpertLib();
            tLib.setTTeacher(creater);
            tLib.setCreatOn(new Timestamp(System.currentTimeMillis()));
            tLib.setTJieqi(jieqi);
            tLib.setIsdeleted("N");
            tLib.setType("01");
            tLib.setTUnit(creater.getTUnit());
            List<TExpertTeacher> tExpertTeacherList = new ArrayList<TExpertTeacher>();
            String teas[] = experts.split(",");
            for (int i = 0; i < teas.length; i++) {
                String tea = teas[i].split("--")[1].trim();
                //System.out.println(tea);
                TTeacher eTeacher = this.teacherService
                        .findTeacherByTeaCode(tea);// 根据教职工号获取教师对象
                TExpertTeacher exTeacher = new TExpertTeacher();
                exTeacher.setTTeacher(eTeacher);
                exTeacher.setIsdeleted("N");
                tExpertTeacherList.add(exTeacher);
            }
            // 01 用于标记临时邮件接收人的类型为申报的
            this.expertLibService
                    .creatExpertLib(tLib, tExpertTeacherList, "01");
        } catch (Exception e) {
            System.out.println("create expert team failed ");
            e.printStackTrace();
        }
    }


    /**
     * TODO 生成我的评审的页面
     */
    @Action(value = "PreMyReview", results = {
            @Result(name = "success", location = "/pages/expertTeam/my_review.jsp"),
            @Result(name = "message", location = "message_info.jsp")
    })
    public String preMyReview() throws Exception {
        try {

            // 评审教师教职号
            user = getSessionUser();
            if (user == null) {
                toLogin();
            }
            teacherCode = user.getUserId();
            // 获取当前届期
            TJieqi jieqi = this.jieQiService.findJieQiNow();
            Date now = new Date();
            if (jieqi == null) {
                messageInfo = "当前时间不是可以进行网评的时间段";
                return "message";
            } else {
                Date jtStart = jieqi.getStartOn();
                Date jtEnd = jieqi.getEndOn();
                if (now.getTime() < jtStart.getTime() || now.getTime() > jtEnd.getTime()) {
                    messageInfo = "当前时间不是可以进行网评的时间段";
                    return "message";
                }
            }
            String year = jieqi.getJqYear().toString();
            jieQiYears = new ArrayList<JieQiYear>();
            jieQiYears.add(new JieQiYear(year, year));
            List<TJieqi> tmpJieqis = new ArrayList<TJieqi>();
            tmpJieqis.add(jieqi);
            qicis.put(year.toString(), tmpJieqis);
            // 专业
            professions = this.professionService
                    .findTProfessionsByTeaCode(teacherCode);
            // 结果录入页面，获取状态为03，已经分派专家的申报
            this.totalNumber = this.declarationService
                    .getReviewTeaDeclarationCount(teacherCode);
            // totalNumber=1;
            pageBean = new PageBean(page, totalNumber, pageCapacity);
            listTDeclComment = this.declarationService.getReviewTeaDeclaration(
                    teacherCode, pageBean);
            totalPage = pageBean.getTotalPage();
            return SUCCESS;
        } catch (Exception e) {
            return ERROR;
        }
    }


    /**
     * 我的评审页面的查询
     */
    @Action(value = "FindInMyReview", results = {
            @Result(name = "success", location = "/pages/expertTeam/my_review.jsp"),
            @Result(name = "message", location = "message_info.jsp")
    })
    public String findInMyReview() throws Exception {
        try {
            // 评审教师教职号
            user = getSessionUser();
            if (user == null) {
                toLogin();
            }
            teacherCode = user.getUserId();
            // 获取当前届期
            TJieqi jieqi = this.jieQiService.findJieQiNow();
            if (jieqi == null) {
                messageInfo = "当前时间不是可以进行网评的时间段";
                return "message";
            }

            String year = jieqi.getJqYear().toString();
            jieQiYears = new ArrayList<JieQiYear>();
            jieQiYears.add(new JieQiYear(year, year));
            List<TJieqi> tmpJieqis = new ArrayList<TJieqi>();
            tmpJieqis.add(jieqi);
            qicis.put(year.toString(), tmpJieqis);
            // 专业
            professions = this.professionService
                    .findTProfessionsByTeaCode(teacherCode);
            // 结果录入页面，获取状态为03，已经分派专家的申报
            this.totalNumber = this.declarationService
                    .findReviewTeaDeclarationCount(teacherCode, proName,
                            jqYear, qici, profession, studentNumebr, compEval);
            pageBean = new PageBean(page, totalNumber, pageCapacity);
            listTDeclComment = this.declarationService
                    .findReviewTeaDeclaration(teacherCode, proName, jqYear,
                            qici, profession, studentNumebr, compEval, pageBean);
            totalPage = pageBean.getTotalPage();
            return SUCCESS;
        } catch (Exception e) {
            return ERROR;
        }
    }


    /**
     * 根据专家库ID查看专家库的专家教师
     */
    @Action(value = "ViewExpTea", results = {
            @Result(name = "success", location = "/pages/expertTeam/view_expert_team.jsp")
    })
    public String viewExpTea() throws Exception {
        try {
            user = getSessionUser();
            if (user == null) {
                toLogin();
            }
            totalNumber = this.expertTeacherService.findExpTeaCountByExpLibId(expLibId);
            pageBean = new PageBean(page, totalNumber, pageCapacity);
            expertTeachers = this.expertTeacherService.findExpTeaByExpLibId(
                    expLibId, pageBean);
            TExpertLib tExpertLib = this.expertLibService.getById(expLibId);
            jqYear = tExpertLib.getTJieqi().getJqYear().toString();
            qici = tExpertLib.getTJieqi().getQici();
            return SUCCESS;
        } catch (Exception e) {
            return ERROR;
        }
    }


    /**
     * 生成编辑学院专家团队页面
     */
    @Action(value = "PreUpdateExpTea", results = {
            @Result(name = "success", location = "/pages/expertTeam/update_expert_team.jsp")
    })
    @SuppressWarnings("unchecked")
    public String preUpdateExpTea() throws Exception {
        try {
            // 从session中获取教职工号
            user = getSessionUser();
            if (user == null) {
                toLogin();
            }
            teaCode = user.getUserId();
            // 01 为申报的专家教师，02为结题的专家教师
            teachers = this.teacherService.getCommonTeachers(teaCode, "01");
            expertTeachers = this.expertTeacherService.findExpTeaByExpLibId(expLibId);
            // 根据专家库id获取当前专家库
            tExpertLib = this.expertLibService.getById(expLibId);

            return SUCCESS;
        } catch (Exception e) {
            return ERROR;
        }
    }


    /**
     * TODO 编辑专家团队
     */
    @Action(value = "UpdateExpTeacher")
    public void updateExpTea() throws Exception {
        try {
            user = getSessionUser();
            if (user == null) {
                toLogin();
            }
            TExpertLib tLib = this.expertLibService.getById(expLibId);
            List<TExpertTeacher> tExpertTeacherList = new ArrayList<TExpertTeacher>();
            String teas[] = experts.split(",");
            for (int i = 0; i < teas.length; i++) {
                String tea = teas[i].split("--")[1].trim();
                TTeacher eTeacher = this.teacherService.findTeacherByTeaCode(tea);// 根据教职工号获取教师对象
                TExpertTeacher exTeacher = new TExpertTeacher();
                exTeacher.setTTeacher(eTeacher);
                exTeacher.setIsdeleted("N");
                tExpertTeacherList.add(exTeacher);
            }
            this.expertLibService.updateExperLib(tLib, tExpertTeacherList, "01");

        } catch (Exception e) {

        }
    }


    /**
     * 删除专家团队
     */
    @Action(value = "DeleteExpertLib", results = {
            @Result(name = "success", type = "redirect", location = "ListUnitExperTeam")
    })
    public String deleteExpertLib() throws Exception {
        try {
            user = getSessionUser();
            if (user == null) {
                toLogin();
            }
            TExpertLib tExpertLib = this.expertLibService.getById(expLibId);
            this.expertLibService.deleteExperLib(tExpertLib);
            return SUCCESS;
        } catch (Exception e) {
            return ERROR;
        }
    }


    /**
     * 评审意见
     */
    @Action(value = "ReviewOpinion", results = {
            @Result(name = "success", type = "redirect", location = "PreResultTypeIn")
    })
    public String reviewOpinion() throws Exception {
        try {
            user = getSessionUser();
            if (user == null) {
                toLogin();
            }
            TDeclaration tDeclaration = this.declarationService
                    .getTDeclaration(declarId);
            tDeclaration.setReviewOpinion(opinion);
            this.declarationService.updateTDeclaration(tDeclaration);
            return SUCCESS;
        } catch (Exception e) {
            System.out.println("add review opinion falie " + e);
            return ERROR;
        }
    }


    @Action(value = "AddComments", results = {
            @Result(name = "success", location = "/index.jsp"),
            @Result(name = "message", location = "message_info.jsp")
    })
    public String addComments() throws Exception {
        try {
            user = getSessionUser();
            if (user == null) {
                toLogin();
            }
            teaCode = user.getUserId();
            // 申报对象
            // TDeclaration tDeclaration =
            // this.declarationService.getTDeclaration(Id);
            // 届期
            TJieqi jieqi = this.jieQiService.findJieQiNow();
            if (jieqi == null) {
                messageInfo = "当前时间不是可以进行网评的时间段";
                return MESSAGE;
            }
            TExpertReview tExpertReview = this.expertReviewService
                    .getTExpertReview(jieqi.getJqId(), teaCode, declarId, "01");
            // 评审意见内容
            //TDeclComment tDeclComment = declComment;
            //tDeclComment.setTExpertReview(tExpertReview);
            //this.expertTeacherService.addTDeclComment(declComment);
            TDeclComment tDeclComment = expertReviewService.geTDeclCommentByTexpertReview(tExpertReview.getExReviewId());
            tDeclComment.setCompEval(declComment.getCompEval());
            tDeclComment.setDeclScore(declComment.getDeclScore());
            tDeclComment.setDeclArgument(declComment.getDeclArgument());

            return SUCCESS;
        } catch (Exception e) {
            System.out.println("decLconment exception: " + e.toString());
            return ERROR;
        }
    }


    /**
     * ***************************
     * set and get methods
     * ***************************
     */

    public DeclarationService getDeclarationService() {
        return declarationService;
    }

    public void setDeclarationService(DeclarationService declarationService) {
        this.declarationService = declarationService;
    }

    public String getTeaCode() {
        return teaCode;
    }

    public void setTeaCode(String teaCode) {
        this.teaCode = teaCode;
    }

    public List<Integer> getYears() {
        return years;
    }

    public void setYears(List<Integer> years) {
        this.years = years;
    }

    public List<JieQiYear> getJieQiYears() {
        return jieQiYears;
    }

    public void setJieQiYears(List<JieQiYear> jieQiYears) {
        this.jieQiYears = jieQiYears;
    }

    public List<TTeacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<TTeacher> teachers) {
        this.teachers = teachers;
    }

    public Map<String, List<TJieqi>> getQicis() {
        return qicis;
    }

    public void setQicis(Map<String, List<TJieqi>> qicis) {
        this.qicis = qicis;
    }

    public List<TExpertTeacher> getExpertTeachers() {
        return expertTeachers;
    }

    public void setExpertTeachers(List<TExpertTeacher> expertTeachers) {
        this.expertTeachers = expertTeachers;
    }

    public String getJqYear() {
        return jqYear;
    }

    public void setJqYear(String jqYear) {
        this.jqYear = jqYear;
    }

    public String getQici() {
        return qici;
    }

    public void setQici(String qici) {
        this.qici = qici;
    }

    public ExpertLibService getExpertLibService() {
        return expertLibService;
    }

    public void setExpertLibService(ExpertLibService expertLibService) {
        this.expertLibService = expertLibService;
    }

    public ExpertTeacherService getExpertTeacherService() {
        return expertTeacherService;
    }

    public void setExpertTeacherService(
            ExpertTeacherService expertTeacherService) {
        this.expertTeacherService = expertTeacherService;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherTitle() {
        return teacherTitle;
    }

    public void setTeacherTitle(String teacherTitle) {
        this.teacherTitle = teacherTitle;
    }

    public String[] getTeacherCodes() {
        return teacherCodes;
    }

    public void setTeacherCodes(String[] teacherCodes) {
        this.teacherCodes = teacherCodes;
    }

    public String getExperts() {
        return experts;
    }

    public void setExperts(String experts) {
        this.experts = experts;
    }

    public TeacherService getTeacherService() {
        return teacherService;
    }

    public void setTeacherService(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    public JieQiService getJieQiService() {
        return jieQiService;
    }

    public void setJieQiService(JieQiService jieQiService) {
        this.jieQiService = jieQiService;
    }

    public List<TProfession> getProfessions() {
        return professions;
    }

    public void setProfessions(List<TProfession> professions) {
        this.professions = professions;
    }

    public ProfessionService getProfessionService() {
        return professionService;
    }

    public void setProfessionService(ProfessionService professionService) {
        this.professionService = professionService;
    }

    public ProjectService getProjectService() {
        return projectService;
    }

    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }

    public String[] getCheckProjects() {
        return checkProjects;
    }

    public void setCheckProjects(String[] checkProjects) {
        this.checkProjects = checkProjects;
    }

    public List<TDeclaration> getDeclarations() {
        return declarations;
    }

    public void setDeclarations(List<TDeclaration> declarations) {
        this.declarations = declarations;
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

    public List<TExpertLib> getExpertLibs() {
        return expertLibs;
    }

    public void setExpertLibs(List<TExpertLib> expertLibs) {
        this.expertLibs = expertLibs;
    }

    public ExpertReviewService getExpertReviewService() {
        return expertReviewService;
    }

    public void setExpertReviewService(ExpertReviewService expertReviewService) {
        this.expertReviewService = expertReviewService;
    }

    public String getCheckState() {
        return checkState;
    }

    public void setCheckState(String checkState) {
        this.checkState = checkState;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getProSerial() {
        return proSerial;
    }

    public void setProSerial(String proSerial) {
        this.proSerial = proSerial;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getStudentNumebr() {
        return studentNumebr;
    }

    public void setStudentNumebr(String studentNumebr) {
        this.studentNumebr = studentNumebr;
    }

    public String getTeacherEmail() {
        return teacherEmail;
    }

    public void setTeacherEmail(String teacherEmail) {
        this.teacherEmail = teacherEmail;
    }

    public String getTeacherAge() {
        return teacherAge;
    }

    public void setTeacherAge(String teacherAge) {
        this.teacherAge = teacherAge;
    }

    public String getTeacherSex() {
        return teacherSex;
    }

    public void setTeacherSex(String teacherSex) {
        this.teacherSex = teacherSex;
    }

    public String getTeacherTele() {
        return teacherTele;
    }

    public void setTeacherTele(String teacherTele) {
        this.teacherTele = teacherTele;
    }

    public String getTeacherRemark() {
        return teacherRemark;
    }

    public void setTeacherRemark(String teacherRemark) {
        this.teacherRemark = teacherRemark;
    }

    public String getTeacherIntro() {
        return teacherIntro;
    }

    public void setTeacherIntro(String teacherIntro) {
        this.teacherIntro = teacherIntro;
    }

    public String getTeacherCode() {
        return teacherCode;
    }

    public void setTeacherCode(String teacherCode) {
        this.teacherCode = teacherCode;
    }

    public TDeclComment getDeclComment() {
        return declComment;
    }

    public void setDeclComment(TDeclComment declComment) {
        this.declComment = declComment;
    }

    public List<TDeclComment> getListTDeclComment() {
        return listTDeclComment;
    }

    public void setListTDeclComment(List<TDeclComment> listTDeclComment) {
        this.listTDeclComment = listTDeclComment;
    }

    public String getExpLibId() {
        return expLibId;
    }

    public void setExpLibId(String expLibId) {
        this.expLibId = expLibId;
    }

    public String getDeclarId() {
        return declarId;
    }

    public void setDeclarId(String declarId) {
        this.declarId = declarId;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }

    public String getReviewResult() {
        return reviewResult;
    }

    public void setReviewResult(String reviewResult) {
        this.reviewResult = reviewResult;
    }

    public String getCompEval() {
        return compEval;
    }

    public void setCompEval(String compEval) {
        this.compEval = compEval;
    }

    public void setEndProjects(List<TEndProject> endProjects) {
        this.endProjects = endProjects;
    }

    public void setEndProjectService(EndProjectService endProjectService) {
        this.endProjectService = endProjectService;
    }

    public List<TEndProject> getEndProjects() {
        return endProjects;
    }

    public void setEndProjectExportService(
            EndProjectExportService endProjectExportService) {
        this.endProjectExportService = endProjectExportService;
    }

    public List<TEndProjectComment> getEndProjectComments() {
        return endProjectComments;
    }

    public void setEndProjectComments(
            List<TEndProjectComment> endProjectComments) {
        this.endProjectComments = endProjectComments;
    }

    public TDeclCommentDAO gettDeclCommentDAO() {
        return tDeclCommentDAO;
    }

    public void settDeclCommentDAO(TDeclCommentDAO tDeclCommentDAO) {
        this.tDeclCommentDAO = tDeclCommentDAO;
    }

    public String getEndProjectCommentsId() {
        return endProjectCommentsId;
    }

    public void setEndProjectCommentsId(String endProjectCommentsId) {
        this.endProjectCommentsId = endProjectCommentsId;
    }

    public TEndProjectComment getEndProjectComment() {
        return endProjectComment;
    }

    public void setEndProjectComment(TEndProjectComment endProjectComment) {
        this.endProjectComment = endProjectComment;
    }

    public TUser getUser() {
        return user;
    }

    public void setUser(TUser user) {
        this.user = user;
    }

    public EndProjectProperty getProperty() {
        return property;
    }

    public void setProperty(EndProjectProperty property) {
        this.property = property;
    }

    public TUser gettUser() {
        return tUser;
    }

    public void settUser(TUser tUser) {
        this.tUser = tUser;
    }

    public List<TAttachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<TAttachment> attachments) {
        this.attachments = attachments;
    }

    public String getMessageInfo() {
        return messageInfo;
    }

    public void setMessageInfo(String messageInfo) {
        this.messageInfo = messageInfo;
    }

    public List<TEndProjectExport> getEndProjectExports() {
        return endProjectExports;
    }

    public void setEndProjectExports(List<TEndProjectExport> endProjectExports) {
        this.endProjectExports = endProjectExports;
    }

    public String getEndprojectId() {
        return endprojectId;
    }

    public void setEndprojectId(String endprojectId) {
        this.endprojectId = endprojectId;
    }

    public TUnit getTunit() {
        return tunit;
    }

    public void setTunit(TUnit tunit) {
        this.tunit = tunit;
    }

    public EndProjectService getEndProjectService() {
        return endProjectService;
    }

    public EndProjectExportService getEndProjectExportService() {
        return endProjectExportService;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public TExpertLib getTExpertLib() {
        return tExpertLib;
    }

    public void setTExpertLib(TExpertLib tExpertLib) {
        this.tExpertLib = tExpertLib;
    }

}
