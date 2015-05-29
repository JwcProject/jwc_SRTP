package edu.cqu.no1.dao.impl;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;
import edu.cqu.no1.dao.*;
import edu.cqu.no1.domain.TPermission;
import edu.cqu.no1.util.PageBean;
import org.hibernate.Query;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by ZKQ on 2015/5/27.
 */

@Repository
public class TPermissionDAOImpl extends BaseDaoImpl<TPermission> implements TPermissionDAO {

    private static final Logger log = LoggerFactory
            .getLogger(TPermissionDAO.class);
    // property constants
    public static final String PERMISSION_NAME = "permissionName";
    public static final String PERMISSION_STATE = "permissionState";
    public static final String PERMISSION_URL = "permissionUrl";
    public static final String PERMISSION_LEVEL = "permissionLevel";
    public static final String PERMISSION_FATHERID = "permissionFatherid";
    public static final String PERMISSION_INTRODUCTION = "permissionIntroduction";
    public static final String ISDELETED = "isdeleted";



    public List findByPermissionName(Object permissionName) {
        return findByProperty(PERMISSION_NAME, permissionName);
    }


    public List findByPermissionState(Object permissionState) {
        return findByProperty(PERMISSION_STATE, permissionState);
    }


    public List findByPermissionUrl(Object permissionUrl) {
        return findByProperty(PERMISSION_URL, permissionUrl);
    }


    public List findByPermissionLevel(Object permissionLevel) {
        return findByProperty(PERMISSION_LEVEL, permissionLevel);
    }


    public List findByPermissionFatherid(Object permissionFatherid) {
        return findByProperty(PERMISSION_FATHERID, permissionFatherid);
    }


    public List findByPermissionIntroduction(Object permissionIntroduction) {
        return findByProperty(PERMISSION_INTRODUCTION, permissionIntroduction);
    }


    public List findByIsdeleted(Object isdeleted) {
        return findByProperty(ISDELETED, isdeleted);
    }


    public int getAllTPermissionCount()
    {
        log.debug("finding all TPermission counts");
        try {

			/*String queryString = "select count(*) from TUser as where s.isdeleted = '0'";
			List tmpList = this.getSession().createQuery(queryString).list();*/


			/*String queryString = "select count(1) from T_User where isdeleted = '0'";
			List tmpList = this.getSession().createSQLQuery(queryString).list();*/

            String queryStr = "select count(*) from TPermission as a where a.isdeleted='N'";
            List tmpList = getSessionFactory().getCurrentSession().createQuery(queryStr).list();

            int count = 0;

            if(tmpList.size()>0)
            {
                count = new Integer(""+tmpList.get(0));
            }

            return count;
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }
    }



    public List findAll(PageBean pageBean) {
        log.debug("finding all TPermission instances");
        try {
            String queryString = "from TPermission as p where p.isdeleted = 'N'";
            Query query = getSessionFactory().getCurrentSession().createQuery(queryString);
            query.setFetchSize(pageBean.getBeginIndex());
            query.setMaxResults(pageBean.getPageCapibility());
            return query.list();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }
    }
    //write by pzh

    public List findAllExceptDeleted() {
        log.debug("finding all TPermission instances except deleted");
        try {
            String queryString = "from TPermission as p where p.isdeleted = 'N'";
            Query query =getSessionFactory().getCurrentSession().createQuery(queryString);
            return query.list();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }
    }


    public static TPermissionDAO getFromApplicationContext(
            ApplicationContext ctx) {
        return (TPermissionDAO) ctx.getBean("TPermissionDAO");
    }


    /**
     * lsp
     */
    /**
     * 过滤查询
     */

    public List seachPermission(TPermission instance, PageBean pageBean){
        log.debug("search TPermission instances except deleted");
        try {
            String sql="";
            try {
                sql = getSqlStr("TPermission", instance.getClass(), instance);
                sql = sql.replace("=:permissionName", " like :permissionName");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            return getQueryBySql(sql, instance)
                    .setFirstResult(pageBean.getBeginIndex())
                    .setMaxResults(pageBean.getPageCapibility())
                    .list();
        }catch (RuntimeException re) {
            log.error("search failed", re);
            throw re;
        }
    }

    public int getSearchCount(TPermission instance){
        log.debug("search TPermission count except deleted");
        try {
            String sql="";
            try {
                sql = "select count(*) " + getSqlStr("TPermission", instance.getClass(), instance);
                sql = sql.replace("=:permissionName", " like :permissionName");
                //System.out.println(sql);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            List tempList = getQueryBySql(sql, instance).list();
            int count = 0;
            if (tempList.size() > 0) {
                count = new Integer("" + tempList.get(0));
            }
            return count;
        }catch (RuntimeException re) {
            log.error("search failed", re);
            throw re;
        }
    }
    private String getSqlStr(String table,Class instanceClass,Object instance) throws IllegalArgumentException, IllegalAccessException{
        String sql = "from " + table + "  where isdeleted='N' ";
        Field[] filds = instanceClass.getDeclaredFields();
        for (Field field : filds) {
            boolean accessFlag = field.isAccessible();
            field.setAccessible(true);
            Object object = field.get(instance);
            if(null != object && !"[]".equals(object.toString()) && !"".equals(object.toString())){
                sql += " and " + field.getName() + "=:"+field.getName();
            }
            field.setAccessible(accessFlag);
        }
        return sql;
    }
    private Query getQueryBySql(String sql,TPermission instance){
        Query query = getSessionFactory().getCurrentSession().createQuery(sql);
        if(!"".equals(instance.getPermissionName())){
            query.setString("permissionName", "%"+instance.getPermissionName()+"%");
        }
        if(!"".equals(instance.getPermissionLevel())){
            System.out.println("level-->" + instance.getPermissionLevel());
            query.setString("permissionLevel", instance.getPermissionLevel()+" ");
        }
        if(!(null==instance.getPermissionState()) && !"".equals(instance.getPermissionState())){
            query.setString("permissionState", instance.getPermissionState());
        }
        return query;
    }

    @SuppressWarnings("unchecked")
    public List getChildPermissionsById(String id){
        String sql = "from TPermission where isdeleted='N' and permissionFatherid is null";
        if(null != id){
            sql = "from TPermission where isdeleted='N' and permissionFatherid=:permissionFatherid";
        }
        Query query =getSessionFactory().getCurrentSession().createQuery(sql);
        if(null != id){
            query.setString("permissionFatherid", id);
        }
        return query.list();
    }
}
