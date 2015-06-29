package com.isse.action;

/************************************************************
 * author: PANZHIHUI & YUWENQIAN
 * time  : 2013/7/19
 * comments: role action  
 ***********************************************************/
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.json.annotations.JSON;
import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;

import com.isse.datamodel.TreeNode;
import com.isse.model.TPermission;
import com.isse.model.TRole;
import com.isse.model.TRolePermission;
import com.isse.service.PermissionService;
import com.isse.service.RoleService;
import com.opensymphony.xwork2.ActionSupport;
import com.util.PageBean;

public class RoleAction extends ActionSupport {
	
	private static final long serialVersionUID = -3781147204276341768L;
	
	private RoleService roleService;
	private TRole role;
	private List<TRole> listRoles;
	private String id;
	private String keyword;
	//private TreeNode node;
	private List<TreeNode> nodeList;
	
	private PermissionService permissionService;
	private List<TPermission> listPermissions;
	private List<TRolePermission> listRolePermissions;
	private List<String> listPermissionIds; 
	
	/**
	 * 分页使用的参数
	 */
	private int page = 1; // 初始页面
	private PageBean pageBean; // 分页用的bean
	private int totalPage = 1; // 总页面数
	private int totalNumber = 0; // 总数据条数
	private int pageCapacity = 10; // 每页显示条数

	public String listRole() {
		try{
			this.totalNumber = this.roleService.getAllTRoleCount();
			//System.out.println("------page ---->"+page);
			// 构造分页对象
			pageBean = new PageBean(page,totalNumber,pageCapacity);
			listRoles = this.roleService.getAllTRole(pageBean);
			totalPage = this.pageBean.getTotalPage(); 
			return "success";
		} catch (Exception e){
			System.out.println("list exception: " + e.toString());
			return "listError";
		}
	}
	
	public String addRole() {
		try{
			this.roleService.addTRole(role);
			return "success";
		} catch(Exception e){
			System.out.println("add exception: " + e.toString());
			return "addError";
		}
	}
	
	public String preAddRole() {
		return "success";
	}
	
	public String viewRole() {
		try{
			role = this.roleService.getTRole(id);
			return "success";
		} catch(Exception e){
			return "viewError";
		}
	}
	
	public String updateRole() {
		try{
			this.roleService.updateTRole(role);
			return "success";
		} catch(Exception e){
			System.out.println("update exception: " + e.toString());
			return "updateError";
		}
	}
	
	public String deleteRole() {
		try{
			this.roleService.deleteTRole(id);
			return "success";
		} catch(Exception e){
			System.out.println("delete exception: "+ e.toString());
			return "deleteError";
		}
	}
	
	public String preAssignPermission() {
		/*try{
			this.role = this.roleService.getTRole(id);
			//this.listPermissions = this.permissionService.getAllPermission();
			TreeNode permissionTree = permissionService.getFatherPermissionTree(null);
			this.listRolePermissions = this.roleService.getAllRolePermission(role);
			//所获取的permission中的isdeleted都为N
			//使用permission属性中的isdeleted来判断该permission算法存在于此role中
			for(int i=0; i<this.listPermissions.size(); ++i){
				for(int j=0; j<this.listRolePermissions.size(); ++j){
					if(this.listPermissions.get(i) == this.listRolePermissions.get(j).getTPermission()){
						//“Y”代表该权限已存在角色中
						this.listPermissions.get(i).setIsdeleted("Y");
						break;
					}
				}
			}
			return "success";
		} catch(Exception e){
			System.out.println("get permission exception: "+ e.toString());
			return "getPermissionError";
		}*/
		this.role = this.roleService.getTRole(id);
		return "success";
	}
	
