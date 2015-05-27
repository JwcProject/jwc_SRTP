package edu.cqu.no1.dao;

import edu.cqu.no1.domain.TUserRole;

import java.util.List;

/**
 * Created by ZKQ on 2015/5/27.
 */
public interface TUserRoleDAO extends BaseDao<TUserRole> {
    List findByIsdeleted(Object isdeleted);
}
