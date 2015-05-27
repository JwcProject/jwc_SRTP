package edu.cqu.no1.dao.impl;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.isse.model.TDeclFund;
import com.isse.model.TDeclJob;

/**
 * A data access object (DAO) providing persistence and search support for
 * TDeclJob entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.isse.model.TDeclJob
 * @author MyEclipse Persistence Tools
 */

public class TDeclJobDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(TDeclJobDAO.class);
	// property constants
	public static final String JOB_CONTENT = "jobContent";
	public static final String ISDELETED = "isdeleted";

	protected void initDao() {
		// do nothing
	}

	public void save(TDeclJob transientInstance) {
		log.debug("saving TDeclJob instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TDeclJob persistentInstance) {
		log.debug("deleting TDeclJob instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TDeclJob findById(String id) {
		log.debug("getting TDeclJob instance with id: " + id);
		try {
			TDeclJob instance = (TDeclJob) getHibernateTemplate().get(
					"com.isse.model.TDeclJob", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TDeclJob instance) {
		log.debug("finding TDeclJob instance by example");
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
		log.debug("finding TDeclJob instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TDeclJob as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByJobContent(Object jobContent) {
		return findByProperty(JOB_CONTENT, jobContent);
	}

	public List findByIsdeleted(Object isdeleted) {
		return findByProperty(ISDELETED, isdeleted);
	}

	public List findAll() {
		log.debug("finding all TDeclJob instances");
		try {
			String queryString = "from TDeclJob";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TDeclJob merge(TDeclJob detachedInstance) {
		log.debug("merging TDeclJob instance");
		try {
			TDeclJob result = (TDeclJob) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TDeclJob instance) {
		log.debug("attaching dirty TDeclJob instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TDeclJob instance) {
		log.debug("attaching clean TDeclJob instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TDeclJobDAO getFromApplicationContext(ApplicationContext ctx) {
		return (TDeclJobDAO) ctx.getBean("TDeclJobDAO");
	}
	
	public List<TDeclJob> findByDeclarId(String declarId){
		log.debug("finding all TDeclJob instances");
		try {
			String queryStr = "from TDeclJob as a where a.isdeleted = 'N' " +
					"and a.TDeclaration.declarId=:code ";
			
			Query query = this.getSession().createQuery(queryStr);
			query.setString("code", declarId);
			
			return query.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	public int deleteJobByDeclId(String declarId) throws Exception{
		log.debug("deleteJobByDeclId");
		try {
			List<TDeclJob> list = findByDeclarId(declarId);
			for (TDeclJob tDeclJob : list) {
				tDeclJob.setIsdeleted("Y");
				merge(tDeclJob);
			}
			return list == null ? 0:list.size();
		} catch (RuntimeException re) {
			log.error("deleteJobByDeclId failed", re);
			throw re;
		}
	}
}