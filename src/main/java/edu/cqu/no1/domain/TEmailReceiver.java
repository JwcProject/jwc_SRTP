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
 * TEmailReceiver entity. @author MyEclipse Persistence Tools
 */
@Entity
@DynamicInsert
@Table(name = "t_email_receiver", catalog = "srtp")
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
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "receiver_id", unique = true, nullable = false, length = 32)
	public String getReceiverId() {
		return this.receiverId;
	}

	public void setReceiverId(String receiverId) {
		this.receiverId = receiverId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "email_id")
	public TEmail getTEmail() {
		return this.TEmail;
	}

	public void setTEmail(TEmail TEmail) {
		this.TEmail = TEmail;
	}

	@Column(name = "receiver_code", length = 32)
	public String getReceiverCode() {
		return this.receiverCode;
	}

	public void setReceiverCode(String receiverCode) {
		this.receiverCode = receiverCode;
	}

	@Column(name = "receiver_role", length = 20)
	public String getReceiverRole() {
		return this.receiverRole;
	}

	public void setReceiverRole(String receiverRole) {
		this.receiverRole = receiverRole;
	}

	@Column(name = "email_address", length = 100)
	public String getEmailAddress() {
		return this.emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	@Column(name = "is_received", length = 2)
	public String getIsReceived() {
		return this.isReceived;
	}

	public void setIsReceived(String isReceived) {
		this.isReceived = isReceived;
	}

	@Column(name = "isdeleted", columnDefinition = "varchar(1) default 'N'")
	public String getIsdeleted() {
		return this.isdeleted;
	}

	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}

}