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
 * TTeacher entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_teacher", catalog = "srtp")
public class TTeacher implements java.io.Serializable {

	// Fields

	private String teaId;
	private TProfession TProfession;
	private TUnit TUnit;
	private String isdeleted;
	private String teaEmail;
	private Double teaAge;
	private String teaCode;
	private String teaIntro;
	private String teaName;
	private String teaRemark;
	private String teaSex;
	private String teaState;
	private String teaTele;
	private String teaTitle;
	private Set<TDeclaration> TDeclarationsForTeacher2Code = new HashSet<TDeclaration>(
			0);
	private Set<TEmail> TEmails = new HashSet<TEmail>(0);
	private Set<TProject> TProjectsForProjectTeacher1 = new HashSet<TProject>(0);
	private Set<TExpertLib> TExpertLibs = new HashSet<TExpertLib>(0);
	private Set<TDeclaration> TDeclarationsForTeacher1Code = new HashSet<TDeclaration>(
			0);
	private Set<TExpertTeacherModel> TExpertTeacherModels = new HashSet<TExpertTeacherModel>(
			0);
	private Set<TProject> TProjectsForProjectTeacher2 = new HashSet<TProject>(0);
	private Set<TExpertTeacher> TExpertTeachers = new HashSet<TExpertTeacher>(0);

	// Constructors

	/** default constructor */
	public TTeacher() {
	}

	/** full constructor */
	public TTeacher(TProfession TProfession, TUnit TUnit, String isdeleted,
			String teaEmail, Double teaAge, String teaCode, String teaIntro,
			String teaName, String teaRemark, String teaSex, String teaState,
			String teaTele, String teaTitle,
			Set<TDeclaration> TDeclarationsForTeacher2Code,
			Set<TEmail> TEmails, Set<TProject> TProjectsForProjectTeacher1,
			Set<TExpertLib> TExpertLibs,
			Set<TDeclaration> TDeclarationsForTeacher1Code,
			Set<TExpertTeacherModel> TExpertTeacherModels,
			Set<TProject> TProjectsForProjectTeacher2,
			Set<TExpertTeacher> TExpertTeachers) {
		this.TProfession = TProfession;
		this.TUnit = TUnit;
		this.isdeleted = isdeleted;
		this.teaEmail = teaEmail;
		this.teaAge = teaAge;
		this.teaCode = teaCode;
		this.teaIntro = teaIntro;
		this.teaName = teaName;
		this.teaRemark = teaRemark;
		this.teaSex = teaSex;
		this.teaState = teaState;
		this.teaTele = teaTele;
		this.teaTitle = teaTitle;
		this.TDeclarationsForTeacher2Code = TDeclarationsForTeacher2Code;
		this.TEmails = TEmails;
		this.TProjectsForProjectTeacher1 = TProjectsForProjectTeacher1;
		this.TExpertLibs = TExpertLibs;
		this.TDeclarationsForTeacher1Code = TDeclarationsForTeacher1Code;
		this.TExpertTeacherModels = TExpertTeacherModels;
		this.TProjectsForProjectTeacher2 = TProjectsForProjectTeacher2;
		this.TExpertTeachers = TExpertTeachers;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "tea_id", unique = true, nullable = false, length = 36)
	public String getTeaId() {
		return this.teaId;
	}

	public void setTeaId(String teaId) {
		this.teaId = teaId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "profession_id")
	public TProfession getTProfession() {
		return this.TProfession;
	}

	public void setTProfession(TProfession TProfession) {
		this.TProfession = TProfession;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UNIT_ID")
	public TUnit getTUnit() {
		return this.TUnit;
	}

	public void setTUnit(TUnit TUnit) {
		this.TUnit = TUnit;
	}

	@Column(name = "isdeleted", length = 1)
	public String getIsdeleted() {
		return this.isdeleted;
	}

	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}

	@Column(name = "tea_email", length = 50)
	public String getTeaEmail() {
		return this.teaEmail;
	}

	public void setTeaEmail(String teaEmail) {
		this.teaEmail = teaEmail;
	}

	@Column(name = "tea_age")
	public Double getTeaAge() {
		return this.teaAge;
	}

	public void setTeaAge(Double teaAge) {
		this.teaAge = teaAge;
	}

