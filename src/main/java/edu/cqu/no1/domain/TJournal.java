package edu.cqu.no1.domain;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by ZKQ on 2015/5/27.
 */
@Entity
@Table(name = "t_journal", schema = "", catalog = "srtp")
public class TJournal {
    private String journalId;
    private String userId;
    private String userName;
    private Timestamp journalLogintime;
    private Timestamp journalQuitime;
    private String journalRemark;
    private String isdeleted;
    private String journalLoginip;

    @Id
    @Column(name = "JOURNAL_ID")
    public String getJournalId() {
        return journalId;
    }

    public void setJournalId(String journalId) {
        this.journalId = journalId;
    }

    @Basic
    @Column(name = "USER_ID")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "USER_NAME")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "JOURNAL_LOGINTIME")
    public Timestamp getJournalLogintime() {
        return journalLogintime;
    }

    public void setJournalLogintime(Timestamp journalLogintime) {
        this.journalLogintime = journalLogintime;
    }

    @Basic
    @Column(name = "JOURNAL_QUITIME")
    public Timestamp getJournalQuitime() {
        return journalQuitime;
    }

    public void setJournalQuitime(Timestamp journalQuitime) {
        this.journalQuitime = journalQuitime;
    }

    @Basic
    @Column(name = "JOURNAL_REMARK")
    public String getJournalRemark() {
        return journalRemark;
    }

    public void setJournalRemark(String journalRemark) {
        this.journalRemark = journalRemark;
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
    @Column(name = "JOURNAL_LOGINIP")
    public String getJournalLoginip() {
        return journalLoginip;
    }

    public void setJournalLoginip(String journalLoginip) {
        this.journalLoginip = journalLoginip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TJournal tJournal = (TJournal) o;

        if (isdeleted != null ? !isdeleted.equals(tJournal.isdeleted) : tJournal.isdeleted != null) return false;
        if (journalId != null ? !journalId.equals(tJournal.journalId) : tJournal.journalId != null) return false;
        if (journalLoginip != null ? !journalLoginip.equals(tJournal.journalLoginip) : tJournal.journalLoginip != null)
            return false;
        if (journalLogintime != null ? !journalLogintime.equals(tJournal.journalLogintime) : tJournal.journalLogintime != null)
            return false;
        if (journalQuitime != null ? !journalQuitime.equals(tJournal.journalQuitime) : tJournal.journalQuitime != null)
            return false;
        if (journalRemark != null ? !journalRemark.equals(tJournal.journalRemark) : tJournal.journalRemark != null)
            return false;
        if (userId != null ? !userId.equals(tJournal.userId) : tJournal.userId != null) return false;
        if (userName != null ? !userName.equals(tJournal.userName) : tJournal.userName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = journalId != null ? journalId.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (journalLogintime != null ? journalLogintime.hashCode() : 0);
        result = 31 * result + (journalQuitime != null ? journalQuitime.hashCode() : 0);
        result = 31 * result + (journalRemark != null ? journalRemark.hashCode() : 0);
        result = 31 * result + (isdeleted != null ? isdeleted.hashCode() : 0);
        result = 31 * result + (journalLoginip != null ? journalLoginip.hashCode() : 0);
        return result;
    }
}
