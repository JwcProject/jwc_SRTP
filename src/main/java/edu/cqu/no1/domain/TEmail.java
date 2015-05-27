package edu.cqu.no1.domain;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by ZKQ on 2015/5/27.
 */
@Entity
@Table(name = "t_email", schema = "", catalog = "srtp")
public class TEmail {
    private String emailId;
    private String jqId;
    private String teaId;
    private String emailTitle;
    private String emailContent;
    private String sender;
    private String emailSecret;
    private Timestamp creatOn;
    private String sendState;
    private Timestamp sendOn;
    private String isdeleted;

    @Id
    @Column(name = "EMAIL_ID")
    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    @Basic
    @Column(name = "JQ_ID")
    public String getJqId() {
        return jqId;
    }

    public void setJqId(String jqId) {
        this.jqId = jqId;
    }

    @Basic
    @Column(name = "TEA_ID")
    public String getTeaId() {
        return teaId;
    }

    public void setTeaId(String teaId) {
        this.teaId = teaId;
    }

    @Basic
    @Column(name = "EMAIL_TITLE")
    public String getEmailTitle() {
        return emailTitle;
    }

    public void setEmailTitle(String emailTitle) {
        this.emailTitle = emailTitle;
    }

    @Basic
    @Column(name = "EMAIL_CONTENT")
    public String getEmailContent() {
        return emailContent;
    }

    public void setEmailContent(String emailContent) {
        this.emailContent = emailContent;
    }

    @Basic
    @Column(name = "SENDER")
    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    @Basic
    @Column(name = "EMAIL_SECRET")
    public String getEmailSecret() {
        return emailSecret;
    }

    public void setEmailSecret(String emailSecret) {
        this.emailSecret = emailSecret;
    }

    @Basic
    @Column(name = "CREAT_ON")
    public Timestamp getCreatOn() {
        return creatOn;
    }

    public void setCreatOn(Timestamp creatOn) {
        this.creatOn = creatOn;
    }

    @Basic
    @Column(name = "SEND_STATE")
    public String getSendState() {
        return sendState;
    }

    public void setSendState(String sendState) {
        this.sendState = sendState;
    }

    @Basic
    @Column(name = "SEND_ON")
    public Timestamp getSendOn() {
        return sendOn;
    }

    public void setSendOn(Timestamp sendOn) {
        this.sendOn = sendOn;
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

        TEmail tEmail = (TEmail) o;

        if (creatOn != null ? !creatOn.equals(tEmail.creatOn) : tEmail.creatOn != null) return false;
        if (emailContent != null ? !emailContent.equals(tEmail.emailContent) : tEmail.emailContent != null)
            return false;
        if (emailId != null ? !emailId.equals(tEmail.emailId) : tEmail.emailId != null) return false;
        if (emailSecret != null ? !emailSecret.equals(tEmail.emailSecret) : tEmail.emailSecret != null) return false;
        if (emailTitle != null ? !emailTitle.equals(tEmail.emailTitle) : tEmail.emailTitle != null) return false;
        if (isdeleted != null ? !isdeleted.equals(tEmail.isdeleted) : tEmail.isdeleted != null) return false;
        if (jqId != null ? !jqId.equals(tEmail.jqId) : tEmail.jqId != null) return false;
        if (sendOn != null ? !sendOn.equals(tEmail.sendOn) : tEmail.sendOn != null) return false;
        if (sendState != null ? !sendState.equals(tEmail.sendState) : tEmail.sendState != null) return false;
        if (sender != null ? !sender.equals(tEmail.sender) : tEmail.sender != null) return false;
        if (teaId != null ? !teaId.equals(tEmail.teaId) : tEmail.teaId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = emailId != null ? emailId.hashCode() : 0;
        result = 31 * result + (jqId != null ? jqId.hashCode() : 0);
        result = 31 * result + (teaId != null ? teaId.hashCode() : 0);
        result = 31 * result + (emailTitle != null ? emailTitle.hashCode() : 0);
        result = 31 * result + (emailContent != null ? emailContent.hashCode() : 0);
        result = 31 * result + (sender != null ? sender.hashCode() : 0);
        result = 31 * result + (emailSecret != null ? emailSecret.hashCode() : 0);
        result = 31 * result + (creatOn != null ? creatOn.hashCode() : 0);
        result = 31 * result + (sendState != null ? sendState.hashCode() : 0);
        result = 31 * result + (sendOn != null ? sendOn.hashCode() : 0);
        result = 31 * result + (isdeleted != null ? isdeleted.hashCode() : 0);
        return result;
    }
}
