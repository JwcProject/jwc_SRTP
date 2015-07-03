package edu.cqu.no1.domain;

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
 * TProjectChangeContent entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_project_change_content", catalog = "srtp2")
public class TProjectChangeContent implements java.io.Serializable {

	// Fields

	private String projectChangeContentId;
	private TProjectChange TProjectChange;
	private String isdeleted;
	private String projectChangeContentField;
	private String projectChangeContentFieldname;
	private String projectChangeContentNvalue;
	private String projectChangeContentOvalue;

	// Constructors

	/** default constructor */
	public TProjectChangeContent() {
	}

	/** full constructor */
	public TProjectChangeContent(TProjectChange TProjectChange,
			String isdeleted, String projectChangeContentField,
			String projectChangeContentFieldname,
			String projectChangeContentNvalue, String projectChangeContentOvalue) {
		this.TProjectChange = TProjectChange;
		this.isdeleted = isdeleted;
		this.projectChangeContentField = projectChangeContentField;
		this.projectChangeContentFieldname = projectChangeContentFieldname;
		this.projectChangeContentNvalue = projectChangeContentNvalue;
		this.projectChangeContentOvalue = projectChangeContentOvalue;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "projectChangeContent_id", unique = true, nullable = false, length = 36)
	public String getProjectChangeContentId() {
		return this.projectChangeContentId;
	}

	public void setProjectChangeContentId(String projectChangeContentId) {
		this.projectChangeContentId = projectChangeContentId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "projectChange_id")
	public TProjectChange getTProjectChange() {
		return this.TProjectChange;
	}

	public void setTProjectChange(TProjectChange TProjectChange) {
		this.TProjectChange = TProjectChange;
	}

	@Column(name = "isdeleted", length = 1)
	public String getIsdeleted() {
		return this.isdeleted;
	}

	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}

	@Column(name = "projectChangeContent_field", length = 100)
	public String getProjectChangeContentField() {
		return this.projectChangeContentField;
	}

	public void setProjectChangeContentField(String projectChangeContentField) {
		this.projectChangeContentField = projectChangeContentField;
	}

	@Column(name = "projectChangeContent_fieldname", length = 100)
	public String getProjectChangeContentFieldname() {
		return this.projectChangeContentFieldname;
	}

	public void setProjectChangeContentFieldname(
			String projectChangeContentFieldname) {
		this.projectChangeContentFieldname = projectChangeContentFieldname;
	}

	@Column(name = "projectChangeContent_nvalue", length = 1000)
	public String getProjectChangeContentNvalue() {
		return this.projectChangeContentNvalue;
	}

	public void setProjectChangeContentNvalue(String projectChangeContentNvalue) {
		this.projectChangeContentNvalue = projectChangeContentNvalue;
	}

	@Column(name = "projectChangeContent_ovalue", length = 1000)
	public String getProjectChangeContentOvalue() {
		return this.projectChangeContentOvalue;
	}

	public void setProjectChangeContentOvalue(String projectChangeContentOvalue) {
		this.projectChangeContentOvalue = projectChangeContentOvalue;
	}

}