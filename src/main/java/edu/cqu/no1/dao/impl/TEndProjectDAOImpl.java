package edu.cqu.no1.dao.impl;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;
import edu.cqu.no1.dao.TEndProjectDAO;
import edu.cqu.no1.datamodel.EndProjectProperty;
import edu.cqu.no1.domain.TEndProject;
import edu.cqu.no1.domain.TEndProjectExport;
import edu.cqu.no1.util.PageBean;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.*;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by ZKQ on 2015/5/27.
 */

@Repository
public class TEndProjectDAOImpl extends BaseDaoImpl<TEndProject> implements TEndProjectDAO {
    private static final Logger log = LoggerFactory
            .getLogger(TEndProjectDAO.class);
    // property constants
    public static final String ENDPROJECT_STATE = "endprojectState";
    public static final String ENDPROJECT_SUMMARY = "endprojectSummary";
    public static final String ENDPROJECT_METHOD = "endprojectMethod";
    public static final String ENDPROJECT_SCORE = "endprojectScore";
    public static final String LAST_SCORE = "lastScore";
    public static final String ENDPROJECT_NUMBER = "endprojectNumber";
    public static final String LAST_COMMENT = "lastComment";
    public static final String ENDPROJECT_COMMENT = "endprojectComment";
    public static final String ENDPROJECT_NAME = "endprojectName";
    public static final String ENDPROJECT_SENSE = "endprojectSense";
    public static final String ENDPROJECT_CONTENT = "endprojectContent";
    public static final String ENDPROJECT_CREDIT = "endprojectCredit";
    public static final String ENDPROJECT_PROBLEM = "endprojectProblem";
    public static final String ENDPROJECT_INNOVATE = "endprojectInnovate";
    public static final String ENDPROJECT_INTRODUCTION = "endprojectIntroduction";
    public static final String ENDPROJECT_WORK = "endprojectWork";
    public static final String ISDELETED = "isdeleted";
    public static final String ENDPROJECT_PASSAPPLY = "endprojectPassapply";

    /**
     * lsp
     */
//	public int getEndProjectCountForSecReview(EndProjectProperty properties){
//		Criteria criteria = getCriteriaForSecReview(properties);
//		int rowCount = (Integer) criteria.setProjection(Projections.rowCount())
//				.uniqueResult();
//		criteria.setProjection(null);
//		return rowCount;
//	}
    public List getEndProjectsForResultTypeIn(EndProjectProperty properties,Boolean typeIned,PageBean pageBean) {
        Criteria criteria = getCriteriaByByMutiProperty(properties);
        if(typeIned){
            criteria.add(Restrictions.isNotNull("lastScore"));
        }else{
            criteria.add(Restrictions.isNull("lastScore"));
        }
        criteria.setFirstResult(pageBean.getBeginIndex());
        criteria.setMaxResults(pageBean.getPageCapibility());
        criteria.addOrder(Order.desc("p.projectEndtime"));
        return criteria.list();
    }
    public int getEndProjectCountForResultTypeIn(EndProjectProperty properties,Boolean typeIned){
        Criteria criteria = getCriteriaByByMutiProperty(properties);
        if(typeIned){
            criteria.add(Restrictions.isNotNull("lastScore"));
        }else{
            criteria.add(Restrictions.isNull("lastScore"));
        }
        int rowCount = (Integer) criteria.setProjection(Projections.rowCount())
                .uniqueResult();
        criteria.setProjection(null);
        return rowCount;
    }

    public int getEndProjectCountByMutiProperty(EndProjectProperty properties) {
        Criteria criteria = getCriteriaByByMutiProperty(properties);
        int rowCount = ((Long)criteria.setProjection(Projections.rowCount())
                .uniqueResult()).intValue();
        criteria.setProjection(null);
        return rowCount;
    }

