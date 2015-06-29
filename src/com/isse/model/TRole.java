package com.isse.model;

import java.util.HashSet;
import java.util.Set;

/**
 * TRole entity. @author MyEclipse Persistence Tools
 */

public class TRole implements java.io.Serializable {

	// Fields

	private String roleId;
	private String roleName;
	private String roleState;
	private String roleIntroduction;
	private String isdeleted;
	private Set TUserRoles = new HashSet(0);
	private Set TRolePermissions = new HashSet(0);

	// Constructors

	/** default constructor */
	public TRole() {
	}

	/** full constructor */
	public TRole(String roleName, String roleState, String roleIntroduction,
			String isdeleted, Set TUserRoles, Set TRolePermissions) {
		this.roleName = roleName;
		this.roleState = roleState;
		this.roleIntroduction = roleIntroduction;
		this.isdeleted = isdeleted;
		this.TUserRoles = TUserRoles;
		this.TRolePermissions = TRolePermissions;
	}

	// Property accessors

	public String getRoleId() {
		return this.roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleState() {
		return this.roleState;
	}

	public void setRoleState(String roleState) {
		this.roleState = roleState;
	}

	public String getRoleIntroduction() {
		return this.roleIntroduction;
	}

	public void setRoleIntroduction(String roleIntroduction) {
		this.roleIntroduction = roleIntroduction;
	}

	public String getIsdeleted() {
		return this.isdeleted;
	}

	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}

	public Set getTUserRoles() {
		return this.TUserRoles;
	}

	public void setTUserRoles(Set TUserRoles) {
		this.TUserRoles = TUserRoles;
	}

	public Set getTRolePermissions() {
		return this.TRolePermissions;
	}

	public void setTRolePermissions(Set TRolePermissions) {
		this.TRolePermissions = TRolePermissions;
	}

}