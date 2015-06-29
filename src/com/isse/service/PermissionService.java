package com.isse.service;

import java.util.List;

import com.isse.datamodel.TreeNode;
import com.isse.model.TPermission;
import com.util.PageBean;

public interface PermissionService {
	
	public void addTPermission(TPermission permission);
	public void updateTPermission(TPermission permission);
	public void deleteTPermission(String id);
	public TPermission getTPermission(String id);
	public List<TPermission> getAllTPermission(final PageBean pageBean);
	public int getAllTPermissionCount();
	public List<TPermission> getAllPermission(); //get all permission except deleted
	public List<TPermission> searchPermission(TPermission permission,PageBean pageBean);
	public int getSearchCount(TPermission permission);
	public TreeNode getFatherPermissionTree(String curFatherPermsId);
}
