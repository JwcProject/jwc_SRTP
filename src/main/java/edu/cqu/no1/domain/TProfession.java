package edu.cqu.no1.domain;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Huxley on 5/29/15.
 */
@Entity
@Table(name = "t_profession", schema = "", catalog = "srtp")
public class TProfession {
    private String professionId;
    private String unitId;
    private String professionName;
    private String professionSession;
    private String professionClass;
    private String professionRemark;
    private String professionIsdeleted;
    private TUnit tUnitByUnitId;
    private Collection<TTeacher> tTeachersByProfessionId;

    @Id
    @Column(name = "profession_id")
    public String getProfessionId() {
        return professionId;
    }

    public void setProfessionId(String professionId) {
        this.professionId = professionId;
    }

    @Basic
    @Column(name = "unit_id")
    public String getUnitId() {
        return unitId;
    }

    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }

    @Basic
    @Column(name = "profession_name")
    public String getProfessionName() {
        return professionName;
    }

    public void setProfessionName(String professionName) {
        this.professionName = professionName;
    }

    @Basic
    @Column(name = "profession_session")
    public String getProfessionSession() {
        return professionSession;
    }

    public void setProfessionSession(String professionSession) {
        this.professionSession = professionSession;
    }

    @Basic
    @Column(name = "profession_class")
    public String getProfessionClass() {
        return professionClass;
    }

    public void setProfessionClass(String professionClass) {
        this.professionClass = professionClass;
    }

    @Basic
    @Column(name = "profession_remark")
    public String getProfessionRemark() {
        return professionRemark;
    }

    public void setProfessionRemark(String professionRemark) {
        this.professionRemark = professionRemark;
    }

    @Basic
    @Column(name = "profession_isdeleted")
    public String getProfessionIsdeleted() {
        return professionIsdeleted;
    }

    public void setProfessionIsdeleted(String professionIsdeleted) {
        this.professionIsdeleted = professionIsdeleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TProfession that = (TProfession) o;

        if (professionId != null ? !professionId.equals(that.professionId) : that.professionId != null) return false;
        if (unitId != null ? !unitId.equals(that.unitId) : that.unitId != null) return false;
        if (professionName != null ? !professionName.equals(that.professionName) : that.professionName != null)
            return false;
        if (professionSession != null ? !professionSession.equals(that.professionSession) : that.professionSession != null)
            return false;
        if (professionClass != null ? !professionClass.equals(that.professionClass) : that.professionClass != null)
            return false;
        if (professionRemark != null ? !professionRemark.equals(that.professionRemark) : that.professionRemark != null)
            return false;
        if (professionIsdeleted != null ? !professionIsdeleted.equals(that.professionIsdeleted) : that.professionIsdeleted != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = professionId != null ? professionId.hashCode() : 0;
        result = 31 * result + (unitId != null ? unitId.hashCode() : 0);
        result = 31 * result + (professionName != null ? professionName.hashCode() : 0);
        result = 31 * result + (professionSession != null ? professionSession.hashCode() : 0);
        result = 31 * result + (professionClass != null ? professionClass.hashCode() : 0);
        result = 31 * result + (professionRemark != null ? professionRemark.hashCode() : 0);
        result = 31 * result + (professionIsdeleted != null ? professionIsdeleted.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "unit_id", referencedColumnName = "unit_id")
    public TUnit gettUnitByUnitId() {
        return tUnitByUnitId;
    }

    public void settUnitByUnitId(TUnit tUnitByUnitId) {
        this.tUnitByUnitId = tUnitByUnitId;
    }

    @OneToMany(mappedBy = "tProfessionByProfessionId")
    public Collection<TTeacher> gettTeachersByProfessionId() {
        return tTeachersByProfessionId;
    }

    public void settTeachersByProfessionId(Collection<TTeacher> tTeachersByProfessionId) {
        this.tTeachersByProfessionId = tTeachersByProfessionId;
    }
}
