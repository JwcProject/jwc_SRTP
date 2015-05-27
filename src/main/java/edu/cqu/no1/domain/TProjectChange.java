package edu.cqu.no1.domain;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by ZKQ on 2015/5/27.
 */
@Entity
@Table(name = "t_project_change", schema = "", catalog = "srtp")
public class TProjectChange {
    private String projectchangeId;
    private String projectId;
    private String projectchangeState;
    private String projectchangeAtid;
    private String projectchangeCtid;
    private Timestamp projectchangeCtime;
    private Timestamp projectchangeAtime;
    private Timestamp projectchangeDate;
    private String projectchangeReason;
    private String isdeleted;

    @Id
    @Column(name = "PROJECTCHANGE_ID")
    public String getProjectchangeId() {
        return projectchangeId;
    }

    public void setProjectchangeId(String projectchangeId) {
        this.projectchangeId = projectchangeId;
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
    @Column(name = "PROJECTCHANGE_STATE")
    public String getProjectchangeState() {
        return projectchangeState;
    }

    public void setProjectchangeState(String projectchangeState) {
        this.projectchangeState = projectchangeState;
    }

    @Basic
    @Column(name = "PROJECTCHANGE_ATID")
    public String getProjectchangeAtid() {
        return projectchangeAtid;
    }

    public void setProjectchangeAtid(String projectchangeAtid) {
        this.projectchangeAtid = projectchangeAtid;
    }

    @Basic
    @Column(name = "PROJECTCHANGE_CTID")
    public String getProjectchangeCtid() {
        return projectchangeCtid;
    }

    public void setProjectchangeCtid(String projectchangeCtid) {
        this.projectchangeCtid = projectchangeCtid;
    }

    @Basic
    @Column(name = "PROJECTCHANGE_CTIME")
    public Timestamp getProjectchangeCtime() {
        return projectchangeCtime;
    }

    public void setProjectchangeCtime(Timestamp projectchangeCtime) {
        this.projectchangeCtime = projectchangeCtime;
    }

    @Basic
    @Column(name = "PROJECTCHANGE_ATIME")
    public Timestamp getProjectchangeAtime() {
        return projectchangeAtime;
    }

    public void setProjectchangeAtime(Timestamp projectchangeAtime) {
        this.projectchangeAtime = projectchangeAtime;
    }

    @Basic
    @Column(name = "PROJECTCHANGE_DATE")
    public Timestamp getProjectchangeDate() {
        return projectchangeDate;
    }

    public void setProjectchangeDate(Timestamp projectchangeDate) {
        this.projectchangeDate = projectchangeDate;
    }

    @Basic
    @Column(name = "PROJECTCHANGE_REASON")
    public String getProjectchangeReason() {
        return projectchangeReason;
    }

    public void setProjectchangeReason(String projectchangeReason) {
        this.projectchangeReason = projectchangeReason;
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

        TProjectChange that = (TProjectChange) o;

        if (isdeleted != null ? !isdeleted.equals(that.isdeleted) : that.isdeleted != null) return false;
        if (projectId != null ? !projectId.equals(that.projectId) : that.projectId != null) return false;
        if (projectchangeAtid != null ? !projectchangeAtid.equals(that.projectchangeAtid) : that.projectchangeAtid != null)
            return false;
        if (projectchangeAtime != null ? !projectchangeAtime.equals(that.projectchangeAtime) : that.projectchangeAtime != null)
            return false;
        if (projectchangeCtid != null ? !projectchangeCtid.equals(that.projectchangeCtid) : that.projectchangeCtid != null)
            return false;
        if (projectchangeCtime != null ? !projectchangeCtime.equals(that.projectchangeCtime) : that.projectchangeCtime != null)
            return false;
        if (projectchangeDate != null ? !projectchangeDate.equals(that.projectchangeDate) : that.projectchangeDate != null)
            return false;
        if (projectchangeId != null ? !projectchangeId.equals(that.projectchangeId) : that.projectchangeId != null)
            return false;
        if (projectchangeReason != null ? !projectchangeReason.equals(that.projectchangeReason) : that.projectchangeReason != null)
            return false;
        if (projectchangeState != null ? !projectchangeState.equals(that.projectchangeState) : that.projectchangeState != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = projectchangeId != null ? projectchangeId.hashCode() : 0;
        result = 31 * result + (projectId != null ? projectId.hashCode() : 0);
        result = 31 * result + (projectchangeState != null ? projectchangeState.hashCode() : 0);
        result = 31 * result + (projectchangeAtid != null ? projectchangeAtid.hashCode() : 0);
        result = 31 * result + (projectchangeCtid != null ? projectchangeCtid.hashCode() : 0);
        result = 31 * result + (projectchangeCtime != null ? projectchangeCtime.hashCode() : 0);
        result = 31 * result + (projectchangeAtime != null ? projectchangeAtime.hashCode() : 0);
        result = 31 * result + (projectchangeDate != null ? projectchangeDate.hashCode() : 0);
        result = 31 * result + (projectchangeReason != null ? projectchangeReason.hashCode() : 0);
        result = 31 * result + (isdeleted != null ? isdeleted.hashCode() : 0);
        return result;
    }
}
