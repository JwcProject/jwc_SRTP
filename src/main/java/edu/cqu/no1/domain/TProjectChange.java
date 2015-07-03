package edu.cqu.no1.domain;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TProjectChange entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_project_change", catalog = "srtp2")
public class TProjectChange implements java.io.Serializable {

	// Fields

	private String projectChangeId;
	private TProject TProject;
	private String isdeleted;
	private String projectChangeAtid;
	private Timestamp projectChangeAtime;
	private String projectChangeCtid;
	private Timestamp projectChangeCtime;
	private Timestamp projectChangeDate;
	private String projectChangeReason;
	private String projectChangeState;
	private Set<TProjectChangeContent> TProjectChangeContents = new HashSet<TProjectChangeContent>(
			0);

	// Constructors

	/** default constructor */
	public TProjectChange() {
	}

	/** full constructor */
	public TProjectChange(TProject TProject, String isdeleted,
			String projectChangeAtid, Timestamp projectChangeAtime,
			String projectChangeCtid, Timestamp projectChangeCtime,
			Timestamp projectChangeDate, String projectChangeReason,
			String projectChangeState,
			Set<TProjectChangeContent> TProjectChangeContents) {
		this.TProject = TProject;
		this.isdeleted = isdeleted;
		this.projectChangeAtid = projectChangeAtid;
		this.projectChangeAtime = projectChangeAtime;
		this.projectChangeCtid = projectChangeCtid;
		this.projectChangeCtime = projectChangeCtime;
		this.projectChangeDate = projectChangeDate;
		this.projectChangeReason = projectChangeReason;
		this.projectChangeState = projectChangeState;
		this.TProjectChangeContents = TProjectChangeContents;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "projectChange_id", unique = true, nullable = false, length = 36)
	public String getProjectChangeId() {
		return this.projectChangeId;
	}

	public void setProjectChangeId(String projectChangeId) {
		this.projectChangeId = projectChangeId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "project_id")
	public TProject getTProject() {
		return this.TProject;
	}

	public void setTProject(TProject TProject) {
		this.TProject = TProject;
	}

	@Column(name = "isdeleted", length = 1)
	public String getIsdeleted() {
		return this.isdeleted;
	}

	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}

	@Column(name = "projectChange_atid", length = 32)
	public String getProjectChangeAtid() {
		return this.projectChangeAtid;
	}

	public void setProjectChangeAtid(String projectChangeAtid) {
		this.projectChangeAtid = projectChangeAtid;
	}

	@Column(name = "projectChange_atime", length = 19)
	public Timestamp getProjectChangeAtime() {
		return this.projectChangeAtime;
	}

	public void setProjectChangeAtime(Timestamp projectChangeAtime) {
		this.projectChangeAtime = projectChangeAtime;
	}

	@Column(name = "projectChange_ctid", length = 32)
	public String getProjectChangeCtid() {
		return this.projectChangeCtid;
	}

	public void setProjectChangeCtid(String projectChangeCtid) {
		this.projectChangeCtid = projectChangeCtid;
	}

	@Column(name = "projectChange_ctime", length = 19)
	public Timestamp getProjectChangeCtime() {
		return this.projectChangeCtime;
	}

	public void setProjectChangeCtime(Timestamp projectChangeCtime) {
		this.projectChangeCtime = projectChangeCtime;
	}

	@Column(name = "projectChange_date", length = 19)
	public Timestamp getProjectChangeDate() {
		return this.projectChangeDate;
	}

	public void setProjectChangeDate(Timestamp projectChangeDate) {
		this.projectChangeDate = projectChangeDate;
	}

	@Column(name = "projectChange_reason", length = 200)
	public String getProjectChangeReason() {
		return this.projectChangeReason;
	}

	public void setProjectChangeReason(String projectChangeReason) {
		this.projectChangeReason = projectChangeReason;
	}

	@Column(name = "projectChange_state", length = 2)
	public String getProjectChangeState() {
		return this.projectChangeState;
	}

	public void setProjectChangeState(String projectChangeState) {
		this.projectChangeState = projectChangeState;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TProjectChange")
	public Set<TProjectChangeContent> getTProjectChangeContents() {
		return this.TProjectChangeContents;
	}

	public void setTProjectChangeContents(
			Set<TProjectChangeContent> TProjectChangeContents) {
		this.TProjectChangeContents = TProjectChangeContents;
	}

}