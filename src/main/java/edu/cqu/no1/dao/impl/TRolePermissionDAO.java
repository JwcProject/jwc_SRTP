package edu.cqu.no1.dao.impl;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.isse.model.TRolePermission;

/**
 * A data access object (DAO) providing persistence and search support for
 * TRolePermission entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.isse.model.TRolePermission
 * @author MyEclipse Persistence Tools
 */

public class TRolePermissionDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(TRolePermissionDAO.class);
	// property constants
	public static final String ISDELETED = "isdeleted";

	protected void initDao() {
		// do nothing
	}

	public void save(TRolePermission transientInstance) {
		log.debug("saving TRolePermission instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TRolePermission persistentInstance) {
		log.debug("deleting TRolePermission instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TRolePermission findById(String id) {
		log.debug("getting TRolePermission instance with id: " + id);
		try {
			TRolePermission instance = (TRolePermission) getHibernateTemplate()
					.get("com.isse.model.TRolePermission", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TRolePermission instance) {
		log.debug("finding TRolePermission instance by example");
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
		log.debug("finding TRolePermission instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TRolePermission as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByIsdeleted(Object isdeleted) {
		return findByProperty(ISDELETED, isdeleted);
	}

	public List findAll() {
		log.debug("finding all TRolePermission instances");
		try {
			String queryString = "from TRolePermission";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public List findByRoleId(String roleId) {
		log.debug("finding all TRolePermission instances by role id");
		try {
			String queryString = "from TRolePermission as model where model.TRole.roleId= ?";
			return this.getHibernateTemplate().find(queryString, roleId);
		} catch (RuntimeException re) {
			log.error("find all by role failed", re);
			throw re;
		}
	}

	public TRolePermission merge(TRolePermission detachedInstance) {
		log.debug("merging TRolePermission instance");
		try {
			TRolePermission result = (TRolePermission) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TRolePermission instance) {
		log.debug("attaching dirty TRolePermission instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TRolePermission instance) {
		log.debug("attaching clean TRolePermission instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TRolePermissionDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (TRolePermissionDAO) ctx.getBean("TRolePermissionDAO");
	}
}