package com.isse.model;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import org.apache.struts2.json.annotations.JSON;

/**
 * TTeacher entity. @author MyEclipse Persistence Tools
 */

public class TTeacher implements java.io.Serializable {

	// Fields

	private String teaId;
	private TUnit TUnit;
	private String teaName;
	private String teaCode;
	private BigDecimal teaAge;
	private String teaSex;
	private String teaTitle;
	private String teaTele;
	private String teaEmail;
	private String teaState;
	private String teaIntro;
	private String teaRemark;
	private String isdeleted;
	private Set TDeclarationsForTeacher2Code = new HashSet(0);
	private Set TExpertTeachers = new HashSet(0);
	private Set TExpertLibs = new HashSet(0);
	private Set TEmails = new HashSet(0);
	private Set TDeclarationsForTeacher1Code = new HashSet(0);

	// Constructors

	/** default constructor */
	public TTeacher() {
	}

	/** full constructor */
	public TTeacher(TUnit TUnit, String teaName, String teaCode,
			BigDecimal teaAge, String teaSex, String teaTitle, String teaTele,
			String teaEmail, String teaState, String teaIntro,
			String teaRemark, String isdeleted,
			Set TDeclarationsForTeacher2Code, Set TExpertTeachers,
			Set TExpertLibs, Set TEmails, Set TDeclarationsForTeacher1Code) {
		this.TUnit = TUnit;
		this.teaName = teaName;
		this.teaCode = teaCode;
		this.teaAge = teaAge;
		this.teaSex = teaSex;
		this.teaTitle = teaTitle;
		this.teaTele = teaTele;
		this.teaEmail = teaEmail;
		this.teaState = teaState;
		this.teaIntro = teaIntro;
		this.teaRemark = teaRemark;
		this.isdeleted = isdeleted;
		this.TDeclarationsForTeacher2Code = TDeclarationsForTeacher2Code;
		this.TExpertTeachers = TExpertTeachers;
		this.TExpertLibs = TExpertLibs;
		this.TEmails = TEmails;
		this.TDeclarationsForTeacher1Code = TDeclarationsForTeacher1Code;
	}

	// Property accessors

	public String getTeaId() {
		return this.teaId;
	}

	public void setTeaId(String teaId) {
		this.teaId = teaId;
	}

	public TUnit getTUnit() {
		return this.TUnit;
	}

	public void setTUnit(TUnit TUnit) {
		this.TUnit = TUnit;
	}

	public String getTeaName() {
		return this.teaName;
	}

	public void setTeaName(String teaName) {
		this.teaName = teaName;
	}

	public String getTeaCode() {
		return this.teaCode;
	}

	public void setTeaCode(String teaCode) {
		this.teaCode = teaCode;
	}

	public BigDecimal getTeaAge() {
		return this.teaAge;
	}

	public void setTeaAge(BigDecimal teaAge) {
		this.teaAge = teaAge;
	}

	public String getTeaSex() {
		return this.teaSex;
	}

	public void setTeaSex(String teaSex) {
		this.teaSex = teaSex;
	}

	public String getTeaTitle() {
		return this.teaTitle;
	}

	public void setTeaTitle(String teaTitle) {
		this.teaTitle = teaTitle;
	}

	public String getTeaTele() {
		return this.teaTele;
	}

	public void setTeaTele(String teaTele) {
		this.teaTele = teaTele;
	}

	public String getTeaEmail() {
		return this.teaEmail;
	}

	public void setTeaEmail(String teaEmail) {
		this.teaEmail = teaEmail;
	}

	public String getTeaState() {
		return this.teaState;
	}

	public void setTeaState(String teaState) {
		this.teaState = teaState;
	}

	public String getTeaIntro() {
		return this.teaIntro;
	}

	public void setTeaIntro(String teaIntro) {
		this.teaIntro = teaIntro;
	}

	public String getTeaRemark() {
		return this.teaRemark;
	}

	public void setTeaRemark(String teaRemark) {
		this.teaRemark = teaRemark;
	}

	public String getIsdeleted() {
		return this.isdeleted;
	}

	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}
	@JSON(serialize=false)
	public Set getTDeclarationsForTeacher2Code() {
		return this.TDeclarationsForTeacher2Code;
	}

	public void setTDeclarationsForTeacher2Code(Set TDeclarationsForTeacher2Code) {
		this.TDeclarationsForTeacher2Code = TDeclarationsForTeacher2Code;
	}
	@JSON(serialize=false)
	public Set getTExpertTeachers() {
		return this.TExpertTeachers;
	}

	public void setTExpertTeachers(Set TExpertTeachers) {
		this.TExpertTeachers = TExpertTeachers;
	}
	@JSON(serialize=false)
	public Set getTExpertLibs() {
		return this.TExpertLibs;
	}

	public void setTExpertLibs(Set TExpertLibs) {
		this.TExpertLibs = TExpertLibs;
	}
	@JSON(serialize=false)
	public Set getTEmails() {
		return this.TEmails;
	}

	public void setTEmails(Set TEmails) {
		this.TEmails = TEmails;
	}
	@JSON(serialize=false)
	public Set getTDeclarationsForTeacher1Code() {
		return this.TDeclarationsForTeacher1Code;
	}

	public void setTDeclarationsForTeacher1Code(Set TDeclarationsForTeacher1Code) {
		this.TDeclarationsForTeacher1Code = TDeclarationsForTeacher1Code;
	}

}