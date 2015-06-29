package com.isse.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.apache.struts2.json.annotations.JSON;

/**
 * TStudent entity. @author MyEclipse Persistence Tools
 */

public class TStudent implements java.io.Serializable {

	// Fields

	private String studentId;
	private TUser TUser;
	private TProfession TProfession;
	private TUnit TUnit;
	private String studentNumber;
	private Date studentBirthday;
	private String studentSex;
	private String studentName;
	private String studentAge;
	private String studentEmail;
	private String studentTelphone;
	private String studentDegree;
	private String studentRemark;
	private String isdeleted;
	private Set TDeclarationsForLeaderCode = new HashSet(0);
	private Set TDeclarationsForMember1Code = new HashSet(0);
	private Set TDeclarationsForMember2Code = new HashSet(0);
	private Set TDeclJobs = new HashSet(0);

	// Constructors

	/** default constructor */
	public TStudent() {
	}

	/** full constructor */
	public TStudent(TUser TUser, TProfession TProfession, TUnit TUnit,
			String studentNumber, Date studentBirthday, String studentSex,
			String studentName, String studentAge, String studentEmail,
			String studentTelphone, String studentDegree, String studentRemark,
			String isdeleted, Set TDeclarationsForLeaderCode,
			Set TDeclarationsForMember1Code, Set TDeclarationsForMember2Code,
			Set TDeclJobs) {
		this.TUser = TUser;
		this.TProfession = TProfession;
		this.TUnit = TUnit;
		this.studentNumber = studentNumber;
		this.studentBirthday = studentBirthday;
		this.studentSex = studentSex;
		this.studentName = studentName;
		this.studentAge = studentAge;
		this.studentEmail = studentEmail;
		this.studentTelphone = studentTelphone;
		this.studentDegree = studentDegree;
		this.studentRemark = studentRemark;
		this.isdeleted = isdeleted;
		this.TDeclarationsForLeaderCode = TDeclarationsForLeaderCode;
		this.TDeclarationsForMember1Code = TDeclarationsForMember1Code;
		this.TDeclarationsForMember2Code = TDeclarationsForMember2Code;
		this.TDeclJobs = TDeclJobs;
	}

	// Property accessors

	public String getStudentId() {
		return this.studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	@JSON(serialize=false)
	public TUser getTUser() {
		return this.TUser;
	}

	public void setTUser(TUser TUser) {
		this.TUser = TUser;
	}
	@JSON(serialize=false)
	public TProfession getTProfession() {
		return this.TProfession;
	}

	public void setTProfession(TProfession TProfession) {
		this.TProfession = TProfession;
	}

	public TUnit getTUnit() {
		return this.TUnit;
	}

	public void setTUnit(TUnit TUnit) {
		this.TUnit = TUnit;
	}

	public String getStudentNumber() {
		return this.studentNumber;
	}

	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	public Date getStudentBirthday() {
		return this.studentBirthday;
	}

	public void setStudentBirthday(Date studentBirthday) {
		this.studentBirthday = studentBirthday;
	}

	public String getStudentSex() {
		return this.studentSex;
	}

	public void setStudentSex(String studentSex) {
		this.studentSex = studentSex;
	}

	public String getStudentName() {
		return this.studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentAge() {
		return this.studentAge;
	}

	public void setStudentAge(String studentAge) {
		this.studentAge = studentAge;
	}

	public String getStudentEmail() {
		return this.studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	public String getStudentTelphone() {
		return this.studentTelphone;
	}

	public void setStudentTelphone(String studentTelphone) {
		this.studentTelphone = studentTelphone;
	}

	public String getStudentDegree() {
		return this.studentDegree;
	}

	public void setStudentDegree(String studentDegree) {
		this.studentDegree = studentDegree;
	}

	public String getStudentRemark() {
		return this.studentRemark;
	}

	public void setStudentRemark(String studentRemark) {
		this.studentRemark = studentRemark;
	}

	public String getIsdeleted() {
		return this.isdeleted;
	}

	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}
	@JSON(serialize=false)
	public Set getTDeclarationsForLeaderCode() {
		return this.TDeclarationsForLeaderCode;
	}

	public void setTDeclarationsForLeaderCode(Set TDeclarationsForLeaderCode) {
		this.TDeclarationsForLeaderCode = TDeclarationsForLeaderCode;
	}
	@JSON(serialize=false)
	public Set getTDeclarationsForMember1Code() {
		return this.TDeclarationsForMember1Code;
	}

	public void setTDeclarationsForMember1Code(Set TDeclarationsForMember1Code) {
		this.TDeclarationsForMember1Code = TDeclarationsForMember1Code;
	}
	@JSON(serialize=false)
	public Set getTDeclarationsForMember2Code() {
		return this.TDeclarationsForMember2Code;
	}

	public void setTDeclarationsForMember2Code(Set TDeclarationsForMember2Code) {
		this.TDeclarationsForMember2Code = TDeclarationsForMember2Code;
	}
	@JSON(serialize=false)
	public Set getTDeclJobs() {
		return this.TDeclJobs;
	}

	public void setTDeclJobs(Set TDeclJobs) {
		this.TDeclJobs = TDeclJobs;
	}

}