package edu.cqu.no1.dao;

import edu.cqu.no1.domain.TDeclComment;

import java.util.List;

/**
 * Created by ZKQ on 2015/5/27.
 */
public interface TDeclCommentDAO extends BaseDao<TDeclComment> {
    //通过专家评审id得到网评对象
    TDeclComment findByExpertReview(String exReviewId);

    List findByDeclArgument(Object declArgument);

    List findByCompEval(Object compEval);

    List findByIsdeleted(Object isdeleted);
}
