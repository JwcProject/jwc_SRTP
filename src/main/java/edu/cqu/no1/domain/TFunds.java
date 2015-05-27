package edu.cqu.no1.domain;

import javax.persistence.*;

/**
 * Created by ZKQ on 2015/5/27.
 */
@Entity
@Table(name = "t_funds", schema = "", catalog = "srtp")
public class TFunds {
    private String id;
    private String projectId;
    private String fundsId;
    private String fundsName;
    private String fundsIsreimburse;
    private Double fundsMoney;
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
    @Column(name = "PROJECT_ID")
    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    @Basic
    @Column(name = "FUNDS_ID")
    public String getFundsId() {
        return fundsId;
    }

    public void setFundsId(String fundsId) {
        this.fundsId = fundsId;
    }

    @Basic
    @Column(name = "FUNDS_NAME")
    public String getFundsName() {
        return fundsName;
    }

    public void setFundsName(String fundsName) {
        this.fundsName = fundsName;
    }

    @Basic
    @Column(name = "FUNDS_ISREIMBURSE")
    public String getFundsIsreimburse() {
        return fundsIsreimburse;
    }

    public void setFundsIsreimburse(String fundsIsreimburse) {
        this.fundsIsreimburse = fundsIsreimburse;
    }

    @Basic
    @Column(name = "FUNDS_MONEY")
    public Double getFundsMoney() {
        return fundsMoney;
    }

    public void setFundsMoney(Double fundsMoney) {
        this.fundsMoney = fundsMoney;
    }

    @Basic
    @Column(name = "FUNDS_DETAIL")
    public String getFundsDetail() {
        return fundsDetail;
    }

    public void setFundsDetail(String fundsDetail) {
        this.fundsDetail = fundsDetail;
    }

    @Basic
    @Column(name = "FUNDS_USE")
    public String getFundsUse() {
        return fundsUse;
    }

    public void setFundsUse(String fundsUse) {
        this.fundsUse = fundsUse;
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

        TFunds tFunds = (TFunds) o;

        if (fundsDetail != null ? !fundsDetail.equals(tFunds.fundsDetail) : tFunds.fundsDetail != null) return false;
        if (fundsId != null ? !fundsId.equals(tFunds.fundsId) : tFunds.fundsId != null) return false;
        if (fundsIsreimburse != null ? !fundsIsreimburse.equals(tFunds.fundsIsreimburse) : tFunds.fundsIsreimburse != null)
            return false;
        if (fundsMoney != null ? !fundsMoney.equals(tFunds.fundsMoney) : tFunds.fundsMoney != null) return false;
        if (fundsName != null ? !fundsName.equals(tFunds.fundsName) : tFunds.fundsName != null) return false;
        if (fundsUse != null ? !fundsUse.equals(tFunds.fundsUse) : tFunds.fundsUse != null) return false;
        if (id != null ? !id.equals(tFunds.id) : tFunds.id != null) return false;
        if (isdeleted != null ? !isdeleted.equals(tFunds.isdeleted) : tFunds.isdeleted != null) return false;
        if (projectId != null ? !projectId.equals(tFunds.projectId) : tFunds.projectId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (projectId != null ? projectId.hashCode() : 0);
        result = 31 * result + (fundsId != null ? fundsId.hashCode() : 0);
        result = 31 * result + (fundsName != null ? fundsName.hashCode() : 0);
        result = 31 * result + (fundsIsreimburse != null ? fundsIsreimburse.hashCode() : 0);
        result = 31 * result + (fundsMoney != null ? fundsMoney.hashCode() : 0);
        result = 31 * result + (fundsDetail != null ? fundsDetail.hashCode() : 0);
        result = 31 * result + (fundsUse != null ? fundsUse.hashCode() : 0);
        result = 31 * result + (isdeleted != null ? isdeleted.hashCode() : 0);
        return result;
    }
}
