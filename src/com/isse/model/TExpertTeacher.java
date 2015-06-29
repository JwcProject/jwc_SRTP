package com.isse.model;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import org.apache.struts2.json.annotations.JSON;

/**
 * TExpertTeacher entity. @author MyEclipse Persistence Tools
 */

public class TExpertTeacher implements java.io.Serializable {

	// Fields

	private String exTeaId;
	private TExpertLib TExpertLib;
	private TTeacher TTeacher;
	private BigDecimal reDeclNum;
	private String isdeleted;
	private Set TExpertReviews = new HashSet(0);
	private Set TEndProjectExports = new HashSet(0);

	// Constructors

	/** default constructor */
	public TExpertTeacher() {
	}

	/** full constructor */
	public TExpertTeacher(TExpertLib TExpertLib, TTeacher TTeacher,
			BigDecimal reDeclNum, String isdeleted, Set TExpertReviews,
			Set TEndProjectExports) {
		this.TExpertLib = TExpertLib;
		this.TTeacher = TTeacher;
		this.reDeclNum = reDeclNum;
		this.isdeleted = isdeleted;
		this.TExpertReviews = TExpertReviews;
		this.TEndProjectExports = TEndProjectExports;
	}

	// Property accessors

	public String getExTeaId() {
		return this.exTeaId;
	}

	public void setExTeaId(String exTeaId) {
		this.exTeaId = exTeaId;
	}

	public TExpertLib getTExpertLib() {
		return this.TExpertLib;
	}

	public void setTExpertLib(TExpertLib TExpertLib) {
		this.TExpertLib = TExpertLib;
	}

	public TTeacher getTTeacher() {
		return this.TTeacher;
	}

	public void setTTeacher(TTeacher TTeacher) {
		this.TTeacher = TTeacher;
	}

	public BigDecimal getReDeclNum() {
		return this.reDeclNum;
	}

	public void setReDeclNum(BigDecimal reDeclNum) {
		this.reDeclNum = reDeclNum;
	}

	public String getIsdeleted() {
		return this.isdeleted;
	}

	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}
	@JSON(serialize=false)
	public Set getTExpertReviews() {
		return this.TExpertReviews;
	}

	public void setTExpertReviews(Set TExpertReviews) {
		this.TExpertReviews = TExpertReviews;
	}
	@JSON(serialize=false)
	public Set getTEndProjectExports() {
		return this.TEndProjectExports;
	}

	public void setTEndProjectExports(Set TEndProjectExports) {
		this.TEndProjectExports = TEndProjectExports;
	}

}