package edu.cqu.no1.dao.impl;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.isse.model.TTempEmailReciver;

/**
 * A data access object (DAO) providing persistence and search support for
 * TTempEmailReciver entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.isse.model.TTempEmailReciver
 * @author MyEclipse Persistence Tools
 */

public class TTempEmailReciverDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(TTempEmailReciverDAO.class);
	// property constants
	public static final String DEPART_ID = "departId";
	public static final String JQ_ID = "jqId";
	public static final String CODE = "code";
	public static final String NAME = "name";
	public static final String EMAIL = "email";
	public static final String ISDELETED = "isdeleted";
	public static final String TYPE="type";

	protected void initDao() {
		// do nothing
	}

	public void save(TTempEmailReciver transientInstance) {
		log.debug("saving TTempEmailReciver instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TTempEmailReciver persistentInstance) {
		log.debug("deleting TTempEmailReciver instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TTempEmailReciver findById(String id) {
		log.debug("getting TTempEmailReciver instance with id: " + id);
		try {
			TTempEmailReciver instance = (TTempEmailReciver) getHibernateTemplate()
					.get("com.isse.model.TTempEmailReciver", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TTempEmailReciver instance) {
		log.debug("finding TTempEmailReciver instance by example");
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
		log.debug("finding TTempEmailReciver instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TTempEmailReciver as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findTempEmailReciverByJQid(String jqId) {
		log.debug("find tempEmailReciver by JQ id");
		try {
			String queryStr = "from TTempEmailReciver t where t.isdeleted = 'N' and t.jqId=:jqId)";
			Query query = this.getSession().createQuery(queryStr);
			query.setString("jqId", jqId);

			return query.list();
		} catch (RuntimeException e) {
			log.error("find tempEmailReciver by JQ id failed", e);
			throw e;
		}
	}

	/**
	 * 
	 *TODO 通过届期ID和学院主管教师教职工号获取临时邮件接收人
	 *authoy lzh
	 *@param jqId
	 *@param teaCode
	 *@return
	 */
	@SuppressWarnings("unchecked")
	public List<TTempEmailReciver> findTempEmailRecivers(String jqId,
			String teaCode,String type) {
		log.debug("find tempEmailRecivers by jieqi Id and teaCode ");
		try {
			String queryStr = "from TTempEmailReciver t where t.isdeleted = 'N' and t.type=:type and t.jqId=:jqId and t.departId=(select TT.TUnit.unitId from TTeacher TT where TT.isdeleted='N' and TT.teaCode=:code)";
			Query query = this.getSession().createQuery(queryStr);
			query.setString("jqId", jqId);
			query.setString("type", type);
			query.setString("code", teaCode);
			return query.list();
		} catch (RuntimeException e) {
			log.error("find tempEmailReciver  by jieqi Id and teaCode failed", e);
			throw e;
		}
	}

	// 通过届期ID和主管教师教职工号查找临时邮件接收人的邮箱
	public List findEmailByJQid(String jqId, String teaCode,String type) {
		log.debug("find tempEmailReciver by JQ id and teaCode");
		try {
			String queryStr = "select distinct t.email from TTempEmailReciver t where t.isdeleted = 'N' and t.type=:type and t.jqId=:jqId and t.departId=(select TT.TUnit.unitId from TTeacher TT where TT.isdeleted='N' and TT.teaCode=:code)";
			Query query = this.getSession().createQuery(queryStr);
			query.setString("jqId", jqId);
			query.setString("type", type);
			query.setString("code", teaCode);
			return query.list();
		} catch (RuntimeException e) {
			log.error("find tempEmailReciver by JQ id  and teaCode failed", e);
			throw e;
		}
	}

	// 通过届期和教师工号得到临时邮件收信人
	public TTempEmailReciver findTempEmailReciver(String jqId, String teaCode) {
		log.debug("find tempEmailReciver ");
		try {
			String queryStr = "from TTempEmailReciver t where t.isdeleted = 'N' and t.jqId=:jqId and t.code=:teaCode";
			Query query = this.getSession().createQuery(queryStr);
			query.setString("jqId", jqId);
			query.setString("teaCode", teaCode);
			TTempEmailReciver tTempEmailReciver = null;
			if (null != query.list() && query.list().size() > 0) {
				tTempEmailReciver = (TTempEmailReciver) query.list().get(0);
			}
			return tTempEmailReciver;

		} catch (RuntimeException e) {
			log.error("find tempEmailReciver  failed", e);
			throw e;
		}
	}

	public List findByDepartId(Object departId) {
		return findByProperty(DEPART_ID, departId);
	}

	public List findByJqId(Object jqId) {
		return findByProperty(JQ_ID, jqId);
	}

	public List findByCode(Object code) {
		return findByProperty(CODE, code);
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}

	public List findByIsdeleted(Object isdeleted) {
		return findByProperty(ISDELETED, isdeleted);
	}

	public List findAll() {
		log.debug("finding all TTempEmailReciver instances");
		try {
			String queryString = "from TTempEmailReciver";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TTempEmailReciver merge(TTempEmailReciver detachedInstance) {
		log.debug("merging TTempEmailReciver instance");
		try {
			TTempEmailReciver result = (TTempEmailReciver) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TTempEmailReciver instance) {
		log.debug("attaching dirty TTempEmailReciver instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TTempEmailReciver instance) {
		log.debug("attaching clean TTempEmailReciver instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TTempEmailReciverDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (TTempEmailReciverDAO) ctx.getBean("TTempEmailReciverDAO");
	}
}