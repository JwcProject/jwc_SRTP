package edu.cqu.no1.domain;// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.GenericGenerator;

/**
 * TFunds entity. @author MyEclipse Persistence Tools
 */
@Entity
@DynamicInsert
@Table(name = "t_funds", catalog = "srtp")
public class TFunds implements java.io.Serializable {

	// Fields

	private String id;
	private TProject TProject;
	private String fundsId;
	private String fundsName;
	private String fundsIsReimburse;
	private Float fundsMoney;
	private String fundsDetail;
	private String fundsUse;
	private String isdeleted;

	// Constructors

	/** default constructor */
	public TFunds() {
	}

	/** full constructor */
	public TFunds(TProject TProject, String fundsId, String fundsName,
			String fundsIsReimburse, Float fundsMoney, String fundsDetail,
			String fundsUse, String isdeleted) {
		this.TProject = TProject;
		this.fundsId = fundsId;
		this.fundsName = fundsName;
		this.fundsIsReimburse = fundsIsReimburse;
		this.fundsMoney = fundsMoney;
		this.fundsDetail = fundsDetail;
		this.fundsUse = fundsUse;
		this.isdeleted = isdeleted;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "ID", unique = true, nullable = false, length = 32)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "project_id")
	public TProject getTProject() {
		return this.TProject;
	}

	public void setTProject(TProject TProject) {
		this.TProject = TProject;
	}

	@Column(name = "funds_id", length = 32)
	public String getFundsId() {
		return this.fundsId;
	}

	public void setFundsId(String fundsId) {
		this.fundsId = fundsId;
	}

	@Column(name = "funds_name", length = 50)
	public String getFundsName() {
		return this.fundsName;
	}

	public void setFundsName(String fundsName) {
		this.fundsName = fundsName;
	}

	@Column(name = "funds_isReimburse", length = 2)
	public String getFundsIsReimburse() {
		return this.fundsIsReimburse;
	}

	public void setFundsIsReimburse(String fundsIsReimburse) {
		this.fundsIsReimburse = fundsIsReimburse;
	}

	@Column(name = "funds_money", precision = 12, scale = 0)
	public Float getFundsMoney() {
		return this.fundsMoney;
	}

	public void setFundsMoney(Float fundsMoney) {
		this.fundsMoney = fundsMoney;
	}

	@Column(name = "funds_detail", length = 200)
	public String getFundsDetail() {
		return this.fundsDetail;
	}

	public void setFundsDetail(String fundsDetail) {
		this.fundsDetail = fundsDetail;
	}

	@Column(name = "funds_use", length = 200)
	public String getFundsUse() {
		return this.fundsUse;
	}

	public void setFundsUse(String fundsUse) {
		this.fundsUse = fundsUse;
	}

	@Column(name = "isdeleted", nullable = false, columnDefinition = "varchar(1) default 'N'")
	public String getIsdeleted() {
		return this.isdeleted;
	}

	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}

}