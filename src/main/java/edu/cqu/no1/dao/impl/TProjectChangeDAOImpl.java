package edu.cqu.no1.dao.impl;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;
import edu.cqu.no1.dao.TProjectChangeDAO;
import edu.cqu.no1.domain.TProjectChange;
import org.springframework.context.ApplicationContext;

import java.util.List;

/**
 * Created by ZKQ on 2015/5/27.
 */
public class TProjectChangeDAOImpl extends BaseDaoImpl<TProjectChange> implements TProjectChangeDAO {

    private static final Logger log = LoggerFactory
            .getLogger(TProjectChangeDAO.class);
    // property constants
    public static final String PROJECTCHANGE_STATE = "projectchangeState";
    public static final String PROJECTCHANGE_ATID = "projectchangeAtid";
    public static final String PROJECTCHANGE_CTID = "projectchangeCtid";
    public static final String PROJECTCHANGE_REASON = "projectchangeReason";
    public static final String ISDELETED = "isdeleted";


    @Override
    public List findByProjectchangeState(Object projectchangeState) {
        return findByProperty(PROJECTCHANGE_STATE, projectchangeState);
    }

    @Override
    public List findByProjectchangeAtid(Object projectchangeAtid) {
        return findByProperty(PROJECTCHANGE_ATID, projectchangeAtid);
    }

    @Override
    public List findByProjectchangeCtid(Object projectchangeCtid) {
        return findByProperty(PROJECTCHANGE_CTID, projectchangeCtid);
    }

    @Override
    public List findByProjectchangeReason(Object projectchangeReason) {
        return findByProperty(PROJECTCHANGE_REASON, projectchangeReason);
    }

    @Override
    public List findByIsdeleted(Object isdeleted) {
        return findByProperty(ISDELETED, isdeleted);
    }


    public static TProjectChangeDAO getFromApplicationContext(
            ApplicationContext ctx) {
        return (TProjectChangeDAO) ctx.getBean("TProjectChangeDAO");
    }
}
