package com.isse.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * TDeclComment entity. @author MyEclipse Persistence Tools
 */

public class TDeclComment implements java.io.Serializable {

	// Fields

	private String declComId;
	private TExpertReview TExpertReview;
	private String declArgument;
	private String compEval;
	private BigDecimal declScore;
	private Date reviewTime;
	private String isdeleted;

	// Constructors

	/** default constructor */
	public TDeclComment() {
	}

	/** full constructor */
	public TDeclComment(TExpertReview TExpertReview, String declArgument,
			String compEval, BigDecimal declScore, Date reviewTime,
			String isdeleted) {
		this.TExpertReview = TExpertReview;
		this.declArgument = declArgument;
		this.compEval = compEval;
		this.declScore = declScore;
		this.reviewTime = reviewTime;
		this.isdeleted = isdeleted;
	}

	// Property accessors

	public String getDeclComId() {
		return this.declComId;
	}

	public void setDeclComId(String declComId) {
		this.declComId = declComId;
	}

	public TExpertReview getTExpertReview() {
		return this.TExpertReview;
	}

	public void setTExpertReview(TExpertReview TExpertReview) {
		this.TExpertReview = TExpertReview;
	}

	public String getDeclArgument() {
		return this.declArgument;
	}

	public void setDeclArgument(String declArgument) {
		this.declArgument = declArgument;
	}

	public String getCompEval() {
		return this.compEval;
	}

	public void setCompEval(String compEval) {
		this.compEval = compEval;
	}

	public BigDecimal getDeclScore() {
		return this.declScore;
	}

	public void setDeclScore(BigDecimal declScore) {
		this.declScore = declScore;
	}

	public Date getReviewTime() {
		return this.reviewTime;
	}

	public void setReviewTime(Date reviewTime) {
		this.reviewTime = reviewTime;
	}

	public String getIsdeleted() {
		return this.isdeleted;
	}

	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}

}