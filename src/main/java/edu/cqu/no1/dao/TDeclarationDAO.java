package edu.cqu.no1.dao;

import edu.cqu.no1.util.PageBean;

import java.util.List;

/**
 * Created by ZKQ on 2015/5/27.
 */
public interface TDeclarationDAO {
    boolean checkHadReqDecla(String stuNumber);

    /*
* 通过学院主管教师的code得到该学院的所有申报
*/
    List getUnitDeclarationByTeaCode(String unitTeaCode, String checkState1, String checkState2, PageBean pageBean);

    int getUnitDeclarationCount(String unitTeaCode, String checkState1, String checkState2);

    /*
* 获取教务处的申报列表
*/
    List getSchoolDeclaration(String checkState1, String checkState2, PageBean pageBean);

    int getSchoolDeclarationCount(String checkState1, String checkState2);

    /*
* 通过评审教师的id得到其评审的申报列表
*/
    List getReviewTeaDeclaration(String teaCode, PageBean pageBean);

    int getReviewTeaDeclarationCount(String teaCode);

    //多条件查询学院申报
    List findUnitDeclaration(String teaCode, String jqYear, String jqId, String professionName, String leaderCode, String checkState, String proSerial, String proName, PageBean pageBean);

    int findUnitDeclarationCount(String teaCode, String jqYear, String jqId, String professionName, String leaderCode, String checkState, String proSerial, String proName);

    /*
* 多条件查询教务处申报列表
*/
    List findSchoolDeclaration(String proName, String jqYear, String jqId, String checkState, String college, PageBean pageBean);

    int findSchoolDeclarationCount(String proName, String jqYear, String jqId, String checkState, String college);

    /*
* 多条件查询评审专家个人相关申报
*/
    List findReviewTeaDeclaration(String teaCode, String jqYear, String jqId, String professionName, String leaderCode, String compEval, PageBean pageBean);

    int findReviewTeaDeclarationCount(String teaCode, String jqYear, String jqId, String professionName, String leaderCode, String compEval);

    List findUnitDecByState(String teaCode, String state, PageBean pageBean);

    int findUnitDecByStateCount(String teaCode, String state);

    //获取普通教师的个人申报列表
    List getTeaDeclaration(String teaCode, PageBean pageBean);

    int getTeaDeclarationCount(String teaCode);

    //多条件查询教师个人申报
    List findTeaDeclaration(String teaCode, String projectName, String stuCode, PageBean pageBean);

    int findTeaDeclarationCount(String teaCode, String projectName, String stuCode);

    List findByProSerial(Object proSerial);

    List findByProName(Object proName);

    List findByLabLevel(Object labLevel);

    List findByLabName(Object labName);

    List findByLeaderCode(Object leaderCode);

    List findByMember1Code(Object member1Code);

    List findByMember2Code(Object member2Code);

    List findByTeacher1Code(Object teacher1Code);

    List findByTeacher2Code(Object teacher2Code);

    List findByCollege(Object college);

    List findByCheckState(Object checkState);

    List findByProIntro(Object proIntro);

    List findByResContent(Object resContent);

    List findByProAdv(Object proAdv);

    List findByResProgram(Object resProgram);

    List findByInnoPoint(Object innoPoint);

    List findByResCondition(Object resCondition);

    List findByProPlan(Object proPlan);

    List findByExpResult(Object expResult);

    List findByExpTarget(Object expTarget);

    List findByIsdeleted(Object isdeleted);

    List findByProType(Object proType);

    List findByProFund(Object proFund);

    List findAll(PageBean pageBean, String studentId);

    int getAllTDeclarationCount(String studentId);

    String getDeclarationSerial(String unitId);
}
