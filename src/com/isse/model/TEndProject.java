package com.isse.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.apache.struts2.json.annotations.JSON;

/**
 * TEndProject entity. @author MyEclipse Persistence Tools
 */

public class TEndProject implements java.io.Serializable {

	// Fields

	private String endprojectId;
	private TJieqi TJieqi;
	private TProject TProject;
	private TUnit TUnit;
	private String endprojectState;
	private String endprojectSummary;
	private String endprojectMethod;
	private String endprojectScore;
	private String lastScore;
	private String endprojectNumber;
	private String lastComment;
	private String endprojectComment;
	private String endprojectName;
	private String endprojectSense;
	private String endprojectContent;
	private Double endprojectCredit;
	private String endprojectProblem;
	private String endprojectInnovate;
	private String endprojectIntroduction;
	private String endprojectWork;
	private String isdeleted;
	private String endprojectPassapply;
	private Date submitTime;
	private Date unitTypeinTime;
	private Date schoolTypeinTime;
	private Set TEndProjectExports = new HashSet(0);
	private Set TEndprojectJobs = new HashSet(0);

	// Constructors

	/** default constructor */
	public TEndProject() {
	}

	/** full constructor */
	public TEndProject(TJieqi TJieqi, TProject TProject,TUnit TUnit,
			String endprojectState, String endprojectSummary,
			String endprojectMethod, String endprojectScore, String lastScore,
			String endprojectNumber, String lastComment,
			String endprojectComment, String endprojectName,
			String endprojectSense, String endprojectContent,
			Double endprojectCredit, String endprojectProblem,
			String endprojectInnovate, String endprojectIntroduction,
			String endprojectWork, String isdeleted,
			String endprojectPassapply, Date submitTime, Date unitTypeinTime,
			Date schoolTypeinTime, Set TEndProjectExports, Set TEndprojectJobs) {
		this.TJieqi = TJieqi;
		this.TProject = TProject;
		this.TUnit = TUnit;
		this.endprojectState = endprojectState;
		this.endprojectSummary = endprojectSummary;
		this.endprojectMethod = endprojectMethod;
		this.endprojectScore = endprojectScore;
		this.lastScore = lastScore;
		this.endprojectNumber = endprojectNumber;
		this.lastComment = lastComment;
		this.endprojectComment = endprojectComment;
		this.endprojectName = endprojectName;
		this.endprojectSense = endprojectSense;
		this.endprojectContent = endprojectContent;
		this.endprojectCredit = endprojectCredit;
		this.endprojectProblem = endprojectProblem;
		this.endprojectInnovate = endprojectInnovate;
		this.endprojectIntroduction = endprojectIntroduction;
		this.endprojectWork = endprojectWork;
		this.isdeleted = isdeleted;
		this.endprojectPassapply = endprojectPassapply;
		this.submitTime = submitTime;
		this.unitTypeinTime = unitTypeinTime;
		this.schoolTypeinTime = schoolTypeinTime;
		this.TEndProjectExports = TEndProjectExports;
		this.TEndprojectJobs = TEndprojectJobs;
	}

	// Property accessors

	public String getEndprojectId() {
		return this.endprojectId;
	}

	public void setEndprojectId(String endprojectId) {
		this.endprojectId = endprojectId;
	}

	public TJieqi getTJieqi() {
		return this.TJieqi;
	}

	public void setTJieqi(TJieqi TJieqi) {
		this.TJieqi = TJieqi;
	}

	public TProject getTProject() {
		return this.TProject;
	}

	public void setTProject(TProject TProject) {
		this.TProject = TProject;
	}

	public TUnit getTUnit() {
		return TUnit;
	}

	public void setTUnit(TUnit tUnit) {
		TUnit = tUnit;
	}

	public String getEndprojectState() {
		return this.endprojectState;
	}

	public void setEndprojectState(String endprojectState) {
		this.endprojectState = endprojectState;
	}

	public String getEndprojectSummary() {
		return this.endprojectSummary;
	}

	public void setEndprojectSummary(String endprojectSummary) {
		this.endprojectSummary = endprojectSummary;
	}

