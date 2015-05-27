package edu.cqu.no1.dao.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.isse.model.TDeclComment;

/**
 * A data access object (DAO) providing persistence and search support for
 * TDeclComment entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.isse.model.TDeclComment
 * @author MyEclipse Persistence Tools
 */

public class TDeclCommentDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(TDeclCommentDAO.class);
	// property constants
	public static final String DECL_ARGUMENT = "declArgument";
	public static final String COMP_EVAL = "compEval";
	public static final String ISDELETED = "isdeleted";

	protected void initDao() {
		// do nothing
	}

	public void save(TDeclComment transientInstance) {
		log.debug("saving TDeclComment instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TDeclComment persistentInstance) {
		log.debug("deleting TDeclComment instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TDeclComment findById(String id) {
		log.debug("getting TDeclComment instance with id: " + id);
		try {
			TDeclComment instance = (TDeclComment) getHibernateTemplate().get(
					"com.isse.model.TDeclComment", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TDeclComment instance) {
		log.debug("finding TDeclComment instance by example");
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
		log.debug("finding TDeclComment instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TDeclComment as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	//通过专家评审id得到网评对象
	public TDeclComment findByExpertReview(String exReviewId)
	{
		log.debug("get TDeclComment by expertReview");
		try {
			String queryString = "from TDeclComment td where td.isdeleted = 'N' and td.TExpertReview.exReviewId=:exReviewId";
			Query query = this.getSession().createQuery(queryString);
			query.setString("exReviewId", exReviewId);
			TDeclComment tDeclComment = null;
			List tempL = query.list();
			if(tempL.size()>0)
			{
				tDeclComment =(TDeclComment)tempL.get(0);
			}
			return tDeclComment;
		} catch (RuntimeException e) {
			// TODO: handle exception
			log.error("get TDeclComment by expertReview failed", e);
			throw e;
		}
	}

	public List findByDeclArgument(Object declArgument) {
		return findByProperty(DECL_ARGUMENT, declArgument);
	}

	public List findByCompEval(Object compEval) {
		return findByProperty(COMP_EVAL, compEval);
	}

	public List findByIsdeleted(Object isdeleted) {
		return findByProperty(ISDELETED, isdeleted);
	}

	public List findAll() {
		log.debug("finding all TDeclComment instances");
		try {
			String queryString = "from TDeclComment";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TDeclComment merge(TDeclComment detachedInstance) {
		log.debug("merging TDeclComment instance");
		try {
			TDeclComment result = (TDeclComment) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TDeclComment instance) {
		log.debug("attaching dirty TDeclComment instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TDeclComment instance) {
		log.debug("attaching clean TDeclComment instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TDeclCommentDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (TDeclCommentDAO) ctx.getBean("TDeclCommentDAO");
	}
}