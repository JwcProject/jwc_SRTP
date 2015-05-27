package edu.cqu.no1.domain;

import javax.persistence.*;

/**
 * Created by ZKQ on 2015/5/27.
 */
@Entity
@Table(name = "t_decl_fund", schema = "", catalog = "srtp")
public class TDeclFund {
    private String declFundId;
    private String declarId;
    private String serialNum;
    private String fundContent;
    private Double amount;
    private String isdeleted;

    @Id
    @Column(name = "DECL_FUND_ID")
    public String getDeclFundId() {
        return declFundId;
    }

    public void setDeclFundId(String declFundId) {
        this.declFundId = declFundId;
    }

    @Basic
    @Column(name = "DECLAR_ID")
    public String getDeclarId() {
        return declarId;
    }

    public void setDeclarId(String declarId) {
        this.declarId = declarId;
    }

    @Basic
    @Column(name = "SERIAL_NUM")
    public String getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum;
    }

    @Basic
    @Column(name = "FUND_CONTENT")
    public String getFundContent() {
        return fundContent;
    }

    public void setFundContent(String fundContent) {
        this.fundContent = fundContent;
    }

    @Basic
    @Column(name = "AMOUNT")
    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
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

        TDeclFund tDeclFund = (TDeclFund) o;

        if (amount != null ? !amount.equals(tDeclFund.amount) : tDeclFund.amount != null) return false;
        if (declFundId != null ? !declFundId.equals(tDeclFund.declFundId) : tDeclFund.declFundId != null) return false;
        if (declarId != null ? !declarId.equals(tDeclFund.declarId) : tDeclFund.declarId != null) return false;
        if (fundContent != null ? !fundContent.equals(tDeclFund.fundContent) : tDeclFund.fundContent != null)
            return false;
        if (isdeleted != null ? !isdeleted.equals(tDeclFund.isdeleted) : tDeclFund.isdeleted != null) return false;
        if (serialNum != null ? !serialNum.equals(tDeclFund.serialNum) : tDeclFund.serialNum != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = declFundId != null ? declFundId.hashCode() : 0;
        result = 31 * result + (declarId != null ? declarId.hashCode() : 0);
        result = 31 * result + (serialNum != null ? serialNum.hashCode() : 0);
        result = 31 * result + (fundContent != null ? fundContent.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (isdeleted != null ? isdeleted.hashCode() : 0);
        return result;
    }
}
