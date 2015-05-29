package edu.cqu.no1.domain;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Created by Huxley on 5/29/15.
 */
@Entity
@javax.persistence.Table(name = "t_end_project", schema = "", catalog = "srtp")
public class TEndProject {
    private Timestamp schoolTypeinTime;

    @Basic
    @javax.persistence.Column(name = "SCHOOL_TYPEIN_TIME")
    public Timestamp getSchoolTypeinTime() {
        return schoolTypeinTime;
    }

    public void setSchoolTypeinTime(Timestamp schoolTypeinTime) {
        this.schoolTypeinTime = schoolTypeinTime;
    }

    private Timestamp unitTypeinTime;

    @Basic
    @javax.persistence.Column(name = "UNIT_TYPEIN_TIME")
    public Timestamp getUnitTypeinTime() {
        return unitTypeinTime;
    }

    public void setUnitTypeinTime(Timestamp unitTypeinTime) {
        this.unitTypeinTime = unitTypeinTime;
    }

    private Timestamp submitTime;

    @Basic
    @javax.persistence.Column(name = "SUBMIT_TIME")
    public Timestamp getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Timestamp submitTime) {
        this.submitTime = submitTime;
    }

    private String endProjectId;

    @Id
    @javax.persistence.Column(name = "endProject_id")
    public String getEndProjectId() {
        return endProjectId;
    }

    public void setEndProjectId(String endProjectId) {
        this.endProjectId = endProjectId;
    }

    private String projectId;

    @Basic
    @javax.persistence.Column(name = "project_id")
    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    private String jqId;

    @Basic
    @javax.persistence.Column(name = "jq_id")
    public String getJqId() {
        return jqId;
    }

    public void setJqId(String jqId) {
        this.jqId = jqId;
    }

    private String endProjectState;

    @Basic
    @javax.persistence.Column(name = "endProject_state")
    public String getEndProjectState() {
        return endProjectState;
    }

    public void setEndProjectState(String endProjectState) {
        this.endProjectState = endProjectState;
    }

    private String endProjectSummary;

    @Basic
    @javax.persistence.Column(name = "endProject_summary")
    public String getEndProjectSummary() {
        return endProjectSummary;
    }

    public void setEndProjectSummary(String endProjectSummary) {
        this.endProjectSummary = endProjectSummary;
    }

    private String endProjectMethod;

    @Basic
    @javax.persistence.Column(name = "endProject_method")
    public String getEndProjectMethod() {
        return endProjectMethod;
    }

    public void setEndProjectMethod(String endProjectMethod) {
        this.endProjectMethod = endProjectMethod;
    }

    private String endProjectScore;

    @Basic
    @javax.persistence.Column(name = "endProject_score")
    public String getEndProjectScore() {
        return endProjectScore;
    }

    public void setEndProjectScore(String endProjectScore) {
        this.endProjectScore = endProjectScore;
    }

    private String lastScore;

    @Basic
    @javax.persistence.Column(name = "last_score")
    public String getLastScore() {
        return lastScore;
    }

    public void setLastScore(String lastScore) {
        this.lastScore = lastScore;
    }

    private String endProjectNumber;

    @Basic
    @javax.persistence.Column(name = "endProject_number")
    public String getEndProjectNumber() {
        return endProjectNumber;
    }

    public void setEndProjectNumber(String endProjectNumber) {
        this.endProjectNumber = endProjectNumber;
    }

    private String lastComment;

    @Basic
    @javax.persistence.Column(name = "last_comment")
    public String getLastComment() {
        return lastComment;
    }

    public void setLastComment(String lastComment) {
        this.lastComment = lastComment;
    }

    private String endProjectComment;

    @Basic
    @javax.persistence.Column(name = "endProject_comment")
    public String getEndProjectComment() {
        return endProjectComment;
    }

    public void setEndProjectComment(String endProjectComment) {
        this.endProjectComment = endProjectComment;
    }

    private String endProjectName;

    @Basic
    @javax.persistence.Column(name = "endProject_name")
    public String getEndProjectName() {
        return endProjectName;
    }

    public void setEndProjectName(String endProjectName) {
        this.endProjectName = endProjectName;
    }

    private String endProjectSense;

    @Basic
    @javax.persistence.Column(name = "endProject_sense")
    public String getEndProjectSense() {
        return endProjectSense;
    }

    public void setEndProjectSense(String endProjectSense) {
        this.endProjectSense = endProjectSense;
    }

    private String endProjectContent;

    @Basic
    @javax.persistence.Column(name = "endProject_content")
    public String getEndProjectContent() {
        return endProjectContent;
    }

    public void setEndProjectContent(String endProjectContent) {
        this.endProjectContent = endProjectContent;
    }

    private Float endProjectCredit;

    @Basic
    @javax.persistence.Column(name = "endProject_credit")
    public Float getEndProjectCredit() {
        return endProjectCredit;
    }

    public void setEndProjectCredit(Float endProjectCredit) {
        this.endProjectCredit = endProjectCredit;
    }

    private String endProjectProblem;

    @Basic
    @javax.persistence.Column(name = "endProject_problem")
    public String getEndProjectProblem() {
        return endProjectProblem;
    }

    public void setEndProjectProblem(String endProjectProblem) {
        this.endProjectProblem = endProjectProblem;
    }

    private String endProjectInnovate;

    @Basic
    @javax.persistence.Column(name = "endProject_innovate")
    public String getEndProjectInnovate() {
        return endProjectInnovate;
    }

    public void setEndProjectInnovate(String endProjectInnovate) {
        this.endProjectInnovate = endProjectInnovate;
    }

    private String endProjectIntroduction;

    @Basic
    @javax.persistence.Column(name = "endProject_introduction")
    public String getEndProjectIntroduction() {
        return endProjectIntroduction;
    }

    public void setEndProjectIntroduction(String endProjectIntroduction) {
        this.endProjectIntroduction = endProjectIntroduction;
    }

    private String endProjectWork;

    @Basic
    @javax.persistence.Column(name = "endProject_work")
    public String getEndProjectWork() {
        return endProjectWork;
    }

    public void setEndProjectWork(String endProjectWork) {
        this.endProjectWork = endProjectWork;
    }

    private String isdeleted;

    @Basic
    @javax.persistence.Column(name = "isdeleted")
    public String getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(String isdeleted) {
        this.isdeleted = isdeleted;
    }

    private String endProjectPassApply;

    @Basic
    @javax.persistence.Column(name = "endProject_passApply")
    public String getEndProjectPassApply() {
        return endProjectPassApply;
    }

    public void setEndProjectPassApply(String endProjectPassApply) {
        this.endProjectPassApply = endProjectPassApply;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TEndProject that = (TEndProject) o;

        if (schoolTypeinTime != null ? !schoolTypeinTime.equals(that.schoolTypeinTime) : that.schoolTypeinTime != null)
            return false;
        if (unitTypeinTime != null ? !unitTypeinTime.equals(that.unitTypeinTime) : that.unitTypeinTime != null)
            return false;
        if (submitTime != null ? !submitTime.equals(that.submitTime) : that.submitTime != null) return false;
        if (endProjectId != null ? !endProjectId.equals(that.endProjectId) : that.endProjectId != null) return false;
        if (projectId != null ? !projectId.equals(that.projectId) : that.projectId != null) return false;
        if (jqId != null ? !jqId.equals(that.jqId) : that.jqId != null) return false;
        if (endProjectState != null ? !endProjectState.equals(that.endProjectState) : that.endProjectState != null)
            return false;
        if (endProjectSummary != null ? !endProjectSummary.equals(that.endProjectSummary) : that.endProjectSummary != null)
            return false;
        if (endProjectMethod != null ? !endProjectMethod.equals(that.endProjectMethod) : that.endProjectMethod != null)
            return false;
        if (endProjectScore != null ? !endProjectScore.equals(that.endProjectScore) : that.endProjectScore != null)
            return false;
        if (lastScore != null ? !lastScore.equals(that.lastScore) : that.lastScore != null) return false;
        if (endProjectNumber != null ? !endProjectNumber.equals(that.endProjectNumber) : that.endProjectNumber != null)
            return false;
        if (lastComment != null ? !lastComment.equals(that.lastComment) : that.lastComment != null) return false;
        if (endProjectComment != null ? !endProjectComment.equals(that.endProjectComment) : that.endProjectComment != null)
            return false;
        if (endProjectName != null ? !endProjectName.equals(that.endProjectName) : that.endProjectName != null)
            return false;
        if (endProjectSense != null ? !endProjectSense.equals(that.endProjectSense) : that.endProjectSense != null)
            return false;
        if (endProjectContent != null ? !endProjectContent.equals(that.endProjectContent) : that.endProjectContent != null)
            return false;
        if (endProjectCredit != null ? !endProjectCredit.equals(that.endProjectCredit) : that.endProjectCredit != null)
            return false;
        if (endProjectProblem != null ? !endProjectProblem.equals(that.endProjectProblem) : that.endProjectProblem != null)
            return false;
        if (endProjectInnovate != null ? !endProjectInnovate.equals(that.endProjectInnovate) : that.endProjectInnovate != null)
            return false;
        if (endProjectIntroduction != null ? !endProjectIntroduction.equals(that.endProjectIntroduction) : that.endProjectIntroduction != null)
            return false;
        if (endProjectWork != null ? !endProjectWork.equals(that.endProjectWork) : that.endProjectWork != null)
            return false;
        if (isdeleted != null ? !isdeleted.equals(that.isdeleted) : that.isdeleted != null) return false;
        if (endProjectPassApply != null ? !endProjectPassApply.equals(that.endProjectPassApply) : that.endProjectPassApply != null)
            return false;
        if (unitId != null ? !unitId.equals(that.unitId) : that.unitId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = schoolTypeinTime != null ? schoolTypeinTime.hashCode() : 0;
        result = 31 * result + (unitTypeinTime != null ? unitTypeinTime.hashCode() : 0);
        result = 31 * result + (submitTime != null ? submitTime.hashCode() : 0);
        result = 31 * result + (endProjectId != null ? endProjectId.hashCode() : 0);
        result = 31 * result + (projectId != null ? projectId.hashCode() : 0);
        result = 31 * result + (jqId != null ? jqId.hashCode() : 0);
        result = 31 * result + (endProjectState != null ? endProjectState.hashCode() : 0);
        result = 31 * result + (endProjectSummary != null ? endProjectSummary.hashCode() : 0);
        result = 31 * result + (endProjectMethod != null ? endProjectMethod.hashCode() : 0);
        result = 31 * result + (endProjectScore != null ? endProjectScore.hashCode() : 0);
        result = 31 * result + (lastScore != null ? lastScore.hashCode() : 0);
        result = 31 * result + (endProjectNumber != null ? endProjectNumber.hashCode() : 0);
        result = 31 * result + (lastComment != null ? lastComment.hashCode() : 0);
        result = 31 * result + (endProjectComment != null ? endProjectComment.hashCode() : 0);
        result = 31 * result + (endProjectName != null ? endProjectName.hashCode() : 0);
        result = 31 * result + (endProjectSense != null ? endProjectSense.hashCode() : 0);
        result = 31 * result + (endProjectContent != null ? endProjectContent.hashCode() : 0);
        result = 31 * result + (endProjectCredit != null ? endProjectCredit.hashCode() : 0);
        result = 31 * result + (endProjectProblem != null ? endProjectProblem.hashCode() : 0);
        result = 31 * result + (endProjectInnovate != null ? endProjectInnovate.hashCode() : 0);
        result = 31 * result + (endProjectIntroduction != null ? endProjectIntroduction.hashCode() : 0);
        result = 31 * result + (endProjectWork != null ? endProjectWork.hashCode() : 0);
        result = 31 * result + (isdeleted != null ? isdeleted.hashCode() : 0);
        result = 31 * result + (endProjectPassApply != null ? endProjectPassApply.hashCode() : 0);
        result = 31 * result + (unitId != null ? unitId.hashCode() : 0);
        return result;
    }
}
