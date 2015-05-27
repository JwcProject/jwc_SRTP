package edu.cqu.no1.dao.impl;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.isse.model.TFunds;

/**
 * A data access object (DAO) providing persistence and search support for
 * TFunds entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.isse.model.TFunds
 * @author MyEclipse Persistence Tools
 */

public class TFundsDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(TFundsDAO.class);
	// property constants
	public static final String FUNDS_ID = "fundsId";
	public static final String FUNDS_NAME = "fundsName";
	public static final String FUNDS_ISREIMBURSE = "fundsIsreimburse";
	public static final String FUNDS_MONEY = "fundsMoney";
	public static final String FUNDS_DETAIL = "fundsDetail";
	public static final String FUNDS_USE = "fundsUse";
	public static final String ISDELETED = "isdeleted";

	protected void initDao() {
		// do nothing
	}

	public void save(TFunds transientInstance) {
		log.debug("saving TFunds instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TFunds persistentInstance) {
		log.debug("deleting TFunds instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TFunds findById(String id) {
		log.debug("getting TFunds instance with id: " + id);
		try {
			TFunds instance = (TFunds) getHibernateTemplate().get(
					"com.isse.model.TFunds", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TFunds instance) {
		log.debug("finding TFunds instance by example");
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
		log.debug("finding TFunds instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TFunds as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByFundsId(Object fundsId) {
		return findByProperty(FUNDS_ID, fundsId);
	}

	public List findByFundsName(Object fundsName) {
		return findByProperty(FUNDS_NAME, fundsName);
	}

	public List findByFundsIsreimburse(Object fundsIsreimburse) {
		return findByProperty(FUNDS_ISREIMBURSE, fundsIsreimburse);
	}

	public List findByFundsMoney(Object fundsMoney) {
		return findByProperty(FUNDS_MONEY, fundsMoney);
	}

	public List findByFundsDetail(Object fundsDetail) {
		return findByProperty(FUNDS_DETAIL, fundsDetail);
	}

	public List findByFundsUse(Object fundsUse) {
		return findByProperty(FUNDS_USE, fundsUse);
	}

	public List findByIsdeleted(Object isdeleted) {
		return findByProperty(ISDELETED, isdeleted);
	}

	public List findAll() {
		log.debug("finding all TFunds instances");
		try {
			String queryString = "from TFunds";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TFunds merge(TFunds detachedInstance) {
		log.debug("merging TFunds instance");
		try {
			TFunds result = (TFunds) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TFunds instance) {
		log.debug("attaching dirty TFunds instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TFunds instance) {
		log.debug("attaching clean TFunds instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TFundsDAO getFromApplicationContext(ApplicationContext ctx) {
		return (TFundsDAO) ctx.getBean("TFundsDAO");
	}
}