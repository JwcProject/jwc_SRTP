package edu.cqu.no1.domain;// default package

import java.math.BigDecimal;
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
	private String fileName;
	private BigDecimal fileSize;
	private String fileFormat;
	private String fileUrl;
	private String uploaderRole;
	private Timestamp uploadTime;
	private String objectCode;
	private String isdeleted;

	// Constructors

	/** default constructor */
	public TAttachment() {
	}

	/** full constructor */
	public TAttachment(TAttchmentType TAttchmentType, TUser TUser,
			String fileName, BigDecimal fileSize, String fileFormat,
			String fileUrl, String uploaderRole, Timestamp uploadTime,
			String objectCode, String isdeleted) {
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
	@GenericGenerator(name = "generator", strategy = "guid")
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

	@Column(name = "file_name", length = 100)
	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Column(name = "file_size")
	public BigDecimal getFileSize() {
		return this.fileSize;
	}

	public void setFileSize(BigDecimal fileSize) {
		this.fileSize = fileSize;
	}

	@Column(name = "file_format", length = 50)
	public String getFileFormat() {
		return this.fileFormat;
	}

	public void setFileFormat(String fileFormat) {
		this.fileFormat = fileFormat;
	}

	@Column(name = "file_url", length = 50)
	public String getFileUrl() {
		return this.fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	@Column(name = "uploader_role", length = 32)
	public String getUploaderRole() {
		return this.uploaderRole;
	}

	public void setUploaderRole(String uploaderRole) {
		this.uploaderRole = uploaderRole;
	}

	@Column(name = "upload_time", length = 19)
	public Timestamp getUploadTime() {
		return this.uploadTime;
	}

	public void setUploadTime(Timestamp uploadTime) {
		this.uploadTime = uploadTime;
	}

	@Column(name = "object_code", length = 32)
	public String getObjectCode() {
		return this.objectCode;
	}

	public void setObjectCode(String objectCode) {
		this.objectCode = objectCode;
	}

	@Column(name = "isdeleted", length = 1)
	public String getIsdeleted() {
		return this.isdeleted;
	}

	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}

}