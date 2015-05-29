package edu.cqu.no1.domain;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Huxley on 5/29/15.
 */
@Entity
@Table(name = "t_decl_comment", schema = "", catalog = "srtp")
public class TDeclComment {
    private String declComId;
    private String exReviewId;
    private String declArgument;
    private String compEval;
    private Integer declScore;
    private Timestamp reviewTime;
    private String isdeleted;
    private TExpertReview tExpertReviewByExReviewId;

    @Id
    @Column(name = "decl_com_id")
    public String getDeclComId() {
        return declComId;
    }

    public void setDeclComId(String declComId) {
        this.declComId = declComId;
    }

    @Basic
    @Column(name = "ex_review_id")
    public String getExReviewId() {
        return exReviewId;
    }

    public void setExReviewId(String exReviewId) {
        this.exReviewId = exReviewId;
    }

    @Basic
    @Column(name = "decl_argument")
    public String getDeclArgument() {
        return declArgument;
    }

    public void setDeclArgument(String declArgument) {
        this.declArgument = declArgument;
    }

    @Basic
    @Column(name = "comp_eval")
    public String getCompEval() {
        return compEval;
    }

    public void setCompEval(String compEval) {
        this.compEval = compEval;
    }

    @Basic
    @Column(name = "decl_score")
    public Integer getDeclScore() {
        return declScore;
    }

    public void setDeclScore(Integer declScore) {
        this.declScore = declScore;
    }

    @Basic
    @Column(name = "review_time")
    public Timestamp getReviewTime() {
        return reviewTime;
    }

    public void setReviewTime(Timestamp reviewTime) {
        this.reviewTime = reviewTime;
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

        TDeclComment that = (TDeclComment) o;

        if (declComId != null ? !declComId.equals(that.declComId) : that.declComId != null) return false;
        if (exReviewId != null ? !exReviewId.equals(that.exReviewId) : that.exReviewId != null) return false;
        if (declArgument != null ? !declArgument.equals(that.declArgument) : that.declArgument != null) return false;
        if (compEval != null ? !compEval.equals(that.compEval) : that.compEval != null) return false;
        if (declScore != null ? !declScore.equals(that.declScore) : that.declScore != null) return false;
        if (reviewTime != null ? !reviewTime.equals(that.reviewTime) : that.reviewTime != null) return false;
        if (isdeleted != null ? !isdeleted.equals(that.isdeleted) : that.isdeleted != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = declComId != null ? declComId.hashCode() : 0;
        result = 31 * result + (exReviewId != null ? exReviewId.hashCode() : 0);
        result = 31 * result + (declArgument != null ? declArgument.hashCode() : 0);
        result = 31 * result + (compEval != null ? compEval.hashCode() : 0);
        result = 31 * result + (declScore != null ? declScore.hashCode() : 0);
        result = 31 * result + (reviewTime != null ? reviewTime.hashCode() : 0);
        result = 31 * result + (isdeleted != null ? isdeleted.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "ex_review_id", referencedColumnName = "ex_review_id")
    public TExpertReview gettExpertReviewByExReviewId() {
        return tExpertReviewByExReviewId;
    }

    public void settExpertReviewByExReviewId(TExpertReview tExpertReviewByExReviewId) {
        this.tExpertReviewByExReviewId = tExpertReviewByExReviewId;
    }
}
