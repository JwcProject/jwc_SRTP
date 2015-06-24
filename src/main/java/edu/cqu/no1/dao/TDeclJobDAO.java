package edu.cqu.no1.dao;

import edu.cqu.no1.domain.TDeclJob;

import java.util.List;

/**
 * Created by ZKQ on 2015/5/27.
 */
public interface TDeclJobDAO extends BaseDao<TDeclJob> {
    List findByJobContent(Object jobContent);

    List findByIsdeleted(Object isdeleted);

    List<TDeclJob> findByDeclarId(String declarId);

    int deleteJobByDeclId(String declarId) throws Exception;
}
