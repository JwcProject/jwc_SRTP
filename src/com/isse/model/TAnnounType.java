package com.isse.model;

import java.util.HashSet;
import java.util.Set;

/**
 * TAnnounType entity. @author MyEclipse Persistence Tools
 */

public class TAnnounType implements java.io.Serializable {

	// Fields

	private String announTypeId;
	private String announTypeName;
	private String isdeleted;
	private Set TAnnouncements = new HashSet(0);

	// Constructors

	/** default constructor */
	public TAnnounType() {
	}

	/** full constructor */
	public TAnnounType(String announTypeName, String isdeleted,
			Set TAnnouncements) {
		this.announTypeName = announTypeName;
		this.isdeleted = isdeleted;
		this.TAnnouncements = TAnnouncements;
	}

	// Property accessors

	public String getAnnounTypeId() {
		return this.announTypeId;
	}

	public void setAnnounTypeId(String announTypeId) {
		this.announTypeId = announTypeId;
	}

	public String getAnnounTypeName() {
		return this.announTypeName;
	}

	public void setAnnounTypeName(String announTypeName) {
		this.announTypeName = announTypeName;
	}

	public String getIsdeleted() {
		return this.isdeleted;
	}

	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}

	public Set getTAnnouncements() {
		return this.TAnnouncements;
	}

	public void setTAnnouncements(Set TAnnouncements) {
		this.TAnnouncements = TAnnouncements;
	}

}