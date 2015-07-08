package edu.cqu.no1.domain;

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
 * TRoleAuthority entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_role_authority", catalog = "srtp")
public class TRoleAuthority implements java.io.Serializable {

	// Fields

	private String id;
	private TRole TRole;
	private TAuthority TAuthority;

	// Constructors

	/** default constructor */
	public TRoleAuthority() {
	}

	/** full constructor */
	public TRoleAuthority(TRole TRole, TAuthority TAuthority) {
		this.TRole = TRole;
		this.TAuthority = TAuthority;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role", nullable = false)
	public TRole getTRole() {
		return this.TRole;
	}

	public void setTRole(TRole TRole) {
		this.TRole = TRole;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "authority", nullable = false)
	public TAuthority getTAuthority() {
		return this.TAuthority;
	}

	public void setTAuthority(TAuthority TAuthority) {
		this.TAuthority = TAuthority;
	}

}