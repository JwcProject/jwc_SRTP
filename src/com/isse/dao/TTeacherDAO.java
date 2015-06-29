package com.isse.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.isse.model.TAnnouncementModel;
import com.isse.model.TTeacher;
import com.util.PageBean;

/**
 * A data access object (DAO) providing persistence and search support for
 * TTeacher entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.isse.model.TTeacher
 * @author MyEclipse Persistence Tools
 */

public class TTeacherDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(TTeacherDAO.class);
	// property constants
	public static final String TEA_NAME = "teaName";
	public static final String TEA_CODE = "teaCode";
	public static final String TEA_SEX = "teaSex";
	public static final String TEA_TITLE = "teaTitle";
	public static final String TEA_TELE = "teaTele";
	public static final String TEA_EMAIL = "teaEmail";
	public static final String TEA_STATE = "teaState";
	public static final String TEA_INTRO = "teaIntro";
	public static final String TEA_REMARK = "teaRemark";
	public static final String ISDELETED = "isdeleted";

	protected void initDao() {
		// do nothing
	}

	public void save(TTeacher transientInstance) {
		log.debug("saving TTeacher instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TTeacher persistentInstance) {
		log.debug("deleting TTeacher instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TTeacher findById(java.lang.String id) {
		log.debug("getting TTeacher instance with id: " + id);
		try {
			TTeacher instance = (TTeacher) getHibernateTemplate().get(
					"com.isse.model.TTeacher", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TTeacher instance) {
		log.debug("finding TTeacher instance by example");
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
		log.debug("finding TTeacher instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TTeacher as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	//通过学院主管教师的id找到本学院所有的教师
	public List getTeachers(String code) {
		log.debug("get all Teacher ");
		try {
			String queryStr = "from TTeacher t where t.isdeleted = 'N' and t.TUnit.unitId=(select a.TUnit.unitId from TTeacher a where a.teaCode=:code)";
			Query query = this.getSession().createQuery(queryStr);
			query.setString("code", code);
			return query.list();
		} catch (RuntimeException e) {
			log.error("get all teacher failed", e);
			throw e;
		}
	}
	
	/*
	 * 得到不是专家教师的教师
	 * type 为类别，01 为申报的专家教师，02为结题的专家教师
	 */
	public List getCommonTeachers(String code,String type) {
		log.debug("get all common Teacher ");
		try {
			String queryStr = "from TTeacher t where t.isdeleted = 'N' and t.TUnit.unitId=(select a.TUnit.unitId from TTeacher a where a.teaCode=:code) and not exists(from TExpertTeacher ET where ET.isdeleted='N' and ET.TTeacher.teaId=t.teaId and ET.TExpertLib.type=:type)";
			//select t.* from t_teacher t where t.isdeleted = 'N' and t.unit_id=(select a.unit_id from t_teacher a where a.tea_code='rj1000') and not exists(select ET.EX_TEA_ID from t_expert_teacher ET where ET.Isdeleted='N' and ET.Tea_Id=t.tea_id)
			Query query = this.getSession().createQuery(queryStr);
			query.setString("code", code);
			query.setString("type", type);
			return query.list();
		} catch (RuntimeException e) {
			log.error("get all common teacher failed", e);
			throw e;
		}
	}
	
	//多条件查询当前主管教师所在学院的所有教师
	public List findTeachers(String teaCode, String teaName, String teaTitle) {
		log.debug("find all Teacher ");
		try {
			String queryStr = "from TTeacher t where t.isdeleted = 'N' and t.TUnit.unitId=(select a.TUnit.unitId from TTeacher a where a.teaCode=:code)";
			
			if(null != teaName && !teaName.trim().equals(""))
			{
				
				queryStr += " and t.teaName like :teaName";
				
			}
			
			if(null != teaTitle && !teaTitle.trim().equals("00"))
			{
				
				queryStr += " and t.teaTitle =:teaTitle";
				
			}
			Query query = this.getSession().createQuery(queryStr);
			
			query.setString("code", teaCode);
			
			if(null != teaName && !teaName.equals(""))
			{
				query.setString("teaName", "%"+teaName+"%");
			}
			if(null != teaTitle && !teaTitle.equals("00"))
			{
				query.setString("teaTitle", teaTitle);	
			}
			return query.list();
		} catch (RuntimeException e) {
			log.error("find all teacher failed", e);
			throw e;
		}
	}
	
	public List findTeacherByCode(String code) {
		log.debug("find teacher by teacher code");
		try {
			String queryStr = "from TTeacher t where t.isdeleted = 'N' and t.teaCode=:code";
			Query query = this.getSession().createQuery(queryStr);
			query.setString("code", code);
			return query.list();
		} catch (RuntimeException e) {
			log.error("get teacher failed", e);
			throw e;
		}
	}

	public List findByTeaName(Object teaName) {
		return findByProperty(TEA_NAME, teaName);
	}

	public List findByTeaCode(Object teaCode) {
		return findByProperty(TEA_CODE, teaCode);
	}

	public List findByTeaSex(Object teaSex) {
		return findByProperty(TEA_SEX, teaSex);
	}

	public List findByTeaTitle(Object teaTitle) {
		return findByProperty(TEA_TITLE, teaTitle);
	}

	public List findByTeaTele(Object teaTele) {
		return findByProperty(TEA_TELE, teaTele);
	}

	public List findByTeaEmail(Object teaEmail) {
		return findByProperty(TEA_EMAIL, teaEmail);
	}

	public List findByTeaState(Object teaState) {
		return findByProperty(TEA_STATE, teaState);
	}

	public List findByTeaIntro(Object teaIntro) {
		return findByProperty(TEA_INTRO, teaIntro);
	}

	public List findByTeaRemark(Object teaRemark) {
		return findByProperty(TEA_REMARK, teaRemark);
	}

	public List findByIsdeleted(Object isdeleted) {
		return findByProperty(ISDELETED, isdeleted);
	}

	public List findAll() {
		log.debug("finding all TTeacher instances");
		try {
			String queryString = "from TTeacher";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TTeacher merge(TTeacher detachedInstance) {
		log.debug("merging TTeacher instance");
		try {
			TTeacher result = (TTeacher) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TTeacher instance) {
		log.debug("attaching dirty TTeacher instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TTeacher instance) {
		log.debug("attaching clean TTeacher instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TTeacherDAO getFromApplicationContext(ApplicationContext ctx) {
		return (TTeacherDAO) ctx.getBean("TTeacherDAO");
	}
	/**
	 * lsp
	 */
	public List findTeachersByName(String name){
		log.debug("findTeachersByName");
		try {
			String queryStr = "from TTeacher t where t.isdeleted = 'N' and t.teaName like :name";
			Query query = this.getSession().createQuery(queryStr);
			query.setString("name",  "%" + name + "%");
			return query.list();
		} catch (RuntimeException re) {
			log.error("findTeachersByName failed", re);
			throw re;
		}
	}
	
	
}