    public List getEndProjectsByMutiProperty(EndProjectProperty properties,
                                             PageBean pageBean) {
        Criteria criteria = getCriteriaByByMutiProperty(properties);
        criteria.setFirstResult(pageBean.getBeginIndex());
        criteria.setMaxResults(pageBean.getPageCapibility());
        criteria.addOrder(Order.desc("p.projectEndtime"));
        return criteria.list();
    }
    /**
     * 获取参加二次评审但未录入成绩的结题
     * @param properties
     * @return
     */
    private Criteria getCriteriaForSecReview(EndProjectProperty properties,String teaCode,Boolean typeIned){
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(TEndProjectExport.class)
                .setProjection(Projections.property("TEndProject.endprojectId"))
                .add(Restrictions.eq("isdeleted", "N"))
                .createCriteria("TExpertTeacher","e")
                .createCriteria("TTeacher", "t")
                .add(Restrictions.eq("t.teaCode", teaCode));
        Criteria criteria = getCriteriaByByMutiProperty(properties).add(Property.forName("endprojectId").in(detachedCriteria));
        if(typeIned){
            criteria.add(Restrictions.isNotNull("lastScore"));
        }else{
            criteria.add(Restrictions.isNull("lastScore"));
        }
        return criteria;
    }
    private Criteria getCriteriaByByMutiProperty(EndProjectProperty properties) {
        Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(TEndProject.class);
        Criteria tempCriteria = criteria.createCriteria("TProject", "p");
        tempCriteria.createCriteria("TUnit", "u");
        tempCriteria.createCriteria("TStudentByProjectLeader", "s")
                .createCriteria("TProfessionByProfessionId", "f");
        criteria.createCriteria("TJieqi", "j");
        if (properties != null) {
            if (properties.getEndprojectScore() != null && !"".equals(properties.getEndprojectScore().trim())
                    && !"0".equals(properties.getEndprojectScore())) {
                criteria.add(Restrictions.eq("endprojectScore",
                        properties.getEndprojectScore()));
            }
            if (properties.getEndprojectState() != null && !"".equals(properties.getEndprojectState().trim())
                    && !"0".equals(properties.getEndprojectState())) {
                criteria.add(Restrictions.eq("endprojectState",
                        properties.getEndprojectState()));
            }
            if (properties.getYear() != null && !"".equals(properties.getYear().trim())
                    && !"0".equals(properties.getYear())) {
                criteria.add(Restrictions.eq("j.jqYear", new BigDecimal(
                        properties.getYear())));
            }
            if (properties.getJieqiId() != null && !"".equals(properties.getJieqiId().trim())
                    && !"0".equals(properties.getJieqiId())) {
                criteria.add(Restrictions.eq("j.jqId", properties.getJieqiId()));
            }
            if (properties.getProfessionId() != null && !"".equals(properties.getProfessionId().trim())
                    && !"0".equals(properties.getProfessionId())) {
                criteria.add(Restrictions.eq("f.professionId",
                        properties.getProfessionId()));
            }
            if (properties.getUnitId() != null && !"".equals(properties.getUnitId().trim())
                    && !"0".equals(properties.getUnitId())) {
                criteria.add(Restrictions.eq("u.unitId", properties.getUnitId()));
            }
            if (properties.getProjectName() != null && !"".equals(properties.getProjectName().trim())) {
                criteria.add(Restrictions.like("p.projectName", "%"
                        + properties.getProjectName() + "%"));
            }
            if (properties.getStudentNumber() != null && !"".equals(properties.getStudentNumber().trim())) {
                criteria.add(Restrictions.like("s.studentNumber", "%"
                        + properties.getStudentNumber() + "%"));
            }
        }
        criteria.add(Restrictions.eq("isdeleted", "N"));
        return criteria;
    }

