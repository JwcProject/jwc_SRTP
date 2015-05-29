package edu.cqu.no1.dao.impl;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;
import edu.cqu.no1.dao.*;
import edu.cqu.no1.domain.TAnnouncement;
import edu.cqu.no1.domain.TAnnouncementModel;
import edu.cqu.no1.util.PageBean;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
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
     * TODO 根据公告ID获取公告的信息，包括发布者名称
     *
     * @param announId
     * @return
     */

    public TAnnouncementModel getAnnounById(String announId) {
        log.debug("get a announcement with publisherName by announId");
        try {
            String queryString = "select t.*,s.USER_NAME as PUBLISHERNAME from T_ANNOUNCEMENT t,T_USER s where t.ANNOUN_ID=:aID and t.PUBLISHER_CODE=s.USER_ID";
            SQLQuery sqlQuery = getSessionFactory().getCurrentSession().createSQLQuery(queryString);
            sqlQuery.setString("aID", announId);
            @SuppressWarnings("unchecked")
            List<TAnnouncementModel> list = sqlQuery.addEntity(
                    TAnnouncementModel.class).list();
            if (list.size() > 0) {
                return list.get(0);
            }
            return null;
        } catch (RuntimeException e) {
            log.error(
                    "get a announcement with publisherName by announId failed ",
                    e);
            throw e;
        }
    }

    /**
     * TODO 学生或老师查询本人的公告
     *
     * @param number     学号或教职工号
     * @param announName
     * @param announDate
     * @param pageBean
     * @return
     */

    public List findStuTeatAnnoun(String number, String announName,
                                  Date announDate, PageBean pageBean) {
        log.debug("finding Student TAnnouncement instances");
        try {
            String queryStr = "select t.*,s.USER_NAME as PUBLISHERNAME from T_ANNOUNCEMENT t,T_USER s where t.ISDELETED = 'N' and t.PUBLISHER_CODE=s.USER_ID and t.PUBLISHER_CODE=:code";
            if (null != announName && !announName.trim().equals("")) {
                queryStr += " and t.ANNOUN_TITLE like :aName";
            }
            if (null != announDate && !announDate.toString().trim().equals("")) {
                queryStr += " and t.PUBLISH_TIME >= :aDate and t.PUBLISH_TIME <= :aDate+1";
            }
            SQLQuery sqlQuery = getSessionFactory().getCurrentSession().createSQLQuery(queryStr);
            sqlQuery.setString("code", number);
            if (null != announName && !announName.trim().equals("")) {
                sqlQuery.setString("aName", "%" + announName + "%");
            }
            if (null != announDate && !announDate.toString().trim().equals("")) {
                sqlQuery.setDate("aDate", announDate);
            }
            sqlQuery.setFirstResult(pageBean.getBeginIndex());
            sqlQuery.setMaxResults(pageBean.getPageCapibility());
            return sqlQuery.addEntity(TAnnouncementModel.class).list();
        } catch (RuntimeException re) {
            log.error("find Student failed", re);
            throw re;
        }

    }


    public int findStuTeaAnnounCount(String number, String announName,
                                     Date announDate) {
        log.debug("finding StuTea count TAnnouncement instances");
        try {
            String queryStr = "select count(*) from T_ANNOUNCEMENT t where t.ISDELETED = 'N' and t.PUBLISHER_CODE=:code";
            if (null != announName && !announName.trim().equals("")) {
                queryStr += " and t.ANNOUN_TITLE like :aName";
            }
            if (null != announDate && !announDate.toString().trim().equals("")) {
                queryStr += " and t.PUBLISH_TIME >= :aDate and t.PUBLISH_TIME <= :aDate+1";
            }
            SQLQuery sqlQuery = getSessionFactory().getCurrentSession().createSQLQuery(queryStr);
            sqlQuery.setString("code", number);
            if (null != announName && !announName.trim().equals("")) {
                sqlQuery.setString("aName", "%" + announName + "%");
            }
            if (null != announDate && !announDate.toString().trim().equals("")) {
                sqlQuery.setDate("aDate", announDate);
            }
            List list = sqlQuery.list();
            int count = 0;
            if (list.size() > 0) {
                count = new Integer("" + list.get(0));
            }
            return count;
        } catch (RuntimeException re) {
            log.error("find StuTea count failed", re);
            throw re;
        }
    }

    /**
     * TODO 学院主管教师查询本学院的公告
     *
     * @param teaCode    主管教室教职工号
     * @param announName
     * @param announDate
     * @param pageBean
     * @return
     */

    public List findUnitAnnoun(String teaCode, String announName,
                               Date announDate, PageBean pageBean) {
        log.debug("finding unit TAnnouncement");
        try {
            String queryString = "Select A.*,Uu.User_Name as PUBLISHERNAME From T_Announcement A, T_User Uu Where A.Isdeleted='N'";
            if (null != announName && !announName.trim().equals("")) {
                queryString += " and A.ANNOUN_TITLE like :aName";
            }
            if (null != announDate && !announDate.toString().trim().equals("")) {
                queryString += " and A.PUBLISH_TIME >= :aDate and A.PUBLISH_TIME <= :aDate+1";
            }
            queryString += " and A.Publisher_Code = Uu.User_Id And (A.Publisher_Code In "
                    + "(Select T.Tea_Code From T_Teacher t Where T.Unit_Id = "
                    + "(Select Tt.Unit_Id From T_Teacher Tt Where Tt.Tea_Code =:code)) "
                    + "Or A.Publisher_Code In (Select S.Student_Number From T_Student s Where s.Unit_Id = "
                    + "(Select Tt.Unit_Id From T_Teacher Tt Where Tt.Tea_Code =:code)))";
            SQLQuery sqlQuery = getSessionFactory().getCurrentSession().createSQLQuery(queryString);
            sqlQuery.setString("code", teaCode);
            if (null != announName && !announName.trim().equals("")) {
                sqlQuery.setString("aName", "%" + announName + "%");
            }
            if (null != announDate && !announDate.toString().trim().equals("")) {
                sqlQuery.setDate("aDate", announDate);
            }
            System.out.println("unit-->" + queryString);
            sqlQuery.setFirstResult(pageBean.getBeginIndex());
            sqlQuery.setMaxResults(pageBean.getPageCapibility());
            return sqlQuery.addEntity(TAnnouncementModel.class).list();
        } catch (RuntimeException e) {
            log.error("query unit TAnnouncement failed: " + e);
            throw e;
        }
    }


    public int findUnitAnnounCount(String teaCode, String announName,
                                   Date announDate) {
        log.debug("finding unit TAnnouncement");
        try {
            String queryString = "select count(*) from T_Announcement A where A.Isdeleted='N'";
            if (null != announName && !announName.trim().equals("")) {
                queryString += " and A.ANNOUN_TITLE like :aName";
            }
            if (null != announDate && !announDate.toString().trim().equals("")) {
                queryString += " and A.PUBLISH_TIME >= :aDate and A.PUBLISH_TIME <= :aDate+1";
            }
            queryString += " and (A.Publisher_code in "
                    + " (select T.Tea_Code From T_Teacher t Where T.Unit_Id = "
                    + " (Select Tt.Unit_Id From T_Teacher Tt Where Tt.Tea_Code =:code))"
                    + " Or A.Publisher_Code In (Select S.Student_Number From T_Student s Where s.Unit_Id = "
                    + " (Select Tt.Unit_Id From T_Teacher Tt Where Tt.Tea_Code =:code)))";
            SQLQuery sqlQuery = getSessionFactory().getCurrentSession().createSQLQuery(queryString);
            sqlQuery.setString("code", teaCode);
            if (null != announName && !announName.trim().equals("")) {
                sqlQuery.setString("aName", "%" + announName + "%");
            }
            if (null != announDate && !announDate.toString().trim().equals("")) {
                sqlQuery.setDate("aDate", announDate);
            }
            List list = sqlQuery.list();
            int count = 0;
            if (list.size() > 0) {
                count = new Integer("" + list.get(0));
            }
            System.out.println("count--》" + count);
            return count;
        } catch (RuntimeException e) {
            log.error("query unit TAnnouncement count failed: " + e);
            throw e;
        }

    }

    /**
     * TODO教务处查询公告
     *
     * @param announName
     * @param announDate
     * @param publisherName
     * @param typeName
     * @param pageBean
     * @return
     */

    public List findSchoolAnnoun(String announName, String checkState,
                                 Date announDate, String publisherName, String typeName,
                                 PageBean pageBean) {
        log.debug("find school TAnnouncements ");
        try {
            String queryString = "Select A.*,Uu.User_Name as PUBLISHERNAME From T_Announcement A,"
                    + "T_User Uu Where A.Isdeleted='N' and A.Publisher_Code = Uu.User_Id";
            if (null != announName && !announName.trim().equals("")) {
                queryString += " and A.ANNOUN_TITLE like :aName";
            }
            if (null != checkState && !checkState.trim().equals("") && !checkState.trim().equals("ALL")) {
                queryString += " and A.CHECK_STATE =:aState";
            }
            if (null != checkState && checkState.trim().equals("ALL")) {
                queryString += " and A.CHECK_STATE in (select t.CHECK_STATE from t_announcement t where t.check_state is not null)";
            }
            if (null != announDate && !announDate.toString().trim().equals("")) {
                queryString += " and A.PUBLISH_TIME >= :aDate and A.PUBLISH_TIME <= :aDate+1";
            }
            if (null != publisherName && !publisherName.trim().equals("")) {
                queryString += " and A.PUBLISHER_CODE in (select Uu.USER_ID from T_User Uu where Uu.USER_NAME like :uName)";
            }
            if (null != typeName && !typeName.trim().equals("00")) {
                queryString += " and A.ANNOUN_TYPE_ID = (select Ta.Announ_Type_Id from t_announ_type Ta where Ta.Announ_Type_Name like :tName)";
            }
            queryString += " order by PUBLISH_TIME desc";
            SQLQuery sqlQuery = getSessionFactory().getCurrentSession().createSQLQuery(queryString);

            if (null != announName && !announName.trim().equals("")) {
                sqlQuery.setString("aName", "%" + announName + "%");
            }
            if (null != checkState && !checkState.trim().equals("") && !checkState.trim().equals("ALL")) {
                sqlQuery.setString("aState", checkState);
            }
            if (null != announDate && !announDate.toString().trim().equals("")) {
                sqlQuery.setDate("aDate", announDate);
            }
            if (null != publisherName && !publisherName.trim().equals("")) {
                sqlQuery.setString("uName", "%" + publisherName + "%");
            }
            if (null != typeName && !typeName.trim().equals("00")) {
                sqlQuery.setString("tName", "%" + typeName + "%");
            }
            sqlQuery.setFirstResult(pageBean.getBeginIndex());
            sqlQuery.setMaxResults(pageBean.getPageCapibility());
            return sqlQuery.addEntity(TAnnouncementModel.class).list();
        } catch (RuntimeException e) {
            log.error("find school TAnnouncement " + e);
            throw e;
        }

    }


    public int findSchoolAnnounCount(String announName, String checkState,
                                     Date announDate, String publisherName, String typeName) {
        log.debug("find school count TAnnouncements ");
        try {
            String queryString = "Select count(*) From T_Announcement A Where A.Isdeleted='N'";

            if (null != announName && !announName.trim().equals("")) {
                queryString += " and A.ANNOUN_TITLE like :aName";
            }
            if (null != checkState && !checkState.trim().equals("") && !checkState.trim().equals("ALL")) {
                queryString += " and A.CHECK_STATE =:aState";
            }
            if (null != checkState && checkState.equals("ALL")) {
                queryString += " and A.CHECK_STATE in (select t.CHECK_STATE from t_announcement t where t.check_state is not null)";
            }
            if (null != announDate && !announDate.toString().trim().equals("")) {
                queryString += " and A.PUBLISH_TIME >= :aDate and A.PUBLISH_TIME <= :aDate+1";
            }
            if (null != publisherName && !publisherName.trim().equals("")) {
                queryString += " and A.PUBLISHER_CODE in (select Uu.USER_ID from T_User Uu where Uu.USER_NAME like :uName)";
            }
            if (null != typeName && !typeName.trim().equals("00")) {
                queryString += " and A.ANNOUN_TYPE_ID = (select Ta.Announ_Type_Id from t_announ_type Ta where Ta.Announ_Type_Name like :tName)";
            }
            SQLQuery sqlQuery = getSessionFactory().getCurrentSession().createSQLQuery(queryString);
            if (null != announName && !announName.trim().equals("")) {
                sqlQuery.setString("aName", "%" + announName + "%");
            }
            if (null != checkState && !checkState.trim().equals("") && !checkState.trim().equals("ALL")) {
                sqlQuery.setString("aState", checkState);
            }
            if (null != announDate && !announDate.toString().trim().equals("")) {
                sqlQuery.setDate("aDate", announDate);
            }
            if (null != publisherName && !publisherName.trim().equals("")) {
                sqlQuery.setString("uName", "%" + publisherName + "%");
            }
            if (null != typeName && !typeName.trim().equals("00")) {
                sqlQuery.setString("tName", "%" + typeName + "%");
            }
            List list = sqlQuery.list();
            int count = 0;
            if (list.size() > 0) {
                count = new Integer("" + list.get(0));
            }
            System.out.println("school query count-->" + count);
            return count;
        } catch (RuntimeException e) {
            log.error("find school count TAnnouncement " + e);
            throw e;
        }
    }

    /**
     * TODO
     *
     * @param code     学生学号/指导老师教职工号
     * @param pageBean return List
     */

    public List getStuTeaAnnounctment(String code, PageBean pageBean) {
        log.debug("finding all person TAnnouncement instances by pageBeanun");
        try {// as publisherName
            String queryStr = "select t.*,s.USER_NAME as PUBLISHERNAME from T_ANNOUNCEMENT t,T_USER s where t.ISDELETED = 'N' and t.PUBLISHER_CODE=s.USER_ID and t.PUBLISHER_CODE=:code";
            SQLQuery sqlQuery = getSessionFactory().getCurrentSession().createSQLQuery(queryStr);
            sqlQuery.setString("code", code);
            sqlQuery.setFirstResult(pageBean.getBeginIndex());
            sqlQuery.setMaxResults(pageBean.getPageCapibility());
            return sqlQuery.addEntity(TAnnouncementModel.class).list();
        } catch (RuntimeException e) {
            log.error("find all failed", e);
            throw e;
        }
    }


    public int getStuTeaAnnouncementCount(String code) {
        log.debug("finding all person TAnnouncement count");
        try {
            String queryStr = "select count(*) from TAnnouncement as t where t.isdeleted='N' and t.publisherCode=:code";
            Query query = getSessionFactory().getCurrentSession().createQuery(queryStr);
            query.setString("code", code);
            List tmpList = query.list();
            int count = 0;
            if (tmpList.size() > 0) {
                count = new Integer("" + tmpList.get(0));
            }
            return count;

        } catch (RuntimeException e) {
            log.error("find my count  failed", e);
            throw e;
        }
    }

    /**
     * TODO 学员主管教师获取属于一个学院的公告
     *
     * @param unitTeaCode 学院主管老师的教职工号
     * @param pageBean    return List
     */

    public List getUnitAnnounctment(String unitTeaCode, PageBean pageBean) {
        log.debug("finding unit all TAnnouncement instances by pageBeanun");
        try {
            String queryStr = "Select A.*,Uu.User_Name as PUBLISHERNAME From T_Announcement A, T_User Uu Where A.Isdeleted='N' and A.Publisher_Code = Uu.User_Id And (A.Publisher_Code In (Select T.Tea_Code From T_Teacher t Where T.Unit_Id = (Select Tt.Unit_Id From T_Teacher Tt Where Tt.Tea_Code =:code)) Or A.Publisher_Code In (Select S.Student_Number From T_Student s Where s.Unit_Id = (Select Tt.Unit_Id From T_Teacher Tt Where Tt.Tea_Code =:code)))";
            SQLQuery sqlQuery = getSessionFactory().getCurrentSession().createSQLQuery(queryStr);
            sqlQuery.setString("code", unitTeaCode);
            //sqlQuery.setFetchSize(pageBean.getBeginIndex());
            sqlQuery.setFirstResult(pageBean.getBeginIndex());
            sqlQuery.setMaxResults(pageBean.getPageCapibility());
            List aList = sqlQuery.list();
            //aList = sqlQuery.addEntity(TAnnouncementModel.class).list();
            return sqlQuery.addEntity(TAnnouncementModel.class).list();
        } catch (RuntimeException e) {
            log.error("find unit all TAnnouncement failed", e);
            throw e;
        }
    }


    public int getUnitAnnounctmentCount(String unitTeaCode) {
        log.debug("finding unit all TAnnouncement instances by pageBeanun");
        try {
            String queryStr = "select count(*) from T_Announcement A where A.Isdeleted='N' and (A.Publisher_code in "
                    + "(select T.Tea_Code From T_Teacher t Where T.Unit_Id = "
                    + "(Select Tt.Unit_Id From T_Teacher Tt Where Tt.Tea_Code =:code))"
                    + " Or A.Publisher_Code In (Select S.Student_Number From T_Student s Where s.Unit_Id = "
                    + "(Select Tt.Unit_Id From T_Teacher Tt Where Tt.Tea_Code =:code)))";
            SQLQuery sqlQuery = getSessionFactory().getCurrentSession().createSQLQuery(queryStr);
            sqlQuery.setString("code", unitTeaCode);
            List tmpList = sqlQuery.list();
            int count = 0;
            if (tmpList.size() > 0) {
                count = new Integer("" + tmpList.get(0));
            }
            return count;
        } catch (RuntimeException e) {
            log.error("find unit all TAnnouncement failed", e);
            throw e;
        }
    }

    //通过当前学生所在学院获取学院公告

    public List getUnitAnnounctmentByStuCode(String unitStuCode, PageBean pageBean) {
        log.debug("getting unit all TAnnouncement instances by pageBeanun");
        try {
            String queryStr = "from TAnnouncement t where t.isdeleted = 'N' and t.publishState = 'Y' and t.publisherCode in " +
                    "(select tt.teaCode from TTeacher tt where tt.TUnit.unitId = " +
                    "(select s.TUnit.unitId from TStudent s where s.TUser.userId =:unitStuCode) " +
                    "and tt.teaCode in (select u.userId from TUser u where u.userType = '02' or u.userType = '03'))";
            Query query = getSessionFactory().getCurrentSession().createQuery(queryStr);
            query.setString("unitStuCode", unitStuCode);
            query.setFirstResult(pageBean.getBeginIndex());
            query.setMaxResults(pageBean.getPageCapibility());
            return query.list();
        } catch (RuntimeException e) {
            log.error("get unit all TAnnouncement failed", e);
            throw e;
        }
    }


    public int getUnitAnnounctmentByStuCodeCount(String unitStuCode) {
        log.debug("getting unit all TAnnouncement count instances by pageBean");
        try {
            String queryStr = "select count(*) from TAnnouncement t where t.isdeleted = 'N' and t.publishState = 'Y' and t.publisherCode in " +
                    "(select tt.teaCode from TTeacher tt where tt.TUnit.unitId = " +
                    "(select s.TUnit.unitId from TStudent s where s.TUser.userId =:unitStuCode) " +
                    "and tt.teaCode in (select u.userId from TUser u where u.userType = '02' or u.userType = '03'))";
            Query query = getSessionFactory().getCurrentSession().createQuery(queryStr);
            query.setString("unitStuCode", unitStuCode);
            List tmpList = query.list();
            int count = 0;
            if (tmpList.size() > 0) {
                count = new Integer("" + tmpList.get(0));
            }
            return count;
        } catch (RuntimeException e) {
            log.error("get unit all TAnnouncement count failed", e);
            throw e;
        }
    }

    //查询当前学生所在学院的学院公告

    public List findUnitAnnounctmentByStuCode(String unitStuCode, String announTitle, Date publishTime, PageBean pageBean) {
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


    public int findUnitAnnounctmentByStuCodeCount(String unitStuCode, String announTitle, Date publishTime) {
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

    //获取普通学生和普通教师的公告

    public List getCommonStuAndTeaAnnoun(PageBean pageBean) {
        log.debug("getting common student and teacher TAnnouncement instances by pageBeanun");
        try {
            String queryStr = "from TAnnouncement t where t.isdeleted = 'N' and t.publishState = 'Y' and t.publisherCode in " +
                    "(select u.userId from TUser u where u.userType = '04' or u.userType = '05' or u.userType = '06' or u.userType = '07' or u.userType = '08')";
            Query query = getSessionFactory().getCurrentSession().createQuery(queryStr);
            query.setFirstResult(pageBean.getBeginIndex());
            query.setMaxResults(pageBean.getPageCapibility());
            return query.list();
        } catch (RuntimeException e) {
            log.error("get common student and teacher TAnnouncement failed", e);
            throw e;
        }
    }


    public int getCommonStuAndTeaAnnounCount() {
        log.debug("getting common student and teacher TAnnouncement count instances by pageBeanun");
        try {
            String queryStr = "select count(*) from TAnnouncement t where t.isdeleted = 'N' and t.publishState = 'Y' and t.publisherCode in " +
                    "(select u.userId from TUser u where u.userType = '04' or u.userType = '05' or u.userType = '06' or u.userType = '07' or u.userType = '08')";
            Query query = getSessionFactory().getCurrentSession().createQuery(queryStr);
            List tmpList = query.list();
            int count = 0;
            if (tmpList.size() > 0) {
                count = new Integer("" + tmpList.get(0));
            }
            return count;
        } catch (RuntimeException e) {
            log.error("get common student and teacher count TAnnouncement failed", e);
            throw e;
        }
    }

    //查询普通学生和普通教师的公告

    public List findCommonStuAndTeaAnnoun(String announTitle, String announContent, Date publishTime, PageBean pageBean) {
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


    public int findCommonStuAndTeaAnnounCount(String announTitle, String announContent, Date publishTime) {
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

    /**
     * TODO 教务处主管老师获取所有未删除的公告
     *
     * @param pageBean return List
     */

    public List getSchoolAnnounctment(PageBean pageBean) {
        log.debug("finding all School TAnnouncement instances by pageBeanun");
        try {
            String queryStr = "Select A.*,Uu.User_Name as PUBLISHERNAME From T_Announcement A, T_User Uu Where A.Isdeleted='N' and A.Publisher_Code = Uu.User_Id and A.CHECK_STATE in (select t.CHECK_STATE from t_announcement t where t.check_state is not null)  order by PUBLISH_TIME desc";
            SQLQuery sqlQuery = getSessionFactory().getCurrentSession().createSQLQuery(queryStr);
            sqlQuery.setFirstResult(pageBean.getBeginIndex());
            sqlQuery.setMaxResults(pageBean.getPageCapibility());
            return sqlQuery.addEntity(TAnnouncementModel.class).list();
        } catch (RuntimeException e) {
            log.error("find all School failed", e);
            throw e;
        }
    }


    public int getSchoolAnnounctmentCount() {
        log.debug("finding all School TAnnouncement count");
        try {
            String queryStr = "select count(*) from T_Announcement A where A.isdeleted = 'N'  and A.CHECK_STATE in (select t.CHECK_STATE from t_announcement t where t.check_state is not null)";
            SQLQuery sqlQuery = getSessionFactory().getCurrentSession().createSQLQuery(queryStr);
            List tmpList = sqlQuery.list();
            int count = 0;
            if (tmpList.size() > 0) {
                count = new Integer("" + tmpList.get(0));
            }
            return count;
        } catch (RuntimeException e) {
            log.error("find all School count failed", e);
            throw e;
        }
    }

    /**
     * TODO根据公告类别获取公告的ID，名称
     *
     * @param typeName 公告类别名称
     * @return
     */

    public List findAnnounByType(String typeName, PageBean pageBean) {
        log.debug("find TAnnouncement by type");
        try {
            String queryString = "select t.*,Uu.User_Name as PUBLISHERNAME from T_Announcement t,T_announ_type Ta,T_User Uu "
                    + "where t.ISDELETED='N' and t.PUBLISH_STATE = 'Y' and t.Publisher_Code = Uu.User_Id and t.ANNOUN_TYPE_ID=Ta.Announ_Type_Id and Ta.Announ_Type_Name like :tName";
            SQLQuery sqlQuery = getSessionFactory().getCurrentSession().createSQLQuery(queryString);
            sqlQuery.setString("tName", "%" + typeName + "%");
            sqlQuery.setFirstResult(pageBean.getBeginIndex());
            sqlQuery.setMaxResults(pageBean.getPageCapibility());
            return sqlQuery.addEntity(TAnnouncementModel.class).list();
        } catch (RuntimeException e) {
            log.error("find announcement by type failed " + e);
            throw e;
        }

    }


    public int findAnnounByTypeCount(String typeName) {
        log.debug("find TAnnouncement count by type");
        try {
            String queryString = "select count(*) from T_Announcement t,T_announ_type Ta "
                    + "where t.ISDELETED='N' and t.PUBLISH_STATE = 'Y' and t.ANNOUN_TYPE_ID=Ta.Announ_Type_Id and Ta.Announ_Type_Name like :tName";
            SQLQuery sqlQuery = getSessionFactory().getCurrentSession().createSQLQuery(queryString);
            sqlQuery.setString("tName", "%" + typeName + "%");
            List list = sqlQuery.list();
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

    //查询主页学校公告

    public List findIndexSchoolAnnoument(String announTitle, Date publishTime, String typeName, PageBean pageBean) {
        log.debug("find TAnnouncement by type");
        try {
            String queryString = "select t.*,Uu.User_Name as PUBLISHERNAME from T_Announcement t,T_announ_type Ta,T_User Uu "
                    + "where t.ISDELETED='N' and t.PUBLISH_STATE = 'Y' and t.Publisher_Code = Uu.User_Id and t.ANNOUN_TYPE_ID=Ta.Announ_Type_Id and Ta.Announ_Type_Name like :tName";
            if (null != announTitle && !announTitle.trim().equals("")) {
                queryString += " and t.ANNOUN_TITLE like :announTitle";
            }
            if (null != publishTime && !publishTime.toString().trim().equals("")) {
                queryString += " and t.PUBLISH_TIME >= :publishTime and t.PUBLISH_TIME <= :publishTime+1";
            }

            SQLQuery sqlQuery = getSessionFactory().getCurrentSession().createSQLQuery(queryString);

            if (null != announTitle && !announTitle.trim().equals("")) {
                sqlQuery.setString("announTitle", "%" + announTitle + "%");
            }

            if (null != publishTime && !publishTime.toString().trim().equals("")) {
                sqlQuery.setDate("publishTime", publishTime);
            }

            sqlQuery.setString("tName", "%" + typeName + "%");
            sqlQuery.setFirstResult(pageBean.getBeginIndex());
            sqlQuery.setMaxResults(pageBean.getPageCapibility());
            return sqlQuery.addEntity(TAnnouncementModel.class).list();
        } catch (RuntimeException e) {
            log.error("find announcement by type failed " + e);
            throw e;
        }
    }


    public int findIndexSchoolAnnoumentCount(String announTitle, Date publishTime, String typeName) {
        log.debug("find TAnnouncement count by type");
        try {
            String queryString = "select count(*) from T_Announcement t,T_announ_type Ta "
                    + "where t.ISDELETED='N' and t.PUBLISH_STATE = 'Y' and t.ANNOUN_TYPE_ID=Ta.Announ_Type_Id and Ta.Announ_Type_Name like :tName";
            if (null != announTitle && !announTitle.trim().equals("")) {
                queryString += " and t.ANNOUN_TITLE like :announTitle";
            }
            if (null != publishTime && !publishTime.toString().trim().equals("")) {
                queryString += " and t.PUBLISH_TIME >= :publishTime and t.PUBLISH_TIME <= :publishTime+1";
            }
            SQLQuery sqlQuery = getSessionFactory().getCurrentSession().createSQLQuery(queryString);
            if (null != announTitle && !announTitle.trim().equals("")) {
                sqlQuery.setString("announTitle", "%" + announTitle + "%");
            }

            if (null != publishTime && !publishTime.toString().trim().equals("")) {
                sqlQuery.setDate("publishTime", publishTime);
            }
            sqlQuery.setString("tName", "%" + typeName + "%");
            List list = sqlQuery.list();
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

}
