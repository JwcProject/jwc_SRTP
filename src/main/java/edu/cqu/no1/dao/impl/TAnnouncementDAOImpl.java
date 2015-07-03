package edu.cqu.no1.dao.impl;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;
import com.sun.istack.internal.NotNull;
import edu.cqu.no1.dao.*;
import edu.cqu.no1.domain.TAnnouncement;
import edu.cqu.no1.util.PageBean;
import org.hibernate.Query;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by ZKQ on 2015/5/27.
 */

@Repository
public class TAnnouncementDAOImpl extends BaseDaoImpl<TAnnouncement> implements TAnnouncementDAO {
    private static final Logger log = LoggerFactory
            .getLogger(TAnnouncementDAO.class);
    // property constants
    public static final String ANNOUN_TITLE = "announTitle";
    public static final String ANNOUN_CONTENT = "announContent";
    public static final String PUBLISHER_CODE = "publisherCode";
    public static final String PUBLISHER_ROLE = "publisherRole";
    public static final String PUBLISH_STATE = "publishState";
    public static final String CHECKER_CODE = "checkerCode";
    public static final String CHECK_STATE = "checkState";
    public static final String ISDELETED = "isdeleted";


    public List findByAnnounTitle(Object announTitle) {
        return findByProperty(ANNOUN_TITLE, announTitle);
    }


    public List findByAnnounContent(Object announContent) {
        return findByProperty(ANNOUN_CONTENT, announContent);
    }


    public List findByPublisherCode(Object publisherCode) {
        return findByProperty(PUBLISHER_CODE, publisherCode);
    }


    public List findByPublisherRole(Object publisherRole) {
        return findByProperty(PUBLISHER_ROLE, publisherRole);
    }


    public List findByPublishState(Object publishState) {
        return findByProperty(PUBLISH_STATE, publishState);
    }


    public List findByCheckerCode(Object checkerCode) {
        return findByProperty(CHECKER_CODE, checkerCode);
    }


    public List findByCheckState(Object checkState) {
        return findByProperty(CHECK_STATE, checkState);
    }


    public List findByIsdeleted(Object isdeleted) {
        return findByProperty(ISDELETED, isdeleted);
    }


    /**
     * 根据公告类别获取公告的ID，名称
     * @param typeName 公告类别名称
     * @return
     */
    @Override
    public List findAnnounByType(String typeName, PageBean pageBean) {
        log.debug("find TAnnouncement by type");
        return findIndexSchoolAnnoument(null, null, typeName, pageBean);
    }

    public int findAnnounByTypeCount(String typeName) {
        log.debug("find TAnnouncement count by type");
        return findIndexSchoolAnnoumentCount(null, null, typeName);
    }

    //查询主页学校公告
    @Override
    public List findIndexSchoolAnnoument(String announTitle, Date publishTime, String typeName, PageBean pageBean) {
        log.debug("find TAnnouncement by type");
        try {
            String hql = "from TAnnouncement ta where ta.isdeleted = 'N' and ta.publishState = 'Y'" +
                    " and ta.TAnnounType.announTypeName like :tName";
            if (null != announTitle && !announTitle.trim().equals("")) {
                hql += " and ta.announTitle like :announTitle";
            }
            if (null != publishTime && !publishTime.toString().trim().equals("")) {
                hql += " and ta.publishTime between :publishTime and :publishTime + 1";
            }

            Query query = getSessionFactory().getCurrentSession().createQuery(hql);

            if (null != announTitle && !announTitle.trim().equals("")) {
                query.setString("announTitle", "%" + announTitle + "%");
            }

            if (null != publishTime && !publishTime.toString().trim().equals("")) {
                query.setDate("publishTime", publishTime);
            }

            query.setString("tName", "%" + typeName + "%");
            if (null != pageBean) {
                query.setFirstResult(pageBean.getBeginIndex());
                query.setMaxResults(pageBean.getPageCapibility());
            }
            return query.list();
        } catch (RuntimeException e) {
            log.error("find announcement by type failed " + e);
            throw e;
        }
    }


