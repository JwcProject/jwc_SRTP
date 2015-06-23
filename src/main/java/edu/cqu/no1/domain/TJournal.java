package edu.cqu.no1.domain;// default package

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.GenericGenerator;

/**
 * TJournal entity. @author MyEclipse Persistence Tools
 */
@Entity
@DynamicInsert
@Table(name = "t_journal", catalog = "srtp")
public class TJournal implements java.io.Serializable {

	// Fields
	private String journalId;
	private TUser TUser;
	private String userName;
	private Timestamp journalLogintime;
	private Timestamp journalQuitime;
	private String journalRemark;
	private String isdeleted;
	private String journalLoginIp;
	private Set<TJournalAct> TJournalActs = new HashSet<TJournalAct>(0);

	// Constructors

	/** default constructor */
	public TJournal() {
	}

	/** full constructor */
	public TJournal(TUser TUser, String userName, Timestamp journalLogintime,
			Timestamp journalQuitime, String journalRemark, String isdeleted,
			String journalLoginIp, Set<TJournalAct> TJournalActs) {
		this.TUser = TUser;
		this.userName = userName;
		this.journalLogintime = journalLogintime;
		this.journalQuitime = journalQuitime;
		this.journalRemark = journalRemark;
		this.isdeleted = isdeleted;
		this.journalLoginIp = journalLoginIp;
		this.TJournalActs = TJournalActs;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "journal_id", unique = true, nullable = false, length = 32)
	public String getJournalId() {
		return this.journalId;
	}

	public void setJournalId(String journalId) {
		this.journalId = journalId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	public TUser getTUser() {
		return this.TUser;
	}

	public void setTUser(TUser TUser) {
		this.TUser = TUser;
	}

	@Column(name = "user_name", length = 100)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "journal_logintime", length = 19)
	public Timestamp getJournalLogintime() {
		return this.journalLogintime;
	}

	public void setJournalLogintime(Timestamp journalLogintime) {
		this.journalLogintime = journalLogintime;
	}

	@Column(name = "journal_quitime", length = 19)
	public Timestamp getJournalQuitime() {
		return this.journalQuitime;
	}

	public void setJournalQuitime(Timestamp journalQuitime) {
		this.journalQuitime = journalQuitime;
	}

	@Column(name = "journal_remark", length = 100)
	public String getJournalRemark() {
		return this.journalRemark;
	}

	public void setJournalRemark(String journalRemark) {
		this.journalRemark = journalRemark;
	}

	@Column(name = "isdeleted", nullable = false, columnDefinition = "varchar(1) default 'N'")
	public String getIsdeleted() {
		return this.isdeleted;
	}

	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}

	@Column(name = "journal_loginIp", length = 50)
	public String getJournalLoginIp() {
		return this.journalLoginIp;
	}

	public void setJournalLoginIp(String journalLoginIp) {
		this.journalLoginIp = journalLoginIp;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TJournal")
	public Set<TJournalAct> getTJournalActs() {
		return this.TJournalActs;
	}

	public void setTJournalActs(Set<TJournalAct> TJournalActs) {
		this.TJournalActs = TJournalActs;
	}

}