package edu.cqu.no1.dao;

import java.util.List;

/**
 * Created by ZKQ on 2015/5/27.
 */
public interface TFundsDAO {
    List findByFundsId(Object fundsId);

    List findByFundsName(Object fundsName);

    List findByFundsIsreimburse(Object fundsIsreimburse);

    List findByFundsMoney(Object fundsMoney);

    List findByFundsDetail(Object fundsDetail);

    List findByFundsUse(Object fundsUse);

    List findByIsdeleted(Object isdeleted);
}
