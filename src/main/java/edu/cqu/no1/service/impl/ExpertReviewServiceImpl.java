package edu.cqu.no1.service.impl;

import edu.cqu.no1.dao.TDeclCommentDAO;
import edu.cqu.no1.dao.TExpertReviewDAO;
import edu.cqu.no1.domain.TDeclComment;
import edu.cqu.no1.domain.TDeclaration;
import edu.cqu.no1.domain.TExpertReview;
import edu.cqu.no1.domain.TExpertTeacher;
import edu.cqu.no1.service.ExpertReviewService;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ZKQ on 2015/6/4.
 */

@Service
public class ExpertReviewServiceImpl implements ExpertReviewService {

    @Resource
    TExpertReviewDAO tExpertReviewDAO;
    @Resource
    TDeclCommentDAO tDeclCommentDAO;

    @Override
    //创建专家评审
    public void creatExpertReview(TDeclaration tDeclaration,
                                  List<TExpertTeacher> tExpertTeacherList) {
        // TODO Auto-generated method stub
        Session session = tExpertReviewDAO.getSessionFactory().getCurrentSession();
        Transaction trans = session.beginTransaction();
        try {
            //开始事务
            trans.begin();
            tDeclaration.setCheckState("03");
            TExpertReview tExpertReview = null;
            TDeclComment tDeclComment = null;
            for (int i = 0; i < tExpertTeacherList.size(); i++) {
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

    public TDeclComment geTDeclCommentByTexpertReview(String texperReviewId) {
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
