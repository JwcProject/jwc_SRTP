package edu.cqu.no1.dao.impl;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;
import edu.cqu.no1.dao.*;
import edu.cqu.no1.domain.TAnnounType;
import org.hibernate.Query;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ZKQ on 2015/5/27.
 */

@Repository
public class TAnnounTypeDAOImpl extends BaseDaoImpl<TAnnounType> implements edu.cqu.no1.dao.TAnnounTypeDAO {
    private static final Logger log = LoggerFactory
            .getLogger(TAnnounTypeDAO.class);
    // property constants
    public static final String ANNOUN_TYPE_NAME = "announTypeName";
    public static final String ISDELETED = "isdeleted";


    public TAnnounType findByAnnounName(String announTypeName)
    {
        log.debug("finding TAnnounType by annoument name");
        try {
            String queryString = "from TAnnounType t where t.announTypeName=:announTypeName";
            Query query = getSessionFactory().getCurrentSession().createQuery(queryString);
            query.setString("announTypeName", announTypeName);
            List<TAnnounType> tempL = query.list();
            TAnnounType tAnnounType = null;
            if(tempL.size()>0)
            {
                tAnnounType = tempL.get(0);
            }
            return tAnnounType;

        } catch (RuntimeException e) {
            log.error("finding TAnnounType by annoument name failed", e);
            throw e;
        }
    }

    public List findByAnnounTypeName(Object announTypeName) {
        return findByProperty(ANNOUN_TYPE_NAME, announTypeName);
    }
    
    public List findByIsdeleted(Object isdeleted) {
        return findByProperty(ISDELETED, isdeleted);
    }

    public static TAnnounTypeDAO getFromApplicationContext(
            ApplicationContext ctx) {
        return (TAnnounTypeDAO) ctx.getBean("TAnnounTypeDAO");
    }
}
