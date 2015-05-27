package edu.cqu.no1.domain;

import javax.persistence.*;

/**
 * Created by ZKQ on 2015/5/27.
 */
@Entity
@Table(name = "t_unit", schema = "", catalog = "srtp")
public class TUnit {
    private String unitId;
    private String unitName;
    private String unitType;
    private String unitFatherid;
    private String unitCode;
    private String unitRemark;
    private String isdeleted;

    @Id
    @Column(name = "UNIT_ID")
    public String getUnitId() {
        return unitId;
    }

    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }

    @Basic
    @Column(name = "UNIT_NAME")
    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    @Basic
    @Column(name = "UNIT_TYPE")
    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }

    @Basic
    @Column(name = "UNIT_FATHERID")
    public String getUnitFatherid() {
        return unitFatherid;
    }

    public void setUnitFatherid(String unitFatherid) {
        this.unitFatherid = unitFatherid;
    }

    @Basic
    @Column(name = "UNIT_CODE")
    public String getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

    @Basic
    @Column(name = "UNIT_REMARK")
    public String getUnitRemark() {
        return unitRemark;
    }

    public void setUnitRemark(String unitRemark) {
        this.unitRemark = unitRemark;
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

        TUnit tUnit = (TUnit) o;

        if (isdeleted != null ? !isdeleted.equals(tUnit.isdeleted) : tUnit.isdeleted != null) return false;
        if (unitCode != null ? !unitCode.equals(tUnit.unitCode) : tUnit.unitCode != null) return false;
        if (unitFatherid != null ? !unitFatherid.equals(tUnit.unitFatherid) : tUnit.unitFatherid != null) return false;
        if (unitId != null ? !unitId.equals(tUnit.unitId) : tUnit.unitId != null) return false;
        if (unitName != null ? !unitName.equals(tUnit.unitName) : tUnit.unitName != null) return false;
        if (unitRemark != null ? !unitRemark.equals(tUnit.unitRemark) : tUnit.unitRemark != null) return false;
        if (unitType != null ? !unitType.equals(tUnit.unitType) : tUnit.unitType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = unitId != null ? unitId.hashCode() : 0;
        result = 31 * result + (unitName != null ? unitName.hashCode() : 0);
        result = 31 * result + (unitType != null ? unitType.hashCode() : 0);
        result = 31 * result + (unitFatherid != null ? unitFatherid.hashCode() : 0);
        result = 31 * result + (unitCode != null ? unitCode.hashCode() : 0);
        result = 31 * result + (unitRemark != null ? unitRemark.hashCode() : 0);
        result = 31 * result + (isdeleted != null ? isdeleted.hashCode() : 0);
        return result;
    }
}
