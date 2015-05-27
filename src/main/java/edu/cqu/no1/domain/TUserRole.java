package edu.cqu.no1.domain;

import javax.persistence.*;

/**
 * Created by ZKQ on 2015/5/27.
 */
@Entity
@Table(name = "t_user_role", schema = "", catalog = "srtp")
public class TUserRole {
    private String userroleId;
    private String userId;
    private String roleId;
    private String isdeleted;

    @Id
    @Column(name = "USERROLE_ID")
    public String getUserroleId() {
        return userroleId;
    }

    public void setUserroleId(String userroleId) {
        this.userroleId = userroleId;
    }

    @Basic
    @Column(name = "USER_ID")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

        TUserRole tUserRole = (TUserRole) o;

        if (isdeleted != null ? !isdeleted.equals(tUserRole.isdeleted) : tUserRole.isdeleted != null) return false;
        if (roleId != null ? !roleId.equals(tUserRole.roleId) : tUserRole.roleId != null) return false;
        if (userId != null ? !userId.equals(tUserRole.userId) : tUserRole.userId != null) return false;
        if (userroleId != null ? !userroleId.equals(tUserRole.userroleId) : tUserRole.userroleId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userroleId != null ? userroleId.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (roleId != null ? roleId.hashCode() : 0);
        result = 31 * result + (isdeleted != null ? isdeleted.hashCode() : 0);
        return result;
    }
}
