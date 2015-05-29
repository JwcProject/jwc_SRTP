package edu.cqu.no1.domain;

import javax.persistence.*;

/**
 * Created by Huxley on 5/29/15.
 */
@Entity
@Table(name = "t_role_permission", schema = "", catalog = "srtp")
public class TRolePermission {
    private String rolePermissionId;
    private String roleId;
    private String permissionId;
    private String isdeleted;
    private TPermission tPermissionByPermissionId;
    private TRole tRoleByRoleId;

    @Id
    @Column(name = "rolePermission_id")
    public String getRolePermissionId() {
        return rolePermissionId;
    }

    public void setRolePermissionId(String rolePermissionId) {
        this.rolePermissionId = rolePermissionId;
    }

    @Basic
    @Column(name = "role_id")
    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "permission_id")
    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
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

        TRolePermission that = (TRolePermission) o;

        if (rolePermissionId != null ? !rolePermissionId.equals(that.rolePermissionId) : that.rolePermissionId != null)
            return false;
        if (roleId != null ? !roleId.equals(that.roleId) : that.roleId != null) return false;
        if (permissionId != null ? !permissionId.equals(that.permissionId) : that.permissionId != null) return false;
        if (isdeleted != null ? !isdeleted.equals(that.isdeleted) : that.isdeleted != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rolePermissionId != null ? rolePermissionId.hashCode() : 0;
        result = 31 * result + (roleId != null ? roleId.hashCode() : 0);
        result = 31 * result + (permissionId != null ? permissionId.hashCode() : 0);
        result = 31 * result + (isdeleted != null ? isdeleted.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "permission_id", referencedColumnName = "permission_id")
    public TPermission gettPermissionByPermissionId() {
        return tPermissionByPermissionId;
    }

    public void settPermissionByPermissionId(TPermission tPermissionByPermissionId) {
        this.tPermissionByPermissionId = tPermissionByPermissionId;
    }

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    public TRole gettRoleByRoleId() {
        return tRoleByRoleId;
    }

    public void settRoleByRoleId(TRole tRoleByRoleId) {
        this.tRoleByRoleId = tRoleByRoleId;
    }
}
