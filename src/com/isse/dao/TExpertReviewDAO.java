package com.isse.dao;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.isse.model.TExpertReview;

/**
 * A data access object (DAO) providing persistence and search support for
 * TExpertReview entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.isse.model.TExpertReview
 * @author MyEclipse Persistence Tools
 */

public class TExpertReviewDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(TExpertReviewDAO.class);
	// property constants
	public static final String ISDELETED = "isdeleted";

	protected void initDao() {
		// do nothing
	}

	public void save(TExpertReview transientInstance) {
		log.debug("saving TExpertReview instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TExpertReview persistentInstance) {
		log.debug("deleting TExpertReview instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TExpertReview findById(java.lang.String id) {
		log.debug("getting TExpertReview instance with id: " + id);
		try {
			TExpertReview instance = (TExpertReview) getHibernateTemplate()
					.get("com.isse.model.TExpertReview", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TExpertReview instance) {
		log.debug("finding TExpertReview instance by example");
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
		log.debug("finding TExpertReview instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TExpertReview as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByIsdeleted(Object isdeleted) {
		return findByProperty(ISDELETED, isdeleted);
	}

	public List findAll() {
		log.debug("finding all TExpertReview instances");
		try {
			String queryString = "from TExpertReview";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/**
	 * 
	 *TODO 根据届期ID,教师教职工号，申报ID，专家库类别
	 *     获取对应的专家评审
	 *authoy lzh
	 *@param jqId
	 *@param teaCode
	 *@param declId
	 *@param type
	 *@return
	 */
	public TExpertReview getTExpertReview(String jqId,String teaCode,String declId,String type){
		log.debug("get TExpertREview By jqId,teaCode,declId,type");
		try {
			String queryString  = "From TExpertReview ER where ER.TDeclaration.declarId=:declId and ER.TExpertTeacher.exTeaId =" +
					" (select ET.exTeaId From TExpertTeacher ET where ET.TTeacher.teaId=(select TT.teaId from TTeacher TT where TT.teaCode=:teaCode)" +
					"and ET.TExpertLib.libId=(select EL.libId from TExpertLib EL where EL.TJieqi.jqId=:jqId and EL.type=:type))";
			Query query = this.getSession().createQuery(queryString);
			query.setString("declId", declId);
			query.setString("teaCode", teaCode);
			query.setString("jqId", jqId);
			query.setString("type", type);
			List list = query.list();
			TExpertReview tExpertReview = null;
			if(list.size()>0){
				tExpertReview = (TExpertReview) list.get(0);
			}
			return tExpertReview;
		} catch (RuntimeException e) {
			log.error("get TExpertREview By jqId,teaCode,declId,type failed" +e);
			throw e;
		}
	}
	
	public TExpertReview merge(TExpertReview detachedInstance) {
		log.debug("merging TExpertReview instance");
		try {
			TExpertReview result = (TExpertReview) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TExpertReview instance) {
		log.debug("attaching dirty TExpertReview instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TExpertReview instance) {
		log.debug("attaching clean TExpertReview instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TExpertReviewDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (TExpertReviewDAO) ctx.getBean("TExpertReviewDAO");
	}
}