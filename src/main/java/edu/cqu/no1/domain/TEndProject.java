package edu.cqu.no1.domain;

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
 * TEndProject entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_end_project", catalog = "srtp")
public class TEndProject implements java.io.Serializable {

	// Fields

	private String endProjectId;
	private TJieqi TJieqi;
	private TProject TProject;
	private TUnit TUnit;
	private String endProjectComment;
	private String endProjectContent;
	private Float endProjectCredit;
	private String endProjectInnovate;
	private String endProjectIntroduction;
	private String endProjectMethod;
	private String endProjectName;
	private String endProjectNumber;
	private String endProjectPassApply;
	private String endProjectProblem;
	private String endProjectScore;
	private String endProjectSense;
	private String endProjectState;
	private String endProjectSummary;
	private String endProjectWork;
	private String isdeleted;
	private String lastComment;
	private String lastScore;
	private Timestamp schoolTypeinTime;
	private Timestamp submitTime;
	private Timestamp unitTypeinTime;
	private Set<TEndProjectJob> TEndProjectJobs = new HashSet<TEndProjectJob>(0);
	private Set<TEndProjectExport> TEndProjectExports = new HashSet<TEndProjectExport>(
			0);

	// Constructors

	/** default constructor */
	public TEndProject() {
	}

	/** full constructor */
	public TEndProject(TJieqi TJieqi, TProject TProject, TUnit TUnit,
			String endProjectComment, String endProjectContent,
			Float endProjectCredit, String endProjectInnovate,
			String endProjectIntroduction, String endProjectMethod,
			String endProjectName, String endProjectNumber,
			String endProjectPassApply, String endProjectProblem,
			String endProjectScore, String endProjectSense,
			String endProjectState, String endProjectSummary,
			String endProjectWork, String isdeleted, String lastComment,
			String lastScore, Timestamp schoolTypeinTime, Timestamp submitTime,
			Timestamp unitTypeinTime, Set<TEndProjectJob> TEndProjectJobs,
			Set<TEndProjectExport> TEndProjectExports) {
		this.TJieqi = TJieqi;
		this.TProject = TProject;
		this.TUnit = TUnit;
		this.endProjectComment = endProjectComment;
		this.endProjectContent = endProjectContent;
		this.endProjectCredit = endProjectCredit;
		this.endProjectInnovate = endProjectInnovate;
		this.endProjectIntroduction = endProjectIntroduction;
		this.endProjectMethod = endProjectMethod;
		this.endProjectName = endProjectName;
		this.endProjectNumber = endProjectNumber;
		this.endProjectPassApply = endProjectPassApply;
		this.endProjectProblem = endProjectProblem;
		this.endProjectScore = endProjectScore;
		this.endProjectSense = endProjectSense;
		this.endProjectState = endProjectState;
		this.endProjectSummary = endProjectSummary;
		this.endProjectWork = endProjectWork;
		this.isdeleted = isdeleted;
		this.lastComment = lastComment;
		this.lastScore = lastScore;
		this.schoolTypeinTime = schoolTypeinTime;
		this.submitTime = submitTime;
		this.unitTypeinTime = unitTypeinTime;
		this.TEndProjectJobs = TEndProjectJobs;
		this.TEndProjectExports = TEndProjectExports;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "endProject_id", unique = true, nullable = false, length = 36)
	public String getEndProjectId() {
		return this.endProjectId;
	}

