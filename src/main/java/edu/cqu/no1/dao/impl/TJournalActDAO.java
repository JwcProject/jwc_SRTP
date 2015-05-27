package edu.cqu.no1.dao.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.isse.model.TJournalAct;
import com.util.PageBean;

/**
 * A data access object (DAO) providing persistence and search support for
 * TJournalAct entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.isse.model.TJournalAct
 * @author MyEclipse Persistence Tools
 */

public class TJournalActDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(TJournalActDAO.class);
	// property constants
	public static final String JOURNALACT_TYPE = "journalactType";
	public static final String JOURNALACT_INTRODUCTION = "journalactIntroduction";
	public static final String JOURNALACT_REMARK = "journalactRemark";
	public static final String ISDELETED = "isdeleted";
	public static final String USER_ID = "userId";

	protected void initDao() {
		// do nothing
	}

	public void save(TJournalAct transientInstance) {
		log.debug("saving TJournalAct instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TJournalAct persistentInstance) {
		log.debug("deleting TJournalAct instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TJournalAct findById(String id) {
		log.debug("getting TJournalAct instance with id: " + id);
		try {
			TJournalAct instance = (TJournalAct) getHibernateTemplate().get(
					"com.isse.model.TJournalAct", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TJournalAct instance) {
		log.debug("finding TJournalAct instance by example");
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
		log.debug("finding TJournalAct instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TJournalAct as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	public int getAllTJournalActCount()
	{
		log.debug("finding all TJournalAct counts");
		try {
			
			String queryStr = "select count(*) from TJournalAct as a where a.isdeleted='N'";
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
		log.debug("finding all TJournalAct instances");
		try {
			
			String queryStr = "from TJournalAct as a where a.isdeleted = 'N'";
			
			Query query = this.getSession().createQuery(queryStr);
			query.setFetchSize(pageBean.getBeginIndex());
			query.setMaxResults(pageBean.getPageCapibility());
			
			return query.list();
			
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	//多条件查询获取查询列表
	public List findByMultiCondition(String userId,String journalactType,String journalactIntroduction,Date time,final PageBean pageBean) {
		log.debug("finding all SelectedTJournalAct instances");
		try {
			
            String queryStr = new String("from TJournalAct as model where 1=1");

			if(null != userId && !userId.trim().equals(""))
			{
				
				queryStr += " and model.userId like :customerid";
				
			}
			
			if(null != journalactType && !journalactType.trim().equals(""))
			{
				
					queryStr += " and model.journalactType like :journalacttype";
				
			}
			
			if(null != journalactIntroduction && !journalactIntroduction.trim().equals(""))
			{
					queryStr += " and model.journalactIntroduction like :journalactintroduction";
				
			}
			
			if(null != time && !time.equals(""))
			{
				queryStr += " and model.time >= :time and model.time <= :time+1";
				
			}
			
			Query query = this.getSession().createQuery(queryStr);
			
			if(null != userId && !userId.trim().equals(""))
			{
				
				query.setString("customerid", "%"+userId+"%");
				
			}
			
			if(null != journalactType && !journalactType.trim().equals(""))
			{
				query.setString("journalacttype", "%"+journalactType+"%");
				
			}
			
			if(null != journalactIntroduction && !journalactIntroduction.equals(""))
			{
				query.setString("journalactintroduction", "%"+journalactIntroduction+"%");
			}
			
			if(null != time && !time.equals(""))
			{
				query.setDate("time", time);
			}
			
			
			query.setFetchSize(pageBean.getBeginIndex());
			query.setMaxResults(pageBean.getPageCapibility());
			
			return query.list();
			
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	//多条件查询获取查询列表长度
	public int findByMultiConditionCount(String userId,String journalactType,String journalactIntroduction,Date time) {
		log.debug("finding all SelectedTJournalAct counts");
		try {
			 String queryStr = new String("select count(*) from TJournalAct as model where 1=1");

				if(null != userId && !userId.trim().equals(""))
				{
					
					queryStr += " and model.userId like :customerid";
					
				}
				
				if(null != journalactType && !journalactType.trim().equals(""))
				{
					
						queryStr += " and model.journalactType like :journalacttype";
					
				}
				
				if(null != journalactIntroduction && !journalactIntroduction.trim().equals(""))
				{
						queryStr += " and model.journalactIntroduction like :journalactintroduction";
					
				}
				
				if(null != time && !time.equals(""))
				{
						queryStr += " and model.time >= :time and model.time <= :time +1";
					
				}
				
				
				System.out.println(queryStr);
				Session session = this.getSession();
				Query query = session.createQuery(queryStr);
				
				if(null != userId && !userId.trim().equals(""))
				{
					query.setString("customerid", "%"+userId+"%");
					
				}
				
				if(null != journalactType && !journalactType.equals(""))
				{
					query.setString("journalacttype", "%"+journalactType+"%");
					
				}
				
				if(null != journalactIntroduction && !journalactIntroduction.equals(""))
				{
					query.setString("journalactintroduction", "%"+journalactIntroduction+"%");
				}
				
				if(null != time && !time.equals(""))
				{
					query.setDate("time", time);
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

	public List findByJournalactType(Object journalactType) {
		return findByProperty(JOURNALACT_TYPE, journalactType);
	}

	public List findByJournalactIntroduction(Object journalactIntroduction) {
		return findByProperty(JOURNALACT_INTRODUCTION, journalactIntroduction);
	}

	public List findByJournalactRemark(Object journalactRemark) {
		return findByProperty(JOURNALACT_REMARK, journalactRemark);
	}

	public List findByIsdeleted(Object isdeleted) {
		return findByProperty(ISDELETED, isdeleted);
	}

	public List findByUserId(Object userId) {
		return findByProperty(USER_ID, userId);
	}

	public List findAll() {
		log.debug("finding all TJournalAct instances");
		try {
			String queryString = "from TJournalAct";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TJournalAct merge(TJournalAct detachedInstance) {
		log.debug("merging TJournalAct instance");
		try {
			TJournalAct result = (TJournalAct) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TJournalAct instance) {
		log.debug("attaching dirty TJournalAct instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TJournalAct instance) {
		log.debug("attaching clean TJournalAct instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TJournalActDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (TJournalActDAO) ctx.getBean("TJournalActDAO");
	}
}