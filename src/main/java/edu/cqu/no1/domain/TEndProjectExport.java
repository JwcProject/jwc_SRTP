package edu.cqu.no1.domain;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Huxley on 5/29/15.
 */
@Entity
@Table(name = "t_end_project_export", schema = "", catalog = "srtp")
public class TEndProjectExport {
    private String id;
    private String expertId;
    private String endProjectId;
    private String isdeleted;
    private Collection<TEndProjectComment> tEndProjectCommentsById;
    private TExpertTeacherModel texpertteachermodelByExpertId;
    private TExpertTeacher tExpertTeacherByExpertId;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "expert_id")
    public String getExpertId() {
        return expertId;
    }

    public void setExpertId(String expertId) {
        this.expertId = expertId;
    }

    @Basic
    @Column(name = "endProject_id")
    public String getEndProjectId() {
        return endProjectId;
    }

    public void setEndProjectId(String endProjectId) {
        this.endProjectId = endProjectId;
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

        TEndProjectExport that = (TEndProjectExport) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (expertId != null ? !expertId.equals(that.expertId) : that.expertId != null) return false;
        if (endProjectId != null ? !endProjectId.equals(that.endProjectId) : that.endProjectId != null) return false;
        if (isdeleted != null ? !isdeleted.equals(that.isdeleted) : that.isdeleted != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (expertId != null ? expertId.hashCode() : 0);
        result = 31 * result + (endProjectId != null ? endProjectId.hashCode() : 0);
        result = 31 * result + (isdeleted != null ? isdeleted.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "tEndProjectExportByEProjectExportId")
    public Collection<TEndProjectComment> gettEndProjectCommentsById() {
        return tEndProjectCommentsById;
    }

    public void settEndProjectCommentsById(Collection<TEndProjectComment> tEndProjectCommentsById) {
        this.tEndProjectCommentsById = tEndProjectCommentsById;
    }

    @ManyToOne
    @JoinColumn(name = "expert_id", referencedColumnName = "EX_TEA_ID")
    public TExpertTeacherModel getTexpertteachermodelByExpertId() {
        return texpertteachermodelByExpertId;
    }

    public void setTexpertteachermodelByExpertId(TExpertTeacherModel texpertteachermodelByExpertId) {
        this.texpertteachermodelByExpertId = texpertteachermodelByExpertId;
    }

    @ManyToOne
    @JoinColumn(name = "expert_id", referencedColumnName = "ex_tea_id")
    public TExpertTeacher gettExpertTeacherByExpertId() {
        return tExpertTeacherByExpertId;
    }

    public void settExpertTeacherByExpertId(TExpertTeacher tExpertTeacherByExpertId) {
        this.tExpertTeacherByExpertId = tExpertTeacherByExpertId;
    }
}
