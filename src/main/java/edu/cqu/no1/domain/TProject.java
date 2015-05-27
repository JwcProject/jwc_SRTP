package edu.cqu.no1.domain;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Created by ZKQ on 2015/5/27.
 */
@Entity
@javax.persistence.Table(name = "t_project", schema = "", catalog = "srtp")
public class TProject {
    private String projectId;

    @Id
    @javax.persistence.Column(name = "PROJECT_ID")
    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    private String projectTeacher2;

    @Basic
    @javax.persistence.Column(name = "PROJECT_TEACHER2")
    public String getProjectTeacher2() {
        return projectTeacher2;
    }

    public void setProjectTeacher2(String projectTeacher2) {
        this.projectTeacher2 = projectTeacher2;
    }

    private String projectTeacher1;

    @Basic
    @javax.persistence.Column(name = "PROJECT_TEACHER1")
    public String getProjectTeacher1() {
        return projectTeacher1;
    }

    public void setProjectTeacher1(String projectTeacher1) {
        this.projectTeacher1 = projectTeacher1;
    }

    private String jqId;

    @Basic
    @javax.persistence.Column(name = "JQ_ID")
    public String getJqId() {
        return jqId;
    }

    public void setJqId(String jqId) {
        this.jqId = jqId;
    }

    private String projectLeader;

    @Basic
    @javax.persistence.Column(name = "PROJECT_LEADER")
    public String getProjectLeader() {
        return projectLeader;
    }

    public void setProjectLeader(String projectLeader) {
        this.projectLeader = projectLeader;
    }

    private String declarId;

    @Basic
    @javax.persistence.Column(name = "DECLAR_ID")
    public String getDeclarId() {
        return declarId;
    }

    public void setDeclarId(String declarId) {
        this.declarId = declarId;
    }

    private String projectUser2;

    @Basic
    @javax.persistence.Column(name = "PROJECT_USER2")
    public String getProjectUser2() {
        return projectUser2;
    }

    public void setProjectUser2(String projectUser2) {
        this.projectUser2 = projectUser2;
    }

    private String unitId;

