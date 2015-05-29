package edu.cqu.no1.domain;

import javax.persistence.*;

/**
 * Created by Huxley on 5/29/15.
 */
@Entity
@Table(name = "t_funds", schema = "", catalog = "srtp")
public class TFunds {
    private String id;
    private String projectId;
    private String fundsId;
    private String fundsName;
    private String fundsIsReimburse;
    private Float fundsMoney;
    private String fundsDetail;
    private String fundsUse;
    private String isdeleted;

    @Id
    @Column(name = "ID")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "project_id")
    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    @Basic
    @Column(name = "funds_id")
    public String getFundsId() {
        return fundsId;
    }

    public void setFundsId(String fundsId) {
        this.fundsId = fundsId;
    }

    @Basic
    @Column(name = "funds_name")
    public String getFundsName() {
        return fundsName;
    }

    public void setFundsName(String fundsName) {
        this.fundsName = fundsName;
    }

    @Basic
    @Column(name = "funds_isReimburse")
    public String getFundsIsReimburse() {
        return fundsIsReimburse;
    }

    public void setFundsIsReimburse(String fundsIsReimburse) {
        this.fundsIsReimburse = fundsIsReimburse;
    }

    @Basic
    @Column(name = "funds_money")
    public Float getFundsMoney() {
        return fundsMoney;
    }

    public void setFundsMoney(Float fundsMoney) {
        this.fundsMoney = fundsMoney;
    }

    @Basic
    @Column(name = "funds_detail")
    public String getFundsDetail() {
        return fundsDetail;
    }

    public void setFundsDetail(String fundsDetail) {
        this.fundsDetail = fundsDetail;
    }

    @Basic
    @Column(name = "funds_use")
    public String getFundsUse() {
        return fundsUse;
    }

    public void setFundsUse(String fundsUse) {
        this.fundsUse = fundsUse;
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

        TFunds tFunds = (TFunds) o;

        if (id != null ? !id.equals(tFunds.id) : tFunds.id != null) return false;
        if (projectId != null ? !projectId.equals(tFunds.projectId) : tFunds.projectId != null) return false;
        if (fundsId != null ? !fundsId.equals(tFunds.fundsId) : tFunds.fundsId != null) return false;
        if (fundsName != null ? !fundsName.equals(tFunds.fundsName) : tFunds.fundsName != null) return false;
        if (fundsIsReimburse != null ? !fundsIsReimburse.equals(tFunds.fundsIsReimburse) : tFunds.fundsIsReimburse != null)
            return false;
        if (fundsMoney != null ? !fundsMoney.equals(tFunds.fundsMoney) : tFunds.fundsMoney != null) return false;
        if (fundsDetail != null ? !fundsDetail.equals(tFunds.fundsDetail) : tFunds.fundsDetail != null) return false;
        if (fundsUse != null ? !fundsUse.equals(tFunds.fundsUse) : tFunds.fundsUse != null) return false;
        if (isdeleted != null ? !isdeleted.equals(tFunds.isdeleted) : tFunds.isdeleted != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (projectId != null ? projectId.hashCode() : 0);
        result = 31 * result + (fundsId != null ? fundsId.hashCode() : 0);
        result = 31 * result + (fundsName != null ? fundsName.hashCode() : 0);
        result = 31 * result + (fundsIsReimburse != null ? fundsIsReimburse.hashCode() : 0);
        result = 31 * result + (fundsMoney != null ? fundsMoney.hashCode() : 0);
        result = 31 * result + (fundsDetail != null ? fundsDetail.hashCode() : 0);
        result = 31 * result + (fundsUse != null ? fundsUse.hashCode() : 0);
        result = 31 * result + (isdeleted != null ? isdeleted.hashCode() : 0);
        return result;
    }
}
