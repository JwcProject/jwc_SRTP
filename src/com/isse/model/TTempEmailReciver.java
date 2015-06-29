package com.isse.model;

/**
 * TTempEmailReciver entity. @author MyEclipse Persistence Tools
 */

public class TTempEmailReciver implements java.io.Serializable {

	// Fields

	private String id;
	private String departId;
	private String jqId;
	private String code;
	private String name;
	private String email;
	private String isdeleted;
	private String type;
	// Constructors

	/** default constructor */
	public TTempEmailReciver() {
	}

	/** full constructor */
	public TTempEmailReciver(String departId, String jqId, String code,
			String name, String email, String isdeleted) {
		this.departId = departId;
		this.jqId = jqId;
		this.code = code;
		this.name = name;
		this.email = email;
		this.isdeleted = isdeleted;
	}
	
	// Property accessors

	/**
	 * @param id
	 * @param departId
	 * @param jqId
	 * @param code
	 * @param name
	 * @param email
	 * @param isdeleted
	 * @param type
	 */
	public TTempEmailReciver(String id, String departId, String jqId,
			String code, String name, String email, String isdeleted,
			String type) {
		super();
		this.id = id;
		this.departId = departId;
		this.jqId = jqId;
		this.code = code;
		this.name = name;
		this.email = email;
		this.isdeleted = isdeleted;
		this.type = type;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDepartId() {
		return this.departId;
	}

	public void setDepartId(String departId) {
		this.departId = departId;
	}

	public String getJqId() {
		return this.jqId;
	}

	public void setJqId(String jqId) {
		this.jqId = jqId;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIsdeleted() {
		return this.isdeleted;
	}

	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}