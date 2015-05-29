package edu.cqu.no1.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by Huxley on 5/29/15.
 */
@Entity
@Table(name = "t_project_change", schema = "", catalog = "srtp")
public class TProjectChange {
    private String projectId;
    private String projectChangeId;
    private String projectChangeState;
    private String projectChangeAtid;
    private String projectChangeCtid;
    private Timestamp projectChangeCtime;
    private Timestamp projectChangeAtime;
    private Timestamp projectChangeDate;
    private String projectChangeReason;
    private String isdeleted;
    private Collection<TProjectChangeContent> tProjectChangeContentsByProjectChangeId;

    @Basic
    @Column(name = "project_id")
    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    @Id
    @Column(name = "projectChange_id")
    public String getProjectChangeId() {
        return projectChangeId;
    }

    public void setProjectChangeId(String projectChangeId) {
        this.projectChangeId = projectChangeId;
    }

    @Basic
    @Column(name = "projectChange_state")
    public String getProjectChangeState() {
        return projectChangeState;
    }

    public void setProjectChangeState(String projectChangeState) {
        this.projectChangeState = projectChangeState;
    }

    @Basic
    @Column(name = "projectChange_atid")
    public String getProjectChangeAtid() {
        return projectChangeAtid;
    }

    public void setProjectChangeAtid(String projectChangeAtid) {
        this.projectChangeAtid = projectChangeAtid;
    }

    @Basic
    @Column(name = "projectChange_ctid")
    public String getProjectChangeCtid() {
        return projectChangeCtid;
    }

    public void setProjectChangeCtid(String projectChangeCtid) {
        this.projectChangeCtid = projectChangeCtid;
    }

    @Basic
    @Column(name = "projectChange_ctime")
    public Timestamp getProjectChangeCtime() {
        return projectChangeCtime;
    }

    public void setProjectChangeCtime(Timestamp projectChangeCtime) {
        this.projectChangeCtime = projectChangeCtime;
    }

    @Basic
    @Column(name = "projectChange_atime")
    public Timestamp getProjectChangeAtime() {
        return projectChangeAtime;
    }

    public void setProjectChangeAtime(Timestamp projectChangeAtime) {
        this.projectChangeAtime = projectChangeAtime;
    }

    @Basic
    @Column(name = "projectChange_date")
    public Timestamp getProjectChangeDate() {
        return projectChangeDate;
    }

    public void setProjectChangeDate(Timestamp projectChangeDate) {
        this.projectChangeDate = projectChangeDate;
    }

    @Basic
    @Column(name = "projectChange_reason")
    public String getProjectChangeReason() {
        return projectChangeReason;
    }

    public void setProjectChangeReason(String projectChangeReason) {
        this.projectChangeReason = projectChangeReason;
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

        TProjectChange that = (TProjectChange) o;

        if (projectId != null ? !projectId.equals(that.projectId) : that.projectId != null) return false;
        if (projectChangeId != null ? !projectChangeId.equals(that.projectChangeId) : that.projectChangeId != null)
            return false;
        if (projectChangeState != null ? !projectChangeState.equals(that.projectChangeState) : that.projectChangeState != null)
            return false;
        if (projectChangeAtid != null ? !projectChangeAtid.equals(that.projectChangeAtid) : that.projectChangeAtid != null)
            return false;
        if (projectChangeCtid != null ? !projectChangeCtid.equals(that.projectChangeCtid) : that.projectChangeCtid != null)
            return false;
        if (projectChangeCtime != null ? !projectChangeCtime.equals(that.projectChangeCtime) : that.projectChangeCtime != null)
            return false;
        if (projectChangeAtime != null ? !projectChangeAtime.equals(that.projectChangeAtime) : that.projectChangeAtime != null)
            return false;
        if (projectChangeDate != null ? !projectChangeDate.equals(that.projectChangeDate) : that.projectChangeDate != null)
            return false;
        if (projectChangeReason != null ? !projectChangeReason.equals(that.projectChangeReason) : that.projectChangeReason != null)
            return false;
        if (isdeleted != null ? !isdeleted.equals(that.isdeleted) : that.isdeleted != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = projectId != null ? projectId.hashCode() : 0;
        result = 31 * result + (projectChangeId != null ? projectChangeId.hashCode() : 0);
        result = 31 * result + (projectChangeState != null ? projectChangeState.hashCode() : 0);
        result = 31 * result + (projectChangeAtid != null ? projectChangeAtid.hashCode() : 0);
        result = 31 * result + (projectChangeCtid != null ? projectChangeCtid.hashCode() : 0);
        result = 31 * result + (projectChangeCtime != null ? projectChangeCtime.hashCode() : 0);
        result = 31 * result + (projectChangeAtime != null ? projectChangeAtime.hashCode() : 0);
        result = 31 * result + (projectChangeDate != null ? projectChangeDate.hashCode() : 0);
        result = 31 * result + (projectChangeReason != null ? projectChangeReason.hashCode() : 0);
        result = 31 * result + (isdeleted != null ? isdeleted.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "tProjectChangeByProjectChangeId")
    public Collection<TProjectChangeContent> gettProjectChangeContentsByProjectChangeId() {
        return tProjectChangeContentsByProjectChangeId;
    }

    public void settProjectChangeContentsByProjectChangeId(Collection<TProjectChangeContent> tProjectChangeContentsByProjectChangeId) {
        this.tProjectChangeContentsByProjectChangeId = tProjectChangeContentsByProjectChangeId;
    }
}
