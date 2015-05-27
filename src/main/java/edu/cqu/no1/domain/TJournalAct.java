package edu.cqu.no1.domain;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by ZKQ on 2015/5/27.
 */
@Entity
@Table(name = "t_journal_act", schema = "", catalog = "srtp")
public class TJournalAct {
    private String journalactId;
    private String journalId;
    private String journalactType;
    private String journalactIntroduction;
    private Timestamp time;
    private String journalactRemark;
    private String isdeleted;
    private String userId;

    @Id
    @Column(name = "JOURNALACT_ID")
    public String getJournalactId() {
        return journalactId;
    }

    public void setJournalactId(String journalactId) {
        this.journalactId = journalactId;
    }

    @Basic
    @Column(name = "JOURNAL_ID")
    public String getJournalId() {
        return journalId;
    }

    public void setJournalId(String journalId) {
        this.journalId = journalId;
    }

    @Basic
    @Column(name = "JOURNALACT_TYPE")
    public String getJournalactType() {
        return journalactType;
    }

    public void setJournalactType(String journalactType) {
        this.journalactType = journalactType;
    }

    @Basic
    @Column(name = "JOURNALACT_INTRODUCTION")
    public String getJournalactIntroduction() {
        return journalactIntroduction;
    }

    public void setJournalactIntroduction(String journalactIntroduction) {
        this.journalactIntroduction = journalactIntroduction;
    }

    @Basic
    @Column(name = "TIME")
    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Basic
    @Column(name = "JOURNALACT_REMARK")
    public String getJournalactRemark() {
        return journalactRemark;
    }

    public void setJournalactRemark(String journalactRemark) {
        this.journalactRemark = journalactRemark;
    }

    @Basic
    @Column(name = "ISDELETED")
    public String getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(String isdeleted) {
        this.isdeleted = isdeleted;
    }

    @Basic
    @Column(name = "USER_ID")
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

        if (isdeleted != null ? !isdeleted.equals(that.isdeleted) : that.isdeleted != null) return false;
        if (journalId != null ? !journalId.equals(that.journalId) : that.journalId != null) return false;
        if (journalactId != null ? !journalactId.equals(that.journalactId) : that.journalactId != null) return false;
        if (journalactIntroduction != null ? !journalactIntroduction.equals(that.journalactIntroduction) : that.journalactIntroduction != null)
            return false;
        if (journalactRemark != null ? !journalactRemark.equals(that.journalactRemark) : that.journalactRemark != null)
            return false;
        if (journalactType != null ? !journalactType.equals(that.journalactType) : that.journalactType != null)
            return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = journalactId != null ? journalactId.hashCode() : 0;
        result = 31 * result + (journalId != null ? journalId.hashCode() : 0);
        result = 31 * result + (journalactType != null ? journalactType.hashCode() : 0);
        result = 31 * result + (journalactIntroduction != null ? journalactIntroduction.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (journalactRemark != null ? journalactRemark.hashCode() : 0);
        result = 31 * result + (isdeleted != null ? isdeleted.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }
}