	public String getRolePermission() {
		this.role = this.roleService.getTRole(id);
		this.listRolePermissions = this.roleService.getAllRolePermission(role);
		List<String> permissionId = new ArrayList<String>();
		for(TRolePermission rolePermission : listRolePermissions){
			permissionId.add(rolePermission.getTPermission().getPermissionId());
		}
		TreeNode node = permissionService.getFatherPermissionTree(null);
		setPermissionsChecked(node, permissionId);
		nodeList = new ArrayList<TreeNode>();
		nodeList.add(node);
		return "success";
	}
	
	private void setPermissionsChecked(TreeNode node, List<String> permissionId) {
		//TreeNode result = node;
		if(permissionId.contains(node.getId())){
			node.setChecked(true);
		}else {
			node.setChecked(false);
		}
		for(TreeNode child : node.getChildren()){
			if(permissionId.contains(child.getId())){
				child.setChecked(true);
			}else {
				child.setChecked(false);
			}
			setPermissionsChecked(child, permissionId);
		}
	}
	
	public String assignPermission() {
		try{
			this.role = this.roleService.getTRole(id);
			this.roleService.deleteAllRolePermission(role);
			TPermission permission;
			TRolePermission tRolePermission;
			if(this.listPermissionIds != null){
				for(int i=0; i<this.listPermissionIds.size(); ++i){
					System.out.println(this.listPermissionIds.get(i));
					permission = this.permissionService.getTPermission(this.listPermissionIds.get(i));
					tRolePermission = new TRolePermission();
					tRolePermission.setTRole(role);
					tRolePermission.setTPermission(permission);
					this.roleService.addRolePermission(tRolePermission);
				}
			}
			return "success";
		} catch(Exception e){
			e.printStackTrace();
			System.out.println("assign permission exception: "+ e.toString());
			return "assignPermissionError";
		}
	}
	
	public String queryRole(){
		try{
			this.totalNumber = this.roleService.getRoleByKeywordCount(keyword);
			pageBean = new PageBean(page,totalNumber,pageCapacity);
			this.listRoles = this.roleService.getTRoleByKeyword(keyword, pageBean);
			return "success";
		} catch(Exception e){
			return "queryError";
		}
	}
	
	/*****************************************************************
	 * get & set motheds
	 ****************************************************************/

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public TRole getRole() {
		return role;
	}

	public void setRole(TRole role) {
		this.role = role;
	}

	public List<TRole> getListRoles() {
		return listRoles;
	}

	public void setListRoles(List<TRole> listRoles) {
		this.listRoles = listRoles;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalNumber() {
		return totalNumber;
	}

	public void setTotalNumber(int totalNumber) {
		this.totalNumber = totalNumber;
	}

	public int getPageCapacity() {
		return pageCapacity;
	}

	public void setPageCapacity(int pageCapacity) {
		this.pageCapacity = pageCapacity;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@JSON(serialize=false)
	public List<TPermission> getListPermissions() {
		return listPermissions;
	}

	public void setListPermissions(List<TPermission> listPermissions) {
		this.listPermissions = listPermissions;
	}

	/*public PermissionService getPermissionService() {
		return permissionService;
	}*/

	public void setPermissionService(PermissionService permissionService) {
		this.permissionService = permissionService;
	}
	@JSON(serialize=false)
	public List<String> getListPermissionIds() {
		return listPermissionIds;
	}

	public void setListPermissionIds(List<String> listPermissionIds) {
		this.listPermissionIds = listPermissionIds;
	}
	@JSON(serialize=false)
	public List<TRolePermission> getListRolePermissions() {
		return listRolePermissions;
	}

	public void setListRolePermissions(List<TRolePermission> listRolePermissions) {
		this.listRolePermissions = listRolePermissions;
	}
	@JSON(serialize=false)
	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public List<TreeNode> getNodeList() {
		return nodeList;
	}

	public void setNodeList(List<TreeNode> nodeList) {
		this.nodeList = nodeList;
	}

/*	public TreeNode getNode() {
		return node;
	}

	public void setNode(TreeNode node) {
		this.node = node;
	}*/
	
}
