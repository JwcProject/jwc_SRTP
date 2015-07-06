package edu.cqu.no1.service.impl;

import edu.cqu.no1.dao.TProjectDAO;
import edu.cqu.no1.domain.TProject;
import edu.cqu.no1.service.ProjectService;
import edu.cqu.no1.util.PageBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ZKQ on 2015/6/4.
 */

@Service
public class ProjectServiceImpl implements ProjectService {

    @Resource
    private TProjectDAO tProjectDAO;

    @Override
    public void creatProject(String jqId) {
        try {
            this.tProjectDAO.createProject(jqId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //获取学院项目列表
    public List<TProject> getProjectByTeaCode(String unitTeaCode, PageBean pageBean) {
        return this.tProjectDAO.getProjectByTeaCode(unitTeaCode, pageBean);
    }

    public int getProjectByteaCodeCount(String unitTeaCode) {
        return this.tProjectDAO.getProjectCount(unitTeaCode);
    }

    //多条件查询学院项目列表
    public int findProjectByTeaCodeCount(String teacherCode, String jqYear, String jqId, String professionName, String studentNums, String projectNumber, String projectName) {
        return this.tProjectDAO.findProjectByTeaCodeCount(teacherCode, jqYear, jqId, professionName, studentNums, projectNumber, projectName);
    }

    public List<TProject> findProjectByTeaCode(String teacherCode, String jqYear, String jqId, String professionName, String studentNums, String projectNumber, String projectName, PageBean pageBean) {
        return this.tProjectDAO.findProjectByTeaCode(teacherCode, jqYear, jqId, professionName, studentNums, projectNumber, projectName, pageBean);
    }

    //获取学校所有项目
    public List<TProject> listSchoolProject(PageBean pageBean) {
        return this.tProjectDAO.listSchoolProject(pageBean);
    }

    public int listSchoolProjectCount() {
        return this.tProjectDAO.listSchoolProjectCount();
    }

    //多条件查询学校项目
    public List<TProject> findSchoolProject(String jqYear, String jqId, String unitName, String studentNums, String projectName, PageBean pageBean) {
        return this.tProjectDAO.findSchoolProject(jqYear, jqId, unitName, studentNums, projectName, pageBean);
    }

    public int findSchoolProjectCount(String jqYear, String jqId, String unitName, String studentNums, String projectName) {
        return this.tProjectDAO.findSchoolProjectCount(jqYear, jqId, unitName, studentNums, projectName);
    }

    //获取学生个人项目列表
    public List<TProject> getStuProject(String stuCode) {
        return this.tProjectDAO.getStuProject(stuCode);
    }

    //获取教师个人项目列表
    public List<TProject> getTeaProject(String teaCode, PageBean pageBean) {
        return this.tProjectDAO.getTeaProject(teaCode, pageBean);
    }

    public int getTeaProjectCount(String teaCode) {
        return this.tProjectDAO.getTeaProjectCount(teaCode);
    }

    //多条件查询教师个人项目
    public List<TProject> findTeaProject(String teaCode, String projectName, String stuCode, PageBean pageBean) {
        return this.tProjectDAO.findTeaProject(teaCode, projectName, stuCode, pageBean);
    }

    public int findTeaProjectCount(String teaCode, String projectName, String stuCode) {
        return this.tProjectDAO.findTeaProjectCount(teaCode, projectName, stuCode);
    }

    public TProject findByLeaderCode(String leaderCode) {
        return this.tProjectDAO.findByLeaderCode(leaderCode);
    }

    public TProject findById(String projectId) {
        return this.tProjectDAO.findById(projectId);
    }

    public TProjectDAO gettProjectDAO() {
        return tProjectDAO;
    }

    public void settProjectDAO(TProjectDAO tProjectDAO) {
        this.tProjectDAO = tProjectDAO;
    }

}
