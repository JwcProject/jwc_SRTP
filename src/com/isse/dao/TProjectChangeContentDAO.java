package com.isse.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.isse.model.TProjectChangeContent;

/**
 * A data access object (DAO) providing persistence and search support for
 * TProjectChangeContent entities. Transaction control of the save(), update()
 * and delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.isse.model.TProjectChangeContent
 * @author MyEclipse Persistence Tools
 */

public class TProjectChangeContentDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(TProjectChangeContentDAO.class);
	// property constants
	public static final String PROJECTCHANGECONTENT_FIELD = "projectchangecontentField";
	public static final String PROJECTCHANGECONTENT_FIELDNAME = "projectchangecontentFieldname";
	public static final String PROJECTCHANGECONTENT_OVALUE = "projectchangecontentOvalue";
	public static final String PROJECTCHANGECONTENT_NVALUE = "projectchangecontentNvalue";
	public static final String ISDELETED = "isdeleted";

	protected void initDao() {
		// do nothing
	}

	public void save(TProjectChangeContent transientInstance) {
		log.debug("saving TProjectChangeContent instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TProjectChangeContent persistentInstance) {
		log.debug("deleting TProjectChangeContent instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TProjectChangeContent findById(java.lang.String id) {
		log.debug("getting TProjectChangeContent instance with id: " + id);
		try {
			TProjectChangeContent instance = (TProjectChangeContent) getHibernateTemplate()
					.get("com.isse.model.TProjectChangeContent", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TProjectChangeContent instance) {
		log.debug("finding TProjectChangeContent instance by example");
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
		log.debug("finding TProjectChangeContent instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TProjectChangeContent as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByProjectchangecontentField(Object projectchangecontentField) {
		return findByProperty(PROJECTCHANGECONTENT_FIELD,
				projectchangecontentField);
	}

	public List findByProjectchangecontentFieldname(
			Object projectchangecontentFieldname) {
		return findByProperty(PROJECTCHANGECONTENT_FIELDNAME,
				projectchangecontentFieldname);
	}

	public List findByProjectchangecontentOvalue(
			Object projectchangecontentOvalue) {
		return findByProperty(PROJECTCHANGECONTENT_OVALUE,
				projectchangecontentOvalue);
	}

	public List findByProjectchangecontentNvalue(
			Object projectchangecontentNvalue) {
		return findByProperty(PROJECTCHANGECONTENT_NVALUE,
				projectchangecontentNvalue);
	}

	public List findByIsdeleted(Object isdeleted) {
		return findByProperty(ISDELETED, isdeleted);
	}

	public List findAll() {
		log.debug("finding all TProjectChangeContent instances");
		try {
			String queryString = "from TProjectChangeContent";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TProjectChangeContent merge(TProjectChangeContent detachedInstance) {
		log.debug("merging TProjectChangeContent instance");
		try {
			TProjectChangeContent result = (TProjectChangeContent) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TProjectChangeContent instance) {
		log.debug("attaching dirty TProjectChangeContent instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TProjectChangeContent instance) {
		log.debug("attaching clean TProjectChangeContent instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TProjectChangeContentDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (TProjectChangeContentDAO) ctx
				.getBean("TProjectChangeContentDAO");
	}
}