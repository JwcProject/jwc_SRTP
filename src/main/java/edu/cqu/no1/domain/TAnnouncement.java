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
 * TAnnouncement entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_announcement", catalog = "srtp2")
public class TAnnouncement implements java.io.Serializable {

	// Fields

	private String announId;
	private TAnnounType TAnnounType;
	private String announContent;
	private String announTitle;
	private String checkState;
	private Timestamp checkTime;
	private String checkerCode;
	private String isdeleted;
	private String publishState;
	private Timestamp publishTime;
	private String publisherCode;
	private String publisherRole;
	private String publisherName;

	// Constructors

	/** default constructor */
	public TAnnouncement() {
	}

	/** full constructor */
	public TAnnouncement(TAnnounType TAnnounType, String announContent,
			String announTitle, String checkState, Timestamp checkTime,
			String checkerCode, String isdeleted, String publishState,
			Timestamp publishTime, String publisherCode, String publisherRole,
			String publisherName) {
		this.TAnnounType = TAnnounType;
		this.announContent = announContent;
		this.announTitle = announTitle;
		this.checkState = checkState;
		this.checkTime = checkTime;
		this.checkerCode = checkerCode;
		this.isdeleted = isdeleted;
		this.publishState = publishState;
		this.publishTime = publishTime;
		this.publisherCode = publisherCode;
		this.publisherRole = publisherRole;
		this.publisherName = publisherName;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "announ_id", unique = true, nullable = false, length = 36)
	public String getAnnounId() {
		return this.announId;
	}

	public void setAnnounId(String announId) {
		this.announId = announId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "announ_type_id")
	public TAnnounType getTAnnounType() {
		return this.TAnnounType;
	}

	public void setTAnnounType(TAnnounType TAnnounType) {
		this.TAnnounType = TAnnounType;
	}

	@Column(name = "announ_content", length = 4000)
	public String getAnnounContent() {
		return this.announContent;
	}

	public void setAnnounContent(String announContent) {
		this.announContent = announContent;
	}

	@Column(name = "announ_title", length = 200)
	public String getAnnounTitle() {
		return this.announTitle;
	}

	public void setAnnounTitle(String announTitle) {
		this.announTitle = announTitle;
	}

	@Column(name = "check_state", length = 2)
	public String getCheckState() {
		return this.checkState;
	}

	public void setCheckState(String checkState) {
		this.checkState = checkState;
	}

	@Column(name = "check_time", length = 19)
	public Timestamp getCheckTime() {
		return this.checkTime;
	}

	public void setCheckTime(Timestamp checkTime) {
		this.checkTime = checkTime;
	}

	@Column(name = "checker_code", length = 32)
	public String getCheckerCode() {
		return this.checkerCode;
	}

	public void setCheckerCode(String checkerCode) {
		this.checkerCode = checkerCode;
	}

	@Column(name = "isdeleted", length = 1)
	public String getIsdeleted() {
		return this.isdeleted;
	}

	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}

	@Column(name = "publish_state", length = 2)
	public String getPublishState() {
		return this.publishState;
	}

	public void setPublishState(String publishState) {
		this.publishState = publishState;
	}

	@Column(name = "publish_time", length = 19)
	public Timestamp getPublishTime() {
		return this.publishTime;
	}

	public void setPublishTime(Timestamp publishTime) {
		this.publishTime = publishTime;
	}

	@Column(name = "publisher_code", length = 32)
	public String getPublisherCode() {
		return this.publisherCode;
	}

	public void setPublisherCode(String publisherCode) {
		this.publisherCode = publisherCode;
	}

	@Column(name = "publisher_role", length = 32)
	public String getPublisherRole() {
		return this.publisherRole;
	}

	public void setPublisherRole(String publisherRole) {
		this.publisherRole = publisherRole;
	}

	@Column(name = "publisher_name", length = 32)
	public String getPublisherName() {
		return this.publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

}