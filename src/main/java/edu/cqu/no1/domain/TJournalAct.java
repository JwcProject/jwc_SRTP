package edu.cqu.no1.domain;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Huxley on 5/29/15.
 */
@Entity
@Table(name = "t_journal_act", schema = "", catalog = "srtp")
public class TJournalAct {
    private String journalActId;
    private String journalId;
    private String journalActType;
    private String journalActIntroduction;
    private Timestamp time;
    private String journalActRemark;
    private String isdeleted;
    private String userId;
    private TJournal tJournalByJournalId;

    @Id
    @Column(name = "journalAct_id")
    public String getJournalActId() {
        return journalActId;
    }

    public void setJournalActId(String journalActId) {
        this.journalActId = journalActId;
    }

    @Basic
    @Column(name = "journal_id")
    public String getJournalId() {
        return journalId;
    }

    public void setJournalId(String journalId) {
        this.journalId = journalId;
    }

    @Basic
    @Column(name = "journalAct_type")
    public String getJournalActType() {
        return journalActType;
    }

    public void setJournalActType(String journalActType) {
        this.journalActType = journalActType;
    }

    @Basic
    @Column(name = "journalAct_introduction")
    public String getJournalActIntroduction() {
        return journalActIntroduction;
    }

    public void setJournalActIntroduction(String journalActIntroduction) {
        this.journalActIntroduction = journalActIntroduction;
    }

    @Basic
    @Column(name = "time")
    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Basic
    @Column(name = "journalAct_remark")
    public String getJournalActRemark() {
        return journalActRemark;
    }

    public void setJournalActRemark(String journalActRemark) {
        this.journalActRemark = journalActRemark;
    }

    @Basic
    @Column(name = "isdeleted")
    public String getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(String isdeleted) {
        this.isdeleted = isdeleted;
    }

    @Basic
    @Column(name = "user_id")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TJournalAct that = (TJournalAct) o;

        if (journalActId != null ? !journalActId.equals(that.journalActId) : that.journalActId != null) return false;
        if (journalId != null ? !journalId.equals(that.journalId) : that.journalId != null) return false;
        if (journalActType != null ? !journalActType.equals(that.journalActType) : that.journalActType != null)
            return false;
        if (journalActIntroduction != null ? !journalActIntroduction.equals(that.journalActIntroduction) : that.journalActIntroduction != null)
            return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (journalActRemark != null ? !journalActRemark.equals(that.journalActRemark) : that.journalActRemark != null)
            return false;
        if (isdeleted != null ? !isdeleted.equals(that.isdeleted) : that.isdeleted != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = journalActId != null ? journalActId.hashCode() : 0;
        result = 31 * result + (journalId != null ? journalId.hashCode() : 0);
        result = 31 * result + (journalActType != null ? journalActType.hashCode() : 0);
        result = 31 * result + (journalActIntroduction != null ? journalActIntroduction.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (journalActRemark != null ? journalActRemark.hashCode() : 0);
        result = 31 * result + (isdeleted != null ? isdeleted.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "journal_id", referencedColumnName = "journal_id")
    public TJournal gettJournalByJournalId() {
        return tJournalByJournalId;
    }

    public void settJournalByJournalId(TJournal tJournalByJournalId) {
        this.tJournalByJournalId = tJournalByJournalId;
    }
}
