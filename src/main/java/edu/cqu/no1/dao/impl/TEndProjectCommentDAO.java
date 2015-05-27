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

import com.isse.model.TEndProject;
import com.isse.model.TEndProjectComment;
import com.util.PageBean;

/**
 * A data access object (DAO) providing persistence and search support for
 * TEndProjectComment entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.isse.model.TEndProjectComment
 * @author MyEclipse Persistence Tools
 */

public class TEndProjectCommentDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(TEndProjectCommentDAO.class);
	// property constants
	public static final String ENDPROJECTCOMMENT_ADVISE = "endprojectcommentAdvise";
	public static final String ENDPROJECTCOMMENT_CONTENT = "endprojectcommentContent";
	public static final String ISDELETED = "isdeleted";

	protected void initDao() {
		// do nothing
	}

	
	//获取一个教师可以评审的结题
	public List<TEndProjectComment> findMyReviewEndPros(String teaCode,PageBean pageBean){
		log.debug("finding teacher review TEndProjectComment by pageBean");
		try {
			String sql = "From TEndProjectComment T where T.isdeleted='N' and T.TEndProjectExport.TExpertTeacher.TTeacher.teaCode=:code"; 
			Query query = this.getSession().createQuery(sql);
			query.setString("code", teaCode);
			query.setFirstResult(pageBean.getBeginIndex());
			query.setMaxResults(pageBean.getPageCapibility());
			return query.list();
		} catch (RuntimeException e) {
			log.error("finding teacher review TEndProjectComment by pageBean failed", e);
			throw e;
		}
	}
	public int findMyReviewEndProsCount(String teaCode){
		log.debug("finding teacher review TEndProjectComment count");
		try {
			String sql = "select count(*) From TEndProjectComment T where T.isdeleted='N' and T.TEndProjectExport.TExpertTeacher.TTeacher.teaCode=:code"; 
			Query query = this.getSession().createQuery(sql);
			query.setString("code", teaCode);
			List list = query.list();
			int count = 0;
			if(list.size()>0){
				count = new Integer(""+list.get(0));
			}
			return count;
		} catch (RuntimeException e) {
			log.error("finding teacher review TEndProjectComment count failed", e);
			throw e;
		}
	}
	public void save(TEndProjectComment transientInstance) {
		log.debug("saving TEndProjectComment instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TEndProjectComment persistentInstance) {
		log.debug("deleting TEndProjectComment instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TEndProjectComment findById(String id) {
		log.debug("getting TEndProjectComment instance with id: " + id);
		try {
			TEndProjectComment instance = (TEndProjectComment) getHibernateTemplate()
					.get("com.isse.model.TEndProjectComment", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TEndProjectComment instance) {
		log.debug("finding TEndProjectComment instance by example");
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
		log.debug("finding TEndProjectComment instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TEndProjectComment as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByEndprojectcommentAdvise(Object endprojectcommentAdvise) {
		return findByProperty(ENDPROJECTCOMMENT_ADVISE, endprojectcommentAdvise);
	}

	public List findByEndprojectcommentContent(Object endprojectcommentContent) {
		return findByProperty(ENDPROJECTCOMMENT_CONTENT,
				endprojectcommentContent);
	}

	public List findByIsdeleted(Object isdeleted) {
		return findByProperty(ISDELETED, isdeleted);
	}

	public List findAll() {
		log.debug("finding all TEndProjectComment instances");
		try {
			String queryString = "from TEndProjectComment";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TEndProjectComment merge(TEndProjectComment detachedInstance) {
		log.debug("merging TEndProjectComment instance");
		try {
			TEndProjectComment result = (TEndProjectComment) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TEndProjectComment instance) {
		log.debug("attaching dirty TEndProjectComment instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TEndProjectComment instance) {
		log.debug("attaching clean TEndProjectComment instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TEndProjectCommentDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (TEndProjectCommentDAO) ctx.getBean("TEndProjectCommentDAO");
	}
}