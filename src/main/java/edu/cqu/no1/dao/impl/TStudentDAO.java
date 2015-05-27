package edu.cqu.no1.dao.impl;

import java.util.Date;
import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.isse.model.TStudent;

/**
 * A data access object (DAO) providing persistence and search support for
 * TStudent entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.isse.model.TStudent
 * @author MyEclipse Persistence Tools
 */

public class TStudentDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(TStudentDAO.class);
	// property constants
	public static final String STUDENT_NUMBER = "studentNumber";
	public static final String STUDENT_SEX = "studentSex";
	public static final String STUDENT_NAME = "studentName";
	public static final String STUDENT_AGE = "studentAge";
	public static final String STUDENT_EMAIL = "studentEmail";
	public static final String STUDENT_TELPHONE = "studentTelphone";
	public static final String STUDENT_DEGREE = "studentDegree";
	public static final String STUDENT_REMARK = "studentRemark";
	public static final String ISDELETED = "isdeleted";

	protected void initDao() {
		// do nothing
	}

	public void save(TStudent transientInstance) {
		log.debug("saving TStudent instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TStudent persistentInstance) {
		log.debug("deleting TStudent instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TStudent findById(String id) {
		log.debug("getting TStudent instance with id: " + id);
		try {
			TStudent instance = (TStudent) getHibernateTemplate().get(
					"com.isse.model.TStudent", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	public List findStudentByCode(String code) {
		log.debug("find student by student code");
		try {
			String queryStr = "from TStudent t where t.isdeleted = 'N' and t.studentNumber=:code";
			Query query = this.getSession().createQuery(queryStr);
			query.setString("code", code);
			return query.list();
		} catch (RuntimeException e) {
			log.error("get student failed", e);
			throw e;
		}
	}

	public List findByExample(TStudent instance) {
		log.debug("finding TStudent instance by example");
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
		log.debug("finding TStudent instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TStudent as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByStudentNumber(Object studentNumber) {
		return findByProperty(STUDENT_NUMBER, studentNumber);
	}

	public List findByStudentSex(Object studentSex) {
		return findByProperty(STUDENT_SEX, studentSex);
	}

	public List findByStudentName(Object studentName) {
		return findByProperty(STUDENT_NAME, studentName);
	}

	public List findByStudentAge(Object studentAge) {
		return findByProperty(STUDENT_AGE, studentAge);
	}

	public List findByStudentEmail(Object studentEmail) {
		return findByProperty(STUDENT_EMAIL, studentEmail);
	}

	public List findByStudentTelphone(Object studentTelphone) {
		return findByProperty(STUDENT_TELPHONE, studentTelphone);
	}

	public List findByStudentDegree(Object studentDegree) {
		return findByProperty(STUDENT_DEGREE, studentDegree);
	}

	public List findByStudentRemark(Object studentRemark) {
		return findByProperty(STUDENT_REMARK, studentRemark);
	}

	public List findByIsdeleted(Object isdeleted) {
		return findByProperty(ISDELETED, isdeleted);
	}

	public List findAll() {
		log.debug("finding all TStudent instances");
		try {
			String queryString = "from TStudent";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TStudent merge(TStudent detachedInstance) {
		log.debug("merging TStudent instance");
		try {
			TStudent result = (TStudent) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TStudent instance) {
		log.debug("attaching dirty TStudent instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TStudent instance) {
		log.debug("attaching clean TStudent instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TStudentDAO getFromApplicationContext(ApplicationContext ctx) {
		return (TStudentDAO) ctx.getBean("TStudentDAO");
	}
}