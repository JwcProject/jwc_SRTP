package edu.cqu.no1.domain;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TAttachment entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_attachment", catalog = "srtp")
public class TAttachment implements java.io.Serializable {

	// Fields

	private String attaId;
	private TAttchmentType TAttchmentType;
	private TUser TUser;
	private String fileFormat;
	private String fileName;
	private Double fileSize;
	private String fileUrl;
	private String isdeleted;
	private String objectCode;
	private Timestamp uploadTime;
	private String uploaderRole;

	// Constructors

	/** default constructor */
	public TAttachment() {
	}

	/** full constructor */
	public TAttachment(TAttchmentType TAttchmentType, TUser TUser,
			String fileFormat, String fileName, Double fileSize,
			String fileUrl, String isdeleted, String objectCode,
			Timestamp uploadTime, String uploaderRole) {
		this.TAttchmentType = TAttchmentType;
		this.TUser = TUser;
		this.fileFormat = fileFormat;
		this.fileName = fileName;
		this.fileSize = fileSize;
		this.fileUrl = fileUrl;
		this.isdeleted = isdeleted;
		this.objectCode = objectCode;
		this.uploadTime = uploadTime;
		this.uploaderRole = uploaderRole;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "atta_id", unique = true, nullable = false, length = 36)
	public String getAttaId() {
		return this.attaId;
	}

	public void setAttaId(String attaId) {
		this.attaId = attaId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "atta_type_id")
	public TAttchmentType getTAttchmentType() {
		return this.TAttchmentType;
	}

	public void setTAttchmentType(TAttchmentType TAttchmentType) {
		this.TAttchmentType = TAttchmentType;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "uploader_code")
	public TUser getTUser() {
		return this.TUser;
	}

	public void setTUser(TUser TUser) {
		this.TUser = TUser;
	}

	@Column(name = "file_format", length = 150)
	public String getFileFormat() {
		return this.fileFormat;
	}

	public void setFileFormat(String fileFormat) {
		this.fileFormat = fileFormat;
	}

	@Column(name = "file_name", length = 100)
	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Column(name = "file_size")
	public Double getFileSize() {
		return this.fileSize;
	}

	public void setFileSize(Double fileSize) {
		this.fileSize = fileSize;
	}

	@Column(name = "file_url", length = 150)
	public String getFileUrl() {
		return this.fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	@Column(name = "isdeleted", length = 1)
	public String getIsdeleted() {
		return this.isdeleted;
	}

	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}

	@Column(name = "object_code", length = 36)
	public String getObjectCode() {
		return this.objectCode;
	}

	public void setObjectCode(String objectCode) {
		this.objectCode = objectCode;
	}

	@Column(name = "upload_time", length = 19)
	public Timestamp getUploadTime() {
		return this.uploadTime;
	}

	public void setUploadTime(Timestamp uploadTime) {
		this.uploadTime = uploadTime;
	}

	@Column(name = "uploader_role", length = 36)
	public String getUploaderRole() {
		return this.uploaderRole;
	}

	public void setUploaderRole(String uploaderRole) {
		this.uploaderRole = uploaderRole;
	}

}