package com.isse.model;

import java.util.HashSet;
import java.util.Set;

/**
 * TProfession entity. @author MyEclipse Persistence Tools
 */

public class TProfession implements java.io.Serializable {

	// Fields

	private String professionId;
	private TUnit TUnit;
	private String professionName;
	private String professionSession;
	private String professionClass;
	private String professionRemark;
	private String professionIsdeleted;
	private Set TStudents = new HashSet(0);

	// Constructors

	/** default constructor */
	public TProfession() {
	}

	/** full constructor */
	public TProfession(TUnit TUnit, String professionName,
			String professionSession, String professionClass,
			String professionRemark, String professionIsdeleted, Set TStudents) {
		this.TUnit = TUnit;
		this.professionName = professionName;
		this.professionSession = professionSession;
		this.professionClass = professionClass;
		this.professionRemark = professionRemark;
		this.professionIsdeleted = professionIsdeleted;
		this.TStudents = TStudents;
	}

	// Property accessors

	public String getProfessionId() {
		return this.professionId;
	}

	public void setProfessionId(String professionId) {
		this.professionId = professionId;
	}

	public TUnit getTUnit() {
		return this.TUnit;
	}

	public void setTUnit(TUnit TUnit) {
		this.TUnit = TUnit;
	}

	public String getProfessionName() {
		return this.professionName;
	}

	public void setProfessionName(String professionName) {
		this.professionName = professionName;
	}

	public String getProfessionSession() {
		return this.professionSession;
	}

	public void setProfessionSession(String professionSession) {
		this.professionSession = professionSession;
	}

	public String getProfessionClass() {
		return this.professionClass;
	}

	public void setProfessionClass(String professionClass) {
		this.professionClass = professionClass;
	}

	public String getProfessionRemark() {
		return this.professionRemark;
	}

	public void setProfessionRemark(String professionRemark) {
		this.professionRemark = professionRemark;
	}

	public String getProfessionIsdeleted() {
		return this.professionIsdeleted;
	}

	public void setProfessionIsdeleted(String professionIsdeleted) {
		this.professionIsdeleted = professionIsdeleted;
	}

	public Set getTStudents() {
		return this.TStudents;
	}

	public void setTStudents(Set TStudents) {
		this.TStudents = TStudents;
	}

}