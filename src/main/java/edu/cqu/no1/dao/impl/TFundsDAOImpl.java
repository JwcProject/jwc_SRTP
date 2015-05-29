package edu.cqu.no1.dao.impl;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;
import edu.cqu.no1.dao.*;
import edu.cqu.no1.domain.TFunds;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ZKQ on 2015/5/27.
 */

@Repository
public class TFundsDAOImpl extends BaseDaoImpl<TFunds> implements TFundsDAO {

    private static final Logger log = LoggerFactory.getLogger(TFundsDAO.class);
    // property constants
    public static final String FUNDS_ID = "fundsId";
    public static final String FUNDS_NAME = "fundsName";
    public static final String FUNDS_ISREIMBURSE = "fundsIsreimburse";
    public static final String FUNDS_MONEY = "fundsMoney";
    public static final String FUNDS_DETAIL = "fundsDetail";
    public static final String FUNDS_USE = "fundsUse";
    public static final String ISDELETED = "isdeleted";


    public List findByFundsId(Object fundsId) {
        return findByProperty(FUNDS_ID, fundsId);
    }


    public List findByFundsName(Object fundsName) {
        return findByProperty(FUNDS_NAME, fundsName);
    }


    public List findByFundsIsreimburse(Object fundsIsreimburse) {
        return findByProperty(FUNDS_ISREIMBURSE, fundsIsreimburse);
    }


    public List findByFundsMoney(Object fundsMoney) {
        return findByProperty(FUNDS_MONEY, fundsMoney);
    }


    public List findByFundsDetail(Object fundsDetail) {
        return findByProperty(FUNDS_DETAIL, fundsDetail);
    }


    public List findByFundsUse(Object fundsUse) {
        return findByProperty(FUNDS_USE, fundsUse);
    }


    public List findByIsdeleted(Object isdeleted) {
        return findByProperty(ISDELETED, isdeleted);
    }

    public static TFundsDAO getFromApplicationContext(ApplicationContext ctx) {
        return (TFundsDAO) ctx.getBean("TFundsDAO");
    }
}
