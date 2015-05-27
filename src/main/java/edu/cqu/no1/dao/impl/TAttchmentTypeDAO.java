package edu.cqu.no1.dao.impl;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.isse.model.TAttchmentType;

/**
 * A data access object (DAO) providing persistence and search support for
 * TAttchmentType entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.isse.model.TAttchmentType
 * @author MyEclipse Persistence Tools
 */

public class TAttchmentTypeDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(TAttchmentTypeDAO.class);
	// property constants
	public static final String ATTA_TYPE_NAME = "attaTypeName";
	public static final String ISDELETED = "isdeleted";

	protected void initDao() {
		// do nothing
	}

	public void save(TAttchmentType transientInstance) {
		log.debug("saving TAttchmentType instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TAttchmentType persistentInstance) {
		log.debug("deleting TAttchmentType instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TAttchmentType findById(String id) {
		log.debug("getting TAttchmentType instance with id: " + id);
		try {
			TAttchmentType instance = (TAttchmentType) getHibernateTemplate()
					.get("com.isse.model.TAttchmentType", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TAttchmentType instance) {
		log.debug("finding TAttchmentType instance by example");
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
		log.debug("finding TAttchmentType instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TAttchmentType as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByAttaTypeName(Object attaTypeName) {
		return findByProperty(ATTA_TYPE_NAME, attaTypeName);
	}

	public List findByIsdeleted(Object isdeleted) {
		return findByProperty(ISDELETED, isdeleted);
	}

	public List findAll() {
		log.debug("finding all TAttchmentType instances");
		try {
			String queryString = "from TAttchmentType";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TAttchmentType merge(TAttchmentType detachedInstance) {
		log.debug("merging TAttchmentType instance");
		try {
			TAttchmentType result = (TAttchmentType) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TAttchmentType instance) {
		log.debug("attaching dirty TAttchmentType instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TAttchmentType instance) {
		log.debug("attaching clean TAttchmentType instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TAttchmentTypeDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (TAttchmentTypeDAO) ctx.getBean("TAttchmentTypeDAO");
	}
}