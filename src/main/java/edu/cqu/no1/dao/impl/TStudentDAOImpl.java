package edu.cqu.no1.dao.impl;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;
import edu.cqu.no1.dao.TStudentDAO;
import edu.cqu.no1.domain.TStudent;
import org.hibernate.Query;
import org.springframework.context.ApplicationContext;

import java.util.List;

/**
 * Created by ZKQ on 2015/5/27.
 */
public class TStudentDAOImpl extends BaseDaoImpl<TStudent> implements TStudentDAO {

    private static final Logger log = LoggerFactory
            .getLogger(TStudentDAO.class);
    // property constants
    public static final String STUDENT_NUMBER = "studentNumber";
    public static final String STUDENT_SEX = "studentSex";
    public static final String STUDENT_NAME = "studentName";
    public static final String STUDENT_AGE = "studentAge";
    public static final String STUDENT_EMAIL = "studentEmail";
    public static final String STUDENT_TELPHONE = "studentTelphone";
    public static final String STUDENT_DEGREE = "studentDegree";
    public static final String STUDENT_REMARK = "studentRemark";
    public static final String ISDELETED = "isdeleted";


    @Override
    public List findStudentByCode(String code) {
        log.debug("find student by student code");
        try {
            String queryStr = "from TStudent t where t.isdeleted = 'N' and t.studentNumber=:code";
            Query query = getSessionFactory().getCurrentSession().createQuery(queryStr);
            query.setString("code", code);
            return query.list();
        } catch (RuntimeException e) {
            log.error("get student failed", e);
            throw e;
        }
    }

    @Override
    public List findByStudentNumber(Object studentNumber) {
        return findByProperty(STUDENT_NUMBER, studentNumber);
    }

    @Override
    public List findByStudentSex(Object studentSex) {
        return findByProperty(STUDENT_SEX, studentSex);
    }

    @Override
    public List findByStudentName(Object studentName) {
        return findByProperty(STUDENT_NAME, studentName);
    }

    @Override
    public List findByStudentAge(Object studentAge) {
        return findByProperty(STUDENT_AGE, studentAge);
    }

    @Override
    public List findByStudentEmail(Object studentEmail) {
        return findByProperty(STUDENT_EMAIL, studentEmail);
    }

    @Override
    public List findByStudentTelphone(Object studentTelphone) {
        return findByProperty(STUDENT_TELPHONE, studentTelphone);
    }

    @Override
    public List findByStudentDegree(Object studentDegree) {
        return findByProperty(STUDENT_DEGREE, studentDegree);
    }

    @Override
    public List findByStudentRemark(Object studentRemark) {
        return findByProperty(STUDENT_REMARK, studentRemark);
    }

    @Override
    public List findByIsdeleted(Object isdeleted) {
        return findByProperty(ISDELETED, isdeleted);
    }


    public static TStudentDAO getFromApplicationContext(ApplicationContext ctx) {
        return (TStudentDAO) ctx.getBean("TStudentDAO");
    }
}
