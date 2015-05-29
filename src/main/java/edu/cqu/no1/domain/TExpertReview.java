package edu.cqu.no1.domain;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Huxley on 5/29/15.
 */
@Entity
@Table(name = "t_expert_review", schema = "", catalog = "srtp")
public class TExpertReview {
    private String exReviewId;
    private String exTeaId;
    private String declarId;
    private String isdeleted;
    private Collection<TDeclComment> tDeclCommentsByExReviewId;
    private TExpertTeacherModel texpertteachermodelByExTeaId;
    private TExpertTeacher tExpertTeacherByExTeaId;

    @Id
    @Column(name = "ex_review_id")
    public String getExReviewId() {
        return exReviewId;
    }

    public void setExReviewId(String exReviewId) {
        this.exReviewId = exReviewId;
    }

    @Basic
    @Column(name = "ex_tea_id")
    public String getExTeaId() {
        return exTeaId;
    }

    public void setExTeaId(String exTeaId) {
        this.exTeaId = exTeaId;
    }

    @Basic
    @Column(name = "declar_id")
    public String getDeclarId() {
        return declarId;
    }

    public void setDeclarId(String declarId) {
        this.declarId = declarId;
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

        TExpertReview that = (TExpertReview) o;

        if (exReviewId != null ? !exReviewId.equals(that.exReviewId) : that.exReviewId != null) return false;
        if (exTeaId != null ? !exTeaId.equals(that.exTeaId) : that.exTeaId != null) return false;
        if (declarId != null ? !declarId.equals(that.declarId) : that.declarId != null) return false;
        if (isdeleted != null ? !isdeleted.equals(that.isdeleted) : that.isdeleted != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = exReviewId != null ? exReviewId.hashCode() : 0;
        result = 31 * result + (exTeaId != null ? exTeaId.hashCode() : 0);
        result = 31 * result + (declarId != null ? declarId.hashCode() : 0);
        result = 31 * result + (isdeleted != null ? isdeleted.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "tExpertReviewByExReviewId")
    public Collection<TDeclComment> gettDeclCommentsByExReviewId() {
        return tDeclCommentsByExReviewId;
    }

    public void settDeclCommentsByExReviewId(Collection<TDeclComment> tDeclCommentsByExReviewId) {
        this.tDeclCommentsByExReviewId = tDeclCommentsByExReviewId;
    }

    @ManyToOne
    @JoinColumn(name = "ex_tea_id", referencedColumnName = "EX_TEA_ID")
    public TExpertTeacherModel getTexpertteachermodelByExTeaId() {
        return texpertteachermodelByExTeaId;
    }

    public void setTexpertteachermodelByExTeaId(TExpertTeacherModel texpertteachermodelByExTeaId) {
        this.texpertteachermodelByExTeaId = texpertteachermodelByExTeaId;
    }

    @ManyToOne
    @JoinColumn(name = "ex_tea_id", referencedColumnName = "ex_tea_id")
    public TExpertTeacher gettExpertTeacherByExTeaId() {
        return tExpertTeacherByExTeaId;
    }

    public void settExpertTeacherByExTeaId(TExpertTeacher tExpertTeacherByExTeaId) {
        this.tExpertTeacherByExTeaId = tExpertTeacherByExTeaId;
    }
}
