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
 * TDeclFund entity. @author MyEclipse Persistence Tools
 */
@Entity
@DynamicInsert
@Table(name = "t_decl_fund", catalog = "srtp")
public class TDeclFund implements java.io.Serializable {

	// Fields

	private String declFundId;
	private TDeclaration TDeclaration;
	private String serialNum;
	private String fundContent;
	private Float amount;
	private String isdeleted;

	// Constructors

	/** default constructor */
	public TDeclFund() {
	}

	/** full constructor */
	public TDeclFund(TDeclaration TDeclaration, String serialNum,
			String fundContent, Float amount, String isdeleted) {
		this.TDeclaration = TDeclaration;
		this.serialNum = serialNum;
		this.fundContent = fundContent;
		this.amount = amount;
		this.isdeleted = isdeleted;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "decl_fund_id", unique = true, nullable = false, length = 32)
	public String getDeclFundId() {
		return this.declFundId;
	}

	public void setDeclFundId(String declFundId) {
		this.declFundId = declFundId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "declar_id")
	public TDeclaration getTDeclaration() {
		return this.TDeclaration;
	}

	public void setTDeclaration(TDeclaration TDeclaration) {
		this.TDeclaration = TDeclaration;
	}

	@Column(name = "serial_num", length = 2)
	public String getSerialNum() {
		return this.serialNum;
	}

	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
	}

	@Column(name = "fund_content", length = 200)
	public String getFundContent() {
		return this.fundContent;
	}

	public void setFundContent(String fundContent) {
		this.fundContent = fundContent;
	}

	@Column(name = "amount", precision = 12, scale = 0)
	public Float getAmount() {
		return this.amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	@Column(name = "isdeleted", nullable = false, columnDefinition = "varchar(1) default 'N'")
	public String getIsdeleted() {
		return this.isdeleted;
	}

	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}

}