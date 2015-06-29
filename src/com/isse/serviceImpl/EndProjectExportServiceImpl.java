package com.isse.serviceImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.isse.dao.TEndProjectCommentDAO;
import com.isse.dao.TEndProjectExportDAO;
import com.isse.model.TEndProject;
import com.isse.model.TEndProjectComment;
import com.isse.model.TEndProjectExport;
import com.isse.model.TExpertReview;
import com.isse.model.TExpertTeacher;
import com.isse.service.EndProjectExportService;
import com.isse.service.EndProjectService;
import com.util.PageBean;

/**
 * @Create Date：2013-9-7上午10:36:56
 * @Update Date：
 * @Author：lzh
 * TODO
 */
public class EndProjectExportServiceImpl implements EndProjectExportService{

	private TEndProjectExportDAO endProjectExportDAO;
	private TEndProjectCommentDAO endProjectCommentDAO;
	@Override
	public void creatEndProExpertReview(TEndProject endProject,
			List<TExpertTeacher> tExpertTeacherList) {
		  Session session = endProjectExportDAO.getSessionFactory().getCurrentSession();
	        Transaction trans=session.beginTransaction();
	        try {
	    		//开始事务
	            trans.begin();
	            TEndProjectExport endProjectExport = null;
	            for(int i=0;i<tExpertTeacherList.size();i++){
	            	endProjectExport = new TEndProjectExport();
	            	endProjectExport.setTEndProject(endProject);
	            	endProjectExport.setTExpertTeacher(tExpertTeacherList.get(i));
	            	endProjectExport.setIsdeleted("N");
	            	this.endProjectExportDAO.save(endProjectExport);
	            }
	            //结题设置为结题中
	            endProject.setEndprojectState("03");
	            //想结题网评实体插入数据
	            TEndProjectComment endProjectComment = new TEndProjectComment();
	            endProjectComment.setTEndProjectExport(endProjectExport);
	            endProjectComment.setIsdeleted("N");
	            this.endProjectCommentDAO.save(endProjectComment);
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

	/* (non-Javadoc)
	 * @see com.isse.service.EndProjectExportService#findMyReviewEndPros(java.lang.String, java.lang.String, com.util.PageBean)
	 */
	@Override
	public List<TEndProjectExport> findMyReviewEndPros(String teaCode,
			String jieqiId, PageBean pageBean) {
		return this.endProjectExportDAO.findMyReviewEndPros(teaCode, jieqiId, pageBean);
	}

	/* (non-Javadoc)
	 * @see com.isse.service.EndProjectExportService#findMyReviewEndPros(java.lang.String, java.lang.String)
	 */
	@Override
	public int findMyReviewEndPros(String teaCode, String jieqiId) {
		return this.endProjectExportDAO.findMyReviewEndPros(teaCode, jieqiId);
	}
	//根据结题ID和教职工号获取结题评审专家对象
	@Override
	public TEndProjectExport findEndProExp(String teaCode, String endProId) {
		return this.endProjectExportDAO.findEndProExp(teaCode, endProId);
	}
	/*******************************************
	 *  set and get methods
	 *******************************************/
	public TEndProjectExportDAO getEndProjectExportDAO() {
		return endProjectExportDAO;
	}

	public void setEndProjectExportDAO(TEndProjectExportDAO endProjectExportDAO) {
		this.endProjectExportDAO = endProjectExportDAO;
	}

	public TEndProjectCommentDAO getEndProjectCommentDAO() {
		return endProjectCommentDAO;
	}

	public void setEndProjectCommentDAO(TEndProjectCommentDAO endProjectCommentDAO) {
		this.endProjectCommentDAO = endProjectCommentDAO;
	}
}
