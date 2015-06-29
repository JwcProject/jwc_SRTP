package com.isse.service;

import java.util.List;

import com.isse.model.TRole;
import com.isse.model.TRolePermission;
import com.util.PageBean;

public interface RoleService {
	public void addTRole(TRole role);
	public void updateTRole(TRole role);
	public void deleteTRole(String id);
	public TRole getTRole(String id);
	public List<TRole> getAllTRole(final PageBean pageBean);
	public int getAllTRoleCount();
	public void addRolePermission(TRolePermission rolePermission);
	/**
	 * 获取当前role的所有角色权限TRolePermission
	 * @param TRole role
	 * @return TRolePermission列表
	 */
	public List<TRolePermission> getAllRolePermission(TRole role);
	/**
	 * 删除当前role的所有角色权限
	 * @param TRole role
	 */
	public void deleteAllRolePermission(TRole role);
	public List<TRole> getTRoleByKeyword(String keyword, final PageBean pageBean);
	public int getRoleByKeywordCount(String keyword);
	
	//通过用户id查询到该用户的角色名称
	public String findRoleNameByUserId(String userId);
}
