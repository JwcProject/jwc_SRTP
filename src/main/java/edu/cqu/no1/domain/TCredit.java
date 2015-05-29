package edu.cqu.no1.domain;

import javax.persistence.*;

/**
 * Created by Huxley on 5/29/15.
 */
@Entity
@Table(name = "t_credit", schema = "", catalog = "srtp")
public class TCredit {
    private String projectId;
    private String creditId;
    private Integer creditContribution;
    private Float creditScore;
    private String isdeleted;

    @Basic
    @Column(name = "project_id")
    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    @Id
    @Column(name = "credit_id")
    public String getCreditId() {
        return creditId;
    }

    public void setCreditId(String creditId) {
        this.creditId = creditId;
    }

    @Basic
    @Column(name = "credit_contribution")
    public Integer getCreditContribution() {
        return creditContribution;
    }

    public void setCreditContribution(Integer creditContribution) {
        this.creditContribution = creditContribution;
    }

    @Basic
    @Column(name = "credit_score")
    public Float getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(Float creditScore) {
        this.creditScore = creditScore;
    }

    @Basic
    @Column(name = "isdeleted")
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

        if (projectId != null ? !projectId.equals(tCredit.projectId) : tCredit.projectId != null) return false;
        if (creditId != null ? !creditId.equals(tCredit.creditId) : tCredit.creditId != null) return false;
        if (creditContribution != null ? !creditContribution.equals(tCredit.creditContribution) : tCredit.creditContribution != null)
            return false;
        if (creditScore != null ? !creditScore.equals(tCredit.creditScore) : tCredit.creditScore != null) return false;
        if (isdeleted != null ? !isdeleted.equals(tCredit.isdeleted) : tCredit.isdeleted != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = projectId != null ? projectId.hashCode() : 0;
        result = 31 * result + (creditId != null ? creditId.hashCode() : 0);
        result = 31 * result + (creditContribution != null ? creditContribution.hashCode() : 0);
        result = 31 * result + (creditScore != null ? creditScore.hashCode() : 0);
        result = 31 * result + (isdeleted != null ? isdeleted.hashCode() : 0);
        return result;
    }
}
