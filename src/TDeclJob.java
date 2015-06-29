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
 * TDeclJob entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_decl_job", catalog = "srtp")
public class TDeclJob implements java.io.Serializable {

	// Fields

	private String jobId;
	private TStudent TStudent;
	private TDeclaration TDeclaration;
	private String jobContent;
	private String isdeleted;

	// Constructors

	/** default constructor */
	public TDeclJob() {
	}

	/** full constructor */
	public TDeclJob(TStudent TStudent, TDeclaration TDeclaration,
			String jobContent, String isdeleted) {
		this.TStudent = TStudent;
		this.TDeclaration = TDeclaration;
		this.jobContent = jobContent;
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
	@JoinColumn(name = "declar_id")
	public TDeclaration getTDeclaration() {
		return this.TDeclaration;
	}

	public void setTDeclaration(TDeclaration TDeclaration) {
		this.TDeclaration = TDeclaration;
	}

	@Column(name = "job_content", length = 500)
	public String getJobContent() {
		return this.jobContent;
	}

	public void setJobContent(String jobContent) {
		this.jobContent = jobContent;
	}

	@Column(name = "isdeleted", length = 1)
	public String getIsdeleted() {
		return this.isdeleted;
	}

	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}

}