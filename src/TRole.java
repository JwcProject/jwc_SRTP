// default package

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
 * TRole entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_role", catalog = "srtp")
public class TRole implements java.io.Serializable {

	// Fields

	private String roleId;
	private String roleName;
	private String roleState;
	private String roleIntroduction;
	private String isdeleted;
	private Set<TRolePermission> TRolePermissions = new HashSet<TRolePermission>(
			0);
	private Set<TUserRole> TUserRoles = new HashSet<TUserRole>(0);

	// Constructors

	/** default constructor */
	public TRole() {
	}

	/** full constructor */
	public TRole(String roleName, String roleState, String roleIntroduction,
			String isdeleted, Set<TRolePermission> TRolePermissions,
			Set<TUserRole> TUserRoles) {
		this.roleName = roleName;
		this.roleState = roleState;
		this.roleIntroduction = roleIntroduction;
		this.isdeleted = isdeleted;
		this.TRolePermissions = TRolePermissions;
		this.TUserRoles = TUserRoles;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "guid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "role_id", unique = true, nullable = false, length = 32)
	public String getRoleId() {
		return this.roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	@Column(name = "role_name", length = 20)
	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Column(name = "role_state", length = 2)
	public String getRoleState() {
		return this.roleState;
	}

	public void setRoleState(String roleState) {
		this.roleState = roleState;
	}

	@Column(name = "role_introduction", length = 50)
	public String getRoleIntroduction() {
		return this.roleIntroduction;
	}

	public void setRoleIntroduction(String roleIntroduction) {
		this.roleIntroduction = roleIntroduction;
	}

	@Column(name = "isdeleted", length = 1)
	public String getIsdeleted() {
		return this.isdeleted;
	}

	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TRole")
	public Set<TRolePermission> getTRolePermissions() {
		return this.TRolePermissions;
	}

	public void setTRolePermissions(Set<TRolePermission> TRolePermissions) {
		this.TRolePermissions = TRolePermissions;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TRole")
	public Set<TUserRole> getTUserRoles() {
		return this.TUserRoles;
	}

	public void setTUserRoles(Set<TUserRole> TUserRoles) {
		this.TUserRoles = TUserRoles;
	}

}