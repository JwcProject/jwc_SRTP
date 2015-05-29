package edu.cqu.no1.domain;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Huxley on 5/29/15.
 */
@Entity
@Table(name = "t_announcement", schema = "", catalog = "srtp")
public class TAnnouncement {
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
    private TAnnounType tAnnounTypeByAnnounTypeId;

    @Id
    @Column(name = "announ_id")
    public String getAnnounId() {
        return announId;
    }

    public void setAnnounId(String announId) {
        this.announId = announId;
    }

    @Basic
    @Column(name = "announ_type_id")
    public String getAnnounTypeId() {
        return announTypeId;
    }

    public void setAnnounTypeId(String announTypeId) {
        this.announTypeId = announTypeId;
    }

    @Basic
    @Column(name = "announ_title")
    public String getAnnounTitle() {
        return announTitle;
    }

    public void setAnnounTitle(String announTitle) {
        this.announTitle = announTitle;
    }

    @Basic
    @Column(name = "announ_content")
    public String getAnnounContent() {
        return announContent;
    }

    public void setAnnounContent(String announContent) {
        this.announContent = announContent;
    }

    @Basic
    @Column(name = "publisher_code")
    public String getPublisherCode() {
        return publisherCode;
    }

    public void setPublisherCode(String publisherCode) {
        this.publisherCode = publisherCode;
    }

    @Basic
    @Column(name = "publisher_role")
    public String getPublisherRole() {
        return publisherRole;
    }

    public void setPublisherRole(String publisherRole) {
        this.publisherRole = publisherRole;
    }

    @Basic
    @Column(name = "publish_time")
    public Timestamp getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Timestamp publishTime) {
        this.publishTime = publishTime;
    }

    @Basic
    @Column(name = "publish_state")
    public String getPublishState() {
        return publishState;
    }

    public void setPublishState(String publishState) {
        this.publishState = publishState;
    }

    @Basic
    @Column(name = "checker_code")
    public String getCheckerCode() {
        return checkerCode;
    }

    public void setCheckerCode(String checkerCode) {
        this.checkerCode = checkerCode;
    }

    @Basic
    @Column(name = "check_time")
    public Timestamp getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Timestamp checkTime) {
        this.checkTime = checkTime;
    }

    @Basic
    @Column(name = "check_state")
    public String getCheckState() {
        return checkState;
    }

    public void setCheckState(String checkState) {
        this.checkState = checkState;
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

        TAnnouncement that = (TAnnouncement) o;

        if (announId != null ? !announId.equals(that.announId) : that.announId != null) return false;
        if (announTypeId != null ? !announTypeId.equals(that.announTypeId) : that.announTypeId != null) return false;
        if (announTitle != null ? !announTitle.equals(that.announTitle) : that.announTitle != null) return false;
        if (announContent != null ? !announContent.equals(that.announContent) : that.announContent != null)
            return false;
        if (publisherCode != null ? !publisherCode.equals(that.publisherCode) : that.publisherCode != null)
            return false;
        if (publisherRole != null ? !publisherRole.equals(that.publisherRole) : that.publisherRole != null)
            return false;
        if (publishTime != null ? !publishTime.equals(that.publishTime) : that.publishTime != null) return false;
        if (publishState != null ? !publishState.equals(that.publishState) : that.publishState != null) return false;
        if (checkerCode != null ? !checkerCode.equals(that.checkerCode) : that.checkerCode != null) return false;
        if (checkTime != null ? !checkTime.equals(that.checkTime) : that.checkTime != null) return false;
        if (checkState != null ? !checkState.equals(that.checkState) : that.checkState != null) return false;
        if (isdeleted != null ? !isdeleted.equals(that.isdeleted) : that.isdeleted != null) return false;

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
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "announ_type_id", referencedColumnName = "announ_type_id")
    public TAnnounType gettAnnounTypeByAnnounTypeId() {
        return tAnnounTypeByAnnounTypeId;
    }

    public void settAnnounTypeByAnnounTypeId(TAnnounType tAnnounTypeByAnnounTypeId) {
        this.tAnnounTypeByAnnounTypeId = tAnnounTypeByAnnounTypeId;
    }
}
