package com.isse.model;

/**
 * TProjectChangeContent entity. @author MyEclipse Persistence Tools
 */

public class TProjectChangeContent implements java.io.Serializable {

	// Fields

	private String projectchangecontentId;
	private TProjectChange TProjectChange;
	private String projectchangecontentField;
	private String projectchangecontentFieldname;
	private String projectchangecontentOvalue;
	private String projectchangecontentNvalue;
	private String isdeleted;

	// Constructors

	/** default constructor */
	public TProjectChangeContent() {
	}

	/** full constructor */
	public TProjectChangeContent(TProjectChange TProjectChange,
			String projectchangecontentField,
			String projectchangecontentFieldname,
			String projectchangecontentOvalue,
			String projectchangecontentNvalue, String isdeleted) {
		this.TProjectChange = TProjectChange;
		this.projectchangecontentField = projectchangecontentField;
		this.projectchangecontentFieldname = projectchangecontentFieldname;
		this.projectchangecontentOvalue = projectchangecontentOvalue;
		this.projectchangecontentNvalue = projectchangecontentNvalue;
		this.isdeleted = isdeleted;
	}

	// Property accessors

	public String getProjectchangecontentId() {
		return this.projectchangecontentId;
	}

	public void setProjectchangecontentId(String projectchangecontentId) {
		this.projectchangecontentId = projectchangecontentId;
	}

	public TProjectChange getTProjectChange() {
		return this.TProjectChange;
	}

	public void setTProjectChange(TProjectChange TProjectChange) {
		this.TProjectChange = TProjectChange;
	}

	public String getProjectchangecontentField() {
		return this.projectchangecontentField;
	}

	public void setProjectchangecontentField(String projectchangecontentField) {
		this.projectchangecontentField = projectchangecontentField;
	}

	public String getProjectchangecontentFieldname() {
		return this.projectchangecontentFieldname;
	}

	public void setProjectchangecontentFieldname(
			String projectchangecontentFieldname) {
		this.projectchangecontentFieldname = projectchangecontentFieldname;
	}

	public String getProjectchangecontentOvalue() {
		return this.projectchangecontentOvalue;
	}

	public void setProjectchangecontentOvalue(String projectchangecontentOvalue) {
		this.projectchangecontentOvalue = projectchangecontentOvalue;
	}

	public String getProjectchangecontentNvalue() {
		return this.projectchangecontentNvalue;
	}

	public void setProjectchangecontentNvalue(String projectchangecontentNvalue) {
		this.projectchangecontentNvalue = projectchangecontentNvalue;
	}

	public String getIsdeleted() {
		return this.isdeleted;
	}

	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}

}