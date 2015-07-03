package edu.cqu.no1.domain;

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
 * TExpertTeacher entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_expert_teacher", catalog = "srtp2")
public class TExpertTeacher implements java.io.Serializable {

	// Fields

	private String exTeaId;
	private TExpertLib TExpertLib;
	private TTeacher TTeacher;
	private String isdeleted;
	private Integer reDeclNum;
	private Set<TEndProjectExport> TEndProjectExports = new HashSet<TEndProjectExport>(
			0);
	private Set<TExpertReview> TExpertReviews = new HashSet<TExpertReview>(0);

	// Constructors

	/** default constructor */
	public TExpertTeacher() {
	}

	/** full constructor */
	public TExpertTeacher(TExpertLib TExpertLib, TTeacher TTeacher,
			String isdeleted, Integer reDeclNum,
			Set<TEndProjectExport> TEndProjectExports,
			Set<TExpertReview> TExpertReviews) {
		this.TExpertLib = TExpertLib;
		this.TTeacher = TTeacher;
		this.isdeleted = isdeleted;
		this.reDeclNum = reDeclNum;
		this.TEndProjectExports = TEndProjectExports;
		this.TExpertReviews = TExpertReviews;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "ex_tea_id", unique = true, nullable = false, length = 36)
	public String getExTeaId() {
		return this.exTeaId;
	}

	public void setExTeaId(String exTeaId) {
		this.exTeaId = exTeaId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lib_id")
	public TExpertLib getTExpertLib() {
		return this.TExpertLib;
	}

	public void setTExpertLib(TExpertLib TExpertLib) {
		this.TExpertLib = TExpertLib;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tea_id")
	public TTeacher getTTeacher() {
		return this.TTeacher;
	}

	public void setTTeacher(TTeacher TTeacher) {
		this.TTeacher = TTeacher;
	}

	@Column(name = "isdeleted", length = 1)
	public String getIsdeleted() {
		return this.isdeleted;
	}

	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}

	@Column(name = "re_decl_num")
	public Integer getReDeclNum() {
		return this.reDeclNum;
	}

	public void setReDeclNum(Integer reDeclNum) {
		this.reDeclNum = reDeclNum;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TExpertTeacher")
	public Set<TEndProjectExport> getTEndProjectExports() {
		return this.TEndProjectExports;
	}

	public void setTEndProjectExports(Set<TEndProjectExport> TEndProjectExports) {
		this.TEndProjectExports = TEndProjectExports;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TExpertTeacher")
	public Set<TExpertReview> getTExpertReviews() {
		return this.TExpertReviews;
	}

	public void setTExpertReviews(Set<TExpertReview> TExpertReviews) {
		this.TExpertReviews = TExpertReviews;
	}

}