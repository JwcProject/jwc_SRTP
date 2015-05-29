package edu.cqu.no1.domain;

import javax.persistence.*;

/**
 * Created by Huxley on 5/29/15.
 */
@Entity
@Table(name = "t_endproject_job", schema = "", catalog = "srtp")
public class TEndprojectJob {
    private String jobId;
    private String endProjectId;
    private String studentId;
    private String jobContent;
    private String finished;
    private String isdeleted;

    @Id
    @Column(name = "job_id")
    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    @Basic
    @Column(name = "endProject_id")
    public String getEndProjectId() {
        return endProjectId;
    }

    public void setEndProjectId(String endProjectId) {
        this.endProjectId = endProjectId;
    }

    @Basic
    @Column(name = "student_id")
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Basic
    @Column(name = "job_content")
    public String getJobContent() {
        return jobContent;
    }

    public void setJobContent(String jobContent) {
        this.jobContent = jobContent;
    }

    @Basic
    @Column(name = "finished")
    public String getFinished() {
        return finished;
    }

    public void setFinished(String finished) {
        this.finished = finished;
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

        TEndprojectJob that = (TEndprojectJob) o;

        if (jobId != null ? !jobId.equals(that.jobId) : that.jobId != null) return false;
        if (endProjectId != null ? !endProjectId.equals(that.endProjectId) : that.endProjectId != null) return false;
        if (studentId != null ? !studentId.equals(that.studentId) : that.studentId != null) return false;
        if (jobContent != null ? !jobContent.equals(that.jobContent) : that.jobContent != null) return false;
        if (finished != null ? !finished.equals(that.finished) : that.finished != null) return false;
        if (isdeleted != null ? !isdeleted.equals(that.isdeleted) : that.isdeleted != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = jobId != null ? jobId.hashCode() : 0;
        result = 31 * result + (endProjectId != null ? endProjectId.hashCode() : 0);
        result = 31 * result + (studentId != null ? studentId.hashCode() : 0);
        result = 31 * result + (jobContent != null ? jobContent.hashCode() : 0);
        result = 31 * result + (finished != null ? finished.hashCode() : 0);
        result = 31 * result + (isdeleted != null ? isdeleted.hashCode() : 0);
        return result;
    }
}
