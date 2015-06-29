package com.isse.model;

/**
 * TDeclFund entity. @author MyEclipse Persistence Tools
 */

public class TDeclFund implements java.io.Serializable {

	// Fields

	private String declFundId;
	private TDeclaration TDeclaration;
	private String serialNum;
	private String fundContent;
	private Double amount;
	private String isdeleted;

	// Constructors

	/** default constructor */
	public TDeclFund() {
	}

	/** full constructor */
	public TDeclFund(TDeclaration TDeclaration, String serialNum,
			String fundContent, Double amount, String isdeleted) {
		this.TDeclaration = TDeclaration;
		this.serialNum = serialNum;
		this.fundContent = fundContent;
		this.amount = amount;
		this.isdeleted = isdeleted;
	}

	// Property accessors

	public String getDeclFundId() {
		return this.declFundId;
	}

	public void setDeclFundId(String declFundId) {
		this.declFundId = declFundId;
	}

	public TDeclaration getTDeclaration() {
		return this.TDeclaration;
	}

	public void setTDeclaration(TDeclaration TDeclaration) {
		this.TDeclaration = TDeclaration;
	}

	public String getSerialNum() {
		return this.serialNum;
	}

	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
	}

	public String getFundContent() {
		return this.fundContent;
	}

	public void setFundContent(String fundContent) {
		this.fundContent = fundContent;
	}

	public Double getAmount() {
		return this.amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getIsdeleted() {
		return this.isdeleted;
	}

	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}

}