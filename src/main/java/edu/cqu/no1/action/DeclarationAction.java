package edu.cqu.no1.action;


import edu.cqu.no1.datamodel.JieQiYear;
import edu.cqu.no1.domain.*;
import edu.cqu.no1.service.*;
import edu.cqu.no1.util.FileUtility;
import edu.cqu.no1.util.PageBean;
import edu.cqu.no1.util.mail.MailInfo;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller

@Namespace("/")
@Scope("prototype")
@ParentPackage("base")
public class DeclarationAction extends BaseAction {

    @Resource
    private DeclarationService declarationService;
    @Resource
    private ProfessionService professionService;
    @Resource
    private JieQiService jieQiService;

    private TDeclaration declaration;
    private List<TStudent> students = new ArrayList<TStudent>();
    private List<TTeacher> teachers = new ArrayList<TTeacher>();
    private String studentNums;
    private String teacherName;
    private String groupCodes;
    private String teacherCodes;
    private String groupWork;
    private String projectFund;
    private String declarationId;
    private String attachementId;
    private List<TDeclaration> declarations;
    private List<TAttachment> attachments;
    private Map<String, List<TJieqi>> qicis = new HashMap<String, List<TJieqi>>();
    private List<Integer> years;
    private List<JieQiYear> jieQiYears;
    private List<TProfession> professions;

    // 上传文件 数组
    private File[] files;
    private String[] filesContentType;
    private String[] filesFileName;

    //信息提示
    private String messageInfo;
    /**
     * 学院查询申报用的参数
     */
    private String jqQici;//得到届期ID
    private String checkState;
    private String jqYear;
    private String profession;
    private String proSerial; //项目编号
    private String proName;   //项目名称
    private String college; //学院名称
    private String collgegId;
    private List<TExpertTeacher> expertTeachers;

    @Resource
    private ExpertTeacherService expertTeacherService;
    /**
     * 分页使用的参数
     */
    private int page = 1; // 初始页面
    private PageBean pageBean; // 分页用的bean
    private int totalPage = 1; // 总页面数
    private int totalNumber = 0; // 总数据条数s
    private int pageCapacity = 14; // 每页显示条数

    private String studentId;
    private List<TDeclaration> listDeclaration;

    private List<TDeclJob> listTDeclJob;
    private List<TDeclFund> listTDeclFund;
    private String Id;
    private String addStudentNumber;
    private String result;


    @Action(value = "findStudentsByNumber", results = {
            @Result(name = "success", type = "json", params = {"root", "students", "excludeNullProperties", "true"})
    })
    public String findStudentsByNumbers() {
        if (null != this.studentNums && !"".equals(this.studentNums)) {
            this.students = this.declarationService.getStudentsByNumber(studentNums);
        }
        this.studentNums = "";
        return SUCCESS;
    }


    @Action(value = "findTeachersByName", results = {
            @Result(name = "success", type = "json", params = {"root", "teachers", "excludeNullProperties", "true"})
    })
    public String findTeachersByName() {
        if (null != this.teacherName && !"".equals(this.teacherName)) {
            this.teachers = this.declarationService.getTeachersByName(teacherName);
        }
        this.teacherName = "";
        return SUCCESS;
    }


    /**
     * 判断输入的学号是否已经参与其他SRTP项目
     */
    @Action(value = "CheckIsInDeclaration", results = {
            @Result(name = "success", type = "json", params = {"contentType", "text/html", "includeProperties", "result"})
    })
    public String checkIsInDeclaration() throws Exception {
        if (null != addStudentNumber && !"".equals(addStudentNumber.trim())) {
            try {
                boolean foo = this.declarationService.checkHadReqDecla(addStudentNumber);
                if (foo) {
                    result = "yes";
                } else {
                    result = "no";
                }

                return SUCCESS;
            } catch (Exception e) {
                result = ERROR;

                return ERROR;
            }
        } else {
            result = "noValue";
        }

        return result;
    }


