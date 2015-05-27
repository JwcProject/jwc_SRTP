package edu.cqu.no1.domain;

import javax.persistence.*;

/**
 * Created by ZKQ on 2015/5/27.
 */
@Entity
@Table(name = "t_project_change_content", schema = "", catalog = "srtp")
public class TProjectChangeContent {
    private String projectchangecontentId;
    private String projectchangeId;
    private String projectchangecontentField;
    private String projectchangecontentFieldname;
    private String projectchangecontentOvalue;
    private String projectchangecontentNvalue;
    private String isdeleted;

    @Id
    @Column(name = "PROJECTCHANGECONTENT_ID")
    public String getProjectchangecontentId() {
        return projectchangecontentId;
    }

    public void setProjectchangecontentId(String projectchangecontentId) {
        this.projectchangecontentId = projectchangecontentId;
    }

    @Basic
    @Column(name = "PROJECTCHANGE_ID")
    public String getProjectchangeId() {
        return projectchangeId;
    }

    public void setProjectchangeId(String projectchangeId) {
        this.projectchangeId = projectchangeId;
    }

    @Basic
    @Column(name = "PROJECTCHANGECONTENT_FIELD")
    public String getProjectchangecontentField() {
        return projectchangecontentField;
    }

    public void setProjectchangecontentField(String projectchangecontentField) {
        this.projectchangecontentField = projectchangecontentField;
    }

    @Basic
    @Column(name = "PROJECTCHANGECONTENT_FIELDNAME")
    public String getProjectchangecontentFieldname() {
        return projectchangecontentFieldname;
    }

    public void setProjectchangecontentFieldname(String projectchangecontentFieldname) {
        this.projectchangecontentFieldname = projectchangecontentFieldname;
    }

    @Basic
    @Column(name = "PROJECTCHANGECONTENT_OVALUE")
    public String getProjectchangecontentOvalue() {
        return projectchangecontentOvalue;
    }

    public void setProjectchangecontentOvalue(String projectchangecontentOvalue) {
        this.projectchangecontentOvalue = projectchangecontentOvalue;
    }

    @Basic
    @Column(name = "PROJECTCHANGECONTENT_NVALUE")
    public String getProjectchangecontentNvalue() {
        return projectchangecontentNvalue;
    }

    public void setProjectchangecontentNvalue(String projectchangecontentNvalue) {
        this.projectchangecontentNvalue = projectchangecontentNvalue;
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

        TProjectChangeContent that = (TProjectChangeContent) o;

        if (isdeleted != null ? !isdeleted.equals(that.isdeleted) : that.isdeleted != null) return false;
        if (projectchangeId != null ? !projectchangeId.equals(that.projectchangeId) : that.projectchangeId != null)
            return false;
        if (projectchangecontentField != null ? !projectchangecontentField.equals(that.projectchangecontentField) : that.projectchangecontentField != null)
            return false;
        if (projectchangecontentFieldname != null ? !projectchangecontentFieldname.equals(that.projectchangecontentFieldname) : that.projectchangecontentFieldname != null)
            return false;
        if (projectchangecontentId != null ? !projectchangecontentId.equals(that.projectchangecontentId) : that.projectchangecontentId != null)
            return false;
        if (projectchangecontentNvalue != null ? !projectchangecontentNvalue.equals(that.projectchangecontentNvalue) : that.projectchangecontentNvalue != null)
            return false;
        if (projectchangecontentOvalue != null ? !projectchangecontentOvalue.equals(that.projectchangecontentOvalue) : that.projectchangecontentOvalue != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = projectchangecontentId != null ? projectchangecontentId.hashCode() : 0;
        result = 31 * result + (projectchangeId != null ? projectchangeId.hashCode() : 0);
        result = 31 * result + (projectchangecontentField != null ? projectchangecontentField.hashCode() : 0);
        result = 31 * result + (projectchangecontentFieldname != null ? projectchangecontentFieldname.hashCode() : 0);
        result = 31 * result + (projectchangecontentOvalue != null ? projectchangecontentOvalue.hashCode() : 0);
        result = 31 * result + (projectchangecontentNvalue != null ? projectchangecontentNvalue.hashCode() : 0);
        result = 31 * result + (isdeleted != null ? isdeleted.hashCode() : 0);
        return result;
    }
}
