package com.isse.model;

import java.math.BigDecimal;
import java.util.Date;


/**
 * TAttachment entity. @author MyEclipse Persistence Tools
 */

public class TAttachment  implements java.io.Serializable {


    // Fields    

     private String attaId;
     private TAttchmentType TAttchmentType;
     private TUser TUser;
     private String fileName;
     private BigDecimal fileSize;
     private String fileFormat;
     private String fileUrl;
     private String uploaderRole;
     private Date uploadTime;
     private String objectCode;
     private String isdeleted;


    // Constructors

    /** default constructor */
    public TAttachment() {
    }

    
    /** full constructor */
    public TAttachment(TAttchmentType TAttchmentType, TUser TUser, String fileName, BigDecimal fileSize, String fileFormat, String fileUrl, String uploaderRole, Date uploadTime, String objectCode, String isdeleted) {
        this.TAttchmentType = TAttchmentType;
        this.TUser = TUser;
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.fileFormat = fileFormat;
        this.fileUrl = fileUrl;
        this.uploaderRole = uploaderRole;
        this.uploadTime = uploadTime;
        this.objectCode = objectCode;
        this.isdeleted = isdeleted;
    }

   
    // Property accessors

    public String getAttaId() {
        return this.attaId;
    }
    
    public void setAttaId(String attaId) {
        this.attaId = attaId;
    }

    public TAttchmentType getTAttchmentType() {
        return this.TAttchmentType;
    }
    
    public void setTAttchmentType(TAttchmentType TAttchmentType) {
        this.TAttchmentType = TAttchmentType;
    }

    public TUser getTUser() {
        return this.TUser;
    }
    
    public void setTUser(TUser TUser) {
        this.TUser = TUser;
    }

    public String getFileName() {
        return this.fileName;
    }
    
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public BigDecimal getFileSize() {
        return this.fileSize;
    }
    
    public void setFileSize(BigDecimal fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileFormat() {
        return this.fileFormat;
    }
    
    public void setFileFormat(String fileFormat) {
        this.fileFormat = fileFormat;
    }

    public String getFileUrl() {
        return this.fileUrl;
    }
    
    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getUploaderRole() {
        return this.uploaderRole;
    }
    
    public void setUploaderRole(String uploaderRole) {
        this.uploaderRole = uploaderRole;
    }

    public Date getUploadTime() {
        return this.uploadTime;
    }
    
    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getObjectCode() {
        return this.objectCode;
    }
    
    public void setObjectCode(String objectCode) {
        this.objectCode = objectCode;
    }

    public String getIsdeleted() {
        return this.isdeleted;
    }
    
    public void setIsdeleted(String isdeleted) {
        this.isdeleted = isdeleted;
    }
   








}