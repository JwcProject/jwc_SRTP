package edu.cqu.no1.domain;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Huxley on 5/29/15.
 */
@Entity
@Table(name = "t_teacher", schema = "", catalog = "srtp")
public class TTeacher {
    private String teaId;
    private String professionId;
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
    private String unitId;
    private Collection<TEmail> tEmailsByTeaId;
    private Collection<TExpertLib> tExpertLibsByTeaId;
    private Collection<TExpertTeacher> tExpertTeachersByTeaId;
    private TUnit tUnitByUnitId;
    private TProfession tProfessionByProfessionId;
    private Collection<TExpertTeacherModel> texpertteachermodelsByTeaId;

    @Id
    @Column(name = "tea_id")
    public String getTeaId() {
        return teaId;
    }

    public void setTeaId(String teaId) {
        this.teaId = teaId;
    }

    @Basic
    @Column(name = "profession_id")
    public String getProfessionId() {
        return professionId;
    }

    public void setProfessionId(String professionId) {
        this.professionId = professionId;
    }

    @Basic
    @Column(name = "tea_name")
    public String getTeaName() {
        return teaName;
    }

    public void setTeaName(String teaName) {
        this.teaName = teaName;
    }

    @Basic
    @Column(name = "tea_code")
    public String getTeaCode() {
        return teaCode;
    }

    public void setTeaCode(String teaCode) {
        this.teaCode = teaCode;
    }

    @Basic
    @Column(name = "tea_age")
    public Integer getTeaAge() {
        return teaAge;
    }

    public void setTeaAge(Integer teaAge) {
        this.teaAge = teaAge;
    }

    @Basic
    @Column(name = "tea_sex")
    public String getTeaSex() {
        return teaSex;
    }

    public void setTeaSex(String teaSex) {
        this.teaSex = teaSex;
    }

    @Basic
    @Column(name = "tea_title")
    public String getTeaTitle() {
        return teaTitle;
    }

    public void setTeaTitle(String teaTitle) {
        this.teaTitle = teaTitle;
    }

    @Basic
    @Column(name = "tea_tele")
    public String getTeaTele() {
        return teaTele;
    }

    public void setTeaTele(String teaTele) {
        this.teaTele = teaTele;
    }

    @Basic
    @Column(name = "tea_email")
    public String getTeaEmail() {
        return teaEmail;
    }

    public void setTeaEmail(String teaEmail) {
        this.teaEmail = teaEmail;
    }

    @Basic
    @Column(name = "tea_state")
    public String getTeaState() {
        return teaState;
    }

    public void setTeaState(String teaState) {
        this.teaState = teaState;
    }

    @Basic
    @Column(name = "tea_intro")
    public String getTeaIntro() {
        return teaIntro;
    }

    public void setTeaIntro(String teaIntro) {
        this.teaIntro = teaIntro;
    }

    @Basic
    @Column(name = "tea_remark")
    public String getTeaRemark() {
        return teaRemark;
    }

    public void setTeaRemark(String teaRemark) {
        this.teaRemark = teaRemark;
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
    @Column(name = "UNIT_ID")
    public String getUnitId() {
        return unitId;
    }

    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TTeacher tTeacher = (TTeacher) o;

        if (teaId != null ? !teaId.equals(tTeacher.teaId) : tTeacher.teaId != null) return false;
        if (professionId != null ? !professionId.equals(tTeacher.professionId) : tTeacher.professionId != null)
            return false;
        if (teaName != null ? !teaName.equals(tTeacher.teaName) : tTeacher.teaName != null) return false;
        if (teaCode != null ? !teaCode.equals(tTeacher.teaCode) : tTeacher.teaCode != null) return false;
        if (teaAge != null ? !teaAge.equals(tTeacher.teaAge) : tTeacher.teaAge != null) return false;
        if (teaSex != null ? !teaSex.equals(tTeacher.teaSex) : tTeacher.teaSex != null) return false;
        if (teaTitle != null ? !teaTitle.equals(tTeacher.teaTitle) : tTeacher.teaTitle != null) return false;
        if (teaTele != null ? !teaTele.equals(tTeacher.teaTele) : tTeacher.teaTele != null) return false;
        if (teaEmail != null ? !teaEmail.equals(tTeacher.teaEmail) : tTeacher.teaEmail != null) return false;
        if (teaState != null ? !teaState.equals(tTeacher.teaState) : tTeacher.teaState != null) return false;
        if (teaIntro != null ? !teaIntro.equals(tTeacher.teaIntro) : tTeacher.teaIntro != null) return false;
        if (teaRemark != null ? !teaRemark.equals(tTeacher.teaRemark) : tTeacher.teaRemark != null) return false;
        if (isdeleted != null ? !isdeleted.equals(tTeacher.isdeleted) : tTeacher.isdeleted != null) return false;
        if (unitId != null ? !unitId.equals(tTeacher.unitId) : tTeacher.unitId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = teaId != null ? teaId.hashCode() : 0;
        result = 31 * result + (professionId != null ? professionId.hashCode() : 0);
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
        result = 31 * result + (unitId != null ? unitId.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "tTeacherByTeaId")
    public Collection<TEmail> gettEmailsByTeaId() {
        return tEmailsByTeaId;
    }

    public void settEmailsByTeaId(Collection<TEmail> tEmailsByTeaId) {
        this.tEmailsByTeaId = tEmailsByTeaId;
    }

    @OneToMany(mappedBy = "tTeacherByTeaId")
    public Collection<TExpertLib> gettExpertLibsByTeaId() {
        return tExpertLibsByTeaId;
    }

    public void settExpertLibsByTeaId(Collection<TExpertLib> tExpertLibsByTeaId) {
        this.tExpertLibsByTeaId = tExpertLibsByTeaId;
    }

    @OneToMany(mappedBy = "tTeacherByTeaId")
    public Collection<TExpertTeacher> gettExpertTeachersByTeaId() {
        return tExpertTeachersByTeaId;
    }

    public void settExpertTeachersByTeaId(Collection<TExpertTeacher> tExpertTeachersByTeaId) {
        this.tExpertTeachersByTeaId = tExpertTeachersByTeaId;
    }

    @ManyToOne
    @JoinColumn(name = "UNIT_ID", referencedColumnName = "unit_id")
    public TUnit gettUnitByUnitId() {
        return tUnitByUnitId;
    }

    public void settUnitByUnitId(TUnit tUnitByUnitId) {
        this.tUnitByUnitId = tUnitByUnitId;
    }

    @ManyToOne
    @JoinColumn(name = "profession_id", referencedColumnName = "profession_id")
    public TProfession gettProfessionByProfessionId() {
        return tProfessionByProfessionId;
    }

    public void settProfessionByProfessionId(TProfession tProfessionByProfessionId) {
        this.tProfessionByProfessionId = tProfessionByProfessionId;
    }

    @OneToMany(mappedBy = "tTeacherByTeaId")
    public Collection<TExpertTeacherModel> getTexpertteachermodelsByTeaId() {
        return texpertteachermodelsByTeaId;
    }

    public void setTexpertteachermodelsByTeaId(Collection<TExpertTeacherModel> texpertteachermodelsByTeaId) {
        this.texpertteachermodelsByTeaId = texpertteachermodelsByTeaId;
    }
}
