package edu.cqu.no1.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Created by ZKQ on 2015/5/27.
 */
@Entity
public class Tannouncementmodel {
    private String announId;
    private String announTypeId;
    private String announTitle;
    private String announContent;
    private String publisherCode;
    private String publisherRole;
    private Timestamp publishTime;
    private String publishState;
    private String checkerCode;
    private Timestamp checkTime;
    private String checkState;
    private String isdeleted;
    private String publishername;

    @Id
    @Column(name = "ANNOUN_ID")
    public String getAnnounId() {
        return announId;
    }

    public void setAnnounId(String announId) {
        this.announId = announId;
    }

    @Basic
    @Column(name = "ANNOUN_TYPE_ID")
    public String getAnnounTypeId() {
        return announTypeId;
    }

    public void setAnnounTypeId(String announTypeId) {
        this.announTypeId = announTypeId;
    }

    @Basic
    @Column(name = "ANNOUN_TITLE")
    public String getAnnounTitle() {
        return announTitle;
    }

    public void setAnnounTitle(String announTitle) {
        this.announTitle = announTitle;
    }

    @Basic
    @Column(name = "ANNOUN_CONTENT")
    public String getAnnounContent() {
        return announContent;
    }

    public void setAnnounContent(String announContent) {
        this.announContent = announContent;
    }

    @Basic
    @Column(name = "PUBLISHER_CODE")
    public String getPublisherCode() {
        return publisherCode;
    }

    public void setPublisherCode(String publisherCode) {
        this.publisherCode = publisherCode;
    }

    @Basic
    @Column(name = "PUBLISHER_ROLE")
    public String getPublisherRole() {
        return publisherRole;
    }

    public void setPublisherRole(String publisherRole) {
        this.publisherRole = publisherRole;
    }

    @Basic
    @Column(name = "PUBLISH_TIME")
    public Timestamp getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Timestamp publishTime) {
        this.publishTime = publishTime;
    }

    @Basic
    @Column(name = "PUBLISH_STATE")
    public String getPublishState() {
        return publishState;
    }

    public void setPublishState(String publishState) {
        this.publishState = publishState;
    }

    @Basic
    @Column(name = "CHECKER_CODE")
    public String getCheckerCode() {
        return checkerCode;
    }

    public void setCheckerCode(String checkerCode) {
        this.checkerCode = checkerCode;
    }

    @Basic
    @Column(name = "CHECK_TIME")
    public Timestamp getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Timestamp checkTime) {
        this.checkTime = checkTime;
    }

    @Basic
    @Column(name = "CHECK_STATE")
    public String getCheckState() {
        return checkState;
    }

    public void setCheckState(String checkState) {
        this.checkState = checkState;
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
    @Column(name = "PUBLISHERNAME")
    public String getPublishername() {
        return publishername;
    }

    public void setPublishername(String publishername) {
        this.publishername = publishername;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tannouncementmodel that = (Tannouncementmodel) o;

        if (announContent != null ? !announContent.equals(that.announContent) : that.announContent != null)
            return false;
        if (announId != null ? !announId.equals(that.announId) : that.announId != null) return false;
        if (announTitle != null ? !announTitle.equals(that.announTitle) : that.announTitle != null) return false;
        if (announTypeId != null ? !announTypeId.equals(that.announTypeId) : that.announTypeId != null) return false;
        if (checkState != null ? !checkState.equals(that.checkState) : that.checkState != null) return false;
        if (checkTime != null ? !checkTime.equals(that.checkTime) : that.checkTime != null) return false;
        if (checkerCode != null ? !checkerCode.equals(that.checkerCode) : that.checkerCode != null) return false;
        if (isdeleted != null ? !isdeleted.equals(that.isdeleted) : that.isdeleted != null) return false;
        if (publishState != null ? !publishState.equals(that.publishState) : that.publishState != null) return false;
        if (publishTime != null ? !publishTime.equals(that.publishTime) : that.publishTime != null) return false;
        if (publisherCode != null ? !publisherCode.equals(that.publisherCode) : that.publisherCode != null)
            return false;
        if (publisherRole != null ? !publisherRole.equals(that.publisherRole) : that.publisherRole != null)
            return false;
        if (publishername != null ? !publishername.equals(that.publishername) : that.publishername != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = announId != null ? announId.hashCode() : 0;
        result = 31 * result + (announTypeId != null ? announTypeId.hashCode() : 0);
        result = 31 * result + (announTitle != null ? announTitle.hashCode() : 0);
        result = 31 * result + (announContent != null ? announContent.hashCode() : 0);
        result = 31 * result + (publisherCode != null ? publisherCode.hashCode() : 0);
        result = 31 * result + (publisherRole != null ? publisherRole.hashCode() : 0);
        result = 31 * result + (publishTime != null ? publishTime.hashCode() : 0);
        result = 31 * result + (publishState != null ? publishState.hashCode() : 0);
        result = 31 * result + (checkerCode != null ? checkerCode.hashCode() : 0);
        result = 31 * result + (checkTime != null ? checkTime.hashCode() : 0);
        result = 31 * result + (checkState != null ? checkState.hashCode() : 0);
        result = 31 * result + (isdeleted != null ? isdeleted.hashCode() : 0);
        result = 31 * result + (publishername != null ? publishername.hashCode() : 0);
        return result;
    }
}
