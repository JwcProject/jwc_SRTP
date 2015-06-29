package com.isse.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.isse.model.TUserRole;

/**
 * A data access object (DAO) providing persistence and search support for
 * TUserRole entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.isse.model.TUserRole
 * @author MyEclipse Persistence Tools
 */

public class TUserRoleDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(TUserRoleDAO.class);
	// property constants
	public static final String ISDELETED = "isdeleted";

	protected void initDao() {
		// do nothing
	}

	public void save(TUserRole transientInstance) {
		log.debug("saving TUserRole instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TUserRole persistentInstance) {
		log.debug("deleting TUserRole instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TUserRole findById(java.lang.String id) {
		log.debug("getting TUserRole instance with id: " + id);
		try {
			TUserRole instance = (TUserRole) getHibernateTemplate().get(
					"com.isse.model.TUserRole", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TUserRole instance) {
		log.debug("finding TUserRole instance by example");
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
		log.debug("finding TUserRole instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TUserRole as model where model."
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
		log.debug("finding all TUserRole instances");
		try {
			String queryString = "from TUserRole";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TUserRole merge(TUserRole detachedInstance) {
		log.debug("merging TUserRole instance");
		try {
			TUserRole result = (TUserRole) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TUserRole instance) {
		log.debug("attaching dirty TUserRole instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TUserRole instance) {
		log.debug("attaching clean TUserRole instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TUserRoleDAO getFromApplicationContext(ApplicationContext ctx) {
		return (TUserRoleDAO) ctx.getBean("TUserRoleDAO");
	}
}