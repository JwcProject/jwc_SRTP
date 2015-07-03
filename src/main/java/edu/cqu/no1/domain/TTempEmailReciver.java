package edu.cqu.no1.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TTempEmailReciver entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_temp_email_reciver", catalog = "srtp")
public class TTempEmailReciver implements java.io.Serializable {

	// Fields

	private String id;
	private String code;
	private String departId;
	private String email;
	private String isdeleted;
	private String jqId;
	private String name;
	private String type;

	// Constructors

	/** default constructor */
	public TTempEmailReciver() {
	}

	/** full constructor */
	public TTempEmailReciver(String code, String departId, String email,
			String isdeleted, String jqId, String name, String type) {
		this.code = code;
		this.departId = departId;
		this.email = email;
		this.isdeleted = isdeleted;
		this.jqId = jqId;
		this.name = name;
		this.type = type;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "id", unique = true, nullable = false, length = 32)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "code", length = 32)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "depart_id", length = 32)
	public String getDepartId() {
		return this.departId;
	}

	public void setDepartId(String departId) {
		this.departId = departId;
	}

	@Column(name = "email", length = 100)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "isdeleted", length = 1)
	public String getIsdeleted() {
		return this.isdeleted;
	}

	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}

	@Column(name = "jq_id", length = 32)
	public String getJqId() {
		return this.jqId;
	}

	public void setJqId(String jqId) {
		this.jqId = jqId;
	}

	@Column(name = "name", length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "type", length = 2)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

}