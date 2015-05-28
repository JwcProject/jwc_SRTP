package edu.cqu.no1.dao.impl;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;
import edu.cqu.no1.dao.*;
import edu.cqu.no1.domain.TRole;
import edu.cqu.no1.util.PageBean;
import org.hibernate.Query;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ZKQ on 2015/5/27.
 */

@Repository
public class TRoleDAOImpl extends BaseDaoImpl<TRole> implements TRoleDAO {

    private static final Logger log = LoggerFactory.getLogger(TRoleDAO.class);
    // property constants
    public static final String ROLE_NAME = "roleName";
    public static final String ROLE_STATE = "roleState";
    public static final String ROLE_INTRODUCTION = "roleIntroduction";
    public static final String ISDELETED = "isdeleted";


    public List findByRoleName(Object roleName) {
        return findByProperty(ROLE_NAME, roleName);
    }

    public List findByRoleState(Object roleState) {
        return findByProperty(ROLE_STATE, roleState);
    }

    public List findByRoleIntroduction(Object roleIntroduction) {
        return findByProperty(ROLE_INTRODUCTION, roleIntroduction);
    }

    public List findByIsdeleted(Object isdeleted) {
        return findByProperty(ISDELETED, isdeleted);
    }

    public static TRoleDAO getFromApplicationContext(ApplicationContext ctx) {
        return (TRoleDAO) ctx.getBean("TRoleDAO");
    }

    //获取Role数量
    @SuppressWarnings("rawtypes")
    public int getAllTRoleCount()
    {
        log.debug("finding all TRole counts");
        try {

            String queryStr = "select count(*) from TRole as a where a.isdeleted='N'";
            List tmpList = getSessionFactory().getCurrentSession().createQuery(queryStr).list();

            int count = 0;

            if(tmpList.size()>0)
            {
                count = new Integer(""+tmpList.get(0));
            }

            return count;
        } catch (RuntimeException re) {
            log.error("find all TRole counts failed", re);
            throw re;
        }
    }

    @SuppressWarnings("rawtypes")
    public List findAll(final PageBean pageBean) {
        log.debug("finding all TRole instances");
        try {
            String queryStr = "from TRole as a where a.isdeleted = 'N'";

            Query query = getSessionFactory().getCurrentSession().createQuery(queryStr);
            query.setFirstResult(pageBean.getBeginIndex());
            query.setMaxResults(pageBean.getPageCapibility());

            return query.list();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }
    }

    @SuppressWarnings("rawtypes")
    public List findByKeyword(String keyword, PageBean pageBean) {
        log.debug("find TRole by keyword");
        try {
            String queryString = "from TRole as model where model.isdeleted = 'N'";
            if(keyword!=null && !keyword.trim().equals("")){
                queryString += " and model.roleName like :rName";
                queryString += " or model.roleIntroduction like :rIntroduce";
            }

            Query query = getSessionFactory().getCurrentSession().createQuery(queryString);
            if(keyword!=null && !keyword.trim().equals("")){
                query.setString("rName", "%"+keyword+"%");
                query.setString("rIntroduce", "%"+keyword+"%");
            }
            query.setFetchSize(pageBean.getBeginIndex());
            query.setMaxResults(pageBean.getPageCapibility());
            return query.list();
        } catch (RuntimeException re) {
            log.error("find TRole by keyword failed", re);
            throw re;
        }
    }

    @SuppressWarnings("rawtypes")
    public int getRoleByKeywordCount(String keyword) {
        log.debug("find role count by keyword");
        try {
            String queryString = "select count(*) from TRole as model where model.isdeleted = 'N'";
            if(keyword!=null && !keyword.trim().equals("")){
                queryString += " and model.roleName like :rName";
                queryString += " and model.roleIntroduction like :rIntroduce";
            }

            Query query = getSessionFactory().getCurrentSession().createQuery(queryString);
            if(keyword!=null && !keyword.trim().equals("")){
                query.setString("rName", "%"+keyword+"%");
                query.setString("rIntroduce", "%"+keyword+"%");
            }
            List tmpList = query.list();
            int count = 0;
            if(tmpList.size()>0){
                count = new Integer(""+tmpList.get(0));
            }
            return count;
        } catch (RuntimeException re) {
            log.error("find role count by keyword failed", re);
            throw re;
        }
    }

    //通过用户id查询到该用户的角色名称
    public String findRoleNameByUserId(String userId){
        log.debug("find roleName by userId");
        try {
            String queryString = "Select r.roleName From TRole r Where r.roleId In(Select ur.TRole.roleId From TUserRole ur Where ur.TUser.userId =:userId) And Rownum = 1";
            Query query = getSessionFactory().getCurrentSession().createQuery(queryString);
            query.setString("userId", userId);
            String roleName = "";
            List tmpList = query.list();
            if(tmpList.size()>0)
            {
                roleName = (String)tmpList.get(0);
            }
            return roleName;
        } catch (RuntimeException re) {
            // TODO: handle exception
            log.error("find roleName by userId failed", re);
            throw re;
        }
    }

}
