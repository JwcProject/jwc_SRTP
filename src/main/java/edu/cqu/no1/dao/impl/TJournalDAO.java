package edu.cqu.no1.dao.impl;

import java.util.Date;
import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.isse.model.TJournal;
import com.util.PageBean;

/**
 * A data access object (DAO) providing persistence and search support for
 * TJournal entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.isse.model.TJournal
 * @author MyEclipse Persistence Tools
 */

public class TJournalDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(TJournalDAO.class);
	// property constants
	public static final String USER_NAME = "userName";
	public static final String JOURNAL_REMARK = "journalRemark";
	public static final String ISDELETED = "isdeleted";
	public static final String JOURNAL_LOGINIP = "journalLoginip";

	protected void initDao() {
		// do nothing
	}

	public void save(TJournal transientInstance) {
		log.debug("saving TJournal instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TJournal persistentInstance) {
		log.debug("deleting TJournal instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TJournal findById(String id) {
		log.debug("getting TJournal instance with id: " + id);
		try {
			TJournal instance = (TJournal) getHibernateTemplate().get(
					"com.isse.model.TJournal", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TJournal instance) {
		log.debug("finding TJournal instance by example");
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
		log.debug("finding TJournal instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TJournal as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByUserName(Object userName) {
		return findByProperty(USER_NAME, userName);
	}

	public List findByJournalRemark(Object journalRemark) {
		return findByProperty(JOURNAL_REMARK, journalRemark);
	}

	public List findByIsdeleted(Object isdeleted) {
		return findByProperty(ISDELETED, isdeleted);
	}

	public List findByJournalLoginip(Object journalLoginip) {
		return findByProperty(JOURNAL_LOGINIP, journalLoginip);
	}
	
	/***********************************
	 * author: chenmin
     * date  : 2013.7.17
     * comments: 
    ************************************/
	
	public List findByQueryString(String queryString){
		return getHibernateTemplate().find(queryString);
	}
	
	//多条件查询获取查询列表
	public List findByMultiCondition(String userId,String userName,String journalLoginip,Date journalLogintime,Date journalQuitime,final PageBean pageBean) {
		log.debug("finding all SelectedTJournal instances");
		try {
			
            String queryStr = new String("from TJournal as model where 1=1");

			if(null != userId && !userId.trim().equals(""))
			{
				
				queryStr += " and model.TUser.userId like :customerid";
				
			}
			
			if(null != userName && !userName.equals(""))
			{
				
					queryStr += " and model.userName like :customername";
				
			}
			
			if(null != journalLoginip && !journalLoginip.equals(""))
			{
					queryStr += " and model.journalLoginip like :journalloginip";
				
			}
			
			if(null != journalLogintime && !journalLogintime.equals(""))
			{
				queryStr += " and model.journalLogintime >= :journallogintime and model.journalLogintime <= :journallogintime+1";
				
			}
			
			if(null != journalQuitime && !journalQuitime.equals(""))
			{
					queryStr += " and model.journalQuitime >= :journalquitime and model.journalQuitime <= :journalquitime+1";
				
			}
			
			Query query = this.getSession().createQuery(queryStr);
			
			if(null != userId && !userId.trim().equals(""))
			{
				
				query.setString("customerid", "%"+userId+"%");
				
			}
			
			if(null != userName && !userName.equals(""))
			{
				query.setString("customername", "%"+userName+"%");
				
			}
			
			if(null != journalLoginip && !journalLoginip.equals(""))
			{
				query.setString("journalloginip", "%"+journalLoginip+"%");
			}
			
			if(null != journalLogintime && !journalLogintime.equals(""))
			{
				query.setDate("journallogintime", journalLogintime);
			}
			
			if(null != journalQuitime && !journalQuitime.equals(""))
			{
				query.setDate("journalquitime", journalQuitime);
				
			}
			
			
			query.setFirstResult(pageBean.getBeginIndex());
			query.setMaxResults(pageBean.getPageCapibility());
			
			return query.list();
			
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	//多条件查询获取查询列表长度
	public int findByMultiConditionCount(String userId,String userName,String journalLoginip,Date journalLogintime,Date journalQuitime) {
		log.debug("finding all SelectedTJournal counts");
		try {
			 String queryStr = new String("select count(*) from TJournal as model where 1=1");

				if(null != userId && !userId.trim().equals(""))
				{
					
					queryStr += " and model.TUser.userId like :customerid";
					
				}
				
				if(null != userName && !userName.equals(""))
				{
					
						queryStr += " and model.userName like :customername";
					
				}
				
				if(null != journalLoginip && !journalLoginip.equals(""))
				{
						queryStr += " and model.journalLoginip like :journalloginip";
					
				}
				
				if(null != journalLogintime && !journalLogintime.equals(""))
				{
						queryStr += " and model.journalLogintime >= :journallogintime and model.journalLogintime <= :journallogintime +1";
					
				}
				
				if(null != journalQuitime && !journalQuitime.equals(""))
				{
						queryStr += " and model.journalQuitime >= :journalquitime and model.journalQuitime <= :journalquitime+1";
					
				}
				System.out.println(queryStr);
				Session session = this.getSession();
				Query query = session.createQuery(queryStr);
				
				if(null != userId && !userId.trim().equals(""))
				{
					query.setString("customerid", "%"+userId+"%");
					
				}
				
				if(null != userName && !userName.equals(""))
				{
					query.setString("customername", "%"+userName+"%");
					
				}
				
				if(null != journalLoginip && !journalLoginip.equals(""))
				{
					query.setString("journalloginip", "%"+journalLoginip+"%");
				}
				
				if(null != journalLogintime && !journalLogintime.equals(""))
				{
					query.setDate("journallogintime", journalLogintime);
				}
				
				if(null != journalQuitime && !journalQuitime.equals(""))
				{
					query.setDate("journalquitime", journalQuitime);
					
				}
			
            List tmpList = query.list();
			
			int count = 0;
			
			if(tmpList.size()>0)
			{
				count = new Integer(""+tmpList.get(0));
			}
			
			return count;
			
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public int getAllTJournalCount()
	{
		log.debug("finding all TJournal counts");
		try {
			
			String queryStr = "select count(*) from TJournal as a where a.isdeleted='N'";
			List tmpList = this.getSession().createQuery(queryStr).list();
			
			int count = 0;
			
			if(tmpList.size()>0)
			{
				count = new Integer(""+tmpList.get(0));
			}
			
			return count;
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	

	public List findAll(final PageBean pageBean) {
		log.debug("finding all TJournal instances");
		try {
			
			String queryStr = "from TJournal as a where a.isdeleted = 'N'";
			
			Query query = this.getSession().createQuery(queryStr);
			query.setFirstResult(pageBean.getBeginIndex());
			query.setMaxResults(pageBean.getPageCapibility());
			
			return query.list();
			
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all TJournal instances");
		try {
			String queryString = "from TJournal";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public TJournal merge(TJournal detachedInstance) {
		log.debug("merging TJournal instance");
		try {
			TJournal result = (TJournal) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TJournal instance) {
		log.debug("attaching dirty TJournal instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TJournal instance) {
		log.debug("attaching clean TJournal instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TJournalDAO getFromApplicationContext(ApplicationContext ctx) {
		return (TJournalDAO) ctx.getBean("TJournalDAO");
	}
}