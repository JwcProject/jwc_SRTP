package com.isse.model;

/**
 * TCode entity. @author MyEclipse Persistence Tools
 */

public class TCode implements java.io.Serializable {

	// Fields

	private String encodeId;
	private String encodeValue;
	private String encodeDesc;
	private String encodeRemark;
	private String isdeleted;

	// Constructors

	/** default constructor */
	public TCode() {
	}

	/** full constructor */
	public TCode(String encodeValue, String encodeDesc, String encodeRemark,
			String isdeleted) {
		this.encodeValue = encodeValue;
		this.encodeDesc = encodeDesc;
		this.encodeRemark = encodeRemark;
		this.isdeleted = isdeleted;
	}

	// Property accessors

	public String getEncodeId() {
		return this.encodeId;
	}

	public void setEncodeId(String encodeId) {
		this.encodeId = encodeId;
	}

	public String getEncodeValue() {
		return this.encodeValue;
	}

	public void setEncodeValue(String encodeValue) {
		this.encodeValue = encodeValue;
	}

	public String getEncodeDesc() {
		return this.encodeDesc;
	}

	public void setEncodeDesc(String encodeDesc) {
		this.encodeDesc = encodeDesc;
	}

	public String getEncodeRemark() {
		return this.encodeRemark;
	}

	public void setEncodeRemark(String encodeRemark) {
		this.encodeRemark = encodeRemark;
	}

	public String getIsdeleted() {
		return this.isdeleted;
	}

	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}

}