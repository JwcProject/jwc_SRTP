package edu.cqu.no1.domain;

import javax.persistence.*;

/**
 * Created by ZKQ on 2015/5/27.
 */
@Entity
@Table(name = "t_end_project_export", schema = "", catalog = "srtp")
public class TEndProjectExport {
    private String id;
    private String expertId;
    private String endprojectId;
    private String isdeleted;

    @Id
    @Column(name = "ID")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "EXPERT_ID")
    public String getExpertId() {
        return expertId;
    }

    public void setExpertId(String expertId) {
        this.expertId = expertId;
    }

    @Basic
    @Column(name = "ENDPROJECT_ID")
    public String getEndprojectId() {
        return endprojectId;
    }

    public void setEndprojectId(String endprojectId) {
        this.endprojectId = endprojectId;
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

        TEndProjectExport that = (TEndProjectExport) o;

        if (endprojectId != null ? !endprojectId.equals(that.endprojectId) : that.endprojectId != null) return false;
        if (expertId != null ? !expertId.equals(that.expertId) : that.expertId != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (isdeleted != null ? !isdeleted.equals(that.isdeleted) : that.isdeleted != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (expertId != null ? expertId.hashCode() : 0);
        result = 31 * result + (endprojectId != null ? endprojectId.hashCode() : 0);
        result = 31 * result + (isdeleted != null ? isdeleted.hashCode() : 0);
        return result;
    }
}
