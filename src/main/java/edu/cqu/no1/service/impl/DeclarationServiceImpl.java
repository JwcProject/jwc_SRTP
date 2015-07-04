package edu.cqu.no1.service.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import edu.cqu.no1.dao.*;
import edu.cqu.no1.domain.*;
import edu.cqu.no1.service.DeclarationService;
import edu.cqu.no1.util.PageBean;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by ZKQ on 2015/6/4.
 */

@Service
public class DeclarationServiceImpl implements DeclarationService {
    @Resource
    private TStudentDAO tStudentDAO;
    @Resource
    private TTeacherDAO teacherDAO;
    @Resource
    private TUnitDAO tUnitDAO;
    @Resource
    private TProfessionDAO tProfessionDAO;
    @Resource
    private TJieqiDAO tJieqiDAO;
    @Resource
    private TDeclarationDAO tDeclarationDAO;
    @Resource
    private TDeclJobDAO tDeclJobDAO;
    @Resource
    private TDeclFundDAO tDeclFundDAO;
    @Resource
    private TAttachmentDAO tAttachmentDAO;
    @Resource
    private TAttchmentTypeDAO tAttchmentTypeDAO;
    @Resource
    private TTempEmailReciverDAO tempEmailReciverDAO;


    private List<TTempEmailReciver> tempEmailRecivers;


