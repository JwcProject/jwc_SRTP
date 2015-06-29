package com.isse.dao;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.isse.model.TProfession;

/**
 * A data access object (DAO) providing persistence and search support for
 * TProfession entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.isse.model.TProfession
 * @author MyEclipse Persistence Tools
 */

public class TProfessionDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(TProfessionDAO.class);
	// property constants
	public static final String PROFESSION_NAME = "professionName";
	public static final String PROFESSION_SESSION = "professionSession";
	public static final String PROFESSION_CLASS = "professionClass";
	public static final String PROFESSION_REMARK = "professionRemark";
	public static final String PROFESSION_ISDELETED = "professionIsdeleted";

	protected void initDao() {
		// do nothing
	}

	public void save(TProfession transientInstance) {
		log.debug("saving TProfession instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TProfession persistentInstance) {
		log.debug("deleting TProfession instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TProfession findById(java.lang.String id) {
		log.debug("getting TProfession instance with id: " + id);
		try {
			TProfession instance = (TProfession) getHibernateTemplate().get(
					"com.isse.model.TProfession", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TProfession instance) {
		log.debug("finding TProfession instance by example");
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
		log.debug("finding TProfession instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TProfession as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	//根据学院主管教师的工号获取该学院所有专业列表
	public List findProfessionsByTeaCode(String teaCode){
		log.debug("finding all professions by teacher code ");
		try {
			String queryStr = "from TProfession as p where p.professionIsdeleted = 'N' and p.TUnit.unitId=" +
					"(select a.TUnit.unitId from TTeacher as a where a.teaCode=:code)";
			Query query = this.getSession().createQuery(queryStr);
			query.setString("code", teaCode);
			
			return query.list();
		} catch (RuntimeException e) {
			log.error("find all professions failed", e);
			throw e;
		}
	}
	@SuppressWarnings("unchecked")
	public List<TProfession> getProfessionsByTeacherId(String teacherId) {
		log.debug("getProfessionsByTeacherId");
		try {
			String queryStr = "from TProfession as p where p.professionIsdeleted = 'N' and p.TUnit.unitId=" +
					"(select a.TUnit.unitId from TTeacher as a where a.teaId=:teacherId)";
			Query query = this.getSession().createQuery(queryStr);
			query.setString("teacherId", teacherId);
			return query.list();
		} catch (RuntimeException e) {
			log.error("getProfessionsByTeacherId failed", e);
			throw e;
		}
	}
	public List findByProfessionName(Object professionName) {
		return findByProperty(PROFESSION_NAME, professionName);
	}

	public List findByProfessionSession(Object professionSession) {
		return findByProperty(PROFESSION_SESSION, professionSession);
	}

	public List findByProfessionClass(Object professionClass) {
		return findByProperty(PROFESSION_CLASS, professionClass);
	}

	public List findByProfessionRemark(Object professionRemark) {
		return findByProperty(PROFESSION_REMARK, professionRemark);
	}

	public List findByProfessionIsdeleted(Object professionIsdeleted) {
		return findByProperty(PROFESSION_ISDELETED, professionIsdeleted);
	}

	public List findAll() {
		log.debug("finding all TProfession instances");
		try {
			String queryString = "from TProfession";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TProfession merge(TProfession detachedInstance) {
		log.debug("merging TProfession instance");
		try {
			TProfession result = (TProfession) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TProfession instance) {
		log.debug("attaching dirty TProfession instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TProfession instance) {
		log.debug("attaching clean TProfession instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TProfessionDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (TProfessionDAO) ctx.getBean("TProfessionDAO");
	}
}