    public int findIndexSchoolAnnoumentCount(String announTitle, Date publishTime, String typeName) {
        log.debug("find TAnnouncement count by type");
        try {
            String hql = "select count(*) from TAnnouncement where isdeleted = 'N'" +
                    " and publishState = 'Y' and TAnnounType.announTypeName like :tName";
            if (null != announTitle && !announTitle.trim().equals("")) {
                hql += " and ta.announTitle like :announTitle";
            }
            if (null != publishTime && !publishTime.toString().trim().equals("")) {
                hql += " and ta.publishTime between :publishTime and :publishTime + 1";
            }
            Query query = getSessionFactory().getCurrentSession().createQuery(hql);
            if (null != announTitle && !announTitle.trim().equals("")) {
                query.setString("announTitle", "%" + announTitle + "%");
            }

            if (null != publishTime && !publishTime.toString().trim().equals("")) {
                query.setDate("publishTime", publishTime);
            }
            query.setString("tName", "%" + typeName + "%");
            List list = query.list();
            int count = 0;
            if (list.size() > 0) {
                count = new Integer("" + list.get(0));
            }
            return count;
        } catch (RuntimeException e) {
            log.error("find announcement count by type failed " + e);
            throw e;
        }

    }

    public static TAnnouncementDAO getFromApplicationContext(
            ApplicationContext ctx) {
        return (TAnnouncementDAO) ctx.getBean("TAnnouncementDAO");
    }

    /**
     * 学生或老师查询本人的公告
     *
     * @param number     学号或教职工号
     * @param announName
     * @param announDate
     * @param pageBean
     * @return
     */
    @Override
    public List getStuTeatAnnoun(String number, String announName,
                                 Date announDate, PageBean pageBean) {
        log.debug("finding Student or Teacher TAnnouncement instances");
        try {
            String hql = "from TAnnouncement ta where" +
                    " ta.isdeleted = 'N' and  ta.publisherCode = :code";

            if (null != announName && !announName.trim().equals("")) {
                hql += " and ta.announTitle like :aName";
            }
            if (null != announDate && !announDate.toString().trim().equals("")) {
                hql += " and ta.publishTime between :aDate and :aDate + 1";
            }
            Query query = getSessionFactory().getCurrentSession().createQuery(hql);
            query.setString("code", number);

            if (null != announName && !announName.trim().equals("")) {
                query.setString("aName", "%" + announName + "%");
            }
            if (null != announDate && !announDate.toString().trim().equals("")) {
                query.setDate("aDate", announDate);
            }

            if (null != pageBean) {
                query.setFirstResult(pageBean.getBeginIndex());
                query.setMaxResults(pageBean.getPageCapibility());
            }
            return query.list();
        } catch (RuntimeException re) {
            log.error("find Student failed", re);
            throw re;
        }

    }

    /**
     * 查询学生或老师公告数量
     *
     * @param number
     * @param announName
     * @param announDate
     * @return
     */

    @Override
    public int getStuTeaAnnounCount(String number, String announName,
                                    Date announDate) {
        log.debug("finding StuTea count TAnnouncement instances");
        try {
            String hql = "select count(*) from TAnnouncement where isdeleted = 'N' and publisherCode = :code";

            if (null != announName && !announName.trim().equals("")) {
                hql += " and announTitle like :aName";
            }
            if (null != announDate && !announDate.toString().trim().equals("")) {
                hql += " and publishTime between :aDate and :aDate + 1";
            }
            Query query = getSessionFactory().getCurrentSession().createQuery(hql);
            query.setString("code", number);
            if (null != announName && !announName.trim().equals("")) {
                query.setString("aName", "%" + announName + "%");
            }
            if (null != announDate && !announDate.toString().trim().equals("")) {
                query.setDate("aDate", announDate);
            }
            List list = query.list();


            if (list != null && list.size() > 0) {
                return Integer.valueOf(list.get(0) + "");
            }
            return 0;
        } catch (RuntimeException re) {
            log.error("find StuTea count failed", re);
            throw re;
        }
    }

    /**
     * 学院主管教师查询本学院的公告
     *
     * @param teaCode    主管教室教职工号
     * @param announName
     * @param announDate
     * @param pageBean
     * @return
     */
    @Override
    public List getUnitAnnoun(String teaCode, String announName,
                              Date announDate, PageBean pageBean) {
        log.debug("finding unit TAnnouncement");
        try {
            String hql = "from TAnnouncement ta where ta.isdeleted = 'N'";

            if (null != announName && !announName.trim().equals("")) {
                hql += " and ta.announTitle like :aName";
            }
            if (null != announDate && !announDate.toString().trim().equals("")) {
                hql += " and ta.publishTime between :aDate and :aDate + 1";
            }
            hql += " and ta.publisherCode=:code or ta.publisherCode in" +
                    "(select studentNumber from TStudent where TUnit = (select TUnit from TTeacher where teaCode = :code)))";
            Query query = getSessionFactory().getCurrentSession().createQuery(hql);
            query.setString("code", teaCode);
            if (null != announName && !announName.trim().equals("")) {
                query.setString("aName", "%" + announName + "%");
            }
            if (null != announDate && !announDate.toString().trim().equals("")) {
                query.setDate("aDate", announDate);
            }
            if (null != pageBean) {
                query.setFirstResult(pageBean.getBeginIndex());
                query.setMaxResults(pageBean.getPageCapibility());
            }
            return query.list();
        } catch (RuntimeException e) {
            log.error("query unit TAnnouncement failed: " + e);
            throw e;
        }
    }


