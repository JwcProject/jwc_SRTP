package edu.cqu.no1.dao;

import edu.cqu.no1.domain.TExpertReview;

import java.util.List;

/**
 * Created by ZKQ on 2015/5/27.
 */
public interface TExpertReviewDAO extends BaseDao<TExpertReview> {
    List findByIsdeleted(Object isdeleted);

    TExpertReview getTExpertReview(String jqId, String teaCode, String declId, String type);
}
