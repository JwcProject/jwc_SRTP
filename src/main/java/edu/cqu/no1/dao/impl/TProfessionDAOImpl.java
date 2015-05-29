package edu.cqu.no1.dao.impl;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;
import edu.cqu.no1.dao.TProfessionDAO;
import edu.cqu.no1.domain.TProfession;
import org.hibernate.Query;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ZKQ on 2015/5/27.
 */

@Repository
public class TProfessionDAOImpl extends BaseDaoImpl<TProfession> implements TProfessionDAO {

    private static final Logger log = LoggerFactory
            .getLogger(TProfessionDAO.class);
    // property constants
    public static final String PROFESSION_NAME = "professionName";
    public static final String PROFESSION_SESSION = "professionSession";
    public static final String PROFESSION_CLASS = "professionClass";
    public static final String PROFESSION_REMARK = "professionRemark";
    public static final String PROFESSION_ISDELETED = "professionIsdeleted";


    //根据学院主管教师的工号获取该学院所有专业列表

    public List findProfessionsByTeaCode(String teaCode){
        log.debug("finding all professions by teacher code ");
        try {
            String queryStr = "from TProfession as p where p.professionIsdeleted = 'N' and p.TUnit.unitId=" +
                    "(select a.TUnit.unitId from TTeacher as a where a.teaCode=:code)";
            Query query = getSessionFactory().getCurrentSession().createQuery(queryStr);
            query.setString("code", teaCode);

            return query.list();
        } catch (RuntimeException e) {
            log.error("find all professions failed", e);
            throw e;
        }
    }

    @SuppressWarnings("unchecked")
    public List<TProfession> getProfessionsByTeacherId(String teacherId) {
        log.debug("getProfessionsByTeacherId");
        try {
            String queryStr = "from TProfession as p where p.professionIsdeleted = 'N' and p.TUnit.unitId=" +
                    "(select a.TUnit.unitId from TTeacher as a where a.teaId=:teacherId)";
            Query query = getSessionFactory().getCurrentSession().createQuery(queryStr);
            query.setString("teacherId", teacherId);
            return query.list();
        } catch (RuntimeException e) {
            log.error("getProfessionsByTeacherId failed", e);
            throw e;
        }
    }

    public List findByProfessionName(Object professionName) {
        return findByProperty(PROFESSION_NAME, professionName);
    }


    public List findByProfessionSession(Object professionSession) {
        return findByProperty(PROFESSION_SESSION, professionSession);
    }


    public List findByProfessionClass(Object professionClass) {
        return findByProperty(PROFESSION_CLASS, professionClass);
    }


    public List findByProfessionRemark(Object professionRemark) {
        return findByProperty(PROFESSION_REMARK, professionRemark);
    }


    public List findByProfessionIsdeleted(Object professionIsdeleted) {
        return findByProperty(PROFESSION_ISDELETED, professionIsdeleted);
    }


    public static TProfessionDAO getFromApplicationContext(
            ApplicationContext ctx) {
        return (TProfessionDAO) ctx.getBean("TProfessionDAO");
    }
}
