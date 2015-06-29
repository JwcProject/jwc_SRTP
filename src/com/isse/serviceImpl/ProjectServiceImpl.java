/**
 * 
 */
package com.isse.serviceImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.isse.dao.TProjectDAO;
import com.isse.model.TProject;
import com.isse.service.ProjectService;
import com.util.PageBean;

/**
 * @author ming
 *
 */
public class ProjectServiceImpl implements ProjectService {

	private TProjectDAO tProjectDAO;
	
	@Override
	public void creatProject(String jqId) {
		//Session session = this.tProjectDAO.getSessionFactory().getCurrentSession();
		//Transaction transaction = session.beginTransaction();
		try {
			//transaction.begin();			
			this.tProjectDAO.createProject(jqId);
			
			//transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			//throw e;
			//transaction.rollback();
		}
		
		
	}
	
	//获取学院项目列表
	public List<TProject> getProjectByTeaCode(String unitTeaCode, PageBean pageBean)
	{
		return this.tProjectDAO.getProjectByTeaCode(unitTeaCode, pageBean);
	}
	public int getProjectByteaCodeCount(String unitTeaCode)
	{
		return this.tProjectDAO.getProjectCount(unitTeaCode);
	}
	
	//多条件查询学院项目列表
	public int findProjectByTeaCodeCount(String teacherCode, String jqYear, String jqId, String professionName, String studentNums, String projectNumber, String projectName)
	{
		return this.tProjectDAO.findProjectByTeaCodeCount(teacherCode, jqYear, jqId, professionName, studentNums, projectNumber, projectName);
	}
	public List<TProject> findProjectByTeaCode(String teacherCode, String jqYear, String jqId, String professionName, String studentNums, String projectNumber, String projectName, PageBean pageBean)
	{
		return this.tProjectDAO.findProjectByTeaCode(teacherCode, jqYear, jqId, professionName, studentNums, projectNumber, projectName, pageBean);
	}
	
	//获取学校所有项目
	public List<TProject> listSchoolProject(PageBean pageBean)
	{
		return this.tProjectDAO.listSchoolProject(pageBean);
	}
	public int listSchoolProjectCount()
	{
		return this.tProjectDAO.listSchoolProjectCount();
	}
	
	//多条件查询学校项目
	public List<TProject> findSchoolProject(String jqYear, String jqId, String unitName, String studentNums, String projectName, PageBean pageBean)
	{
		return this.tProjectDAO.findSchoolProject(jqYear, jqId, unitName, studentNums, projectName, pageBean);
	}
	public int findSchoolProjectCount(String jqYear, String jqId, String unitName, String studentNums, String projectName)
	{
		return this.tProjectDAO.findSchoolProjectCount(jqYear, jqId, unitName, studentNums, projectName);
	}
	
	//获取学生个人项目列表 
	public List<TProject> getStuProject(String stuCode)
	{
		return this.tProjectDAO.getStuProject(stuCode);
	}
	
	//获取教师个人项目列表
	public List<TProject> getTeaProject(String teaCode,PageBean pageBean)
	{
		return this.tProjectDAO.getTeaProject(teaCode, pageBean);
	}
	public int getTeaProjectCount(String teaCode)
	{
		return this.tProjectDAO.getTeaProjectCount(teaCode);
	}
	
	//多条件查询教师个人项目
	public List<TProject> findTeaProject(String teaCode, String projectName, String stuCode, PageBean pageBean)
	{
		return this.tProjectDAO.findTeaProject(teaCode, projectName, stuCode, pageBean);
	}
	public int findTeaProjectCount(String teaCode, String projectName, String stuCode)
	{
		return this.tProjectDAO.findTeaProjectCount(teaCode, projectName, stuCode);
	}
	
	public TProject findByLeaderCode(String leaderCode){
		return this.tProjectDAO.findByLeaderCode(leaderCode);
	}
	
	public TProject findById(String projectId){
		return this.tProjectDAO.findById(projectId);
	}
	
	public TProjectDAO gettProjectDAO() {
		return tProjectDAO;
	}
	public void settProjectDAO(TProjectDAO tProjectDAO) {
		this.tProjectDAO = tProjectDAO;
	}

}
