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
 * TDeclFund entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.isse.model.TDeclFund
 * @author MyEclipse Persistence Tools
 */

public class TDeclFundDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(TDeclFundDAO.class);
	// property constants
	public static final String SERIAL_NUM = "serialNum";
	public static final String FUND_CONTENT = "fundContent";
	public static final String AMOUNT = "amount";
	public static final String ISDELETED = "isdeleted";

	protected void initDao() {
		// do nothing
	}

	public void save(TDeclFund transientInstance) {
		log.debug("saving TDeclFund instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TDeclFund persistentInstance) {
		log.debug("deleting TDeclFund instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TDeclFund findById(String id) {
		log.debug("getting TDeclFund instance with id: " + id);
		try {
			TDeclFund instance = (TDeclFund) getHibernateTemplate().get(
					"com.isse.model.TDeclFund", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TDeclFund instance) {
		log.debug("finding TDeclFund instance by example");
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
		log.debug("finding TDeclFund instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TDeclFund as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findBySerialNum(Object serialNum) {
		return findByProperty(SERIAL_NUM, serialNum);
	}

	public List findByFundContent(Object fundContent) {
		return findByProperty(FUND_CONTENT, fundContent);
	}

	public List findByAmount(Object amount) {
		return findByProperty(AMOUNT, amount);
	}

	public List findByIsdeleted(Object isdeleted) {
		return findByProperty(ISDELETED, isdeleted);
	}

	public List findAll() {
		log.debug("finding all TDeclFund instances");
		try {
			String queryString = "from TDeclFund";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TDeclFund merge(TDeclFund detachedInstance) {
		log.debug("merging TDeclFund instance");
		try {
			TDeclFund result = (TDeclFund) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TDeclFund instance) {
		log.debug("attaching dirty TDeclFund instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TDeclFund instance) {
		log.debug("attaching clean TDeclFund instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TDeclFundDAO getFromApplicationContext(ApplicationContext ctx) {
		return (TDeclFundDAO) ctx.getBean("TDeclFundDAO");
	}
	
	public List<TDeclFund> findByDeclarId(String declarId){
		log.debug("finding all TDeclFund instances");
		try {
			String queryStr = "from TDeclFund as a where a.isdeleted = 'N' " +
					"and a.TDeclaration.declarId=:code ";
			
			Query query = this.getSession().createQuery(queryStr);
			query.setString("code", declarId);
			
			return query.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	public int deleteFundByDeclId(String declarId) throws Exception{
		log.debug("deleteFundByDeclId");
		try {
			List<TDeclFund> list = findByDeclarId(declarId);
			for (TDeclFund tDeclFund : list) {
				tDeclFund.setIsdeleted("Y");
				merge(tDeclFund);
			}
			return list == null ? 0:list.size();
		} catch (RuntimeException re) {
			log.error("deleteFundByDeclId failed", re);
			throw re;
		}
	}
}