package edu.cqu.no1.domain;

import javax.persistence.*;

/**
 * Created by ZKQ on 2015/5/27.
 */
@Entity
@Table(name = "t_expert_teacher", schema = "", catalog = "srtp")
public class TExpertTeacher {
    private String exTeaId;
    private String libId;
    private String teaId;
    private Integer reDeclNum;
    private String isdeleted;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TExpertTeacher that = (TExpertTeacher) o;

        if (exTeaId != null ? !exTeaId.equals(that.exTeaId) : that.exTeaId != null) return false;
        if (isdeleted != null ? !isdeleted.equals(that.isdeleted) : that.isdeleted != null) return false;
        if (libId != null ? !libId.equals(that.libId) : that.libId != null) return false;
        if (reDeclNum != null ? !reDeclNum.equals(that.reDeclNum) : that.reDeclNum != null) return false;
        if (teaId != null ? !teaId.equals(that.teaId) : that.teaId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = exTeaId != null ? exTeaId.hashCode() : 0;
        result = 31 * result + (libId != null ? libId.hashCode() : 0);
        result = 31 * result + (teaId != null ? teaId.hashCode() : 0);
        result = 31 * result + (reDeclNum != null ? reDeclNum.hashCode() : 0);
        result = 31 * result + (isdeleted != null ? isdeleted.hashCode() : 0);
        return result;
    }
}
