package edu.cqu.no1.domain;

import javax.persistence.*;

/**
 * Created by Huxley on 5/29/15.
 */
@Entity
@Table(name = "t_user_role", schema = "", catalog = "srtp")
public class TUserRole {
    private String userRoleId;
    private String userId;
    private String roleId;
    private String isdeleted;
    private TRole tRoleByRoleId;
    private TUser tUserByUserId;

    @Id
    @Column(name = "userRole_id")
    public String getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(String userRoleId) {
        this.userRoleId = userRoleId;
    }

    @Basic
    @Column(name = "user_id")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

        TUserRole tUserRole = (TUserRole) o;

        if (userRoleId != null ? !userRoleId.equals(tUserRole.userRoleId) : tUserRole.userRoleId != null) return false;
        if (userId != null ? !userId.equals(tUserRole.userId) : tUserRole.userId != null) return false;
        if (roleId != null ? !roleId.equals(tUserRole.roleId) : tUserRole.roleId != null) return false;
        if (isdeleted != null ? !isdeleted.equals(tUserRole.isdeleted) : tUserRole.isdeleted != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userRoleId != null ? userRoleId.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (roleId != null ? roleId.hashCode() : 0);
        result = 31 * result + (isdeleted != null ? isdeleted.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    public TRole gettRoleByRoleId() {
        return tRoleByRoleId;
    }

    public void settRoleByRoleId(TRole tRoleByRoleId) {
        this.tRoleByRoleId = tRoleByRoleId;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    public TUser gettUserByUserId() {
        return tUserByUserId;
    }

    public void settUserByUserId(TUser tUserByUserId) {
        this.tUserByUserId = tUserByUserId;
    }
}
