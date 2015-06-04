package edu.cqu.no1.service;

import edu.cqu.no1.domain.TProject;
import edu.cqu.no1.util.PageBean;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ZKQ on 2015/6/4.
 */

public interface ProjectService {
    public void creatProject(String jqId);

    public TProject findByLeaderCode(String leaderCode);

    public TProject findById(String projectId);

    //获取学院项目列表
    public List<TProject> getProjectByTeaCode(String unitTeaCode, PageBean pageBean);

    public int getProjectByteaCodeCount(String unitTeaCode);

    //多条件查询学院项目列表
    public int findProjectByTeaCodeCount(String teacherCode, String jqYear, String jqId, String professionName, String studentNums, String projectNumber, String projectName);

    public List<TProject> findProjectByTeaCode(String teacherCode, String jqYear, String jqId, String professionName, String studentNums, String projectNumber, String projectName, PageBean pageBean);

    //获取学校所有项目
    public List<TProject> listSchoolProject(PageBean pageBean);

    public int listSchoolProjectCount();

    //多条件查询学校项目
    public List<TProject> findSchoolProject(String jqYear, String jqId, String unitName, String studentNums, String projectName, PageBean pageBean);

    public int findSchoolProjectCount(String jqYear, String jqId, String unitName, String studentNums, String projectName);

    //获取学生个人项目列表
    public List<TProject> getStuProject(String stuCode);

    //获取教师个人项目列表
    public List<TProject> getTeaProject(String teaCode, PageBean pageBean);

    public int getTeaProjectCount(String teaCode);

    //多条件查询教师个人项目
    public List<TProject> findTeaProject(String teaCode, String projectName, String stuCode, PageBean pageBean);

    public int findTeaProjectCount(String teaCode, String projectName, String stuCode);

}
