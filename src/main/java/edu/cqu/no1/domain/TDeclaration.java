package edu.cqu.no1.domain;// default package

import java.sql.Timestamp;
import java.util.Date;
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
 * TDeclaration entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_declaration", catalog = "srtp")
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
	private Integer memberAmount;
	private Timestamp startOn;
	private Timestamp endOn;
	private Timestamp declTime;
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
	private String reviewOpinion;
	private String reviewResult;
	private String proType;
	private Double proFund;
	private Set<TProject> TProjects = new HashSet<TProject>(0);
	private Set<TDeclJob> TDeclJobs = new HashSet<TDeclJob>(0);
	private Set<TDeclFund> TDeclFunds = new HashSet<TDeclFund>(0);
	private Set<TExpertReview> TExpertReviews = new HashSet<TExpertReview>(0);

	// Constructors

	/** default constructor */
	public TDeclaration() {
	}

	/** full constructor */
	public TDeclaration(TJieqi TJieqi, TTeacher TTeacherByTeacher2Code,
			TTeacher TTeacherByTeacher1Code, TStudent TStudentByMember2Code,
			TStudent TStudentByMember1Code, TUnit TUnit,
			TStudent TStudentByLeaderCode, String proSerial, String proName,
			String labLevel, String labName, Integer memberAmount,
			Timestamp startOn, Timestamp endOn, Timestamp declTime,
			String checkState, String proIntro, String resContent,
			String proAdv, String resProgram, String innoPoint,
			String resCondition, String proPlan, String expResult,
			String expTarget, String isdeleted, String reviewOpinion,
			String reviewResult, String proType, Double proFund,
			Set<TProject> TProjects, Set<TDeclJob> TDeclJobs,
			Set<TDeclFund> TDeclFunds, Set<TExpertReview> TExpertReviews) {
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
		this.reviewOpinion = reviewOpinion;
		this.reviewResult = reviewResult;
		this.proType = proType;
		this.proFund = proFund;
		this.TProjects = TProjects;
		this.TDeclJobs = TDeclJobs;
		this.TDeclFunds = TDeclFunds;
		this.TExpertReviews = TExpertReviews;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "guid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "declar_id", unique = true, nullable = false, length = 36)
	public String getDeclarId() {
		return this.declarId;
	}

	public void setDeclarId(String declarId) {
		this.declarId = declarId;
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
	@JoinColumn(name = "teacher2_code")
	public TTeacher getTTeacherByTeacher2Code() {
		return this.TTeacherByTeacher2Code;
	}

	public void setTTeacherByTeacher2Code(TTeacher TTeacherByTeacher2Code) {
		this.TTeacherByTeacher2Code = TTeacherByTeacher2Code;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "teacher1_code")
	public TTeacher getTTeacherByTeacher1Code() {
		return this.TTeacherByTeacher1Code;
	}

	public void setTTeacherByTeacher1Code(TTeacher TTeacherByTeacher1Code) {
		this.TTeacherByTeacher1Code = TTeacherByTeacher1Code;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member2_code")
	public TStudent getTStudentByMember2Code() {
		return this.TStudentByMember2Code;
	}

	public void setTStudentByMember2Code(TStudent TStudentByMember2Code) {
		this.TStudentByMember2Code = TStudentByMember2Code;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member1_code")
	public TStudent getTStudentByMember1Code() {
		return this.TStudentByMember1Code;
	}

	public void setTStudentByMember1Code(TStudent TStudentByMember1Code) {
		this.TStudentByMember1Code = TStudentByMember1Code;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "college")
	public TUnit getTUnit() {
		return this.TUnit;
	}

	public void setTUnit(TUnit TUnit) {
		this.TUnit = TUnit;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "leader_code")
	public TStudent getTStudentByLeaderCode() {
		return this.TStudentByLeaderCode;
	}

	public void setTStudentByLeaderCode(TStudent TStudentByLeaderCode) {
		this.TStudentByLeaderCode = TStudentByLeaderCode;
	}

	@Column(name = "pro_serial", length = 30)
	public String getProSerial() {
		return this.proSerial;
	}

	public void setProSerial(String proSerial) {
		this.proSerial = proSerial;
	}

	@Column(name = "pro_name", length = 50)
	public String getProName() {
		return this.proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	@Column(name = "lab_level", length = 20)
	public String getLabLevel() {
		return this.labLevel;
	}

	public void setLabLevel(String labLevel) {
		this.labLevel = labLevel;
	}

	@Column(name = "lab_name", length = 50)
	public String getLabName() {
		return this.labName;
	}

	public void setLabName(String labName) {
		this.labName = labName;
	}

	@Column(name = "member_amount")
	public Integer getMemberAmount() {
		return this.memberAmount;
	}

	public void setMemberAmount(Integer memberAmount) {
		this.memberAmount = memberAmount;
	}

	@Column(name = "start_on", length = 19)
	public Timestamp getStartOn() {
		return this.startOn;
	}

	public void setStartOn(Timestamp startOn) {
		this.startOn = startOn;
	}

	@Column(name = "end_on", length = 19)
	public Timestamp getEndOn() {
		return this.endOn;
	}

	public void setEndOn(Timestamp endOn) {
		this.endOn = endOn;
	}

	@Column(name = "decl_time", length = 19)
	public Timestamp getDeclTime() {
		return this.declTime;
	}

	public void setDeclTime(Timestamp declTime) {
		this.declTime = declTime;
	}

	@Column(name = "check_state", length = 2)
	public String getCheckState() {
		return this.checkState;
	}

	public void setCheckState(String checkState) {
		this.checkState = checkState;
	}

	@Column(name = "pro_intro", length = 500)
	public String getProIntro() {
		return this.proIntro;
	}

	public void setProIntro(String proIntro) {
		this.proIntro = proIntro;
	}

	@Column(name = "res_content", length = 1000)
	public String getResContent() {
		return this.resContent;
	}

	public void setResContent(String resContent) {
		this.resContent = resContent;
	}

	@Column(name = "pro_adv", length = 1000)
	public String getProAdv() {
		return this.proAdv;
	}

	public void setProAdv(String proAdv) {
		this.proAdv = proAdv;
	}

	@Column(name = "res_program", length = 1000)
	public String getResProgram() {
		return this.resProgram;
	}

	public void setResProgram(String resProgram) {
		this.resProgram = resProgram;
	}

	@Column(name = "inno_point", length = 1000)
	public String getInnoPoint() {
		return this.innoPoint;
	}

	public void setInnoPoint(String innoPoint) {
		this.innoPoint = innoPoint;
	}

	@Column(name = "res_condition", length = 1000)
	public String getResCondition() {
		return this.resCondition;
	}

	public void setResCondition(String resCondition) {
		this.resCondition = resCondition;
	}

	@Column(name = "pro_plan", length = 1000)
	public String getProPlan() {
		return this.proPlan;
	}

	public void setProPlan(String proPlan) {
		this.proPlan = proPlan;
	}

	@Column(name = "exp_result", length = 500)
	public String getExpResult() {
		return this.expResult;
	}

	public void setExpResult(String expResult) {
		this.expResult = expResult;
	}

	@Column(name = "exp_target", length = 500)
	public String getExpTarget() {
		return this.expTarget;
	}

	public void setExpTarget(String expTarget) {
		this.expTarget = expTarget;
	}

	@Column(name = "isdeleted", length = 1)
	public String getIsdeleted() {
		return this.isdeleted;
	}

	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}

	@Column(name = "REVIEW_OPINION", length = 500)
	public String getReviewOpinion() {
		return this.reviewOpinion;
	}

	public void setReviewOpinion(String reviewOpinion) {
		this.reviewOpinion = reviewOpinion;
	}

	@Column(name = "REVIEW_RESULT", length = 2)
	public String getReviewResult() {
		return this.reviewResult;
	}

	public void setReviewResult(String reviewResult) {
		this.reviewResult = reviewResult;
	}

	@Column(name = "PRO_TYPE", length = 2)
	public String getProType() {
		return this.proType;
	}

	public void setProType(String proType) {
		this.proType = proType;
	}

	@Column(name = "PRO_FUND", precision = 22, scale = 0)
	public Double getProFund() {
		return this.proFund;
	}

	public void setProFund(Double proFund) {
		this.proFund = proFund;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TDeclaration")
	public Set<TProject> getTProjects() {
		return this.TProjects;
	}

	public void setTProjects(Set<TProject> TProjects) {
		this.TProjects = TProjects;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TDeclaration")
	public Set<TDeclJob> getTDeclJobs() {
		return this.TDeclJobs;
	}

	public void setTDeclJobs(Set<TDeclJob> TDeclJobs) {
		this.TDeclJobs = TDeclJobs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TDeclaration")
	public Set<TDeclFund> getTDeclFunds() {
		return this.TDeclFunds;
	}

	public void setTDeclFunds(Set<TDeclFund> TDeclFunds) {
		this.TDeclFunds = TDeclFunds;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TDeclaration")
	public Set<TExpertReview> getTExpertReviews() {
		return this.TExpertReviews;
	}

	public void setTExpertReviews(Set<TExpertReview> TExpertReviews) {
		this.TExpertReviews = TExpertReviews;
	}

}