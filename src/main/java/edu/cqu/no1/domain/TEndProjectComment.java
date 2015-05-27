package edu.cqu.no1.domain;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by ZKQ on 2015/5/27.
 */
@Entity
@Table(name = "t_end_project_comment", schema = "", catalog = "srtp")
public class TEndProjectComment {
    private String id;
    private String eprojectexportId;
    private String endprojectcommentAdvise;
    private Integer endprojectcommentScore;
    private String endprojectcommentContent;
    private String isdeleted;
    private Timestamp endprojectcommentTime;

    @Id
    @Column(name = "ID")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "EPROJECTEXPORT_ID")
    public String getEprojectexportId() {
        return eprojectexportId;
    }

    public void setEprojectexportId(String eprojectexportId) {
        this.eprojectexportId = eprojectexportId;
    }

    @Basic
    @Column(name = "ENDPROJECTCOMMENT_ADVISE")
    public String getEndprojectcommentAdvise() {
        return endprojectcommentAdvise;
    }

    public void setEndprojectcommentAdvise(String endprojectcommentAdvise) {
        this.endprojectcommentAdvise = endprojectcommentAdvise;
    }

    @Basic
    @Column(name = "ENDPROJECTCOMMENT_SCORE")
    public Integer getEndprojectcommentScore() {
        return endprojectcommentScore;
    }

    public void setEndprojectcommentScore(Integer endprojectcommentScore) {
        this.endprojectcommentScore = endprojectcommentScore;
    }

    @Basic
    @Column(name = "ENDPROJECTCOMMENT_CONTENT")
    public String getEndprojectcommentContent() {
        return endprojectcommentContent;
    }

    public void setEndprojectcommentContent(String endprojectcommentContent) {
        this.endprojectcommentContent = endprojectcommentContent;
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
    @Column(name = "ENDPROJECTCOMMENT_TIME")
    public Timestamp getEndprojectcommentTime() {
        return endprojectcommentTime;
    }

    public void setEndprojectcommentTime(Timestamp endprojectcommentTime) {
        this.endprojectcommentTime = endprojectcommentTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TEndProjectComment that = (TEndProjectComment) o;

        if (endprojectcommentAdvise != null ? !endprojectcommentAdvise.equals(that.endprojectcommentAdvise) : that.endprojectcommentAdvise != null)
            return false;
        if (endprojectcommentContent != null ? !endprojectcommentContent.equals(that.endprojectcommentContent) : that.endprojectcommentContent != null)
            return false;
        if (endprojectcommentScore != null ? !endprojectcommentScore.equals(that.endprojectcommentScore) : that.endprojectcommentScore != null)
            return false;
        if (endprojectcommentTime != null ? !endprojectcommentTime.equals(that.endprojectcommentTime) : that.endprojectcommentTime != null)
            return false;
        if (eprojectexportId != null ? !eprojectexportId.equals(that.eprojectexportId) : that.eprojectexportId != null)
            return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (isdeleted != null ? !isdeleted.equals(that.isdeleted) : that.isdeleted != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (eprojectexportId != null ? eprojectexportId.hashCode() : 0);
        result = 31 * result + (endprojectcommentAdvise != null ? endprojectcommentAdvise.hashCode() : 0);
        result = 31 * result + (endprojectcommentScore != null ? endprojectcommentScore.hashCode() : 0);
        result = 31 * result + (endprojectcommentContent != null ? endprojectcommentContent.hashCode() : 0);
        result = 31 * result + (isdeleted != null ? isdeleted.hashCode() : 0);
        result = 31 * result + (endprojectcommentTime != null ? endprojectcommentTime.hashCode() : 0);
        return result;
    }
}