    /**
     * 根据教师职工号 公告名称 公告时间查询公告数量
     *
     * @param teaCode    教师职工号
     * @param announName 公告名称
     * @param announDate 公告时间
     * @return
     */
    @Override
    public int getUnitAnnounCount(String teaCode, String announName,
                                  Date announDate) {
        log.debug("finding unit TAnnouncement");
        try {
            String hql = "select count(*) from TAnnouncement ta where ta.isdeleted = 'N'";
            if (null != announName && !announName.trim().equals("")) {
                hql += " and ta.announTitle like :aName";
            }

            if (null != announDate && !announDate.toString().trim().equals("")) {
                hql += " and ta.publishTime between :aDate and :aDate + 1";
            }
            hql += " and ta.publisherCode in" +
                    " (select teaCode from TTeacher where teaCode = :code or ta.publisherCode in " +
                    "(select studentNumber from TStudent where TUnit = (select TUnit from TTeacher where teaCode = :code)))";
            Query query = getSessionFactory().getCurrentSession().createQuery(hql);
            query.setString("code", teaCode);
            if (null != announName && !announName.trim().equals("")) {
                query.setString("aName", "%" + announName + "%");
            }
            if (null != announDate && !announDate.toString().trim().equals("")) {
                query.setDate("aDate", announDate);
            }
            List list = query.list();

            if (list != null && list.size() > 0) {
                return Integer.valueOf(list.get(0) + "");
            }
            return 0;
        } catch (RuntimeException e) {
            log.error("query unit TAnnouncement count failed: " + e);
            throw e;
        }

    }

    /**
     * 教务处查询公告
     *
     * @param announName
     * @param announDate
     * @param publisherName
     * @param typeName
     * @param pageBean
     * @return
     */
    @Override
    public List getSchoolAnnoun(String announName, String checkState,
                                Date announDate, String publisherName, String typeName,
                                PageBean pageBean) {
        log.debug("find school TAnnouncements ");
        try {
            String hql = "from TAnnouncement ta where ta.isdeleted = 'N'";


            if (null != announName && !announName.trim().equals("")) {
                hql += " and ta.announTitle like :aName";
            }
            if (null != checkState && !checkState.trim().equals("") && !checkState.trim().equals("ALL")) {
                hql += " and ta.checkState =:aState";
            } else if (null != checkState && checkState.trim().equals("ALL")) {
                hql += " and ta.checkState is not null";
            }


            if (null != announDate && !announDate.toString().trim().equals("")) {
                hql += " and ta.publishTime between :aDate and :aDate + 1";
            }

            if (null != publisherName && !publisherName.trim().equals("")) {
                hql += " and ta.publisherCode in (select userId from TUser where userName like :uName)";
            }

            if (null != typeName && !typeName.trim().equals("00")) {
                hql += " and ta.TAnnounType.announTypeName like :tName";
            }

            hql += " order by ta.publishTime desc";
            Query query = getSessionFactory().getCurrentSession().createQuery(hql);


            if (null != announName && !announName.trim().equals("")) {
                query.setString("aName", "%" + announName + "%");
            }
            if (null != checkState && !checkState.trim().equals("") && !checkState.trim().equals("ALL")) {
                query.setString("aState", checkState);
            }
            if (null != announDate && !announDate.toString().trim().equals("")) {
                query.setDate("aDate", announDate);
            }
            if (null != publisherName && !publisherName.trim().equals("")) {
                query.setString("uName", "%" + publisherName + "%");
            }
            if (null != typeName && !typeName.trim().equals("00")) {
                query.setString("tName", "%" + typeName + "%");
            }
            if (null != pageBean) {
                query.setFirstResult(pageBean.getBeginIndex());
                query.setMaxResults(pageBean.getPageCapibility());
            }
            return query.list();
        } catch (RuntimeException e) {
            log.error("find school TAnnouncement " + e);
            throw e;
        }

    }

