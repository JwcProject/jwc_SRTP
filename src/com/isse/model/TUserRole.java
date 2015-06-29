package com.isse.model;

/**
 * TUserRole entity. @author MyEclipse Persistence Tools
 */

public class TUserRole implements java.io.Serializable {

	// Fields

	private String userroleId;
	private TUser TUser;
	private TRole TRole;
	private String isdeleted;

	// Constructors

	/** default constructor */
	public TUserRole() {
	}

	/** full constructor */
	public TUserRole(TUser TUser, TRole TRole, String isdeleted) {
		this.TUser = TUser;
		this.TRole = TRole;
		this.isdeleted = isdeleted;
	}

	// Property accessors

	public String getUserroleId() {
		return this.userroleId;
	}

	public void setUserroleId(String userroleId) {
		this.userroleId = userroleId;
	}

	public TUser getTUser() {
		return this.TUser;
	}

	public void setTUser(TUser TUser) {
		this.TUser = TUser;
	}

	public TRole getTRole() {
		return this.TRole;
	}

	public void setTRole(TRole TRole) {
		this.TRole = TRole;
	}

	public String getIsdeleted() {
		return this.isdeleted;
	}

	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}

}