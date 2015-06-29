// default package

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
	private String emailTitle;
	private String emailContent;
	private String sender;
	private String emailSecret;
	private Timestamp creatOn;
	private String sendState;
	private Timestamp sendOn;
	private String isdeleted;
	private Set<TEmailReceiver> TEmailReceivers = new HashSet<TEmailReceiver>(0);

	// Constructors

	/** default constructor */
	public TEmail() {
	}

	/** full constructor */
	public TEmail(TJieqi TJieqi, TTeacher TTeacher, String emailTitle,
			String emailContent, String sender, String emailSecret,
			Timestamp creatOn, String sendState, Timestamp sendOn,
			String isdeleted, Set<TEmailReceiver> TEmailReceivers) {
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
	@GenericGenerator(name = "generator", strategy = "guid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "email_id", unique = true, nullable = false, length = 32)
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

	@Column(name = "email_title", length = 200)
	public String getEmailTitle() {
		return this.emailTitle;
	}

	public void setEmailTitle(String emailTitle) {
		this.emailTitle = emailTitle;
	}

	@Column(name = "email_content", length = 1000)
	public String getEmailContent() {
		return this.emailContent;
	}

	public void setEmailContent(String emailContent) {
		this.emailContent = emailContent;
	}

	@Column(name = "sender", length = 100)
	public String getSender() {
		return this.sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	@Column(name = "email_secret", length = 20)
	public String getEmailSecret() {
		return this.emailSecret;
	}

	public void setEmailSecret(String emailSecret) {
		this.emailSecret = emailSecret;
	}

	@Column(name = "creat_on", length = 19)
	public Timestamp getCreatOn() {
		return this.creatOn;
	}

	public void setCreatOn(Timestamp creatOn) {
		this.creatOn = creatOn;
	}

	@Column(name = "send_state", length = 2)
	public String getSendState() {
		return this.sendState;
	}

	public void setSendState(String sendState) {
		this.sendState = sendState;
	}

	@Column(name = "send_on", length = 19)
	public Timestamp getSendOn() {
		return this.sendOn;
	}

	public void setSendOn(Timestamp sendOn) {
		this.sendOn = sendOn;
	}

	@Column(name = "isdeleted", length = 1)
	public String getIsdeleted() {
		return this.isdeleted;
	}

	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TEmail")
	public Set<TEmailReceiver> getTEmailReceivers() {
		return this.TEmailReceivers;
	}

	public void setTEmailReceivers(Set<TEmailReceiver> TEmailReceivers) {
		this.TEmailReceivers = TEmailReceivers;
	}

}