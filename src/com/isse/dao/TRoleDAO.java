package com.isse.dao;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.isse.model.TRole;
import com.util.PageBean;

/**
 * A data access object (DAO) providing persistence and search support for TRole
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.isse.model.TRole
 * @author MyEclipse Persistence Tools
 */

public class TRoleDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(TRoleDAO.class);
	// property constants
	public static final String ROLE_NAME = "roleName";
	public static final String ROLE_STATE = "roleState";
	public static final String ROLE_INTRODUCTION = "roleIntroduction";
	public static final String ISDELETED = "isdeleted";

	protected void initDao() {
		// do nothing
	}

	public void save(TRole transientInstance) {
		log.debug("saving TRole instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TRole persistentInstance) {
		log.debug("deleting TRole instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TRole findById(java.lang.String id) {
		log.debug("getting TRole instance with id: " + id);
		try {
			TRole instance = (TRole) getHibernateTemplate().get(
					"com.isse.model.TRole", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TRole instance) {
		log.debug("finding TRole instance by example");
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
		log.debug("finding TRole instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TRole as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByRoleName(Object roleName) {
		return findByProperty(ROLE_NAME, roleName);
	}

	public List findByRoleState(Object roleState) {
		return findByProperty(ROLE_STATE, roleState);
	}

	public List findByRoleIntroduction(Object roleIntroduction) {
		return findByProperty(ROLE_INTRODUCTION, roleIntroduction);
	}

	public List findByIsdeleted(Object isdeleted) {
		return findByProperty(ISDELETED, isdeleted);
	}

	public List findAll() {
		log.debug("finding all TRole instances");
		try {
			String queryString = "from TRole";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TRole merge(TRole detachedInstance) {
		log.debug("merging TRole instance");
		try {
			TRole result = (TRole) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TRole instance) {
		log.debug("attaching dirty TRole instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TRole instance) {
		log.debug("attaching clean TRole instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TRoleDAO getFromApplicationContext(ApplicationContext ctx) {
		return (TRoleDAO) ctx.getBean("TRoleDAO");
	}
	
	//获取Role数量
	@SuppressWarnings("rawtypes")
	public int getAllTRoleCount()
	{
		log.debug("finding all TRole counts");
		try {
		
			String queryStr = "select count(*) from TRole as a where a.isdeleted='N'";
			List tmpList = this.getSession().createQuery(queryStr).list();
			
			int count = 0;
			
			if(tmpList.size()>0)
			{
				count = new Integer(""+tmpList.get(0));
			}
			
			return count;
		} catch (RuntimeException re) {
			log.error("find all TRole counts failed", re);
			throw re;
		}
	}
	
	@SuppressWarnings("rawtypes")
	public List findAll(final PageBean pageBean) {
		log.debug("finding all TRole instances");
		try {
			String queryStr = "from TRole as a where a.isdeleted = 'N'";
			
			Query query = this.getSession().createQuery(queryStr);
			query.setFirstResult(pageBean.getBeginIndex());
			query.setMaxResults(pageBean.getPageCapibility());
			
			return query.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	@SuppressWarnings("rawtypes")
	public List findByKeyword(String keyword, PageBean pageBean) {
		log.debug("find TRole by keyword");
		try {
			String queryString = "from TRole as model where model.isdeleted = 'N'";
			if(keyword!=null && !keyword.trim().equals("")){
				queryString += " and model.roleName like :rName";
				queryString += " or model.roleIntroduction like :rIntroduce";
			}
			
			Query query = this.getSession().createQuery(queryString);
			if(keyword!=null && !keyword.trim().equals("")){
				query.setString("rName", "%"+keyword+"%");
				query.setString("rIntroduce", "%"+keyword+"%");
			}
			query.setFetchSize(pageBean.getBeginIndex());
			query.setMaxResults(pageBean.getPageCapibility());
			return query.list();
		} catch (RuntimeException re) {
			log.error("find TRole by keyword failed", re);
			throw re;
		}
	}
	
	@SuppressWarnings("rawtypes")
	public int getRoleByKeywordCount(String keyword) {
		log.debug("find role count by keyword");
		try {
			String queryString = "select count(*) from TRole as model where model.isdeleted = 'N'";
			if(keyword!=null && !keyword.trim().equals("")){
				queryString += " and model.roleName like :rName";
				queryString += " and model.roleIntroduction like :rIntroduce";
			}
			
			Query query = this.getSession().createQuery(queryString);
			if(keyword!=null && !keyword.trim().equals("")){
				query.setString("rName", "%"+keyword+"%");
				query.setString("rIntroduce", "%"+keyword+"%");
			}
			List tmpList = query.list();
			int count = 0;
			if(tmpList.size()>0){
				count = new Integer(""+tmpList.get(0));
			}
			return count;
		} catch (RuntimeException re) {
			log.error("find role count by keyword failed", re);
			throw re;
		}
	}
	
	//通过用户id查询到该用户的角色名称
	public String findRoleNameByUserId(String userId){
		log.debug("find roleName by userId");
		try {
			String queryString = "Select r.roleName From TRole r Where r.roleId In(Select ur.TRole.roleId From TUserRole ur Where ur.TUser.userId =:userId) And Rownum = 1";
			Query query = this.getSession().createQuery(queryString);
			query.setString("userId", userId);
			String roleName = "";
			List tmpList = query.list();
			if(tmpList.size()>0)
			{
				roleName = (String)tmpList.get(0);
			}
			return roleName;
		} catch (RuntimeException re) {
			// TODO: handle exception
			log.error("find roleName by userId failed", re);
			throw re;
		}
	}
	
}