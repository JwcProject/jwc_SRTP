package edu.cqu.no1.domain;

import javax.persistence.*;

/**
 * Created by ZKQ on 2015/5/27.
 */
@Entity
@Table(name = "t_attchment_type", schema = "", catalog = "srtp")
public class TAttchmentType {
    private String attaTypeId;
    private String attaTypeName;
    private String isdeleted;

    @Id
    @Column(name = "ATTA_TYPE_ID")
    public String getAttaTypeId() {
        return attaTypeId;
    }

    public void setAttaTypeId(String attaTypeId) {
        this.attaTypeId = attaTypeId;
    }

    @Basic
    @Column(name = "ATTA_TYPE_NAME")
    public String getAttaTypeName() {
        return attaTypeName;
    }

    public void setAttaTypeName(String attaTypeName) {
        this.attaTypeName = attaTypeName;
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

        TAttchmentType that = (TAttchmentType) o;

        if (attaTypeId != null ? !attaTypeId.equals(that.attaTypeId) : that.attaTypeId != null) return false;
        if (attaTypeName != null ? !attaTypeName.equals(that.attaTypeName) : that.attaTypeName != null) return false;
        if (isdeleted != null ? !isdeleted.equals(that.isdeleted) : that.isdeleted != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = attaTypeId != null ? attaTypeId.hashCode() : 0;
        result = 31 * result + (attaTypeName != null ? attaTypeName.hashCode() : 0);
        result = 31 * result + (isdeleted != null ? isdeleted.hashCode() : 0);
        return result;
    }
}
