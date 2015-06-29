// default package

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
 * TEndProjectExport entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_end_project_export", catalog = "srtp")
public class TEndProjectExport implements java.io.Serializable {

	// Fields

	private String id;
	private TExpertTeacherModel TExpertTeacherModel;
	private TExpertTeacher TExpertTeacher;
	private TEndProject TEndProject;
	private String isdeleted;
	private Set<TEndProjectComment> TEndProjectComments = new HashSet<TEndProjectComment>(
			0);

	// Constructors

	/** default constructor */
	public TEndProjectExport() {
	}

	/** full constructor */
	public TEndProjectExport(TExpertTeacherModel TExpertTeacherModel,
			TExpertTeacher TExpertTeacher, TEndProject TEndProject,
			String isdeleted, Set<TEndProjectComment> TEndProjectComments) {
		this.TExpertTeacherModel = TExpertTeacherModel;
		this.TExpertTeacher = TExpertTeacher;
		this.TEndProject = TEndProject;
		this.isdeleted = isdeleted;
		this.TEndProjectComments = TEndProjectComments;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "guid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "id", unique = true, nullable = false, length = 32)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "expert_id")
	public TExpertTeacherModel getTExpertTeacherModel() {
		return this.TExpertTeacherModel;
	}

	public void setTExpertTeacherModel(TExpertTeacherModel TExpertTeacherModel) {
		this.TExpertTeacherModel = TExpertTeacherModel;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "expert_id", insertable = false, updatable = false)
	public TExpertTeacher getTExpertTeacher() {
		return this.TExpertTeacher;
	}

	public void setTExpertTeacher(TExpertTeacher TExpertTeacher) {
		this.TExpertTeacher = TExpertTeacher;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "endProject_id")
	public TEndProject getTEndProject() {
		return this.TEndProject;
	}

	public void setTEndProject(TEndProject TEndProject) {
		this.TEndProject = TEndProject;
	}

	@Column(name = "isdeleted", length = 1)
	public String getIsdeleted() {
		return this.isdeleted;
	}

	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TEndProjectExport")
	public Set<TEndProjectComment> getTEndProjectComments() {
		return this.TEndProjectComments;
	}

	public void setTEndProjectComments(
			Set<TEndProjectComment> TEndProjectComments) {
		this.TEndProjectComments = TEndProjectComments;
	}

}