package edu.cqu.no1.dao;

import edu.cqu.no1.domain.TEndProjectComment;
import edu.cqu.no1.util.PageBean;

import java.util.List;

/**
 * Created by ZKQ on 2015/5/27.
 */
public interface TEndProjectCommentDAO {
    //获取一个教师可以评审的结题
    List<TEndProjectComment> findMyReviewEndPros(String teaCode, PageBean pageBean);

    int findMyReviewEndProsCount(String teaCode);

    List findByEndprojectcommentAdvise(Object endprojectcommentAdvise);

    List findByEndprojectcommentContent(Object endprojectcommentContent);

    List findByIsdeleted(Object isdeleted);
}
