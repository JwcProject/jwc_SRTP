package com.isse.model;

import java.util.Date;
/**
 * TJournalAct entity. @author MyEclipse Persistence Tools
 */

public class TJournalAct implements java.io.Serializable {

	// Fields

	private String journalactId;
	private TJournal TJournal;
	private String journalactType;
	private String journalactIntroduction;
	private Date time;
	private String journalactRemark;
	private String isdeleted;
	private String userId;

	// Constructors

	/** default constructor */
	public TJournalAct() {
	}

	/** full constructor */
	public TJournalAct(TJournal TJournal, String journalactType,
			String journalactIntroduction, Date time,
			String journalactRemark, String isdeleted, String userId) {
		this.TJournal = TJournal;
		this.journalactType = journalactType;
		this.journalactIntroduction = journalactIntroduction;
		this.time = time;
		this.journalactRemark = journalactRemark;
		this.isdeleted = isdeleted;
		this.userId = userId;
	}

	// Property accessors

	public String getJournalactId() {
		return this.journalactId;
	}

	public void setJournalactId(String journalactId) {
		this.journalactId = journalactId;
	}

	public TJournal getTJournal() {
		return this.TJournal;
	}

	public void setTJournal(TJournal TJournal) {
		this.TJournal = TJournal;
	}

	public String getJournalactType() {
		return this.journalactType;
	}

	public void setJournalactType(String journalactType) {
		this.journalactType = journalactType;
	}

	public String getJournalactIntroduction() {
		return this.journalactIntroduction;
	}

	public void setJournalactIntroduction(String journalactIntroduction) {
		this.journalactIntroduction = journalactIntroduction;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getJournalactRemark() {
		return this.journalactRemark;
	}

	public void setJournalactRemark(String journalactRemark) {
		this.journalactRemark = journalactRemark;
	}

	public String getIsdeleted() {
		return this.isdeleted;
	}

	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}