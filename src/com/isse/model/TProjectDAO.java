package com.isse.model;

import java.util.Date;
import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.isse.model.TProject;

/**
 * A data access object (DAO) providing persistence and search support for
 * TProject entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.isse.model.TProject
 * @author MyEclipse Persistence Tools
 */

public class TProjectDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(TProjectDAO.class);
	// property constants
	public static final String PROJECT_LINE = "projectLine";
	public static final String PROJECT_STATE = "projectState";
	public static final String PROJECT_NUMBER = "projectNumber";
	public static final String PROJECT_SENSE = "projectSense";
	public static final String PROJECT_CONTENT = "projectContent";
	public static final String PROJECT_LABTYPE = "projectLabtype";
	public static final String PROJECT_LABNAME = "projectLabname";
	public static final String PROJECT_NAME = "projectName";
	public static final String PROJECT_INTRODUCTION = "projectIntroduction";
	public static final String PROJECT_FUND = "projectFund";
	public static final String PROJECT_INNOVATE = "projectInnovate";
	public static final String PROJECT_CONDITION = "projectCondition";
	public static final String PROJECT_PROGRESS = "projectProgress";
	public static final String PROJECT_GOAL = "projectGoal";
	public static final String PROJECT_ACHIEVEMENT = "projectAchievement";
	public static final String PROJECT_WORK = "projectWork";
	public static final String REDMINE_PROJECTID = "redmineProjectid";
	public static final String PROJECT_SCORE = "projectScore";
	public static final String ISDELETED = "isdeleted";

	protected void initDao() {
		// do nothing
	}

	public void save(TProject transientInstance) {
		log.debug("saving TProject instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TProject persistentInstance) {
		log.debug("deleting TProject instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TProject findById(java.lang.String id) {
		log.debug("getting TProject instance with id: " + id);
		try {
			TProject instance = (TProject) getHibernateTemplate().get(
					"com.isse.model.TProject", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TProject instance) {
		log.debug("finding TProject instance by example");
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
		log.debug("finding TProject instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TProject as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByProjectLine(Object projectLine) {
		return findByProperty(PROJECT_LINE, projectLine);
	}

	public List findByProjectState(Object projectState) {
		return findByProperty(PROJECT_STATE, projectState);
	}

	public List findByProjectNumber(Object projectNumber) {
		return findByProperty(PROJECT_NUMBER, projectNumber);
	}

	public List findByProjectSense(Object projectSense) {
		return findByProperty(PROJECT_SENSE, projectSense);
	}

	public List findByProjectContent(Object projectContent) {
		return findByProperty(PROJECT_CONTENT, projectContent);
	}

	public List findByProjectLabtype(Object projectLabtype) {
		return findByProperty(PROJECT_LABTYPE, projectLabtype);
	}

	public List findByProjectLabname(Object projectLabname) {
		return findByProperty(PROJECT_LABNAME, projectLabname);
	}

	public List findByProjectName(Object projectName) {
		return findByProperty(PROJECT_NAME, projectName);
	}

	public List findByProjectIntroduction(Object projectIntroduction) {
		return findByProperty(PROJECT_INTRODUCTION, projectIntroduction);
	}

	public List findByProjectFund(Object projectFund) {
		return findByProperty(PROJECT_FUND, projectFund);
	}

	public List findByProjectInnovate(Object projectInnovate) {
		return findByProperty(PROJECT_INNOVATE, projectInnovate);
	}

	public List findByProjectCondition(Object projectCondition) {
		return findByProperty(PROJECT_CONDITION, projectCondition);
	}

	public List findByProjectProgress(Object projectProgress) {
		return findByProperty(PROJECT_PROGRESS, projectProgress);
	}

	public List findByProjectGoal(Object projectGoal) {
		return findByProperty(PROJECT_GOAL, projectGoal);
	}

	public List findByProjectAchievement(Object projectAchievement) {
		return findByProperty(PROJECT_ACHIEVEMENT, projectAchievement);
	}

	public List findByProjectWork(Object projectWork) {
		return findByProperty(PROJECT_WORK, projectWork);
	}

	public List findByRedmineProjectid(Object redmineProjectid) {
		return findByProperty(REDMINE_PROJECTID, redmineProjectid);
	}

	public List findByProjectScore(Object projectScore) {
		return findByProperty(PROJECT_SCORE, projectScore);
	}

	public List findByIsdeleted(Object isdeleted) {
		return findByProperty(ISDELETED, isdeleted);
	}

	public List findAll() {
		log.debug("finding all TProject instances");
		try {
			String queryString = "from TProject";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TProject merge(TProject detachedInstance) {
		log.debug("merging TProject instance");
		try {
			TProject result = (TProject) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TProject instance) {
		log.debug("attaching dirty TProject instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TProject instance) {
		log.debug("attaching clean TProject instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TProjectDAO getFromApplicationContext(ApplicationContext ctx) {
		return (TProjectDAO) ctx.getBean("TProjectDAO");
	}
}