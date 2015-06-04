package edu.cqu.no1.service.impl;

import edu.cqu.no1.dao.TRoleDAO;
import edu.cqu.no1.dao.TRolePermissionDAO;
import edu.cqu.no1.domain.TRole;
import edu.cqu.no1.domain.TRolePermission;
import edu.cqu.no1.service.RoleService;
import edu.cqu.no1.util.PageBean;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ZKQ on 2015/6/4.
 */

@Service
public class RoleServiceImpl implements RoleService {

    private TRoleDAO tRoleDao;
    private TRolePermissionDAO tRolePermissionDao;

    public TRoleDAO gettRoleDao() {
        return tRoleDao;
    }

    public void settRoleDao(TRoleDAO tRoleDao) {
        this.tRoleDao = tRoleDao;
    }

    public TRolePermissionDAO gettRolePermissionDao() {
        return tRolePermissionDao;
    }

    public void settRolePermissionDao(TRolePermissionDAO tRolePermissionDao) {
        this.tRolePermissionDao = tRolePermissionDao;
    }

    @Override
    public void addTRole(TRole role) {
        // TODO Auto-generated method stub
        this.tRoleDao.save(role);
    }

    @Override
    public void updateTRole(TRole role) {
        // TODO Auto-generated method stub
        this.tRoleDao.merge(role);
    }

    @Override
    public void deleteTRole(String id) {
        // TODO Auto-generated method stub
        TRole tRole = this.getTRole(id);
        tRole.setIsdeleted("Y");
        this.updateTRole(tRole);
    }

    @Override
    public TRole getTRole(String id) {
        // TODO Auto-generated method stub
        return this.tRoleDao.findById(id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<TRole> getAllTRole(PageBean pageBean) {
        // TODO Auto-generated method stub
        return this.tRoleDao.findAll(pageBean);
    }

    @Override
    public int getAllTRoleCount() {
        // TODO Auto-generated method stub
        return this.tRoleDao.getAllTRoleCount();
    }

    @Override
    public void addRolePermission(TRolePermission rolePermission) {
        // TODO Auto-generated method stub
        this.tRolePermissionDao.save(rolePermission);
    }

    @Override
    public void deleteAllRolePermission(TRole role) {
        // TODO Auto-generated method stub
        List<TRolePermission> listRolePermissions = this.getAllRolePermission(role);
        for (int i = 0; i < listRolePermissions.size(); ++i) {
            this.tRolePermissionDao.delete(listRolePermissions.get(i));
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<TRolePermission> getAllRolePermission(TRole role) {
        // TODO Auto-generated method stub
        return this.tRolePermissionDao.findByProperty("TRole.roleId", role.getRoleId());
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<TRole> getTRoleByKeyword(String keyword, final PageBean pageBean) {
        // TODO Auto-generated method stub
        return this.tRoleDao.findByKeyword(keyword, pageBean);
    }

    @Override
    public int getRoleByKeywordCount(String keyword) {
        // TODO Auto-generated method stub
        return this.tRoleDao.getRoleByKeywordCount(keyword);
    }

    //通过用户id查询到该用户的角色名称
    public String findRoleNameByUserId(String userId) {
        return this.tRoleDao.findRoleNameByUserId(userId);
    }
}
