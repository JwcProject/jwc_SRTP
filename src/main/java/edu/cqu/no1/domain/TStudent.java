package edu.cqu.no1.domain;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by ZKQ on 2015/5/27.
 */
@Entity
@Table(name = "t_student", schema = "", catalog = "srtp")
public class TStudent {
    private String studentId;
    private String userId;
    private String professionId;
    private String unitId;
    private String studentNumber;
    private Timestamp studentBirthday;
    private String studentSex;
    private String studentName;
    private String studentAge;
    private String studentEmail;
    private String studentTelphone;
    private String studentDegree;
    private String studentRemark;
    private String isdeleted;

    @Id
    @Column(name = "STUDENT_ID")
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Basic
    @Column(name = "USER_ID")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "PROFESSION_ID")
    public String getProfessionId() {
        return professionId;
    }

    public void setProfessionId(String professionId) {
        this.professionId = professionId;
    }

    @Basic
    @Column(name = "UNIT_ID")
    public String getUnitId() {
        return unitId;
    }

    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }

    @Basic
    @Column(name = "STUDENT_NUMBER")
    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    @Basic
    @Column(name = "STUDENT_BIRTHDAY")
    public Timestamp getStudentBirthday() {
        return studentBirthday;
    }

    public void setStudentBirthday(Timestamp studentBirthday) {
        this.studentBirthday = studentBirthday;
    }

    @Basic
    @Column(name = "STUDENT_SEX")
    public String getStudentSex() {
        return studentSex;
    }

    public void setStudentSex(String studentSex) {
        this.studentSex = studentSex;
    }

    @Basic
    @Column(name = "STUDENT_NAME")
    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @Basic
    @Column(name = "STUDENT_AGE")
    public String getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(String studentAge) {
        this.studentAge = studentAge;
    }

    @Basic
    @Column(name = "STUDENT_EMAIL")
    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    @Basic
    @Column(name = "STUDENT_TELPHONE")
    public String getStudentTelphone() {
        return studentTelphone;
    }

    public void setStudentTelphone(String studentTelphone) {
        this.studentTelphone = studentTelphone;
    }

    @Basic
    @Column(name = "STUDENT_DEGREE")
    public String getStudentDegree() {
        return studentDegree;
    }

    public void setStudentDegree(String studentDegree) {
        this.studentDegree = studentDegree;
    }

    @Basic
    @Column(name = "STUDENT_REMARK")
    public String getStudentRemark() {
        return studentRemark;
    }

    public void setStudentRemark(String studentRemark) {
        this.studentRemark = studentRemark;
    }

    @Basic
    @Column(name = "ISDELETED")
    public String getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(String isdeleted) {
        this.isdeleted = isdeleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TStudent tStudent = (TStudent) o;

        if (isdeleted != null ? !isdeleted.equals(tStudent.isdeleted) : tStudent.isdeleted != null) return false;
        if (professionId != null ? !professionId.equals(tStudent.professionId) : tStudent.professionId != null)
            return false;
        if (studentAge != null ? !studentAge.equals(tStudent.studentAge) : tStudent.studentAge != null) return false;
        if (studentBirthday != null ? !studentBirthday.equals(tStudent.studentBirthday) : tStudent.studentBirthday != null)
            return false;
        if (studentDegree != null ? !studentDegree.equals(tStudent.studentDegree) : tStudent.studentDegree != null)
            return false;
        if (studentEmail != null ? !studentEmail.equals(tStudent.studentEmail) : tStudent.studentEmail != null)
            return false;
        if (studentId != null ? !studentId.equals(tStudent.studentId) : tStudent.studentId != null) return false;
        if (studentName != null ? !studentName.equals(tStudent.studentName) : tStudent.studentName != null)
            return false;
        if (studentNumber != null ? !studentNumber.equals(tStudent.studentNumber) : tStudent.studentNumber != null)
            return false;
        if (studentRemark != null ? !studentRemark.equals(tStudent.studentRemark) : tStudent.studentRemark != null)
            return false;
        if (studentSex != null ? !studentSex.equals(tStudent.studentSex) : tStudent.studentSex != null) return false;
        if (studentTelphone != null ? !studentTelphone.equals(tStudent.studentTelphone) : tStudent.studentTelphone != null)
            return false;
        if (unitId != null ? !unitId.equals(tStudent.unitId) : tStudent.unitId != null) return false;
        if (userId != null ? !userId.equals(tStudent.userId) : tStudent.userId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = studentId != null ? studentId.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (professionId != null ? professionId.hashCode() : 0);
        result = 31 * result + (unitId != null ? unitId.hashCode() : 0);
        result = 31 * result + (studentNumber != null ? studentNumber.hashCode() : 0);
        result = 31 * result + (studentBirthday != null ? studentBirthday.hashCode() : 0);
        result = 31 * result + (studentSex != null ? studentSex.hashCode() : 0);
        result = 31 * result + (studentName != null ? studentName.hashCode() : 0);
        result = 31 * result + (studentAge != null ? studentAge.hashCode() : 0);
        result = 31 * result + (studentEmail != null ? studentEmail.hashCode() : 0);
        result = 31 * result + (studentTelphone != null ? studentTelphone.hashCode() : 0);
        result = 31 * result + (studentDegree != null ? studentDegree.hashCode() : 0);
        result = 31 * result + (studentRemark != null ? studentRemark.hashCode() : 0);
        result = 31 * result + (isdeleted != null ? isdeleted.hashCode() : 0);
        return result;
    }
}
