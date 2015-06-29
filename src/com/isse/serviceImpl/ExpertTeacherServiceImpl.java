/**
 * 
 */
package com.isse.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.mapping.Array;

import com.isse.dao.TDeclCommentDAO;
import com.isse.dao.TExpertTeacherDAO;
import com.isse.dao.TTeacherDAO;
import com.isse.model.TDeclComment;
import com.isse.model.TExpertLib;
import com.isse.model.TExpertTeacher;
import com.isse.model.TTeacher;
import com.isse.service.ExpertTeacherService;
import com.util.PageBean;

/**
 * @author ming
 *
 */
public class ExpertTeacherServiceImpl implements ExpertTeacherService {
    
	TExpertTeacherDAO tExpertTeacherDAO;
	TTeacherDAO teacherDAO;
	TDeclCommentDAO declCommentDAO;
	
	/* (non-Javadoc)
	 * @see com.isse.service.ExpertTeacher#findExpertTeachersByTeaCode(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	//通过主管教师的工号列出所在学院历史专家教师
	public List<TExpertTeacher> getExpertTeachersByTeaCode(String teaCode, String type, PageBean pageBean) {
		List<TTeacher> teacherList = new ArrayList<TTeacher>();
		teacherList = teacherDAO.getTeachers(teaCode);
		
		List<TExpertTeacher> expertTeacherList = new ArrayList<TExpertTeacher>();
		for(int i=0;i<teacherList.size();i++){
			TExpertTeacher tExpertTeacher = new TExpertTeacher();
			tExpertTeacher = tExpertTeacherDAO.getExpertTeachersByTeaId(teacherList.get(i).getTeaId(),type);
			if(tExpertTeacher != null){
				expertTeacherList.add(tExpertTeacher);
			}
		}
		if(expertTeacherList.size()>0)
		{
			if(pageBean.getCurrPage()==pageBean.getTotalPage())
			{
				if(expertTeacherList.size()<pageBean.getTotalRows())
				{
					return expertTeacherList;
				}
				return expertTeacherList.subList(pageBean.getBeginIndex(), pageBean.getTotalRows());
			}
			return expertTeacherList.subList(pageBean.getBeginIndex(), pageBean.getBeginIndex()+pageBean.getPageCapibility());
			
		}
		else{
			return null;
		}
	}
	
	public int getExpertTeachersByTeaCodeCount(String teaCode, String type)
	{
		List<TTeacher> teacherList = new ArrayList<TTeacher>();
		teacherList = teacherDAO.getTeachers(teaCode);
		
		List<TExpertTeacher> expertTeacherList = new ArrayList<TExpertTeacher>();
		for(int i=0;i<teacherList.size();i++){
			TExpertTeacher tExpertTeacher = new TExpertTeacher();
			tExpertTeacher = tExpertTeacherDAO.getExpertTeachersByTeaId(teacherList.get(i).getTeaId(),type);
			if(tExpertTeacher != null){
				expertTeacherList.add(tExpertTeacher);
			}
		}
		return expertTeacherList.size();
	}
	
	//多条件查询学院历史专家教师
	@SuppressWarnings("unchecked")
	public int findExpertTeachersCount(String teaCode, String teaName, String teaTitle, String type){
		List<TTeacher> teacherList = new ArrayList<TTeacher>();
		teacherList = teacherDAO.findTeachers(teaCode, teaName, teaTitle);
		List<TExpertTeacher> expertTeacherList = new ArrayList<TExpertTeacher>();
		for(int i=0;i<teacherList.size();i++){
			TExpertTeacher tExpertTeacher = new TExpertTeacher();
			tExpertTeacher = tExpertTeacherDAO.getExpertTeachersByTeaId(teacherList.get(i).getTeaId(),type);
			if(null!=tExpertTeacher){
				expertTeacherList.add(tExpertTeacher);
			}
			
		}
		return expertTeacherList.size();
	}
	
	@SuppressWarnings("unchecked")
	public List<TExpertTeacher> findExpertTeachers(String teaCode, String teaName, String teaTitle, String type, PageBean pageBean){
		List<TTeacher> teacherList = new ArrayList<TTeacher>();
		teacherList = teacherDAO.findTeachers(teaCode, teaName, teaTitle);
		List<TExpertTeacher> expertTeacherList = new ArrayList<TExpertTeacher>();
		for(int i=0;i<teacherList.size();i++){
			TExpertTeacher tExpertTeacher = new TExpertTeacher();
			tExpertTeacher = tExpertTeacherDAO.getExpertTeachersByTeaId(teacherList.get(i).getTeaId(),type);
			if(null!=tExpertTeacher){
				expertTeacherList.add(tExpertTeacher);
			}
			
		}
		
		if(expertTeacherList==null)
		{

			return null;

		}
		else
		{
			if(pageBean.getCurrPage()==pageBean.getTotalPage())
			{
				return expertTeacherList.subList(pageBean.getBeginIndex(), pageBean.getTotalRows());
			}
			return expertTeacherList.subList(pageBean.getBeginIndex(), pageBean.getBeginIndex()+pageBean.getPageCapibility());
		}
	}
	
	//通过届期找到对应的专家教师
	public List<TExpertTeacher> findExpertTeachersByJQid(String jqId){
		return this.tExpertTeacherDAO.findExpertTeachersByJQid(jqId);
	}
	
	
	//添加一组专家教师
	public void saveExpertTeacher(List<TExpertTeacher> tExpertTeacherList){
		Session session =this.tExpertTeacherDAO.getSessionFactory().getCurrentSession();  
		Transaction trans=session.beginTransaction(); 
	try {
		//开始事务
        trans.begin();

        for(int i=0;i<tExpertTeacherList.size();i++){
        	this.tExpertTeacherDAO.save(tExpertTeacherList.get(i));
        }
        trans.commit();
		
	} catch (Exception e) {
		
		try {
			trans.rollback();//JTA事务回滚
			
		} catch (Exception e2) {
			//JTA事务回滚出错处理
			e2.printStackTrace();
		}
		e.printStackTrace();
	}
	}

	/**
	 * 
	 *TODO 根据专家库ID获取某一期的专家教师(分页)
	 *authoy lzh
	 *@param expLibId
	 *@return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<TExpertTeacher> findExpTeaByExpLibId(String expLibId,
			PageBean pageBean) {
		return this.tExpertTeacherDAO.findExpTeaByExpLibId(expLibId, pageBean);
	}

	@Override
	public int findExpTeaCountByExpLibId(String expLibId) {
		return this.tExpertTeacherDAO.findExpTeaCountByExpLibId(expLibId);
	}
	
	/**
	 * 
	 *TODO 根据专家库ID获取某一期的专家教师(不分页)
	 *authoy lzh
	 *@param expLibId
	 *@return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<TExpertTeacher> findExpTeaByExpLibId(String expLibId) {
		return this.tExpertTeacherDAO.findExpTeaByExpLibId(expLibId);
	}
	
	
	@Override
	public TExpertTeacher findExpTeaByCode(String teaCode) {
		return this.tExpertTeacherDAO.findExpTeaByCode(teaCode);
	}
	
	//获取本届期已经分配的专家教师
    public List findAssignedExpertTeachers(String jqId, String type, String teaCode)
    {
    	return this.tExpertTeacherDAO.findAssignedExpertTeachers(jqId, type, teaCode);
    }
	
	//添加网评
	public void addTDeclComment(TDeclComment declComment) {
		// TODO Auto-generated method stub
		this.declCommentDAO.save(declComment);
	}
	
	//根据届期id，专家库类型，获取专家库
    public List<TExpertLib> findExpertLibByJqid(String jqId, String type)
    {
    	return this.tExpertTeacherDAO.findExpertLibByJqid(jqId, type);
    }
	
  //根据届期id，专家库类型，登陆教师ID，获取本学院专家库
    public List<TExpertLib> findUnitExpertLibByJqid(String jqId, String type, String teacherCode)
    {
    	return this.tExpertTeacherDAO.findUnitExpertLibByJqid(jqId, type, teacherCode);
    }
	public TExpertTeacherDAO gettExpertTeacherDAO() {
		return tExpertTeacherDAO;
	}

	public void settExpertTeacherDAO(TExpertTeacherDAO tExpertTeacherDAO) {
		this.tExpertTeacherDAO = tExpertTeacherDAO;
	}

	public TTeacherDAO getTeacherDAO() {
		return teacherDAO;
	}

	public void setTeacherDAO(TTeacherDAO teacherDAO) {
		this.teacherDAO = teacherDAO;
	}

	public TDeclCommentDAO getDeclCommentDAO() {
		return declCommentDAO;
	}

	public void setDeclCommentDAO(TDeclCommentDAO declCommentDAO) {
		this.declCommentDAO = declCommentDAO;
	}
}