    public TEndProject findByLeaderCode(String leaderCode){
        log.debug("find endproject by leader code");
        try {
            String sqlString="from TEndProject T where T.isdeleted = 'N' and T.TProject.TStudentByProjectLeader.studentNumber=:number";
            Query query = getSessionFactory().getCurrentSession().createQuery(sqlString);
            query.setString("number", leaderCode);
            List list = query.list();
            if(list.size()>0){
                return (TEndProject)list.get(0);
            }
            return null;
        } catch (RuntimeException e) {
            log.debug("find endproject by leader code failed"+e);
            throw e;
        }
    }


    /**
     *
     * 多条件查询结题 authoy lzh
     *
     * @param teaCode
     * @param year
     * @param qici
     * @param proNumber
     * @param proName
     * @param profession
     * @param stuNumber
     * @param state
     * @param pageBean
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<TEndProject> findEndProByMutipleProperty(String teaCode,
                                                         String year, String qici, String proNumber, String proName,
                                                         String profession, String stuNumber, String state, PageBean pageBean) {
        log.debug("find endproject by mutiple property");
        try {
            String queryString = "From TEndProject T where T.isdeleted='N'";
            if (null != qici && !qici.trim().equals("")) {
                queryString += " and T.TJieqi.jqId=:qici";
            } else {
                if (null != year && !year.trim().equals("")) {
                    queryString += " and T.TJieqi.jqYear=:year";
                }
            }
            if (null != proNumber && !proNumber.trim().equals("")) {
                queryString += " and T.TProject.projectNumber=:number";
            }
            if (null != proName && !proName.trim().equals("")) {
                queryString += " and T.TProject.projectName=:name";
            }
            if (null != profession && !profession.trim().equals("")) {
                queryString += " and T.TProject.TStudentByProjectLeader.TProfession.professionName=:profession";
            }
            if (null != stuNumber && !stuNumber.trim().equals("")) {
                queryString += " and T.TProject.TStudentByProjectLeader.studentNumber=:stuNumber";
            }
            if (null != state && !state.trim().equals("")) {
                queryString += " and T.endprojectState=:state";
            }
            if (null != teaCode && !teaCode.trim().equals("")) {
                queryString += " and T.TProject.TStudentByProjectLeader.TUnit.unitId=(select TT.TUnit.unitId from TTeacher TT where TT.isdeleted='N' and TT.teaCode=:teaCode)";
            }
            Query query = getSessionFactory().getCurrentSession().createQuery(queryString);
            if (null != qici && !qici.trim().equals("")) {
                query.setString("qici", qici);
            } else {
                if (null != year && !year.trim().equals("")) {
                    query.setString("year", year);
                }
            }
            if (null != proNumber && !proNumber.trim().equals("")) {
                query.setString("number", proNumber);
            }
            if (null != proName && !proName.trim().equals("")) {
                query.setString("name", proName);
            }
            if (null != profession && !profession.trim().equals("")) {
                query.setString("profession", profession);
            }
            if (null != stuNumber && !stuNumber.trim().equals("")) {
                query.setString("stuNumber", stuNumber);
            }
            if (null != state && !state.trim().equals("")) {
                query.setString("state", state);
            }
            if (null != teaCode && !teaCode.trim().equals("")) {
                query.setString("teaCode", teaCode);
            }
            query.setFirstResult(pageBean.getBeginIndex());
            query.setMaxResults(pageBean.getPageCapibility());
            return query.list();
        } catch (RuntimeException e) {
            log.error("find endproject by mutiple property failed"+e);
            throw e;
        }
    }

    public int findEndProByMutiplePropertyCount(String teaCode, String year,
                                                String qici, String proNumber, String proName, String profession,
                                                String stuNumber, String state) {
        log.debug("find endproject count by mutiple property");
        try {
            String queryString = "select count(*) From TEndProject T where T.isdeleted='N'";
            if (null != qici && !qici.trim().equals("")) {
                queryString += " and T.TJieqi.jqId=:qici";
            } else {
                if (null != year && !year.trim().equals("")) {
                    queryString += " and T.TJieqi.jqYear=:year";
                }
            }
            if (null != proNumber && !proNumber.trim().equals("")) {
                queryString += " and T.TProject.projectNumber=:number";
            }
            if (null != proName && !proName.trim().equals("")) {
                queryString += " and T.TProject.projectName=:name";
            }
            if (null != profession && !profession.trim().equals("")) {
                queryString += " and T.TProject.TStudentByProjectLeader.TProfession.professionName=:profession";
            }
            if (null != stuNumber && !stuNumber.trim().equals("")) {
                queryString += " and T.TProject.TStudentByProjectLeader.studentNumber=:stuNumber";
            }
            if (null != state && !state.trim().equals("")) {
                queryString += " and T.endprojectState=:state";
            }
            if (null != teaCode && !teaCode.trim().equals("")) {
                queryString += " and T.TProject.TStudentByProjectLeader.TUnit.unitId=(select TT.TUnit.unitId from TTeacher TT where TT.isdeleted='N' and TT.teaCode=:teaCode)";
            }
            Query query = getSessionFactory().getCurrentSession().createQuery(queryString);
            if (null != qici && !qici.trim().equals("")) {
                query.setString("qici", qici);
            } else {
                if (null != year && !year.trim().equals("")) {
                    query.setString("year", year);
                }
            }
            if (null != proNumber && !proNumber.trim().equals("")) {
                query.setString("number", proNumber);
            }
            if (null != proName && !proName.trim().equals("")) {
                query.setString("name", proName);
            }
            if (null != profession && !profession.trim().equals("")) {
                query.setString("profession", profession);
            }
            if (null != stuNumber && !stuNumber.trim().equals("")) {
                query.setString("stuNumber", stuNumber);
            }
            if (null != state && !state.trim().equals("")) {
                query.setString("state", state);
            }
            if (null != teaCode && !teaCode.trim().equals("")) {
                query.setString("teaCode", teaCode);
            }
            List list = query.list();
            int count = 0;
            if(list.size()>0){
                count = new Integer(""+list.get(0));
            }
            return count;
        } catch (RuntimeException e) {
            log.error("find endproject count by mutiple property failed"+e);
            System.out.println(e);
            throw e;
        }
    }

    /**
     *
     * 根据学院主管教师教职工号获取学院的结题列表 authoy lzh
     *
     * @param unitTeaCode
     * @param checkState
     * @param pageBean
     * @return
     */
    public List getUnitEndProByTeaCode(String unitTeaCode, String checkState,
                                       PageBean pageBean) {
        log.debug("finding unit all TEndproject instances by pageBean");
        try {
            String queryStr = "From TEndProject T Where T.isdeleted='N' and T.endProjectPassApply='01' and T.endProjectState =:checkState and T.TProject.TUnit.unitId = (select TE.TUnit.unitId From TTeacher TE where TE.teaCode =:code) order by T.TProject.projectBegintime desc";
            Query query = getSessionFactory().getCurrentSession().createQuery(queryStr);
            query.setString("code", unitTeaCode);
            query.setString("checkState", checkState);
            query.setFirstResult(pageBean.getBeginIndex());
            query.setMaxResults(pageBean.getPageCapibility());
            return query.list();
        } catch (RuntimeException e) {
            log.error("find unit all TEndproject failed", e);
            throw e;
        }
    }

