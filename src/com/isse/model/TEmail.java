package com.isse.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * TEmail entity. @author MyEclipse Persistence Tools
 */

public class TEmail implements java.io.Serializable {

	// Fields

	private String emailId;
	private TJieqi TJieqi;
	private TTeacher TTeacher;
	private String emailTitle;
	private String emailContent;
	private String sender;
	private String emailSecret;
	private Date creatOn;
	private String sendState;
	private Date sendOn;
	private String isdeleted;
	private Set TEmailReceivers = new HashSet(0);

	// Constructors

	/** default constructor */
	public TEmail() {
	}

	/** full constructor */
	public TEmail(TJieqi TJieqi, TTeacher TTeacher, String emailTitle,
			String emailContent, String sender, String emailSecret,
			Date creatOn, String sendState, Date sendOn, String isdeleted,
			Set TEmailReceivers) {
		this.TJieqi = TJieqi;
		this.TTeacher = TTeacher;
		this.emailTitle = emailTitle;
		this.emailContent = emailContent;
		this.sender = sender;
		this.emailSecret = emailSecret;
		this.creatOn = creatOn;
		this.sendState = sendState;
		this.sendOn = sendOn;
		this.isdeleted = isdeleted;
		this.TEmailReceivers = TEmailReceivers;
	}

	// Property accessors

	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public TJieqi getTJieqi() {
		return this.TJieqi;
	}

	public void setTJieqi(TJieqi TJieqi) {
		this.TJieqi = TJieqi;
	}

	public TTeacher getTTeacher() {
		return this.TTeacher;
	}

	public void setTTeacher(TTeacher TTeacher) {
		this.TTeacher = TTeacher;
	}

	public String getEmailTitle() {
		return this.emailTitle;
	}

	public void setEmailTitle(String emailTitle) {
		this.emailTitle = emailTitle;
	}

	public String getEmailContent() {
		return this.emailContent;
	}

	public void setEmailContent(String emailContent) {
		this.emailContent = emailContent;
	}

	public String getSender() {
		return this.sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getEmailSecret() {
		return this.emailSecret;
	}

	public void setEmailSecret(String emailSecret) {
		this.emailSecret = emailSecret;
	}

	public Date getCreatOn() {
		return this.creatOn;
	}

	public void setCreatOn(Date creatOn) {
		this.creatOn = creatOn;
	}

	public String getSendState() {
		return this.sendState;
	}

	public void setSendState(String sendState) {
		this.sendState = sendState;
	}

	public Date getSendOn() {
		return this.sendOn;
	}

	public void setSendOn(Date sendOn) {
		this.sendOn = sendOn;
	}

	public String getIsdeleted() {
		return this.isdeleted;
	}

	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}

	public Set getTEmailReceivers() {
		return this.TEmailReceivers;
	}

	public void setTEmailReceivers(Set TEmailReceivers) {
		this.TEmailReceivers = TEmailReceivers;
	}

}