package edu.cqu.no1.domain;

import javax.persistence.*;

/**
 * Created by ZKQ on 2015/5/27.
 */
@Entity
@Table(name = "t_expert_review", schema = "", catalog = "srtp")
public class TExpertReview {
    private String exReviewId;
    private String declarId;
    private String exTeaId;
    private String isdeleted;

    @Id
    @Column(name = "EX_REVIEW_ID")
    public String getExReviewId() {
        return exReviewId;
    }

    public void setExReviewId(String exReviewId) {
        this.exReviewId = exReviewId;
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
    @Column(name = "EX_TEA_ID")
    public String getExTeaId() {
        return exTeaId;
    }

    public void setExTeaId(String exTeaId) {
        this.exTeaId = exTeaId;
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

        TExpertReview that = (TExpertReview) o;

        if (declarId != null ? !declarId.equals(that.declarId) : that.declarId != null) return false;
        if (exReviewId != null ? !exReviewId.equals(that.exReviewId) : that.exReviewId != null) return false;
        if (exTeaId != null ? !exTeaId.equals(that.exTeaId) : that.exTeaId != null) return false;
        if (isdeleted != null ? !isdeleted.equals(that.isdeleted) : that.isdeleted != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = exReviewId != null ? exReviewId.hashCode() : 0;
        result = 31 * result + (declarId != null ? declarId.hashCode() : 0);
        result = 31 * result + (exTeaId != null ? exTeaId.hashCode() : 0);
        result = 31 * result + (isdeleted != null ? isdeleted.hashCode() : 0);
        return result;
    }
}
