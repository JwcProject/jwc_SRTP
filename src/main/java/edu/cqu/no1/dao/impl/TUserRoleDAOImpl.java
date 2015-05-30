package edu.cqu.no1.dao.impl;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;
import edu.cqu.no1.dao.TUserRoleDAO;
import edu.cqu.no1.domain.TUserRole;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ZKQ on 2015/5/27.
 */

@Repository
public class TUserRoleDAOImpl extends BaseDaoImpl<TUserRole> implements TUserRoleDAO {

    private static final Logger log = LoggerFactory
            .getLogger(TUserRoleDAO.class);
    // property constants
    public static final String ISDELETED = "isdeleted";

    public List findByIsdeleted(Object isdeleted) {
        return findByProperty(ISDELETED, isdeleted);
    }

    public static TUserRoleDAO getFromApplicationContext(ApplicationContext ctx) {
        return (TUserRoleDAO) ctx.getBean("TUserRoleDAO");
    }
}
