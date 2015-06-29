package com.isse.model;

import java.util.HashSet;
import java.util.Set;

/**
 * TExpertReview entity. @author MyEclipse Persistence Tools
 */

public class TExpertReview implements java.io.Serializable {

	// Fields

	private String exReviewId;
	private TDeclaration TDeclaration;
	private TExpertTeacher TExpertTeacher;
	private String isdeleted;
	private Set TDeclComments = new HashSet(0);

	// Constructors

	/** default constructor */
	public TExpertReview() {
	}

	/** full constructor */
	public TExpertReview(TDeclaration TDeclaration,
			TExpertTeacher TExpertTeacher, String isdeleted, Set TDeclComments) {
		this.TDeclaration = TDeclaration;
		this.TExpertTeacher = TExpertTeacher;
		this.isdeleted = isdeleted;
		this.TDeclComments = TDeclComments;
	}

	// Property accessors

	public String getExReviewId() {
		return this.exReviewId;
	}

	public void setExReviewId(String exReviewId) {
		this.exReviewId = exReviewId;
	}

	public TDeclaration getTDeclaration() {
		return this.TDeclaration;
	}

	public void setTDeclaration(TDeclaration TDeclaration) {
		this.TDeclaration = TDeclaration;
	}

	public TExpertTeacher getTExpertTeacher() {
		return this.TExpertTeacher;
	}

	public void setTExpertTeacher(TExpertTeacher TExpertTeacher) {
		this.TExpertTeacher = TExpertTeacher;
	}

	public String getIsdeleted() {
		return this.isdeleted;
	}

	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}

	public Set getTDeclComments() {
		return this.TDeclComments;
	}

	public void setTDeclComments(Set TDeclComments) {
		this.TDeclComments = TDeclComments;
	}

}