    public int getUnitEndProCount(String unitTeaCode, String checkState) {
        log.debug("get unit TEndproject count");
        try {
            String queryStr = "select count(*) From TEndProject T Where T.isdeleted='N' and T.endProjectPassApply='01' and T.endProjectState =:checkState and T.TProject.TUnit.unitId = (select TE.TUnit.unitId From TTeacher TE where TE.teaCode =:code)";
            Query query = getSessionFactory().getCurrentSession().createQuery(queryStr);
            query.setString("code", unitTeaCode);
            query.setString("checkState", checkState);
            List tmpList = query.list();
            int count = 0;
            if (tmpList.size() > 0) {
                count = new Integer("" + tmpList.get(0));
            }
            return count;

        } catch (RuntimeException e) {
            log.error("get unit TEndproject count failed", e);
            System.out.println(e);
            throw e;
        }
    }

    /**
     *
     * 根据组长学号获取结题 authoy lzh
     *
     * @param studentNum
     * @return
     */
    public List findMyEndProjects(String studentNum) {
        log.debug("find endprojects by leadercodes");
        try {

            String sql = "From TEndProject T where (T.TProject.TStudentByProjectLeader.studentId=(select S.studentId from TStudent S where S.studentNumber=:number and S.isdeleted='N') or T.TProject.TStudentByProjectUser1.studentId=(select S.studentId from TStudent S where S.studentNumber=:number and S.isdeleted='N') or T.TProject.TStudentByProjectUser2.studentId=(select S.studentId from TStudent S where S.studentNumber=:number and S.isdeleted='N')) and T.isdeleted='N'";
            Query query = getSessionFactory().getCurrentSession().createQuery(sql);
            query.setString("number", studentNum);
            return query.list();
        } catch (RuntimeException e) {
            log.error("find endprojects by leadercodes failed" + e);
            throw e;
        }

    }



