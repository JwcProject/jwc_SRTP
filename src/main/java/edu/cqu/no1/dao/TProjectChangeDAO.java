package edu.cqu.no1.dao;

import java.util.List;

/**
 * Created by ZKQ on 2015/5/27.
 */
public interface TProjectChangeDAO {
    List findByProjectchangeState(Object projectchangeState);

    List findByProjectchangeAtid(Object projectchangeAtid);

    List findByProjectchangeCtid(Object projectchangeCtid);

    List findByProjectchangeReason(Object projectchangeReason);

    List findByIsdeleted(Object isdeleted);
}
