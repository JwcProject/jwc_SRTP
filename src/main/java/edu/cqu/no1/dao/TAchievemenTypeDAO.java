package edu.cqu.no1.dao;

import edu.cqu.no1.domain.TAchievemenType;

import java.util.List;

/**
 * Created by ZKQ on 2015/5/27.
 */


public interface TAchievemenTypeDAO extends BaseDao<TAchievemenType> {

    List findByAchievementypeName(Object achievementypeName);

    List findByAchievementypeIntroduction(
            Object achievementypeIntroduction);

    List findByIsdeleted(Object isdeleted);

}
