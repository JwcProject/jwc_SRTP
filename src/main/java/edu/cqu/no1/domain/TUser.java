package edu.cqu.no1.domain;

import javax.persistence.*;

/**
 * Created by ZKQ on 2015/5/27.
 */
@Entity
@Table(name = "t_user", schema = "", catalog = "srtp")
public class TUser {
    private String userId;
    private String userName;
    private String userPassword;
    private String userState;
    private String userIntroduction;
    private String isdeleted;
    private String userType;

    @Id
    @Column(name = "USER_ID")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "USER_NAME")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "USER_PASSWORD")
    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Basic
    @Column(name = "USER_STATE")
    public String getUserState() {
        return userState;
    }

    public void setUserState(String userState) {
        this.userState = userState;
    }

    @Basic
    @Column(name = "USER_INTRODUCTION")
    public String getUserIntroduction() {
        return userIntroduction;
    }

    public void setUserIntroduction(String userIntroduction) {
        this.userIntroduction = userIntroduction;
    }

    @Basic
    @Column(name = "ISDELETED")
    public String getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(String isdeleted) {
        this.isdeleted = isdeleted;
    }

    @Basic
    @Column(name = "USER_TYPE")
    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TUser tUser = (TUser) o;

        if (isdeleted != null ? !isdeleted.equals(tUser.isdeleted) : tUser.isdeleted != null) return false;
        if (userId != null ? !userId.equals(tUser.userId) : tUser.userId != null) return false;
        if (userIntroduction != null ? !userIntroduction.equals(tUser.userIntroduction) : tUser.userIntroduction != null)
            return false;
        if (userName != null ? !userName.equals(tUser.userName) : tUser.userName != null) return false;
        if (userPassword != null ? !userPassword.equals(tUser.userPassword) : tUser.userPassword != null) return false;
        if (userState != null ? !userState.equals(tUser.userState) : tUser.userState != null) return false;
        if (userType != null ? !userType.equals(tUser.userType) : tUser.userType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (userPassword != null ? userPassword.hashCode() : 0);
        result = 31 * result + (userState != null ? userState.hashCode() : 0);
        result = 31 * result + (userIntroduction != null ? userIntroduction.hashCode() : 0);
        result = 31 * result + (isdeleted != null ? isdeleted.hashCode() : 0);
        result = 31 * result + (userType != null ? userType.hashCode() : 0);
        return result;
    }
}
