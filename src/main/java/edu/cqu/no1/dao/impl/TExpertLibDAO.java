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

import com.isse.model.TExpertLib;
import com.isse.model.TJieqi;
import com.util.PageBean;

/**
 * A data access object (DAO) providing persistence and search support for
 * TExpertLib entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.isse.model.TExpertLib
 * @author MyEclipse Persistence Tools
 */

public class TExpertLibDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(TExpertLibDAO.class);
	// property constants
	public static final String IS_ASSIGNED = "isAssigned";
	public static final String ISDELETED = "isdeleted";
	public static final String TYPE="type";

	protected void initDao() {
		// do nothing
	}

	public void save(TExpertLib transientInstance) {
		log.debug("saving TExpertLib instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TExpertLib persistentInstance) {
		log.debug("deleting TExpertLib instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TExpertLib findById(String id) {
		log.debug("getting TExpertLib instance with id: " + id);
		try {
			TExpertLib instance = (TExpertLib) getHibernateTemplate().get(
					"com.isse.model.TExpertLib", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TExpertLib instance) {
		log.debug("finding TExpertLib instance by example");
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
		log.debug("finding TExpertLib instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TExpertLib as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByIsAssigned(Object isAssigned) {
		return findByProperty(IS_ASSIGNED, isAssigned);
	}

	public List findByIsdeleted(Object isdeleted) {
		return findByProperty(ISDELETED, isdeleted);
	}
	
	public List findByTYPE(Object type) {
		return findByProperty(TYPE, type);
	}
	
	public List findAll() {
		log.debug("finding all TExpertLib instances");
		try {
			String queryString = "from TExpertLib";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	/**
	 * 
	 *TODO 获取一个学院所有的专家团队
	 *authoy lzh
	 *@param teaCode 学院主管教师教职工号
	 *@param pageBean
	 *@return
	 */
	@SuppressWarnings("unchecked")
	public List<TExpertLib> findExpsByUnitTeaCode(String teaCode,String type,PageBean pageBean) {
		log.debug("get unit expert team");
		try {
			String queryString="from TExpertLib T where T.isdeleted = 'N' and T.type=:type and T.TTeacher.TUnit.unitId in (select Te.TUnit.unitId from TTeacher Te where Te.teaCode=:code)";
			Query query = this.getSession().createQuery(queryString);
			query.setString("code", teaCode);
			query.setString("type", type);
			query.setFetchSize(pageBean.getBeginIndex());
			query.setMaxResults(pageBean.getPageCapibility());
			return query.list();
		} catch (RuntimeException e) {
			log.debug("get unit expert team failed" + e);
			throw e;
		}
	}
	
	public int findExpsCountByUnitTeaCode(String teaCode,String type) {
		log.debug("get unit expert team count");
		try {
			String queryString="Select count(*) From TExpertLib T where T.isdeleted='N' and T.type=:type and T.TTeacher.TUnit.unitId in (select Te.TUnit.unitId from TTeacher Te where Te.teaCode=:code)";
//			System.out.println(queryString);
			Query query = this.getSession().createQuery(queryString);
			query.setString("code", teaCode);
			query.setString("type", type);
			List list = query.list();
			int count = 0;
			if(list.size()>0){
				count = new Integer(""+list.get(0));
			}
			return count;
		} catch (RuntimeException e) {
			log.debug("get unit expert team count failed" + e);
			throw e;
		}
	}
	
	/**
	 * 
	 *TODO 获取当前届期对应的专家库对象
	 *authoy lzh
	 *@param type 专家库的类型（01为申报的，02为结题的）
	 *@return
	 */
	public TExpertLib findNowJieQiExpLib(String type){
		log.debug("get ExpertLib Now");
		try {
			String queryString = "from TExpertLib as model where SYSDATE() between model.TJieqi.startOn and model.TJieqi.endOn and model.isdeleted='N' and model.type=:type";
			Query query = this.getSession().createQuery(queryString);
			query.setString("type", type);
			List list = query.list();
			if (list != null && list.size() > 0) {
				return (TExpertLib) list.get(0);
			}
			return null;
		} catch (RuntimeException re) {
			log.error("get ExpertLib Now failed", re);
			throw re;
		}
	}

	public TExpertLib merge(TExpertLib detachedInstance) {
		log.debug("merging TExpertLib instance");
		try {
			TExpertLib result = (TExpertLib) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TExpertLib instance) {
		log.debug("attaching dirty TExpertLib instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TExpertLib instance) {
		log.debug("attaching clean TExpertLib instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TExpertLibDAO getFromApplicationContext(ApplicationContext ctx) {
		return (TExpertLibDAO) ctx.getBean("TExpertLibDAO");
	}
	/**
	 * 根据届期查询专家库
	 */
	public List findExpertLibByQici(String jieqiId, String unitId, String type){
		log.debug("findExpertLibByQici");
		try {
			String queryString="from TExpertLib T where T.isdeleted = 'N' and T.TJieqi.jqId=:jqId and T.TUnit.unitId = :unitId and T.type= :type";
			Query query = getSession().createQuery(queryString);
			query.setString("jqId", jieqiId);
			query.setString("unitId", unitId);
			query.setString("type", type);
			return query.list();
		} catch (RuntimeException e) {
			log.debug("findExpertLibByQici failed" + e);
			throw e;
		}
	}
}