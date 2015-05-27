package edu.cqu.no1.dao.impl;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;
import edu.cqu.no1.dao.*;
import edu.cqu.no1.domain.TDeclFund;
import org.hibernate.Query;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ZKQ on 2015/5/27.
 */

@Repository
public class TDeclFundDAOImpl extends BaseDaoImpl<TDeclFund> implements edu.cqu.no1.dao.TDeclFundDAO {

    private static final Logger log = LoggerFactory
            .getLogger(TDeclFundDAO.class);
    // property constants
    public static final String SERIAL_NUM = "serialNum";
    public static final String FUND_CONTENT = "fundContent";
    public static final String AMOUNT = "amount";
    public static final String ISDELETED = "isdeleted";

    @Override
    public List findBySerialNum(Object serialNum) {
        return findByProperty(SERIAL_NUM, serialNum);
    }

    @Override
    public List findByFundContent(Object fundContent) {
        return findByProperty(FUND_CONTENT, fundContent);
    }

    @Override
    public List findByAmount(Object amount) {
        return findByProperty(AMOUNT, amount);
    }

    @Override
    public List findByIsdeleted(Object isdeleted) {
        return findByProperty(ISDELETED, isdeleted);
    }


    public static TDeclFundDAO getFromApplicationContext(ApplicationContext ctx) {
        return (TDeclFundDAO) ctx.getBean("TDeclFundDAO");
    }

    @Override
    public List<TDeclFund> findByDeclarId(String declarId){
        log.debug("finding all TDeclFund instances");
        try {
            String queryStr = "from TDeclFund as a where a.isdeleted = 'N' " +
                    "and a.TDeclaration.declarId=:code ";

            Query query = getSessionFactory().getCurrentSession().createQuery(queryStr);
            query.setString("code", declarId);

            return query.list();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }
    }
    @Override
    public int deleteFundByDeclId(String declarId) throws Exception{
        log.debug("deleteFundByDeclId");
        try {
            List<TDeclFund> list = findByDeclarId(declarId);
            for (TDeclFund tDeclFund : list) {
                tDeclFund.setIsdeleted("Y");
                merge(tDeclFund);
            }
            return list == null ? 0:list.size();
        } catch (RuntimeException re) {
            log.error("deleteFundByDeclId failed", re);
            throw re;
        }
    }
}
