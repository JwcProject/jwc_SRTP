package edu.cqu.no1.domain;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Huxley on 5/29/15.
 */
@Entity
@Table(name = "t_role", schema = "", catalog = "srtp")
public class TRole {
    private String roleId;
    private String roleName;
    private String roleState;
    private String roleIntroduction;
    private String isdeleted;
    private Collection<TRolePermission> tRolePermissionsByRoleId;
    private Collection<TUserRole> tUserRolesByRoleId;

    @Id
    @Column(name = "role_id")
    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "role_name")
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Basic
    @Column(name = "role_state")
    public String getRoleState() {
        return roleState;
    }

    public void setRoleState(String roleState) {
        this.roleState = roleState;
    }

    @Basic
    @Column(name = "role_introduction")
    public String getRoleIntroduction() {
        return roleIntroduction;
    }

    public void setRoleIntroduction(String roleIntroduction) {
        this.roleIntroduction = roleIntroduction;
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

        TRole tRole = (TRole) o;

        if (roleId != null ? !roleId.equals(tRole.roleId) : tRole.roleId != null) return false;
        if (roleName != null ? !roleName.equals(tRole.roleName) : tRole.roleName != null) return false;
        if (roleState != null ? !roleState.equals(tRole.roleState) : tRole.roleState != null) return false;
        if (roleIntroduction != null ? !roleIntroduction.equals(tRole.roleIntroduction) : tRole.roleIntroduction != null)
            return false;
        if (isdeleted != null ? !isdeleted.equals(tRole.isdeleted) : tRole.isdeleted != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = roleId != null ? roleId.hashCode() : 0;
        result = 31 * result + (roleName != null ? roleName.hashCode() : 0);
        result = 31 * result + (roleState != null ? roleState.hashCode() : 0);
        result = 31 * result + (roleIntroduction != null ? roleIntroduction.hashCode() : 0);
        result = 31 * result + (isdeleted != null ? isdeleted.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "tRoleByRoleId")
    public Collection<TRolePermission> gettRolePermissionsByRoleId() {
        return tRolePermissionsByRoleId;
    }

    public void settRolePermissionsByRoleId(Collection<TRolePermission> tRolePermissionsByRoleId) {
        this.tRolePermissionsByRoleId = tRolePermissionsByRoleId;
    }

    @OneToMany(mappedBy = "tRoleByRoleId")
    public Collection<TUserRole> gettUserRolesByRoleId() {
        return tUserRolesByRoleId;
    }

    public void settUserRolesByRoleId(Collection<TUserRole> tUserRolesByRoleId) {
        this.tUserRolesByRoleId = tUserRolesByRoleId;
    }
}
