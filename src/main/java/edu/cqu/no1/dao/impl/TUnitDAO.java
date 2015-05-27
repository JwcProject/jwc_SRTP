package edu.cqu.no1.dao.impl;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.isse.model.TUnit;

/**
 * A data access object (DAO) providing persistence and search support for TUnit
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.isse.model.TUnit
 * @author MyEclipse Persistence Tools
 */

public class TUnitDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(TUnitDAO.class);
	// property constants
	public static final String UNIT_NAME = "unitName";
	public static final String UNIT_TYPE = "unitType";
	public static final String UNIT_FATHERID = "unitFatherid";
	public static final String UNIT_CODE = "unitCode";
	public static final String UNIT_REMARK = "unitRemark";
	public static final String ISDELETED = "isdeleted";

	protected void initDao() {
		// do nothing
	}

	public void save(TUnit transientInstance) {
		log.debug("saving TUnit instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TUnit persistentInstance) {
		log.debug("deleting TUnit instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TUnit findById(String id) {
		log.debug("getting TUnit instance with id: " + id);
		try {
			TUnit instance = (TUnit) getHibernateTemplate().get(
					"com.isse.model.TUnit", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TUnit instance) {
		log.debug("finding TUnit instance by example");
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
		log.debug("finding TUnit instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TUnit as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	

	public List findByUnitName(Object unitName) {
		return findByProperty(UNIT_NAME, unitName);
	}

	public List findByUnitType(Object unitType) {
		return findByProperty(UNIT_TYPE, unitType);
	}

	public List findByUnitFatherid(Object unitFatherid) {
		return findByProperty(UNIT_FATHERID, unitFatherid);
	}

	public List findByUnitCode(Object unitCode) {
		return findByProperty(UNIT_CODE, unitCode);
	}

	public List findByUnitRemark(Object unitRemark) {
		return findByProperty(UNIT_REMARK, unitRemark);
	}

	public List findByIsdeleted(Object isdeleted) {
		return findByProperty(ISDELETED, isdeleted);
	}

	public List findAll() {
		log.debug("finding all TUnit instances");
		try {
			String queryString = "from TUnit";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TUnit merge(TUnit detachedInstance) {
		log.debug("merging TUnit instance");
		try {
			TUnit result = (TUnit) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TUnit instance) {
		log.debug("attaching dirty TUnit instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TUnit instance) {
		log.debug("attaching clean TUnit instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TUnitDAO getFromApplicationContext(ApplicationContext ctx) {
		return (TUnitDAO) ctx.getBean("TUnitDAO");
	}
	/**
	 * lsp 
	 */
	/**
	 * 根据教师ID查询单位
	 */
	public TUnit getUnitByTeacherId(String teaId){
		log.debug("getUnitByUserId");
		try {
			String sql = "select t.TUnit from TTeacher as t where t.teaCode=?"; 
			Query query = getSession().createQuery(sql);
			query.setString(0, teaId);
			List list = query.list();
			if (list != null && list.size() > 0) {
				log.debug("getUnitByUserId successful");
				return (TUnit) list.get(0);
			}else {
				return null;
			}			
		} catch (RuntimeException re) {
			log.error("getUnitByUserId", re);
			throw re;
		}
	}
	public List getAllColleges(){
		log.debug("getAllColleges");
		try {
			String sql = "from TUnit where isdeleted='N' and unitName like '%学院%'"; 
			Query query = getSession().createQuery(sql);
		    return query.list();
		} catch (RuntimeException re) {
			log.error("getAllColleges failed", re);
			throw re;
		}
	}
}