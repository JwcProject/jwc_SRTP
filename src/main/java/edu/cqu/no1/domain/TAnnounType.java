package edu.cqu.no1.domain;

import javax.persistence.*;

/**
 * Created by ZKQ on 2015/5/27.
 */
@Entity
@Table(name = "t_announ_type", schema = "", catalog = "srtp")
public class TAnnounType {
    private String announTypeId;
    private String announTypeName;
    private String isdeleted;

    @Id
    @Column(name = "ANNOUN_TYPE_ID")
    public String getAnnounTypeId() {
        return announTypeId;
    }

    public void setAnnounTypeId(String announTypeId) {
        this.announTypeId = announTypeId;
    }

    @Basic
    @Column(name = "ANNOUN_TYPE_NAME")
    public String getAnnounTypeName() {
        return announTypeName;
    }

    public void setAnnounTypeName(String announTypeName) {
        this.announTypeName = announTypeName;
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

        TAnnounType that = (TAnnounType) o;

        if (announTypeId != null ? !announTypeId.equals(that.announTypeId) : that.announTypeId != null) return false;
        if (announTypeName != null ? !announTypeName.equals(that.announTypeName) : that.announTypeName != null)
            return false;
        if (isdeleted != null ? !isdeleted.equals(that.isdeleted) : that.isdeleted != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = announTypeId != null ? announTypeId.hashCode() : 0;
        result = 31 * result + (announTypeName != null ? announTypeName.hashCode() : 0);
        result = 31 * result + (isdeleted != null ? isdeleted.hashCode() : 0);
        return result;
    }
}