	public String getEndprojectMethod() {
		return this.endprojectMethod;
	}

	public void setEndprojectMethod(String endprojectMethod) {
		this.endprojectMethod = endprojectMethod;
	}

	public String getEndprojectScore() {
		return this.endprojectScore;
	}

	public void setEndprojectScore(String endprojectScore) {
		this.endprojectScore = endprojectScore;
	}

	public String getLastScore() {
		return this.lastScore;
	}

	public void setLastScore(String lastScore) {
		this.lastScore = lastScore;
	}

	public String getEndprojectNumber() {
		return this.endprojectNumber;
	}

	public void setEndprojectNumber(String endprojectNumber) {
		this.endprojectNumber = endprojectNumber;
	}

	public String getLastComment() {
		return this.lastComment;
	}

	public void setLastComment(String lastComment) {
		this.lastComment = lastComment;
	}

	public String getEndprojectComment() {
		return this.endprojectComment;
	}

	public void setEndprojectComment(String endprojectComment) {
		this.endprojectComment = endprojectComment;
	}

	public String getEndprojectName() {
		return this.endprojectName;
	}

	public void setEndprojectName(String endprojectName) {
		this.endprojectName = endprojectName;
	}

	public String getEndprojectSense() {
		return this.endprojectSense;
	}

	public void setEndprojectSense(String endprojectSense) {
		this.endprojectSense = endprojectSense;
	}

	public String getEndprojectContent() {
		return this.endprojectContent;
	}

	public void setEndprojectContent(String endprojectContent) {
		this.endprojectContent = endprojectContent;
	}

	public Double getEndprojectCredit() {
		return this.endprojectCredit;
	}

	public void setEndprojectCredit(Double endprojectCredit) {
		this.endprojectCredit = endprojectCredit;
	}

	public String getEndprojectProblem() {
		return this.endprojectProblem;
	}

	public void setEndprojectProblem(String endprojectProblem) {
		this.endprojectProblem = endprojectProblem;
	}

	public String getEndprojectInnovate() {
		return this.endprojectInnovate;
	}

	public void setEndprojectInnovate(String endprojectInnovate) {
		this.endprojectInnovate = endprojectInnovate;
	}

	public String getEndprojectIntroduction() {
		return this.endprojectIntroduction;
	}

	public void setEndprojectIntroduction(String endprojectIntroduction) {
		this.endprojectIntroduction = endprojectIntroduction;
	}

	public String getEndprojectWork() {
		return this.endprojectWork;
	}

	public void setEndprojectWork(String endprojectWork) {
		this.endprojectWork = endprojectWork;
	}

	public String getIsdeleted() {
		return this.isdeleted;
	}

	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}

	public String getEndprojectPassapply() {
		return this.endprojectPassapply;
	}

	public void setEndprojectPassapply(String endprojectPassapply) {
		this.endprojectPassapply = endprojectPassapply;
	}

	public Date getSubmitTime() {
		return this.submitTime;
	}

	public void setSubmitTime(Date submitTime) {
		this.submitTime = submitTime;
	}

	public Date getUnitTypeinTime() {
		return this.unitTypeinTime;
	}

	public void setUnitTypeinTime(Date unitTypeinTime) {
		this.unitTypeinTime = unitTypeinTime;
	}

	public Date getSchoolTypeinTime() {
		return this.schoolTypeinTime;
	}

	public void setSchoolTypeinTime(Date schoolTypeinTime) {
		this.schoolTypeinTime = schoolTypeinTime;
	}
	@JSON(serialize=false)
	public Set getTEndProjectExports() {
		return this.TEndProjectExports;
	}

	public void setTEndProjectExports(Set TEndProjectExports) {
		this.TEndProjectExports = TEndProjectExports;
	}
	@JSON(serialize=false)
	public Set getTEndprojectJobs() {
		return this.TEndprojectJobs;
	}

	public void setTEndprojectJobs(Set TEndprojectJobs) {
		this.TEndprojectJobs = TEndprojectJobs;
	}

}