    public List findByEndprojectState(Object endprojectState) {
        return findByProperty(ENDPROJECT_STATE, endprojectState);
    }

    public List findByEndprojectSummary(Object endprojectSummary) {
        return findByProperty(ENDPROJECT_SUMMARY, endprojectSummary);
    }

    public List findByEndprojectMethod(Object endprojectMethod) {
        return findByProperty(ENDPROJECT_METHOD, endprojectMethod);
    }

    public List findByEndprojectScore(Object endprojectScore) {
        return findByProperty(ENDPROJECT_SCORE, endprojectScore);
    }

    public List findByLastScore(Object lastScore) {
        return findByProperty(LAST_SCORE, lastScore);
    }

    public List findByEndprojectNumber(Object endprojectNumber) {
        return findByProperty(ENDPROJECT_NUMBER, endprojectNumber);
    }

    public List findByLastComment(Object lastComment) {
        return findByProperty(LAST_COMMENT, lastComment);
    }

    public List findByEndprojectComment(Object endprojectComment) {
        return findByProperty(ENDPROJECT_COMMENT, endprojectComment);
    }

    public List findByEndprojectName(Object endprojectName) {
        return findByProperty(ENDPROJECT_NAME, endprojectName);
    }

    public List findByEndprojectSense(Object endprojectSense) {
        return findByProperty(ENDPROJECT_SENSE, endprojectSense);
    }

    public List findByEndprojectContent(Object endprojectContent) {
        return findByProperty(ENDPROJECT_CONTENT, endprojectContent);
    }

    public List findByEndprojectCredit(Object endprojectCredit) {
        return findByProperty(ENDPROJECT_CREDIT, endprojectCredit);
    }

    public List findByEndprojectProblem(Object endprojectProblem) {
        return findByProperty(ENDPROJECT_PROBLEM, endprojectProblem);
    }

    public List findByEndprojectInnovate(Object endprojectInnovate) {
        return findByProperty(ENDPROJECT_INNOVATE, endprojectInnovate);
    }

    public List findByEndprojectIntroduction(Object endprojectIntroduction) {
        return findByProperty(ENDPROJECT_INTRODUCTION, endprojectIntroduction);
    }

    public List findByEndprojectWork(Object endprojectWork) {
        return findByProperty(ENDPROJECT_WORK, endprojectWork);
    }

    public List findByIsdeleted(Object isdeleted) {
        return findByProperty(ISDELETED, isdeleted);
    }

    public List findByEndprojectPassapply(Object endprojectPassapply) {
        return findByProperty(ENDPROJECT_PASSAPPLY, endprojectPassapply);
    }


    public static TEndProjectDAO getFromApplicationContext(
            ApplicationContext ctx) {
        return (TEndProjectDAO) ctx.getBean("TEndProjectDAO");
    }
}
