package edu.cqu.no1.dao;

import edu.cqu.no1.domain.TRole;

/**
 * Created by zl on 2015/7/4.
 */
public interface TRoleDao extends BaseDao<TRole> {
    TRole getRoleByName(String name);
}
