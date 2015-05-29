package edu.cqu.no1.domain;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Huxley on 5/29/15.
 */
@Entity
@Table(name = "t_attachment", schema = "", catalog = "srtp")
public class TAttachment {
    private String attaId;
    private String attaTypeId;
    private String fileName;
    private Integer fileSize;
    private String fileFormat;
    private String fileUrl;
    private String uploaderCode;
    private String uploaderRole;
    private Timestamp uploadTime;
    private String objectCode;
    private String isdeleted;
    private TUser tUserByUploaderCode;
    private TAttchmentType tAttchmentTypeByAttaTypeId;

    @Id
    @Column(name = "atta_id")
    public String getAttaId() {
        return attaId;
    }

    public void setAttaId(String attaId) {
        this.attaId = attaId;
    }

    @Basic
    @Column(name = "atta_type_id")
    public String getAttaTypeId() {
        return attaTypeId;
    }

    public void setAttaTypeId(String attaTypeId) {
        this.attaTypeId = attaTypeId;
    }

    @Basic
    @Column(name = "file_name")
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Basic
    @Column(name = "file_size")
    public Integer getFileSize() {
        return fileSize;
    }

    public void setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
    }

    @Basic
    @Column(name = "file_format")
    public String getFileFormat() {
        return fileFormat;
    }

    public void setFileFormat(String fileFormat) {
        this.fileFormat = fileFormat;
    }

    @Basic
    @Column(name = "file_url")
    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    @Basic
    @Column(name = "uploader_code")
    public String getUploaderCode() {
        return uploaderCode;
    }

    public void setUploaderCode(String uploaderCode) {
        this.uploaderCode = uploaderCode;
    }

    @Basic
    @Column(name = "uploader_role")
    public String getUploaderRole() {
        return uploaderRole;
    }

    public void setUploaderRole(String uploaderRole) {
        this.uploaderRole = uploaderRole;
    }

    @Basic
    @Column(name = "upload_time")
    public Timestamp getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Timestamp uploadTime) {
        this.uploadTime = uploadTime;
    }

    @Basic
    @Column(name = "object_code")
    public String getObjectCode() {
        return objectCode;
    }

    public void setObjectCode(String objectCode) {
        this.objectCode = objectCode;
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

        TAttachment that = (TAttachment) o;

        if (attaId != null ? !attaId.equals(that.attaId) : that.attaId != null) return false;
        if (attaTypeId != null ? !attaTypeId.equals(that.attaTypeId) : that.attaTypeId != null) return false;
        if (fileName != null ? !fileName.equals(that.fileName) : that.fileName != null) return false;
        if (fileSize != null ? !fileSize.equals(that.fileSize) : that.fileSize != null) return false;
        if (fileFormat != null ? !fileFormat.equals(that.fileFormat) : that.fileFormat != null) return false;
        if (fileUrl != null ? !fileUrl.equals(that.fileUrl) : that.fileUrl != null) return false;
        if (uploaderCode != null ? !uploaderCode.equals(that.uploaderCode) : that.uploaderCode != null) return false;
        if (uploaderRole != null ? !uploaderRole.equals(that.uploaderRole) : that.uploaderRole != null) return false;
        if (uploadTime != null ? !uploadTime.equals(that.uploadTime) : that.uploadTime != null) return false;
        if (objectCode != null ? !objectCode.equals(that.objectCode) : that.objectCode != null) return false;
        if (isdeleted != null ? !isdeleted.equals(that.isdeleted) : that.isdeleted != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = attaId != null ? attaId.hashCode() : 0;
        result = 31 * result + (attaTypeId != null ? attaTypeId.hashCode() : 0);
        result = 31 * result + (fileName != null ? fileName.hashCode() : 0);
        result = 31 * result + (fileSize != null ? fileSize.hashCode() : 0);
        result = 31 * result + (fileFormat != null ? fileFormat.hashCode() : 0);
        result = 31 * result + (fileUrl != null ? fileUrl.hashCode() : 0);
        result = 31 * result + (uploaderCode != null ? uploaderCode.hashCode() : 0);
        result = 31 * result + (uploaderRole != null ? uploaderRole.hashCode() : 0);
        result = 31 * result + (uploadTime != null ? uploadTime.hashCode() : 0);
        result = 31 * result + (objectCode != null ? objectCode.hashCode() : 0);
        result = 31 * result + (isdeleted != null ? isdeleted.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "uploader_code", referencedColumnName = "user_id")
    public TUser gettUserByUploaderCode() {
        return tUserByUploaderCode;
    }

    public void settUserByUploaderCode(TUser tUserByUploaderCode) {
        this.tUserByUploaderCode = tUserByUploaderCode;
    }

    @ManyToOne
    @JoinColumn(name = "atta_type_id", referencedColumnName = "atta_type_id")
    public TAttchmentType gettAttchmentTypeByAttaTypeId() {
        return tAttchmentTypeByAttaTypeId;
    }

    public void settAttchmentTypeByAttaTypeId(TAttchmentType tAttchmentTypeByAttaTypeId) {
        this.tAttchmentTypeByAttaTypeId = tAttchmentTypeByAttaTypeId;
    }
}
