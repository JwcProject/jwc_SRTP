package edu.cqu.no1.action;

import com.opensymphony.xwork2.ActionSupport;
import edu.cqu.no1.datamodel.TreeNode;
import edu.cqu.no1.domain.TPermission;
import edu.cqu.no1.domain.TRole;
import edu.cqu.no1.domain.TRolePermission;
import edu.cqu.no1.service.PermissionService;
import edu.cqu.no1.service.RoleService;
import edu.cqu.no1.util.PageBean;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller

@Namespace("/")
@Scope("prototype")
@ParentPackage("base")
public class RoleAction extends ActionSupport {
	
	private static final long serialVersionUID = -3781147204276341768L;

    @Resource
	private RoleService roleService;
	private TRole role;
	private List<TRole> listRoles;
	private String id;
	private String keyword;
	//private TreeNode node;
	private List<TreeNode> nodeList;

    @Resource
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


    @Action(value = "ListRole", results = {
            @Result(name = "success", location = "/pages/systemManage/roleManage/role_list.jsp")
    })
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


    @Action(value = "AddRole", results = {
            @Result(name = "input", location = "/pages/systemManage/roleManage/role_add.jsp"),
            @Result(name = "success", type = "redirectAction", location = "ListRole"),

    })
	public String addRole() {
		try{
			this.roleService.addTRole(role);
			return "success";
		} catch(Exception e){
			System.out.println("add exception: " + e.toString());
			return "addError";
		}
	}


    @Action(value = "PreAddRole", results = {
            @Result(name = "success", location = "/pages/systemManage/roleManage/role_add.jsp")
    })
	public String preAddRole() {
		return "success";
	}


    @Action(value = "ViewRole", results = {
            @Result(name = "success", location = "/pages/systemManage/roleManage/role_view.jsp")
    })
	public String viewRole() {
		try{
			role = this.roleService.getTRole(id);
			return "success";
		} catch(Exception e){
			return "viewError";
		}
	}



    @Action(value = "UpdateRole", results = {
            @Result(name = "input", location = "/pages/systemManage/roleManage/role_edit.jsp"),
            @Result(name = "success", type = "redirectAction", location = "ListRole"),

    })
	public String updateRole() {
		try{
			this.roleService.updateTRole(role);
			return "success";
		} catch(Exception e){
			System.out.println("update exception: " + e.toString());
			return "updateError";
		}
	}


    @Action(value = "DeleteRole", results = {
             @Result(name = "success", type = "redirectAction", location = "ListRole")

    })
	public String deleteRole() {
		try{
			this.roleService.deleteTRole(id);
			return "success";
		} catch(Exception e){
			System.out.println("delete exception: "+ e.toString());
			return "deleteError";
		}
	}


    @Action(value = "PreAssignPermission", results = {
            @Result(name = "success", location = "/pages/systemManage/roleManage/permission_add.jsp")

    })
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


    @Action(value = "GetRolePermissons", results = {
            @Result(name = "success",type = "json", params = {"root", "nodeList", "excludeNullProperties", "true"})

    })
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


    @Action(value = "AssignPermission", results = {
            @Result(name = "success", type = "redirectAction", location = "ListRole")

    })
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


    @Action(value = "QueryRole", results = {
            @Result(name = "success", location = "/pages/systemManage/roleManage/role_list.jsp")

    })
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
