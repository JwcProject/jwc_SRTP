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
 * TProfession entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_profession", catalog = "srtp")
public class TProfession implements java.io.Serializable {

	// Fields

	private String professionId;
	private TUnit TUnit;
	private String professionClass;
	private String professionIsdeleted;
	private String professionName;
	private String professionRemark;
	private String professionSession;
	private Set<TStudent> TStudentsForProProfessionId = new HashSet<TStudent>(0);
	private Set<TTeacher> TTeachers = new HashSet<TTeacher>(0);
	private Set<TStudent> TStudentsForProfessionId = new HashSet<TStudent>(0);

	// Constructors

	/** default constructor */
	public TProfession() {
	}

	/** full constructor */
	public TProfession(TUnit TUnit, String professionClass,
			String professionIsdeleted, String professionName,
			String professionRemark, String professionSession,
			Set<TStudent> TStudentsForProProfessionId, Set<TTeacher> TTeachers,
			Set<TStudent> TStudentsForProfessionId) {
		this.TUnit = TUnit;
		this.professionClass = professionClass;
		this.professionIsdeleted = professionIsdeleted;
		this.professionName = professionName;
		this.professionRemark = professionRemark;
		this.professionSession = professionSession;
		this.TStudentsForProProfessionId = TStudentsForProProfessionId;
		this.TTeachers = TTeachers;
		this.TStudentsForProfessionId = TStudentsForProfessionId;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "profession_id", unique = true, nullable = false, length = 36)
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

	@Column(name = "profession_class", length = 64)
	public String getProfessionClass() {
		return this.professionClass;
	}

	public void setProfessionClass(String professionClass) {
		this.professionClass = professionClass;
	}

	@Column(name = "profession_isdeleted", length = 1)
	public String getProfessionIsdeleted() {
		return this.professionIsdeleted;
	}

	public void setProfessionIsdeleted(String professionIsdeleted) {
		this.professionIsdeleted = professionIsdeleted;
	}

	@Column(name = "profession_name", length = 64)
	public String getProfessionName() {
		return this.professionName;
	}

	public void setProfessionName(String professionName) {
		this.professionName = professionName;
	}

	@Column(name = "profession_remark", length = 200)
	public String getProfessionRemark() {
		return this.professionRemark;
	}

	public void setProfessionRemark(String professionRemark) {
		this.professionRemark = professionRemark;
	}

	@Column(name = "profession_session", length = 20)
	public String getProfessionSession() {
		return this.professionSession;
	}

	public void setProfessionSession(String professionSession) {
		this.professionSession = professionSession;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TProfessionByProProfessionId")
	public Set<TStudent> getTStudentsForProProfessionId() {
		return this.TStudentsForProProfessionId;
	}

	public void setTStudentsForProProfessionId(
			Set<TStudent> TStudentsForProProfessionId) {
		this.TStudentsForProProfessionId = TStudentsForProProfessionId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TProfession")
	public Set<TTeacher> getTTeachers() {
		return this.TTeachers;
	}

	public void setTTeachers(Set<TTeacher> TTeachers) {
		this.TTeachers = TTeachers;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TProfessionByProfessionId")
	public Set<TStudent> getTStudentsForProfessionId() {
		return this.TStudentsForProfessionId;
	}

	public void setTStudentsForProfessionId(
			Set<TStudent> TStudentsForProfessionId) {
		this.TStudentsForProfessionId = TStudentsForProfessionId;
	}

}