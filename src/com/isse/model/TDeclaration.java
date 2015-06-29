package com.isse.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.management.loading.PrivateClassLoader;

/**
 * TDeclaration entity. @author MyEclipse Persistence Tools
 */

public class TDeclaration implements java.io.Serializable {

	// Fields

	private String declarId;
	private TJieqi TJieqi;
	private TTeacher TTeacherByTeacher2Code;
	private TTeacher TTeacherByTeacher1Code;
	private TStudent TStudentByMember2Code;
	private TStudent TStudentByMember1Code;
	private TUnit TUnit;
	private TStudent TStudentByLeaderCode;
	private String proSerial;
	private String proName;
	private String labLevel;
	private String labName;
	private BigDecimal memberAmount;
	private Date startOn;
	private Date endOn;
	private Date declTime;
	private String checkState;
	private String proIntro;
	private String resContent;
	private String proAdv;
	private String resProgram;
	private String innoPoint;
	private String resCondition;
	private String proPlan;
	private String expResult;
	private String expTarget;
	private String isdeleted;
	private String proType;
	private Double proFund;
	private String reviewOpinion;
	private String reviewResult;
	private Set TDeclJobs = new HashSet(0);
	private Set TProjects = new HashSet(0);
	private Set TExpertReviews = new HashSet(0);
	private Set TDeclFunds = new HashSet(0);

	// Constructors

	/** default constructor */
	public TDeclaration() {
	}

	/** full constructor */
	public TDeclaration(TJieqi TJieqi, TTeacher TTeacherByTeacher2Code,
			TTeacher TTeacherByTeacher1Code, TStudent TStudentByMember2Code,
			TStudent TStudentByMember1Code, TUnit TUnit,
			TStudent TStudentByLeaderCode, String proSerial, String proName,
			String labLevel, String labName, BigDecimal memberAmount,
			Date startOn, Date endOn, Date declTime, String checkState,
			String proIntro, String resContent, String proAdv,
			String resProgram, String innoPoint, String resCondition,
			String proPlan, String expResult, String expTarget,
			String isdeleted, String proType, Double proFund, Set TDeclJobs,
			Set TProjects, Set TExpertReviews, Set TDeclFunds) {
		this.TJieqi = TJieqi;
		this.TTeacherByTeacher2Code = TTeacherByTeacher2Code;
		this.TTeacherByTeacher1Code = TTeacherByTeacher1Code;
		this.TStudentByMember2Code = TStudentByMember2Code;
		this.TStudentByMember1Code = TStudentByMember1Code;
		this.TUnit = TUnit;
		this.TStudentByLeaderCode = TStudentByLeaderCode;
		this.proSerial = proSerial;
		this.proName = proName;
		this.labLevel = labLevel;
		this.labName = labName;
		this.memberAmount = memberAmount;
		this.startOn = startOn;
		this.endOn = endOn;
		this.declTime = declTime;
		this.checkState = checkState;
		this.proIntro = proIntro;
		this.resContent = resContent;
		this.proAdv = proAdv;
		this.resProgram = resProgram;
		this.innoPoint = innoPoint;
		this.resCondition = resCondition;
		this.proPlan = proPlan;
		this.expResult = expResult;
		this.expTarget = expTarget;
		this.isdeleted = isdeleted;
		this.proType = proType;
		this.proFund = proFund;
		this.TDeclJobs = TDeclJobs;
		this.TProjects = TProjects;
		this.TExpertReviews = TExpertReviews;
		this.TDeclFunds = TDeclFunds;
	}
	
