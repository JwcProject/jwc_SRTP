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

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.GenericGenerator;

/**
 * TEndProjectComment entity. @author MyEclipse Persistence Tools
 */
@Entity
@DynamicInsert
@Table(name = "t_end_project_comment", catalog = "srtp")
public class TEndProjectComment implements java.io.Serializable {

	// Fields

	private String id;
	private TEndProjectExport TEndProjectExport;
	private String endProjectCommentAdvise;
	private Integer endProjectCommentScore;
	private String endProjectCommentContent;
	private String isdeleted;
	private Timestamp endProjectCommentTime;

	// Constructors

	/** default constructor */
	public TEndProjectComment() {
	}

	/** full constructor */
	public TEndProjectComment(TEndProjectExport TEndProjectExport,
			String endProjectCommentAdvise, Integer endProjectCommentScore,
			String endProjectCommentContent, String isdeleted,
			Timestamp endProjectCommentTime) {
		this.TEndProjectExport = TEndProjectExport;
		this.endProjectCommentAdvise = endProjectCommentAdvise;
		this.endProjectCommentScore = endProjectCommentScore;
		this.endProjectCommentContent = endProjectCommentContent;
		this.isdeleted = isdeleted;
		this.endProjectCommentTime = endProjectCommentTime;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
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
	@JoinColumn(name = "EProjectExport_id")
	public TEndProjectExport getTEndProjectExport() {
		return this.TEndProjectExport;
	}

	public void setTEndProjectExport(TEndProjectExport TEndProjectExport) {
		this.TEndProjectExport = TEndProjectExport;
	}

	@Column(name = "endProjectComment_advise", length = 200)
	public String getEndProjectCommentAdvise() {
		return this.endProjectCommentAdvise;
	}

	public void setEndProjectCommentAdvise(String endProjectCommentAdvise) {
		this.endProjectCommentAdvise = endProjectCommentAdvise;
	}

	@Column(name = "endProjectComment_score")
	public Integer getEndProjectCommentScore() {
		return this.endProjectCommentScore;
	}

	public void setEndProjectCommentScore(Integer endProjectCommentScore) {
		this.endProjectCommentScore = endProjectCommentScore;
	}

	@Column(name = "endProjectComment_content", length = 5)
	public String getEndProjectCommentContent() {
		return this.endProjectCommentContent;
	}

	public void setEndProjectCommentContent(String endProjectCommentContent) {
		this.endProjectCommentContent = endProjectCommentContent;
	}

	@Column(name = "isdeleted", nullable = false, columnDefinition = "varchar(1) default 'N'")
	public String getIsdeleted() {
		return this.isdeleted;
	}

	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}

	@Column(name = "endProjectComment_time", length = 19)
	public Timestamp getEndProjectCommentTime() {
		return this.endProjectCommentTime;
	}

	public void setEndProjectCommentTime(Timestamp endProjectCommentTime) {
		this.endProjectCommentTime = endProjectCommentTime;
	}

}