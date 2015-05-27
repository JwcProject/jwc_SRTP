package edu.cqu.no1.dao.impl;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;
import edu.cqu.no1.dao.*;
import edu.cqu.no1.domain.TJournal;
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
public class TJournalDAOImpl extends BaseDaoImpl<TJournal> implements edu.cqu.no1.dao.TJournalDAO {

    private static final Logger log = LoggerFactory
            .getLogger(TJournalDAO.class);
    // property constants
    public static final String USER_NAME = "userName";
    public static final String JOURNAL_REMARK = "journalRemark";
    public static final String ISDELETED = "isdeleted";
    public static final String JOURNAL_LOGINIP = "journalLoginip";


    @Override
    public List findByUserName(Object userName) {
        return findByProperty(USER_NAME, userName);
    }

    @Override
    public List findByJournalRemark(Object journalRemark) {
        return findByProperty(JOURNAL_REMARK, journalRemark);
    }

    @Override
    public List findByIsdeleted(Object isdeleted) {
        return findByProperty(ISDELETED, isdeleted);
    }

    @Override
    public List findByJournalLoginip(Object journalLoginip) {
        return findByProperty(JOURNAL_LOGINIP, journalLoginip);
    }

    /**
     * ********************************
     * author: chenmin
     * date  : 2013.7.17
     * comments:
     * **********************************
     */

    @Override
    public List findByQueryString(String queryString) {
        //return getHibernateTemplate().find(queryString);
        return null;
    }

    //多条件查询获取查询列表
    @Override
    public List findByMultiCondition(String userId, String userName, String journalLoginip, Date journalLogintime, Date journalQuitime, final PageBean pageBean) {
        log.debug("finding all SelectedTJournal instances");
        try {

            String queryStr = new String("from TJournal as model where 1=1");

            if (null != userId && !userId.trim().equals("")) {

                queryStr += " and model.TUser.userId like :customerid";

            }

            if (null != userName && !userName.equals("")) {

                queryStr += " and model.userName like :customername";

            }

            if (null != journalLoginip && !journalLoginip.equals("")) {
                queryStr += " and model.journalLoginip like :journalloginip";

            }

            if (null != journalLogintime && !journalLogintime.equals("")) {
                queryStr += " and model.journalLogintime >= :journallogintime and model.journalLogintime <= :journallogintime+1";

            }

            if (null != journalQuitime && !journalQuitime.equals("")) {
                queryStr += " and model.journalQuitime >= :journalquitime and model.journalQuitime <= :journalquitime+1";

            }

            Query query = getSessionFactory().getCurrentSession().createQuery(queryStr);

            if (null != userId && !userId.trim().equals("")) {

                query.setString("customerid", "%" + userId + "%");

            }

            if (null != userName && !userName.equals("")) {
                query.setString("customername", "%" + userName + "%");

            }

            if (null != journalLoginip && !journalLoginip.equals("")) {
                query.setString("journalloginip", "%" + journalLoginip + "%");
            }

            if (null != journalLogintime && !journalLogintime.equals("")) {
                query.setDate("journallogintime", journalLogintime);
            }

            if (null != journalQuitime && !journalQuitime.equals("")) {
                query.setDate("journalquitime", journalQuitime);

            }


            query.setFirstResult(pageBean.getBeginIndex());
            query.setMaxResults(pageBean.getPageCapibility());

            return query.list();

        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }
    }

    //多条件查询获取查询列表长度
    @Override
    public int findByMultiConditionCount(String userId, String userName, String journalLoginip, Date journalLogintime, Date journalQuitime) {
        log.debug("finding all SelectedTJournal counts");
        try {
            String queryStr = new String("select count(*) from TJournal as model where 1=1");

            if (null != userId && !userId.trim().equals("")) {

                queryStr += " and model.TUser.userId like :customerid";

            }

            if (null != userName && !userName.equals("")) {

                queryStr += " and model.userName like :customername";

            }

            if (null != journalLoginip && !journalLoginip.equals("")) {
                queryStr += " and model.journalLoginip like :journalloginip";

            }

            if (null != journalLogintime && !journalLogintime.equals("")) {
                queryStr += " and model.journalLogintime >= :journallogintime and model.journalLogintime <= :journallogintime +1";

            }

            if (null != journalQuitime && !journalQuitime.equals("")) {
                queryStr += " and model.journalQuitime >= :journalquitime and model.journalQuitime <= :journalquitime+1";

            }
            System.out.println(queryStr);
            Session session = getSessionFactory().getCurrentSession();
            Query query = session.createQuery(queryStr);

            if (null != userId && !userId.trim().equals("")) {
                query.setString("customerid", "%" + userId + "%");

            }

            if (null != userName && !userName.equals("")) {
                query.setString("customername", "%" + userName + "%");

            }

            if (null != journalLoginip && !journalLoginip.equals("")) {
                query.setString("journalloginip", "%" + journalLoginip + "%");
            }

            if (null != journalLogintime && !journalLogintime.equals("")) {
                query.setDate("journallogintime", journalLogintime);
            }

            if (null != journalQuitime && !journalQuitime.equals("")) {
                query.setDate("journalquitime", journalQuitime);

            }

            List tmpList = query.list();

            int count = 0;

            if (tmpList.size() > 0) {
                count = new Integer("" + tmpList.get(0));
            }

            return count;

        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }
    }

    @Override
    public int getAllTJournalCount() {
        log.debug("finding all TJournal counts");
        try {

            String queryStr = "select count(*) from TJournal as a where a.isdeleted='N'";
            List tmpList = getSessionFactory().getCurrentSession().createQuery(queryStr).list();

            int count = 0;

            if (tmpList.size() > 0) {
                count = new Integer("" + tmpList.get(0));
            }

            return count;
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }
    }


    @Override
    public List findAll(final PageBean pageBean) {
        log.debug("finding all TJournal instances");
        try {

            String queryStr = "from TJournal as a where a.isdeleted = 'N'";

            Query query = getSessionFactory().getCurrentSession().createQuery(queryStr);
            query.setFirstResult(pageBean.getBeginIndex());
            query.setMaxResults(pageBean.getPageCapibility());

            return query.list();

        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }
    }

    public static TJournalDAO getFromApplicationContext(ApplicationContext ctx) {
        return (TJournalDAO) ctx.getBean("TJournalDAO");
    }
}
