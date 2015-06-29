package com.isse.model;

import java.util.Date;

import org.apache.struts2.json.annotations.JSON;

/**
 * TAnnouncement entity. @author MyEclipse Persistence Tools
 */

public class TAnnouncementModel implements java.io.Serializable {

	// Fields

	private String announId;
	private TAnnounType TAnnounType;
	private String announTitle;
	private String announContent;
	private String publisherCode;
	private String publisherRole;
	private Date publishTime;
	private String publishState;
	private String checkerCode;
	private Date checkTime;
	private String checkState;
	private String isdeleted;
	private String publisherName;
	// Constructors

	/** default constructor */
	public TAnnouncementModel() {
	}
	
	/** full constructor */
	
	/**
	 * @param announId
	 * @param tAnnounType
	 * @param announTitle
	 * @param announContent
	 * @param publisherCode
	 * @param publisherRole
	 * @param publishTime
	 * @param publishState
	 * @param checkerCode
	 * @param checkTime
	 * @param checkState
	 * @param isdeleted
	 * @param publisherName
	 */
	public TAnnouncementModel(String announId,
			com.isse.model.TAnnounType tAnnounType, String announTitle,
			String announContent, String publisherCode, String publisherRole,
			Date publishTime, String publishState, String checkerCode,
			Date checkTime, String checkState, String isdeleted,
			String publisherName) {
		super();
		this.announId = announId;
		TAnnounType = tAnnounType;
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
		this.publisherName = publisherName;
	}

	public String getAnnounId() {
		return announId;
	}

	public void setAnnounId(String announId) {
		this.announId = announId;
	}
	@JSON(serialize=false)
	public TAnnounType getTAnnounType() {
		return TAnnounType;
	}

	public void setTAnnounType(TAnnounType tAnnounType) {
		TAnnounType = tAnnounType;
	}

	public String getAnnounTitle() {
		return announTitle;
	}

	public void setAnnounTitle(String announTitle) {
		this.announTitle = announTitle;
	}

	public String getAnnounContent() {
		return announContent;
	}

	public void setAnnounContent(String announContent) {
		this.announContent = announContent;
	}

	public String getPublisherCode() {
		return publisherCode;
	}

	public void setPublisherCode(String publisherCode) {
		this.publisherCode = publisherCode;
	}

	public String getPublisherRole() {
		return publisherRole;
	}

	public void setPublisherRole(String publisherRole) {
		this.publisherRole = publisherRole;
	}
	public Date getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	public String getPublishState() {
		return publishState;
	}

	public void setPublishState(String publishState) {
		this.publishState = publishState;
	}

	public String getCheckerCode() {
		return checkerCode;
	}

	public void setCheckerCode(String checkerCode) {
		this.checkerCode = checkerCode;
	}
	@JSON(serialize=false)
	public Date getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}

	public String getCheckState() {
		return checkState;
	}

	public void setCheckState(String checkState) {
		this.checkState = checkState;
	}

	public String getIsdeleted() {
		return isdeleted;
	}

	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	@Override
	public String toString() {
		return "TAnnouncementModel [announId=" + announId + ", TAnnounType="
				+ TAnnounType + ", announTitle=" + announTitle
				+ ", announContent=" + announContent + ", publisherCode="
				+ publisherCode + ", publisherRole=" + publisherRole
				+ ", publishTime=" + publishTime + ", publishState="
				+ publishState + ", checkerCode=" + checkerCode
				+ ", checkTime=" + checkTime + ", checkState=" + checkState
				+ ", isdeleted=" + isdeleted + ", publisherName="
				+ publisherName + "]";
	}
	
	
}