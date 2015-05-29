package edu.cqu.no1.domain;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Huxley on 5/29/15.
 */
@Entity
@Table(name = "t_end_project_comment", schema = "", catalog = "srtp")
public class TEndProjectComment {
    private String id;
    private String eProjectExportId;
    private String endProjectCommentAdvise;
    private Integer endProjectCommentScore;
    private String endProjectCommentContent;
    private String isdeleted;
    private Timestamp endProjectCommentTime;
    private TEndProjectExport tEndProjectExportByEProjectExportId;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "EProjectExport_id")
    public String geteProjectExportId() {
        return eProjectExportId;
    }

    public void seteProjectExportId(String eProjectExportId) {
        this.eProjectExportId = eProjectExportId;
    }

    @Basic
    @Column(name = "endProjectComment_advise")
    public String getEndProjectCommentAdvise() {
        return endProjectCommentAdvise;
    }

    public void setEndProjectCommentAdvise(String endProjectCommentAdvise) {
        this.endProjectCommentAdvise = endProjectCommentAdvise;
    }

    @Basic
    @Column(name = "endProjectComment_score")
    public Integer getEndProjectCommentScore() {
        return endProjectCommentScore;
    }

    public void setEndProjectCommentScore(Integer endProjectCommentScore) {
        this.endProjectCommentScore = endProjectCommentScore;
    }

    @Basic
    @Column(name = "endProjectComment_content")
    public String getEndProjectCommentContent() {
        return endProjectCommentContent;
    }

    public void setEndProjectCommentContent(String endProjectCommentContent) {
        this.endProjectCommentContent = endProjectCommentContent;
    }

    @Basic
    @Column(name = "isdeleted")
    public String getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(String isdeleted) {
        this.isdeleted = isdeleted;
    }

    @Basic
    @Column(name = "endProjectComment_time")
    public Timestamp getEndProjectCommentTime() {
        return endProjectCommentTime;
    }

    public void setEndProjectCommentTime(Timestamp endProjectCommentTime) {
        this.endProjectCommentTime = endProjectCommentTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TEndProjectComment that = (TEndProjectComment) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (eProjectExportId != null ? !eProjectExportId.equals(that.eProjectExportId) : that.eProjectExportId != null)
            return false;
        if (endProjectCommentAdvise != null ? !endProjectCommentAdvise.equals(that.endProjectCommentAdvise) : that.endProjectCommentAdvise != null)
            return false;
        if (endProjectCommentScore != null ? !endProjectCommentScore.equals(that.endProjectCommentScore) : that.endProjectCommentScore != null)
            return false;
        if (endProjectCommentContent != null ? !endProjectCommentContent.equals(that.endProjectCommentContent) : that.endProjectCommentContent != null)
            return false;
        if (isdeleted != null ? !isdeleted.equals(that.isdeleted) : that.isdeleted != null) return false;
        if (endProjectCommentTime != null ? !endProjectCommentTime.equals(that.endProjectCommentTime) : that.endProjectCommentTime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (eProjectExportId != null ? eProjectExportId.hashCode() : 0);
        result = 31 * result + (endProjectCommentAdvise != null ? endProjectCommentAdvise.hashCode() : 0);
        result = 31 * result + (endProjectCommentScore != null ? endProjectCommentScore.hashCode() : 0);
        result = 31 * result + (endProjectCommentContent != null ? endProjectCommentContent.hashCode() : 0);
        result = 31 * result + (isdeleted != null ? isdeleted.hashCode() : 0);
        result = 31 * result + (endProjectCommentTime != null ? endProjectCommentTime.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "EProjectExport_id", referencedColumnName = "id")
    public TEndProjectExport gettEndProjectExportByEProjectExportId() {
        return tEndProjectExportByEProjectExportId;
    }

    public void settEndProjectExportByEProjectExportId(TEndProjectExport tEndProjectExportByEProjectExportId) {
        this.tEndProjectExportByEProjectExportId = tEndProjectExportByEProjectExportId;
    }
}
