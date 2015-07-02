package edu.cqu.no1.domain;// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TResultDistribut entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_result_distribut", catalog = "srtp")
public class TResultDistribut implements java.io.Serializable {

	// Fields

	private String id;
	private String jqId;
	private String college;
	private String collegename;
	private String jqname;
	private Double decsum;
	private Double prosum;
	private Double bestsum;
	private Double badsum;
	private Double endsum;
	private Double delaysum;
	private Double prorate;
	private Double bestrate;
	private Double endrate;
	private Double delayrate;

	// Constructors

	/** default constructor */
	public TResultDistribut() {
	}

	/** full constructor */
	public TResultDistribut(String jqId, String college, String collegename,
			String jqname, Double decsum, Double prosum, Double bestsum,
			Double badsum, Double endsum, Double delaysum, Double prorate,
			Double bestrate, Double endrate, Double delayrate) {
		this.jqId = jqId;
		this.college = college;
		this.collegename = collegename;
		this.jqname = jqname;
		this.decsum = decsum;
		this.prosum = prosum;
		this.bestsum = bestsum;
		this.badsum = badsum;
		this.endsum = endsum;
		this.delaysum = delaysum;
		this.prorate = prorate;
		this.bestrate = bestrate;
		this.endrate = endrate;
		this.delayrate = delayrate;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "guid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "ID", unique = true, nullable = false, length = 36)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "JQ_ID", length = 32)
	public String getJqId() {
		return this.jqId;
	}

	public void setJqId(String jqId) {
		this.jqId = jqId;
	}

	@Column(name = "COLLEGE", length = 32)
	public String getCollege() {
		return this.college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	@Column(name = "COLLEGENAME", length = 50)
	public String getCollegename() {
		return this.collegename;
	}

	public void setCollegename(String collegename) {
		this.collegename = collegename;
	}

	@Column(name = "JQNAME", length = 50)
	public String getJqname() {
		return this.jqname;
	}

	public void setJqname(String jqname) {
		this.jqname = jqname;
	}

	@Column(name = "DECSUM", precision = 22, scale = 0)
	public Double getDecsum() {
		return this.decsum;
	}

	public void setDecsum(Double decsum) {
		this.decsum = decsum;
	}

	@Column(name = "PROSUM", precision = 22, scale = 0)
	public Double getProsum() {
		return this.prosum;
	}

	public void setProsum(Double prosum) {
		this.prosum = prosum;
	}

	@Column(name = "BESTSUM", precision = 22, scale = 0)
	public Double getBestsum() {
		return this.bestsum;
	}

	public void setBestsum(Double bestsum) {
		this.bestsum = bestsum;
	}

	@Column(name = "BADSUM", precision = 22, scale = 0)
	public Double getBadsum() {
		return this.badsum;
	}

	public void setBadsum(Double badsum) {
		this.badsum = badsum;
	}

	@Column(name = "ENDSUM", precision = 22, scale = 0)
	public Double getEndsum() {
		return this.endsum;
	}

	public void setEndsum(Double endsum) {
		this.endsum = endsum;
	}

	@Column(name = "DELAYSUM", precision = 22, scale = 0)
	public Double getDelaysum() {
		return this.delaysum;
	}

	public void setDelaysum(Double delaysum) {
		this.delaysum = delaysum;
	}

	@Column(name = "PRORATE", precision = 22, scale = 0)
	public Double getProrate() {
		return this.prorate;
	}

	public void setProrate(Double prorate) {
		this.prorate = prorate;
	}

	@Column(name = "BESTRATE", precision = 22, scale = 0)
	public Double getBestrate() {
		return this.bestrate;
	}

	public void setBestrate(Double bestrate) {
		this.bestrate = bestrate;
	}

	@Column(name = "ENDRATE", precision = 22, scale = 0)
	public Double getEndrate() {
		return this.endrate;
	}

	public void setEndrate(Double endrate) {
		this.endrate = endrate;
	}

	@Column(name = "DELAYRATE", precision = 22, scale = 0)
	public Double getDelayrate() {
		return this.delayrate;
	}

	public void setDelayrate(Double delayrate) {
		this.delayrate = delayrate;
	}

}