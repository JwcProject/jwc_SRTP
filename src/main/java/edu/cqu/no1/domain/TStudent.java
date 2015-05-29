package edu.cqu.no1.domain;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Created by Huxley on 5/29/15.
 */
@Entity
@javax.persistence.Table(name = "t_student", schema = "", catalog = "srtp")
public class TStudent {
    private String studentId;

    @Id
    @javax.persistence.Column(name = "student_id")
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    private String userId;

    @Basic
    @javax.persistence.Column(name = "user_id")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    private String proProfessionId;

    @Basic
    @javax.persistence.Column(name = "pro_profession_id")
    public String getProProfessionId() {
        return proProfessionId;
    }

    public void setProProfessionId(String proProfessionId) {
        this.proProfessionId = proProfessionId;
    }

    private String studentNumber;

    @Basic
    @javax.persistence.Column(name = "student_number")
    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    private Timestamp studentBirthday;

    @Basic
    @javax.persistence.Column(name = "student_birthday")
    public Timestamp getStudentBirthday() {
        return studentBirthday;
    }

    public void setStudentBirthday(Timestamp studentBirthday) {
        this.studentBirthday = studentBirthday;
    }

    private String studentSex;

    @Basic
    @javax.persistence.Column(name = "student_sex")
    public String getStudentSex() {
        return studentSex;
    }

    public void setStudentSex(String studentSex) {
        this.studentSex = studentSex;
    }

    private String studentName;

    @Basic
    @javax.persistence.Column(name = "student_name")
    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    private String studentAge;

    @Basic
    @javax.persistence.Column(name = "student_age")
    public String getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(String studentAge) {
        this.studentAge = studentAge;
    }

    private String studentEmail;

    @Basic
    @javax.persistence.Column(name = "student_email")
    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    private String studentTelphone;

    @Basic
    @javax.persistence.Column(name = "student_telphone")
    public String getStudentTelphone() {
        return studentTelphone;
    }

    public void setStudentTelphone(String studentTelphone) {
        this.studentTelphone = studentTelphone;
    }

    private String studentDegree;

    @Basic
    @javax.persistence.Column(name = "student_degree")
    public String getStudentDegree() {
        return studentDegree;
    }

    public void setStudentDegree(String studentDegree) {
        this.studentDegree = studentDegree;
    }

    private String studentRemark;

    @Basic
    @javax.persistence.Column(name = "student_remark")
    public String getStudentRemark() {
        return studentRemark;
    }

    public void setStudentRemark(String studentRemark) {
        this.studentRemark = studentRemark;
    }

    private String professionId;

    @Basic
    @javax.persistence.Column(name = "profession_id")
    public String getProfessionId() {
        return professionId;
    }

    public void setProfessionId(String professionId) {
        this.professionId = professionId;
    }

    private String isdeleted;

    @Basic
    @javax.persistence.Column(name = "isdeleted")
    public String getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(String isdeleted) {
        this.isdeleted = isdeleted;
    }

    private String unitId;

    @Basic
    @javax.persistence.Column(name = "UNIT_ID")
    public String getUnitId() {
        return unitId;
    }

    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TStudent tStudent = (TStudent) o;

        if (studentId != null ? !studentId.equals(tStudent.studentId) : tStudent.studentId != null) return false;
        if (userId != null ? !userId.equals(tStudent.userId) : tStudent.userId != null) return false;
        if (proProfessionId != null ? !proProfessionId.equals(tStudent.proProfessionId) : tStudent.proProfessionId != null)
            return false;
        if (studentNumber != null ? !studentNumber.equals(tStudent.studentNumber) : tStudent.studentNumber != null)
            return false;
        if (studentBirthday != null ? !studentBirthday.equals(tStudent.studentBirthday) : tStudent.studentBirthday != null)
            return false;
        if (studentSex != null ? !studentSex.equals(tStudent.studentSex) : tStudent.studentSex != null) return false;
        if (studentName != null ? !studentName.equals(tStudent.studentName) : tStudent.studentName != null)
            return false;
        if (studentAge != null ? !studentAge.equals(tStudent.studentAge) : tStudent.studentAge != null) return false;
        if (studentEmail != null ? !studentEmail.equals(tStudent.studentEmail) : tStudent.studentEmail != null)
            return false;
        if (studentTelphone != null ? !studentTelphone.equals(tStudent.studentTelphone) : tStudent.studentTelphone != null)
            return false;
        if (studentDegree != null ? !studentDegree.equals(tStudent.studentDegree) : tStudent.studentDegree != null)
            return false;
        if (studentRemark != null ? !studentRemark.equals(tStudent.studentRemark) : tStudent.studentRemark != null)
            return false;
        if (professionId != null ? !professionId.equals(tStudent.professionId) : tStudent.professionId != null)
            return false;
        if (isdeleted != null ? !isdeleted.equals(tStudent.isdeleted) : tStudent.isdeleted != null) return false;
        if (unitId != null ? !unitId.equals(tStudent.unitId) : tStudent.unitId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = studentId != null ? studentId.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (proProfessionId != null ? proProfessionId.hashCode() : 0);
        result = 31 * result + (studentNumber != null ? studentNumber.hashCode() : 0);
        result = 31 * result + (studentBirthday != null ? studentBirthday.hashCode() : 0);
        result = 31 * result + (studentSex != null ? studentSex.hashCode() : 0);
        result = 31 * result + (studentName != null ? studentName.hashCode() : 0);
        result = 31 * result + (studentAge != null ? studentAge.hashCode() : 0);
        result = 31 * result + (studentEmail != null ? studentEmail.hashCode() : 0);
        result = 31 * result + (studentTelphone != null ? studentTelphone.hashCode() : 0);
        result = 31 * result + (studentDegree != null ? studentDegree.hashCode() : 0);
        result = 31 * result + (studentRemark != null ? studentRemark.hashCode() : 0);
        result = 31 * result + (professionId != null ? professionId.hashCode() : 0);
        result = 31 * result + (isdeleted != null ? isdeleted.hashCode() : 0);
        result = 31 * result + (unitId != null ? unitId.hashCode() : 0);
        return result;
    }
}
