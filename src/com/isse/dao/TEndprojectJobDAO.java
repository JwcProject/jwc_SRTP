package com.isse.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.isse.model.TEndprojectJob;

/**
 	* A data access object (DAO) providing persistence and search support for TEndprojectJob entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.isse.model.TEndprojectJob
  * @author MyEclipse Persistence Tools 
 */

public class TEndprojectJobDAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(TEndprojectJobDAO.class);
		//property constants
	public static final String JOB_CONTENT = "jobContent";
	public static final String FINISHED = "finished";
	public static final String ISDELETED = "isdeleted";



	protected void initDao() {
		//do nothing
	}
    
	/**
	 * 
	 *TODO 根据结题获取结题分工
	 *authoy lzh
	 *@param endprojectId
	 *@return
	 */
	public List findEndProJobsByEndProId(String endprojectId){
		log.debug("find endprojectjobs by endproject id");
		try {
			String queryString = "From TEndprojectJob T where T.isdeleted='N' and T.TEndProject.endprojectId=:id";
			Query query = this.getSession().createQuery(queryString);
			query.setString("id", endprojectId);
			return query.list();
		} catch (RuntimeException e) {
			log.error("find endprojectjobs by endprojects failed"+e);
			throw e;
		}
	}
    public void save(TEndprojectJob transientInstance) {
        log.debug("saving TEndprojectJob instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(TEndprojectJob persistentInstance) {
        log.debug("deleting TEndprojectJob instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public TEndprojectJob findById( java.lang.String id) {
        log.debug("getting TEndprojectJob instance with id: " + id);
        try {
            TEndprojectJob instance = (TEndprojectJob) getHibernateTemplate()
                    .get("com.isse.model.TEndprojectJob", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(TEndprojectJob instance) {
        log.debug("finding TEndprojectJob instance by example");
        try {
            List results = getHibernateTemplate().findByExample(instance);
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding TEndprojectJob instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from TEndprojectJob as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByJobContent(Object jobContent
	) {
		return findByProperty(JOB_CONTENT, jobContent
		);
	}
	
	public List findByFinished(Object finished
	) {
		return findByProperty(FINISHED, finished
		);
	}
	
	public List findByIsdeleted(Object isdeleted
	) {
		return findByProperty(ISDELETED, isdeleted
		);
	}
	

	public List findAll() {
		log.debug("finding all TEndprojectJob instances");
		try {
			String queryString = "from TEndprojectJob";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public TEndprojectJob merge(TEndprojectJob detachedInstance) {
        log.debug("merging TEndprojectJob instance");
        try {
            TEndprojectJob result = (TEndprojectJob) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(TEndprojectJob instance) {
        log.debug("attaching dirty TEndprojectJob instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(TEndprojectJob instance) {
        log.debug("attaching clean TEndprojectJob instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static TEndprojectJobDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (TEndprojectJobDAO) ctx.getBean("TEndprojectJobDAO");
	}
}