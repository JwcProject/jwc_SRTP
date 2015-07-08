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
 * TRole entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_role", catalog = "srtp")
public class TRole implements java.io.Serializable {

	// Fields

	private String id;
	private String name;
	private String desc;
	private Set<TRoleAuthority> TRoleAuthorities = new HashSet<TRoleAuthority>(
			0);
	private Set<TUser> TUsers = new HashSet<TUser>(0);

	// Constructors

	/** default constructor */
	public TRole() {
	}

	/** minimal constructor */
	public TRole(String name) {
		this.name = name;
	}

	/** full constructor */
	public TRole(String name, String desc,
			Set<TRoleAuthority> TRoleAuthorities, Set<TUser> TUsers) {
		this.name = name;
		this.desc = desc;
		this.TRoleAuthorities = TRoleAuthorities;
		this.TUsers = TUsers;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "id", unique = true, nullable = false, length = 36)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "desc")
	public String getDesc() {
		return this.desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TRole")
	public Set<TRoleAuthority> getTRoleAuthorities() {
		return this.TRoleAuthorities;
	}

	public void setTRoleAuthorities(Set<TRoleAuthority> TRoleAuthorities) {
		this.TRoleAuthorities = TRoleAuthorities;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TRole")
	public Set<TUser> getTUsers() {
		return this.TUsers;
	}

	public void setTUsers(Set<TUser> TUsers) {
		this.TUsers = TUsers;
	}

}