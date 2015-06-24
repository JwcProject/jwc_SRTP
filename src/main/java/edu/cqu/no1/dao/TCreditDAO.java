package edu.cqu.no1.dao;

import edu.cqu.no1.domain.TCredit;

import java.util.List;

/**
 * Created by ZKQ on 2015/5/27.
 */
public interface TCreditDAO extends BaseDao<TCredit> {
    List findByCreditScore(Object creditScore);

    List findByIsdeleted(Object isdeleted);
}
