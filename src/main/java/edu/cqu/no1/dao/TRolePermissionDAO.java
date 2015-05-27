package edu.cqu.no1.dao;

import edu.cqu.no1.domain.TRolePermission;

import java.util.List;

/**
 * Created by ZKQ on 2015/5/27.
 */
public interface TRolePermissionDAO extends BaseDao<TRolePermission> {
    List findByIsdeleted(Object isdeleted);

    List findByRoleId(String roleId);
}