    /**
     * 查询学校公告数量
     *
     * @param announName
     * @param checkState
     * @param announDate
     * @param publisherName
     * @param typeName
     * @return
     */
    @Override
    public int getSchoolAnnounCount(String announName, String checkState,
                                    Date announDate, String publisherName, String typeName) {
        log.debug("find school count TAnnouncements ");
        try {
            String hql = "select count(*) from TAnnouncement ta where ta.isdeleted = 'N'";

            if (null != announName && !announName.trim().equals("")) {
                hql += " and ta.announTitle like :aName";
            }
            if (null != checkState && !checkState.trim().equals("") && !checkState.trim().equals("ALL")) {
                hql += " and A.CHECK_STATE =:aState";
            }
            if (null != checkState && checkState.trim().equals("ALL")) {
                hql += " and ta.checkState is not null";
            }
            if (null != announDate && !announDate.toString().trim().equals("")) {
                hql += " and ta.publishTime between :aDate and :aDate + 1";
            }
            if (null != publisherName && !publisherName.trim().equals("")) {
                hql += " and ta.publisherCode in (select userId from TUser where userName like :uName)";
            }
            if (null != typeName && !typeName.trim().equals("00")) {
                hql += " and ta.TAnnounType.announTypeName like :tName";
            }
            Query query = getSessionFactory().getCurrentSession().createQuery(hql);
            if (null != announName && !announName.trim().equals("")) {
                query.setString("aName", "%" + announName + "%");
            }
            if (null != checkState && !checkState.trim().equals("") && !checkState.trim().equals("ALL")) {
                query.setString("aState", checkState);
            }
            if (null != announDate && !announDate.toString().trim().equals("")) {
                query.setDate("aDate", announDate);
            }
            if (null != publisherName && !publisherName.trim().equals("")) {
                query.setString("uName", "%" + publisherName + "%");
            }
            if (null != typeName && !typeName.trim().equals("00")) {
                query.setString("tName", "%" + typeName + "%");
            }
            List list = query.list();

            if (list != null && list.size() > 0) {
                return Integer.valueOf(list.get(0) + "");
            }
            return 0;
        } catch (RuntimeException e) {
            log.error("find school count TAnnouncement " + e);
            throw e;
        }
    }


    /**
     * @param unitStuCode
     * @param announTitle
     * @param publishTime
     * @param pageBean
     * @return
     */
    @Override
    public List getUnitAnnounctmentByStuCode(String unitStuCode, String announTitle, Date publishTime, PageBean pageBean) {
        log.debug("finding unit all TAnnouncement instances by pageBean");
        try {
            String queryStr = "from TAnnouncement t where t.isdeleted = 'N' and t.publishState = 'Y' and t.publisherCode in " +
                    "(select tt.teaCode from TTeacher tt where tt.TUnit.unitId = " +
                    "(select s.TUnit.unitId from TStudent s where s.TUser.userId =:unitStuCode) " +
                    "and tt.teaCode in (select u.userId from TUser u where u.userType = '02' or u.userType = '03'))";
            if (null != announTitle && !announTitle.trim().equals("")) {
                queryStr += " and t.announTitle like :announTitle";
            }
            if (null != publishTime && !publishTime.toString().trim().equals("")) {
                queryStr += " and t.publishTime >= :publishTime and t.publishTime <= :publishTime+1";
            }

            Query query = getSessionFactory().getCurrentSession().createQuery(queryStr);
            query.setString("unitStuCode", unitStuCode);

            if (null != announTitle && !announTitle.trim().equals("")) {
                query.setString("announTitle", "%" + announTitle + "%");
            }
            if (null != publishTime && !publishTime.toString().trim().equals("")) {
                query.setDate("publishTime", publishTime);
            }
            query.setFirstResult(pageBean.getBeginIndex());
            query.setMaxResults(pageBean.getPageCapibility());
            return query.list();
        } catch (RuntimeException e) {
            log.error("find unit all TAnnouncement failed", e);
            throw e;
        }
    }


