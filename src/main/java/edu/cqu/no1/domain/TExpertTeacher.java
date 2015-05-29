package edu.cqu.no1.domain;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Huxley on 5/29/15.
 */
@Entity
@Table(name = "t_expert_teacher", schema = "", catalog = "srtp")
public class TExpertTeacher {
    private String exTeaId;
    private String teaId;
    private String libId;
    private Integer reDeclNum;
    private String isdeleted;
    private Collection<TEndProjectExport> tEndProjectExportsByExTeaId;
    private Collection<TExpertReview> tExpertReviewsByExTeaId;
    private TExpertLib tExpertLibByLibId;
    private TTeacher tTeacherByTeaId;

    @Id
    @Column(name = "ex_tea_id")
    public String getExTeaId() {
        return exTeaId;
    }

    public void setExTeaId(String exTeaId) {
        this.exTeaId = exTeaId;
    }

    @Basic
    @Column(name = "tea_id")
    public String getTeaId() {
        return teaId;
    }

    public void setTeaId(String teaId) {
        this.teaId = teaId;
    }

    @Basic
    @Column(name = "lib_id")
    public String getLibId() {
        return libId;
    }

    public void setLibId(String libId) {
        this.libId = libId;
    }

    @Basic
    @Column(name = "re_decl_num")
    public Integer getReDeclNum() {
        return reDeclNum;
    }

    public void setReDeclNum(Integer reDeclNum) {
        this.reDeclNum = reDeclNum;
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

        TExpertTeacher that = (TExpertTeacher) o;

        if (exTeaId != null ? !exTeaId.equals(that.exTeaId) : that.exTeaId != null) return false;
        if (teaId != null ? !teaId.equals(that.teaId) : that.teaId != null) return false;
        if (libId != null ? !libId.equals(that.libId) : that.libId != null) return false;
        if (reDeclNum != null ? !reDeclNum.equals(that.reDeclNum) : that.reDeclNum != null) return false;
        if (isdeleted != null ? !isdeleted.equals(that.isdeleted) : that.isdeleted != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = exTeaId != null ? exTeaId.hashCode() : 0;
        result = 31 * result + (teaId != null ? teaId.hashCode() : 0);
        result = 31 * result + (libId != null ? libId.hashCode() : 0);
        result = 31 * result + (reDeclNum != null ? reDeclNum.hashCode() : 0);
        result = 31 * result + (isdeleted != null ? isdeleted.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "tExpertTeacherByExpertId")
    public Collection<TEndProjectExport> gettEndProjectExportsByExTeaId() {
        return tEndProjectExportsByExTeaId;
    }

    public void settEndProjectExportsByExTeaId(Collection<TEndProjectExport> tEndProjectExportsByExTeaId) {
        this.tEndProjectExportsByExTeaId = tEndProjectExportsByExTeaId;
    }

    @OneToMany(mappedBy = "tExpertTeacherByExTeaId")
    public Collection<TExpertReview> gettExpertReviewsByExTeaId() {
        return tExpertReviewsByExTeaId;
    }

    public void settExpertReviewsByExTeaId(Collection<TExpertReview> tExpertReviewsByExTeaId) {
        this.tExpertReviewsByExTeaId = tExpertReviewsByExTeaId;
    }

    @ManyToOne
    @JoinColumn(name = "lib_id", referencedColumnName = "lib_id")
    public TExpertLib gettExpertLibByLibId() {
        return tExpertLibByLibId;
    }

    public void settExpertLibByLibId(TExpertLib tExpertLibByLibId) {
        this.tExpertLibByLibId = tExpertLibByLibId;
    }

    @ManyToOne
    @JoinColumn(name = "tea_id", referencedColumnName = "tea_id")
    public TTeacher gettTeacherByTeaId() {
        return tTeacherByTeaId;
    }

    public void settTeacherByTeaId(TTeacher tTeacherByTeaId) {
        this.tTeacherByTeaId = tTeacherByTeaId;
    }
}
