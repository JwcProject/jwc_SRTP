package com.isse.model;

/**
 * TRolePermission entity. @author MyEclipse Persistence Tools
 */

public class TRolePermission implements java.io.Serializable {

	// Fields

	private String rolepermissionId;
	private TRole TRole;
	private TPermission TPermission;
	private String isdeleted;

	// Constructors

	/** default constructor */
	public TRolePermission() {
	}

	/** full constructor */
	public TRolePermission(TRole TRole, TPermission TPermission,
			String isdeleted) {
		this.TRole = TRole;
		this.TPermission = TPermission;
		this.isdeleted = isdeleted;
	}

	// Property accessors

	public String getRolepermissionId() {
		return this.rolepermissionId;
	}

	public void setRolepermissionId(String rolepermissionId) {
		this.rolepermissionId = rolepermissionId;
	}

	public TRole getTRole() {
		return this.TRole;
	}

	public void setTRole(TRole TRole) {
		this.TRole = TRole;
	}

	public TPermission getTPermission() {
		return this.TPermission;
	}

	public void setTPermission(TPermission TPermission) {
		this.TPermission = TPermission;
	}

	public String getIsdeleted() {
		return this.isdeleted;
	}

	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}

}