package edu.cqu.no1.domain;

import javax.persistence.*;

/**
 * Created by ZKQ on 2015/5/27.
 */
@Entity
@Table(name = "t_decl_job", schema = "", catalog = "srtp")
public class TDeclJob {
    private String jobId;
    private String studentId;
    private String declarId;
    private String jobContent;
    private String isdeleted;

    @Id
    @Column(name = "JOB_ID")
    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    @Basic
    @Column(name = "STUDENT_ID")
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Basic
    @Column(name = "DECLAR_ID")
    public String getDeclarId() {
        return declarId;
    }

    public void setDeclarId(String declarId) {
        this.declarId = declarId;
    }

    @Basic
    @Column(name = "JOB_CONTENT")
    public String getJobContent() {
        return jobContent;
    }

    public void setJobContent(String jobContent) {
        this.jobContent = jobContent;
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

        TDeclJob tDeclJob = (TDeclJob) o;

        if (declarId != null ? !declarId.equals(tDeclJob.declarId) : tDeclJob.declarId != null) return false;
        if (isdeleted != null ? !isdeleted.equals(tDeclJob.isdeleted) : tDeclJob.isdeleted != null) return false;
        if (jobContent != null ? !jobContent.equals(tDeclJob.jobContent) : tDeclJob.jobContent != null) return false;
        if (jobId != null ? !jobId.equals(tDeclJob.jobId) : tDeclJob.jobId != null) return false;
        if (studentId != null ? !studentId.equals(tDeclJob.studentId) : tDeclJob.studentId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = jobId != null ? jobId.hashCode() : 0;
        result = 31 * result + (studentId != null ? studentId.hashCode() : 0);
        result = 31 * result + (declarId != null ? declarId.hashCode() : 0);
        result = 31 * result + (jobContent != null ? jobContent.hashCode() : 0);
        result = 31 * result + (isdeleted != null ? isdeleted.hashCode() : 0);
        return result;
    }
}