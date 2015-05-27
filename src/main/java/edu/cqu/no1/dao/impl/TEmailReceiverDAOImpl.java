package edu.cqu.no1.dao.impl;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;
import edu.cqu.no1.dao.*;
import edu.cqu.no1.domain.TEmailReceiver;
import org.springframework.context.ApplicationContext;

import java.util.List;

/**
 * Created by ZKQ on 2015/5/27.
 */
public class TEmailReceiverDAOImpl extends BaseDaoImpl<TEmailReceiver> implements edu.cqu.no1.dao.TEmailReceiverDAO {

    private static final Logger log = LoggerFactory
            .getLogger(TEmailReceiverDAO.class);
    // property constants
    public static final String RECEIVER_CODE = "receiverCode";
    public static final String RECEIVER_ROLE = "receiverRole";
    public static final String EMAIL_ADDRESS = "emailAddress";
    public static final String IS_RECEIVED = "isReceived";
    public static final String ISDELETED = "isdeleted";

    @Override
    public List findByReceiverCode(Object receiverCode) {
        return findByProperty(RECEIVER_CODE, receiverCode);
    }

    @Override
    public List findByReceiverRole(Object receiverRole) {
        return findByProperty(RECEIVER_ROLE, receiverRole);
    }

    @Override
    public List findByEmailAddress(Object emailAddress) {
        return findByProperty(EMAIL_ADDRESS, emailAddress);
    }

    @Override
    public List findByIsReceived(Object isReceived) {
        return findByProperty(IS_RECEIVED, isReceived);
    }

    @Override
    public List findByIsdeleted(Object isdeleted) {
        return findByProperty(ISDELETED, isdeleted);
    }

    public static TEmailReceiverDAO getFromApplicationContext(
            ApplicationContext ctx) {
        return (TEmailReceiverDAO) ctx.getBean("TEmailReceiverDAO");
    }
}
