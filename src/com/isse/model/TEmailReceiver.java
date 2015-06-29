package com.isse.model;

/**
 * TEmailReceiver entity. @author MyEclipse Persistence Tools
 */

public class TEmailReceiver implements java.io.Serializable {

	// Fields

	private String receiverId;
	private TEmail TEmail;
	private String receiverCode;
	private String receiverRole;
	private String emailAddress;
	private String isReceived;
	private String isdeleted;

	// Constructors

	/** default constructor */
	public TEmailReceiver() {
	}

	/** full constructor */
	public TEmailReceiver(TEmail TEmail, String receiverCode,
			String receiverRole, String emailAddress, String isReceived,
			String isdeleted) {
		this.TEmail = TEmail;
		this.receiverCode = receiverCode;
		this.receiverRole = receiverRole;
		this.emailAddress = emailAddress;
		this.isReceived = isReceived;
		this.isdeleted = isdeleted;
	}

	// Property accessors

	public String getReceiverId() {
		return this.receiverId;
	}

	public void setReceiverId(String receiverId) {
		this.receiverId = receiverId;
	}

	public TEmail getTEmail() {
		return this.TEmail;
	}

	public void setTEmail(TEmail TEmail) {
		this.TEmail = TEmail;
	}

	public String getReceiverCode() {
		return this.receiverCode;
	}

	public void setReceiverCode(String receiverCode) {
		this.receiverCode = receiverCode;
	}

	public String getReceiverRole() {
		return this.receiverRole;
	}

	public void setReceiverRole(String receiverRole) {
		this.receiverRole = receiverRole;
	}

	public String getEmailAddress() {
		return this.emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getIsReceived() {
		return this.isReceived;
	}

	public void setIsReceived(String isReceived) {
		this.isReceived = isReceived;
	}

	public String getIsdeleted() {
		return this.isdeleted;
	}

	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}

}