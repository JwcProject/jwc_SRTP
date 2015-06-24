package edu.cqu.no1.dao.impl;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;
import edu.cqu.no1.dao.TAchievemenTypeDAO;
import edu.cqu.no1.domain.TAchievemenType;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ZKQ on 2015/5/27.
 */

@Repository
public class TAchievemenTypeDAOImpl extends BaseDaoImpl<TAchievemenType> implements TAchievemenTypeDAO {
    private static final Logger log = LoggerFactory
            .getLogger(TAchievemenTypeDAOImpl.class);
    // property constants
    public static final String ACHIEVEMENTYPE_NAME = "achievementypeName";
    public static final String ACHIEVEMENTYPE_INTRODUCTION = "achievementypeIntroduction";
    public static final String ISDELETED = "isdeleted";


    public List findByAchievementypeName(Object achievementypeName) {
        return findByProperty(ACHIEVEMENTYPE_NAME, achievementypeName);
    }


    public List findByAchievementypeIntroduction(
            Object achievementypeIntroduction) {
        return findByProperty(ACHIEVEMENTYPE_INTRODUCTION,
                achievementypeIntroduction);
    }


    public List findByIsdeleted(Object isdeleted) {
        return findByProperty(ISDELETED, isdeleted);
    }


    public static TAchievemenTypeDAOImpl getFromApplicationContext(
            ApplicationContext ctx) {
        return (TAchievemenTypeDAOImpl) ctx.getBean("TAchievemenTypeDAO");
    }
}
