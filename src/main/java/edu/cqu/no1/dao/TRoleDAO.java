package edu.cqu.no1.dao;

import edu.cqu.no1.domain.TRole;
import edu.cqu.no1.util.PageBean;

import java.util.List;

/**
 * Created by ZKQ on 2015/5/27.
 */
public interface TRoleDAO extends BaseDao<TRole> {
    List findByRoleName(Object roleName);

    List findByRoleState(Object roleState);

    List findByRoleIntroduction(Object roleIntroduction);

    List findByIsdeleted(Object isdeleted);

    //获取Role数量
    @SuppressWarnings("rawtypes")
    int getAllTRoleCount();

    @SuppressWarnings("rawtypes")
    List findAll(PageBean pageBean);

    @SuppressWarnings("rawtypes")
    List findByKeyword(String keyword, PageBean pageBean);

    @SuppressWarnings("rawtypes")
    int getRoleByKeywordCount(String keyword);

    //通过用户id查询到该用户的角色名称
    String findRoleNameByUserId(String userId);
}
