package edu.cqu.no1.domain;

import javax.persistence.*;

/**
 * Created by ZKQ on 2015/5/27.
 */
@Entity
@Table(name = "t_teacher", schema = "", catalog = "srtp")
public class TTeacher {
    private String teaId;
    private String unitId;
    private String teaName;
    private String teaCode;
    private Integer teaAge;
    private String teaSex;
    private String teaTitle;
    private String teaTele;
    private String teaEmail;
    private String teaState;
    private String teaIntro;
    private String teaRemark;
    private String isdeleted;

    @Id
    @Column(name = "TEA_ID")
    public String getTeaId() {
        return teaId;
    }

    public void setTeaId(String teaId) {
        this.teaId = teaId;
    }

    @Basic
    @Column(name = "UNIT_ID")
    public String getUnitId() {
        return unitId;
    }

    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }

    @Basic
    @Column(name = "TEA_NAME")
    public String getTeaName() {
        return teaName;
    }

    public void setTeaName(String teaName) {
        this.teaName = teaName;
    }

    @Basic
    @Column(name = "TEA_CODE")
    public String getTeaCode() {
        return teaCode;
    }

    public void setTeaCode(String teaCode) {
        this.teaCode = teaCode;
    }

    @Basic
    @Column(name = "TEA_AGE")
    public Integer getTeaAge() {
        return teaAge;
    }

    public void setTeaAge(Integer teaAge) {
        this.teaAge = teaAge;
    }

    @Basic
    @Column(name = "TEA_SEX")
    public String getTeaSex() {
        return teaSex;
    }

    public void setTeaSex(String teaSex) {
        this.teaSex = teaSex;
    }

    @Basic
    @Column(name = "TEA_TITLE")
    public String getTeaTitle() {
        return teaTitle;
    }

    public void setTeaTitle(String teaTitle) {
        this.teaTitle = teaTitle;
    }

    @Basic
    @Column(name = "TEA_TELE")
    public String getTeaTele() {
        return teaTele;
    }

    public void setTeaTele(String teaTele) {
        this.teaTele = teaTele;
    }

    @Basic
    @Column(name = "TEA_EMAIL")
    public String getTeaEmail() {
        return teaEmail;
    }

    public void setTeaEmail(String teaEmail) {
        this.teaEmail = teaEmail;
    }

    @Basic
    @Column(name = "TEA_STATE")
    public String getTeaState() {
        return teaState;
    }

    public void setTeaState(String teaState) {
        this.teaState = teaState;
    }

    @Basic
    @Column(name = "TEA_INTRO")
    public String getTeaIntro() {
        return teaIntro;
    }

    public void setTeaIntro(String teaIntro) {
        this.teaIntro = teaIntro;
    }

    @Basic
    @Column(name = "TEA_REMARK")
    public String getTeaRemark() {
        return teaRemark;
    }

    public void setTeaRemark(String teaRemark) {
        this.teaRemark = teaRemark;
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

        TTeacher tTeacher = (TTeacher) o;

        if (isdeleted != null ? !isdeleted.equals(tTeacher.isdeleted) : tTeacher.isdeleted != null) return false;
        if (teaAge != null ? !teaAge.equals(tTeacher.teaAge) : tTeacher.teaAge != null) return false;
        if (teaCode != null ? !teaCode.equals(tTeacher.teaCode) : tTeacher.teaCode != null) return false;
        if (teaEmail != null ? !teaEmail.equals(tTeacher.teaEmail) : tTeacher.teaEmail != null) return false;
        if (teaId != null ? !teaId.equals(tTeacher.teaId) : tTeacher.teaId != null) return false;
        if (teaIntro != null ? !teaIntro.equals(tTeacher.teaIntro) : tTeacher.teaIntro != null) return false;
        if (teaName != null ? !teaName.equals(tTeacher.teaName) : tTeacher.teaName != null) return false;
        if (teaRemark != null ? !teaRemark.equals(tTeacher.teaRemark) : tTeacher.teaRemark != null) return false;
        if (teaSex != null ? !teaSex.equals(tTeacher.teaSex) : tTeacher.teaSex != null) return false;
        if (teaState != null ? !teaState.equals(tTeacher.teaState) : tTeacher.teaState != null) return false;
        if (teaTele != null ? !teaTele.equals(tTeacher.teaTele) : tTeacher.teaTele != null) return false;
        if (teaTitle != null ? !teaTitle.equals(tTeacher.teaTitle) : tTeacher.teaTitle != null) return false;
        if (unitId != null ? !unitId.equals(tTeacher.unitId) : tTeacher.unitId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = teaId != null ? teaId.hashCode() : 0;
        result = 31 * result + (unitId != null ? unitId.hashCode() : 0);
        result = 31 * result + (teaName != null ? teaName.hashCode() : 0);
        result = 31 * result + (teaCode != null ? teaCode.hashCode() : 0);
        result = 31 * result + (teaAge != null ? teaAge.hashCode() : 0);
        result = 31 * result + (teaSex != null ? teaSex.hashCode() : 0);
        result = 31 * result + (teaTitle != null ? teaTitle.hashCode() : 0);
        result = 31 * result + (teaTele != null ? teaTele.hashCode() : 0);
        result = 31 * result + (teaEmail != null ? teaEmail.hashCode() : 0);
        result = 31 * result + (teaState != null ? teaState.hashCode() : 0);
        result = 31 * result + (teaIntro != null ? teaIntro.hashCode() : 0);
        result = 31 * result + (teaRemark != null ? teaRemark.hashCode() : 0);
        result = 31 * result + (isdeleted != null ? isdeleted.hashCode() : 0);
        return result;
    }
}
