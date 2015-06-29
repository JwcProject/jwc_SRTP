package com.isse.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.json.annotations.JSON;

import com.isse.datamodel.TreeNode;
import com.isse.model.TPermission;
import com.isse.service.PermissionService;
import com.opensymphony.xwork2.ActionSupport;
import com.util.PageBean;

public class PermissionAction extends ActionSupport{


	private static final long serialVersionUID = 1669389863810074513L;
	private PermissionService permissionService;
	private TPermission permission;
	private List<TPermission> listPermissions;
	private String id;
	private String curFatherPermsId;
	private List<TreeNode> fathPermsTree = new ArrayList<TreeNode>();
	/**
	 * 分页使用的参数
	 */
	private int page = 1; // 初始页面
	private PageBean pageBean; // 分页用的bean
	private int totalPage = 1; // 总页面数
	private int totalNumber = 0; // 总数据条数
	private int pageCapacity = 10; // 每页显示条数
	
	
	public String listPermission() throws Exception
	{
		try
		{
			this.totalNumber = this.permissionService.getAllTPermissionCount();
			
			// 构造分页对象
			pageBean = new PageBean(page,totalNumber,pageCapacity);
			
			listPermissions = this.permissionService.getAllTPermission(pageBean);
			
			totalPage = this.pageBean.getTotalPage(); 
			
			return "success";
		}
		catch (Exception e)
		{
			System.out.println("list exception: " + e.toString());
			
			return "listError";
		}
	}
	
	public String addPermission() throws Exception
	{
		try
		{
			this.permissionService.addTPermission(permission);
			
			return "success";
		}
		catch(Exception e)
		{
			System.out.println("add exception: " + e.toString());
			
			return "addError";
		}
	}
	
	
	public String preAddPermission() throws Exception
	{
		return "success";
	}
	
	public String viewPermission() throws Exception
	{
		try
		{
			permission = this.permissionService.getTPermission(id);
			
			return "success";
		}
		catch(Exception e)
		{
			return "viewError";
		}
	}
	
	public String updatePermission() throws Exception
	{
		try
		{
			this.permissionService.updateTPermission(permission);
			
			return "success";
		}
		catch(Exception e)
		{
			System.out.println("add exception: " + e.toString());
			
			return "updateError";
		}
	}
	
	
	public String deletePermission()throws Exception
	{
		try {
			this.permissionService.deleteTPermission(id);
			return "success";
		} catch (Exception e) {
			System.out.println("delete exception: " + e.toString());
			return "deleteError";
		}
	}
	public String searchPermission()throws Exception{
		try
		{
			this.totalNumber = this.permissionService.getSearchCount(permission);
			
			// 构造分页对象
			pageBean = new PageBean(page,totalNumber,pageCapacity);
			
			listPermissions = this.permissionService.searchPermission(permission, pageBean);
			
			totalPage = this.pageBean.getTotalPage(); 
			
			return "success";
		}
		catch (Exception e)
		{
			System.out.println("search exception: " + e.toString());
			
			return "listError";
		}
	}
	public String findFatherPermsTree(){
		this.fathPermsTree.add(this.permissionService.getFatherPermissionTree(curFatherPermsId));
		return SUCCESS;
	}
	
	/*****************************************************
	 *  get & set methods
	 * *************************************************/
	public List<TreeNode> getFathPermsTree() {
		return fathPermsTree;
	}

	public void setFathPermsTree(List<TreeNode> fathPermsTree) {
		this.fathPermsTree = fathPermsTree;
	}
    @JSON(serialize=false)
	public String getCurFatherPermsId() {
		return curFatherPermsId;
	}
	
	public void setCurFatherPermsId(String curFatherPermsId) {
		this.curFatherPermsId = curFatherPermsId;
	}
	@JSON(serialize=false)
	public PermissionService getPermissionService() {
		return permissionService;
	}

	public void setPermissionService(PermissionService permissionService) {
		this.permissionService = permissionService;
	}
	@JSON(serialize=false)
	public TPermission getPermission() {
		return permission;
	}

	public void setPermission(TPermission permission) {
		this.permission = permission;
	}
	@JSON(serialize=false)
	public List<TPermission> getListPermissions() {
		return listPermissions;
	}

	public void setListPermissions(List<TPermission> listPermissions) {
		this.listPermissions = listPermissions;
	}
	@JSON(serialize=false)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	@JSON(serialize=false)
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
	@JSON(serialize=false)
	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}
	@JSON(serialize=false)
	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	@JSON(serialize=false)
	public int getTotalNumber() {
		return totalNumber;
	}

	public void setTotalNumber(int totalNumber) {
		this.totalNumber = totalNumber;
	}
	@JSON(serialize=false)
	public int getPageCapacity() {
		return pageCapacity;
	}
	
	public void setPageCapacity(int pageCapacity) {
		this.pageCapacity = pageCapacity;
	}
	
}
