package com.isse.model;

/**
 * TDeclJob entity. @author MyEclipse Persistence Tools
 */

public class TDeclJob implements java.io.Serializable {

	// Fields

	private String jobId;
	private TStudent TStudent;
	private TDeclaration TDeclaration;
	private String jobContent;
	private String isdeleted;

	// Constructors

	/** default constructor */
	public TDeclJob() {
	}

	/** full constructor */
	public TDeclJob(TStudent TStudent, TDeclaration TDeclaration,
			String jobContent, String isdeleted) {
		this.TStudent = TStudent;
		this.TDeclaration = TDeclaration;
		this.jobContent = jobContent;
		this.isdeleted = isdeleted;
	}

	// Property accessors

	public String getJobId() {
		return this.jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public TStudent getTStudent() {
		return this.TStudent;
	}

	public void setTStudent(TStudent TStudent) {
		this.TStudent = TStudent;
	}

	public TDeclaration getTDeclaration() {
		return this.TDeclaration;
	}

	public void setTDeclaration(TDeclaration TDeclaration) {
		this.TDeclaration = TDeclaration;
	}

	public String getJobContent() {
		return this.jobContent;
	}

	public void setJobContent(String jobContent) {
		this.jobContent = jobContent;
	}

	public String getIsdeleted() {
		return this.isdeleted;
	}

	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}

}