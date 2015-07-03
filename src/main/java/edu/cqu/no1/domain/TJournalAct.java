package edu.cqu.no1.domain;

import java.sql.Timestamp;
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
 * TJournalAct entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_journal_act", catalog = "srtp2")
public class TJournalAct implements java.io.Serializable {

	// Fields

	private String journalActId;
	private TJournal TJournal;
	private String isdeleted;
	private String journalActIntroduction;
	private String journalActRemark;
	private String journalActType;
	private Timestamp time;
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
	public TJournalAct(TJournal TJournal, String isdeleted,
			String journalActIntroduction, String journalActRemark,
			String journalActType, Timestamp time, String userId) {
		this.TJournal = TJournal;
		this.isdeleted = isdeleted;
		this.journalActIntroduction = journalActIntroduction;
		this.journalActRemark = journalActRemark;
		this.journalActType = journalActType;
		this.time = time;
		this.userId = userId;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "journalAct_id", unique = true, nullable = false, length = 36)
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

	@Column(name = "isdeleted", length = 1)
	public String getIsdeleted() {
		return this.isdeleted;
	}

	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}

	@Column(name = "journalAct_introduction", length = 100)
	public String getJournalActIntroduction() {
		return this.journalActIntroduction;
	}

	public void setJournalActIntroduction(String journalActIntroduction) {
		this.journalActIntroduction = journalActIntroduction;
	}

	@Column(name = "journalAct_remark", length = 100)
	public String getJournalActRemark() {
		return this.journalActRemark;
	}

	public void setJournalActRemark(String journalActRemark) {
		this.journalActRemark = journalActRemark;
	}

	@Column(name = "journalAct_type", length = 2)
	public String getJournalActType() {
		return this.journalActType;
	}

	public void setJournalActType(String journalActType) {
		this.journalActType = journalActType;
	}

	@Column(name = "time", nullable = false, length = 19)
	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	@Column(name = "user_id", length = 32)
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}