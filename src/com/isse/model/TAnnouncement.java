package com.isse.model;

import java.util.Date;

/**
 * TAnnouncement entity. @author MyEclipse Persistence Tools
 */

public class TAnnouncement implements java.io.Serializable {

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

	// Constructors

	/** default constructor */
	public TAnnouncement() {
	}

	/** full constructor */
	public TAnnouncement(TAnnounType TAnnounType, String announTitle,
			String announContent, String publisherCode, String publisherRole,
			Date publishTime, String publishState, String checkerCode,
			Date checkTime, String checkState, String isdeleted) {
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
	}

	// Property accessors

	public String getAnnounId() {
		return this.announId;
	}

	public void setAnnounId(String announId) {
		this.announId = announId;
	}

	public TAnnounType getTAnnounType() {
		return this.TAnnounType;
	}

	public void setTAnnounType(TAnnounType TAnnounType) {
		this.TAnnounType = TAnnounType;
	}

	public String getAnnounTitle() {
		return this.announTitle;
	}

	public void setAnnounTitle(String announTitle) {
		this.announTitle = announTitle;
	}

	public String getAnnounContent() {
		return this.announContent;
	}

	public void setAnnounContent(String announContent) {
		this.announContent = announContent;
	}

	public String getPublisherCode() {
		return this.publisherCode;
	}

	public void setPublisherCode(String publisherCode) {
		this.publisherCode = publisherCode;
	}

	public String getPublisherRole() {
		return this.publisherRole;
	}

	public void setPublisherRole(String publisherRole) {
		this.publisherRole = publisherRole;
	}

	public Date getPublishTime() {
		return this.publishTime;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	public String getPublishState() {
		return this.publishState;
	}

	public void setPublishState(String publishState) {
		this.publishState = publishState;
	}

	public String getCheckerCode() {
		return this.checkerCode;
	}

	public void setCheckerCode(String checkerCode) {
		this.checkerCode = checkerCode;
	}

	public Date getCheckTime() {
		return this.checkTime;
	}

	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}

	public String getCheckState() {
		return this.checkState;
	}

	public void setCheckState(String checkState) {
		this.checkState = checkState;
	}

	public String getIsdeleted() {
		return this.isdeleted;
	}

	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}

}