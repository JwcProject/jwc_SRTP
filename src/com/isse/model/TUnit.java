package com.isse.model;

import java.util.HashSet;
import java.util.Set;

import org.apache.struts2.json.annotations.JSON;

/**
 * TUnit entity. @author MyEclipse Persistence Tools
 */

public class TUnit implements java.io.Serializable {

	// Fields

	private String unitId;
	private String unitName;
	private String unitType;
	private String unitFatherid;
	private String unitCode;
	private String unitRemark;
	private String isdeleted;
	private Set TProfessions = new HashSet(0);
	private Set TProjects = new HashSet(0);
	private Set TEndProjects = new HashSet(0);
	private Set TDeclarations = new HashSet(0);
	private Set TTeachers = new HashSet(0);
	private Set TStudents = new HashSet(0);
	private Set TExpertLib = new HashSet(0);

	// Constructors

	/** default constructor */
	public TUnit() {
	}

	/** full constructor */
	public TUnit(String unitName, String unitType, String unitFatherid,
			String unitCode, String unitRemark, String isdeleted,
			Set TProfessions, Set TProjects, Set TEndProjects, Set TDeclarations, Set TTeachers,
			Set TStudents) {
		this.unitName = unitName;
		this.unitType = unitType;
		this.unitFatherid = unitFatherid;
		this.unitCode = unitCode;
		this.unitRemark = unitRemark;
		this.isdeleted = isdeleted;
		this.TProfessions = TProfessions;
		this.TProjects = TProjects;
		this.TEndProjects = TEndProjects;
		this.TDeclarations = TDeclarations;
		this.TTeachers = TTeachers;
		this.TStudents = TStudents;
	}

	// Property accessors

	public String getUnitId() {
		return this.unitId;
	}

	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}

	public String getUnitName() {
		return this.unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getUnitType() {
		return this.unitType;
	}

	public void setUnitType(String unitType) {
		this.unitType = unitType;
	}

	public String getUnitFatherid() {
		return this.unitFatherid;
	}

	public void setUnitFatherid(String unitFatherid) {
		this.unitFatherid = unitFatherid;
	}

	public String getUnitCode() {
		return this.unitCode;
	}

	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}

	public String getUnitRemark() {
		return this.unitRemark;
	}

	public void setUnitRemark(String unitRemark) {
		this.unitRemark = unitRemark;
	}

	public String getIsdeleted() {
		return this.isdeleted;
	}

	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}
	@JSON(serialize=false)
	public Set getTProfessions() {
		return this.TProfessions;
	}

	public void setTProfessions(Set TProfessions) {
		this.TProfessions = TProfessions;
	}
	@JSON(serialize=false)
	public Set getTProjects() {
		return this.TProjects;
	}

	public void setTProjects(Set TProjects) {
		this.TProjects = TProjects;
	}
	@JSON(serialize=false)
	public Set getTEndProjects() {
		return TEndProjects;
	}

	public void setTEndProjects(Set tEndProjects) {
		TEndProjects = tEndProjects;
	}

	@JSON(serialize=false)
	public Set getTDeclarations() {
		return this.TDeclarations;
	}

	public void setTDeclarations(Set TDeclarations) {
		this.TDeclarations = TDeclarations;
	}
	@JSON(serialize=false)
	public Set getTTeachers() {
		return this.TTeachers;
	}

	public void setTTeachers(Set TTeachers) {
		this.TTeachers = TTeachers;
	}
	@JSON(serialize=false)
	public Set getTStudents() {
		return this.TStudents;
	}

	public void setTStudents(Set TStudents) {
		this.TStudents = TStudents;
	}
	@JSON(serialize=false)
	public Set getTExpertLib() {
		return TExpertLib;
	}

	public void setTExpertLib(Set tExpertLib) {
		TExpertLib = tExpertLib;
	}
	
}