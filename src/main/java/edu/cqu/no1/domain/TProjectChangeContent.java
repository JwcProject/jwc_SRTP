package edu.cqu.no1.domain;

import javax.persistence.*;

/**
 * Created by Huxley on 5/29/15.
 */
@Entity
@Table(name = "t_project_change_content", schema = "", catalog = "srtp")
public class TProjectChangeContent {
    private String projectChangeId;
    private String projectChangeContentId;
    private String projectChangeContentField;
    private String projectChangeContentFieldname;
    private String projectChangeContentOvalue;
    private String projectChangeContentNvalue;
    private String isdeleted;
    private TProjectChange tProjectChangeByProjectChangeId;

    @Basic
    @Column(name = "projectChange_id")
    public String getProjectChangeId() {
        return projectChangeId;
    }

    public void setProjectChangeId(String projectChangeId) {
        this.projectChangeId = projectChangeId;
    }

    @Id
    @Column(name = "projectChangeContent_id")
    public String getProjectChangeContentId() {
        return projectChangeContentId;
    }

    public void setProjectChangeContentId(String projectChangeContentId) {
        this.projectChangeContentId = projectChangeContentId;
    }

    @Basic
    @Column(name = "projectChangeContent_field")
    public String getProjectChangeContentField() {
        return projectChangeContentField;
    }

    public void setProjectChangeContentField(String projectChangeContentField) {
        this.projectChangeContentField = projectChangeContentField;
    }

    @Basic
    @Column(name = "projectChangeContent_fieldname")
    public String getProjectChangeContentFieldname() {
        return projectChangeContentFieldname;
    }

    public void setProjectChangeContentFieldname(String projectChangeContentFieldname) {
        this.projectChangeContentFieldname = projectChangeContentFieldname;
    }

    @Basic
    @Column(name = "projectChangeContent_ovalue")
    public String getProjectChangeContentOvalue() {
        return projectChangeContentOvalue;
    }

    public void setProjectChangeContentOvalue(String projectChangeContentOvalue) {
        this.projectChangeContentOvalue = projectChangeContentOvalue;
    }

    @Basic
    @Column(name = "projectChangeContent_nvalue")
    public String getProjectChangeContentNvalue() {
        return projectChangeContentNvalue;
    }

    public void setProjectChangeContentNvalue(String projectChangeContentNvalue) {
        this.projectChangeContentNvalue = projectChangeContentNvalue;
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

        TProjectChangeContent that = (TProjectChangeContent) o;

        if (projectChangeId != null ? !projectChangeId.equals(that.projectChangeId) : that.projectChangeId != null)
            return false;
        if (projectChangeContentId != null ? !projectChangeContentId.equals(that.projectChangeContentId) : that.projectChangeContentId != null)
            return false;
        if (projectChangeContentField != null ? !projectChangeContentField.equals(that.projectChangeContentField) : that.projectChangeContentField != null)
            return false;
        if (projectChangeContentFieldname != null ? !projectChangeContentFieldname.equals(that.projectChangeContentFieldname) : that.projectChangeContentFieldname != null)
            return false;
        if (projectChangeContentOvalue != null ? !projectChangeContentOvalue.equals(that.projectChangeContentOvalue) : that.projectChangeContentOvalue != null)
            return false;
        if (projectChangeContentNvalue != null ? !projectChangeContentNvalue.equals(that.projectChangeContentNvalue) : that.projectChangeContentNvalue != null)
            return false;
        if (isdeleted != null ? !isdeleted.equals(that.isdeleted) : that.isdeleted != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = projectChangeId != null ? projectChangeId.hashCode() : 0;
        result = 31 * result + (projectChangeContentId != null ? projectChangeContentId.hashCode() : 0);
        result = 31 * result + (projectChangeContentField != null ? projectChangeContentField.hashCode() : 0);
        result = 31 * result + (projectChangeContentFieldname != null ? projectChangeContentFieldname.hashCode() : 0);
        result = 31 * result + (projectChangeContentOvalue != null ? projectChangeContentOvalue.hashCode() : 0);
        result = 31 * result + (projectChangeContentNvalue != null ? projectChangeContentNvalue.hashCode() : 0);
        result = 31 * result + (isdeleted != null ? isdeleted.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "projectChange_id", referencedColumnName = "projectChange_id")
    public TProjectChange gettProjectChangeByProjectChangeId() {
        return tProjectChangeByProjectChangeId;
    }

    public void settProjectChangeByProjectChangeId(TProjectChange tProjectChangeByProjectChangeId) {
        this.tProjectChangeByProjectChangeId = tProjectChangeByProjectChangeId;
    }
}
