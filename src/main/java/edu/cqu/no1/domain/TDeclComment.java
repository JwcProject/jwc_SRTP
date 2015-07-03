package edu.cqu.no1.domain;

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
@Table(name = "t_decl_comment", catalog = "srtp2")
public class TDeclComment implements java.io.Serializable {

	// Fields

	private String declComId;
	private TExpertReview TExpertReview;
	private String compEval;
	private String declArgument;
	private Integer declScore;
	private String isdeleted;
	private Timestamp reviewTime;

	// Constructors

	/** default constructor */
	public TDeclComment() {
	}

	/** full constructor */
	public TDeclComment(TExpertReview TExpertReview, String compEval,
			String declArgument, Integer declScore, String isdeleted,
			Timestamp reviewTime) {
		this.TExpertReview = TExpertReview;
		this.compEval = compEval;
		this.declArgument = declArgument;
		this.declScore = declScore;
		this.isdeleted = isdeleted;
		this.reviewTime = reviewTime;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "decl_com_id", unique = true, nullable = false, length = 36)
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

	@Column(name = "comp_eval", length = 5)
	public String getCompEval() {
		return this.compEval;
	}

	public void setCompEval(String compEval) {
		this.compEval = compEval;
	}

	@Column(name = "decl_argument", length = 500)
	public String getDeclArgument() {
		return this.declArgument;
	}

	public void setDeclArgument(String declArgument) {
		this.declArgument = declArgument;
	}

	@Column(name = "decl_score")
	public Integer getDeclScore() {
		return this.declScore;
	}

	public void setDeclScore(Integer declScore) {
		this.declScore = declScore;
	}

	@Column(name = "isdeleted", length = 1)
	public String getIsdeleted() {
		return this.isdeleted;
	}

	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}

	@Column(name = "review_time", length = 19)
	public Timestamp getReviewTime() {
		return this.reviewTime;
	}

	public void setReviewTime(Timestamp reviewTime) {
		this.reviewTime = reviewTime;
	}

}