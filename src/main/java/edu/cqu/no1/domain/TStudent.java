package edu.cqu.no1.domain;

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
 * TStudent entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_student", catalog = "srtp2")
public class TStudent implements java.io.Serializable {

	// Fields

	private String studentId;
	private TUser TUser;
	private TProfession TProfessionByProProfessionId;
	private TProfession TProfessionByProfessionId;
	private TUnit TUnit;
	private String isdeleted;
	private String studentAge;
	private Timestamp studentBirthday;
	private String studentDegree;
	private String studentEmail;
	private String studentName;
	private String studentNumber;
	private String studentRemark;
	private String studentSex;
	private String studentTelphone;
	private Set<TDeclaration> TDeclarationsForLeaderCode = new HashSet<TDeclaration>(
			0);
	private Set<TDeclaration> TDeclarationsForMember1Code = new HashSet<TDeclaration>(
			0);
	private Set<TProject> TProjectsForProjectUser1 = new HashSet<TProject>(0);
	private Set<TDeclaration> TDeclarationsForMember2Code = new HashSet<TDeclaration>(
			0);
	private Set<TDeclJob> TDeclJobs = new HashSet<TDeclJob>(0);
	private Set<TProject> TProjectsForProjectUser2 = new HashSet<TProject>(0);
	private Set<TProject> TProjectsForProjectLeader = new HashSet<TProject>(0);
	private Set<TEndProjectJob> TEndProjectJobs = new HashSet<TEndProjectJob>(0);

	// Constructors

	/** default constructor */
	public TStudent() {
	}

