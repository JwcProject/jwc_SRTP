package edu.cqu.no1.domain;// default package

import java.math.BigDecimal;
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
 * TExpertTeacherModel entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_expert_teacher_model", catalog = "srtp")
public class TExpertTeacherModel implements java.io.Serializable {

	// Fields

	private String exTeaId;
	private TExpertLib TExpertLib;
	private TTeacher TTeacher;
	private BigDecimal reDeclNum;
	private String isdeleted;
	private BigDecimal jqYear;
	private String qici;
	private Set<TEndProjectExport> TEndProjectExports = new HashSet<TEndProjectExport>(
			0);
	private Set<TExpertReview> TExpertReviews = new HashSet<TExpertReview>(0);

	// Constructors

	/** default constructor */
	public TExpertTeacherModel() {
	}

	/** full constructor */
	public TExpertTeacherModel(TExpertLib TExpertLib, TTeacher TTeacher,
			BigDecimal reDeclNum, String isdeleted, BigDecimal jqYear,
			String qici, Set<TEndProjectExport> TEndProjectExports,
			Set<TExpertReview> TExpertReviews) {
		this.TExpertLib = TExpertLib;
		this.TTeacher = TTeacher;
		this.reDeclNum = reDeclNum;
		this.isdeleted = isdeleted;
		this.jqYear = jqYear;
		this.qici = qici;
		this.TEndProjectExports = TEndProjectExports;
		this.TExpertReviews = TExpertReviews;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "guid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "EX_TEA_ID", unique = true, nullable = false, length = 36)
	public String getExTeaId() {
		return this.exTeaId;
	}

	public void setExTeaId(String exTeaId) {
		this.exTeaId = exTeaId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LIB_ID")
	public TExpertLib getTExpertLib() {
		return this.TExpertLib;
	}

	public void setTExpertLib(TExpertLib TExpertLib) {
		this.TExpertLib = TExpertLib;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TEA_ID")
	public TTeacher getTTeacher() {
		return this.TTeacher;
	}

	public void setTTeacher(TTeacher TTeacher) {
		this.TTeacher = TTeacher;
	}

	@Column(name = "RE_DECL_NUM", precision = 22, scale = 0)
	public BigDecimal getReDeclNum() {
		return this.reDeclNum;
	}

	public void setReDeclNum(BigDecimal reDeclNum) {
		this.reDeclNum = reDeclNum;
	}

	@Column(name = "ISDELETED", length = 1)
	public String getIsdeleted() {
		return this.isdeleted;
	}

	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}

	@Column(name = "JQ_YEAR", precision = 22, scale = 0)
	public BigDecimal getJqYear() {
		return this.jqYear;
	}

	public void setJqYear(BigDecimal jqYear) {
		this.jqYear = jqYear;
	}

	@Column(name = "QICI", length = 20)
	public String getQici() {
		return this.qici;
	}

	public void setQici(String qici) {
		this.qici = qici;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TExpertTeacherModel")
	public Set<TEndProjectExport> getTEndProjectExports() {
		return this.TEndProjectExports;
	}

	public void setTEndProjectExports(Set<TEndProjectExport> TEndProjectExports) {
		this.TEndProjectExports = TEndProjectExports;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TExpertTeacherModel")
	public Set<TExpertReview> getTExpertReviews() {
		return this.TExpertReviews;
	}

	public void setTExpertReviews(Set<TExpertReview> TExpertReviews) {
		this.TExpertReviews = TExpertReviews;
	}

}