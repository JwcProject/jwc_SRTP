package com.isse.model;

import java.util.HashSet;
import java.util.Set;

import org.apache.struts2.json.annotations.JSON;


/**
 * TUser entity. @author MyEclipse Persistence Tools
 */

public class TUser  implements java.io.Serializable {


    // Fields    

     private String userId;
     private String userName;
     private String userPassword;
     private String userState;
     private String userIntroduction;
     private String isdeleted;
     private String userType;
     private Set TAttachments = new HashSet(0);
     private Set TJournals = new HashSet(0);
     private Set TUserRoles = new HashSet(0);
     private Set TStudents = new HashSet(0);


    // Constructors

    /** default constructor */
    public TUser() {
    }

    
    /** full constructor */
    public TUser(String userName, String userPassword, String userState, String userIntroduction, String isdeleted, String userType, Set TAttachments, Set TJournals, Set TUserRoles, Set TStudents) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userState = userState;
        this.userIntroduction = userIntroduction;
        this.isdeleted = isdeleted;
        this.userType = userType;
        this.TAttachments = TAttachments;
        this.TJournals = TJournals;
        this.TUserRoles = TUserRoles;
        this.TStudents = TStudents;
    }

   
    // Property accessors

    public String getUserId() {
        return this.userId;
    }
    
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return this.userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return this.userPassword;
    }
    
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserState() {
        return this.userState;
    }
    
    public void setUserState(String userState) {
        this.userState = userState;
    }

    public String getUserIntroduction() {
        return this.userIntroduction;
    }
    
    public void setUserIntroduction(String userIntroduction) {
        this.userIntroduction = userIntroduction;
    }

    public String getIsdeleted() {
        return this.isdeleted;
    }
    
    public void setIsdeleted(String isdeleted) {
        this.isdeleted = isdeleted;
    }

    public String getUserType() {
        return this.userType;
    }
    
    public void setUserType(String userType) {
        this.userType = userType;
    }
    @JSON(serialize=false)
    public Set getTAttachments() {
        return this.TAttachments;
    }
    
    public void setTAttachments(Set TAttachments) {
        this.TAttachments = TAttachments;
    }
    @JSON(serialize=false)
    public Set getTJournals() {
        return this.TJournals;
    }
    
    public void setTJournals(Set TJournals) {
        this.TJournals = TJournals;
    }
    @JSON(serialize=false)
    public Set getTUserRoles() {
        return this.TUserRoles;
    }
    
    public void setTUserRoles(Set TUserRoles) {
        this.TUserRoles = TUserRoles;
    }
    @JSON(serialize=false)
    public Set getTStudents() {
        return this.TStudents;
    }
    
    public void setTStudents(Set TStudents) {
        this.TStudents = TStudents;
    }
   








}