	/** full constructor */
	public TStudent(TUser TUser, TProfession TProfessionByProProfessionId,
			TProfession TProfessionByProfessionId, TUnit TUnit,
			String isdeleted, String studentAge, Timestamp studentBirthday,
			String studentDegree, String studentEmail, String studentName,
			String studentNumber, String studentRemark, String studentSex,
			String studentTelphone,
			Set<TDeclaration> TDeclarationsForLeaderCode,
			Set<TDeclaration> TDeclarationsForMember1Code,
			Set<TProject> TProjectsForProjectUser1,
			Set<TDeclaration> TDeclarationsForMember2Code,
			Set<TDeclJob> TDeclJobs, Set<TProject> TProjectsForProjectUser2,
			Set<TProject> TProjectsForProjectLeader,
			Set<TEndProjectJob> TEndProjectJobs) {
		this.TUser = TUser;
		this.TProfessionByProProfessionId = TProfessionByProProfessionId;
		this.TProfessionByProfessionId = TProfessionByProfessionId;
		this.TUnit = TUnit;
		this.isdeleted = isdeleted;
		this.studentAge = studentAge;
		this.studentBirthday = studentBirthday;
		this.studentDegree = studentDegree;
		this.studentEmail = studentEmail;
		this.studentName = studentName;
		this.studentNumber = studentNumber;
		this.studentRemark = studentRemark;
		this.studentSex = studentSex;
		this.studentTelphone = studentTelphone;
		this.TDeclarationsForLeaderCode = TDeclarationsForLeaderCode;
		this.TDeclarationsForMember1Code = TDeclarationsForMember1Code;
		this.TProjectsForProjectUser1 = TProjectsForProjectUser1;
		this.TDeclarationsForMember2Code = TDeclarationsForMember2Code;
		this.TDeclJobs = TDeclJobs;
		this.TProjectsForProjectUser2 = TProjectsForProjectUser2;
		this.TProjectsForProjectLeader = TProjectsForProjectLeader;
		this.TEndProjectJobs = TEndProjectJobs;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "student_id", unique = true, nullable = false, length = 36)
	public String getStudentId() {
		return this.studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	public TUser getTUser() {
		return this.TUser;
	}

	public void setTUser(TUser TUser) {
		this.TUser = TUser;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pro_profession_id")
	public TProfession getTProfessionByProProfessionId() {
		return this.TProfessionByProProfessionId;
	}

	public void setTProfessionByProProfessionId(
			TProfession TProfessionByProProfessionId) {
		this.TProfessionByProProfessionId = TProfessionByProProfessionId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "profession_id")
	public TProfession getTProfessionByProfessionId() {
		return this.TProfessionByProfessionId;
	}

	public void setTProfessionByProfessionId(
			TProfession TProfessionByProfessionId) {
		this.TProfessionByProfessionId = TProfessionByProfessionId;
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

	@Column(name = "student_age", length = 2)
	public String getStudentAge() {
		return this.studentAge;
	}

	public void setStudentAge(String studentAge) {
		this.studentAge = studentAge;
	}

	@Column(name = "student_birthday", length = 19)
	public Timestamp getStudentBirthday() {
		return this.studentBirthday;
	}

	public void setStudentBirthday(Timestamp studentBirthday) {
		this.studentBirthday = studentBirthday;
	}

	@Column(name = "student_degree", length = 5)
	public String getStudentDegree() {
		return this.studentDegree;
	}

	public void setStudentDegree(String studentDegree) {
		this.studentDegree = studentDegree;
	}

	@Column(name = "student_email", length = 100)
	public String getStudentEmail() {
		return this.studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	@Column(name = "student_name", length = 50)
	public String getStudentName() {
		return this.studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	@Column(name = "student_number", length = 20)
	public String getStudentNumber() {
		return this.studentNumber;
	}

	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	@Column(name = "student_remark", length = 200)
	public String getStudentRemark() {
		return this.studentRemark;
	}

	public void setStudentRemark(String studentRemark) {
		this.studentRemark = studentRemark;
	}

	@Column(name = "student_sex", length = 2)
	public String getStudentSex() {
		return this.studentSex;
	}

	public void setStudentSex(String studentSex) {
		this.studentSex = studentSex;
	}

	@Column(name = "student_telphone", length = 15)
	public String getStudentTelphone() {
		return this.studentTelphone;
	}

	public void setStudentTelphone(String studentTelphone) {
		this.studentTelphone = studentTelphone;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TStudentByLeaderCode")
	public Set<TDeclaration> getTDeclarationsForLeaderCode() {
		return this.TDeclarationsForLeaderCode;
	}

	public void setTDeclarationsForLeaderCode(
			Set<TDeclaration> TDeclarationsForLeaderCode) {
		this.TDeclarationsForLeaderCode = TDeclarationsForLeaderCode;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TStudentByMember1Code")
	public Set<TDeclaration> getTDeclarationsForMember1Code() {
		return this.TDeclarationsForMember1Code;
	}

	public void setTDeclarationsForMember1Code(
			Set<TDeclaration> TDeclarationsForMember1Code) {
		this.TDeclarationsForMember1Code = TDeclarationsForMember1Code;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TStudentByProjectUser1")
	public Set<TProject> getTProjectsForProjectUser1() {
		return this.TProjectsForProjectUser1;
	}

	public void setTProjectsForProjectUser1(
			Set<TProject> TProjectsForProjectUser1) {
		this.TProjectsForProjectUser1 = TProjectsForProjectUser1;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TStudentByMember2Code")
	public Set<TDeclaration> getTDeclarationsForMember2Code() {
		return this.TDeclarationsForMember2Code;
	}

	public void setTDeclarationsForMember2Code(
			Set<TDeclaration> TDeclarationsForMember2Code) {
		this.TDeclarationsForMember2Code = TDeclarationsForMember2Code;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TStudent")
	public Set<TDeclJob> getTDeclJobs() {
		return this.TDeclJobs;
	}

	public void setTDeclJobs(Set<TDeclJob> TDeclJobs) {
		this.TDeclJobs = TDeclJobs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TStudentByProjectUser2")
	public Set<TProject> getTProjectsForProjectUser2() {
		return this.TProjectsForProjectUser2;
	}

	public void setTProjectsForProjectUser2(
			Set<TProject> TProjectsForProjectUser2) {
		this.TProjectsForProjectUser2 = TProjectsForProjectUser2;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TStudentByProjectLeader")
	public Set<TProject> getTProjectsForProjectLeader() {
		return this.TProjectsForProjectLeader;
	}

	public void setTProjectsForProjectLeader(
			Set<TProject> TProjectsForProjectLeader) {
		this.TProjectsForProjectLeader = TProjectsForProjectLeader;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TStudent")
	public Set<TEndProjectJob> getTEndProjectJobs() {
		return this.TEndProjectJobs;
	}

	public void setTEndProjectJobs(Set<TEndProjectJob> TEndProjectJobs) {
		this.TEndProjectJobs = TEndProjectJobs;
	}

}