package edu.cqu.no1.dao.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.omg.PortableServer.LIFESPAN_POLICY_ID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.isse.model.TJieqi;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.util.PageBean;

/**
 * A data access object (DAO) providing persistence and search support for
 * TJieqi entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.isse.model.TJieqi
 * @author MyEclipse Persistence Tools
 */

public class TJieqiDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(TJieqiDAO.class);
	// property constants
	public static final String JQ_NAME = "jqName";
	public static final String QICI = "qici";
	public static final String SECONDARY_ASSESSMENT = "secondaryAssessment";
	public static final String SECONDARY_RESPONDENT = "secondaryRespondent";
	public static final String ISDELETED = "isdeleted";

	protected void initDao() {
		// do nothing
	}

	public void save(TJieqi transientInstance) {
		log.debug("saving TJieqi instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TJieqi persistentInstance) {
		log.debug("deleting TJieqi instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TJieqi findById(String id) {
		log.debug("getting TJieqi instance with id: " + id);
		try {
			TJieqi instance = (TJieqi) getHibernateTemplate().get(
					"com.isse.model.TJieqi", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TJieqi instance) {
		log.debug("finding TJieqi instance by example");
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
		log.debug("finding TJieqi instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TJieqi as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByJqName(Object jqName) {
		return findByProperty(JQ_NAME, jqName);
	}

	public List findByQici(Object qici) {
		return findByProperty(QICI, qici);
	}

	public List findBySecondaryAssessment(Object secondaryAssessment) {
		return findByProperty(SECONDARY_ASSESSMENT, secondaryAssessment);
	}

	public List findBySecondaryRespondent(Object secondaryRespondent) {
		return findByProperty(SECONDARY_RESPONDENT, secondaryRespondent);
	}

	public List findByIsdeleted(Object isdeleted) {
		return findByProperty(ISDELETED, isdeleted);
	}

	public List findAll() {
		log.debug("finding all TJieqi instances");
		try {
			String queryString = "from TJieqi";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TJieqi merge(TJieqi detachedInstance) {
		log.debug("merging TJieqi instance");
		try {
			TJieqi result = (TJieqi) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TJieqi instance) {
		log.debug("attaching dirty TJieqi instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TJieqi instance) {
		log.debug("attaching clean TJieqi instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TJieqiDAO getFromApplicationContext(ApplicationContext ctx) {
		return (TJieqiDAO) ctx.getBean("TJieqiDAO");
	}
	/**
	 * lsp 根据当前时间获取届期（当前申报的）
	 */
	
	public TJieqi getJieqiNow(){
		log.debug("getJieqiNow");
		try {
//			String queryString = "from TJieqi as model where SYSDATE between model.startOn and model.endOn";
//			List list = getHibernateTemplate().find(queryString);
//			if (list != null && list.size() > 0) {
//				return (TJieqi) list.get(0);
//			}
//			return null;
			String queString ="From TJieqi T where T.isdeleted='N' and T.declarationState='01'";
			Query query =this.getSession().createQuery(queString);
			List tmpList = query.list();
			if (tmpList != null && tmpList.size() > 0) {
				return (TJieqi) tmpList.get(0);
			}
			return null;
		} catch (RuntimeException re) {
			log.error("getJieqiNow failed", re);
			throw re;
		}
	}
	// 获取当前结题届期
	public TJieqi getCurrentJieqi(){
		log.debug("getJieqi");
		try {
//			String queryString = "from TJieqi as model where SYSDATE between model.startOn and model.jtEndOn";
//			List list = getHibernateTemplate().find(queryString);
//			if (list != null && list.size() > 0) {
//				return (TJieqi) list.get(0);
//			}
//			return null;
			String queString ="From TJieqi T where T.isdeleted='N' and T.endprojectState='01'";
			Query query =this.getSession().createQuery(queString);
			List tmpList = query.list();
			if (tmpList != null && tmpList.size() > 0) {
				return (TJieqi) tmpList.get(0);
			}
			return null;
		} catch (RuntimeException re) {
			log.error("getJieqiNow failed", re);
			throw re;
		}
	}

	/**
	 * 
	 *TODO 根据年份获取届期
	 *authoy lzh
	 *@param year
	 *@return
	 */
	public List getJieqiByYear(String year){
		log.debug("get Jieqi By year");
		try {
			String queryString ="select t.* from T_Jieqi t where t.JQ_YEAR=:jqYear order by t.START_ON desc";
			SQLQuery sqlQuery = this.getSession().createSQLQuery(queryString);
			sqlQuery.setString("jqYear", year);
			return sqlQuery.addEntity(TJieqi.class).list();
		} catch (RuntimeException e) {
			log.error("get jieqi by year tjieqi failed "+e);
			throw e;
		}
	}
	
	public List findAllYears(){
		log.debug("get all years from jieqi");
		try {
			String queryString ="select distinct t.jqYear from TJieqi t order by t.jqYear desc";
			Query query = this.getSession().createQuery(queryString);
			return query.list();
		} catch (RuntimeException e) {
			log.error("get all years failed "+e);
			throw e;
		}
	}
	
	//获取未分派的专家库的年份
	public List findUnassignYears(){
		log.debug("find unassign years");
		try {
			String queryString ="select distinct t.jqYear from TJieqi t where t.jqId in (select l.TJieqi.jqId from TExpertLib l where l.isdeleted='N' and l.isAssigned='01')";
			Query query = this.getSession().createQuery(queryString);
			return query.list();
		} catch (RuntimeException e) {
			log.error("find unassign years failed "+e);
			throw e;
		}
	}
	
	public List findAllJieqis(String jqName,String jqYear,String jqQici,PageBean pageBean){
		log.debug("find all jieqis");
		try {
			String queryStr = "From TJieqi T where T.isdeleted='N'";
			if(null != jqQici && !jqQici.trim().equals("")){
				queryStr +=" and T.jqId=:id";
			}else{
				if(null != jqName && !jqName.trim().equals("")){
					queryStr +=" and T.jqName like :jqName";
				}
				if(null != jqYear && !jqYear.trim().equals("")){
					queryStr +=" and T.jqYear =:jqYear";
				}
			}
			queryStr +=" order by T.declarationState desc,T.endprojectState desc,T.jqYear desc,T.qici desc";
			Query query = this.getSession().createQuery(queryStr);
			if(null != jqQici && !jqQici.trim().equals("")){
				query.setString("id", jqQici);
			}
			else {
				if(null != jqName && !jqName.trim().equals("")){
					query.setString("jqName", "%"+jqName+"%");
				}
				if(null != jqYear && !jqYear.trim().equals("")){
					query.setString("jqYear", jqYear);
				}
			}
			query.setFirstResult(pageBean.getBeginIndex());
			query.setMaxResults(pageBean.getPageCapibility());
			return query.list();
 		} catch (RuntimeException e) {
 			log.error("find all jieqis failed"+e);
 			throw e;
		}
	}
	
	public int findAllJieqisCount(String jqName,String jqYear,String jqQici){
		log.debug("find all jieqis count");
		try {
			String queryStr = "select count(*) From TJieqi T where T.isdeleted='N'";
			if(null != jqQici && !jqQici.trim().equals("")){
				queryStr +=" and T.jqId=:id";
			}else{
				if(null != jqName && !jqName.trim().equals("")){
					queryStr +=" and T.jqName like :jqName";
				}
				if(null != jqYear && !jqYear.trim().equals("")){
					queryStr +=" and T.jqYear =:jqYear";
				}
			}
			Query query = this.getSession().createQuery(queryStr);
			if(null != jqQici && !jqQici.trim().equals("")){
				query.setString("id", jqQici);
			}
			else {
				if(null != jqName && !jqName.trim().equals("")){
					query.setString("jqName", "%"+jqName+"%");
				}
				if(null != jqYear && !jqYear.trim().equals("")){
					query.setString("jqYear", jqYear);
				}
			}
			List tmpList = query.list();
			int count  = 0;
			if(tmpList.size()>0){
				count = new Integer(""+tmpList.get(0));
			}
			return count;
 		} catch (RuntimeException e) {
 			log.error("find all jieqis count failed"+e);
 			throw e;
		}
	}
}