package edu.cqu.no1.domain;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Created by ZKQ on 2015/5/27.
 */
@Entity
@javax.persistence.Table(name = "t_declaration", schema = "", catalog = "srtp")
public class TDeclaration {
    private String declarId;

    @Id
    @javax.persistence.Column(name = "DECLAR_ID")
    public String getDeclarId() {
        return declarId;
    }

    public void setDeclarId(String declarId) {
        this.declarId = declarId;
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

    private String teacher2Code;

    @Basic
    @javax.persistence.Column(name = "TEACHER2_CODE")
    public String getTeacher2Code() {
        return teacher2Code;
    }

    public void setTeacher2Code(String teacher2Code) {
        this.teacher2Code = teacher2Code;
    }

    private String teacher1Code;

    @Basic
    @javax.persistence.Column(name = "TEACHER1_CODE")
    public String getTeacher1Code() {
        return teacher1Code;
    }

    public void setTeacher1Code(String teacher1Code) {
        this.teacher1Code = teacher1Code;
    }

    private String member2Code;

    @Basic
    @javax.persistence.Column(name = "MEMBER2_CODE")
    public String getMember2Code() {
        return member2Code;
    }

    public void setMember2Code(String member2Code) {
        this.member2Code = member2Code;
    }

    private String member1Code;

    @Basic
    @javax.persistence.Column(name = "MEMBER1_CODE")
    public String getMember1Code() {
        return member1Code;
    }

    public void setMember1Code(String member1Code) {
        this.member1Code = member1Code;
    }

    private String college;

    @Basic
    @javax.persistence.Column(name = "COLLEGE")
    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    private String leaderCode;

    @Basic
    @javax.persistence.Column(name = "LEADER_CODE")
    public String getLeaderCode() {
        return leaderCode;
    }

    public void setLeaderCode(String leaderCode) {
        this.leaderCode = leaderCode;
    }

    private String proSerial;

    @Basic
    @javax.persistence.Column(name = "PRO_SERIAL")
    public String getProSerial() {
        return proSerial;
    }

    public void setProSerial(String proSerial) {
        this.proSerial = proSerial;
    }

    private String proName;

    @Basic
    @javax.persistence.Column(name = "PRO_NAME")
    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    private String labLevel;

    @Basic
    @javax.persistence.Column(name = "LAB_LEVEL")
    public String getLabLevel() {
        return labLevel;
    }

    public void setLabLevel(String labLevel) {
        this.labLevel = labLevel;
    }

    private String labName;

    @Basic
    @javax.persistence.Column(name = "LAB_NAME")
    public String getLabName() {
        return labName;
    }

    public void setLabName(String labName) {
        this.labName = labName;
    }

    private Integer memberAmount;

    @Basic
    @javax.persistence.Column(name = "MEMBER_AMOUNT")
    public Integer getMemberAmount() {
        return memberAmount;
    }

    public void setMemberAmount(Integer memberAmount) {
        this.memberAmount = memberAmount;
    }

    private Timestamp startOn;

    @Basic
    @javax.persistence.Column(name = "START_ON")
    public Timestamp getStartOn() {
        return startOn;
    }

    public void setStartOn(Timestamp startOn) {
        this.startOn = startOn;
    }

    private Timestamp endOn;

    @Basic
    @javax.persistence.Column(name = "END_ON")
    public Timestamp getEndOn() {
        return endOn;
    }

    public void setEndOn(Timestamp endOn) {
        this.endOn = endOn;
    }

    private Timestamp declTime;

    @Basic
    @javax.persistence.Column(name = "DECL_TIME")
    public Timestamp getDeclTime() {
        return declTime;
    }

    public void setDeclTime(Timestamp declTime) {
        this.declTime = declTime;
    }

    private String checkState;

    @Basic
    @javax.persistence.Column(name = "CHECK_STATE")
    public String getCheckState() {
        return checkState;
    }

    public void setCheckState(String checkState) {
        this.checkState = checkState;
    }

    private String proIntro;

    @Basic
    @javax.persistence.Column(name = "PRO_INTRO")
    public String getProIntro() {
        return proIntro;
    }

    public void setProIntro(String proIntro) {
        this.proIntro = proIntro;
    }

    private String resContent;

    @Basic
    @javax.persistence.Column(name = "RES_CONTENT")
    public String getResContent() {
        return resContent;
    }

    public void setResContent(String resContent) {
        this.resContent = resContent;
    }

    private String proAdv;

    @Basic
    @javax.persistence.Column(name = "PRO_ADV")
    public String getProAdv() {
        return proAdv;
    }

    public void setProAdv(String proAdv) {
        this.proAdv = proAdv;
    }

    private String resProgram;

    @Basic
    @javax.persistence.Column(name = "RES_PROGRAM")
    public String getResProgram() {
        return resProgram;
    }

    public void setResProgram(String resProgram) {
        this.resProgram = resProgram;
    }

    private String innoPoint;

    @Basic
    @javax.persistence.Column(name = "INNO_POINT")
    public String getInnoPoint() {
        return innoPoint;
    }

    public void setInnoPoint(String innoPoint) {
        this.innoPoint = innoPoint;
    }

    private String resCondition;

    @Basic
    @javax.persistence.Column(name = "RES_CONDITION")
    public String getResCondition() {
        return resCondition;
    }

    public void setResCondition(String resCondition) {
        this.resCondition = resCondition;
    }

    private String proPlan;

    @Basic
    @javax.persistence.Column(name = "PRO_PLAN")
    public String getProPlan() {
        return proPlan;
    }

    public void setProPlan(String proPlan) {
        this.proPlan = proPlan;
    }

    private String expResult;

    @Basic
    @javax.persistence.Column(name = "EXP_RESULT")
    public String getExpResult() {
        return expResult;
    }

    public void setExpResult(String expResult) {
        this.expResult = expResult;
    }

    private String expTarget;

    @Basic
    @javax.persistence.Column(name = "EXP_TARGET")
    public String getExpTarget() {
        return expTarget;
    }

    public void setExpTarget(String expTarget) {
        this.expTarget = expTarget;
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

    private String proType;

    @Basic
    @javax.persistence.Column(name = "PRO_TYPE")
    public String getProType() {
        return proType;
    }

    public void setProType(String proType) {
        this.proType = proType;
    }

    private Double proFund;

    @Basic
    @javax.persistence.Column(name = "PRO_FUND")
    public Double getProFund() {
        return proFund;
    }

    public void setProFund(Double proFund) {
        this.proFund = proFund;
    }

    private String reviewOpinion;

    @Basic
    @javax.persistence.Column(name = "REVIEW_OPINION")
    public String getReviewOpinion() {
        return reviewOpinion;
    }

    public void setReviewOpinion(String reviewOpinion) {
        this.reviewOpinion = reviewOpinion;
    }

    private String reviewResult;

    @Basic
    @javax.persistence.Column(name = "REVIEW_RESULT")
    public String getReviewResult() {
        return reviewResult;
    }

    public void setReviewResult(String reviewResult) {
        this.reviewResult = reviewResult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TDeclaration that = (TDeclaration) o;

        if (checkState != null ? !checkState.equals(that.checkState) : that.checkState != null) return false;
        if (college != null ? !college.equals(that.college) : that.college != null) return false;
        if (declTime != null ? !declTime.equals(that.declTime) : that.declTime != null) return false;
        if (declarId != null ? !declarId.equals(that.declarId) : that.declarId != null) return false;
        if (endOn != null ? !endOn.equals(that.endOn) : that.endOn != null) return false;
        if (expResult != null ? !expResult.equals(that.expResult) : that.expResult != null) return false;
        if (expTarget != null ? !expTarget.equals(that.expTarget) : that.expTarget != null) return false;
        if (innoPoint != null ? !innoPoint.equals(that.innoPoint) : that.innoPoint != null) return false;
        if (isdeleted != null ? !isdeleted.equals(that.isdeleted) : that.isdeleted != null) return false;
        if (jqId != null ? !jqId.equals(that.jqId) : that.jqId != null) return false;
        if (labLevel != null ? !labLevel.equals(that.labLevel) : that.labLevel != null) return false;
        if (labName != null ? !labName.equals(that.labName) : that.labName != null) return false;
        if (leaderCode != null ? !leaderCode.equals(that.leaderCode) : that.leaderCode != null) return false;
        if (member1Code != null ? !member1Code.equals(that.member1Code) : that.member1Code != null) return false;
        if (member2Code != null ? !member2Code.equals(that.member2Code) : that.member2Code != null) return false;
        if (memberAmount != null ? !memberAmount.equals(that.memberAmount) : that.memberAmount != null) return false;
        if (proAdv != null ? !proAdv.equals(that.proAdv) : that.proAdv != null) return false;
        if (proFund != null ? !proFund.equals(that.proFund) : that.proFund != null) return false;
        if (proIntro != null ? !proIntro.equals(that.proIntro) : that.proIntro != null) return false;
        if (proName != null ? !proName.equals(that.proName) : that.proName != null) return false;
        if (proPlan != null ? !proPlan.equals(that.proPlan) : that.proPlan != null) return false;
        if (proSerial != null ? !proSerial.equals(that.proSerial) : that.proSerial != null) return false;
        if (proType != null ? !proType.equals(that.proType) : that.proType != null) return false;
        if (resCondition != null ? !resCondition.equals(that.resCondition) : that.resCondition != null) return false;
        if (resContent != null ? !resContent.equals(that.resContent) : that.resContent != null) return false;
        if (resProgram != null ? !resProgram.equals(that.resProgram) : that.resProgram != null) return false;
        if (reviewOpinion != null ? !reviewOpinion.equals(that.reviewOpinion) : that.reviewOpinion != null)
            return false;
        if (reviewResult != null ? !reviewResult.equals(that.reviewResult) : that.reviewResult != null) return false;
        if (startOn != null ? !startOn.equals(that.startOn) : that.startOn != null) return false;
        if (teacher1Code != null ? !teacher1Code.equals(that.teacher1Code) : that.teacher1Code != null) return false;
        if (teacher2Code != null ? !teacher2Code.equals(that.teacher2Code) : that.teacher2Code != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = declarId != null ? declarId.hashCode() : 0;
        result = 31 * result + (jqId != null ? jqId.hashCode() : 0);
        result = 31 * result + (teacher2Code != null ? teacher2Code.hashCode() : 0);
        result = 31 * result + (teacher1Code != null ? teacher1Code.hashCode() : 0);
        result = 31 * result + (member2Code != null ? member2Code.hashCode() : 0);
        result = 31 * result + (member1Code != null ? member1Code.hashCode() : 0);
        result = 31 * result + (college != null ? college.hashCode() : 0);
        result = 31 * result + (leaderCode != null ? leaderCode.hashCode() : 0);
        result = 31 * result + (proSerial != null ? proSerial.hashCode() : 0);
        result = 31 * result + (proName != null ? proName.hashCode() : 0);
        result = 31 * result + (labLevel != null ? labLevel.hashCode() : 0);
        result = 31 * result + (labName != null ? labName.hashCode() : 0);
        result = 31 * result + (memberAmount != null ? memberAmount.hashCode() : 0);
        result = 31 * result + (startOn != null ? startOn.hashCode() : 0);
        result = 31 * result + (endOn != null ? endOn.hashCode() : 0);
        result = 31 * result + (declTime != null ? declTime.hashCode() : 0);
        result = 31 * result + (checkState != null ? checkState.hashCode() : 0);
        result = 31 * result + (proIntro != null ? proIntro.hashCode() : 0);
        result = 31 * result + (resContent != null ? resContent.hashCode() : 0);
        result = 31 * result + (proAdv != null ? proAdv.hashCode() : 0);
        result = 31 * result + (resProgram != null ? resProgram.hashCode() : 0);
        result = 31 * result + (innoPoint != null ? innoPoint.hashCode() : 0);
        result = 31 * result + (resCondition != null ? resCondition.hashCode() : 0);
        result = 31 * result + (proPlan != null ? proPlan.hashCode() : 0);
        result = 31 * result + (expResult != null ? expResult.hashCode() : 0);
        result = 31 * result + (expTarget != null ? expTarget.hashCode() : 0);
        result = 31 * result + (isdeleted != null ? isdeleted.hashCode() : 0);
        result = 31 * result + (proType != null ? proType.hashCode() : 0);
        result = 31 * result + (proFund != null ? proFund.hashCode() : 0);
        result = 31 * result + (reviewOpinion != null ? reviewOpinion.hashCode() : 0);
        result = 31 * result + (reviewResult != null ? reviewResult.hashCode() : 0);
        return result;
    }
}
