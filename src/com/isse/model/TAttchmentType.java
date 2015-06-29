package com.isse.model;

import java.util.HashSet;
import java.util.Set;

/**
 * TAttchmentType entity. @author MyEclipse Persistence Tools
 */

public class TAttchmentType implements java.io.Serializable {

	// Fields

	private String attaTypeId;
	private String attaTypeName;
	private String isdeleted;
	private Set TAttachments = new HashSet(0);

	// Constructors

	/** default constructor */
	public TAttchmentType() {
	}

	/** full constructor */
	public TAttchmentType(String attaTypeName, String isdeleted,
			Set TAttachments) {
		this.attaTypeName = attaTypeName;
		this.isdeleted = isdeleted;
		this.TAttachments = TAttachments;
	}

	// Property accessors

	public String getAttaTypeId() {
		return this.attaTypeId;
	}

	public void setAttaTypeId(String attaTypeId) {
		this.attaTypeId = attaTypeId;
	}

	public String getAttaTypeName() {
		return this.attaTypeName;
	}

	public void setAttaTypeName(String attaTypeName) {
		this.attaTypeName = attaTypeName;
	}

	public String getIsdeleted() {
		return this.isdeleted;
	}

	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}

	public Set getTAttachments() {
		return this.TAttachments;
	}

	public void setTAttachments(Set TAttachments) {
		this.TAttachments = TAttachments;
	}

}