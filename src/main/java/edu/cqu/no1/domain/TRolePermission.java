package edu.cqu.no1.domain;

import javax.persistence.*;

/**
 * Created by ZKQ on 2015/5/27.
 */
@Entity
@Table(name = "t_role_permission", schema = "", catalog = "srtp")
public class TRolePermission {
    private String rolepermissionId;
    private String roleId;
    private String permissionId;
    private String isdeleted;

    @Id
    @Column(name = "ROLEPERMISSION_ID")
    public String getRolepermissionId() {
        return rolepermissionId;
    }

    public void setRolepermissionId(String rolepermissionId) {
        this.rolepermissionId = rolepermissionId;
    }

    @Basic
    @Column(name = "ROLE_ID")
    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "PERMISSION_ID")
    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
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

        TRolePermission that = (TRolePermission) o;

        if (isdeleted != null ? !isdeleted.equals(that.isdeleted) : that.isdeleted != null) return false;
        if (permissionId != null ? !permissionId.equals(that.permissionId) : that.permissionId != null) return false;
        if (roleId != null ? !roleId.equals(that.roleId) : that.roleId != null) return false;
        if (rolepermissionId != null ? !rolepermissionId.equals(that.rolepermissionId) : that.rolepermissionId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rolepermissionId != null ? rolepermissionId.hashCode() : 0;
        result = 31 * result + (roleId != null ? roleId.hashCode() : 0);
        result = 31 * result + (permissionId != null ? permissionId.hashCode() : 0);
        result = 31 * result + (isdeleted != null ? isdeleted.hashCode() : 0);
        return result;
    }
}
