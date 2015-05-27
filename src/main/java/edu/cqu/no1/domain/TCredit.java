package edu.cqu.no1.domain;

import javax.persistence.*;

/**
 * Created by ZKQ on 2015/5/27.
 */
@Entity
@Table(name = "t_credit", schema = "", catalog = "srtp")
public class TCredit {
    private String creditId;
    private String projectId;
    private Integer creditContribution;
    private Double creditScore;
    private String isdeleted;

    @Id
    @Column(name = "CREDIT_ID")
    public String getCreditId() {
        return creditId;
    }

    public void setCreditId(String creditId) {
        this.creditId = creditId;
    }

    @Basic
    @Column(name = "PROJECT_ID")
    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    @Basic
    @Column(name = "CREDIT_CONTRIBUTION")
    public Integer getCreditContribution() {
        return creditContribution;
    }

    public void setCreditContribution(Integer creditContribution) {
        this.creditContribution = creditContribution;
    }

    @Basic
    @Column(name = "CREDIT_SCORE")
    public Double getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(Double creditScore) {
        this.creditScore = creditScore;
    }

    @Basic
    @Column(name = "ISDELETED")
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

        TCredit tCredit = (TCredit) o;

        if (creditContribution != null ? !creditContribution.equals(tCredit.creditContribution) : tCredit.creditContribution != null)
            return false;
        if (creditId != null ? !creditId.equals(tCredit.creditId) : tCredit.creditId != null) return false;
        if (creditScore != null ? !creditScore.equals(tCredit.creditScore) : tCredit.creditScore != null) return false;
        if (isdeleted != null ? !isdeleted.equals(tCredit.isdeleted) : tCredit.isdeleted != null) return false;
        if (projectId != null ? !projectId.equals(tCredit.projectId) : tCredit.projectId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = creditId != null ? creditId.hashCode() : 0;
        result = 31 * result + (projectId != null ? projectId.hashCode() : 0);
        result = 31 * result + (creditContribution != null ? creditContribution.hashCode() : 0);
        result = 31 * result + (creditScore != null ? creditScore.hashCode() : 0);
        result = 31 * result + (isdeleted != null ? isdeleted.hashCode() : 0);
        return result;
    }
}
