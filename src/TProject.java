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
	private String projectLine;
	private String projectState;
	private String projectNumber;
	private String projectSense;
	private String projectContent;
	private String projectLabtype;
	private String projectLabname;
	private String projectName;
	private String projectIntroduction;
	private Float projectFund;
	private Timestamp projectBegintime;
	private Timestamp projectEndtime;
	private String projectInnovate;
	private String projectCondition;
	private String projectProgress;
	private String projectGoal;
	private String projectAchievement;
	private String projectWork;
	private String redmineProjectid;
	private String projectScore;
	private String isdeleted;
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
			TStudent TStudentByProjectUser1, String projectLine,
			String projectState, String projectNumber, String projectSense,
			String projectContent, String projectLabtype,
			String projectLabname, String projectName,
			String projectIntroduction, Float projectFund,
			Timestamp projectBegintime, Timestamp projectEndtime,
			String projectInnovate, String projectCondition,
			String projectProgress, String projectGoal,
			String projectAchievement, String projectWork,
			String redmineProjectid, String projectScore, String isdeleted,
			Set<TCredit> TCredits, Set<TEndProject> TEndProjects,
			Set<TAchievement> TAchievements,
			Set<TProjectChange> TProjectChanges, Set<TFunds> TFundses) {
		this.TTeacherByProjectTeacher2 = TTeacherByProjectTeacher2;
		this.TTeacherByProjectTeacher1 = TTeacherByProjectTeacher1;
		this.TJieqi = TJieqi;
		this.TStudentByProjectLeader = TStudentByProjectLeader;
		this.TDeclaration = TDeclaration;
		this.TStudentByProjectUser2 = TStudentByProjectUser2;
		this.TUnit = TUnit;
		this.TStudentByProjectUser1 = TStudentByProjectUser1;
		this.projectLine = projectLine;
		this.projectState = projectState;
		this.projectNumber = projectNumber;
		this.projectSense = projectSense;
		this.projectContent = projectContent;
		this.projectLabtype = projectLabtype;
		this.projectLabname = projectLabname;
		this.projectName = projectName;
		this.projectIntroduction = projectIntroduction;
		this.projectFund = projectFund;
		this.projectBegintime = projectBegintime;
		this.projectEndtime = projectEndtime;
		this.projectInnovate = projectInnovate;
		this.projectCondition = projectCondition;
		this.projectProgress = projectProgress;
		this.projectGoal = projectGoal;
		this.projectAchievement = projectAchievement;
		this.projectWork = projectWork;
		this.redmineProjectid = redmineProjectid;
		this.projectScore = projectScore;
		this.isdeleted = isdeleted;
		this.TCredits = TCredits;
		this.TEndProjects = TEndProjects;
		this.TAchievements = TAchievements;
		this.TProjectChanges = TProjectChanges;
		this.TFundses = TFundses;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "guid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "project_id", unique = true, nullable = false, length = 32)
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

	@Column(name = "project_line", length = 500)
	public String getProjectLine() {
		return this.projectLine;
	}

	public void setProjectLine(String projectLine) {
		this.projectLine = projectLine;
	}

	@Column(name = "project_state", length = 2)
	public String getProjectState() {
		return this.projectState;
	}

	public void setProjectState(String projectState) {
		this.projectState = projectState;
	}

	@Column(name = "project_number", length = 20)
	public String getProjectNumber() {
		return this.projectNumber;
	}

	public void setProjectNumber(String projectNumber) {
		this.projectNumber = projectNumber;
	}

	@Column(name = "project_sense", length = 1000)
	public String getProjectSense() {
		return this.projectSense;
	}

	public void setProjectSense(String projectSense) {
		this.projectSense = projectSense;
	}

	@Column(name = "project_content", length = 1000)
	public String getProjectContent() {
		return this.projectContent;
	}

	public void setProjectContent(String projectContent) {
		this.projectContent = projectContent;
	}

	@Column(name = "project_labtype", length = 2)
	public String getProjectLabtype() {
		return this.projectLabtype;
	}

	public void setProjectLabtype(String projectLabtype) {
		this.projectLabtype = projectLabtype;
	}

	@Column(name = "project_labname", length = 20)
	public String getProjectLabname() {
		return this.projectLabname;
	}

	public void setProjectLabname(String projectLabname) {
		this.projectLabname = projectLabname;
	}

	@Column(name = "project_name", length = 50)
	public String getProjectName() {
		return this.projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	@Column(name = "project_introduction", length = 500)
	public String getProjectIntroduction() {
		return this.projectIntroduction;
	}

	public void setProjectIntroduction(String projectIntroduction) {
		this.projectIntroduction = projectIntroduction;
	}

	@Column(name = "project_fund", precision = 12, scale = 0)
	public Float getProjectFund() {
		return this.projectFund;
	}

	public void setProjectFund(Float projectFund) {
		this.projectFund = projectFund;
	}

	@Column(name = "project_begintime", length = 19)
	public Timestamp getProjectBegintime() {
		return this.projectBegintime;
	}

	public void setProjectBegintime(Timestamp projectBegintime) {
		this.projectBegintime = projectBegintime;
	}

	@Column(name = "project_endtime", length = 19)
	public Timestamp getProjectEndtime() {
		return this.projectEndtime;
	}

	public void setProjectEndtime(Timestamp projectEndtime) {
		this.projectEndtime = projectEndtime;
	}

	@Column(name = "project_innovate", length = 500)
	public String getProjectInnovate() {
		return this.projectInnovate;
	}

	public void setProjectInnovate(String projectInnovate) {
		this.projectInnovate = projectInnovate;
	}

	@Column(name = "project_condition", length = 500)
	public String getProjectCondition() {
		return this.projectCondition;
	}

	public void setProjectCondition(String projectCondition) {
		this.projectCondition = projectCondition;
	}

	@Column(name = "project_progress", length = 500)
	public String getProjectProgress() {
		return this.projectProgress;
	}

	public void setProjectProgress(String projectProgress) {
		this.projectProgress = projectProgress;
	}

	@Column(name = "project_goal", length = 500)
	public String getProjectGoal() {
		return this.projectGoal;
	}

	public void setProjectGoal(String projectGoal) {
		this.projectGoal = projectGoal;
	}

	@Column(name = "project_achievement", length = 500)
	public String getProjectAchievement() {
		return this.projectAchievement;
	}

	public void setProjectAchievement(String projectAchievement) {
		this.projectAchievement = projectAchievement;
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

	@Column(name = "project_score", length = 10)
	public String getProjectScore() {
		return this.projectScore;
	}

	public void setProjectScore(String projectScore) {
		this.projectScore = projectScore;
	}

	@Column(name = "isdeleted", length = 1)
	public String getIsdeleted() {
		return this.isdeleted;
	}

	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
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