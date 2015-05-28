package edu.cqu.no1.dao.impl;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;
import edu.cqu.no1.dao.*;
import edu.cqu.no1.domain.TCode;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ZKQ on 2015/5/27.
 */

@Repository
public class TCodeDAOImpl extends BaseDaoImpl<TCode> implements edu.cqu.no1.dao.TCodeDAO {
    private static final Logger log = LoggerFactory.getLogger(TCodeDAO.class);
    // property constants
    public static final String ENCODE_VALUE = "encodeValue";
    public static final String ENCODE_DESC = "encodeDesc";
    public static final String ENCODE_REMARK = "encodeRemark";
    public static final String ISDELETED = "isdeleted";

    public List findByEncodeValue(Object encodeValue) {
        return findByProperty(ENCODE_VALUE, encodeValue);
    }

    public List findByEncodeDesc(Object encodeDesc) {
        return findByProperty(ENCODE_DESC, encodeDesc);
    }

    public List findByEncodeRemark(Object encodeRemark) {
        return findByProperty(ENCODE_REMARK, encodeRemark);
    }

    public List findByIsdeleted(Object isdeleted) {
        return findByProperty(ISDELETED, isdeleted);
    }

    public static TCodeDAO getFromApplicationContext(ApplicationContext ctx) {
        return (TCodeDAO) ctx.getBean("TCodeDAO");
    }
}
