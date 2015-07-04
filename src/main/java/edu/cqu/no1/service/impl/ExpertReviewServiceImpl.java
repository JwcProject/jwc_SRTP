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
import org.springframework.transaction.annotation.Transactional;

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


    /**
     * 创建专家评审
     *
     * @param tDeclaration       申报
     * @param tExpertTeacherList 评审专家列表
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void creatExpertReview(TDeclaration tDeclaration,
                                  List<TExpertTeacher> tExpertTeacherList) {
        try {
            tDeclaration.setCheckState("03");
            TExpertReview tExpertReview = null;
            TDeclComment tDeclComment = null;
            for (int i = 0; i < tExpertTeacherList.size(); i++) {
                tExpertReview = new TExpertReview();
                tExpertReview.setTDeclaration(tDeclaration);
                tExpertReview.setTExpertTeacher(tExpertTeacherList.get(i));
                tExpertReview.setIsdeleted("N");
                this.tExpertReviewDAO.save(tExpertReview);

                //添加专家评审
                tDeclComment = new TDeclComment();
                tDeclComment.setTExpertReview(tExpertReview);
            }
        } catch (Exception e) {
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
