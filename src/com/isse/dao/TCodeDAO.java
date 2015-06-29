package com.isse.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.isse.model.TCode;

/**
 * A data access object (DAO) providing persistence and search support for TCode
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.isse.model.TCode
 * @author MyEclipse Persistence Tools
 */

public class TCodeDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(TCodeDAO.class);
	// property constants
	public static final String ENCODE_VALUE = "encodeValue";
	public static final String ENCODE_DESC = "encodeDesc";
	public static final String ENCODE_REMARK = "encodeRemark";
	public static final String ISDELETED = "isdeleted";

	protected void initDao() {
		// do nothing
	}

	public void save(TCode transientInstance) {
		log.debug("saving TCode instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TCode persistentInstance) {
		log.debug("deleting TCode instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TCode findById(java.lang.String id) {
		log.debug("getting TCode instance with id: " + id);
		try {
			TCode instance = (TCode) getHibernateTemplate().get(
					"com.isse.model.TCode", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TCode instance) {
		log.debug("finding TCode instance by example");
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
		log.debug("finding TCode instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TCode as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByEncodeValue(Object encodeValue) {
		return findByProperty(ENCODE_VALUE, encodeValue);
	}

	public List findByEncodeDesc(Object encodeDesc) {
		return findByProperty(ENCODE_DESC, encodeDesc);
	}

	public List findByEncodeRemark(Object encodeRemark) {
		return findByProperty(ENCODE_REMARK, encodeRemark);
	}

	public List findByIsdeleted(Object isdeleted) {
		return findByProperty(ISDELETED, isdeleted);
	}

	public List findAll() {
		log.debug("finding all TCode instances");
		try {
			String queryString = "from TCode";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TCode merge(TCode detachedInstance) {
		log.debug("merging TCode instance");
		try {
			TCode result = (TCode) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TCode instance) {
		log.debug("attaching dirty TCode instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TCode instance) {
		log.debug("attaching clean TCode instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TCodeDAO getFromApplicationContext(ApplicationContext ctx) {
		return (TCodeDAO) ctx.getBean("TCodeDAO");
	}
}