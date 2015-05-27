package edu.cqu.no1.dao;

import edu.cqu.no1.domain.TAttchmentType;

import java.util.List;

/**
 * Created by ZKQ on 2015/5/27.
 */
public interface TAttchmentTypeDAO extends BaseDao<TAttchmentType> {
    List findByAttaTypeName(Object attaTypeName);

    List findByIsdeleted(Object isdeleted);
}