    @Override
    public int getUnitAnnounctmentByStuCodeCount(String unitStuCode, String announTitle, Date publishTime) {
        log.debug("finding unit all TAnnouncement count instances by pageBeanun");
        try {
            String queryStr = "select count(*) from TAnnouncement t where t.isdeleted = 'N' and t.publishState = 'Y' and t.publisherCode in " +
                    "(select tt.teaCode from TTeacher tt where tt.TUnit.unitId = " +
                    "(select s.TUnit.unitId from TStudent s where s.TUser.userId =:unitStuCode) " +
                    "and tt.teaCode in (select u.userId from TUser u where u.userType = '02' or u.userType = '03'))";
            if (null != announTitle && !announTitle.trim().equals("")) {
                queryStr += " and t.announTitle like :announTitle";
            }
            if (null != publishTime && !publishTime.toString().trim().equals("")) {
                queryStr += " and t.publishTime >= :publishTime and t.publishTime <= :publishTime+1";
            }

            Query query = getSessionFactory().getCurrentSession().createQuery(queryStr);
            query.setString("unitStuCode", unitStuCode);

            if (null != announTitle && !announTitle.trim().equals("")) {
                query.setString("announTitle", "%" + announTitle + "%");
            }
            if (null != publishTime && !publishTime.toString().trim().equals("")) {
                query.setDate("publishTime", publishTime);
            }
            List tmpList = query.list();
            int count = 0;
            if (tmpList.size() > 0) {
                count = new Integer("" + tmpList.get(0));
            }
            return count;
        } catch (RuntimeException e) {
            log.error("find unit all TAnnouncement count failed", e);
            throw e;
        }
    }


    /**
     *
     * @param announTitle
     * @param announContent
     * @param publishTime
     * @param pageBean
     * @return
     */
    @Override
    public List getCommonStuAndTeaAnnoun(String announTitle, String announContent, Date publishTime, PageBean pageBean) {
        log.debug("finding common student and teacher TAnnouncement instances by pageBeanun");
        try {
            String queryStr = "from TAnnouncement t where t.isdeleted = 'N' and t.publishState = 'Y' and t.publisherCode in " +
                    "(select u.userId from TUser u where u.userType = '04' or u.userType = '05' or u.userType = '06' or u.userType = '07' or u.userType = '08')";
            if (null != announTitle && !announTitle.trim().equals("")) {
                queryStr += " and t.announTitle like :announTitle";
            }
            if (null != announContent && !announContent.trim().equals("")) {
                queryStr += " and t.announContent like :announContent";
            }
            if (null != publishTime && !publishTime.toString().trim().equals("")) {
                queryStr += " and t.publishTime >= :publishTime and t.publishTime <= :publishTime+1";
            }
            Query query = getSessionFactory().getCurrentSession().createQuery(queryStr);

            if (null != announTitle && !announTitle.trim().equals("")) {
                query.setString("announTitle", "%" + announTitle + "%");
            }
            if (null != publishTime && !publishTime.toString().trim().equals("")) {
                query.setDate("publishTime", publishTime);
            }
            if (null != announContent && !announContent.trim().equals("")) {
                query.setString("announContent", "%" + announContent + "%");
            }
            query.setFirstResult(pageBean.getBeginIndex());
            query.setMaxResults(pageBean.getPageCapibility());
            return query.list();
        } catch (RuntimeException e) {
            log.error("find common student and teacher TAnnouncement failed", e);
            throw e;
        }
    }

    /**
     *
     * @param announTitle
     * @param announContent
     * @param publishTime
     * @return
     */
    @Override
    public int getCommonStuAndTeaAnnounCount(String announTitle, String announContent, Date publishTime) {
        log.debug("finding common student and teacher TAnnouncement count instances by pageBeanun");
        try {
            String queryStr = "select count(*) from TAnnouncement t where t.isdeleted = 'N' and t.publishState = 'Y' and t.publisherCode in " +
                    "(select u.userId from TUser u where u.userType = '04' or u.userType = '05' or u.userType = '06' or u.userType = '07' or u.userType = '08')";
            if (null != announTitle && !announTitle.trim().equals("")) {
                queryStr += " and t.announTitle like :announTitle";
            }
            if (null != announContent && !announContent.trim().equals("")) {
                queryStr += " and t.announContent like :announContent";
            }
            if (null != publishTime && !publishTime.toString().trim().equals("")) {
                queryStr += " and t.publishTime >= :publishTime and t.publishTime <= :publishTime+1";
            }

            Query query = getSessionFactory().getCurrentSession().createQuery(queryStr);

            if (null != announTitle && !announTitle.trim().equals("")) {
                query.setString("announTitle", "%" + announTitle + "%");
            }
            if (null != announContent && !announContent.trim().equals("")) {
                query.setString("announContent", "%" + announContent + "%");
            }
            if (null != publishTime && !publishTime.toString().trim().equals("")) {
                query.setDate("publishTime", publishTime);
            }

            List tmpList = query.list();
            int count = 0;
            if (tmpList.size() > 0) {
                count = new Integer("" + tmpList.get(0));
            }
            return count;
        } catch (RuntimeException e) {
            log.error("find common student and teacher count TAnnouncement failed", e);
            throw e;
        }
    }

}
