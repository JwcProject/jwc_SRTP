package edu.cqu.no1.dao.impl;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;
import edu.cqu.no1.dao.TAchievemenTypeDAO;
import edu.cqu.no1.domain.TAchievemenType;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;

import java.util.List;

/**
 * Created by ZKQ on 2015/5/27.
 */
public class TAchievemenTypeDAOImpl extends BaseDaoImpl<TAchievemenType> implements TAchievemenTypeDAO {
    private static final Logger log = LoggerFactory
            .getLogger(TAchievemenTypeDAOImpl.class);
    // property constants
    public static final String ACHIEVEMENTYPE_NAME = "achievementypeName";
    public static final String ACHIEVEMENTYPE_INTRODUCTION = "achievementypeIntroduction";
    public static final String ISDELETED = "isdeleted";

    protected void initDao() {
        // do nothing
    }

    @Override
    public List findByExample(TAchievemenType instance) {
 /*       log.debug("finding TAchievemenType instance by example");
        try {
            List results = getHibernateTemplate().findByExample(instance);
            log.debug("find by example successful, result size: "
                    + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }*/

        return null;
    }

    @Override
    public List findByProperty(String propertyName, Object value) {
/*        log.debug("finding TAchievemenType instance with property: "
                + propertyName + ", value: " + value);
        try {
            String queryString = "from TAchievemenType as model where model."
                    + propertyName + "= ?";
            return getHibernateTemplate().find(queryString, value);
        } catch (RuntimeException re) {
            log.error("find by property name failed", re);
            throw re;
        }*/

        return null;
    }

    @Override
    public List findByAchievementypeName(Object achievementypeName) {
        return findByProperty(ACHIEVEMENTYPE_NAME, achievementypeName);
    }

    @Override
    public List findByAchievementypeIntroduction(
            Object achievementypeIntroduction) {
        return findByProperty(ACHIEVEMENTYPE_INTRODUCTION,
                achievementypeIntroduction);
    }

    @Override
    public List findByIsdeleted(Object isdeleted) {
        return findByProperty(ISDELETED, isdeleted);
    }


    @Override
    public TAchievemenType merge(TAchievemenType detachedInstance) {
 /*       log.debug("merging TAchievemenType instance");
        try {
            TAchievemenType result = (TAchievemenType) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }*/

        return null;
    }

    @Override
    public void attachDirty(TAchievemenType instance) {
 /*       log.debug("attaching dirty TAchievemenType instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }*/
    }

    @Override
    public void attachClean(TAchievemenType instance) {
/*        log.debug("attaching clean TAchievemenType instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }*/
    }

    public static TAchievemenTypeDAOImpl getFromApplicationContext(
            ApplicationContext ctx) {
        return (TAchievemenTypeDAOImpl) ctx.getBean("TAchievemenTypeDAO");
    }
}
