package com.isse.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * TJournal entity. @author MyEclipse Persistence Tools
 */

public class TJournal implements java.io.Serializable {

	// Fields

	private String journalId;
	private TUser TUser;
	private String userName;
	private Date journalLogintime;
	private Date journalQuitime;
	private String journalRemark;
	private String isdeleted;
	private String journalLoginip;
	private Set TJournalActs = new HashSet(0);

	// Constructors

	/** default constructor */
	public TJournal() {
	}

	/** full constructor */
	public TJournal(TUser TUser, String userName, Date journalLogintime,
			Date journalQuitime, String journalRemark, String isdeleted,
			String journalLoginip, Set TJournalActs) {
		this.TUser = TUser;
		this.userName = userName;
		this.journalLogintime = journalLogintime;
		this.journalQuitime = journalQuitime;
		this.journalRemark = journalRemark;
		this.isdeleted = isdeleted;
		this.journalLoginip = journalLoginip;
		this.TJournalActs = TJournalActs;
	}

	// Property accessors

	public String getJournalId() {
		return this.journalId;
	}

	public void setJournalId(String journalId) {
		this.journalId = journalId;
	}

	public TUser getTUser() {
		return this.TUser;
	}

	public void setTUser(TUser TUser) {
		this.TUser = TUser;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getJournalLogintime() {
		return this.journalLogintime;
	}

	public void setJournalLogintime(Date journalLogintime) {
		this.journalLogintime = journalLogintime;
	}

	public Date getJournalQuitime() {
		return this.journalQuitime;
	}

	public void setJournalQuitime(Date journalQuitime) {
		this.journalQuitime = journalQuitime;
	}

	public String getJournalRemark() {
		return this.journalRemark;
	}

	public void setJournalRemark(String journalRemark) {
		this.journalRemark = journalRemark;
	}

	public String getIsdeleted() {
		return this.isdeleted;
	}

	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}

	public String getJournalLoginip() {
		return this.journalLoginip;
	}

	public void setJournalLoginip(String journalLoginip) {
		this.journalLoginip = journalLoginip;
	}

	public Set getTJournalActs() {
		return this.TJournalActs;
	}

	public void setTJournalActs(Set TJournalActs) {
		this.TJournalActs = TJournalActs;
	}

}