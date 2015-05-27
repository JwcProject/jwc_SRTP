package edu.cqu.no1.dao.impl;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;
import edu.cqu.no1.dao.TUserDAO;
import edu.cqu.no1.domain.TUser;
import edu.cqu.no1.util.PageBean;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ZKQ on 2015/5/27.
 */

@Repository
public class TUserDAOImpl extends BaseDaoImpl<TUser> implements TUserDAO{

    private static final Logger log = LoggerFactory.getLogger(TUserDAO.class);
    // property constants
    public static final String USER_NAME = "userName";
    public static final String USER_PASSWORD = "userPassword";
    public static final String USER_STATE = "userState";
    public static final String USER_INTRODUCTION = "userIntroduction";
    public static final String ISDELETED = "isdeleted";
    public static final String USER_TYPE = "userType";

    @Override
    public List<TUser> findByUserName(Object userName) {
        return findByProperty(USER_NAME, userName);
    }

    @Override
    public List<TUser> findByUserPassword(Object userPassword) {
        return findByProperty(USER_PASSWORD, userPassword);
    }

    @Override
    public List<TUser> findByUserState(Object userState) {
        return findByProperty(USER_STATE, userState);
    }

    @Override
    public List<TUser> findByUserIntroduction(Object userIntroduction) {
        return findByProperty(USER_INTRODUCTION, userIntroduction);
    }

    @Override
    public List<TUser> findByIsdeleted(Object isdeleted) {
        return findByProperty(ISDELETED, isdeleted);
    }

    @Override
    public List<TUser> findByUserType(Object userType) {
        return findByProperty(USER_TYPE, userType);
    }

    @Override
    public int getAllTUserCount()
    {
        log.debug("finding all TUser counts");
        try {

			/*String queryString = "select count(*) from TUser as where s.isdeleted = '0'";
			List tmpList = getSessionFactory().getCurrentSession().createQuery(queryString).list();*/


			/*String queryString = "select count(1) from T_User where isdeleted = '0'";
			List tmpList = getSessionFactory().getCurrentSession().createSQLQuery(queryString).list();*/

            String queryStr = "select count(*) from TUser as a where a.isdeleted='N'";
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

    @Override
    public List findAll(final PageBean pageBean) {
        log.debug("finding all TUser instances");
        try {

            String queryStr = "from TUser as a where a.isdeleted = 'N'";

            Query query = getSessionFactory().getCurrentSession().createQuery(queryStr);
            query.setFirstResult(pageBean.getBeginIndex());
            query.setMaxResults(pageBean.getPageCapibility());

            return query.list();

			/*final String str =  "select * from T_User a where a.isdeleted = '0'";

			return this.getHibernateTemplate().executeFind(new HibernateCallback()
						{
							public Object doInHibernate(Session session)throws HibernateException, SQLException
							{
								Query query = session.createSQLQuery(str).addEntity(TUser.class);

								query.setFirstResult(pageBean.getBeginIndex());
								query.setMaxResults(pageBean.getPageCapibility());

								return query.list();
							}
						});*/

        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }
    }

    @Override
    public int getTUserCountByMutiProperty(String userId, String userName, String userType, String userState)
    {
        log.debug("finding all getTUserCountByMutiProperty");
        try {

            String queryStr = new String("select count(*) from TUser as model where model.isdeleted='N'");

            if(null != userId && !userId.trim().equals(""))
            {

                queryStr += " and model.userId like :userId";

            }

            if(null != userName && !userName.trim().equals(""))
            {

                queryStr += " and model.userName like :userName";

            }

            if(null != userType && !userType.equals("ALL"))
            {
                queryStr += " and model.userType = :userType";

            }

            if(null != userState && !userState.equals("00"))
            {
                queryStr += " and model.userState = :userState";

            }

            Session session = getSessionFactory().getCurrentSession();
            Query query = session.createQuery(queryStr);

            if(null != userId && !userId.trim().equals(""))
            {
                query.setString("userId", "%"+userId+"%");

            }

            if(null != userName && !userName.trim().equals(""))
            {
                query.setString("userName", "%"+userName+"%");

            }

            if(null != userType && !userType.equals("ALL"))
            {
                query.setString("userType", userType);
            }

            if(null != userState && !userState.equals("00"))
            {
                query.setString("userState", userState);
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

    @Override
    public List getTUserByMutiProperty(String userId, String userName, String userType, String userState, final PageBean pageBean)
    {
        log.debug("finding all getTUserCountByMutiProperty");
        try {

            String queryStr = new String("from TUser as model where model.isdeleted = 'N'");

            if(null != userId && !userId.trim().equals(""))
            {

                queryStr += " and model.userId like :userId";

            }

            if(null != userName && !userName.trim().equals(""))
            {

                queryStr += " and model.userName like :userName";

            }

            if(null != userType && !userType.equals("ALL"))
            {
                queryStr += " and model.userType = :userType";

            }

            if(null != userState && !userState.equals("00"))
            {
                queryStr += " and model.userState = :userState";

            }

            Session session = getSessionFactory().getCurrentSession();
            Query query = session.createQuery(queryStr);
            query.setFirstResult(pageBean.getBeginIndex());
            query.setMaxResults(pageBean.getPageCapibility());

            if(null != userId && !userId.trim().equals(""))
            {
                query.setString("userId", "%"+userId+"%");

            }

            if(null != userName && !userName.trim().equals(""))
            {
                query.setString("userName", "%"+userName+"%");

            }

            if(null != userType && !userType.equals("ALL"))
            {
                query.setString("userType", userType);
            }

            if(null != userState && !userState.equals("00"))
            {
                query.setString("userState", userState);
            }

            return query.list();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }
    }


    public static TUserDAO getFromApplicationContext(ApplicationContext ctx) {
        return (TUserDAO) ctx.getBean("TUserDAO");
    }
    @Override
    public List findByUserIdAndPwd(String userId, String password){
        log.debug("findByUserIdAndPwd");
        try {
            String queryStr = "from TUser as a where a.isdeleted = 'N' and a.userId=:userId and a.userPassword =:password";
            Query query = getSessionFactory().getCurrentSession().createQuery(queryStr);
            query.setString("userId", userId);
            query.setString("password", password);
            return query.list();
        } catch (RuntimeException re) {
            log.error("findByUserIdAndPwd failed", re);
            throw re;
        }
    }
}
