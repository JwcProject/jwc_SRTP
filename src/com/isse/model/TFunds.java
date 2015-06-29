package com.isse.model;

/**
 * TFunds entity. @author MyEclipse Persistence Tools
 */

public class TFunds implements java.io.Serializable {

	// Fields

	private String id;
	private TProject TProject;
	private String fundsId;
	private String fundsName;
	private String fundsIsreimburse;
	private Double fundsMoney;
	private String fundsDetail;
	private String fundsUse;
	private String isdeleted;

	// Constructors

	/** default constructor */
	public TFunds() {
	}

	/** full constructor */
	public TFunds(TProject TProject, String fundsId, String fundsName,
			String fundsIsreimburse, Double fundsMoney, String fundsDetail,
			String fundsUse, String isdeleted) {
		this.TProject = TProject;
		this.fundsId = fundsId;
		this.fundsName = fundsName;
		this.fundsIsreimburse = fundsIsreimburse;
		this.fundsMoney = fundsMoney;
		this.fundsDetail = fundsDetail;
		this.fundsUse = fundsUse;
		this.isdeleted = isdeleted;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public TProject getTProject() {
		return this.TProject;
	}

	public void setTProject(TProject TProject) {
		this.TProject = TProject;
	}

	public String getFundsId() {
		return this.fundsId;
	}

	public void setFundsId(String fundsId) {
		this.fundsId = fundsId;
	}

	public String getFundsName() {
		return this.fundsName;
	}

	public void setFundsName(String fundsName) {
		this.fundsName = fundsName;
	}

	public String getFundsIsreimburse() {
		return this.fundsIsreimburse;
	}

	public void setFundsIsreimburse(String fundsIsreimburse) {
		this.fundsIsreimburse = fundsIsreimburse;
	}

	public Double getFundsMoney() {
		return this.fundsMoney;
	}

	public void setFundsMoney(Double fundsMoney) {
		this.fundsMoney = fundsMoney;
	}

	public String getFundsDetail() {
		return this.fundsDetail;
	}

	public void setFundsDetail(String fundsDetail) {
		this.fundsDetail = fundsDetail;
	}

	public String getFundsUse() {
		return this.fundsUse;
	}

	public void setFundsUse(String fundsUse) {
		this.fundsUse = fundsUse;
	}

	public String getIsdeleted() {
		return this.isdeleted;
	}

	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}

}