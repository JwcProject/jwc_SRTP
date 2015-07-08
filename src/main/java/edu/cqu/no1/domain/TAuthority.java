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
 * TAuthority entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_authority", catalog = "srtp")
public class TAuthority implements java.io.Serializable {

	// Fields

	private String id;
	private String path;
	private String name;
	private String desc;
	private Set<TRoleAuthority> TRoleAuthorities = new HashSet<TRoleAuthority>(
			0);

	// Constructors

	/** default constructor */
	public TAuthority() {
	}

	/** minimal constructor */
	public TAuthority(String path, String name) {
		this.path = path;
		this.name = name;
	}

	/** full constructor */
	public TAuthority(String path, String name, String desc,
			Set<TRoleAuthority> TRoleAuthorities) {
		this.path = path;
		this.name = name;
		this.desc = desc;
		this.TRoleAuthorities = TRoleAuthorities;
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

	@Column(name = "path", nullable = false)
	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TAuthority")
	public Set<TRoleAuthority> getTRoleAuthorities() {
		return this.TRoleAuthorities;
	}

	public void setTRoleAuthorities(Set<TRoleAuthority> TRoleAuthorities) {
		this.TRoleAuthorities = TRoleAuthorities;
	}

}