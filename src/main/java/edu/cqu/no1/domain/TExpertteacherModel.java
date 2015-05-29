package edu.cqu.no1.domain;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Huxley on 5/29/15.
 */
@Entity
public class TExpertTeacherModel {
    private String exTeaId;
    private String libId;
    private String teaId;
    private Integer reDeclNum;
    private String isdeleted;
    private Integer jqYear;
    private String qici;
    private Collection<TEndProjectExport> tEndProjectExportsByExTeaId;
    private Collection<TExpertReview> tExpertReviewsByExTeaId;
    private TTeacher tTeacherByTeaId;
    private TExpertLib tExpertLibByLibId;

    @Id
    @Column(name = "EX_TEA_ID")
    public String getExTeaId() {
        return exTeaId;
    }

    public void setExTeaId(String exTeaId) {
        this.exTeaId = exTeaId;
    }

    @Basic
    @Column(name = "LIB_ID")
    public String getLibId() {
        return libId;
    }

    public void setLibId(String libId) {
        this.libId = libId;
    }

    @Basic
    @Column(name = "TEA_ID")
    public String getTeaId() {
        return teaId;
    }

    public void setTeaId(String teaId) {
        this.teaId = teaId;
    }

    @Basic
    @Column(name = "RE_DECL_NUM")
    public Integer getReDeclNum() {
        return reDeclNum;
    }

    public void setReDeclNum(Integer reDeclNum) {
        this.reDeclNum = reDeclNum;
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
    @Column(name = "JQ_YEAR")
    public Integer getJqYear() {
        return jqYear;
    }

    public void setJqYear(Integer jqYear) {
        this.jqYear = jqYear;
    }

    @Basic
    @Column(name = "QICI")
    public String getQici() {
        return qici;
    }

    public void setQici(String qici) {
        this.qici = qici;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TExpertTeacherModel that = (TExpertTeacherModel) o;

        if (exTeaId != null ? !exTeaId.equals(that.exTeaId) : that.exTeaId != null) return false;
        if (libId != null ? !libId.equals(that.libId) : that.libId != null) return false;
        if (teaId != null ? !teaId.equals(that.teaId) : that.teaId != null) return false;
        if (reDeclNum != null ? !reDeclNum.equals(that.reDeclNum) : that.reDeclNum != null) return false;
        if (isdeleted != null ? !isdeleted.equals(that.isdeleted) : that.isdeleted != null) return false;
        if (jqYear != null ? !jqYear.equals(that.jqYear) : that.jqYear != null) return false;
        if (qici != null ? !qici.equals(that.qici) : that.qici != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = exTeaId != null ? exTeaId.hashCode() : 0;
        result = 31 * result + (libId != null ? libId.hashCode() : 0);
        result = 31 * result + (teaId != null ? teaId.hashCode() : 0);
        result = 31 * result + (reDeclNum != null ? reDeclNum.hashCode() : 0);
        result = 31 * result + (isdeleted != null ? isdeleted.hashCode() : 0);
        result = 31 * result + (jqYear != null ? jqYear.hashCode() : 0);
        result = 31 * result + (qici != null ? qici.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "texpertteachermodelByExpertId")
    public Collection<TEndProjectExport> gettEndProjectExportsByExTeaId() {
        return tEndProjectExportsByExTeaId;
    }

    public void settEndProjectExportsByExTeaId(Collection<TEndProjectExport> tEndProjectExportsByExTeaId) {
        this.tEndProjectExportsByExTeaId = tEndProjectExportsByExTeaId;
    }

    @OneToMany(mappedBy = "texpertteachermodelByExTeaId")
    public Collection<TExpertReview> gettExpertReviewsByExTeaId() {
        return tExpertReviewsByExTeaId;
    }

    public void settExpertReviewsByExTeaId(Collection<TExpertReview> tExpertReviewsByExTeaId) {
        this.tExpertReviewsByExTeaId = tExpertReviewsByExTeaId;
    }

    @ManyToOne
    @JoinColumn(name = "TEA_ID", referencedColumnName = "tea_id")
    public TTeacher gettTeacherByTeaId() {
        return tTeacherByTeaId;
    }

    public void settTeacherByTeaId(TTeacher tTeacherByTeaId) {
        this.tTeacherByTeaId = tTeacherByTeaId;
    }

    @ManyToOne
    @JoinColumn(name = "LIB_ID", referencedColumnName = "lib_id")
    public TExpertLib gettExpertLibByLibId() {
        return tExpertLibByLibId;
    }

    public void settExpertLibByLibId(TExpertLib tExpertLibByLibId) {
        this.tExpertLibByLibId = tExpertLibByLibId;
    }
}
