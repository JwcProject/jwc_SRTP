package edu.cqu.no1.dao;

import java.util.List;

/**
 * Created by ZKQ on 2015/5/27.
 */
public interface TStudentDAO {
    List findStudentByCode(String code);

    List findByStudentNumber(Object studentNumber);

    List findByStudentSex(Object studentSex);

    List findByStudentName(Object studentName);

    List findByStudentAge(Object studentAge);

    List findByStudentEmail(Object studentEmail);

    List findByStudentTelphone(Object studentTelphone);

    List findByStudentDegree(Object studentDegree);

    List findByStudentRemark(Object studentRemark);

    List findByIsdeleted(Object isdeleted);
}
