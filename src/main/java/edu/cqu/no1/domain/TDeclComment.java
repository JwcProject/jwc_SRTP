package edu.cqu.no1.domain;// default package

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
 * TDeclComment entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_decl_comment", catalog = "srtp")
public class TDeclComment implements java.io.Serializable {

	// Fields

	private String declComId;
	private TExpertReview TExpertReview;
	private String declArgument;
	private String compEval;
	private Integer declScore;
	private Timestamp reviewTime;
	private String isdeleted;

	// Constructors

	/** default constructor */
	public TDeclComment() {
	}

	/** full constructor */
	public TDeclComment(TExpertReview TExpertReview, String declArgument,
			String compEval, Integer declScore, Timestamp reviewTime,
			String isdeleted) {
		this.TExpertReview = TExpertReview;
		this.declArgument = declArgument;
		this.compEval = compEval;
		this.declScore = declScore;
		this.reviewTime = reviewTime;
		this.isdeleted = isdeleted;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "guid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "decl_com_id", unique = true, nullable = false, length = 32)
	public String getDeclComId() {
		return this.declComId;
	}

	public void setDeclComId(String declComId) {
		this.declComId = declComId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ex_review_id")
	public TExpertReview getTExpertReview() {
		return this.TExpertReview;
	}

	public void setTExpertReview(TExpertReview TExpertReview) {
		this.TExpertReview = TExpertReview;
	}

	@Column(name = "decl_argument", length = 500)
	public String getDeclArgument() {
		return this.declArgument;
	}

	public void setDeclArgument(String declArgument) {
		this.declArgument = declArgument;
	}

	@Column(name = "comp_eval", length = 5)
	public String getCompEval() {
		return this.compEval;
	}

	public void setCompEval(String compEval) {
		this.compEval = compEval;
	}

	@Column(name = "decl_score")
	public Integer getDeclScore() {
		return this.declScore;
	}

	public void setDeclScore(Integer declScore) {
		this.declScore = declScore;
	}

	@Column(name = "review_time", length = 19)
	public Timestamp getReviewTime() {
		return this.reviewTime;
	}

	public void setReviewTime(Timestamp reviewTime) {
		this.reviewTime = reviewTime;
	}

	@Column(name = "isdeleted", length = 1)
	public String getIsdeleted() {
		return this.isdeleted;
	}

	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}

}