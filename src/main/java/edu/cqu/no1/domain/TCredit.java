package edu.cqu.no1.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TCredit entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_credit", catalog = "srtp")
public class TCredit implements java.io.Serializable {

	// Fields

	private String creditId;
	private TProject TProject;
	private Integer creditContribution;
	private Float creditScore;
	private String isdeleted;

	// Constructors

	/** default constructor */
	public TCredit() {
	}

	/** full constructor */
	public TCredit(TProject TProject, Integer creditContribution,
			Float creditScore, String isdeleted) {
		this.TProject = TProject;
		this.creditContribution = creditContribution;
		this.creditScore = creditScore;
		this.isdeleted = isdeleted;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "credit_id", unique = true, nullable = false, length = 32)
	public String getCreditId() {
		return this.creditId;
	}

	public void setCreditId(String creditId) {
		this.creditId = creditId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "project_id")
	public TProject getTProject() {
		return this.TProject;
	}

	public void setTProject(TProject TProject) {
		this.TProject = TProject;
	}

	@Column(name = "credit_contribution")
	public Integer getCreditContribution() {
		return this.creditContribution;
	}

	public void setCreditContribution(Integer creditContribution) {
		this.creditContribution = creditContribution;
	}

	@Column(name = "credit_score", precision = 12, scale = 0)
	public Float getCreditScore() {
		return this.creditScore;
	}

	public void setCreditScore(Float creditScore) {
		this.creditScore = creditScore;
	}

	@Column(name = "isdeleted", length = 1)
	public String getIsdeleted() {
		return this.isdeleted;
	}

	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}

}