package edu.cqu.no1.dao.impl;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;
import edu.cqu.no1.dao.*;
import edu.cqu.no1.domain.TJieqi;
import edu.cqu.no1.util.PageBean;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ZKQ on 2015/5/27.
 */

@Repository
public class TJieqiDAOImpl extends BaseDaoImpl<TJieqi> implements TJieqiDAO {

    private static final Logger log = LoggerFactory.getLogger(TJieqiDAO.class);
    // property constants
    public static final String JQ_NAME = "jqName";
    public static final String QICI = "qici";
    public static final String SECONDARY_ASSESSMENT = "secondaryAssessment";
    public static final String SECONDARY_RESPONDENT = "secondaryRespondent";
    public static final String ISDELETED = "isdeleted";


    @Override
    public List findByJqName(Object jqName) {
        return findByProperty(JQ_NAME, jqName);
    }

    @Override
    public List findByQici(Object qici) {
        return findByProperty(QICI, qici);
    }

    @Override
    public List findBySecondaryAssessment(Object secondaryAssessment) {
        return findByProperty(SECONDARY_ASSESSMENT, secondaryAssessment);
    }

    @Override
    public List findBySecondaryRespondent(Object secondaryRespondent) {
        return findByProperty(SECONDARY_RESPONDENT, secondaryRespondent);
    }

    @Override
    public List findByIsdeleted(Object isdeleted) {
        return findByProperty(ISDELETED, isdeleted);
    }


    public static TJieqiDAO getFromApplicationContext(ApplicationContext ctx) {
        return (TJieqiDAO) ctx.getBean("TJieqiDAO");
    }


    //获取当前申报届期
    @Override
    public TJieqi getDeclJieqiNow(){
        log.debug("getJieqiNow");
        try {
            String queString ="From TJieqi T where T.isdeleted='N' and T.declarationState='01'";
            Query query =getSessionFactory().getCurrentSession().createQuery(queString);
            List tmpList = query.list();
            if (tmpList != null && tmpList.size() > 0) {
                return (TJieqi) tmpList.get(0);
            }
            return null;
        } catch (RuntimeException re) {
            log.error("getJieqiNow failed", re);
            throw re;
        }
    }


    // 获取当前结题届期
    @Override
    public TJieqi getEndJieqiNow(){
        log.debug("getJieqi");
        try {
            String queString ="From TJieqi T where T.isdeleted='N' and T.endprojectState='01'";
            Query query =getSessionFactory().getCurrentSession().createQuery(queString);
            List tmpList = query.list();
            if (tmpList != null && tmpList.size() > 0) {
                return (TJieqi) tmpList.get(0);
            }
            return null;
        } catch (RuntimeException re) {
            log.error("getJieqiNow failed", re);
            throw re;
        }
    }


    /**
     *
     *根据年份获取届期
     *@param year
     *@return
     */
    @Override
    public List getJieqiByYear(String year){
        log.debug("get Jieqi By year");
        try {
            String queryString ="select t.* from T_Jieqi t where t.JQ_YEAR=:jqYear order by t.START_ON desc";
            SQLQuery sqlQuery = getSessionFactory().getCurrentSession().createSQLQuery(queryString);
            sqlQuery.setString("jqYear", year);
            return sqlQuery.addEntity(TJieqi.class).list();
        } catch (RuntimeException e) {
            log.error("get jieqi by year tjieqi failed "+e);
            throw e;
        }
    }


    @Override
    public List<Integer> findAllYears(){
        log.debug("get all years from jieqi");
        try {
            String queryString ="select distinct t.jqYear from TJieqi t order by t.jqYear desc";
            Query query = getSessionFactory().getCurrentSession().createQuery(queryString);
            return query.list();
        } catch (RuntimeException e) {
            log.error("get all years failed "+e);
            throw e;
        }
    }

    //获取未分派的专家库的年份
    @Override
    public List findUnassignYears(){
        log.debug("find unassign years");
        try {
            String queryString ="select distinct t.jqYear from TJieqi t where t.jqId in (select l.TJieqi.jqId from TExpertLib l where l.isdeleted='N' and l.isAssigned='01')";
            Query query = getSessionFactory().getCurrentSession().createQuery(queryString);
            return query.list();
        } catch (RuntimeException e) {
            log.error("find unassign years failed "+e);
            throw e;
        }
    }


    @Override
    public List findAllJieqis(String jqName, String jqYear, String jqQici, PageBean pageBean){
        log.debug("find all jieqis");
        try {
            String queryStr = "From TJieqi T where T.isdeleted='N'";
            if(null != jqQici && !jqQici.trim().equals("")){
                queryStr +=" and T.jqId=:id";
            }else{
                if(null != jqName && !jqName.trim().equals("")){
                    queryStr +=" and T.jqName like :jqName";
                }
                if(null != jqYear && !jqYear.trim().equals("")){
                    queryStr +=" and T.jqYear =:jqYear";
                }
            }
            queryStr +=" order by T.declarationState desc,T.endprojectState desc,T.jqYear desc,T.qici desc";
            Query query = getSessionFactory().getCurrentSession().createQuery(queryStr);
            if(null != jqQici && !jqQici.trim().equals("")){
                query.setString("id", jqQici);
            }
            else {
                if(null != jqName && !jqName.trim().equals("")){
                    query.setString("jqName", "%"+jqName+"%");
                }
                if(null != jqYear && !jqYear.trim().equals("")){
                    query.setString("jqYear", jqYear);
                }
            }
            query.setFirstResult(pageBean.getBeginIndex());
            query.setMaxResults(pageBean.getPageCapibility());
            return query.list();
        } catch (RuntimeException e) {
            log.error("find all jieqis failed"+e);
            throw e;
        }
    }


    @Override
    public int findAllJieqisCount(String jqName, String jqYear, String jqQici){
        log.debug("find all jieqis count");
        try {
            String queryStr = "select count(*) From TJieqi T where T.isdeleted='N'";
            if(null != jqQici && !jqQici.trim().equals("")){
                queryStr +=" and T.jqId=:id";
            }else{
                if(null != jqName && !jqName.trim().equals("")){
                    queryStr +=" and T.jqName like :jqName";
                }
                if(null != jqYear && !jqYear.trim().equals("")){
                    queryStr +=" and T.jqYear =:jqYear";
                }
            }
            Query query = getSessionFactory().getCurrentSession().createQuery(queryStr);
            if(null != jqQici && !jqQici.trim().equals("")){
                query.setString("id", jqQici);
            }
            else {
                if(null != jqName && !jqName.trim().equals("")){
                    query.setString("jqName", "%"+jqName+"%");
                }
                if(null != jqYear && !jqYear.trim().equals("")){
                    query.setString("jqYear", jqYear);
                }
            }
            List tmpList = query.list();
            int count  = 0;
            if(tmpList.size()>0){
                count = new Integer(""+tmpList.get(0));
            }
            return count;
        } catch (RuntimeException e) {
            log.error("find all jieqis count failed"+e);
            throw e;
        }
    }
}
