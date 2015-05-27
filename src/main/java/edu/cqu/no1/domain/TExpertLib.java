package edu.cqu.no1.domain;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by ZKQ on 2015/5/27.
 */
@Entity
@Table(name = "t_expert_lib", schema = "", catalog = "srtp")
public class TExpertLib {
    private String libId;
    private String jqId;
    private String teaId;
    private Timestamp creatOn;
    private String isAssigned;
    private String isdeleted;
    private String type;
    private String unitId;

    @Id
    @Column(name = "LIB_ID")
    public String getLibId() {
        return libId;
    }

    public void setLibId(String libId) {
        this.libId = libId;
    }

    @Basic
    @Column(name = "JQ_ID")
    public String getJqId() {
        return jqId;
    }

    public void setJqId(String jqId) {
        this.jqId = jqId;
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
    @Column(name = "CREAT_ON")
    public Timestamp getCreatOn() {
        return creatOn;
    }

    public void setCreatOn(Timestamp creatOn) {
        this.creatOn = creatOn;
    }

    @Basic
    @Column(name = "IS_ASSIGNED")
    public String getIsAssigned() {
        return isAssigned;
    }

    public void setIsAssigned(String isAssigned) {
        this.isAssigned = isAssigned;
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
    @Column(name = "TYPE")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

        TExpertLib that = (TExpertLib) o;

        if (creatOn != null ? !creatOn.equals(that.creatOn) : that.creatOn != null) return false;
        if (isAssigned != null ? !isAssigned.equals(that.isAssigned) : that.isAssigned != null) return false;
        if (isdeleted != null ? !isdeleted.equals(that.isdeleted) : that.isdeleted != null) return false;
        if (jqId != null ? !jqId.equals(that.jqId) : that.jqId != null) return false;
        if (libId != null ? !libId.equals(that.libId) : that.libId != null) return false;
        if (teaId != null ? !teaId.equals(that.teaId) : that.teaId != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (unitId != null ? !unitId.equals(that.unitId) : that.unitId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = libId != null ? libId.hashCode() : 0;
        result = 31 * result + (jqId != null ? jqId.hashCode() : 0);
        result = 31 * result + (teaId != null ? teaId.hashCode() : 0);
        result = 31 * result + (creatOn != null ? creatOn.hashCode() : 0);
        result = 31 * result + (isAssigned != null ? isAssigned.hashCode() : 0);
        result = 31 * result + (isdeleted != null ? isdeleted.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (unitId != null ? unitId.hashCode() : 0);
        return result;
    }
}
