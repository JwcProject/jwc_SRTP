package com.isse.dao;

import java.util.Date;
import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.isse.model.TProjectChange;

/**
 * A data access object (DAO) providing persistence and search support for
 * TProjectChange entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.isse.model.TProjectChange
 * @author MyEclipse Persistence Tools
 */

public class TProjectChangeDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(TProjectChangeDAO.class);
	// property constants
	public static final String PROJECTCHANGE_STATE = "projectchangeState";
	public static final String PROJECTCHANGE_ATID = "projectchangeAtid";
	public static final String PROJECTCHANGE_CTID = "projectchangeCtid";
	public static final String PROJECTCHANGE_REASON = "projectchangeReason";
	public static final String ISDELETED = "isdeleted";

	protected void initDao() {
		// do nothing
	}

	public void save(TProjectChange transientInstance) {
		log.debug("saving TProjectChange instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TProjectChange persistentInstance) {
		log.debug("deleting TProjectChange instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TProjectChange findById(java.lang.String id) {
		log.debug("getting TProjectChange instance with id: " + id);
		try {
			TProjectChange instance = (TProjectChange) getHibernateTemplate()
					.get("com.isse.model.TProjectChange", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TProjectChange instance) {
		log.debug("finding TProjectChange instance by example");
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
		log.debug("finding TProjectChange instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TProjectChange as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByProjectchangeState(Object projectchangeState) {
		return findByProperty(PROJECTCHANGE_STATE, projectchangeState);
	}

	public List findByProjectchangeAtid(Object projectchangeAtid) {
		return findByProperty(PROJECTCHANGE_ATID, projectchangeAtid);
	}

	public List findByProjectchangeCtid(Object projectchangeCtid) {
		return findByProperty(PROJECTCHANGE_CTID, projectchangeCtid);
	}

	public List findByProjectchangeReason(Object projectchangeReason) {
		return findByProperty(PROJECTCHANGE_REASON, projectchangeReason);
	}

	public List findByIsdeleted(Object isdeleted) {
		return findByProperty(ISDELETED, isdeleted);
	}

	public List findAll() {
		log.debug("finding all TProjectChange instances");
		try {
			String queryString = "from TProjectChange";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TProjectChange merge(TProjectChange detachedInstance) {
		log.debug("merging TProjectChange instance");
		try {
			TProjectChange result = (TProjectChange) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TProjectChange instance) {
		log.debug("attaching dirty TProjectChange instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TProjectChange instance) {
		log.debug("attaching clean TProjectChange instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TProjectChangeDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (TProjectChangeDAO) ctx.getBean("TProjectChangeDAO");
	}
}