	public void setEndProjectId(String endProjectId) {
		this.endProjectId = endProjectId;
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
	@JoinColumn(name = "project_id")
	public TProject getTProject() {
		return this.TProject;
	}

	public void setTProject(TProject TProject) {
		this.TProject = TProject;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UNIT_ID")
	public TUnit getTUnit() {
		return this.TUnit;
	}

	public void setTUnit(TUnit TUnit) {
		this.TUnit = TUnit;
	}

	@Column(name = "endProject_comment", length = 1000)
	public String getEndProjectComment() {
		return this.endProjectComment;
	}

	public void setEndProjectComment(String endProjectComment) {
		this.endProjectComment = endProjectComment;
	}

	@Column(name = "endProject_content", length = 1000)
	public String getEndProjectContent() {
		return this.endProjectContent;
	}

	public void setEndProjectContent(String endProjectContent) {
		this.endProjectContent = endProjectContent;
	}

	@Column(name = "endProject_credit", precision = 12, scale = 0)
	public Float getEndProjectCredit() {
		return this.endProjectCredit;
	}

	public void setEndProjectCredit(Float endProjectCredit) {
		this.endProjectCredit = endProjectCredit;
	}

	@Column(name = "endProject_innovate", length = 1000)
	public String getEndProjectInnovate() {
		return this.endProjectInnovate;
	}

	public void setEndProjectInnovate(String endProjectInnovate) {
		this.endProjectInnovate = endProjectInnovate;
	}

	@Column(name = "endProject_introduction", length = 1000)
	public String getEndProjectIntroduction() {
		return this.endProjectIntroduction;
	}

	public void setEndProjectIntroduction(String endProjectIntroduction) {
		this.endProjectIntroduction = endProjectIntroduction;
	}

	@Column(name = "endProject_method", length = 1000)
	public String getEndProjectMethod() {
		return this.endProjectMethod;
	}

	public void setEndProjectMethod(String endProjectMethod) {
		this.endProjectMethod = endProjectMethod;
	}

	@Column(name = "endProject_name", length = 50)
	public String getEndProjectName() {
		return this.endProjectName;
	}

	public void setEndProjectName(String endProjectName) {
		this.endProjectName = endProjectName;
	}

	@Column(name = "endProject_number", length = 20)
	public String getEndProjectNumber() {
		return this.endProjectNumber;
	}

	public void setEndProjectNumber(String endProjectNumber) {
		this.endProjectNumber = endProjectNumber;
	}

	@Column(name = "endProject_passApply", length = 2)
	public String getEndProjectPassApply() {
		return this.endProjectPassApply;
	}

	public void setEndProjectPassApply(String endProjectPassApply) {
		this.endProjectPassApply = endProjectPassApply;
	}

	@Column(name = "endProject_problem", length = 1000)
	public String getEndProjectProblem() {
		return this.endProjectProblem;
	}

	public void setEndProjectProblem(String endProjectProblem) {
		this.endProjectProblem = endProjectProblem;
	}

	@Column(name = "endProject_score", length = 10)
	public String getEndProjectScore() {
		return this.endProjectScore;
	}

	public void setEndProjectScore(String endProjectScore) {
		this.endProjectScore = endProjectScore;
	}

	@Column(name = "endProject_sense", length = 1000)
	public String getEndProjectSense() {
		return this.endProjectSense;
	}

	public void setEndProjectSense(String endProjectSense) {
		this.endProjectSense = endProjectSense;
	}

	@Column(name = "endProject_state", length = 2)
	public String getEndProjectState() {
		return this.endProjectState;
	}

	public void setEndProjectState(String endProjectState) {
		this.endProjectState = endProjectState;
	}

	@Column(name = "endProject_summary", length = 1000)
	public String getEndProjectSummary() {
		return this.endProjectSummary;
	}

	public void setEndProjectSummary(String endProjectSummary) {
		this.endProjectSummary = endProjectSummary;
	}

	@Column(name = "endProject_work", length = 1000)
	public String getEndProjectWork() {
		return this.endProjectWork;
	}

	public void setEndProjectWork(String endProjectWork) {
		this.endProjectWork = endProjectWork;
	}

	@Column(name = "isdeleted", length = 1)
	public String getIsdeleted() {
		return this.isdeleted;
	}

	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}

	@Column(name = "last_comment", length = 1000)
	public String getLastComment() {
		return this.lastComment;
	}

	public void setLastComment(String lastComment) {
		this.lastComment = lastComment;
	}

	@Column(name = "last_score", length = 10)
	public String getLastScore() {
		return this.lastScore;
	}

	public void setLastScore(String lastScore) {
		this.lastScore = lastScore;
	}

	@Column(name = "SCHOOL_TYPEIN_TIME", length = 19)
	public Timestamp getSchoolTypeinTime() {
		return this.schoolTypeinTime;
	}

	public void setSchoolTypeinTime(Timestamp schoolTypeinTime) {
		this.schoolTypeinTime = schoolTypeinTime;
	}

	@Column(name = "SUBMIT_TIME", length = 19)
	public Timestamp getSubmitTime() {
		return this.submitTime;
	}

	public void setSubmitTime(Timestamp submitTime) {
		this.submitTime = submitTime;
	}

	@Column(name = "UNIT_TYPEIN_TIME", length = 19)
	public Timestamp getUnitTypeinTime() {
		return this.unitTypeinTime;
	}

	public void setUnitTypeinTime(Timestamp unitTypeinTime) {
		this.unitTypeinTime = unitTypeinTime;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TEndProject")
	public Set<TEndProjectJob> getTEndProjectJobs() {
		return this.TEndProjectJobs;
	}

	public void setTEndProjectJobs(Set<TEndProjectJob> TEndProjectJobs) {
		this.TEndProjectJobs = TEndProjectJobs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TEndProject")
	public Set<TEndProjectExport> getTEndProjectExports() {
		return this.TEndProjectExports;
	}

	public void setTEndProjectExports(Set<TEndProjectExport> TEndProjectExports) {
		this.TEndProjectExports = TEndProjectExports;
	}

}