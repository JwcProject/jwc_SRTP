package edu.cqu.no1.domain;

import javax.persistence.*;

/**
 * Created by Huxley on 5/29/15.
 */
@Entity
@Table(name = "t_code", schema = "", catalog = "srtp")
public class TCode {
    private String encodeId;
    private String encodeValue;
    private String encodeDesc;
    private String encodeRemark;
    private String isdeleted;

    @Id
    @Column(name = "encode_id")
    public String getEncodeId() {
        return encodeId;
    }

    public void setEncodeId(String encodeId) {
        this.encodeId = encodeId;
    }

    @Basic
    @Column(name = "encode_value")
    public String getEncodeValue() {
        return encodeValue;
    }

    public void setEncodeValue(String encodeValue) {
        this.encodeValue = encodeValue;
    }

    @Basic
    @Column(name = "encode_desc")
    public String getEncodeDesc() {
        return encodeDesc;
    }

    public void setEncodeDesc(String encodeDesc) {
        this.encodeDesc = encodeDesc;
    }

    @Basic
    @Column(name = "encode_remark")
    public String getEncodeRemark() {
        return encodeRemark;
    }

    public void setEncodeRemark(String encodeRemark) {
        this.encodeRemark = encodeRemark;
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

        TCode tCode = (TCode) o;

        if (encodeId != null ? !encodeId.equals(tCode.encodeId) : tCode.encodeId != null) return false;
        if (encodeValue != null ? !encodeValue.equals(tCode.encodeValue) : tCode.encodeValue != null) return false;
        if (encodeDesc != null ? !encodeDesc.equals(tCode.encodeDesc) : tCode.encodeDesc != null) return false;
        if (encodeRemark != null ? !encodeRemark.equals(tCode.encodeRemark) : tCode.encodeRemark != null) return false;
        if (isdeleted != null ? !isdeleted.equals(tCode.isdeleted) : tCode.isdeleted != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = encodeId != null ? encodeId.hashCode() : 0;
        result = 31 * result + (encodeValue != null ? encodeValue.hashCode() : 0);
        result = 31 * result + (encodeDesc != null ? encodeDesc.hashCode() : 0);
        result = 31 * result + (encodeRemark != null ? encodeRemark.hashCode() : 0);
        result = 31 * result + (isdeleted != null ? isdeleted.hashCode() : 0);
        return result;
    }
}
