package edu.cqu.no1.domain;// default package

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

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.GenericGenerator;

/**
 * TExpertReview entity. @author MyEclipse Persistence Tools
 */
@Entity
@DynamicInsert
@Table(name = "t_expert_review", catalog = "srtp")
public class TExpertReview implements java.io.Serializable {

	// Fields

	private String exReviewId;
	private TDeclaration TDeclaration;
	private TExpertTeacherModel TExpertTeacherModel;
	private TExpertTeacher TExpertTeacher;
	private String isdeleted;
	private Set<TDeclComment> TDeclComments = new HashSet<TDeclComment>(0);

	// Constructors

	/** default constructor */
	public TExpertReview() {
	}

	/** full constructor */
	public TExpertReview(TDeclaration TDeclaration,
			TExpertTeacherModel TExpertTeacherModel,
			TExpertTeacher TExpertTeacher, String isdeleted,
			Set<TDeclComment> TDeclComments) {
		this.TDeclaration = TDeclaration;
		this.TExpertTeacherModel = TExpertTeacherModel;
		this.TExpertTeacher = TExpertTeacher;
		this.isdeleted = isdeleted;
		this.TDeclComments = TDeclComments;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "ex_review_id", unique = true, nullable = false, length = 32)
	public String getExReviewId() {
		return this.exReviewId;
	}

	public void setExReviewId(String exReviewId) {
		this.exReviewId = exReviewId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "declar_id")
	public TDeclaration getTDeclaration() {
		return this.TDeclaration;
	}

	public void setTDeclaration(TDeclaration TDeclaration) {
		this.TDeclaration = TDeclaration;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ex_tea_id")
	public TExpertTeacherModel getTExpertTeacherModel() {
		return this.TExpertTeacherModel;
	}

	public void setTExpertTeacherModel(TExpertTeacherModel TExpertTeacherModel) {
		this.TExpertTeacherModel = TExpertTeacherModel;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ex_tea_id", insertable = false, updatable = false)
	public TExpertTeacher getTExpertTeacher() {
		return this.TExpertTeacher;
	}

	public void setTExpertTeacher(TExpertTeacher TExpertTeacher) {
		this.TExpertTeacher = TExpertTeacher;
	}

	@Column(name = "isdeleted", columnDefinition = "varchar(1) default 'N'")
	public String getIsdeleted() {
		return this.isdeleted;
	}

	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TExpertReview")
	public Set<TDeclComment> getTDeclComments() {
		return this.TDeclComments;
	}

	public void setTDeclComments(Set<TDeclComment> TDeclComments) {
		this.TDeclComments = TDeclComments;
	}

}