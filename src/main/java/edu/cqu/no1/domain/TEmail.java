package edu.cqu.no1.domain;

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
import org.hibernate.annotations.GenericGenerator;

/**
 * TEmail entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_email", catalog = "srtp")
public class TEmail implements java.io.Serializable {

	// Fields

	private String emailId;
	private TJieqi TJieqi;
	private TTeacher TTeacher;
	private Timestamp creatOn;
	private String emailContent;
	private String emailSecret;
	private String emailTitle;
	private String isdeleted;
	private Timestamp sendOn;
	private String sendState;
	private String sender;
	private Set<TEmailReceiver> TEmailReceivers = new HashSet<TEmailReceiver>(0);

	// Constructors

	/** default constructor */
	public TEmail() {
	}

	/** full constructor */
	public TEmail(TJieqi TJieqi, TTeacher TTeacher, Timestamp creatOn,
			String emailContent, String emailSecret, String emailTitle,
			String isdeleted, Timestamp sendOn, String sendState,
			String sender, Set<TEmailReceiver> TEmailReceivers) {
		this.TJieqi = TJieqi;
		this.TTeacher = TTeacher;
		this.creatOn = creatOn;
		this.emailContent = emailContent;
		this.emailSecret = emailSecret;
		this.emailTitle = emailTitle;
		this.isdeleted = isdeleted;
		this.sendOn = sendOn;
		this.sendState = sendState;
		this.sender = sender;
		this.TEmailReceivers = TEmailReceivers;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "email_id", unique = true, nullable = false, length = 36)
	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "jq_id")
	public TJieqi getTJieqi() {
		return this.TJieqi;
	}

	public void setTJieqi(TJieqi TJieqi) {
		this.TJieqi = TJieqi;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tea_id")
	public TTeacher getTTeacher() {
		return this.TTeacher;
	}

	public void setTTeacher(TTeacher TTeacher) {
		this.TTeacher = TTeacher;
	}

	@Column(name = "creat_on", length = 19)
	public Timestamp getCreatOn() {
		return this.creatOn;
	}

	public void setCreatOn(Timestamp creatOn) {
		this.creatOn = creatOn;
	}

	@Column(name = "email_content", length = 1000)
	public String getEmailContent() {
		return this.emailContent;
	}

	public void setEmailContent(String emailContent) {
		this.emailContent = emailContent;
	}

	@Column(name = "email_secret", length = 20)
	public String getEmailSecret() {
		return this.emailSecret;
	}

	public void setEmailSecret(String emailSecret) {
		this.emailSecret = emailSecret;
	}

	@Column(name = "email_title", length = 200)
	public String getEmailTitle() {
		return this.emailTitle;
	}

	public void setEmailTitle(String emailTitle) {
		this.emailTitle = emailTitle;
	}

	@Column(name = "isdeleted", length = 1)
	public String getIsdeleted() {
		return this.isdeleted;
	}

	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}

	@Column(name = "send_on", length = 19)
	public Timestamp getSendOn() {
		return this.sendOn;
	}

	public void setSendOn(Timestamp sendOn) {
		this.sendOn = sendOn;
	}

	@Column(name = "send_state", length = 4)
	public String getSendState() {
		return this.sendState;
	}

	public void setSendState(String sendState) {
		this.sendState = sendState;
	}

	@Column(name = "sender", length = 100)
	public String getSender() {
		return this.sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TEmail")
	public Set<TEmailReceiver> getTEmailReceivers() {
		return this.TEmailReceivers;
	}

	public void setTEmailReceivers(Set<TEmailReceiver> TEmailReceivers) {
		this.TEmailReceivers = TEmailReceivers;
	}

}