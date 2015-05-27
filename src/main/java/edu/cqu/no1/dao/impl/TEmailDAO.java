package edu.cqu.no1.dao.impl;

import java.util.Date;
import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.isse.model.TEmail;

/**
 * A data access object (DAO) providing persistence and search support for
 * TEmail entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.isse.model.TEmail
 * @author MyEclipse Persistence Tools
 */

public class TEmailDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(TEmailDAO.class);
	// property constants
	public static final String EMAIL_TITLE = "emailTitle";
	public static final String EMAIL_CONTENT = "emailContent";
	public static final String SENDER = "sender";
	public static final String EMAIL_SECRET = "emailSecret";
	public static final String SEND_STATE = "sendState";
	public static final String ISDELETED = "isdeleted";

	protected void initDao() {
		// do nothing
	}

	public void save(TEmail transientInstance) {
		log.debug("saving TEmail instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TEmail persistentInstance) {
		log.debug("deleting TEmail instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TEmail findById(String id) {
		log.debug("getting TEmail instance with id: " + id);
		try {
			TEmail instance = (TEmail) getHibernateTemplate().get(
					"com.isse.model.TEmail", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TEmail instance) {
		log.debug("finding TEmail instance by example");
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
		log.debug("finding TEmail instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TEmail as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByEmailTitle(Object emailTitle) {
		return findByProperty(EMAIL_TITLE, emailTitle);
	}

	public List findByEmailContent(Object emailContent) {
		return findByProperty(EMAIL_CONTENT, emailContent);
	}

	public List findBySender(Object sender) {
		return findByProperty(SENDER, sender);
	}

	public List findByEmailSecret(Object emailSecret) {
		return findByProperty(EMAIL_SECRET, emailSecret);
	}

	public List findBySendState(Object sendState) {
		return findByProperty(SEND_STATE, sendState);
	}

	public List findByIsdeleted(Object isdeleted) {
		return findByProperty(ISDELETED, isdeleted);
	}

	public List findAll() {
		log.debug("finding all TEmail instances");
		try {
			String queryString = "from TEmail";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TEmail merge(TEmail detachedInstance) {
		log.debug("merging TEmail instance");
		try {
			TEmail result = (TEmail) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TEmail instance) {
		log.debug("attaching dirty TEmail instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TEmail instance) {
		log.debug("attaching clean TEmail instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TEmailDAO getFromApplicationContext(ApplicationContext ctx) {
		return (TEmailDAO) ctx.getBean("TEmailDAO");
	}
}