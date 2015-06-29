package com.isse.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * TEndProjectComment entity. @author MyEclipse Persistence Tools
 */

public class TEndProjectComment implements java.io.Serializable {

	// Fields

	private String id;
	private TEndProjectExport TEndProjectExport;
	private String endprojectcommentAdvise;
	private BigDecimal endprojectcommentScore;
	private String endprojectcommentContent;
	private String isdeleted;
	private Date endprojectcommentTime;

	// Constructors

	/** default constructor */
	public TEndProjectComment() {
	}

	/** full constructor */
	public TEndProjectComment(TEndProjectExport TEndProjectExport,
			String endprojectcommentAdvise, BigDecimal endprojectcommentScore,
			String endprojectcommentContent, String isdeleted,
			Date endprojectcommentTime) {
		this.TEndProjectExport = TEndProjectExport;
		this.endprojectcommentAdvise = endprojectcommentAdvise;
		this.endprojectcommentScore = endprojectcommentScore;
		this.endprojectcommentContent = endprojectcommentContent;
		this.isdeleted = isdeleted;
		this.endprojectcommentTime = endprojectcommentTime;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public TEndProjectExport getTEndProjectExport() {
		return this.TEndProjectExport;
	}

	public void setTEndProjectExport(TEndProjectExport TEndProjectExport) {
		this.TEndProjectExport = TEndProjectExport;
	}

	public String getEndprojectcommentAdvise() {
		return this.endprojectcommentAdvise;
	}

	public void setEndprojectcommentAdvise(String endprojectcommentAdvise) {
		this.endprojectcommentAdvise = endprojectcommentAdvise;
	}

	public BigDecimal getEndprojectcommentScore() {
		return this.endprojectcommentScore;
	}

	public void setEndprojectcommentScore(BigDecimal endprojectcommentScore) {
		this.endprojectcommentScore = endprojectcommentScore;
	}

	public String getEndprojectcommentContent() {
		return this.endprojectcommentContent;
	}

	public void setEndprojectcommentContent(String endprojectcommentContent) {
		this.endprojectcommentContent = endprojectcommentContent;
	}

	public String getIsdeleted() {
		return this.isdeleted;
	}

	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}

	public Date getEndprojectcommentTime() {
		return this.endprojectcommentTime;
	}

	public void setEndprojectcommentTime(Date endprojectcommentTime) {
		this.endprojectcommentTime = endprojectcommentTime;
	}

}