    @Basic
    @javax.persistence.Column(name = "UNIT_ID")
    public String getUnitId() {
        return unitId;
    }

    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }

    private String projectUser1;

    @Basic
    @javax.persistence.Column(name = "PROJECT_USER1")
    public String getProjectUser1() {
        return projectUser1;
    }

    public void setProjectUser1(String projectUser1) {
        this.projectUser1 = projectUser1;
    }

    private String projectLine;

    @Basic
    @javax.persistence.Column(name = "PROJECT_LINE")
    public String getProjectLine() {
        return projectLine;
    }

    public void setProjectLine(String projectLine) {
        this.projectLine = projectLine;
    }

    private String projectState;

    @Basic
    @javax.persistence.Column(name = "PROJECT_STATE")
    public String getProjectState() {
        return projectState;
    }

    public void setProjectState(String projectState) {
        this.projectState = projectState;
    }

    private String projectNumber;

    @Basic
    @javax.persistence.Column(name = "PROJECT_NUMBER")
    public String getProjectNumber() {
        return projectNumber;
    }

    public void setProjectNumber(String projectNumber) {
        this.projectNumber = projectNumber;
    }

    private String projectSense;

    @Basic
    @javax.persistence.Column(name = "PROJECT_SENSE")
    public String getProjectSense() {
        return projectSense;
    }

    public void setProjectSense(String projectSense) {
        this.projectSense = projectSense;
    }

    private String projectContent;

    @Basic
    @javax.persistence.Column(name = "PROJECT_CONTENT")
    public String getProjectContent() {
        return projectContent;
    }

    public void setProjectContent(String projectContent) {
        this.projectContent = projectContent;
    }

    private String projectLabtype;

    @Basic
    @javax.persistence.Column(name = "PROJECT_LABTYPE")
    public String getProjectLabtype() {
        return projectLabtype;
    }

    public void setProjectLabtype(String projectLabtype) {
        this.projectLabtype = projectLabtype;
    }

    private String projectLabname;

    @Basic
    @javax.persistence.Column(name = "PROJECT_LABNAME")
    public String getProjectLabname() {
        return projectLabname;
    }

    public void setProjectLabname(String projectLabname) {
        this.projectLabname = projectLabname;
    }

    private String projectName;

    @Basic
    @javax.persistence.Column(name = "PROJECT_NAME")
    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    private String projectIntroduction;

    @Basic
    @javax.persistence.Column(name = "PROJECT_INTRODUCTION")
    public String getProjectIntroduction() {
        return projectIntroduction;
    }

    public void setProjectIntroduction(String projectIntroduction) {
        this.projectIntroduction = projectIntroduction;
    }

    private Double projectFund;

    @Basic
    @javax.persistence.Column(name = "PROJECT_FUND")
    public Double getProjectFund() {
        return projectFund;
    }

    public void setProjectFund(Double projectFund) {
        this.projectFund = projectFund;
    }

    private Timestamp projectBegintime;

    @Basic
    @javax.persistence.Column(name = "PROJECT_BEGINTIME")
    public Timestamp getProjectBegintime() {
        return projectBegintime;
    }

    public void setProjectBegintime(Timestamp projectBegintime) {
        this.projectBegintime = projectBegintime;
    }

    private Timestamp projectEndtime;

    @Basic
    @javax.persistence.Column(name = "PROJECT_ENDTIME")
    public Timestamp getProjectEndtime() {
        return projectEndtime;
    }

    public void setProjectEndtime(Timestamp projectEndtime) {
        this.projectEndtime = projectEndtime;
    }

    private String projectInnovate;

    @Basic
    @javax.persistence.Column(name = "PROJECT_INNOVATE")
    public String getProjectInnovate() {
        return projectInnovate;
    }

    public void setProjectInnovate(String projectInnovate) {
        this.projectInnovate = projectInnovate;
    }

    private String projectCondition;

    @Basic
    @javax.persistence.Column(name = "PROJECT_CONDITION")
    public String getProjectCondition() {
        return projectCondition;
    }

    public void setProjectCondition(String projectCondition) {
        this.projectCondition = projectCondition;
    }

    private String projectProgress;

    @Basic
    @javax.persistence.Column(name = "PROJECT_PROGRESS")
    public String getProjectProgress() {
        return projectProgress;
    }

    public void setProjectProgress(String projectProgress) {
        this.projectProgress = projectProgress;
    }

    private String projectGoal;

    @Basic
    @javax.persistence.Column(name = "PROJECT_GOAL")
    public String getProjectGoal() {
        return projectGoal;
    }

    public void setProjectGoal(String projectGoal) {
        this.projectGoal = projectGoal;
    }

    private String projectAchievement;

    @Basic
    @javax.persistence.Column(name = "PROJECT_ACHIEVEMENT")
    public String getProjectAchievement() {
        return projectAchievement;
    }

    public void setProjectAchievement(String projectAchievement) {
        this.projectAchievement = projectAchievement;
    }

    private String projectWork;

    @Basic
    @javax.persistence.Column(name = "PROJECT_WORK")
    public String getProjectWork() {
        return projectWork;
    }

    public void setProjectWork(String projectWork) {
        this.projectWork = projectWork;
    }

    private String redmineProjectid;

    @Basic
    @javax.persistence.Column(name = "REDMINE_PROJECTID")
    public String getRedmineProjectid() {
        return redmineProjectid;
    }

    public void setRedmineProjectid(String redmineProjectid) {
        this.redmineProjectid = redmineProjectid;
    }

    private String projectScore;

    @Basic
    @javax.persistence.Column(name = "PROJECT_SCORE")
    public String getProjectScore() {
        return projectScore;
    }

    public void setProjectScore(String projectScore) {
        this.projectScore = projectScore;
    }

    private String isdeleted;

    @Basic
    @javax.persistence.Column(name = "ISDELETED")
    public String getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(String isdeleted) {
        this.isdeleted = isdeleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TProject tProject = (TProject) o;

        if (declarId != null ? !declarId.equals(tProject.declarId) : tProject.declarId != null) return false;
        if (isdeleted != null ? !isdeleted.equals(tProject.isdeleted) : tProject.isdeleted != null) return false;
        if (jqId != null ? !jqId.equals(tProject.jqId) : tProject.jqId != null) return false;
        if (projectAchievement != null ? !projectAchievement.equals(tProject.projectAchievement) : tProject.projectAchievement != null)
            return false;
        if (projectBegintime != null ? !projectBegintime.equals(tProject.projectBegintime) : tProject.projectBegintime != null)
            return false;
        if (projectCondition != null ? !projectCondition.equals(tProject.projectCondition) : tProject.projectCondition != null)
            return false;
        if (projectContent != null ? !projectContent.equals(tProject.projectContent) : tProject.projectContent != null)
            return false;
        if (projectEndtime != null ? !projectEndtime.equals(tProject.projectEndtime) : tProject.projectEndtime != null)
            return false;
        if (projectFund != null ? !projectFund.equals(tProject.projectFund) : tProject.projectFund != null)
            return false;
        if (projectGoal != null ? !projectGoal.equals(tProject.projectGoal) : tProject.projectGoal != null)
            return false;
        if (projectId != null ? !projectId.equals(tProject.projectId) : tProject.projectId != null) return false;
        if (projectInnovate != null ? !projectInnovate.equals(tProject.projectInnovate) : tProject.projectInnovate != null)
            return false;
        if (projectIntroduction != null ? !projectIntroduction.equals(tProject.projectIntroduction) : tProject.projectIntroduction != null)
            return false;
        if (projectLabname != null ? !projectLabname.equals(tProject.projectLabname) : tProject.projectLabname != null)
            return false;
        if (projectLabtype != null ? !projectLabtype.equals(tProject.projectLabtype) : tProject.projectLabtype != null)
            return false;
        if (projectLeader != null ? !projectLeader.equals(tProject.projectLeader) : tProject.projectLeader != null)
            return false;
        if (projectLine != null ? !projectLine.equals(tProject.projectLine) : tProject.projectLine != null)
            return false;
        if (projectName != null ? !projectName.equals(tProject.projectName) : tProject.projectName != null)
            return false;
        if (projectNumber != null ? !projectNumber.equals(tProject.projectNumber) : tProject.projectNumber != null)
            return false;
        if (projectProgress != null ? !projectProgress.equals(tProject.projectProgress) : tProject.projectProgress != null)
            return false;
        if (projectScore != null ? !projectScore.equals(tProject.projectScore) : tProject.projectScore != null)
            return false;
        if (projectSense != null ? !projectSense.equals(tProject.projectSense) : tProject.projectSense != null)
            return false;
        if (projectState != null ? !projectState.equals(tProject.projectState) : tProject.projectState != null)
            return false;
        if (projectTeacher1 != null ? !projectTeacher1.equals(tProject.projectTeacher1) : tProject.projectTeacher1 != null)
            return false;
        if (projectTeacher2 != null ? !projectTeacher2.equals(tProject.projectTeacher2) : tProject.projectTeacher2 != null)
            return false;
        if (projectUser1 != null ? !projectUser1.equals(tProject.projectUser1) : tProject.projectUser1 != null)
            return false;
        if (projectUser2 != null ? !projectUser2.equals(tProject.projectUser2) : tProject.projectUser2 != null)
            return false;
        if (projectWork != null ? !projectWork.equals(tProject.projectWork) : tProject.projectWork != null)
            return false;
        if (redmineProjectid != null ? !redmineProjectid.equals(tProject.redmineProjectid) : tProject.redmineProjectid != null)
            return false;
        if (unitId != null ? !unitId.equals(tProject.unitId) : tProject.unitId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = projectId != null ? projectId.hashCode() : 0;
        result = 31 * result + (projectTeacher2 != null ? projectTeacher2.hashCode() : 0);
        result = 31 * result + (projectTeacher1 != null ? projectTeacher1.hashCode() : 0);
        result = 31 * result + (jqId != null ? jqId.hashCode() : 0);
        result = 31 * result + (projectLeader != null ? projectLeader.hashCode() : 0);
        result = 31 * result + (declarId != null ? declarId.hashCode() : 0);
        result = 31 * result + (projectUser2 != null ? projectUser2.hashCode() : 0);
        result = 31 * result + (unitId != null ? unitId.hashCode() : 0);
        result = 31 * result + (projectUser1 != null ? projectUser1.hashCode() : 0);
        result = 31 * result + (projectLine != null ? projectLine.hashCode() : 0);
        result = 31 * result + (projectState != null ? projectState.hashCode() : 0);
        result = 31 * result + (projectNumber != null ? projectNumber.hashCode() : 0);
        result = 31 * result + (projectSense != null ? projectSense.hashCode() : 0);
        result = 31 * result + (projectContent != null ? projectContent.hashCode() : 0);
        result = 31 * result + (projectLabtype != null ? projectLabtype.hashCode() : 0);
        result = 31 * result + (projectLabname != null ? projectLabname.hashCode() : 0);
        result = 31 * result + (projectName != null ? projectName.hashCode() : 0);
        result = 31 * result + (projectIntroduction != null ? projectIntroduction.hashCode() : 0);
        result = 31 * result + (projectFund != null ? projectFund.hashCode() : 0);
        result = 31 * result + (projectBegintime != null ? projectBegintime.hashCode() : 0);
        result = 31 * result + (projectEndtime != null ? projectEndtime.hashCode() : 0);
        result = 31 * result + (projectInnovate != null ? projectInnovate.hashCode() : 0);
        result = 31 * result + (projectCondition != null ? projectCondition.hashCode() : 0);
        result = 31 * result + (projectProgress != null ? projectProgress.hashCode() : 0);
        result = 31 * result + (projectGoal != null ? projectGoal.hashCode() : 0);
        result = 31 * result + (projectAchievement != null ? projectAchievement.hashCode() : 0);
        result = 31 * result + (projectWork != null ? projectWork.hashCode() : 0);
        result = 31 * result + (redmineProjectid != null ? redmineProjectid.hashCode() : 0);
        result = 31 * result + (projectScore != null ? projectScore.hashCode() : 0);
        result = 31 * result + (isdeleted != null ? isdeleted.hashCode() : 0);
        return result;
    }
}
