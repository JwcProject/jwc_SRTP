// default package

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
 * TEndProjectJob entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_end_project_job", catalog = "srtp")
public class TEndProjectJob implements java.io.Serializable {

	// Fields

	private String jobId;
	private TStudent TStudent;
	private TEndProject TEndProject;
	private String jobContent;
	private String finished;
	private String isdeleted;

	// Constructors

	/** default constructor */
	public TEndProjectJob() {
	}

	/** full constructor */
	public TEndProjectJob(TStudent TStudent, TEndProject TEndProject,
			String jobContent, String finished, String isdeleted) {
		this.TStudent = TStudent;
		this.TEndProject = TEndProject;
		this.jobContent = jobContent;
		this.finished = finished;
		this.isdeleted = isdeleted;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "guid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "job_id", unique = true, nullable = false, length = 32)
	public String getJobId() {
		return this.jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "student_id")
	public TStudent getTStudent() {
		return this.TStudent;
	}

	public void setTStudent(TStudent TStudent) {
		this.TStudent = TStudent;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "endProject_id")
	public TEndProject getTEndProject() {
		return this.TEndProject;
	}

	public void setTEndProject(TEndProject TEndProject) {
		this.TEndProject = TEndProject;
	}

	@Column(name = "job_content", length = 500)
	public String getJobContent() {
		return this.jobContent;
	}

	public void setJobContent(String jobContent) {
		this.jobContent = jobContent;
	}

	@Column(name = "finished", length = 50)
	public String getFinished() {
		return this.finished;
	}

	public void setFinished(String finished) {
		this.finished = finished;
	}

	@Column(name = "isdeleted", length = 1)
	public String getIsdeleted() {
		return this.isdeleted;
	}

	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}

}