package edu.cqu.no1.domain;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Huxley on 5/29/15.
 */
@Entity
@Table(name = "t_permission", schema = "", catalog = "srtp")
public class TPermission {
    private String permissionId;
    private String permissionName;
    private String permissionState;
    private String permissionUrl;
    private String permissionLevel;
    private String permissionFatherid;
    private String permissionIntroduction;
    private String isdeleted;
    private Collection<TRolePermission> tRolePermissionsByPermissionId;

    @Id
    @Column(name = "permission_id")
    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }

    @Basic
    @Column(name = "permission_name")
    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    @Basic
    @Column(name = "permission_state")
    public String getPermissionState() {
        return permissionState;
    }

    public void setPermissionState(String permissionState) {
        this.permissionState = permissionState;
    }

    @Basic
    @Column(name = "permission_url")
    public String getPermissionUrl() {
        return permissionUrl;
    }

    public void setPermissionUrl(String permissionUrl) {
        this.permissionUrl = permissionUrl;
    }

    @Basic
    @Column(name = "permission_level")
    public String getPermissionLevel() {
        return permissionLevel;
    }

    public void setPermissionLevel(String permissionLevel) {
        this.permissionLevel = permissionLevel;
    }

    @Basic
    @Column(name = "permission_fatherid")
    public String getPermissionFatherid() {
        return permissionFatherid;
    }

    public void setPermissionFatherid(String permissionFatherid) {
        this.permissionFatherid = permissionFatherid;
    }

    @Basic
    @Column(name = "permission_introduction")
    public String getPermissionIntroduction() {
        return permissionIntroduction;
    }

    public void setPermissionIntroduction(String permissionIntroduction) {
        this.permissionIntroduction = permissionIntroduction;
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

        TPermission that = (TPermission) o;

        if (permissionId != null ? !permissionId.equals(that.permissionId) : that.permissionId != null) return false;
        if (permissionName != null ? !permissionName.equals(that.permissionName) : that.permissionName != null)
            return false;
        if (permissionState != null ? !permissionState.equals(that.permissionState) : that.permissionState != null)
            return false;
        if (permissionUrl != null ? !permissionUrl.equals(that.permissionUrl) : that.permissionUrl != null)
            return false;
        if (permissionLevel != null ? !permissionLevel.equals(that.permissionLevel) : that.permissionLevel != null)
            return false;
        if (permissionFatherid != null ? !permissionFatherid.equals(that.permissionFatherid) : that.permissionFatherid != null)
            return false;
        if (permissionIntroduction != null ? !permissionIntroduction.equals(that.permissionIntroduction) : that.permissionIntroduction != null)
            return false;
        if (isdeleted != null ? !isdeleted.equals(that.isdeleted) : that.isdeleted != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = permissionId != null ? permissionId.hashCode() : 0;
        result = 31 * result + (permissionName != null ? permissionName.hashCode() : 0);
        result = 31 * result + (permissionState != null ? permissionState.hashCode() : 0);
        result = 31 * result + (permissionUrl != null ? permissionUrl.hashCode() : 0);
        result = 31 * result + (permissionLevel != null ? permissionLevel.hashCode() : 0);
        result = 31 * result + (permissionFatherid != null ? permissionFatherid.hashCode() : 0);
        result = 31 * result + (permissionIntroduction != null ? permissionIntroduction.hashCode() : 0);
        result = 31 * result + (isdeleted != null ? isdeleted.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "tPermissionByPermissionId")
    public Collection<TRolePermission> gettRolePermissionsByPermissionId() {
        return tRolePermissionsByPermissionId;
    }

    public void settRolePermissionsByPermissionId(Collection<TRolePermission> tRolePermissionsByPermissionId) {
        this.tRolePermissionsByPermissionId = tRolePermissionsByPermissionId;
    }
}
