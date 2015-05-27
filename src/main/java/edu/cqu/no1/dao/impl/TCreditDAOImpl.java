package edu.cqu.no1.dao.impl;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;
import edu.cqu.no1.dao.*;
import edu.cqu.no1.domain.TCredit;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ZKQ on 2015/5/27.
 */

@Repository
public class TCreditDAOImpl extends BaseDaoImpl<TCredit> implements edu.cqu.no1.dao.TCreditDAO {
    private static final Logger log = LoggerFactory.getLogger(TCreditDAO.class);
    // property constants
    public static final String CREDIT_SCORE = "creditScore";
    public static final String ISDELETED = "isdeleted";

    @Override
    public List findByCreditScore(Object creditScore) {
        return findByProperty(CREDIT_SCORE, creditScore);
    }

    @Override
    public List findByIsdeleted(Object isdeleted) {
        return findByProperty(ISDELETED, isdeleted);
    }

    public static TCreditDAO getFromApplicationContext(ApplicationContext ctx) {
        return (TCreditDAO) ctx.getBean("TCreditDAO");
    }
}
