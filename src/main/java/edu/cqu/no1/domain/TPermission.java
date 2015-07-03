package edu.cqu.no1.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TPermission entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_permission", catalog = "srtp")
public class TPermission implements java.io.Serializable {

	// Fields

	private String permissionId;
	private String isdeleted;
	private String permissionFatherid;
	private String permissionIntroduction;
	private String permissionLevel;
	private String permissionName;
	private String permissionState;
	private String permissionUrl;
	private Set<TRolePermission> TRolePermissions = new HashSet<TRolePermission>(
			0);

	// Constructors

	/** default constructor */
	public TPermission() {
	}

	/** full constructor */
	public TPermission(String isdeleted, String permissionFatherid,
			String permissionIntroduction, String permissionLevel,
			String permissionName, String permissionState,
			String permissionUrl, Set<TRolePermission> TRolePermissions) {
		this.isdeleted = isdeleted;
		this.permissionFatherid = permissionFatherid;
		this.permissionIntroduction = permissionIntroduction;
		this.permissionLevel = permissionLevel;
		this.permissionName = permissionName;
		this.permissionState = permissionState;
		this.permissionUrl = permissionUrl;
		this.TRolePermissions = TRolePermissions;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "permission_id", unique = true, nullable = false, length = 32)
	public String getPermissionId() {
		return this.permissionId;
	}

	public void setPermissionId(String permissionId) {
		this.permissionId = permissionId;
	}

	@Column(name = "isdeleted", length = 1)
	public String getIsdeleted() {
		return this.isdeleted;
	}

	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}

	@Column(name = "permission_fatherid", length = 32)
	public String getPermissionFatherid() {
		return this.permissionFatherid;
	}

	public void setPermissionFatherid(String permissionFatherid) {
		this.permissionFatherid = permissionFatherid;
	}

	@Column(name = "permission_introduction", length = 200)
	public String getPermissionIntroduction() {
		return this.permissionIntroduction;
	}

	public void setPermissionIntroduction(String permissionIntroduction) {
		this.permissionIntroduction = permissionIntroduction;
	}

	@Column(name = "permission_level", length = 2)
	public String getPermissionLevel() {
		return this.permissionLevel;
	}

	public void setPermissionLevel(String permissionLevel) {
		this.permissionLevel = permissionLevel;
	}

	@Column(name = "permission_name", length = 50)
	public String getPermissionName() {
		return this.permissionName;
	}

	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}

	@Column(name = "permission_state", length = 2)
	public String getPermissionState() {
		return this.permissionState;
	}

	public void setPermissionState(String permissionState) {
		this.permissionState = permissionState;
	}

	@Column(name = "permission_url", length = 200)
	public String getPermissionUrl() {
		return this.permissionUrl;
	}

	public void setPermissionUrl(String permissionUrl) {
		this.permissionUrl = permissionUrl;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TPermission")
	public Set<TRolePermission> getTRolePermissions() {
		return this.TRolePermissions;
	}

	public void setTRolePermissions(Set<TRolePermission> TRolePermissions) {
		this.TRolePermissions = TRolePermissions;
	}

}