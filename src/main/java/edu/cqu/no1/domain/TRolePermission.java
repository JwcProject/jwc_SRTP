package edu.cqu.no1.domain;// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TRolePermission entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_role_permission", catalog = "srtp")
public class TRolePermission implements java.io.Serializable {

	// Fields

	private String rolePermissionId;
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
	@GenericGenerator(name = "generator", strategy = "guid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "rolePermission_id", unique = true, nullable = false, length = 36)
	public String getRolePermissionId() {
		return this.rolePermissionId;
	}

	public void setRolePermissionId(String rolePermissionId) {
		this.rolePermissionId = rolePermissionId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role_id")
	public TRole getTRole() {
		return this.TRole;
	}

	public void setTRole(TRole TRole) {
		this.TRole = TRole;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "permission_id")
	public TPermission getTPermission() {
		return this.TPermission;
	}

	public void setTPermission(TPermission TPermission) {
		this.TPermission = TPermission;
	}

	@Column(name = "isdeleted", length = 1)
	public String getIsdeleted() {
		return this.isdeleted;
	}

	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}

}