/**
 * 
 */
package com.isse.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.isse.dao.TDeclCommentDAO;
import com.isse.dao.TExpertReviewDAO;
import com.isse.model.TDeclComment;
import com.isse.model.TDeclaration;
import com.isse.model.TExpertReview;
import com.isse.model.TExpertTeacher;
import com.isse.service.ExpertReviewService;

/**
 * @author ming
 *
 */
public class ExpertReviewServiceImpl implements ExpertReviewService {
    TExpertReviewDAO tExpertReviewDAO;
    TDeclCommentDAO tDeclCommentDAO;
    
	/* (non-Javadoc)
	 * @see com.isse.service.ExpertReviewService#creatExpertLib(com.isse.model.TDeclaration, java.util.List)
	 */
	@Override
	//创建专家评审
	public void creatExpertReview(TDeclaration tDeclaration,
			List<TExpertTeacher> tExpertTeacherList) {
		// TODO Auto-generated method stub
        Session session = tExpertReviewDAO.getSessionFactory().getCurrentSession();
        Transaction trans=session.beginTransaction();
        try {
    		//开始事务
            trans.begin();
            tDeclaration.setCheckState("03");
            TExpertReview tExpertReview = null;
            TDeclComment tDeclComment = null;
            for(int i=0;i<tExpertTeacherList.size();i++){
            	tExpertReview = new TExpertReview();
            	tExpertReview.setTDeclaration(tDeclaration);
            	tExpertReview.setTExpertTeacher(tExpertTeacherList.get(i));
            	//tExpertReview.setIsdeleted("N");
            	this.tExpertReviewDAO.save(tExpertReview);
            	
            	//添加专家评审
            	tDeclComment = new TDeclComment();
            	tDeclComment.setTExpertReview(tExpertReview);
            	
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
	
	public TDeclComment geTDeclCommentByTexpertReview(String texperReviewId)
	{
		return this.tDeclCommentDAO.findByExpertReview(texperReviewId);
	}

	@Override
	public TExpertReview getTExpertReview(String jqId, String teaCode,
			String declId, String type) {
		return this.tExpertReviewDAO.getTExpertReview(jqId, teaCode, declId, type);
	}

	
	public TExpertReviewDAO gettExpertReviewDAO() {
		return tExpertReviewDAO;
	}

	public void settExpertReviewDAO(TExpertReviewDAO tExpertReviewDAO) {
		this.tExpertReviewDAO = tExpertReviewDAO;
	}

	public TDeclCommentDAO gettDeclCommentDAO() {
		return tDeclCommentDAO;
	}

	public void settDeclCommentDAO(TDeclCommentDAO tDeclCommentDAO) {
		this.tDeclCommentDAO = tDeclCommentDAO;
	}
	
	
}
