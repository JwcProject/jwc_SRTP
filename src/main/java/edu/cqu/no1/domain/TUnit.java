package edu.cqu.no1.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TUnit entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_unit", catalog = "srtp2")
public class TUnit implements java.io.Serializable {

	// Fields

	private String unitId;
	private String isdeleted;
	private String unitCode;
	private String unitFatherid;
	private String unitName;
	private String unitRemark;
	private String unitType;
	private Set<TEndProject> TEndProjects = new HashSet<TEndProject>(0);
	private Set<TProfession> TProfessions = new HashSet<TProfession>(0);
	private Set<TDeclaration> TDeclarations = new HashSet<TDeclaration>(0);
	private Set<TStudent> TStudents = new HashSet<TStudent>(0);
	private Set<TProject> TProjects = new HashSet<TProject>(0);
	private Set<TTeacher> TTeachers = new HashSet<TTeacher>(0);
	private Set<TExpertLib> TExpertLibs = new HashSet<TExpertLib>(0);

	// Constructors

	/** default constructor */
	public TUnit() {
	}

	/** full constructor */
	public TUnit(String isdeleted, String unitCode, String unitFatherid,
			String unitName, String unitRemark, String unitType,
			Set<TEndProject> TEndProjects, Set<TProfession> TProfessions,
			Set<TDeclaration> TDeclarations, Set<TStudent> TStudents,
			Set<TProject> TProjects, Set<TTeacher> TTeachers,
			Set<TExpertLib> TExpertLibs) {
		this.isdeleted = isdeleted;
		this.unitCode = unitCode;
		this.unitFatherid = unitFatherid;
		this.unitName = unitName;
		this.unitRemark = unitRemark;
		this.unitType = unitType;
		this.TEndProjects = TEndProjects;
		this.TProfessions = TProfessions;
		this.TDeclarations = TDeclarations;
		this.TStudents = TStudents;
		this.TProjects = TProjects;
		this.TTeachers = TTeachers;
		this.TExpertLibs = TExpertLibs;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "unit_id", unique = true, nullable = false, length = 36)
	public String getUnitId() {
		return this.unitId;
	}

	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}

	@Column(name = "isdeleted", length = 1)
	public String getIsdeleted() {
		return this.isdeleted;
	}

	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}

	@Column(name = "unit_code", length = 100)
	public String getUnitCode() {
		return this.unitCode;
	}

	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}

	@Column(name = "unit_fatherid", length = 32)
	public String getUnitFatherid() {
		return this.unitFatherid;
	}

	public void setUnitFatherid(String unitFatherid) {
		this.unitFatherid = unitFatherid;
	}

	@Column(name = "unit_name", length = 100)
	public String getUnitName() {
		return this.unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	@Column(name = "unit_remark", length = 200)
	public String getUnitRemark() {
		return this.unitRemark;
	}

	public void setUnitRemark(String unitRemark) {
		this.unitRemark = unitRemark;
	}

	@Column(name = "unit_type", length = 2)
	public String getUnitType() {
		return this.unitType;
	}

	public void setUnitType(String unitType) {
		this.unitType = unitType;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TUnit")
	public Set<TEndProject> getTEndProjects() {
		return this.TEndProjects;
	}

	public void setTEndProjects(Set<TEndProject> TEndProjects) {
		this.TEndProjects = TEndProjects;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TUnit")
	public Set<TProfession> getTProfessions() {
		return this.TProfessions;
	}

	public void setTProfessions(Set<TProfession> TProfessions) {
		this.TProfessions = TProfessions;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TUnit")
	public Set<TDeclaration> getTDeclarations() {
		return this.TDeclarations;
	}

	public void setTDeclarations(Set<TDeclaration> TDeclarations) {
		this.TDeclarations = TDeclarations;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TUnit")
	public Set<TStudent> getTStudents() {
		return this.TStudents;
	}

	public void setTStudents(Set<TStudent> TStudents) {
		this.TStudents = TStudents;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TUnit")
	public Set<TProject> getTProjects() {
		return this.TProjects;
	}

	public void setTProjects(Set<TProject> TProjects) {
		this.TProjects = TProjects;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TUnit")
	public Set<TTeacher> getTTeachers() {
		return this.TTeachers;
	}

	public void setTTeachers(Set<TTeacher> TTeachers) {
		this.TTeachers = TTeachers;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TUnit")
	public Set<TExpertLib> getTExpertLibs() {
		return this.TExpertLibs;
	}

	public void setTExpertLibs(Set<TExpertLib> TExpertLibs) {
		this.TExpertLibs = TExpertLibs;
	}

}