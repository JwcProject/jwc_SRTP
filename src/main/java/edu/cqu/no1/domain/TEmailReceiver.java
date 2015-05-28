package edu.cqu.no1.domain;

import javax.persistence.*;

/**
 * Created by ZKQ on 2015/5/27.
 */
@Entity
@Table(name = "t_email_receiver", schema = "", catalog = "srtp")
public class TEmailReceiver {
    private String receiverId;
    private String emailId;
    private String receiverCode;
    private String receiverRole;
    private String emailAddress;
    private String isReceived;
    private String isdeleted;

    @Id
    @Column(name = "RECEIVER_ID")
    public String getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }

    @Basic
    @Column(name = "EMAIL_ID")
    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    @Basic
    @Column(name = "RECEIVER_CODE")
    public String getReceiverCode() {
        return receiverCode;
    }

    public void setReceiverCode(String receiverCode) {
        this.receiverCode = receiverCode;
    }

    @Basic
    @Column(name = "RECEIVER_ROLE")
    public String getReceiverRole() {
        return receiverRole;
    }

    public void setReceiverRole(String receiverRole) {
        this.receiverRole = receiverRole;
    }

    @Basic
    @Column(name = "EMAIL_ADDRESS")
    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Basic
    @Column(name = "IS_RECEIVED")
    public String getIsReceived() {
        return isReceived;
    }

    public void setIsReceived(String isReceived) {
        this.isReceived = isReceived;
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

        TEmailReceiver that = (TEmailReceiver) o;

        if (emailAddress != null ? !emailAddress.equals(that.emailAddress) : that.emailAddress != null) return false;
        if (emailId != null ? !emailId.equals(that.emailId) : that.emailId != null) return false;
        if (isReceived != null ? !isReceived.equals(that.isReceived) : that.isReceived != null) return false;
        if (isdeleted != null ? !isdeleted.equals(that.isdeleted) : that.isdeleted != null) return false;
        if (receiverCode != null ? !receiverCode.equals(that.receiverCode) : that.receiverCode != null) return false;
        if (receiverId != null ? !receiverId.equals(that.receiverId) : that.receiverId != null) return false;
        if (receiverRole != null ? !receiverRole.equals(that.receiverRole) : that.receiverRole != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = receiverId != null ? receiverId.hashCode() : 0;
        result = 31 * result + (emailId != null ? emailId.hashCode() : 0);
        result = 31 * result + (receiverCode != null ? receiverCode.hashCode() : 0);
        result = 31 * result + (receiverRole != null ? receiverRole.hashCode() : 0);
        result = 31 * result + (emailAddress != null ? emailAddress.hashCode() : 0);
        result = 31 * result + (isReceived != null ? isReceived.hashCode() : 0);
        result = 31 * result + (isdeleted != null ? isdeleted.hashCode() : 0);
        return result;
    }
}