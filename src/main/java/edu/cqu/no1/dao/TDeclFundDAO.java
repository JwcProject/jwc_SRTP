package edu.cqu.no1.dao;

import edu.cqu.no1.domain.TDeclFund;

import java.util.List;

/**
 * Created by ZKQ on 2015/5/27.
 */
public interface TDeclFundDAO {
    List findBySerialNum(Object serialNum);

    List findByFundContent(Object fundContent);

    List findByAmount(Object amount);

    List findByIsdeleted(Object isdeleted);

    List<TDeclFund> findByDeclarId(String declarId);

    int deleteFundByDeclId(String declarId) throws Exception;
}
