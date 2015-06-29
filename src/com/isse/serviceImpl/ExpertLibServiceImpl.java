/**
 * 
 */
package com.isse.serviceImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.isse.dao.TExpertLibDAO;
import com.isse.dao.TExpertTeacherDAO;
import com.isse.dao.TTeacherDAO;
import com.isse.dao.TTempEmailReciverDAO;
import com.isse.model.TExpertLib;
import com.isse.model.TExpertTeacher;
import com.isse.model.TTeacher;
import com.isse.model.TTempEmailReciver;
import com.isse.service.ExpertLibService;
import com.util.PageBean;

/**
 * @author ming
 *
 */
public class ExpertLibServiceImpl implements ExpertLibService {
     
     private TExpertLibDAO tExpertLibDAO;
     private TExpertTeacherDAO tExpertTeacherDAO;
     private TTempEmailReciverDAO tTempEmailReciverDAO;
     
     public TExpertLib getById(String libId)
     {
    	 return this.tExpertLibDAO.findById(libId);
     }
     
	/* (non-Javadoc)
	 * @see com.isse.service.ExpertLibService#creatExpertLib()
	 */
	@Override
	//创建一个专家库
	public void creatExpertLib(TExpertLib tExpertLib,
			List<TExpertTeacher> tExpertTeacherList,String type) {
		// TODO Auto-generated method stub
		Session session = this.tExpertTeacherDAO.getSessionFactory().getCurrentSession();
		Transaction trans = session.beginTransaction();
		try {
			// 开始事务
			trans.begin();

			this.tExpertLibDAO.save(tExpertLib);
			for (int i = 0; i < tExpertTeacherList.size(); i++) {
				//向专家教师表中添加对象
				tExpertTeacherList.get(i).setTExpertLib(tExpertLib);
				this.tExpertTeacherDAO.save(tExpertTeacherList.get(i));
				
				//向临时邮件收信人表中添加对象
				TTempEmailReciver tTempEmailReciver = new TTempEmailReciver();
				tTempEmailReciver.setCode(tExpertTeacherList.get(i).getTTeacher().getTeaCode());
				tTempEmailReciver.setDepartId(tExpertTeacherList.get(i).getTTeacher().getTUnit().getUnitId());
				tTempEmailReciver.setEmail(tExpertTeacherList.get(i).getTTeacher().getTeaEmail());
				tTempEmailReciver.setJqId(tExpertLib.getTJieqi().getJqId());
				tTempEmailReciver.setName(tExpertTeacherList.get(i).getTTeacher().getTeaName());
				//设置类别和单位
				tTempEmailReciver.setIsdeleted("N");
				tTempEmailReciver.setType(type);
				tTempEmailReciver.setDepartId(tExpertLib.getTUnit().getUnitId());
				this.tTempEmailReciverDAO.save(tTempEmailReciver);
					
			}
			this.tExpertTeacherDAO.changeReviewUserType(tExpertLib.getLibId());
			trans.commit();

		} catch (Exception e) {

			try {
				trans.rollback();// JTA事务回滚

			} catch (Exception e2) {
				// JTA事务回滚出错处理
				e2.printStackTrace();
			}
			e.printStackTrace();
		}
	}
	
	/**
	 * 根据学院主管教师学号获取学院的专家信息
	 */
	@Override
	public List<TExpertLib> findExpsByUnitTeaCode(String teaCode,String type,
			PageBean pageBean) {
		return this.tExpertLibDAO.findExpsByUnitTeaCode(teaCode,type, pageBean);
	}

	@Override
	public int findExpsCountByUnitTeaCode(String teaCode,String type) {
		return this.tExpertLibDAO.findExpsCountByUnitTeaCode(teaCode,type);
	}
	
	@Override
	public TExpertLib findNowJieQiExpLib(String type) {
		return this.tExpertLibDAO.findNowJieQiExpLib(type);
	}
	
