package com.isse.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * TProject entity. @author MyEclipse Persistence Tools
 */

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
	private Double projectFund;
	private Date projectBegintime;
	private Date projectEndtime;
	private String projectInnovate;
	private String projectCondition;
	private String projectProgress;
	private String projectGoal;
	private String projectAchievement;
	private String projectWork;
	private String redmineProjectid;
	private String projectScore;
	private String isdeleted;
	private Set TEndProjects = new HashSet(0);
	private Set TCredits = new HashSet(0);
	private Set TFundses = new HashSet(0);
	private Set TProjectChanges = new HashSet(0);
	private Set TAchievements = new HashSet(0);

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
			String projectIntroduction, Double projectFund,
			Date projectBegintime, Date projectEndtime, String projectInnovate,
			String projectCondition, String projectProgress,
			String projectGoal, String projectAchievement, String projectWork,
			String redmineProjectid, String projectScore, String isdeleted,
			Set TEndProjects, Set TCredits, Set TFundses, Set TProjectChanges,
			Set TAchievements) {
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
		this.TEndProjects = TEndProjects;
		this.TCredits = TCredits;
		this.TFundses = TFundses;
		this.TProjectChanges = TProjectChanges;
		this.TAchievements = TAchievements;
	}

	// Property accessors

	public String getProjectId() {
		return this.projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public TTeacher getTTeacherByProjectTeacher2() {
		return this.TTeacherByProjectTeacher2;
	}

	public void setTTeacherByProjectTeacher2(TTeacher TTeacherByProjectTeacher2) {
		this.TTeacherByProjectTeacher2 = TTeacherByProjectTeacher2;
	}

	public TTeacher getTTeacherByProjectTeacher1() {
		return this.TTeacherByProjectTeacher1;
	}

	public void setTTeacherByProjectTeacher1(TTeacher TTeacherByProjectTeacher1) {
		this.TTeacherByProjectTeacher1 = TTeacherByProjectTeacher1;
	}

	public TJieqi getTJieqi() {
		return this.TJieqi;
	}

	public void setTJieqi(TJieqi TJieqi) {
		this.TJieqi = TJieqi;
	}

	public TStudent getTStudentByProjectLeader() {
		return this.TStudentByProjectLeader;
	}

	public void setTStudentByProjectLeader(TStudent TStudentByProjectLeader) {
		this.TStudentByProjectLeader = TStudentByProjectLeader;
	}

	public TDeclaration getTDeclaration() {
		return this.TDeclaration;
	}

	public void setTDeclaration(TDeclaration TDeclaration) {
		this.TDeclaration = TDeclaration;
	}

	public TStudent getTStudentByProjectUser2() {
		return this.TStudentByProjectUser2;
	}

	public void setTStudentByProjectUser2(TStudent TStudentByProjectUser2) {
		this.TStudentByProjectUser2 = TStudentByProjectUser2;
	}

	public TUnit getTUnit() {
		return this.TUnit;
	}

	public void setTUnit(TUnit TUnit) {
		this.TUnit = TUnit;
	}

	public TStudent getTStudentByProjectUser1() {
		return this.TStudentByProjectUser1;
	}

	public void setTStudentByProjectUser1(TStudent TStudentByProjectUser1) {
		this.TStudentByProjectUser1 = TStudentByProjectUser1;
	}

	public String getProjectLine() {
		return this.projectLine;
	}

	public void setProjectLine(String projectLine) {
		this.projectLine = projectLine;
	}

	public String getProjectState() {
		return this.projectState;
	}

	public void setProjectState(String projectState) {
		this.projectState = projectState;
	}

	public String getProjectNumber() {
		return this.projectNumber;
	}

	public void setProjectNumber(String projectNumber) {
		this.projectNumber = projectNumber;
	}

	public String getProjectSense() {
		return this.projectSense;
	}

	public void setProjectSense(String projectSense) {
		this.projectSense = projectSense;
	}

	public String getProjectContent() {
		return this.projectContent;
	}

	public void setProjectContent(String projectContent) {
		this.projectContent = projectContent;
	}

	public String getProjectLabtype() {
		return this.projectLabtype;
	}

	public void setProjectLabtype(String projectLabtype) {
		this.projectLabtype = projectLabtype;
	}

	public String getProjectLabname() {
		return this.projectLabname;
	}

	public void setProjectLabname(String projectLabname) {
		this.projectLabname = projectLabname;
	}

	public String getProjectName() {
		return this.projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectIntroduction() {
		return this.projectIntroduction;
	}

	public void setProjectIntroduction(String projectIntroduction) {
		this.projectIntroduction = projectIntroduction;
	}

	public Double getProjectFund() {
		return this.projectFund;
	}

	public void setProjectFund(Double projectFund) {
		this.projectFund = projectFund;
	}

	public Date getProjectBegintime() {
		return this.projectBegintime;
	}

	public void setProjectBegintime(Date projectBegintime) {
		this.projectBegintime = projectBegintime;
	}

	public Date getProjectEndtime() {
		return this.projectEndtime;
	}

	public void setProjectEndtime(Date projectEndtime) {
		this.projectEndtime = projectEndtime;
	}

	public String getProjectInnovate() {
		return this.projectInnovate;
	}

	public void setProjectInnovate(String projectInnovate) {
		this.projectInnovate = projectInnovate;
	}

	public String getProjectCondition() {
		return this.projectCondition;
	}

	public void setProjectCondition(String projectCondition) {
		this.projectCondition = projectCondition;
	}

	public String getProjectProgress() {
		return this.projectProgress;
	}

	public void setProjectProgress(String projectProgress) {
		this.projectProgress = projectProgress;
	}

	public String getProjectGoal() {
		return this.projectGoal;
	}

	public void setProjectGoal(String projectGoal) {
		this.projectGoal = projectGoal;
	}

	public String getProjectAchievement() {
		return this.projectAchievement;
	}

	public void setProjectAchievement(String projectAchievement) {
		this.projectAchievement = projectAchievement;
	}

	public String getProjectWork() {
		return this.projectWork;
	}

	public void setProjectWork(String projectWork) {
		this.projectWork = projectWork;
	}

	public String getRedmineProjectid() {
		return this.redmineProjectid;
	}

	public void setRedmineProjectid(String redmineProjectid) {
		this.redmineProjectid = redmineProjectid;
	}

	public String getProjectScore() {
		return this.projectScore;
	}

	public void setProjectScore(String projectScore) {
		this.projectScore = projectScore;
	}

	public String getIsdeleted() {
		return this.isdeleted;
	}

	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}

	public Set getTEndProjects() {
		return this.TEndProjects;
	}

	public void setTEndProjects(Set TEndProjects) {
		this.TEndProjects = TEndProjects;
	}

	public Set getTCredits() {
		return this.TCredits;
	}

	public void setTCredits(Set TCredits) {
		this.TCredits = TCredits;
	}

	public Set getTFundses() {
		return this.TFundses;
	}

	public void setTFundses(Set TFundses) {
		this.TFundses = TFundses;
	}

	public Set getTProjectChanges() {
		return this.TProjectChanges;
	}

	public void setTProjectChanges(Set TProjectChanges) {
		this.TProjectChanges = TProjectChanges;
	}

	public Set getTAchievements() {
		return this.TAchievements;
	}

	public void setTAchievements(Set TAchievements) {
		this.TAchievements = TAchievements;
	}

}