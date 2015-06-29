package com.isse.model;

import java.util.HashSet;
import java.util.Set;

/**
 * TPermission entity. @author MyEclipse Persistence Tools
 */

public class TPermission implements java.io.Serializable {

	// Fields

	private String permissionId;
	private String permissionName;
	private String permissionState;
	private String permissionUrl;
	private String permissionLevel;
	private String permissionFatherid;
	private String permissionIntroduction;
	private String isdeleted;
	private Set TRolePermissions = new HashSet(0);

	// Constructors

	/** default constructor */
	public TPermission() {
	}

	/** full constructor */
	public TPermission(String permissionName, String permissionState,
			String permissionUrl, String permissionLevel,
			String permissionFatherid, String permissionIntroduction,
			String isdeleted, Set TRolePermissions) {
		this.permissionName = permissionName;
		this.permissionState = permissionState;
		this.permissionUrl = permissionUrl;
		this.permissionLevel = permissionLevel;
		this.permissionFatherid = permissionFatherid;
		this.permissionIntroduction = permissionIntroduction;
		this.isdeleted = isdeleted;
		this.TRolePermissions = TRolePermissions;
	}

	// Property accessors

	public String getPermissionId() {
		return this.permissionId;
	}

	public void setPermissionId(String permissionId) {
		this.permissionId = permissionId;
	}

	public String getPermissionName() {
		return this.permissionName;
	}

	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}

	public String getPermissionState() {
		return this.permissionState;
	}

	public void setPermissionState(String permissionState) {
		this.permissionState = permissionState;
	}

	public String getPermissionUrl() {
		return this.permissionUrl;
	}

	public void setPermissionUrl(String permissionUrl) {
		this.permissionUrl = permissionUrl;
	}

	public String getPermissionLevel() {
		return this.permissionLevel;
	}

	public void setPermissionLevel(String permissionLevel) {
		this.permissionLevel = permissionLevel;
	}

	public String getPermissionFatherid() {
		return this.permissionFatherid;
	}

	public void setPermissionFatherid(String permissionFatherid) {
		this.permissionFatherid = permissionFatherid;
	}

	public String getPermissionIntroduction() {
		return this.permissionIntroduction;
	}

	public void setPermissionIntroduction(String permissionIntroduction) {
		this.permissionIntroduction = permissionIntroduction;
	}

	public String getIsdeleted() {
		return this.isdeleted;
	}

	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}

	public Set getTRolePermissions() {
		return this.TRolePermissions;
	}

	public void setTRolePermissions(Set TRolePermissions) {
		this.TRolePermissions = TRolePermissions;
	}

}