package edu.cqu.no1.dao.impl;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;
import edu.cqu.no1.dao.*;
import edu.cqu.no1.domain.TJournalAct;
import edu.cqu.no1.util.PageBean;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by ZKQ on 2015/5/27.
 */

@Repository
public class TJournalActDAOImpl extends BaseDaoImpl<TJournalAct> implements edu.cqu.no1.dao.TJournalActDAO {

    private static final Logger log = LoggerFactory
            .getLogger(TJournalActDAO.class);
    // property constants
    public static final String JOURNALACT_TYPE = "journalactType";
    public static final String JOURNALACT_INTRODUCTION = "journalactIntroduction";
    public static final String JOURNALACT_REMARK = "journalactRemark";
    public static final String ISDELETED = "isdeleted";
    public static final String USER_ID = "userId";


    public int getAllTJournalActCount()
    {
        log.debug("finding all TJournalAct counts");
        try {

            String queryStr = "select count(*) from TJournalAct as a where a.isdeleted='N'";
            List tmpList = getSessionFactory().getCurrentSession().createQuery(queryStr).list();

            int count = 0;

            if(tmpList.size()>0)
            {
                count = new Integer(""+tmpList.get(0));
            }

            return count;
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }
    }


    public List findAll(final PageBean pageBean) {
        log.debug("finding all TJournalAct instances");
        try {

            String queryStr = "from TJournalAct as a where a.isdeleted = 'N'";

            Query query = getSessionFactory().getCurrentSession().createQuery(queryStr);
            query.setFetchSize(pageBean.getBeginIndex());
            query.setMaxResults(pageBean.getPageCapibility());

            return query.list();

        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }
    }

    //多条件查询获取查询列表
    public List findByMultiCondition(String userId, String journalactType, String journalactIntroduction, Date time, final PageBean pageBean) {
        log.debug("finding all SelectedTJournalAct instances");
        try {

            String queryStr = new String("from TJournalAct as model where 1=1");

            if(null != userId && !userId.trim().equals(""))
            {

                queryStr += " and model.userId like :customerid";

            }

            if(null != journalactType && !journalactType.trim().equals(""))
            {

                queryStr += " and model.journalactType like :journalacttype";

            }

            if(null != journalactIntroduction && !journalactIntroduction.trim().equals(""))
            {
                queryStr += " and model.journalactIntroduction like :journalactintroduction";

            }

            if(null != time && !time.equals(""))
            {
                queryStr += " and model.time >= :time and model.time <= :time+1";

            }

            Query query = getSessionFactory().getCurrentSession().createQuery(queryStr);

            if(null != userId && !userId.trim().equals(""))
            {

                query.setString("customerid", "%"+userId+"%");

            }

            if(null != journalactType && !journalactType.trim().equals(""))
            {
                query.setString("journalacttype", "%"+journalactType+"%");

            }

            if(null != journalactIntroduction && !journalactIntroduction.equals(""))
            {
                query.setString("journalactintroduction", "%"+journalactIntroduction+"%");
            }

            if(null != time && !time.equals(""))
            {
                query.setDate("time", time);
            }


            query.setFetchSize(pageBean.getBeginIndex());
            query.setMaxResults(pageBean.getPageCapibility());

            return query.list();

        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }
    }

    //多条件查询获取查询列表长度
    public int findByMultiConditionCount(String userId, String journalactType, String journalactIntroduction, Date time) {
        log.debug("finding all SelectedTJournalAct counts");
        try {
            String queryStr = new String("select count(*) from TJournalAct as model where 1=1");

            if(null != userId && !userId.trim().equals(""))
            {

                queryStr += " and model.userId like :customerid";

            }

            if(null != journalactType && !journalactType.trim().equals(""))
            {

                queryStr += " and model.journalactType like :journalacttype";

            }

            if(null != journalactIntroduction && !journalactIntroduction.trim().equals(""))
            {
                queryStr += " and model.journalactIntroduction like :journalactintroduction";

            }

            if(null != time && !time.equals(""))
            {
                queryStr += " and model.time >= :time and model.time <= :time +1";

            }


            System.out.println(queryStr);
            Session session = getSessionFactory().getCurrentSession();
            Query query = session.createQuery(queryStr);

            if(null != userId && !userId.trim().equals(""))
            {
                query.setString("customerid", "%"+userId+"%");

            }

            if(null != journalactType && !journalactType.equals(""))
            {
                query.setString("journalacttype", "%"+journalactType+"%");

            }

            if(null != journalactIntroduction && !journalactIntroduction.equals(""))
            {
                query.setString("journalactintroduction", "%"+journalactIntroduction+"%");
            }

            if(null != time && !time.equals(""))
            {
                query.setDate("time", time);
            }

            List tmpList = query.list();

            int count = 0;

            if(tmpList.size()>0)
            {
                count = new Integer(""+tmpList.get(0));
            }

            return count;

        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }
    }

    public List findByJournalactType(Object journalactType) {
        return findByProperty(JOURNALACT_TYPE, journalactType);
    }

    public List findByJournalactIntroduction(Object journalactIntroduction) {
        return findByProperty(JOURNALACT_INTRODUCTION, journalactIntroduction);
    }

    public List findByJournalactRemark(Object journalactRemark) {
        return findByProperty(JOURNALACT_REMARK, journalactRemark);
    }

    public List findByIsdeleted(Object isdeleted) {
        return findByProperty(ISDELETED, isdeleted);
    }

    public List findByUserId(Object userId) {
        return findByProperty(USER_ID, userId);
    }


    public static TJournalActDAO getFromApplicationContext(
            ApplicationContext ctx) {
        return (TJournalActDAO) ctx.getBean("TJournalActDAO");
    }
}
