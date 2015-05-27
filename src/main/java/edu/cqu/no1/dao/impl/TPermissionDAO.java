package edu.cqu.no1.dao.impl;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.isse.model.TPermission;
import com.util.PageBean;

/**
 * A data access object (DAO) providing persistence and search support for
 * TPermission entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.isse.model.TPermission
 * @author MyEclipse Persistence Tools
 */

public class TPermissionDAO extends HibernateDaoSupport {
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

	protected void initDao() {
		// do nothing
	}

	public void save(TPermission transientInstance) {
		log.debug("saving TPermission instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TPermission persistentInstance) {
		log.debug("deleting TPermission instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TPermission findById(String id) {
		log.debug("getting TPermission instance with id: " + id);
		try {
			TPermission instance = (TPermission) getHibernateTemplate().get(
					"com.isse.model.TPermission", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TPermission instance) {
		log.debug("finding TPermission instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TPermission instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TPermission as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

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
			List tmpList = this.getSession().createQuery(queryStr).list();
			
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
	
	public List findAll(){
		log.debug("finding all TPermission instances");
		try {
			String queryString = "from TPermission";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public List findAll(PageBean pageBean) {
		log.debug("finding all TPermission instances");
		try {
			String queryString = "from TPermission as p where p.isdeleted = 'N'";
			Query query = this.getSession().createQuery(queryString);
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
			Query query = this.getSession().createQuery(queryString);
			return query.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	public TPermission merge(TPermission detachedInstance) {
		log.debug("merging TPermission instance");
		try {
			TPermission result = (TPermission) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TPermission instance) {
		log.debug("attaching dirty TPermission instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TPermission instance) {
		log.debug("attaching clean TPermission instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
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
	public List seachPermission(TPermission instance,PageBean pageBean){
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
		Query query = this.getSession().createQuery(sql);
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
		Query query = this.getSession().createQuery(sql);
		if(null != id){
			query.setString("permissionFatherid", id);
		}
		return query.list();
	}
}