package edu.cqu.no1.dao;

import edu.cqu.no1.domain.TProjectChange;

import java.util.List;

/**
 * Created by ZKQ on 2015/5/27.
 */
public interface TProjectChangeDAO extends BaseDao<TProjectChange> {
    List findByProjectchangeState(Object projectchangeState);

    List findByProjectchangeAtid(Object projectchangeAtid);

    List findByProjectchangeCtid(Object projectchangeCtid);

    List findByProjectchangeReason(Object projectchangeReason);

    List findByIsdeleted(Object isdeleted);
}
