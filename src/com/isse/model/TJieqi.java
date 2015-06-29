package com.isse.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * TJieqi entity. @author MyEclipse Persistence Tools
 */

public class TJieqi implements java.io.Serializable {

	// Fields

	private String jqId;
	private String jqName;
	private BigDecimal jqYear;
	private String qici;
	private Date startOn;
	private Date endOn;
	private Date zjStartOn;
	private Date zjEndOn;
	private Date jtStartOn;
	private Date jtEndOn;
	private String secondaryAssessment;
	private String secondaryRespondent;
	private String isdeleted;
	private String declarationState;
	private String endprojectState;
	private Set TProjects = new HashSet(0);
	private Set TExpertLibs = new HashSet(0);
	private Set TEmails = new HashSet(0);
	private Set TEndProjects = new HashSet(0);
	private Set TDeclarations = new HashSet(0);

	// Constructors

	/** default constructor */
	public TJieqi() {
	}

	/** full constructor */
	public TJieqi(String jqName, BigDecimal jqYear, String qici, Date startOn,
			Date endOn, Date zjStartOn, Date zjEndOn, Date jtStartOn,
			Date jtEndOn, String secondaryAssessment,
			String secondaryRespondent, String isdeleted,
			String declarationState, String endprojectState, Set TProjects,
			Set TExpertLibs, Set TEmails, Set TEndProjects, Set TDeclarations) {
		this.jqName = jqName;
		this.jqYear = jqYear;
		this.qici = qici;
		this.startOn = startOn;
		this.endOn = endOn;
		this.zjStartOn = zjStartOn;
		this.zjEndOn = zjEndOn;
		this.jtStartOn = jtStartOn;
		this.jtEndOn = jtEndOn;
		this.secondaryAssessment = secondaryAssessment;
		this.secondaryRespondent = secondaryRespondent;
		this.isdeleted = isdeleted;
		this.declarationState = declarationState;
		this.endprojectState = endprojectState;
		this.TProjects = TProjects;
		this.TExpertLibs = TExpertLibs;
		this.TEmails = TEmails;
		this.TEndProjects = TEndProjects;
		this.TDeclarations = TDeclarations;
	}

	// Property accessors

	public String getJqId() {
		return this.jqId;
	}

	public void setJqId(String jqId) {
		this.jqId = jqId;
	}

	public String getJqName() {
		return this.jqName;
	}

	public void setJqName(String jqName) {
		this.jqName = jqName;
	}

	public BigDecimal getJqYear() {
		return this.jqYear;
	}

	public void setJqYear(BigDecimal jqYear) {
		this.jqYear = jqYear;
	}

	public String getQici() {
		return this.qici;
	}

	public void setQici(String qici) {
		this.qici = qici;
	}

	public Date getStartOn() {
		return this.startOn;
	}

	public void setStartOn(Date startOn) {
		this.startOn = startOn;
	}

	public Date getEndOn() {
		return this.endOn;
	}

	public void setEndOn(Date endOn) {
		this.endOn = endOn;
	}

	public Date getZjStartOn() {
		return this.zjStartOn;
	}

	public void setZjStartOn(Date zjStartOn) {
		this.zjStartOn = zjStartOn;
	}

	public Date getZjEndOn() {
		return this.zjEndOn;
	}

	public void setZjEndOn(Date zjEndOn) {
		this.zjEndOn = zjEndOn;
	}

	public Date getJtStartOn() {
		return this.jtStartOn;
	}

	public void setJtStartOn(Date jtStartOn) {
		this.jtStartOn = jtStartOn;
	}

	public Date getJtEndOn() {
		return this.jtEndOn;
	}

	public void setJtEndOn(Date jtEndOn) {
		this.jtEndOn = jtEndOn;
	}

	public String getSecondaryAssessment() {
		return this.secondaryAssessment;
	}

	public void setSecondaryAssessment(String secondaryAssessment) {
		this.secondaryAssessment = secondaryAssessment;
	}

	public String getSecondaryRespondent() {
		return this.secondaryRespondent;
	}

	public void setSecondaryRespondent(String secondaryRespondent) {
		this.secondaryRespondent = secondaryRespondent;
	}

	public String getIsdeleted() {
		return this.isdeleted;
	}

	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}

	public String getDeclarationState() {
		return this.declarationState;
	}

	public void setDeclarationState(String declarationState) {
		this.declarationState = declarationState;
	}

	public String getEndprojectState() {
		return this.endprojectState;
	}

	public void setEndprojectState(String endprojectState) {
		this.endprojectState = endprojectState;
	}

	public Set getTProjects() {
		return this.TProjects;
	}

	public void setTProjects(Set TProjects) {
		this.TProjects = TProjects;
	}

	public Set getTExpertLibs() {
		return this.TExpertLibs;
	}

	public void setTExpertLibs(Set TExpertLibs) {
		this.TExpertLibs = TExpertLibs;
	}

	public Set getTEmails() {
		return this.TEmails;
	}

	public void setTEmails(Set TEmails) {
		this.TEmails = TEmails;
	}

	public Set getTEndProjects() {
		return this.TEndProjects;
	}

	public void setTEndProjects(Set TEndProjects) {
		this.TEndProjects = TEndProjects;
	}

	public Set getTDeclarations() {
		return this.TDeclarations;
	}

	public void setTDeclarations(Set TDeclarations) {
		this.TDeclarations = TDeclarations;
	}

}