	/**
	 * @param declarId
	 * @param tJieqi
	 * @param tTeacherByTeacher2Code
	 * @param tTeacherByTeacher1Code
	 * @param tStudentByMember2Code
	 * @param tStudentByMember1Code
	 * @param tUnit
	 * @param tStudentByLeaderCode
	 * @param proSerial
	 * @param proName
	 * @param labLevel
	 * @param labName
	 * @param memberAmount
	 * @param startOn
	 * @param endOn
	 * @param declTime
	 * @param checkState
	 * @param proIntro
	 * @param resContent
	 * @param proAdv
	 * @param resProgram
	 * @param innoPoint
	 * @param resCondition
	 * @param proPlan
	 * @param expResult
	 * @param expTarget
	 * @param isdeleted
	 * @param proType
	 * @param proFund
	 * @param reviewOpinion
	 * @param reviewResult
	 * @param tDeclJobs
	 * @param tProjects
	 * @param tExpertReviews
	 * @param tDeclFunds
	 */
	public TDeclaration(String declarId, com.isse.model.TJieqi tJieqi,
			TTeacher tTeacherByTeacher2Code, TTeacher tTeacherByTeacher1Code,
			TStudent tStudentByMember2Code, TStudent tStudentByMember1Code,
			com.isse.model.TUnit tUnit, TStudent tStudentByLeaderCode,
			String proSerial, String proName, String labLevel, String labName,
			BigDecimal memberAmount, Date startOn, Date endOn, Date declTime,
			String checkState, String proIntro, String resContent,
			String proAdv, String resProgram, String innoPoint,
			String resCondition, String proPlan, String expResult,
			String expTarget, String isdeleted, String proType, Double proFund,
			String reviewOpinion, String reviewResult, Set tDeclJobs,
			Set tProjects, Set tExpertReviews, Set tDeclFunds) {
		super();
		this.declarId = declarId;
		TJieqi = tJieqi;
		TTeacherByTeacher2Code = tTeacherByTeacher2Code;
		TTeacherByTeacher1Code = tTeacherByTeacher1Code;
		TStudentByMember2Code = tStudentByMember2Code;
		TStudentByMember1Code = tStudentByMember1Code;
		TUnit = tUnit;
		TStudentByLeaderCode = tStudentByLeaderCode;
		this.proSerial = proSerial;
		this.proName = proName;
		this.labLevel = labLevel;
		this.labName = labName;
		this.memberAmount = memberAmount;
		this.startOn = startOn;
		this.endOn = endOn;
		this.declTime = declTime;
		this.checkState = checkState;
		this.proIntro = proIntro;
		this.resContent = resContent;
		this.proAdv = proAdv;
		this.resProgram = resProgram;
		this.innoPoint = innoPoint;
		this.resCondition = resCondition;
		this.proPlan = proPlan;
		this.expResult = expResult;
		this.expTarget = expTarget;
		this.isdeleted = isdeleted;
		this.proType = proType;
		this.proFund = proFund;
		this.reviewOpinion = reviewOpinion;
		this.reviewResult = reviewResult;
		TDeclJobs = tDeclJobs;
		TProjects = tProjects;
		TExpertReviews = tExpertReviews;
		TDeclFunds = tDeclFunds;
	}

	// Property accessors

	public String getDeclarId() {
		return this.declarId;
	}

	public void setDeclarId(String declarId) {
		this.declarId = declarId;
	}

	public TJieqi getTJieqi() {
		return this.TJieqi;
	}

	public void setTJieqi(TJieqi TJieqi) {
		this.TJieqi = TJieqi;
	}

	public TTeacher getTTeacherByTeacher2Code() {
		return this.TTeacherByTeacher2Code;
	}

	public void setTTeacherByTeacher2Code(TTeacher TTeacherByTeacher2Code) {
		this.TTeacherByTeacher2Code = TTeacherByTeacher2Code;
	}

	public TTeacher getTTeacherByTeacher1Code() {
		return this.TTeacherByTeacher1Code;
	}

	public void setTTeacherByTeacher1Code(TTeacher TTeacherByTeacher1Code) {
		this.TTeacherByTeacher1Code = TTeacherByTeacher1Code;
	}

	public TStudent getTStudentByMember2Code() {
		return this.TStudentByMember2Code;
	}

	public void setTStudentByMember2Code(TStudent TStudentByMember2Code) {
		this.TStudentByMember2Code = TStudentByMember2Code;
	}

	public TStudent getTStudentByMember1Code() {
		return this.TStudentByMember1Code;
	}

	public void setTStudentByMember1Code(TStudent TStudentByMember1Code) {
		this.TStudentByMember1Code = TStudentByMember1Code;
	}

	public TUnit getTUnit() {
		return this.TUnit;
	}

	public void setTUnit(TUnit TUnit) {
		this.TUnit = TUnit;
	}

