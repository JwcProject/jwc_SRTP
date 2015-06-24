package edu.cqu.no1.dao;

import edu.cqu.no1.domain.TAnnounType;

import java.util.List;

/**
 * Created by ZKQ on 2015/5/27.
 */
public interface TAnnounTypeDAO extends BaseDao<TAnnounType>{
    TAnnounType findByAnnounName(String announTypeName);

    List findByAnnounTypeName(Object announTypeName);

    List findByIsdeleted(Object isdeleted);
}
