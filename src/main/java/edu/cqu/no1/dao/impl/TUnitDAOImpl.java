package edu.cqu.no1.dao.impl;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;
import edu.cqu.no1.dao.TUnitDAO;
import edu.cqu.no1.domain.TUnit;
import org.hibernate.Query;
import org.springframework.context.ApplicationContext;

import java.util.List;

/**
 * Created by ZKQ on 2015/5/27.
 */
public class TUnitDAOImpl extends BaseDaoImpl<TUnit> implements TUnitDAO {

    private static final Logger log = LoggerFactory.getLogger(TUnitDAO.class);
    // property constants
    public static final String UNIT_NAME = "unitName";
    public static final String UNIT_TYPE = "unitType";
    public static final String UNIT_FATHERID = "unitFatherid";
    public static final String UNIT_CODE = "unitCode";
    public static final String UNIT_REMARK = "unitRemark";
    public static final String ISDELETED = "isdeleted";


    @Override
    public List findByUnitName(Object unitName) {
        return findByProperty(UNIT_NAME, unitName);
    }

    @Override
    public List findByUnitType(Object unitType) {
        return findByProperty(UNIT_TYPE, unitType);
    }

    @Override
    public List findByUnitFatherid(Object unitFatherid) {
        return findByProperty(UNIT_FATHERID, unitFatherid);
    }

    @Override
    public List findByUnitCode(Object unitCode) {
        return findByProperty(UNIT_CODE, unitCode);
    }

    @Override
    public List findByUnitRemark(Object unitRemark) {
        return findByProperty(UNIT_REMARK, unitRemark);
    }

    @Override
    public List findByIsdeleted(Object isdeleted) {
        return findByProperty(ISDELETED, isdeleted);
    }

    public static TUnitDAO getFromApplicationContext(ApplicationContext ctx) {
        return (TUnitDAO) ctx.getBean("TUnitDAO");
    }
    /**
     * lsp
     */
    /**
     * 根据教师ID查询单位
     */
    @Override
    public TUnit getUnitByTeacherId(String teaId){
        log.debug("getUnitByUserId");
        try {
            String sql = "select t.TUnit from TTeacher as t where t.teaCode=?";
            Query query = getSessionFactory().getCurrentSession().createQuery(sql);
            query.setString(0, teaId);
            List list = query.list();
            if (list != null && list.size() > 0) {
                log.debug("getUnitByUserId successful");
                return (TUnit) list.get(0);
            }else {
                return null;
            }
        } catch (RuntimeException re) {
            log.error("getUnitByUserId", re);
            throw re;
        }
    }
    @Override
    public List getAllColleges(){
        log.debug("getAllColleges");
        try {
            String sql = "from TUnit where isdeleted='N' and unitName like '%学院%'";
            Query query = getSessionFactory().getCurrentSession().createQuery(sql);
            return query.list();
        } catch (RuntimeException re) {
            log.error("getAllColleges failed", re);
            throw re;
        }
    }
}
