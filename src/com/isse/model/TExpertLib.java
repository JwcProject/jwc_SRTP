package com.isse.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * TExpertLib entity. @author MyEclipse Persistence Tools
 */

public class TExpertLib implements java.io.Serializable {

	// Fields

	private String libId;
	private TJieqi TJieqi;
	private TTeacher TTeacher;
	private Date creatOn;
	private String isAssigned;
	private String isdeleted;
	private String type;
	private TUnit TUnit;
	private Set TExpertTeachers = new HashSet(0);

	// Constructors

	/** default constructor */
	public TExpertLib() {
	}

	/** full constructor */
	public TExpertLib(TJieqi TJieqi, TTeacher TTeacher, Date creatOn,
			String isAssigned, String isdeleted, Set TExpertTeachers) {
		this.TJieqi = TJieqi;
		this.TTeacher = TTeacher;
		this.creatOn = creatOn;
		this.isAssigned = isAssigned;
		this.isdeleted = isdeleted;
		this.TExpertTeachers = TExpertTeachers;
	}

	/**
	 * @param libId
	 * @param tJieqi
	 * @param tTeacher
	 * @param creatOn
	 * @param isAssigned
	 * @param isdeleted
	 * @param type
	 * @param tUnit
	 * @param tExpertTeachers
	 */
	public TExpertLib(String libId, com.isse.model.TJieqi tJieqi,
			com.isse.model.TTeacher tTeacher, Date creatOn, String isAssigned,
			String isdeleted, String type, com.isse.model.TUnit tUnit,
			Set tExpertTeachers) {
		super();
		this.libId = libId;
		TJieqi = tJieqi;
		TTeacher = tTeacher;
		this.creatOn = creatOn;
		this.isAssigned = isAssigned;
		this.isdeleted = isdeleted;
		this.type = type;
		TUnit = tUnit;
		TExpertTeachers = tExpertTeachers;
	}

	// Property accessors

	public String getLibId() {
		return this.libId;
	}

	public void setLibId(String libId) {
		this.libId = libId;
	}

	public TJieqi getTJieqi() {
		return this.TJieqi;
	}

	public void setTJieqi(TJieqi TJieqi) {
		this.TJieqi = TJieqi;
	}

	public TTeacher getTTeacher() {
		return this.TTeacher;
	}

	public void setTTeacher(TTeacher TTeacher) {
		this.TTeacher = TTeacher;
	}

	public Date getCreatOn() {
		return this.creatOn;
	}

	public void setCreatOn(Date creatOn) {
		this.creatOn = creatOn;
	}

	public String getIsAssigned() {
		return this.isAssigned;
	}

	public void setIsAssigned(String isAssigned) {
		this.isAssigned = isAssigned;
	}

	public String getIsdeleted() {
		return this.isdeleted;
	}

	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}

	public Set getTExpertTeachers() {
		return this.TExpertTeachers;
	}

	public void setTExpertTeachers(Set TExpertTeachers) {
		this.TExpertTeachers = TExpertTeachers;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public TUnit getTUnit() {
		return TUnit;
	}

	public void setTUnit(TUnit tUnit) {
		TUnit = tUnit;
	}

}