package com.isse.dao;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.isse.model.TEndProjectExport;
import com.util.PageBean;

/**
 * A data access object (DAO) providing persistence and search support for
 * TEndProjectExport entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.isse.model.TEndProjectExport
 * @author MyEclipse Persistence Tools
 */

public class TEndProjectExportDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(TEndProjectExportDAO.class);
	// property constants
	public static final String ISDELETED = "isdeleted";

	protected void initDao() {
		// do nothing
	}

	/**
	 * 
	 *TODO 获取一个专家教师可以进行网评的结题列表
	 *authoy lzh
	 *@param teaCode
	 *@param jieqiId
	 *@return
	 */
	public List<TEndProjectExport> findMyReviewEndPros(String teaCode,String jieqiId,PageBean pageBean){
		log.debug("find my review endprojects");
		try {
			String queryString = "From TEndProjectExport T where T.isdeleted='N' and T.TExpertTeacher.TTeacher.teaCode=:code and T.TEndProject.TJieqi.jqId=:id";
			Query query = this.getSession().createQuery(queryString);
			query.setString("code", teaCode);
			query.setString("id", jieqiId);
			query.setFirstResult(pageBean.getBeginIndex());
			query.setMaxResults(pageBean.getPageCapibility());
			return query.list();
		} catch (RuntimeException e) {
			log.error("find my review endprojects");
			throw e;
		}
	}
	
	/**
	 * 
	 *TODO 根据结题ID和教职工号获取结题评审专家对象
	 *authoy lzh
	 *@param teaCode
	 *@param endProId
	 *@return
	 */
	public TEndProjectExport findEndProExp(String teaCode,String endProId){
		log.debug("find TEndProjectExport by teaCode and endprojectId");
		try {
			String queryString="From TEndProjectExport T where T.isdeleted='N' and T.TEndProject.endprojectId=:id and T.TExpertTeacher.TTeacher.teaCode=:code";
			Query query = this.getSession().createQuery(queryString);
			query.setString("id", endProId);
			query.setString("code", teaCode);
			List list = query.list();
			TEndProjectExport tEndProjectExport = null;
			if(list.size()>0){
				tEndProjectExport = (TEndProjectExport) list.get(0);
			}
			return tEndProjectExport;
		} catch (RuntimeException e) {
			log.error("find TEndProjectExport by teaCode and endprojectId failed"+e);
			throw e;
		}
	}
	public int findMyReviewEndPros(String teaCode,String jieqiId){
		log.debug("find my review endprojects");
		try {
			String queryString = "select count(*) From TEndProjectExport T where T.isdeleted='N' and T.TExpertTeacher.TTeacher.teaCode=:code and T.TEndProject.TJieqi.jqId=:id";
			Query query = this.getSession().createQuery(queryString);
			query.setString("code", teaCode);
			query.setString("id", jieqiId);
			List list = query.list();
			int count =0;
			if(list.size()>0){
				count = new Integer(""+list.get(0));
			}
			return count;
		} catch (RuntimeException e) {
			log.error("find my review endprojects");
			throw e;
		}
	}
	
	public void save(TEndProjectExport transientInstance) {
		log.debug("saving TEndProjectExport instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TEndProjectExport persistentInstance) {
		log.debug("deleting TEndProjectExport instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TEndProjectExport findById(java.lang.String id) {
		log.debug("getting TEndProjectExport instance with id: " + id);
		try {
			TEndProjectExport instance = (TEndProjectExport) getHibernateTemplate()
					.get("com.isse.model.TEndProjectExport", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TEndProjectExport instance) {
		log.debug("finding TEndProjectExport instance by example");
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
		log.debug("finding TEndProjectExport instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TEndProjectExport as model where model."
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
		log.debug("finding all TEndProjectExport instances");
		try {
			String queryString = "from TEndProjectExport";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TEndProjectExport merge(TEndProjectExport detachedInstance) {
		log.debug("merging TEndProjectExport instance");
		try {
			TEndProjectExport result = (TEndProjectExport) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TEndProjectExport instance) {
		log.debug("attaching dirty TEndProjectExport instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TEndProjectExport instance) {
		log.debug("attaching clean TEndProjectExport instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TEndProjectExportDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (TEndProjectExportDAO) ctx.getBean("TEndProjectExportDAO");
	}
}