	public TStudent getTStudentByLeaderCode() {
		return this.TStudentByLeaderCode;
	}

	public void setTStudentByLeaderCode(TStudent TStudentByLeaderCode) {
		this.TStudentByLeaderCode = TStudentByLeaderCode;
	}

	public String getProSerial() {
		return this.proSerial;
	}

	public void setProSerial(String proSerial) {
		this.proSerial = proSerial;
	}

	public String getProName() {
		return this.proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public String getLabLevel() {
		return this.labLevel;
	}

	public void setLabLevel(String labLevel) {
		this.labLevel = labLevel;
	}

	public String getLabName() {
		return this.labName;
	}

	public void setLabName(String labName) {
		this.labName = labName;
	}

	public BigDecimal getMemberAmount() {
		return this.memberAmount;
	}

	public void setMemberAmount(BigDecimal memberAmount) {
		this.memberAmount = memberAmount;
	}

	public Date getStartOn() {
		return this.startOn;
	}

	public void setStartOn(Date startOn) {
		this.startOn = startOn;
	}

	public Date getEndOn() {
		return this.endOn;
	}

	public void setEndOn(Date endOn) {
		this.endOn = endOn;
	}

	public Date getDeclTime() {
		return this.declTime;
	}

	public void setDeclTime(Date declTime) {
		this.declTime = declTime;
	}

	public String getCheckState() {
		return this.checkState;
	}

	public void setCheckState(String checkState) {
		this.checkState = checkState;
	}

	public String getProIntro() {
		return this.proIntro;
	}

	public void setProIntro(String proIntro) {
		this.proIntro = proIntro;
	}

	public String getResContent() {
		return this.resContent;
	}

	public void setResContent(String resContent) {
		this.resContent = resContent;
	}

	public String getProAdv() {
		return this.proAdv;
	}

	public void setProAdv(String proAdv) {
		this.proAdv = proAdv;
	}

	public String getResProgram() {
		return this.resProgram;
	}

	public void setResProgram(String resProgram) {
		this.resProgram = resProgram;
	}

	public String getInnoPoint() {
		return this.innoPoint;
	}

	public void setInnoPoint(String innoPoint) {
		this.innoPoint = innoPoint;
	}

	public String getResCondition() {
		return this.resCondition;
	}

	public void setResCondition(String resCondition) {
		this.resCondition = resCondition;
	}

	public String getProPlan() {
		return this.proPlan;
	}

	public void setProPlan(String proPlan) {
		this.proPlan = proPlan;
	}

	public String getExpResult() {
		return this.expResult;
	}

	public void setExpResult(String expResult) {
		this.expResult = expResult;
	}

	public String getExpTarget() {
		return this.expTarget;
	}

	public void setExpTarget(String expTarget) {
		this.expTarget = expTarget;
	}

	public String getIsdeleted() {
		return this.isdeleted;
	}

	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}

	public String getProType() {
		return this.proType;
	}

	public void setProType(String proType) {
		this.proType = proType;
	}

	public Double getProFund() {
		return this.proFund;
	}

	public void setProFund(Double proFund) {
		this.proFund = proFund;
	}

	public Set getTDeclJobs() {
		return this.TDeclJobs;
	}

	public void setTDeclJobs(Set TDeclJobs) {
		this.TDeclJobs = TDeclJobs;
	}

	public Set getTProjects() {
		return this.TProjects;
	}

	public void setTProjects(Set TProjects) {
		this.TProjects = TProjects;
	}

	public Set getTExpertReviews() {
		return this.TExpertReviews;
	}

	public void setTExpertReviews(Set TExpertReviews) {
		this.TExpertReviews = TExpertReviews;
	}

	public Set getTDeclFunds() {
		return this.TDeclFunds;
	}

	public void setTDeclFunds(Set TDeclFunds) {
		this.TDeclFunds = TDeclFunds;
	}

	public String getReviewOpinion() {
		return reviewOpinion;
	}

	public void setReviewOpinion(String reviewOpinion) {
		this.reviewOpinion = reviewOpinion;
	}

	public String getReviewResult() {
		return reviewResult;
	}

	public void setReviewResult(String reviewResult) {
		this.reviewResult = reviewResult;
	}
	
}