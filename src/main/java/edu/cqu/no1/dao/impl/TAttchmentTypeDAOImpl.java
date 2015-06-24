package edu.cqu.no1.dao.impl;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;
import edu.cqu.no1.dao.TAttchmentTypeDAO;
import edu.cqu.no1.domain.TAttchmentType;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ZKQ on 2015/5/27.
 */

@Repository
public class TAttchmentTypeDAOImpl extends BaseDaoImpl<TAttchmentType> implements TAttchmentTypeDAO {
    private static final Logger log = LoggerFactory
            .getLogger(TAttchmentTypeDAO.class);
    // property constants
    public static final String ATTA_TYPE_NAME = "attaTypeName";
    public static final String ISDELETED = "isdeleted";


    public List findByAttaTypeName(Object attaTypeName) {
        return findByProperty(ATTA_TYPE_NAME, attaTypeName);
    }


    public List findByIsdeleted(Object isdeleted) {
        return findByProperty(ISDELETED, isdeleted);
    }

    public static TAttchmentTypeDAO getFromApplicationContext(
            ApplicationContext ctx) {
        return (TAttchmentTypeDAO) ctx.getBean("TAttchmentTypeDAO");
    }
}
