package com.isse.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.isse.model.TEmailReceiver;

/**
 * A data access object (DAO) providing persistence and search support for
 * TEmailReceiver entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.isse.model.TEmailReceiver
 * @author MyEclipse Persistence Tools
 */

public class TEmailReceiverDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(TEmailReceiverDAO.class);
	// property constants
	public static final String RECEIVER_CODE = "receiverCode";
	public static final String RECEIVER_ROLE = "receiverRole";
	public static final String EMAIL_ADDRESS = "emailAddress";
	public static final String IS_RECEIVED = "isReceived";
	public static final String ISDELETED = "isdeleted";

	protected void initDao() {
		// do nothing
	}

	public void save(TEmailReceiver transientInstance) {
		log.debug("saving TEmailReceiver instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TEmailReceiver persistentInstance) {
		log.debug("deleting TEmailReceiver instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TEmailReceiver findById(java.lang.String id) {
		log.debug("getting TEmailReceiver instance with id: " + id);
		try {
			TEmailReceiver instance = (TEmailReceiver) getHibernateTemplate()
					.get("com.isse.model.TEmailReceiver", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TEmailReceiver instance) {
		log.debug("finding TEmailReceiver instance by example");
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
		log.debug("finding TEmailReceiver instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TEmailReceiver as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByReceiverCode(Object receiverCode) {
		return findByProperty(RECEIVER_CODE, receiverCode);
	}

	public List findByReceiverRole(Object receiverRole) {
		return findByProperty(RECEIVER_ROLE, receiverRole);
	}

	public List findByEmailAddress(Object emailAddress) {
		return findByProperty(EMAIL_ADDRESS, emailAddress);
	}

	public List findByIsReceived(Object isReceived) {
		return findByProperty(IS_RECEIVED, isReceived);
	}

	public List findByIsdeleted(Object isdeleted) {
		return findByProperty(ISDELETED, isdeleted);
	}

	public List findAll() {
		log.debug("finding all TEmailReceiver instances");
		try {
			String queryString = "from TEmailReceiver";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TEmailReceiver merge(TEmailReceiver detachedInstance) {
		log.debug("merging TEmailReceiver instance");
		try {
			TEmailReceiver result = (TEmailReceiver) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TEmailReceiver instance) {
		log.debug("attaching dirty TEmailReceiver instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TEmailReceiver instance) {
		log.debug("attaching clean TEmailReceiver instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TEmailReceiverDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (TEmailReceiverDAO) ctx.getBean("TEmailReceiverDAO");
	}
}