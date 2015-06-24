package edu.cqu.no1.dao.impl;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;
import edu.cqu.no1.dao.*;
import edu.cqu.no1.domain.TExpertLib;
import edu.cqu.no1.util.PageBean;
import org.hibernate.Query;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ZKQ on 2015/5/27.
 */

@Repository
public class TExpertLibDAOImpl extends BaseDaoImpl<TExpertLib> implements TExpertLibDAO {

    private static final Logger log = LoggerFactory
            .getLogger(TExpertLibDAO.class);
    // property constants
    public static final String IS_ASSIGNED = "isAssigned";
    public static final String ISDELETED = "isdeleted";
    public static final String TYPE="type";



    public List findByIsAssigned(Object isAssigned) {
        return findByProperty(IS_ASSIGNED, isAssigned);
    }


    public List findByIsdeleted(Object isdeleted) {
        return findByProperty(ISDELETED, isdeleted);
    }


    public List findByTYPE(Object type) {
        return findByProperty(TYPE, type);
    }


    /**
     *
     *获取一个学院所有的专家团队
     *authoy lzh
     *@param teaCode 学院主管教师教职工号
     *@param pageBean
     *@return
     */

    @SuppressWarnings("unchecked")
    public List<TExpertLib> findExpsByUnitTeaCode(String teaCode, String type, PageBean pageBean) {
        log.debug("get unit expert team");
        try {
            String queryString="from TExpertLib T where T.isdeleted = 'N' and T.type=:type and T.TTeacher.TUnit.unitId in (select Te.TUnit.unitId from TTeacher Te where Te.teaCode=:code)";
            Query query = getSessionFactory().getCurrentSession().createQuery(queryString);
            query.setString("code", teaCode);
            query.setString("type", type);
            query.setFetchSize(pageBean.getBeginIndex());
            query.setMaxResults(pageBean.getPageCapibility());
            return query.list();
        } catch (RuntimeException e) {
            log.debug("get unit expert team failed" + e);
            throw e;
        }
    }


    public int findExpsCountByUnitTeaCode(String teaCode, String type) {
        log.debug("get unit expert team count");
        try {
            String queryString="Select count(*) From TExpertLib T where T.isdeleted='N' and T.type=:type and T.TTeacher.TUnit.unitId in (select Te.TUnit.unitId from TTeacher Te where Te.teaCode=:code)";
//			System.out.println(queryString);
            Query query = getSessionFactory().getCurrentSession().createQuery(queryString);
            query.setString("code", teaCode);
            query.setString("type", type);
            List list = query.list();
            int count = 0;
            if(list.size()>0){
                count = new Integer(""+list.get(0));
            }
            return count;
        } catch (RuntimeException e) {
            log.debug("get unit expert team count failed" + e);
            throw e;
        }
    }

    /**
     *
     *获取当前届期对应的专家库对象
     *authoy lzh
     *@param type 专家库的类型（01为申报的，02为结题的）
     *@return
     */

    public TExpertLib findNowJieQiExpLib(String type){
        log.debug("get ExpertLib Now");
        try {
            String queryString = "from TExpertLib as model where current_date() between model.TJieqi.startOn and model.TJieqi.endOn and model.isdeleted='N' and model.type=:type";
            Query query = getSessionFactory().getCurrentSession().createQuery(queryString);
            query.setString("type", type);
            List list = query.list();
            if (list != null && list.size() > 0) {
                return (TExpertLib) list.get(0);
            }
            return null;
        } catch (RuntimeException re) {
            log.error("get ExpertLib Now failed", re);
            throw re;
        }
    }

    public static TExpertLibDAO getFromApplicationContext(ApplicationContext ctx) {
        return (TExpertLibDAO) ctx.getBean("TExpertLibDAO");
    }
    /**
     * 根据届期查询专家库
     */

    public List findExpertLibByQici(String jieqiId, String unitId, String type){
        log.debug("findExpertLibByQici");
        try {
            String queryString="from TExpertLib T where T.isdeleted = 'N' and T.TJieqi.jqId=:jqId and T.TUnit.unitId = :unitId and T.type= :type";
            Query query = getSessionFactory().getCurrentSession().createQuery(queryString);
            query.setString("jqId", jieqiId);
            query.setString("unitId", unitId);
            query.setString("type", type);
            return query.list();
        } catch (RuntimeException e) {
            log.debug("findExpertLibByQici failed" + e);
            throw e;
        }
    }
}