    /**
     * 生成申请申报页面
     */
    @Action(value = "preAddDeclaration", results = {
            @Result(name = "success", location = "/pages/declarationManage/declaration_add.jsp"),
            @Result(name = "message", location = "message_info.jsp")
    })
    public String preAddDeclaration()  {
        try {
            TUser user = getSessionUser();
            if (user == null || user.getUserId() == null
                    || user.getUserId().equals("")) {
                toLogin();
            } else {
                String stuNumber = user.getUserId();
                //判断是否在申请申报的时间内
                TJieqi jieqi = this.jieQiService.findCurrentJieQi();
                if (jieqi == null) {
                    messageInfo = "当前时间不能够申报项目！";
                    return MESSAGE;
                } else {
                    boolean dec = this.declarationService.checkHadReqDecla(stuNumber);
                    if (dec) {
                        messageInfo = "本期 您已经参与其他项目的申报，不能再申报！";
                        return MESSAGE;
                    }
                }
                return SUCCESS;
            }

        } catch (Exception e) {
            return ERROR;
        }
        return SUCCESS;
    }


    /**
     * 生成审核结果录入页面
     */
    @Action(value = "PreResultTypeIn", results = {
            @Result(name = "success", location = "/pages/declarationManage/result_typein.jsp"),
            @Result(name = "message", location = "message_info.jsp")
    })
    public String preResultTypeIn(){
        try {
            TUser user = getSessionUser();
            if (user == null || user.getUserId() == null
                    || user.getUserId().equals("")) {
                toLogin();
            } else {
               /* String stuNumber = user.getUserId();
                //判断是否在申请申报的时间内
                TJieqi jieqi = this.jieQiService.findCurrentJieQi();
                if (jieqi == null) {
                    messageInfo = "当前时间不能够申报项目！";
                    return MESSAGE;
                } else {
                    boolean dec = this.declarationService.checkHadReqDecla(stuNumber);
                    if (dec) {
                        messageInfo = "本期 您已经参与其他项目的申报，不能再申报！";
                        return MESSAGE;
                    }
                }*/
                getJieQiAndPro(user.getUserId());


                return SUCCESS;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
        return SUCCESS;
    }


    @Action(value = "CheckHadDeclaration", results = {
            @Result(name = "success", type = "json", params = {"contentType", "text/html", "includeProperties", "result"})

    })
    public String checkHadDeclaration() throws Exception {
        try {
            TUser user = getSessionUser();
            if (user == null) {
                toLogin();
                return ERROR;
            } else {
                String stuNumber = user.getUserId();
                boolean dec = this.declarationService.checkHadReqDecla(stuNumber);
                if (dec) {
                    result = "yes";

                } else {
                    result = "no";
                }

                return SUCCESS;
            }
        } catch (Exception e) {
            return ERROR;
        }
    }


    @Action(value = "addDeclaration", results = {
            @Result(name = "success", type = "json", params = {"root", "Id"})
    })
    public String addDeclaration() {
        try {
            TUser user = getSessionUser();
            if (user == null) {
                toLogin();
            }
            if (files != null && files.length > 0) {
                addDeclarationAndFile(files, filesFileName, filesContentType, user,
                        declaration, groupCodes, teacherCodes, groupWork,
                        projectFund);
            }
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    //添加申报的帮助方法
    public void addDeclarationAndFile(File[] files, String[] fileNames,
                                      String[] fileContentType, TUser user, TDeclaration declaration, String groupCodes, String teacherCodes, String groupWork,
                                      String projectFund)
            throws RuntimeException {
        try {
            if (files != null && fileNames != null && fileContentType != null
                    && files.length == fileNames.length
                    && fileNames.length == fileContentType.length) {
                List<String> fileUris = FileUtility.SaveFiles(files, fileNames,
                        fileContentType);
                if (fileUris != null && fileUris.size() > 0) {
                    List<TAttachment> tAttachments = new ArrayList<TAttachment>();
                    for (int i = 0; i < fileUris.size(); i++) {
                        TAttachment tAttachment = new TAttachment();
                        tAttachment.setFileName(fileNames[i]);
                        tAttachment.setFileFormat(fileContentType[i]);
                        tAttachment.setFileSize(new Double(files[i].length()));
                        tAttachment.setFileUrl(fileUris.get(i));
                        tAttachment.setTUser(user);
                        tAttachments.add(tAttachment);
                    }
                    TStudent student = (TStudent) this.declarationService.getStudentsByNumber(user.getUserId()).get(0);
                    groupCodes = groupCodes.replace("," + student.getStudentId(), "").replace(student.getStudentId() + ",", "");
                    groupCodes = student.getStudentId() + "," + groupCodes;
                    this.declaration = this.declarationService.addDeclaration(tAttachments, declaration, groupCodes, teacherCodes, groupWork, projectFund);
                    Id = declaration.getDeclarId();
                }
            }
        } catch (RuntimeException re) {
            re.printStackTrace();
            throw re;
        }
    }


    /**
     * 发布已经保存的申报
     * @return
     */
    @Action(value = "commitSavedDeclaration", results = {
            @Result(name = "success", type = "redirect", location = "ListDeclaration")
    })
    public String commitSavedDeclaration() {
        try {
            TUser tUser = getSessionUser();
            if(tUser == null){
                toLogin();
            }
            declaration = this.declarationService.getTDeclaration(Id);
            declaration.setCheckState("02");
            this.declarationService.updateTDeclaration(declaration);

            return SUCCESS;
        } catch (Exception e) {
            System.out.println("list Unit Declaration failed:" + e);
            e.printStackTrace();
            return ERROR;
        }
    }


    /**
     * 获取学生个人申报列表
     * @return
     * @throws Exception
     */
    @Action(value = "ListDeclaration", results = {
            @Result(name = "success", location = "/pages/declarationManage/declaration_list.jsp")
    })
    public String listDeclaration() throws Exception {
        try {
            TUser tUser = getSessionUser();
            if (tUser == null || tUser.getUserId() == null
                    || tUser.getUserId().equals("")) {
                toLogin();
            }
            String studentId = tUser.getUserId();

            this.totalNumber = this.declarationService.getAllTDeclarationCount(studentId);

            // 构造分页对象
            pageBean = new PageBean(page, totalNumber, pageCapacity);
            listDeclaration = this.declarationService.getAllTDeclaration(pageBean, studentId);

            totalPage = this.pageBean.getTotalPage();
            return SUCCESS;
        } catch (Exception e) {

            System.out.println("list exception: " + e.toString());
            return ERROR;
        }
    }


    /**
     * 获取教师个人申报列表
     */
    @Action(value = "ListTeaPersonalDeclaration", results = {
            @Result(name = "success", location = "/pages/declarationManage/teaPersonal_declaration_list.jsp")
    })
    public String listTeaPersonalDeclaration() throws Exception {
        try {
            TUser tUser = getSessionUser();
            if (tUser == null || tUser.getUserId() == null
                    || tUser.getUserId().equals("")) {
                toLogin();
            }
            String teaCode = tUser.getUserId();

            this.totalNumber = this.declarationService.getTeaDeclarationCount(teaCode);

            // 构造分页对象
            pageBean = new PageBean(page, totalNumber, pageCapacity);
            declarations = this.declarationService.getTeaDeclaration(teaCode, pageBean);
            totalPage = this.pageBean.getTotalPage();
            return SUCCESS;
        } catch (Exception e) {
            return ERROR;
        }
    }


    /**
     * 条件查询教师个人申报列表
     * @return
     * @throws Exception
     */
    @Action(value = "FindTeaPersonalDeclaration", results = {
            @Result(name = "success", location = "/pages/declarationManage/teaPersonal_declaration_list.jsp")
    })
    public String findTeaPersonalDeclaration() throws Exception {
        try {
            TUser tUser = getSessionUser();
            if (tUser == null || tUser.getUserId() == null
                    || tUser.getUserId().equals("")) {
                toLogin();
            }
            String teaCode = tUser.getUserId();

            this.totalNumber = this.declarationService.findTeaDeclarationCount(teaCode, proName, studentNums);

            // 构造分页对象
            pageBean = new PageBean(page, totalNumber, pageCapacity);
            declarations = this.declarationService.findTeaDeclaration(teaCode, proName, studentNums, pageBean);

            totalPage = this.pageBean.getTotalPage();
            return SUCCESS;
        } catch (Exception e) {
            return ERROR;
        }
    }



    /**
     * 列出学院的申报列表
     */
    @Action(value = "ListUnitDeclaration", results = {
            @Result(name = "success", location = "/pages/declarationManage/unit_declaration_list.jsp"),
    })
    public String listUnitDeclaration() throws Exception {
        try {
            TUser tUser = getSessionUser();
            if (tUser == null) {
                toLogin();
            }
            String teaCode = tUser.getUserId();
            //TJieqi tJieqi = this.jieQiService.findCurrentJieQi();
            totalNumber = this.declarationService.getUnitDeclarationCount(teaCode, "02", "09");
            pageBean = new PageBean(page, totalNumber, pageCapacity);
            declarations = this.declarationService.getUnitDeclaration(teaCode, "02", "09", pageBean);
            totalPage = pageBean.getTotalPage();
            getJieQiAndPro(teaCode);
            return SUCCESS;
        } catch (Exception e) {
            System.out.println("list Unit Declaration failed:" + e);
            e.printStackTrace();
            return ERROR;
        }
    }


    /**
     * 查询学院的申报列表
     */
    @Action(value = "QueryUnitDeclaration", results = {
            @Result(name = "success", location = "/pages/declarationManage/unit_declaration_list.jsp"),
    })
    public String findUnitDeclaration() throws Exception {
        try {
            //学院主管老师的教职工号
            TUser tUser = getSessionUser();
            if (tUser == null || tUser.getUserId() == null
                    || tUser.getUserId().equals("")) {
                toLogin();
            }
            String teaCode = tUser.getUserId();
            this.totalNumber = this.declarationService.findUnitDeclarationsCount(teaCode, jqYear, jqQici, profession, studentNums, checkState, proSerial, proName);
            pageBean = new PageBean(page, totalNumber, pageCapacity);
            declarations = this.declarationService.findUnitDeclarations(teaCode, jqYear, jqQici, profession, studentNums, checkState, proSerial, proName, pageBean);
            totalPage = pageBean.getTotalPage();
            getJieQiAndPro(teaCode);
            return SUCCESS;
        } catch (Exception e) {
            //throw e;
            return ERROR;
        }


    }

    /**
     * 全校SRTP项目申报列表   教务处查看
     * @return
     * @throws Exception
     */
    @Action(value = "SchoolDeclaration", results = {
            @Result(name = "success", location = "/pages/declarationManage/schoolDeclaration.jsp")
    })
    public String schoolDeclaration() throws Exception {
        try {
            //TJieqi jieqi = this.jieQiService.findCurrentJieQi();
            //String checkState1 = "06";
            totalNumber = this.declarationService.getSchoolDeclarationCount("02", "09");
            pageBean = new PageBean(page, totalNumber, pageCapacity);
            declarations = this.declarationService.getSchoolDeclaration("02", "09", pageBean);
            totalPage = pageBean.getTotalPage();
            getJieQiAndPro();
            return SUCCESS;
        } catch (Exception e) {
            return ERROR;
        }
    }


    /**
     * 全校SRTP项目申报列表   教务处筛选查看
     */
    @Action(value = "FindSchoolDeclaration", results = {
            @Result(name = "success", location = "/pages/declarationManage/schoolDeclaration.jsp")
    })
    public String findSchoolDeclaration() throws Exception {
        try {

            totalNumber = this.declarationService.findSchoolDeclarationCount(proName, jqYear, jqQici, checkState, college);
            pageBean = new PageBean(page, totalNumber, pageCapacity);
            declarations = this.declarationService.findSchoolDeclaration(proName, jqYear, jqQici, checkState, college, pageBean);
            totalPage = pageBean.getTotalPage();
            getJieQiAndPro();
            return SUCCESS;
        } catch (Exception e) {
            return ERROR;
        }
    }

    /**
     * 在分派评审专家页面上查询申报
     */
    @Action(value = "QueryDeclaAssignExp", results = {
            @Result(name = "success", location = "/pages/expertTeam/assign_expert.jsp")
    })
    public String findAssignExpertDeclaration() throws Exception {
        try {
            //学院主管老师的教职工号
            TUser tUser = getSessionUser();
            if (tUser == null || tUser.getUserId() == null
                    || tUser.getUserId().equals("")) {
                toLogin();
            }
            String teaCode = tUser.getUserId();
            TJieqi jieqi = this.jieQiService.findCurrentJieQi();
            this.totalNumber = this.declarationService.findUnitDeclarationsCount(teaCode, jqYear, jqQici, profession, studentNums, checkState, proSerial, proName);
            pageBean = new PageBean(page, totalNumber, pageCapacity);
            declarations = this.declarationService.findUnitDeclarations(teaCode, jqYear, jqQici, profession, studentNums, checkState, proSerial, proName, pageBean);
            totalPage = pageBean.getTotalPage();
            getJieQiAndPro(teaCode);
            expertTeachers = this.expertTeacherService.findAssignedExpertTeachers(jieqi.getJqId(), "01", teaCode);
            return SUCCESS;
        } catch (Exception e) {
            //throw e;
            return ERROR;
        }
    }


    /**
     * 生成教务处申报结果列表页面
     */
    @Action(value = "ListSchoolDeclaration", results = {
            @Result(name = "success", location = "/pages/declarationManage/school_declaration_list.jsp")
    })
    public String listSchoolDeclaration() throws Exception {
        try {
            totalNumber = this.declarationService.getSchoolDeclarationCount("06", "06");
            pageBean = new PageBean(page, totalNumber, pageCapacity);
            declarations = this.declarationService.getSchoolDeclaration("06", "06", pageBean);
            totalPage = pageBean.getTotalPage();
            getJieQiAndPro();
            return SUCCESS;
        } catch (Exception e) {
            return ERROR;
        }
    }



    //学校申报列表的年份和期次
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
        for (Integer year : years) {
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

    //学院申报列表页面的年份，期次，专业
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
        for (Integer year : years) {
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



    /**
     * 网评
     * @return
     * @throws Exception
     */
    @Action(value = "OnlineComments", results = {
            @Result(name = "success", location = "/pages/expertTeam/online_comments.jsp")
    })
    public String viewDeclaration() throws Exception {
        try {
            declaration = this.declarationService.getTDeclaration(Id);
            listTDeclJob = this.declarationService.getTDeclJob(Id);
            listTDeclFund = this.declarationService.getTDeclFund(Id);
            attachments = this.declarationService.getAttachmentByDeclarId(Id);
            return SUCCESS;
        } catch (Exception e) {
            return ERROR;
        }
    }


    /**
     * 更新申报
     * @return
     * @throws Exception
     */
    @Action(value = "UpdateDeclaration", results = {
            @Result(name = "input", location = "/pages/declarationManage/declaration_edit.jsp"),
            @Result(name = "success", type = "redirect", location = "ListDeclaration"),
    })
    public String updateDeclaration() throws Exception {
        try {
            TUser user = getSessionUser();
            if (user == null || user.getUserId() == null
                    || user.getUserId().equals("")) {
                toLogin();
            }
            if (files != null && files.length > 0) {
                if (files != null && filesFileName != null
                        && filesContentType != null
                        && files.length == filesFileName.length
                        && filesFileName.length == filesContentType.length) {
                    List<TAttachment> tAttachments = this.declarationService.getAttachmentByDeclarId(declarationId);
                    for (TAttachment tAttachment : tAttachments) {
                        FileUtility.DeleteFile(tAttachment.getFileUrl());
                    }
                    List<String> fileUris = FileUtility.SaveFiles(files,
                            filesFileName, filesContentType);
                    if (fileUris != null && fileUris.size() > 0) {
                        List<TAttachment> newAttachments = new ArrayList<TAttachment>();
                        for (int i = 0; i < fileUris.size(); i++) {
                            TAttachment tAttachment = new TAttachment();
                            tAttachment.setFileName(filesFileName[i]);
                            tAttachment.setFileFormat(filesContentType[i]);
                            tAttachment.setFileSize(new Double(files[i].length()));
                            tAttachment.setFileUrl(fileUris.get(i));
                            tAttachment.setTUser(user);
                            newAttachments.add(tAttachment);
                        }
                        this.declaration = this.declarationService
                                .updateDeclaration(newAttachments, user, declaration,
                                        groupCodes, teacherCodes, groupWork,
                                        projectFund);
                    }
                }
            } else {
                this.declaration = this.declarationService.updateDeclaration(
                        declaration, groupCodes, teacherCodes, groupWork,
                        projectFund);
            }
            return SUCCESS;
        } catch (Exception e) {
            System.out.println("update exception: " + e.toString());
            return ERROR;
        }
    }


    /**
     * 删除申报
     * @return
     * @throws Exception
     */
    @Action(value = "DeleteUnitDeclaration", results = {
            @Result(name = "success", type = "redirect", location = "ListUnitDeclaration")
    })
    public String deleteDeclaration() throws Exception {
        try {
            this.declarationService.deleteTDeclaration(Id);
            return SUCCESS;
        } catch (Exception e) {
            return ERROR;
        }
    }


    /**
     * 下载申报附件
     * @return
     * @throws Exception
     */
    @Action(value = "downLoadAttachment", results = {
            @Result(name = "success", type = "stream")
    })
    public String downLoadAttachment() throws Exception {
        TAttachment tAttachment = this.declarationService.getAttachmentById(attachementId);
        try {
            if (tAttachment == null) {
                return ERROR;
            }
            FileUtility.doDownload(tAttachment.getFileUrl(), tAttachment.getFileName());
        } catch (RuntimeException re) {
            re.printStackTrace();
            throw re;
        }
        return SUCCESS;
    }


    @JSON(serialize = false)
    public String getStudentNums() {
        return studentNums;
    }

    public void setStudentNums(String studentNums) {
        this.studentNums = studentNums;
    }

    @JSON(serialize = false)
    public String getTeacherName() {
        return teacherName;
    }


    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public List<TStudent> getStudents() {
        return students;
    }

    public void setStudents(List<TStudent> students) {
        this.students = students;
    }

    public List<TTeacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<TTeacher> teachers) {
        this.teachers = teachers;
    }

    public void setDeclarationService(DeclarationService declarationService) {
        this.declarationService = declarationService;
    }

    @JSON(serialize = false)
    public TDeclaration getDeclaration() {
        return declaration;
    }

    public void setDeclaration(TDeclaration declaration) {
        this.declaration = declaration;
    }

    @JSON(serialize = false)
    public String getGroupCodes() {
        return groupCodes;
    }

    public void setGroupCodes(String groupCodes) {
        this.groupCodes = groupCodes;
    }

    @JSON(serialize = false)
    public String getTeacherCodes() {
        return teacherCodes;
    }

    public void setTeacherCodes(String teacherCodes) {
        this.teacherCodes = teacherCodes;
    }

    @JSON(serialize = false)
    public String getGroupWork() {
        return groupWork;
    }

    public void setGroupWork(String groupWork) {
        this.groupWork = groupWork;
    }

    @JSON(serialize = false)
    public String getProjectFund() {
        return projectFund;
    }

    public void setProjectFund(String projectFund) {
        this.projectFund = projectFund;
    }

    @JSON(serialize = false)
    public String getJqYear() {
        return jqYear;
    }

    public void setJqYear(String jqYear) {
        this.jqYear = jqYear;
    }

    @JSON(serialize = false)
    public List<TDeclaration> getDeclarations() {
        return declarations;
    }

    public void setDeclarations(List<TDeclaration> declarations) {
        this.declarations = declarations;
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
    public Map<String, List<TJieqi>> getQicis() {
        return qicis;
    }

    public void setQicis(Map<String, List<TJieqi>> qicis) {
        this.qicis = qicis;
    }

    @JSON(serialize = false)
    public List<Integer> getYears() {
        return years;
    }

    public void setYears(List<Integer> years) {
        this.years = years;
    }

    @JSON(serialize = false)
    public List<JieQiYear> getJieQiYears() {
        return jieQiYears;
    }

    public void setJieQiYears(List<JieQiYear> jieQiYears) {
        this.jieQiYears = jieQiYears;
    }

    @JSON(serialize = false)
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @JSON(serialize = false)
    public List<TDeclaration> getListDeclaration() {
        return listDeclaration;
    }

    public void setListDeclaration(List<TDeclaration> listDeclaration) {
        this.listDeclaration = listDeclaration;
    }

    @JSON(serialize = false)
    public String getJqQici() {
        return jqQici;
    }

    public void setJqQici(String jqQici) {
        this.jqQici = jqQici;
    }

    @JSON(serialize = false)
    public String getCheckState() {
        return checkState;
    }

    public void setCheckState(String checkState) {
        this.checkState = checkState;
    }

    @JSON(serialize = false)
    public List<TProfession> getProfessions() {
        return professions;
    }

    public void setProfessions(List<TProfession> professions) {
        this.professions = professions;
    }

    public void setProfessionService(ProfessionService professionService) {
        this.professionService = professionService;
    }

    @JSON(serialize = false)
    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    @JSON(serialize = false)
    public List<TDeclJob> getListTDeclJob() {
        return listTDeclJob;
    }

    public void setListTDeclJob(List<TDeclJob> listTDeclJob) {
        this.listTDeclJob = listTDeclJob;
    }

    @JSON(serialize = false)
    public List<TDeclFund> getListTDeclFund() {
        return listTDeclFund;
    }

    public void setListTDeclFund(List<TDeclFund> listTDeclFund) {
        this.listTDeclFund = listTDeclFund;
    }

    @JSON(serialize = false)
    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    @JSON(serialize = false)
    public File[] getFiles() {
        return files;
    }

    public void setFiles(File[] files) {
        this.files = files;
    }

    @JSON(serialize = false)
    public String[] getFilesContentType() {
        return filesContentType;
    }

    public void setFilesContentType(String[] filesContentType) {
        this.filesContentType = filesContentType;
    }

    @JSON(serialize = false)
    public String[] getFilesFileName() {
        return filesFileName;
    }

    public void setFilesFileName(String[] filesFileName) {
        this.filesFileName = filesFileName;
    }

    @JSON(serialize = false)
    public String getProSerial() {
        return proSerial;
    }

    public void setProSerial(String proSerial) {
        this.proSerial = proSerial;
    }

    @JSON(serialize = false)
    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    @JSON(serialize = false)
    public String getDeclarationId() {
        return declarationId;
    }

    public void setDeclarationId(String declarationId) {
        this.declarationId = declarationId;
    }

    public void setJieQiService(JieQiService jieQiService) {
        this.jieQiService = jieQiService;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    @JSON(serialize = false)
    public String getAttachementId() {
        return attachementId;
    }

    public void setAttachementId(String attachementId) {
        this.attachementId = attachementId;
    }

    @JSON(serialize = false)
    public List<TAttachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<TAttachment> attachments) {
        this.attachments = attachments;
    }

    @JSON(serialize = false)
    public String getCollgegId() {
        return collgegId;
    }

    public void setCollgegId(String collgegId) {
        this.collgegId = collgegId;
    }

    public String getMessageInfo() {
        return messageInfo;
    }

    public void setMessageInfo(String messageInfo) {
        this.messageInfo = messageInfo;
    }

    public List<TExpertTeacher> getExpertTeachers() {
        return expertTeachers;
    }

    public void setExpertTeachers(List<TExpertTeacher> expertTeachers) {
        this.expertTeachers = expertTeachers;
    }

    public ExpertTeacherService getExpertTeacherService() {
        return expertTeacherService;
    }

    public void setExpertTeacherService(ExpertTeacherService expertTeacherService) {
        this.expertTeacherService = expertTeacherService;
    }


    public String getAddStudentNumber() {
        return addStudentNumber;
    }

    public void setAddStudentNumber(String addStudentNumber) {
        this.addStudentNumber = addStudentNumber;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

}
