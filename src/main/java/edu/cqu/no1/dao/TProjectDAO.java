package edu.cqu.no1.dao;

import edu.cqu.no1.domain.TProject;
import edu.cqu.no1.util.PageBean;

import java.util.List;

/**
 * Created by ZKQ on 2015/5/27.
 */
public interface TProjectDAO {
    void createProject(String jqId);

    //根据当前教师工号得到所在学院项目列表
    List getProjectByTeaCode(String unitTeaCode, PageBean pageBean);

    int getProjectCount(String unitTeaCode);

    //多条件查询学院项目
    int findProjectByTeaCodeCount(String teacherCode, String jqYear, String jqId, String professionName, String studentNums, String projectNumber, String projectName);

    List findProjectByTeaCode(String teacherCode, String jqYear, String jqId, String professionName, String studentNums, String projectNumber, String projectName, PageBean pageBean);

    //获取学校所有项目
    List listSchoolProject(PageBean pageBean);

    int listSchoolProjectCount();

    //多条件查询学校项目
    List findSchoolProject(String jqYear, String jqId, String unitName, String studentNums, String projectName, PageBean pageBean);

    int findSchoolProjectCount(String jqYear, String jqId, String unitName, String studentNums, String projectName);

    //获取学生个人项目列表
    List getStuProject(String stuCode);

    //获取教师个人项目列表
    List getTeaProject(String teaCode, PageBean pageBean);

    int getTeaProjectCount(String teaCode);

    //多条件查询教师个人项目
    List findTeaProject(String teaCode, String projectName, String stuCode, PageBean pageBean);

    int findTeaProjectCount(String teaCode, String projectName, String stuCode);

    TProject findByLeaderCode(String leaderCode);

    List findByProjectLine(Object projectLine);

    List findByProjectState(Object projectState);

    List findByProjectNumber(Object projectNumber);

    List findByProjectSense(Object projectSense);

    List findByProjectContent(Object projectContent);

    List findByProjectLabtype(Object projectLabtype);

    List findByProjectLabname(Object projectLabname);

    List findByProjectName(Object projectName);

    List findByProjectIntroduction(Object projectIntroduction);

    List findByProjectFund(Object projectFund);

    List findByProjectInnovate(Object projectInnovate);

    List findByProjectCondition(Object projectCondition);

    List findByProjectProgress(Object projectProgress);

    List findByProjectGoal(Object projectGoal);

    List findByProjectAchievement(Object projectAchievement);

    List findByProjectWork(Object projectWork);

    List findByRedmineProjectid(Object redmineProjectid);

    List findByProjectScore(Object projectScore);

    List findByIsdeleted(Object isdeleted);
}
