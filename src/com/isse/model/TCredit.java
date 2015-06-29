package com.isse.model;

import java.math.BigDecimal;

/**
 * TCredit entity. @author MyEclipse Persistence Tools
 */

public class TCredit implements java.io.Serializable {

	// Fields

	private String creditId;
	private TProject TProject;
	private BigDecimal creditContribution;
	private Double creditScore;
	private String isdeleted;

	// Constructors

	/** default constructor */
	public TCredit() {
	}

	/** full constructor */
	public TCredit(TProject TProject, BigDecimal creditContribution,
			Double creditScore, String isdeleted) {
		this.TProject = TProject;
		this.creditContribution = creditContribution;
		this.creditScore = creditScore;
		this.isdeleted = isdeleted;
	}

	// Property accessors

	public String getCreditId() {
		return this.creditId;
	}

	public void setCreditId(String creditId) {
		this.creditId = creditId;
	}

	public TProject getTProject() {
		return this.TProject;
	}

	public void setTProject(TProject TProject) {
		this.TProject = TProject;
	}

	public BigDecimal getCreditContribution() {
		return this.creditContribution;
	}

	public void setCreditContribution(BigDecimal creditContribution) {
		this.creditContribution = creditContribution;
	}

	public Double getCreditScore() {
		return this.creditScore;
	}

	public void setCreditScore(Double creditScore) {
		this.creditScore = creditScore;
	}

	public String getIsdeleted() {
		return this.isdeleted;
	}

	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}

}