package edu.cqu.no1.dao;

import edu.cqu.no1.domain.TAchievemenType;

import java.util.List;

/**
 * Created by ZKQ on 2015/5/27.
 */


public interface TAchievemenTypeDAO {

    List findByExample(TAchievemenType instance);

    List findByProperty(String propertyName, Object value);

    List findByAchievementypeName(Object achievementypeName);

    List findByAchievementypeIntroduction(
            Object achievementypeIntroduction);

    List findByIsdeleted(Object isdeleted);


    TAchievemenType merge(TAchievemenType detachedInstance);

    void attachDirty(TAchievemenType instance);

    void attachClean(TAchievemenType instance);
}
