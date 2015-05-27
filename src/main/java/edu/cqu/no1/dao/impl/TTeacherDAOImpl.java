package edu.cqu.no1.dao.impl;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;
import edu.cqu.no1.dao.TTeacherDAO;
import edu.cqu.no1.domain.TTeacher;
import org.hibernate.Query;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ZKQ on 2015/5/27.
 */

@Repository
public class TTeacherDAOImpl extends BaseDaoImpl<TTeacher> implements TTeacherDAO {


    private static final Logger log = LoggerFactory
            .getLogger(TTeacherDAO.class);
    // property constants
    public static final String TEA_NAME = "teaName";
    public static final String TEA_CODE = "teaCode";
    public static final String TEA_SEX = "teaSex";
    public static final String TEA_TITLE = "teaTitle";
    public static final String TEA_TELE = "teaTele";
    public static final String TEA_EMAIL = "teaEmail";
    public static final String TEA_STATE = "teaState";
    public static final String TEA_INTRO = "teaIntro";
    public static final String TEA_REMARK = "teaRemark";
    public static final String ISDELETED = "isdeleted";

    //通过学院主管教师的id找到本学院所有的教师
    @Override
    public List getTeachers(String code) {
        log.debug("get all Teacher ");
        try {
            String queryStr = "from TTeacher t where t.isdeleted = 'N' and t.TUnit.unitId=(select a.TUnit.unitId from TTeacher a where a.teaCode=:code)";
            Query query = getSessionFactory().getCurrentSession().createQuery(queryStr);
            query.setString("code", code);
            return query.list();
        } catch (RuntimeException e) {
            log.error("get all teacher failed", e);
            throw e;
        }
    }

    /*
     * 得到不是专家教师的教师
     * type 为类别，01 为申报的专家教师，02为结题的专家教师
     */
    @Override
    public List getCommonTeachers(String code, String type) {
        log.debug("get all common Teacher ");
        try {
            String queryStr = "from TTeacher t where t.isdeleted = 'N' and t.TUnit.unitId=(select a.TUnit.unitId from TTeacher a where a.teaCode=:code) and not exists(from TExpertTeacher ET where ET.isdeleted='N' and ET.TTeacher.teaId=t.teaId and ET.TExpertLib.type=:type)";
            //select t.* from t_teacher t where t.isdeleted = 'N' and t.unit_id=(select a.unit_id from t_teacher a where a.tea_code='rj1000') and not exists(select ET.EX_TEA_ID from t_expert_teacher ET where ET.Isdeleted='N' and ET.Tea_Id=t.tea_id)
            Query query = getSessionFactory().getCurrentSession().createQuery(queryStr);
            query.setString("code", code);
            query.setString("type", type);
            return query.list();
        } catch (RuntimeException e) {
            log.error("get all common teacher failed", e);
            throw e;
        }
    }

    //多条件查询当前主管教师所在学院的所有教师
    @Override
    public List findTeachers(String teaCode, String teaName, String teaTitle) {
        log.debug("find all Teacher ");
        try {
            String queryStr = "from TTeacher t where t.isdeleted = 'N' and t.TUnit.unitId=(select a.TUnit.unitId from TTeacher a where a.teaCode=:code)";

            if(null != teaName && !teaName.trim().equals(""))
            {

                queryStr += " and t.teaName like :teaName";

            }

            if(null != teaTitle && !teaTitle.trim().equals("00"))
            {

                queryStr += " and t.teaTitle =:teaTitle";

            }
            Query query = getSessionFactory().getCurrentSession().createQuery(queryStr);

            query.setString("code", teaCode);

            if(null != teaName && !teaName.equals(""))
            {
                query.setString("teaName", "%"+teaName+"%");
            }
            if(null != teaTitle && !teaTitle.equals("00"))
            {
                query.setString("teaTitle", teaTitle);
            }
            return query.list();
        } catch (RuntimeException e) {
            log.error("find all teacher failed", e);
            throw e;
        }
    }

    @Override
    public List findTeacherByCode(String code) {
        log.debug("find teacher by teacher code");
        try {
            String queryStr = "from TTeacher t where t.isdeleted = 'N' and t.teaCode=:code";
            Query query = getSessionFactory().getCurrentSession().createQuery(queryStr);
            query.setString("code", code);
            return query.list();
        } catch (RuntimeException e) {
            log.error("get teacher failed", e);
            throw e;
        }
    }

    @Override
    public List findByTeaName(Object teaName) {
        return findByProperty(TEA_NAME, teaName);
    }

    @Override
    public List findByTeaCode(Object teaCode) {
        return findByProperty(TEA_CODE, teaCode);
    }

    @Override
    public List findByTeaSex(Object teaSex) {
        return findByProperty(TEA_SEX, teaSex);
    }

    @Override
    public List findByTeaTitle(Object teaTitle) {
        return findByProperty(TEA_TITLE, teaTitle);
    }

    @Override
    public List findByTeaTele(Object teaTele) {
        return findByProperty(TEA_TELE, teaTele);
    }

    @Override
    public List findByTeaEmail(Object teaEmail) {
        return findByProperty(TEA_EMAIL, teaEmail);
    }

    @Override
    public List findByTeaState(Object teaState) {
        return findByProperty(TEA_STATE, teaState);
    }

    @Override
    public List findByTeaIntro(Object teaIntro) {
        return findByProperty(TEA_INTRO, teaIntro);
    }

    @Override
    public List findByTeaRemark(Object teaRemark) {
        return findByProperty(TEA_REMARK, teaRemark);
    }

    @Override
    public List findByIsdeleted(Object isdeleted) {
        return findByProperty(ISDELETED, isdeleted);
    }


    public static TTeacherDAO getFromApplicationContext(ApplicationContext ctx) {
        return (TTeacherDAO) ctx.getBean("TTeacherDAO");
    }
    /**
     * lsp
     */
    @Override
    public List findTeachersByName(String name){
        log.debug("findTeachersByName");
        try {
            String queryStr = "from TTeacher t where t.isdeleted = 'N' and t.teaName like :name";
            Query query = getSessionFactory().getCurrentSession().createQuery(queryStr);
            query.setString("name",  "%" + name + "%");
            return query.list();
        } catch (RuntimeException re) {
            log.error("findTeachersByName failed", re);
            throw re;
        }
    }

}
