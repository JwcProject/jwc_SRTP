package edu.cqu.no1.domain;// default package

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
 * TAnnouncementModel entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_announcement_model", catalog = "srtp")
public class TAnnouncementModel implements java.io.Serializable {

	// Fields

	private String announId;
	private TAnnounType TAnnounType;
	private String announTitle;
	private String announContent;
	private String publisherCode;
	private String publisherRole;
	private Timestamp publishTime;
	private String publishState;
	private String checkerCode;
	private Timestamp checkTime;
	private String checkState;
	private String isdeleted;
	private String publishername;

	// Constructors

	/** default constructor */
	public TAnnouncementModel() {
	}

	/** full constructor */
	public TAnnouncementModel(TAnnounType TAnnounType, String announTitle,
			String announContent, String publisherCode, String publisherRole,
			Timestamp publishTime, String publishState, String checkerCode,
			Timestamp checkTime, String checkState, String isdeleted,
			String publishername) {
		this.TAnnounType = TAnnounType;
		this.announTitle = announTitle;
		this.announContent = announContent;
		this.publisherCode = publisherCode;
		this.publisherRole = publisherRole;
		this.publishTime = publishTime;
		this.publishState = publishState;
		this.checkerCode = checkerCode;
		this.checkTime = checkTime;
		this.checkState = checkState;
		this.isdeleted = isdeleted;
		this.publishername = publishername;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "guid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "ANNOUN_ID", unique = true, nullable = false, length = 32)
	public String getAnnounId() {
		return this.announId;
	}

	public void setAnnounId(String announId) {
		this.announId = announId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ANNOUN_TYPE_ID")
	public TAnnounType getTAnnounType() {
		return this.TAnnounType;
	}

	public void setTAnnounType(TAnnounType TAnnounType) {
		this.TAnnounType = TAnnounType;
	}

	@Column(name = "ANNOUN_TITLE", length = 200)
	public String getAnnounTitle() {
		return this.announTitle;
	}

	public void setAnnounTitle(String announTitle) {
		this.announTitle = announTitle;
	}

	@Column(name = "ANNOUN_CONTENT", length = 4000)
	public String getAnnounContent() {
		return this.announContent;
	}

	public void setAnnounContent(String announContent) {
		this.announContent = announContent;
	}

	@Column(name = "PUBLISHER_CODE", length = 32)
	public String getPublisherCode() {
		return this.publisherCode;
	}

	public void setPublisherCode(String publisherCode) {
		this.publisherCode = publisherCode;
	}

	@Column(name = "PUBLISHER_ROLE", length = 32)
	public String getPublisherRole() {
		return this.publisherRole;
	}

	public void setPublisherRole(String publisherRole) {
		this.publisherRole = publisherRole;
	}

	@Column(name = "PUBLISH_TIME", length = 19)
	public Timestamp getPublishTime() {
		return this.publishTime;
	}

	public void setPublishTime(Timestamp publishTime) {
		this.publishTime = publishTime;
	}

	@Column(name = "PUBLISH_STATE", length = 2)
	public String getPublishState() {
		return this.publishState;
	}

	public void setPublishState(String publishState) {
		this.publishState = publishState;
	}

	@Column(name = "CHECKER_CODE", length = 32)
	public String getCheckerCode() {
		return this.checkerCode;
	}

	public void setCheckerCode(String checkerCode) {
		this.checkerCode = checkerCode;
	}

	@Column(name = "CHECK_TIME", length = 19)
	public Timestamp getCheckTime() {
		return this.checkTime;
	}

	public void setCheckTime(Timestamp checkTime) {
		this.checkTime = checkTime;
	}

	@Column(name = "CHECK_STATE", length = 2)
	public String getCheckState() {
		return this.checkState;
	}

	public void setCheckState(String checkState) {
		this.checkState = checkState;
	}

	@Column(name = "ISDELETED", length = 1)
	public String getIsdeleted() {
		return this.isdeleted;
	}

	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}

	@Column(name = "PUBLISHERNAME", length = 50)
	public String getPublishername() {
		return this.publishername;
	}

	public void setPublishername(String publishername) {
		this.publishername = publishername;
	}

}