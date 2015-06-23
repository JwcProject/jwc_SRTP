package edu.cqu.no1.domain;// default package

import java.sql.Timestamp;
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
 * TJournalAct entity. @author MyEclipse Persistence Tools
 */
@Entity
@DynamicInsert
@Table(name = "t_journal_act", catalog = "srtp")
public class TJournalAct implements java.io.Serializable {

	// Fields

	private String journalActId;
	private TJournal TJournal;
	private String journalActType;
	private String journalActIntroduction;
	private Timestamp time;
	private String journalActRemark;
	private String isdeleted;
	private String userId;

	// Constructors

	/** default constructor */
	public TJournalAct() {
	}

	/** minimal constructor */
	public TJournalAct(Timestamp time) {
		this.time = time;
	}

	/** full constructor */
	public TJournalAct(TJournal TJournal, String journalActType,
			String journalActIntroduction, Timestamp time,
			String journalActRemark, String isdeleted, String userId) {
		this.TJournal = TJournal;
		this.journalActType = journalActType;
		this.journalActIntroduction = journalActIntroduction;
		this.time = time;
		this.journalActRemark = journalActRemark;
		this.isdeleted = isdeleted;
		this.userId = userId;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "journalAct_id", unique = true, nullable = false, length = 32)
	public String getJournalActId() {
		return this.journalActId;
	}

	public void setJournalActId(String journalActId) {
		this.journalActId = journalActId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "journal_id")
	public TJournal getTJournal() {
		return this.TJournal;
	}

	public void setTJournal(TJournal TJournal) {
		this.TJournal = TJournal;
	}

	@Column(name = "journalAct_type", length = 2)
	public String getJournalActType() {
		return this.journalActType;
	}

	public void setJournalActType(String journalActType) {
		this.journalActType = journalActType;
	}

	@Column(name = "journalAct_introduction", length = 100)
	public String getJournalActIntroduction() {
		return this.journalActIntroduction;
	}

	public void setJournalActIntroduction(String journalActIntroduction) {
		this.journalActIntroduction = journalActIntroduction;
	}

	@Column(name = "time", nullable = false, length = 19)
	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	@Column(name = "journalAct_remark", length = 100)
	public String getJournalActRemark() {
		return this.journalActRemark;
	}

	public void setJournalActRemark(String journalActRemark) {
		this.journalActRemark = journalActRemark;
	}

	@Column(name = "isdeleted", columnDefinition = "varchar(1) default 'N'")
	public String getIsdeleted() {
		return this.isdeleted;
	}

	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}

	@Column(name = "user_id", length = 32)
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}