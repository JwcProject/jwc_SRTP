package edu.cqu.no1.domain;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Created by ZKQ on 2015/5/27.
 */
@Entity
@javax.persistence.Table(name = "t_end_project", schema = "", catalog = "srtp")
public class TEndProject {
    private String endprojectId;

    @Id
    @javax.persistence.Column(name = "ENDPROJECT_ID")
    public String getEndprojectId() {
        return endprojectId;
    }

    public void setEndprojectId(String endprojectId) {
        this.endprojectId = endprojectId;
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

    private String projectId;

    @Basic
    @javax.persistence.Column(name = "PROJECT_ID")
    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
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

    private String endprojectState;

    @Basic
    @javax.persistence.Column(name = "ENDPROJECT_STATE")
    public String getEndprojectState() {
        return endprojectState;
    }

    public void setEndprojectState(String endprojectState) {
        this.endprojectState = endprojectState;
    }

    private String endprojectSummary;

    @Basic
    @javax.persistence.Column(name = "ENDPROJECT_SUMMARY")
    public String getEndprojectSummary() {
        return endprojectSummary;
    }

    public void setEndprojectSummary(String endprojectSummary) {
        this.endprojectSummary = endprojectSummary;
    }

    private String endprojectMethod;

    @Basic
    @javax.persistence.Column(name = "ENDPROJECT_METHOD")
    public String getEndprojectMethod() {
        return endprojectMethod;
    }

    public void setEndprojectMethod(String endprojectMethod) {
        this.endprojectMethod = endprojectMethod;
    }

    private String endprojectScore;

    @Basic
    @javax.persistence.Column(name = "ENDPROJECT_SCORE")
    public String getEndprojectScore() {
        return endprojectScore;
    }

    public void setEndprojectScore(String endprojectScore) {
        this.endprojectScore = endprojectScore;
    }

    private String lastScore;

    @Basic
    @javax.persistence.Column(name = "LAST_SCORE")
    public String getLastScore() {
        return lastScore;
    }

    public void setLastScore(String lastScore) {
        this.lastScore = lastScore;
    }

    private String endprojectNumber;

    @Basic
    @javax.persistence.Column(name = "ENDPROJECT_NUMBER")
    public String getEndprojectNumber() {
        return endprojectNumber;
    }

    public void setEndprojectNumber(String endprojectNumber) {
        this.endprojectNumber = endprojectNumber;
    }

    private String lastComment;

    @Basic
    @javax.persistence.Column(name = "LAST_COMMENT")
    public String getLastComment() {
        return lastComment;
    }

    public void setLastComment(String lastComment) {
        this.lastComment = lastComment;
    }

    private String endprojectComment;

    @Basic
    @javax.persistence.Column(name = "ENDPROJECT_COMMENT")
    public String getEndprojectComment() {
        return endprojectComment;
    }

    public void setEndprojectComment(String endprojectComment) {
        this.endprojectComment = endprojectComment;
    }

    private String endprojectName;

    @Basic
    @javax.persistence.Column(name = "ENDPROJECT_NAME")
    public String getEndprojectName() {
        return endprojectName;
    }

    public void setEndprojectName(String endprojectName) {
        this.endprojectName = endprojectName;
    }

    private String endprojectSense;

    @Basic
    @javax.persistence.Column(name = "ENDPROJECT_SENSE")
    public String getEndprojectSense() {
        return endprojectSense;
    }

    public void setEndprojectSense(String endprojectSense) {
        this.endprojectSense = endprojectSense;
    }

    private String endprojectContent;

    @Basic
    @javax.persistence.Column(name = "ENDPROJECT_CONTENT")
    public String getEndprojectContent() {
        return endprojectContent;
    }

    public void setEndprojectContent(String endprojectContent) {
        this.endprojectContent = endprojectContent;
    }

    private Double endprojectCredit;

    @Basic
    @javax.persistence.Column(name = "ENDPROJECT_CREDIT")
    public Double getEndprojectCredit() {
        return endprojectCredit;
    }

    public void setEndprojectCredit(Double endprojectCredit) {
        this.endprojectCredit = endprojectCredit;
    }

    private String endprojectProblem;

    @Basic
    @javax.persistence.Column(name = "ENDPROJECT_PROBLEM")
    public String getEndprojectProblem() {
        return endprojectProblem;
    }

    public void setEndprojectProblem(String endprojectProblem) {
        this.endprojectProblem = endprojectProblem;
    }

    private String endprojectInnovate;

    @Basic
    @javax.persistence.Column(name = "ENDPROJECT_INNOVATE")
    public String getEndprojectInnovate() {
        return endprojectInnovate;
    }

    public void setEndprojectInnovate(String endprojectInnovate) {
        this.endprojectInnovate = endprojectInnovate;
    }

    private String endprojectIntroduction;

    @Basic
    @javax.persistence.Column(name = "ENDPROJECT_INTRODUCTION")
    public String getEndprojectIntroduction() {
        return endprojectIntroduction;
    }

    public void setEndprojectIntroduction(String endprojectIntroduction) {
        this.endprojectIntroduction = endprojectIntroduction;
    }

    private String endprojectWork;

    @Basic
    @javax.persistence.Column(name = "ENDPROJECT_WORK")
    public String getEndprojectWork() {
        return endprojectWork;
    }

    public void setEndprojectWork(String endprojectWork) {
        this.endprojectWork = endprojectWork;
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

    private String endprojectPassapply;

    @Basic
    @javax.persistence.Column(name = "ENDPROJECT_PASSAPPLY")
    public String getEndprojectPassapply() {
        return endprojectPassapply;
    }

    public void setEndprojectPassapply(String endprojectPassapply) {
        this.endprojectPassapply = endprojectPassapply;
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

    private Timestamp unitTypeinTime;

    @Basic
    @javax.persistence.Column(name = "UNIT_TYPEIN_TIME")
    public Timestamp getUnitTypeinTime() {
        return unitTypeinTime;
    }

    public void setUnitTypeinTime(Timestamp unitTypeinTime) {
        this.unitTypeinTime = unitTypeinTime;
    }

    private Timestamp schoolTypeinTime;

    @Basic
    @javax.persistence.Column(name = "SCHOOL_TYPEIN_TIME")
    public Timestamp getSchoolTypeinTime() {
        return schoolTypeinTime;
    }

    public void setSchoolTypeinTime(Timestamp schoolTypeinTime) {
        this.schoolTypeinTime = schoolTypeinTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TEndProject that = (TEndProject) o;

        if (endprojectComment != null ? !endprojectComment.equals(that.endprojectComment) : that.endprojectComment != null)
            return false;
        if (endprojectContent != null ? !endprojectContent.equals(that.endprojectContent) : that.endprojectContent != null)
            return false;
        if (endprojectCredit != null ? !endprojectCredit.equals(that.endprojectCredit) : that.endprojectCredit != null)
            return false;
        if (endprojectId != null ? !endprojectId.equals(that.endprojectId) : that.endprojectId != null) return false;
        if (endprojectInnovate != null ? !endprojectInnovate.equals(that.endprojectInnovate) : that.endprojectInnovate != null)
            return false;
        if (endprojectIntroduction != null ? !endprojectIntroduction.equals(that.endprojectIntroduction) : that.endprojectIntroduction != null)
            return false;
        if (endprojectMethod != null ? !endprojectMethod.equals(that.endprojectMethod) : that.endprojectMethod != null)
            return false;
        if (endprojectName != null ? !endprojectName.equals(that.endprojectName) : that.endprojectName != null)
            return false;
        if (endprojectNumber != null ? !endprojectNumber.equals(that.endprojectNumber) : that.endprojectNumber != null)
            return false;
        if (endprojectPassapply != null ? !endprojectPassapply.equals(that.endprojectPassapply) : that.endprojectPassapply != null)
            return false;
        if (endprojectProblem != null ? !endprojectProblem.equals(that.endprojectProblem) : that.endprojectProblem != null)
            return false;
        if (endprojectScore != null ? !endprojectScore.equals(that.endprojectScore) : that.endprojectScore != null)
            return false;
        if (endprojectSense != null ? !endprojectSense.equals(that.endprojectSense) : that.endprojectSense != null)
            return false;
        if (endprojectState != null ? !endprojectState.equals(that.endprojectState) : that.endprojectState != null)
            return false;
        if (endprojectSummary != null ? !endprojectSummary.equals(that.endprojectSummary) : that.endprojectSummary != null)
            return false;
        if (endprojectWork != null ? !endprojectWork.equals(that.endprojectWork) : that.endprojectWork != null)
            return false;
        if (isdeleted != null ? !isdeleted.equals(that.isdeleted) : that.isdeleted != null) return false;
        if (jqId != null ? !jqId.equals(that.jqId) : that.jqId != null) return false;
        if (lastComment != null ? !lastComment.equals(that.lastComment) : that.lastComment != null) return false;
        if (lastScore != null ? !lastScore.equals(that.lastScore) : that.lastScore != null) return false;
        if (projectId != null ? !projectId.equals(that.projectId) : that.projectId != null) return false;
        if (schoolTypeinTime != null ? !schoolTypeinTime.equals(that.schoolTypeinTime) : that.schoolTypeinTime != null)
            return false;
        if (submitTime != null ? !submitTime.equals(that.submitTime) : that.submitTime != null) return false;
        if (unitId != null ? !unitId.equals(that.unitId) : that.unitId != null) return false;
        if (unitTypeinTime != null ? !unitTypeinTime.equals(that.unitTypeinTime) : that.unitTypeinTime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = endprojectId != null ? endprojectId.hashCode() : 0;
        result = 31 * result + (jqId != null ? jqId.hashCode() : 0);
        result = 31 * result + (projectId != null ? projectId.hashCode() : 0);
        result = 31 * result + (unitId != null ? unitId.hashCode() : 0);
        result = 31 * result + (endprojectState != null ? endprojectState.hashCode() : 0);
        result = 31 * result + (endprojectSummary != null ? endprojectSummary.hashCode() : 0);
        result = 31 * result + (endprojectMethod != null ? endprojectMethod.hashCode() : 0);
        result = 31 * result + (endprojectScore != null ? endprojectScore.hashCode() : 0);
        result = 31 * result + (lastScore != null ? lastScore.hashCode() : 0);
        result = 31 * result + (endprojectNumber != null ? endprojectNumber.hashCode() : 0);
        result = 31 * result + (lastComment != null ? lastComment.hashCode() : 0);
        result = 31 * result + (endprojectComment != null ? endprojectComment.hashCode() : 0);
        result = 31 * result + (endprojectName != null ? endprojectName.hashCode() : 0);
        result = 31 * result + (endprojectSense != null ? endprojectSense.hashCode() : 0);
        result = 31 * result + (endprojectContent != null ? endprojectContent.hashCode() : 0);
        result = 31 * result + (endprojectCredit != null ? endprojectCredit.hashCode() : 0);
        result = 31 * result + (endprojectProblem != null ? endprojectProblem.hashCode() : 0);
        result = 31 * result + (endprojectInnovate != null ? endprojectInnovate.hashCode() : 0);
        result = 31 * result + (endprojectIntroduction != null ? endprojectIntroduction.hashCode() : 0);
        result = 31 * result + (endprojectWork != null ? endprojectWork.hashCode() : 0);
        result = 31 * result + (isdeleted != null ? isdeleted.hashCode() : 0);
        result = 31 * result + (endprojectPassapply != null ? endprojectPassapply.hashCode() : 0);
        result = 31 * result + (submitTime != null ? submitTime.hashCode() : 0);
        result = 31 * result + (unitTypeinTime != null ? unitTypeinTime.hashCode() : 0);
        result = 31 * result + (schoolTypeinTime != null ? schoolTypeinTime.hashCode() : 0);
        return result;
    }
}
