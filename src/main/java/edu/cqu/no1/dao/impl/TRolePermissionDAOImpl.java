package edu.cqu.no1.dao.impl;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;
import edu.cqu.no1.dao.TRolePermissionDAO;
import edu.cqu.no1.domain.TRolePermission;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ZKQ on 2015/5/27.
 */

@Repository
public class TRolePermissionDAOImpl extends BaseDaoImpl<TRolePermission> implements TRolePermissionDAO {

    private static final Logger log = LoggerFactory
            .getLogger(TRolePermissionDAO.class);
    // property constants
    public static final String ISDELETED = "isdeleted";

    public List findByIsdeleted(Object isdeleted) {
        return findByProperty(ISDELETED, isdeleted);
    }

    public List findByRoleId(String roleId) {
        // TODO: !!!Implement it!!!
        return null;
    }

    public static TRolePermissionDAO getFromApplicationContext(
            ApplicationContext ctx) {
        return (TRolePermissionDAO) ctx.getBean("TRolePermissionDAO");
    }
}
