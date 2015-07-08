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
 * TProject entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_project", catalog = "srtp")
public class TProject implements java.io.Serializable {

	// Fields

	private String projectId;
	private TTeacher TTeacherByProjectTeacher2;
	private TTeacher TTeacherByProjectTeacher1;
	private TJieqi TJieqi;
	private TStudent TStudentByProjectLeader;
	private TDeclaration TDeclaration;
	private TStudent TStudentByProjectUser2;
	private TUnit TUnit;
	private TStudent TStudentByProjectUser1;
	private String isdeleted;
	private String projectAchievement;
	private Timestamp projectBegintime;
	private String projectCondition;
	private String projectContent;
	private Timestamp projectEndtime;
	private Float projectFund;
	private String projectGoal;
	private String projectInnovate;
	private String projectIntroduction;
	private String projectLabname;
	private String projectLabtype;
	private String projectLine;
	private String projectName;
	private String projectNumber;
	private String projectProgress;
	private String projectScore;
	private String projectSense;
	private String projectState;
	private String projectWork;
	private String redmineProjectid;
	private Set<TCredit> TCredits = new HashSet<TCredit>(0);
	private Set<TEndProject> TEndProjects = new HashSet<TEndProject>(0);
	private Set<TAchievement> TAchievements = new HashSet<TAchievement>(0);
	private Set<TProjectChange> TProjectChanges = new HashSet<TProjectChange>(0);
	private Set<TFunds> TFundses = new HashSet<TFunds>(0);

	// Constructors

	/** default constructor */
	public TProject() {
	}

	/** full constructor */
	public TProject(TTeacher TTeacherByProjectTeacher2,
			TTeacher TTeacherByProjectTeacher1, TJieqi TJieqi,
			TStudent TStudentByProjectLeader, TDeclaration TDeclaration,
			TStudent TStudentByProjectUser2, TUnit TUnit,
			TStudent TStudentByProjectUser1, String isdeleted,
			String projectAchievement, Timestamp projectBegintime,
			String projectCondition, String projectContent,
			Timestamp projectEndtime, Float projectFund, String projectGoal,
			String projectInnovate, String projectIntroduction,
			String projectLabname, String projectLabtype, String projectLine,
			String projectName, String projectNumber, String projectProgress,
			String projectScore, String projectSense, String projectState,
			String projectWork, String redmineProjectid, Set<TCredit> TCredits,
			Set<TEndProject> TEndProjects, Set<TAchievement> TAchievements,
			Set<TProjectChange> TProjectChanges, Set<TFunds> TFundses) {
		this.TTeacherByProjectTeacher2 = TTeacherByProjectTeacher2;
		this.TTeacherByProjectTeacher1 = TTeacherByProjectTeacher1;
		this.TJieqi = TJieqi;
		this.TStudentByProjectLeader = TStudentByProjectLeader;
		this.TDeclaration = TDeclaration;
		this.TStudentByProjectUser2 = TStudentByProjectUser2;
		this.TUnit = TUnit;
		this.TStudentByProjectUser1 = TStudentByProjectUser1;
		this.isdeleted = isdeleted;
		this.projectAchievement = projectAchievement;
		this.projectBegintime = projectBegintime;
		this.projectCondition = projectCondition;
		this.projectContent = projectContent;
		this.projectEndtime = projectEndtime;
		this.projectFund = projectFund;
		this.projectGoal = projectGoal;
		this.projectInnovate = projectInnovate;
		this.projectIntroduction = projectIntroduction;
		this.projectLabname = projectLabname;
		this.projectLabtype = projectLabtype;
		this.projectLine = projectLine;
		this.projectName = projectName;
		this.projectNumber = projectNumber;
		this.projectProgress = projectProgress;
		this.projectScore = projectScore;
		this.projectSense = projectSense;
		this.projectState = projectState;
		this.projectWork = projectWork;
		this.redmineProjectid = redmineProjectid;
		this.TCredits = TCredits;
		this.TEndProjects = TEndProjects;
		this.TAchievements = TAchievements;
		this.TProjectChanges = TProjectChanges;
		this.TFundses = TFundses;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "project_id", unique = true, nullable = false, length = 36)
	public String getProjectId() {
		return this.projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "project_teacher2")
	public TTeacher getTTeacherByProjectTeacher2() {
		return this.TTeacherByProjectTeacher2;
	}

	public void setTTeacherByProjectTeacher2(TTeacher TTeacherByProjectTeacher2) {
		this.TTeacherByProjectTeacher2 = TTeacherByProjectTeacher2;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "project_teacher1")
	public TTeacher getTTeacherByProjectTeacher1() {
		return this.TTeacherByProjectTeacher1;
	}

	public void setTTeacherByProjectTeacher1(TTeacher TTeacherByProjectTeacher1) {
		this.TTeacherByProjectTeacher1 = TTeacherByProjectTeacher1;
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
	@JoinColumn(name = "project_leader")
	public TStudent getTStudentByProjectLeader() {
		return this.TStudentByProjectLeader;
	}

	public void setTStudentByProjectLeader(TStudent TStudentByProjectLeader) {
		this.TStudentByProjectLeader = TStudentByProjectLeader;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "declar_id")
	public TDeclaration getTDeclaration() {
		return this.TDeclaration;
	}

	public void setTDeclaration(TDeclaration TDeclaration) {
		this.TDeclaration = TDeclaration;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "project_user2")
	public TStudent getTStudentByProjectUser2() {
		return this.TStudentByProjectUser2;
	}

	public void setTStudentByProjectUser2(TStudent TStudentByProjectUser2) {
		this.TStudentByProjectUser2 = TStudentByProjectUser2;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "unit_id")
	public TUnit getTUnit() {
		return this.TUnit;
	}

	public void setTUnit(TUnit TUnit) {
		this.TUnit = TUnit;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "project_user1")
	public TStudent getTStudentByProjectUser1() {
		return this.TStudentByProjectUser1;
	}

	public void setTStudentByProjectUser1(TStudent TStudentByProjectUser1) {
		this.TStudentByProjectUser1 = TStudentByProjectUser1;
	}

	@Column(name = "isdeleted", length = 1)
	public String getIsdeleted() {
		return this.isdeleted;
	}

	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}

