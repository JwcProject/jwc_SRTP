package edu.cqu.no1.domain;// default package

import java.sql.Timestamp;
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
 * TExpertLib entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_expert_lib", catalog = "srtp")
public class TExpertLib implements java.io.Serializable {

	// Fields

	private String libId;
	private TJieqi TJieqi;
	private TTeacher TTeacher;
	private TUnit TUnit;
	private Timestamp creatOn;
	private String isAssigned;
	private String isdeleted;
	private String type;
	private Set<TExpertTeacher> TExpertTeachers = new HashSet<TExpertTeacher>(0);
	private Set<TExpertTeacherModel> TExpertTeacherModels = new HashSet<TExpertTeacherModel>(
			0);

	// Constructors

	/** default constructor */
	public TExpertLib() {
	}

	/** full constructor */
	public TExpertLib(TJieqi TJieqi, TTeacher TTeacher, TUnit TUnit,
			Timestamp creatOn, String isAssigned, String isdeleted,
			String type, Set<TExpertTeacher> TExpertTeachers,
			Set<TExpertTeacherModel> TExpertTeacherModels) {
		this.TJieqi = TJieqi;
		this.TTeacher = TTeacher;
		this.TUnit = TUnit;
		this.creatOn = creatOn;
		this.isAssigned = isAssigned;
		this.isdeleted = isdeleted;
		this.type = type;
		this.TExpertTeachers = TExpertTeachers;
		this.TExpertTeacherModels = TExpertTeacherModels;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "guid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "lib_id", unique = true, nullable = false, length = 32)
	public String getLibId() {
		return this.libId;
	}

	public void setLibId(String libId) {
		this.libId = libId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "jq_id")
	public TJieqi getTJieqi() {
		return this.TJieqi;
	}

	public void setTJieqi(TJieqi TJieqi) {
		this.TJieqi = TJieqi;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tea_id")
	public TTeacher getTTeacher() {
		return this.TTeacher;
	}

	public void setTTeacher(TTeacher TTeacher) {
		this.TTeacher = TTeacher;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UNIT_ID")
	public TUnit getTUnit() {
		return this.TUnit;
	}

	public void setTUnit(TUnit TUnit) {
		this.TUnit = TUnit;
	}

	@Column(name = "creat_on", length = 19)
	public Timestamp getCreatOn() {
		return this.creatOn;
	}

	public void setCreatOn(Timestamp creatOn) {
		this.creatOn = creatOn;
	}

	@Column(name = "is_assigned", length = 2)
	public String getIsAssigned() {
		return this.isAssigned;
	}

	public void setIsAssigned(String isAssigned) {
		this.isAssigned = isAssigned;
	}

	@Column(name = "isdeleted", length = 1)
	public String getIsdeleted() {
		return this.isdeleted;
	}

	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}

	@Column(name = "type", length = 2)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TExpertLib")
	public Set<TExpertTeacher> getTExpertTeachers() {
		return this.TExpertTeachers;
	}

	public void setTExpertTeachers(Set<TExpertTeacher> TExpertTeachers) {
		this.TExpertTeachers = TExpertTeachers;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TExpertLib")
	public Set<TExpertTeacherModel> getTExpertTeacherModels() {
		return this.TExpertTeacherModels;
	}

	public void setTExpertTeacherModels(
			Set<TExpertTeacherModel> TExpertTeacherModels) {
		this.TExpertTeacherModels = TExpertTeacherModels;
	}

}