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
 * TProfession entity. @author MyEclipse Persistence Tools
 */
@Entity
@DynamicInsert
@Table(name = "t_profession", catalog = "srtp")
public class TProfession implements java.io.Serializable {

	// Fields

	private String professionId;
	private TUnit TUnit;
	private String professionName;
	private String professionSession;
	private String professionClass;
	private String professionRemark;
	private String professionIsdeleted;
	private Set<TStudent> TStudentsForProProfessionId = new HashSet<TStudent>(0);
	private Set<TStudent> TStudentsForProfessionId = new HashSet<TStudent>(0);
	private Set<TTeacher> TTeachers = new HashSet<TTeacher>(0);

	// Constructors

	/** default constructor */
	public TProfession() {
	}

	/** full constructor */
	public TProfession(TUnit TUnit, String professionName,
			String professionSession, String professionClass,
			String professionRemark, String professionIsdeleted,
			Set<TStudent> TStudentsForProProfessionId,
			Set<TStudent> TStudentsForProfessionId, Set<TTeacher> TTeachers) {
		this.TUnit = TUnit;
		this.professionName = professionName;
		this.professionSession = professionSession;
		this.professionClass = professionClass;
		this.professionRemark = professionRemark;
		this.professionIsdeleted = professionIsdeleted;
		this.TStudentsForProProfessionId = TStudentsForProProfessionId;
		this.TStudentsForProfessionId = TStudentsForProfessionId;
		this.TTeachers = TTeachers;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "profession_id", unique = true, nullable = false, length = 32)
	public String getProfessionId() {
		return this.professionId;
	}

	public void setProfessionId(String professionId) {
		this.professionId = professionId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "unit_id")
	public TUnit getTUnit() {
		return this.TUnit;
	}

	public void setTUnit(TUnit TUnit) {
		this.TUnit = TUnit;
	}

	@Column(name = "profession_name", length = 64)
	public String getProfessionName() {
		return this.professionName;
	}

	public void setProfessionName(String professionName) {
		this.professionName = professionName;
	}

	@Column(name = "profession_session", length = 20)
	public String getProfessionSession() {
		return this.professionSession;
	}

	public void setProfessionSession(String professionSession) {
		this.professionSession = professionSession;
	}

	@Column(name = "profession_class", length = 64)
	public String getProfessionClass() {
		return this.professionClass;
	}

	public void setProfessionClass(String professionClass) {
		this.professionClass = professionClass;
	}

	@Column(name = "profession_remark", length = 200)
	public String getProfessionRemark() {
		return this.professionRemark;
	}

	public void setProfessionRemark(String professionRemark) {
		this.professionRemark = professionRemark;
	}

	@Column(name = "profession_isdeleted", length = 1)
	public String getProfessionIsdeleted() {
		return this.professionIsdeleted;
	}

	public void setProfessionIsdeleted(String professionIsdeleted) {
		this.professionIsdeleted = professionIsdeleted;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TProfessionByProProfessionId")
	public Set<TStudent> getTStudentsForProProfessionId() {
		return this.TStudentsForProProfessionId;
	}

	public void setTStudentsForProProfessionId(
			Set<TStudent> TStudentsForProProfessionId) {
		this.TStudentsForProProfessionId = TStudentsForProProfessionId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TProfessionByProfessionId")
	public Set<TStudent> getTStudentsForProfessionId() {
		return this.TStudentsForProfessionId;
	}

	public void setTStudentsForProfessionId(
			Set<TStudent> TStudentsForProfessionId) {
		this.TStudentsForProfessionId = TStudentsForProfessionId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TProfession")
	public Set<TTeacher> getTTeachers() {
		return this.TTeachers;
	}

	public void setTTeachers(Set<TTeacher> TTeachers) {
		this.TTeachers = TTeachers;
	}

}