	@Column(name = "tea_code", length = 20)
	public String getTeaCode() {
		return this.teaCode;
	}

	public void setTeaCode(String teaCode) {
		this.teaCode = teaCode;
	}

	@Column(name = "tea_intro", length = 1000)
	public String getTeaIntro() {
		return this.teaIntro;
	}

	public void setTeaIntro(String teaIntro) {
		this.teaIntro = teaIntro;
	}

	@Column(name = "tea_name", length = 50)
	public String getTeaName() {
		return this.teaName;
	}

	public void setTeaName(String teaName) {
		this.teaName = teaName;
	}

	@Column(name = "tea_remark", length = 1000)
	public String getTeaRemark() {
		return this.teaRemark;
	}

	public void setTeaRemark(String teaRemark) {
		this.teaRemark = teaRemark;
	}

	@Column(name = "tea_sex", length = 2)
	public String getTeaSex() {
		return this.teaSex;
	}

	public void setTeaSex(String teaSex) {
		this.teaSex = teaSex;
	}

	@Column(name = "tea_state", length = 2)
	public String getTeaState() {
		return this.teaState;
	}

	public void setTeaState(String teaState) {
		this.teaState = teaState;
	}

	@Column(name = "tea_tele", length = 20)
	public String getTeaTele() {
		return this.teaTele;
	}

	public void setTeaTele(String teaTele) {
		this.teaTele = teaTele;
	}

	@Column(name = "tea_title", length = 50)
	public String getTeaTitle() {
		return this.teaTitle;
	}

	public void setTeaTitle(String teaTitle) {
		this.teaTitle = teaTitle;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TTeacherByTeacher2Code")
	public Set<TDeclaration> getTDeclarationsForTeacher2Code() {
		return this.TDeclarationsForTeacher2Code;
	}

	public void setTDeclarationsForTeacher2Code(
			Set<TDeclaration> TDeclarationsForTeacher2Code) {
		this.TDeclarationsForTeacher2Code = TDeclarationsForTeacher2Code;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TTeacher")
	public Set<TEmail> getTEmails() {
		return this.TEmails;
	}

	public void setTEmails(Set<TEmail> TEmails) {
		this.TEmails = TEmails;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TTeacherByProjectTeacher1")
	public Set<TProject> getTProjectsForProjectTeacher1() {
		return this.TProjectsForProjectTeacher1;
	}

	public void setTProjectsForProjectTeacher1(
			Set<TProject> TProjectsForProjectTeacher1) {
		this.TProjectsForProjectTeacher1 = TProjectsForProjectTeacher1;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TTeacher")
	public Set<TExpertLib> getTExpertLibs() {
		return this.TExpertLibs;
	}

	public void setTExpertLibs(Set<TExpertLib> TExpertLibs) {
		this.TExpertLibs = TExpertLibs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TTeacherByTeacher1Code")
	public Set<TDeclaration> getTDeclarationsForTeacher1Code() {
		return this.TDeclarationsForTeacher1Code;
	}

	public void setTDeclarationsForTeacher1Code(
			Set<TDeclaration> TDeclarationsForTeacher1Code) {
		this.TDeclarationsForTeacher1Code = TDeclarationsForTeacher1Code;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TTeacher")
	public Set<TExpertTeacherModel> getTExpertTeacherModels() {
		return this.TExpertTeacherModels;
	}

	public void setTExpertTeacherModels(
			Set<TExpertTeacherModel> TExpertTeacherModels) {
		this.TExpertTeacherModels = TExpertTeacherModels;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TTeacherByProjectTeacher2")
	public Set<TProject> getTProjectsForProjectTeacher2() {
		return this.TProjectsForProjectTeacher2;
	}

	public void setTProjectsForProjectTeacher2(
			Set<TProject> TProjectsForProjectTeacher2) {
		this.TProjectsForProjectTeacher2 = TProjectsForProjectTeacher2;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TTeacher")
	public Set<TExpertTeacher> getTExpertTeachers() {
		return this.TExpertTeachers;
	}

	public void setTExpertTeachers(Set<TExpertTeacher> TExpertTeachers) {
		this.TExpertTeachers = TExpertTeachers;
	}

}