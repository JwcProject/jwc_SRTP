package edu.cqu.no1.dao.impl;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;
import edu.cqu.no1.dao.*;
import edu.cqu.no1.domain.TEmail;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ZKQ on 2015/5/27.
 */

@Repository
public class TEmailDAOImpl extends BaseDaoImpl<TEmail> implements edu.cqu.no1.dao.TEmailDAO {

    private static final Logger log = LoggerFactory.getLogger(TEmailDAO.class);
    // property constants
    public static final String EMAIL_TITLE = "emailTitle";
    public static final String EMAIL_CONTENT = "emailContent";
    public static final String SENDER = "sender";
    public static final String EMAIL_SECRET = "emailSecret";
    public static final String SEND_STATE = "sendState";
    public static final String ISDELETED = "isdeleted";


    public List findByEmailTitle(Object emailTitle) {
        return findByProperty(EMAIL_TITLE, emailTitle);
    }

    public List findByEmailContent(Object emailContent) {
        return findByProperty(EMAIL_CONTENT, emailContent);
    }

    public List findBySender(Object sender) {
        return findByProperty(SENDER, sender);
    }

    public List findByEmailSecret(Object emailSecret) {
        return findByProperty(EMAIL_SECRET, emailSecret);
    }

    public List findBySendState(Object sendState) {
        return findByProperty(SEND_STATE, sendState);
    }

    public List findByIsdeleted(Object isdeleted) {
        return findByProperty(ISDELETED, isdeleted);
    }


    public static TEmailDAO getFromApplicationContext(ApplicationContext ctx) {
        return (TEmailDAO) ctx.getBean("TEmailDAO");
    }
}
