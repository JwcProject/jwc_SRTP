package edu.cqu.no1.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by Huxley on 5/29/15.
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
    private TJieqi tJieqiByJqId;
    private TTeacher tTeacherByTeaId;
    private Collection<TEmailReceiver> tEmailReceiversByEmailId;

    @Id
    @Column(name = "email_id")
    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    @Basic
    @Column(name = "jq_id")
    public String getJqId() {
        return jqId;
    }

    public void setJqId(String jqId) {
        this.jqId = jqId;
    }

    @Basic
    @Column(name = "tea_id")
    public String getTeaId() {
        return teaId;
    }

    public void setTeaId(String teaId) {
        this.teaId = teaId;
    }

    @Basic
    @Column(name = "email_title")
    public String getEmailTitle() {
        return emailTitle;
    }

    public void setEmailTitle(String emailTitle) {
        this.emailTitle = emailTitle;
    }

    @Basic
    @Column(name = "email_content")
    public String getEmailContent() {
        return emailContent;
    }

    public void setEmailContent(String emailContent) {
        this.emailContent = emailContent;
    }

    @Basic
    @Column(name = "sender")
    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    @Basic
    @Column(name = "email_secret")
    public String getEmailSecret() {
        return emailSecret;
    }

    public void setEmailSecret(String emailSecret) {
        this.emailSecret = emailSecret;
    }

    @Basic
    @Column(name = "creat_on")
    public Timestamp getCreatOn() {
        return creatOn;
    }

    public void setCreatOn(Timestamp creatOn) {
        this.creatOn = creatOn;
    }

    @Basic
    @Column(name = "send_state")
    public String getSendState() {
        return sendState;
    }

    public void setSendState(String sendState) {
        this.sendState = sendState;
    }

    @Basic
    @Column(name = "send_on")
    public Timestamp getSendOn() {
        return sendOn;
    }

    public void setSendOn(Timestamp sendOn) {
        this.sendOn = sendOn;
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

        TEmail tEmail = (TEmail) o;

        if (emailId != null ? !emailId.equals(tEmail.emailId) : tEmail.emailId != null) return false;
        if (jqId != null ? !jqId.equals(tEmail.jqId) : tEmail.jqId != null) return false;
        if (teaId != null ? !teaId.equals(tEmail.teaId) : tEmail.teaId != null) return false;
        if (emailTitle != null ? !emailTitle.equals(tEmail.emailTitle) : tEmail.emailTitle != null) return false;
        if (emailContent != null ? !emailContent.equals(tEmail.emailContent) : tEmail.emailContent != null)
            return false;
        if (sender != null ? !sender.equals(tEmail.sender) : tEmail.sender != null) return false;
        if (emailSecret != null ? !emailSecret.equals(tEmail.emailSecret) : tEmail.emailSecret != null) return false;
        if (creatOn != null ? !creatOn.equals(tEmail.creatOn) : tEmail.creatOn != null) return false;
        if (sendState != null ? !sendState.equals(tEmail.sendState) : tEmail.sendState != null) return false;
        if (sendOn != null ? !sendOn.equals(tEmail.sendOn) : tEmail.sendOn != null) return false;
        if (isdeleted != null ? !isdeleted.equals(tEmail.isdeleted) : tEmail.isdeleted != null) return false;

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

    @ManyToOne
    @JoinColumn(name = "jq_id", referencedColumnName = "jq_id")
    public TJieqi gettJieqiByJqId() {
        return tJieqiByJqId;
    }

    public void settJieqiByJqId(TJieqi tJieqiByJqId) {
        this.tJieqiByJqId = tJieqiByJqId;
    }

    @ManyToOne
    @JoinColumn(name = "tea_id", referencedColumnName = "tea_id")
    public TTeacher gettTeacherByTeaId() {
        return tTeacherByTeaId;
    }

    public void settTeacherByTeaId(TTeacher tTeacherByTeaId) {
        this.tTeacherByTeaId = tTeacherByTeaId;
    }

    @OneToMany(mappedBy = "tEmailByEmailId")
    public Collection<TEmailReceiver> gettEmailReceiversByEmailId() {
        return tEmailReceiversByEmailId;
    }

    public void settEmailReceiversByEmailId(Collection<TEmailReceiver> tEmailReceiversByEmailId) {
        this.tEmailReceiversByEmailId = tEmailReceiversByEmailId;
    }
}