	//删除专家库以及该专家库中的专家教师
	public void deleteExperLib(TExpertLib tExpertLib)
	{
		Session session = this.tExpertTeacherDAO.getSessionFactory().getCurrentSession();
        Transaction trans = session.beginTransaction();
        try {
        	// 开始事务
        	trans.begin();
        	tExpertLib.setIsdeleted("Y");
        	this.tExpertLibDAO.merge(tExpertLib);
        	List<TExpertTeacher> expertTeacherList = this.tExpertTeacherDAO.getExpetTeachersByExpertLib(tExpertLib.getLibId());
        	for (int i = 0; i < expertTeacherList.size(); i++) {
        		expertTeacherList.get(i).setIsdeleted("Y");
        		this.tExpertTeacherDAO.merge(expertTeacherList.get(i));
        	}
        	
        	List<TTempEmailReciver> tempEmailReciverList = this.tTempEmailReciverDAO.findTempEmailReciverByJQid(tExpertLib.getTJieqi().getJqId());
        	for(int i = 0; i< tempEmailReciverList.size(); i++){
        		tempEmailReciverList.get(i).setIsdeleted("Y");
        		this.tTempEmailReciverDAO.merge(tempEmailReciverList.get(i));
        	}
        	trans.commit();

        } catch (Exception e) {

        	try {  
        		trans.rollback();// JTA事务回滚

        	} catch (Exception e2) {
        		// JTA事务回滚出错处理
        		e2.printStackTrace();
        	}
        	e.printStackTrace();
        }
	}
	
	//更新专家库中的专家教师
	public void updateExperLib(TExpertLib tExpertLib, List<TExpertTeacher> expertTeacherList,String type)
	{
		Session session = this.tExpertTeacherDAO.getSessionFactory().getCurrentSession();
        Transaction trans = session.beginTransaction();
        try {
        	// 开始事务
        	trans.begin();

        	List<TExpertTeacher> oldExpertTeacherList = this.tExpertTeacherDAO.getExpetTeachersByExpertLib(tExpertLib.getLibId());
        	for (int i = 0; i < oldExpertTeacherList.size(); i++) {
        		//删除专家教师表中的对象
        		oldExpertTeacherList.get(i).setIsdeleted("Y");
        		this.tExpertTeacherDAO.merge(oldExpertTeacherList.get(i));
        		
        		//删除临时邮件收信人表中对应的对象
        		TTempEmailReciver tempEmailReciver = this.tTempEmailReciverDAO.findTempEmailReciver(tExpertLib.getTJieqi().getJqId(), oldExpertTeacherList.get(i).getTTeacher().getTeaCode());
        		tempEmailReciver.setIsdeleted("Y");
        		this.tTempEmailReciverDAO.merge(tempEmailReciver);
        	}
        	
        	for(int i = 0; i < expertTeacherList.size();i++)
        	{
        		//在专家教师表中添加对象
        		expertTeacherList.get(i).setTExpertLib(tExpertLib);
        		this.tExpertTeacherDAO.save(expertTeacherList.get(i));
        		
        		//在临时邮件收信人表中添加对象
        		TTempEmailReciver tTempEmailReciver = new TTempEmailReciver();
				tTempEmailReciver.setCode(expertTeacherList.get(i).getTTeacher().getTeaCode());
				tTempEmailReciver.setDepartId(expertTeacherList.get(i).getTTeacher().getTUnit().getUnitId());
				tTempEmailReciver.setEmail(expertTeacherList.get(i).getTTeacher().getTeaEmail());
				tTempEmailReciver.setJqId(tExpertLib.getTJieqi().getJqId());
				tTempEmailReciver.setName(expertTeacherList.get(i).getTTeacher().getTeaName());
				//设置类别和单位
				tTempEmailReciver.setIsdeleted("N");
				tTempEmailReciver.setType(type);
				tTempEmailReciver.setDepartId(tExpertLib.getTUnit().getUnitId());
				this.tTempEmailReciverDAO.save(tTempEmailReciver);
        	}
   
        	trans.commit();

        } catch (Exception e) {

        	try {
        		trans.rollback();// JTA事务回滚

        	} catch (Exception e2) {
        		// JTA事务回滚出错处理
        		e2.printStackTrace();
        	}
        	e.printStackTrace();
        }
	}
	
	/*****************************
	 * set and get methods 
	 ****************************/
	public TExpertLibDAO gettExpertLibDAO() {
		return tExpertLibDAO;
	}
	public void settExpertLibDAO(TExpertLibDAO tExpertLibDAO) {
		this.tExpertLibDAO = tExpertLibDAO;
	}
	public TExpertTeacherDAO gettExpertTeacherDAO() {
		return tExpertTeacherDAO;
	}
	public void settExpertTeacherDAO(TExpertTeacherDAO tExpertTeacherDAO) {
		this.tExpertTeacherDAO = tExpertTeacherDAO;
	}

	public TTempEmailReciverDAO gettTempEmailReciverDAO() {
		return tTempEmailReciverDAO;
	}

	public void settTempEmailReciverDAO(TTempEmailReciverDAO tTempEmailReciverDAO) {
		this.tTempEmailReciverDAO = tTempEmailReciverDAO;
	}
	
}
