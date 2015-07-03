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
 * TDeclFund entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_decl_fund", catalog = "srtp2")
public class TDeclFund implements java.io.Serializable {

	// Fields

	private String declFundId;
	private TDeclaration TDeclaration;
	private Float amount;
	private String fundContent;
	private String isdeleted;
	private String serialNum;

	// Constructors

	/** default constructor */
	public TDeclFund() {
	}

	/** full constructor */
	public TDeclFund(TDeclaration TDeclaration, Float amount,
			String fundContent, String isdeleted, String serialNum) {
		this.TDeclaration = TDeclaration;
		this.amount = amount;
		this.fundContent = fundContent;
		this.isdeleted = isdeleted;
		this.serialNum = serialNum;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "decl_fund_id", unique = true, nullable = false, length = 36)
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

	@Column(name = "amount", precision = 12, scale = 0)
	public Float getAmount() {
		return this.amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

	@Column(name = "fund_content", length = 200)
	public String getFundContent() {
		return this.fundContent;
	}

	public void setFundContent(String fundContent) {
		this.fundContent = fundContent;
	}

	@Column(name = "isdeleted", length = 1)
	public String getIsdeleted() {
		return this.isdeleted;
	}

	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}

	@Column(name = "serial_num", length = 2)
	public String getSerialNum() {
		return this.serialNum;
	}

	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
	}

}