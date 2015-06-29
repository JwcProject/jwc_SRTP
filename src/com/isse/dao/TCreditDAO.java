package com.isse.dao;

import java.math.BigDecimal;
import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.isse.model.TCredit;

/**
 * A data access object (DAO) providing persistence and search support for
 * TCredit entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.isse.model.TCredit
 * @author MyEclipse Persistence Tools
 */

public class TCreditDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(TCreditDAO.class);
	// property constants
	public static final String CREDIT_SCORE = "creditScore";
	public static final String ISDELETED = "isdeleted";

	protected void initDao() {
		// do nothing
	}

	public void save(TCredit transientInstance) {
		log.debug("saving TCredit instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TCredit persistentInstance) {
		log.debug("deleting TCredit instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TCredit findById(java.lang.String id) {
		log.debug("getting TCredit instance with id: " + id);
		try {
			TCredit instance = (TCredit) getHibernateTemplate().get(
					"com.isse.model.TCredit", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TCredit instance) {
		log.debug("finding TCredit instance by example");
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
		log.debug("finding TCredit instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TCredit as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByCreditScore(Object creditScore) {
		return findByProperty(CREDIT_SCORE, creditScore);
	}

	public List findByIsdeleted(Object isdeleted) {
		return findByProperty(ISDELETED, isdeleted);
	}

	public List findAll() {
		log.debug("finding all TCredit instances");
		try {
			String queryString = "from TCredit";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TCredit merge(TCredit detachedInstance) {
		log.debug("merging TCredit instance");
		try {
			TCredit result = (TCredit) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TCredit instance) {
		log.debug("attaching dirty TCredit instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TCredit instance) {
		log.debug("attaching clean TCredit instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TCreditDAO getFromApplicationContext(ApplicationContext ctx) {
		return (TCreditDAO) ctx.getBean("TCreditDAO");
	}
}