	@Column(name = "project_achievement", length = 500)
	public String getProjectAchievement() {
		return this.projectAchievement;
	}

	public void setProjectAchievement(String projectAchievement) {
		this.projectAchievement = projectAchievement;
	}

	@Column(name = "project_begintime", length = 19)
	public Timestamp getProjectBegintime() {
		return this.projectBegintime;
	}

	public void setProjectBegintime(Timestamp projectBegintime) {
		this.projectBegintime = projectBegintime;
	}

	@Column(name = "project_condition", length = 500)
	public String getProjectCondition() {
		return this.projectCondition;
	}

	public void setProjectCondition(String projectCondition) {
		this.projectCondition = projectCondition;
	}

	@Column(name = "project_content", length = 1000)
	public String getProjectContent() {
		return this.projectContent;
	}

	public void setProjectContent(String projectContent) {
		this.projectContent = projectContent;
	}

	@Column(name = "project_endtime", length = 19)
	public Timestamp getProjectEndtime() {
		return this.projectEndtime;
	}

	public void setProjectEndtime(Timestamp projectEndtime) {
		this.projectEndtime = projectEndtime;
	}

	@Column(name = "project_fund", precision = 12, scale = 0)
	public Float getProjectFund() {
		return this.projectFund;
	}

	public void setProjectFund(Float projectFund) {
		this.projectFund = projectFund;
	}

	@Column(name = "project_goal", length = 500)
	public String getProjectGoal() {
		return this.projectGoal;
	}

	public void setProjectGoal(String projectGoal) {
		this.projectGoal = projectGoal;
	}

	@Column(name = "project_innovate", length = 500)
	public String getProjectInnovate() {
		return this.projectInnovate;
	}

	public void setProjectInnovate(String projectInnovate) {
		this.projectInnovate = projectInnovate;
	}

	@Column(name = "project_introduction", length = 500)
	public String getProjectIntroduction() {
		return this.projectIntroduction;
	}

	public void setProjectIntroduction(String projectIntroduction) {
		this.projectIntroduction = projectIntroduction;
	}

	@Column(name = "project_labname", length = 20)
	public String getProjectLabname() {
		return this.projectLabname;
	}

	public void setProjectLabname(String projectLabname) {
		this.projectLabname = projectLabname;
	}

	@Column(name = "project_labtype", length = 2)
	public String getProjectLabtype() {
		return this.projectLabtype;
	}

	public void setProjectLabtype(String projectLabtype) {
		this.projectLabtype = projectLabtype;
	}

	@Column(name = "project_line", length = 500)
	public String getProjectLine() {
		return this.projectLine;
	}

	public void setProjectLine(String projectLine) {
		this.projectLine = projectLine;
	}

	@Column(name = "project_name", length = 50)
	public String getProjectName() {
		return this.projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	@Column(name = "project_number", length = 20)
	public String getProjectNumber() {
		return this.projectNumber;
	}

	public void setProjectNumber(String projectNumber) {
		this.projectNumber = projectNumber;
	}

	@Column(name = "project_progress", length = 500)
	public String getProjectProgress() {
		return this.projectProgress;
	}

	public void setProjectProgress(String projectProgress) {
		this.projectProgress = projectProgress;
	}

	@Column(name = "project_score", length = 10)
	public String getProjectScore() {
		return this.projectScore;
	}

	public void setProjectScore(String projectScore) {
		this.projectScore = projectScore;
	}

	@Column(name = "project_sense", length = 1000)
	public String getProjectSense() {
		return this.projectSense;
	}

	public void setProjectSense(String projectSense) {
		this.projectSense = projectSense;
	}

	@Column(name = "project_state", length = 2)
	public String getProjectState() {
		return this.projectState;
	}

	public void setProjectState(String projectState) {
		this.projectState = projectState;
	}

	@Column(name = "project_work", length = 500)
	public String getProjectWork() {
		return this.projectWork;
	}

	public void setProjectWork(String projectWork) {
		this.projectWork = projectWork;
	}

	@Column(name = "redmine_projectid", length = 10)
	public String getRedmineProjectid() {
		return this.redmineProjectid;
	}

	public void setRedmineProjectid(String redmineProjectid) {
		this.redmineProjectid = redmineProjectid;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TProject")
	public Set<TCredit> getTCredits() {
		return this.TCredits;
	}

	public void setTCredits(Set<TCredit> TCredits) {
		this.TCredits = TCredits;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TProject")
	public Set<TEndProject> getTEndProjects() {
		return this.TEndProjects;
	}

	public void setTEndProjects(Set<TEndProject> TEndProjects) {
		this.TEndProjects = TEndProjects;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TProject")
	public Set<TAchievement> getTAchievements() {
		return this.TAchievements;
	}

	public void setTAchievements(Set<TAchievement> TAchievements) {
		this.TAchievements = TAchievements;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TProject")
	public Set<TProjectChange> getTProjectChanges() {
		return this.TProjectChanges;
	}

	public void setTProjectChanges(Set<TProjectChange> TProjectChanges) {
		this.TProjectChanges = TProjectChanges;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TProject")
	public Set<TFunds> getTFundses() {
		return this.TFundses;
	}

	public void setTFundses(Set<TFunds> TFundses) {
		this.TFundses = TFundses;
	}

}