    private void addTempEmailReciver(TTempEmailReciver tempEmailReciver) {
        tempEmailReciver.setType("01");
        this.tempEmailRecivers.add(tempEmailReciver);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<TJieqi> findJieqiByYear(String year) {
        return this.tJieqiDAO.getJieqiByYear(year);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List getStudentsByNumber(String numbers) {
        String[] numberList = numbers.split(",");
        List<TStudent> students = new ArrayList<TStudent>();
        for (String number : numberList) {
            students.addAll(this.tStudentDAO.findByStudentNumber(number));
        }
        return students;
    }

    @Override
    public List getTeachersByName(String names) {
        return this.teacherDAO.findTeachersByName(names);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public TDeclaration addDeclaration(List<TAttachment> tAttachments, TDeclaration declaration, String groupCodes, String teacherCodes, String groupWork,
                                       String projectFund) {
        this.tempEmailRecivers = new ArrayList<TTempEmailReciver>();
        TJieqi tJieqi = this.tJieqiDAO.getJieqiNow();
        declaration.setTJieqi(tJieqi);
        declaration.setIsdeleted("N");
        setGroup(declaration, groupCodes, tJieqi);
        setTeacherCodes(declaration, teacherCodes, tJieqi);
        declaration.setTDeclJobs(generateGroupWork(groupWork, declaration));
        declaration.setTDeclFunds(generateProjectFund(projectFund, declaration));
        this.tDeclarationDAO.save(declaration);
        TAttchmentType tAttchmentType = this.tAttchmentTypeDAO.findById("1");
        for (TAttachment tAttachment : tAttachments) {
            tAttachment.setTAttchmentType(tAttchmentType);
            tAttachment.setObjectCode(declaration.getDeclarId());
            this.tAttachmentDAO.save(tAttachment);
        }
        for (TTempEmailReciver tempEmailReciver : tempEmailRecivers) {
            this.tempEmailReciverDAO.save(tempEmailReciver);
        }
        return declaration;
    }

    @SuppressWarnings("unchecked")
    private Set generateGroupWork(String groupWork, TDeclaration declaration) {
        Set groupWorkSet = new HashSet();
        groupWork = groupWork.replaceAll("\t|\r|\n", "");
        String[] groups = groupWork.split(",");
        for (String group : groups) {
            if (group.equals("")) {
                continue;
            }
            String[] works = group.split(":");
            TDeclJob declJob = new TDeclJob();
            TStudent student = this.tStudentDAO.findById(works[0]);
            declJob.setTStudent(student);
            declJob.setJobContent(works[1]);
            declJob.setTDeclaration(declaration);
            declJob.setIsdeleted("N");
            groupWorkSet.add(declJob);
        }
        return groupWorkSet;
    }

    @SuppressWarnings("unchecked")
    private Set generateProjectFund(String projectFund, TDeclaration declaration) {
        Set projectFundSet = new HashSet();
        projectFund = projectFund.replaceAll("\t|\r|\n", "");
        String[] funds = projectFund.split(",");
        for (String fund : funds) {
            if (fund.equals("") || fund.contains("undefined")) {
                continue;
            }
            String[] items = fund.split(":");
            TDeclFund tDeclFund = new TDeclFund();
            tDeclFund.setSerialNum(items[0]);
            tDeclFund.setFundContent(items[1]);
            tDeclFund.setAmount(Float.parseFloat(items[2]));
            tDeclFund.setTDeclaration(declaration);
            projectFundSet.add(tDeclFund);
        }
        return projectFundSet;
    }

    private void setTeacherCodes(TDeclaration declaration, String teacherCodes, TJieqi tJieqi) {
        String[] groups = teacherCodes.split(",");
        switch (groups.length) {
            case 1:
                TTeacher teacher = this.teacherDAO.findById(groups[0]);
                declaration.setTTeacherByTeacher1Code(teacher);
                addTempEmailReciver(getTempEmailReciverFromTeacher(teacher, tJieqi));
                break;
            case 2:
                TTeacher tea1 = this.teacherDAO.findById(groups[0]);
                TTeacher tea2 = this.teacherDAO.findById(groups[1]);
                declaration.setTTeacherByTeacher1Code(tea1);
                declaration.setTTeacherByTeacher2Code(tea2);
                addTempEmailReciver(getTempEmailReciverFromTeacher(tea1, tJieqi));
                addTempEmailReciver(getTempEmailReciverFromTeacher(tea2, tJieqi));
                break;
        }
    }

    private TTempEmailReciver getTempEmailReciverFromStudent(TStudent student, TJieqi tJieqi) {
        TTempEmailReciver tempEmailReciver = new TTempEmailReciver();
        tempEmailReciver.setDepartId(student.getTUnit().getUnitId());
        tempEmailReciver.setJqId(tJieqi.getJqId());
        tempEmailReciver.setName(student.getStudentName());
        tempEmailReciver.setCode(student.getStudentNumber());
        tempEmailReciver.setEmail(student.getStudentEmail());
        tempEmailReciver.setIsdeleted("N");
        return tempEmailReciver;
    }

    private TTempEmailReciver getTempEmailReciverFromTeacher(TTeacher teacher, TJieqi tJieqi) {
        TTempEmailReciver tempEmailReciver = new TTempEmailReciver();
        tempEmailReciver.setDepartId(teacher.getTUnit().getUnitId());
        tempEmailReciver.setJqId(tJieqi.getJqId());
        tempEmailReciver.setName(teacher.getTeaName());
        tempEmailReciver.setCode(teacher.getTeaCode());
        tempEmailReciver.setEmail(teacher.getTeaEmail());
        tempEmailReciver.setIsdeleted("N");
        return tempEmailReciver;
    }

    private void setGroup(TDeclaration declaration, String groupCodes, TJieqi tJieqi) {
        String[] groups = groupCodes.split(",");
        TUnit unit = this.tStudentDAO.findById(groups[0]).getTUnit();
        declaration.setTUnit(unit);
        declaration.setProSerial(this.tDeclarationDAO.getDeclarationSerial(unit.getUnitId()));
        switch (groups.length) {
            case 1:
                TStudent student = this.tStudentDAO.findById(groups[0]);
                addTempEmailReciver(getTempEmailReciverFromStudent(student, tJieqi));
                declaration.setTStudentByLeaderCode(student);
                break;
            case 2:
                TStudent stu2_1 = this.tStudentDAO.findById(groups[0]);
                TStudent stu2_2 = this.tStudentDAO.findById(groups[1]);
                addTempEmailReciver(getTempEmailReciverFromStudent(stu2_1, tJieqi));
                addTempEmailReciver(getTempEmailReciverFromStudent(stu2_2, tJieqi));
                declaration.setTStudentByLeaderCode(stu2_1);
                declaration.setTStudentByMember1Code(stu2_2);
                break;
            case 3:
                TStudent stu3_1 = this.tStudentDAO.findById(groups[0]);
                TStudent stu3_2 = this.tStudentDAO.findById(groups[1]);
                TStudent stu3_3 = this.tStudentDAO.findById(groups[2]);
                addTempEmailReciver(getTempEmailReciverFromStudent(stu3_1, tJieqi));
                addTempEmailReciver(getTempEmailReciverFromStudent(stu3_2, tJieqi));
                addTempEmailReciver(getTempEmailReciverFromStudent(stu3_3, tJieqi));
                declaration.setTStudentByLeaderCode(stu3_1);
                declaration.setTStudentByMember1Code(stu3_2);
                declaration.setTStudentByMember2Code(stu3_3);
                break;
        }
    }

    public TTeacher getTeacherByCode(String teaCode) {
        List list = this.teacherDAO.findByTeaCode(teaCode);
        if (list != null && list.size() > 0) {
            return (TTeacher) list.get(0);
        } else {
            return null;
        }
    }

    public TStudent getStudentByNumber(String number) {
        List list = this.tStudentDAO.findByStudentNumber(number);
        if (list != null && list.size() > 0) {
            return (TStudent) list.get(0);
        } else {
            return null;
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public TDeclaration updateDeclaration(List<TAttachment> tAttachments, TUser user, TDeclaration declaration,
                                          String groupCodes, String teacherCodes, String groupWork,
                                          String projectFund) {
        this.tempEmailRecivers = new ArrayList<TTempEmailReciver>();
        TJieqi tJieqi = this.tJieqiDAO.getJieqiNow();
        declaration.setTJieqi(tJieqi);
        declaration.setDeclTime(new Timestamp(System.currentTimeMillis()));
        declaration.setCheckState("01");
        declaration.setIsdeleted("N");
        setGroup(declaration, groupCodes, tJieqi);
        setTeacherCodes(declaration, teacherCodes, tJieqi);
        try {
            this.tDeclFundDAO.deleteFundByDeclId(declaration.getDeclarId());
            this.tDeclJobDAO.deleteJobByDeclId(declaration.getDeclarId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        declaration.setTDeclJobs(generateGroupWork(groupWork, declaration));
        declaration.setTDeclFunds(generateProjectFund(projectFund, declaration));
        this.tDeclarationDAO.merge(declaration);
        TAttchmentType tAttchmentType = this.tAttchmentTypeDAO.findById("1");
        this.tAttachmentDAO.deleteTAttachmentsByObjectCode(declaration.getDeclarId());
        for (TAttachment newTAttach : tAttachments) {
            newTAttach.setTAttchmentType(tAttchmentType);
            newTAttach.setObjectCode(declaration.getDeclarId());
            this.tAttachmentDAO.save(newTAttach);
        }
        return declaration;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public TDeclaration updateDeclaration(TDeclaration declaration,
                                          String groupCodes, String teacherCodes, String groupWork,
                                          String projectFund) {
        this.tempEmailRecivers = new ArrayList<TTempEmailReciver>();
        try {
            TJieqi tJieqi = this.tJieqiDAO.getJieqiNow();
            declaration.setTJieqi(tJieqi);
            declaration.setDeclTime((Timestamp) new Date());
            declaration.setCheckState("01");
            declaration.setIsdeleted("N");
            setGroup(declaration, groupCodes, tJieqi);
            setTeacherCodes(declaration, teacherCodes, tJieqi);
            this.tDeclFundDAO.deleteFundByDeclId(declaration.getDeclarId());
            this.tDeclJobDAO.deleteJobByDeclId(declaration.getDeclarId());
            declaration.setTDeclJobs(generateGroupWork(groupWork, declaration));
            declaration.setTDeclFunds(generateProjectFund(projectFund, declaration));
            this.tDeclarationDAO.merge(declaration);
            return declaration;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<TDeclaration> getAllTDeclaration(PageBean pageBean, String studentId) {
        return this.tDeclarationDAO.findAll(pageBean, studentId);
    }

    @Override
    public int getAllTDeclarationCount(String studentId) {
        return this.tDeclarationDAO.getAllTDeclarationCount(studentId);
    }

    @Override
    public TDeclaration getTDeclaration(String Id) {
        return this.tDeclarationDAO.findById(Id);
    }

    @Override
    public List<TDeclJob> getTDeclJob(String declarId) {
        return this.tDeclJobDAO.findByDeclarId(declarId);
    }

    @Override
    public List<TDeclFund> getTDeclFund(String declarId) {
        return this.tDeclFundDAO.findByDeclarId(declarId);
    }

    @Override
    public void updateTDeclaration(TDeclaration declaration) {
        this.tDeclarationDAO.merge(declaration);
    }

    @Override
    public void deleteTDeclaration(String Id) {
        TDeclaration declaration = this.getTDeclaration(Id);
        declaration.setIsdeleted("Y");
        this.tDeclarationDAO.merge(declaration);
    }
    /*
     *通过学院主管教师的code获取该学院所有申报列表
	 */

    public List<TDeclaration> getUnitDeclaration(String unitTeaCode, String checkState1, String checkState2, PageBean pageBean) {
        return this.tDeclarationDAO.getUnitDeclarationByTeaCode(unitTeaCode, checkState1, checkState2, pageBean);
    }

    public int getUnitDeclarationCount(String unitTeaCode, String checkState1, String checkState2) {
        return this.tDeclarationDAO.getUnitDeclarationCount(unitTeaCode, checkState1, checkState2);
    }

    /*
     * 通过届期得到教务处的申报列表
     */
    public List<TDeclaration> getSchoolDeclaration(String checkState1, String checkState2, PageBean pageBean) {
        return this.tDeclarationDAO.getSchoolDeclaration(checkState1, checkState2, pageBean);
    }

    public int getSchoolDeclarationCount(String checkState1, String checkState2) {
        return this.tDeclarationDAO.getSchoolDeclarationCount(checkState1, checkState2);
    }

    /*
     * 获取评审专家的申报列表
     */
    public List<TDeclComment> getReviewTeaDeclaration(String teaCode, PageBean pageBean) {
        return this.tDeclarationDAO.getReviewTeaDeclaration(teaCode, pageBean);
    }

    public int getReviewTeaDeclarationCount(String teaCode) {
        return this.tDeclarationDAO.getReviewTeaDeclarationCount(teaCode);
    }


    @SuppressWarnings("unchecked")
    @Override
    public List<Integer> findAllYears() {
        return this.tJieqiDAO.findAllYears();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<TTeacher> findUnitTeachers(String teaCode) {
        List<TTeacher> tmpList = this.teacherDAO.findByTeaCode(teaCode);
        if (tmpList.size() > 0) {
            TTeacher teacher = tmpList.get(0);
            return this.teacherDAO.findByProperty("TUnit.unitId", teacher.getTUnit().getUnitId());
        }
        return null;
    }


    /*
     * 通过多条件查询学院的申报
     */
    public List<TDeclaration> findUnitDeclarations(String teaCode, String jqYear, String jqId, String professionName, String leaderCode, String checkState, String proSerial, String proName, PageBean pageBean) {
        return this.tDeclarationDAO.findUnitDeclaration(teaCode, jqYear, jqId, professionName, leaderCode, checkState, proSerial, proName, pageBean);
    }


    public int findUnitDeclarationsCount(String teaCode, String jqYear, String jqId, String professionName, String leaderCode, String checkState, String proSerial, String proName) {
        return this.tDeclarationDAO.findUnitDeclarationCount(teaCode, jqYear, jqId, professionName, leaderCode, checkState, proSerial, proName);
    }

    //多条件查询学校申报列表
    public List findSchoolDeclaration(String proName, String jqYear, String jqId, String checkState, String college, PageBean pageBean) {
        return this.tDeclarationDAO.findSchoolDeclaration(proName, jqYear, jqId, checkState, college, pageBean);
    }

    public int findSchoolDeclarationCount(String proName, String jqYear, String jqId, String checkState, String college) {
        return this.tDeclarationDAO.findSchoolDeclarationCount(proName, jqYear, jqId, checkState, college);
    }

    /*
     * 多条件查询评审专家个人相关申报
     */
    public List findReviewTeaDeclaration(String teaCode, String proName, String jqYear, String jqId, String professionName, String leaderCode, String compEval, PageBean pageBean) {
        return this.tDeclarationDAO.findReviewTeaDeclaration(teaCode, jqYear, jqId, professionName, leaderCode, compEval, pageBean);
    }

    public int findReviewTeaDeclarationCount(String teaCode, String proName, String jqYear, String jqId, String professionName, String leaderCode, String compEval) {
        return this.tDeclarationDAO.findReviewTeaDeclarationCount(teaCode, jqYear, jqId, professionName, leaderCode, compEval);
    }

    /**
     * 根据申报状态和学院主管教师的教职工号获取申报
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<TDeclaration> findUnitDecByState(String teaCode, String state,
                                                 PageBean pageBean) {
        return this.tDeclarationDAO.findUnitDecByState(teaCode, state, pageBean);
    }

    @Override
    public int findUnitDecByStateCount(String teaCode, String state) {
        return this.tDeclarationDAO.findUnitDecByStateCount(teaCode, state);
    }

    public String findUnitIdByUnitName(String unitName) {
        List<TUnit> tUnits = this.tUnitDAO.findByUnitName(unitName);
        String unitId = "";
        if (tUnits.size() > 0) {
            unitId = tUnits.get(0).getUnitId();
        }
        return unitId;
    }

    //获取普通教师的个人申报列表
    public List<TDeclaration> getTeaDeclaration(String teaCode, PageBean pageBean) {
        return this.tDeclarationDAO.getTeaDeclaration(teaCode, pageBean);
    }

    public int getTeaDeclarationCount(String teaCode) {
        return this.tDeclarationDAO.getTeaDeclarationCount(teaCode);
    }

    //多条件查询教师个人申报
    public List<TDeclaration> findTeaDeclaration(String teaCode, String projectName, String stuCode, PageBean pageBean) {
        return this.tDeclarationDAO.findTeaDeclaration(teaCode, projectName, stuCode, pageBean);
    }

    public int findTeaDeclarationCount(String teaCode, String projectName, String stuCode) {
        return this.tDeclarationDAO.findTeaDeclarationCount(teaCode, projectName, stuCode);
    }

    /**
     * 查询申报表中某一属性的某一个值是不是存在
     */
    @Override
    public boolean checkExist(String key, String value) {
        List list = this.tDeclarationDAO.findByProperty(key, value);
        boolean result = false;
        if (list.size() > 0) {
            result = true;
        }
        return result;
    }

    /**
     * 判断某一个学生是否已经参加申请申报
     */
    @Override
    public boolean checkHadReqDecla(String stuNumber) {
        return this.tDeclarationDAO.checkHadReqDecla(stuNumber);
    }

    /**
     * ****************************************
     * set and get methods
     * ****************************************
     */
    public TProfessionDAO gettProfessionDAO() {
        return tProfessionDAO;
    }

    public void settProfessionDAO(TProfessionDAO tProfessionDAO) {
        this.tProfessionDAO = tProfessionDAO;
    }

    public TStudentDAO gettStudentDAO() {
        return tStudentDAO;
    }

    public void settStudentDAO(TStudentDAO tStudentDAO) {
        this.tStudentDAO = tStudentDAO;
    }

    public TTeacherDAO getTeacherDAO() {
        return teacherDAO;
    }

    public void setTeacherDAO(TTeacherDAO teacherDAO) {
        this.teacherDAO = teacherDAO;
    }

    public TJieqiDAO gettJieqiDAO() {
        return tJieqiDAO;
    }

    public void settJieqiDAO(TJieqiDAO tJieqiDAO) {
        this.tJieqiDAO = tJieqiDAO;
    }

    public TDeclarationDAO gettDeclarationDAO() {
        return tDeclarationDAO;
    }

    public void settDeclarationDAO(TDeclarationDAO tDeclarationDAO) {
        this.tDeclarationDAO = tDeclarationDAO;
    }

    public TDeclJobDAO gettDeclJobDAO() {
        return tDeclJobDAO;
    }

    public void settDeclJobDAO(TDeclJobDAO tDeclJobDAO) {
        this.tDeclJobDAO = tDeclJobDAO;
    }

    public TDeclFundDAO gettDeclFundDAO() {
        return tDeclFundDAO;
    }

    public void settDeclFundDAO(TDeclFundDAO tDeclFundDAO) {
        this.tDeclFundDAO = tDeclFundDAO;
    }

    public TAttachmentDAO gettAttachmentDAO() {
        return tAttachmentDAO;
    }

    public void settAttachmentDAO(TAttachmentDAO tAttachmentDAO) {
        this.tAttachmentDAO = tAttachmentDAO;
    }

    public TAttchmentTypeDAO gettAttchmentTypeDAO() {
        return tAttchmentTypeDAO;
    }

    public void settAttchmentTypeDAO(TAttchmentTypeDAO tAttchmentTypeDAO) {
        this.tAttchmentTypeDAO = tAttchmentTypeDAO;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<TAttachment> getAttachmentByDeclarId(String declarId) {
        return this.tAttachmentDAO.findByObjectCode(declarId);
    }

    @Override
    public TAttachment getAttachmentById(String attachementId) {
        return this.tAttachmentDAO.findById(attachementId);
    }

    public TTempEmailReciverDAO getTempEmailReciverDAO() {
        return tempEmailReciverDAO;
    }

    public void setTempEmailReciverDAO(TTempEmailReciverDAO tempEmailReciverDAO) {
        this.tempEmailReciverDAO = tempEmailReciverDAO;
    }

    public List<TTempEmailReciver> getTempEmailRecivers() {
        return tempEmailRecivers;
    }

    public void setTempEmailRecivers(List<TTempEmailReciver> tempEmailRecivers) {
        this.tempEmailRecivers = tempEmailRecivers;
    }

    public TUnitDAO gettUnitDAO() {
        return tUnitDAO;
    }

    public void settUnitDAO(TUnitDAO tUnitDAO) {
        this.tUnitDAO = tUnitDAO;
    }


}