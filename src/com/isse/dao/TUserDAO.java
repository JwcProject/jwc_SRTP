package com.isse.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.isse.model.TUser;
import com.util.PageBean;

/**
 * A data access object (DAO) providing persistence and search support for TUser
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.isse.model.TUser
 * @author MyEclipse Persistence Tools
 */

public class TUserDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(TUserDAO.class);
	// property constants
	public static final String USER_NAME = "userName";
	public static final String USER_PASSWORD = "userPassword";
	public static final String USER_STATE = "userState";
	public static final String USER_INTRODUCTION = "userIntroduction";
	public static final String ISDELETED = "isdeleted";
	public static final String USER_TYPE = "userType";

	protected void initDao() {
		// do nothing
	}

	public void save(TUser transientInstance) {
		log.debug("saving TUser instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TUser persistentInstance) {
		log.debug("deleting TUser instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TUser findById(java.lang.String id) {
		log.debug("getting TUser instance with id: " + id);
		try {
			TUser instance = (TUser) getHibernateTemplate().get(
					"com.isse.model.TUser", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<TUser> findByExample(TUser instance) {
		log.debug("finding TUser instance by example");
		try {
			List<TUser> results = (List<TUser>) getHibernateTemplate()
					.findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TUser instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TUser as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<TUser> findByUserName(Object userName) {
		return findByProperty(USER_NAME, userName);
	}

	public List<TUser> findByUserPassword(Object userPassword) {
		return findByProperty(USER_PASSWORD, userPassword);
	}

	public List<TUser> findByUserState(Object userState) {
		return findByProperty(USER_STATE, userState);
	}

	public List<TUser> findByUserIntroduction(Object userIntroduction) {
		return findByProperty(USER_INTRODUCTION, userIntroduction);
	}

	public List<TUser> findByIsdeleted(Object isdeleted) {
		return findByProperty(ISDELETED, isdeleted);
	}

	public List<TUser> findByUserType(Object userType) {
		return findByProperty(USER_TYPE, userType);
	}

	public int getAllTUserCount()
	{
		log.debug("finding all TUser counts");
		try {
			
			/*String queryString = "select count(*) from TUser as where s.isdeleted = '0'";
			List tmpList = this.getSession().createQuery(queryString).list();*/
			
			
			/*String queryString = "select count(1) from T_User where isdeleted = '0'";
			List tmpList = this.getSession().createSQLQuery(queryString).list();*/
			
			String queryStr = "select count(*) from TUser as a where a.isdeleted='N'";
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
		log.debug("finding all TUser instances");
		try {
			
			String queryStr = "from TUser as a where a.isdeleted = 'N'";
			
			Query query = this.getSession().createQuery(queryStr);
			query.setFirstResult(pageBean.getBeginIndex());
			query.setMaxResults(pageBean.getPageCapibility());
			
			return query.list();
			
			/*final String str =  "select * from T_User a where a.isdeleted = '0'";
			
			return this.getHibernateTemplate().executeFind(new HibernateCallback()
						{
							public Object doInHibernate(Session session)throws HibernateException, SQLException
							{
								Query query = session.createSQLQuery(str).addEntity(TUser.class);
								
								query.setFirstResult(pageBean.getBeginIndex());
								query.setMaxResults(pageBean.getPageCapibility());
								
								return query.list();
							}
						});*/
			
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public int getTUserCountByMutiProperty(String userId, String userName, String userType, String userState)
	{
		log.debug("finding all getTUserCountByMutiProperty");
		try {
			
			String queryStr = new String("select count(*) from TUser as model where model.isdeleted='N'");

			if(null != userId && !userId.trim().equals(""))
			{
				
				queryStr += " and model.userId like :userId";
				
			}
			
			if(null != userName && !userName.trim().equals(""))
			{
				
					queryStr += " and model.userName like :userName";
				
			}
			
			if(null != userType && !userType.equals("ALL"))
			{
					queryStr += " and model.userType = :userType";
				
			}
			
			if(null != userState && !userState.equals("00"))
			{
					queryStr += " and model.userState = :userState";
				
			}
			
			Session session = this.getSession();
			Query query = session.createQuery(queryStr);
			
			if(null != userId && !userId.trim().equals(""))
			{
				query.setString("userId", "%"+userId+"%");
				
			}
			
			if(null != userName && !userName.trim().equals(""))
			{
				query.setString("userName", "%"+userName+"%");
				
			}
			
			if(null != userType && !userType.equals("ALL"))
			{
				query.setString("userType", userType);
			}
			
			if(null != userState && !userState.equals("00"))
			{
				query.setString("userState", userState);
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
	
	public List getTUserByMutiProperty(String userId, String userName, String userType, String userState,final PageBean pageBean)
	{
		log.debug("finding all getTUserCountByMutiProperty");
		try {
			
			String queryStr = new String("from TUser as model where model.isdeleted = 'N'");

			if(null != userId && !userId.trim().equals(""))
			{
				
				queryStr += " and model.userId like :userId";
				
			}
			
			if(null != userName && !userName.trim().equals(""))
			{
				
					queryStr += " and model.userName like :userName";
				
			}
			
			if(null != userType && !userType.equals("ALL"))
			{
					queryStr += " and model.userType = :userType";
				
			}
			
			if(null != userState && !userState.equals("00"))
			{
					queryStr += " and model.userState = :userState";
				
			}
			
			Session session = this.getSession();
			Query query = session.createQuery(queryStr);
			query.setFirstResult(pageBean.getBeginIndex());
			query.setMaxResults(pageBean.getPageCapibility());
			
			if(null != userId && !userId.trim().equals(""))
			{
				query.setString("userId", "%"+userId+"%");
				
			}
			
			if(null != userName && !userName.trim().equals(""))
			{
				query.setString("userName", "%"+userName+"%");
				
			}
			
			if(null != userType && !userType.equals("ALL"))
			{
				query.setString("userType", userType);
			}
			
			if(null != userState && !userState.equals("00"))
			{
				query.setString("userState", userState);
			}
						
			return query.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public List findAll()
	{
		log.debug("finding all TUser instances");
		try {
			
			String queryString = "from TUser";
			return getHibernateTemplate().find(queryString);
			
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TUser merge(TUser detachedInstance) {
		log.debug("merging TUser instance");
		try {
			TUser result = (TUser) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TUser instance) {
		log.debug("attaching dirty TUser instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TUser instance) {
		log.debug("attaching clean TUser instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TUserDAO getFromApplicationContext(ApplicationContext ctx) {
		return (TUserDAO) ctx.getBean("TUserDAO");
	}
	public List findByUserIdAndPwd(String userId, String password){
		log.debug("findByUserIdAndPwd");
		try {			
			String queryStr = "from TUser as a where a.isdeleted = 'N' and a.userId=:userId and a.userPassword =:password";
			Query query = this.getSession().createQuery(queryStr);
			query.setString("userId", userId);
			query.setString("password", password);
			return query.list();
		} catch (RuntimeException re) {
			log.error("findByUserIdAndPwd failed", re);
			throw re;
		}
	}
}