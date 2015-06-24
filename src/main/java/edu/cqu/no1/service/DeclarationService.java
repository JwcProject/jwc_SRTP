package edu.cqu.no1.service;

import edu.cqu.no1.domain.*;
import edu.cqu.no1.util.PageBean;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;


/**
 * Created by ZKQ on 2015/6/4.
 */

public interface DeclarationService {


    public List getStudentsByNumber(String numbers);

    public List getTeachersByName(String names);

    public TDeclaration addDeclaration(List<TAttachment> tAttachments, TDeclaration declaration, String groupCodes, String teacherCodes, String groupWork,
                                       String projectFund);

    public TDeclaration updateDeclaration(List<TAttachment> tAttachments, TUser user, TDeclaration declaration, String groupCodes, String teacherCodes, String groupWork,
                                          String projectFund);

    public TDeclaration updateDeclaration(TDeclaration declaration, String groupCodes, String teacherCodes, String groupWork,
                                          String projectFund);

    public List<TAttachment> getAttachmentByDeclarId(String declarId);

    public TAttachment getAttachmentById(String attachementId);

    public List<TDeclaration> getAllTDeclaration(final PageBean pageBean, String studentId);

    public int getAllTDeclarationCount(String studentId);

    public List<TJieqi> findJieqiByYear(String year);

    public TDeclaration getTDeclaration(String Id);

    public List<TDeclJob> getTDeclJob(String declarId);

    public List<TDeclFund> getTDeclFund(String declarId);

    public void updateTDeclaration(TDeclaration declaration);

    public void deleteTDeclaration(String declaration);

    //获取学院申报列表
    public List<TDeclaration> getUnitDeclaration(String unitTeaCode, String checkState1, String checkState2, PageBean pageBean);

    public int getUnitDeclarationCount(String unitTeaCode, String checkState1, String checkState2);


    //获取学校申报列表
    public List<TDeclaration> getSchoolDeclaration(String checkState1, String checkState2, PageBean pageBean);

    public int getSchoolDeclarationCount(String checkState1, String checkState2);

    //获取评审专家的申报列表
    public List<TDeclComment> getReviewTeaDeclaration(String teaCode, PageBean pageBean);

    public int getReviewTeaDeclarationCount(String teaCode);

    public List<BigDecimal> findAllYears();

    public List<TTeacher> findUnitTeachers(String teaCode);

    //查询学院申报列表
    public List<TDeclaration> findUnitDeclarations(String teaCode, String jqYear, String jqId, String professionName, String leaderCode, String checkState, String proSerial, String proName, PageBean pageBean);

    public int findUnitDeclarationsCount(String teaCode, String jqYear, String jqId, String professionName, String leaderCode, String checkState, String proSerial, String proName);

    //查询学校申报列表
    public List findSchoolDeclaration(String proName, String jqYear, String jqId, String checkState, String college, PageBean pageBean);

    public int findSchoolDeclarationCount(String proName, String jqYear, String jqId, String checkState, String college);

    //多条件查询评审专家个人相关申报
    public List findReviewTeaDeclaration(String teaCode, String proName, String jqYear, String jqId, String professionName, String leaderCode, String compEval, PageBean pageBean);

    public int findReviewTeaDeclarationCount(String teaCode, String proName, String jqYear, String jqId, String professionName, String leaderCode, String compEval);


    //获取普通教师的个人申报列表
    public List<TDeclaration> getTeaDeclaration(String teaCode, PageBean pageBean);

    public int getTeaDeclarationCount(String teaCode);

    //多条件查询教师个人申报
    public List<TDeclaration> findTeaDeclaration(String teaCode, String projectName, String stuCode, PageBean pageBean);

    public int findTeaDeclarationCount(String teaCode, String projectName, String stuCode);

    public List<TDeclaration> findUnitDecByState(String teaCode, String state, PageBean pageBean);

    public int findUnitDecByStateCount(String teaCode, String state);

    public String findUnitIdByUnitName(String unitName);

    public boolean checkHadReqDecla(String stuNumber);

    public boolean checkExist(String key, String value);

}
