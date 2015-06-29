package com.isse.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * TProjectChange entity. @author MyEclipse Persistence Tools
 */

public class TProjectChange implements java.io.Serializable {

	// Fields

	private String projectchangeId;
	private TProject TProject;
	private String projectchangeState;
	private String projectchangeAtid;
	private String projectchangeCtid;
	private Date projectchangeCtime;
	private Date projectchangeAtime;
	private Date projectchangeDate;
	private String projectchangeReason;
	private String isdeleted;
	private Set TProjectChangeContents = new HashSet(0);

	// Constructors

	/** default constructor */
	public TProjectChange() {
	}

	/** full constructor */
	public TProjectChange(TProject TProject, String projectchangeState,
			String projectchangeAtid, String projectchangeCtid,
			Date projectchangeCtime, Date projectchangeAtime,
			Date projectchangeDate, String projectchangeReason,
			String isdeleted, Set TProjectChangeContents) {
		this.TProject = TProject;
		this.projectchangeState = projectchangeState;
		this.projectchangeAtid = projectchangeAtid;
		this.projectchangeCtid = projectchangeCtid;
		this.projectchangeCtime = projectchangeCtime;
		this.projectchangeAtime = projectchangeAtime;
		this.projectchangeDate = projectchangeDate;
		this.projectchangeReason = projectchangeReason;
		this.isdeleted = isdeleted;
		this.TProjectChangeContents = TProjectChangeContents;
	}

	// Property accessors

	public String getProjectchangeId() {
		return this.projectchangeId;
	}

	public void setProjectchangeId(String projectchangeId) {
		this.projectchangeId = projectchangeId;
	}

	public TProject getTProject() {
		return this.TProject;
	}

	public void setTProject(TProject TProject) {
		this.TProject = TProject;
	}

	public String getProjectchangeState() {
		return this.projectchangeState;
	}

	public void setProjectchangeState(String projectchangeState) {
		this.projectchangeState = projectchangeState;
	}

	public String getProjectchangeAtid() {
		return this.projectchangeAtid;
	}

	public void setProjectchangeAtid(String projectchangeAtid) {
		this.projectchangeAtid = projectchangeAtid;
	}

	public String getProjectchangeCtid() {
		return this.projectchangeCtid;
	}

	public void setProjectchangeCtid(String projectchangeCtid) {
		this.projectchangeCtid = projectchangeCtid;
	}

	public Date getProjectchangeCtime() {
		return this.projectchangeCtime;
	}

	public void setProjectchangeCtime(Date projectchangeCtime) {
		this.projectchangeCtime = projectchangeCtime;
	}

	public Date getProjectchangeAtime() {
		return this.projectchangeAtime;
	}

	public void setProjectchangeAtime(Date projectchangeAtime) {
		this.projectchangeAtime = projectchangeAtime;
	}

	public Date getProjectchangeDate() {
		return this.projectchangeDate;
	}

	public void setProjectchangeDate(Date projectchangeDate) {
		this.projectchangeDate = projectchangeDate;
	}

	public String getProjectchangeReason() {
		return this.projectchangeReason;
	}

	public void setProjectchangeReason(String projectchangeReason) {
		this.projectchangeReason = projectchangeReason;
	}

	public String getIsdeleted() {
		return this.isdeleted;
	}

	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}

	public Set getTProjectChangeContents() {
		return this.TProjectChangeContents;
	}

	public void setTProjectChangeContents(Set TProjectChangeContents) {
		this.TProjectChangeContents = TProjectChangeContents;
	}

}