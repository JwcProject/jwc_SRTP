package edu.cqu.no1.dao.impl;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;
import edu.cqu.no1.dao.*;
import edu.cqu.no1.domain.TDeclaration;
import edu.cqu.no1.util.PageBean;
import org.hibernate.Query;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ZKQ on 2015/5/27.
 */

@Repository
public class TDeclarationDAOImpl extends BaseDaoImpl<TDeclaration> implements edu.cqu.no1.dao.TDeclarationDAO {
    private static final Logger log = LoggerFactory
            .getLogger(TDeclarationDAO.class);
    // property constants
    public static final String PRO_SERIAL = "proSerial";
    public static final String PRO_NAME = "proName";
    public static final String LAB_LEVEL = "labLevel";
    public static final String LAB_NAME = "labName";
    public static final String LEADER_CODE = "leaderCode";
    public static final String MEMBER1_CODE = "member1Code";
    public static final String MEMBER2_CODE = "member2Code";
    public static final String TEACHER1_CODE = "teacher1Code";
    public static final String TEACHER2_CODE = "teacher2Code";
    public static final String COLLEGE = "college";
    public static final String CHECK_STATE = "checkState";
    public static final String PRO_INTRO = "proIntro";
    public static final String RES_CONTENT = "resContent";
    public static final String PRO_ADV = "proAdv";
    public static final String RES_PROGRAM = "resProgram";
    public static final String INNO_POINT = "innoPoint";
    public static final String RES_CONDITION = "resCondition";
    public static final String PRO_PLAN = "proPlan";
    public static final String EXP_RESULT = "expResult";
    public static final String EXP_TARGET = "expTarget";
    public static final String ISDELETED = "isdeleted";
    public static final String PRO_TYPE = "proType";
    public static final String PRO_FUND = "proFund";
    public static final String REVIEW_OPINION = "reviewOpinion";
    public static final String REVIEW_RESULT = "reviewResult";

    /**
     *
     *TODO 判断一个学生是否参与了申报
     *authoy lzh
     *@param stuNumber
     *@return
     */
    public boolean checkHadReqDecla(String stuNumber){
        log.debug("check a student whether had request declaration");
        try {
            String  quesString ="From TDeclaration T where T.isdeleted='N' and (T.leaderCode=(select S.studentId from TStudent S where S.isdeleted='N' and S.studentNumber=:number) OR T.member1Code=(select S.studentId from TStudent S where S.isdeleted='N' and S.studentNumber=:number) OR T.member2Code=(select S.studentId from TStudent S where S.isdeleted='N' and S.studentNumber=:number))";
            Query query = getSessionFactory().getCurrentSession().createQuery(quesString);
            query.setString("number", stuNumber);
            List tmpList = query.list();
            boolean result = false;
            if(tmpList.size()>0){
                result = true;
            }
            return result;
        } catch (RuntimeException e) {
            log.error("check a student whether had request declaration failed"+e);
            throw e;
        }
    }

    /*
     * 通过学院主管教师的code得到该学院的所有申报
     */
    public List getUnitDeclarationByTeaCode(String unitTeaCode, String checkState1, String checkState2, PageBean pageBean) {
        log.debug("finding unit all TDeclaration instances by pageBean");
        try {
            String queryStr = "From TDeclaration D Where D.isdeleted='N' and D.checkState >=:checkState1 and D.checkState <=:checkState2 and D.college = (select T.unitId From TTeacher T where T.teaCode =:code) order by D.declTime desc";
            Query query = getSessionFactory().getCurrentSession().createQuery(queryStr);
            query.setString("code", unitTeaCode);
            //query.setString("jqId", jqId);
            query.setString("checkState1", checkState1);
            query.setString("checkState2", checkState2);
            query.setFirstResult(pageBean.getBeginIndex());
            query.setMaxResults(pageBean.getPageCapibility());
            return query.list();
        } catch (RuntimeException e) {
            log.error("find unit all TDeclaration failed", e);
            throw e;
        }
    }

    public int getUnitDeclarationCount(String unitTeaCode, String checkState1, String checkState2) {
        log.debug("finding all person TDeclaration count");
        try {

            String queryStr = "select count(*) From TDeclaration D Where D.isdeleted='N' and D.checkState >=:checkState1 and D.checkState <=:checkState2 and D.college = (select T.unitId From TTeacher T where T.teaCode =:code)";
            Query query = getSessionFactory().getCurrentSession().createQuery(queryStr);
            query.setString("code", unitTeaCode);
            //query.setString("jqId", jqId);
            query.setString("checkState1", checkState1);
            query.setString("checkState2", checkState2);
            List tmpList = query.list();
            int count = 0;
            if (tmpList.size() > 0) {
                count = new Integer("" + tmpList.get(0));
            }
            return count;

        } catch (RuntimeException e) {
            log.error("find person TDeclaration count failed", e);
            throw e;
        }
    }

    /*
     * 获取教务处的申报列表
     */
    public List getSchoolDeclaration(String checkState1, String checkState2, PageBean pageBean) {
        log.debug("finding school all TDeclaration instances by pageBean");
        try {
            String queryStr = "From TDeclaration D Where D.isdeleted='N' and D.checkState>=:checkState1 and D.checkState<=:checkState2 order by D.declTime desc";
            Query query = getSessionFactory().getCurrentSession().createQuery(queryStr);
            query.setString("checkState1", checkState1);
            query.setString("checkState2", checkState2);
            query.setFirstResult(pageBean.getBeginIndex());
            query.setMaxResults(pageBean.getPageCapibility());
            return query.list();
        } catch (RuntimeException e) {
            log.error("find school all TDeclaration failed", e);
            throw e;
        }
    }

    public int getSchoolDeclarationCount(String checkState1, String checkState2) {
        log.debug("finding all school TDeclaration count");
        try {
            String queryStr = "select count(*) From TDeclaration D Where D.isdeleted='N' and D.checkState>=:checkState1 and D.checkState<=:checkState2";
            Query query = getSessionFactory().getCurrentSession().createQuery(queryStr);
            query.setString("checkState1", checkState1);
            query.setString("checkState2", checkState2);
            List tmpList = query.list();
            int count = 0;
            if (tmpList.size() > 0) {
                count = new Integer("" + tmpList.get(0));
            }
            return count;

        } catch (RuntimeException e) {
            log.error("find person TDeclaration count failed", e);
            throw e;
        }
    }

    /*
     * 通过评审教师的id得到其评审的申报列表 
     */
    public List getReviewTeaDeclaration(String teaCode, PageBean pageBean) {
        log.debug("finding school all TDeclaration instances by pageBean");
        try {
            String queryStr = "from TDeclComment dc where dc.isdeleted = 'N' and dc.exReviewId in" +
                    "(select er.exReviewId from TExpertReview er where er.isdeleted = 'N' and er.exTeaId in" +
                    "(select et.exTeaId from TExpertTeacher et where et.isdeleted = 'N' and et.teaId=(select tt.teaId from TTeacher tt where tt.teaCode=:teaCode)))";
            //String queryStr = "From TDeclaration D Where D.isdeleted='N' and D.checkState>='03' and D.TJieqi.jqId=:jqId and D.declarId in(select E.TDeclaration.declarId from TExpertReview E where E.isdeleted='N' and E.TExpertTeacher.exTeaId in(select et.exTeaId from TExpertTeacher et where et.TTeacher.teaCode=:teaCode))";

            Query query = getSessionFactory().getCurrentSession().createQuery(queryStr);
            //query.setString("jqId", jqId);
            query.setString("teaCode", teaCode);
            query.setFirstResult(pageBean.getBeginIndex());
            query.setMaxResults(pageBean.getPageCapibility());
            return query.list();
        } catch (RuntimeException e) {
            log.error("find school all TDeclaration failed", e);
            throw e;
        }
    }

    
    public int getReviewTeaDeclarationCount(String teaCode) {
        log.debug("finding all school TDeclaration count");
        try {
            //String queryStr = "select count(*) From TDeclaration D Where D.isdeleted='N' and D.checkState>='03' and D.TJieqi.jqId=:jqId and D.declarId in(select E.TDeclaration.declarId from TExpertReview E where E.isdeleted='N' and E.TExpertTeacher.exTeaId in(select et.exTeaId from TExpertTeacher et where et.TTeacher.teaCode=:teaCode))";

            String queryStr = " select count(*) from TDeclComment dc where dc.isdeleted = 'N' and dc.exReviewId in" +
                    "(select er.exReviewId from TExpertReview er where er.isdeleted = 'N' and er.exTeaId in" +
                    "(select et.exTeaId from TExpertTeacher et where et.isdeleted = 'N' and et.teaId=(select tt.teaId from TTeacher tt where tt.teaCode=:teaCode)))";
            Query query = getSessionFactory().getCurrentSession().createQuery(queryStr);
            //query.setString("jqId", jqId);
            query.setString("teaCode", teaCode);
            List tmpList = query.list();
            int count = 0;
            if (tmpList.size() > 0) {
                count = new Integer("" + tmpList.get(0));
            }
            return count;

        } catch (RuntimeException e) {
            log.error("find person TDeclaration count failed", e);
            throw e;
        }
    }
	
	/*
	 * 
	 */

    //多条件查询学院申报
    
    public List findUnitDeclaration(String teaCode, String jqYear, String jqId, String professionName, String leaderCode, String checkState, String proSerial, String proName, PageBean pageBean) {
        log.debug("find unit declaration");
        try {
            String queryString = "From TDeclaration D Where D.isdeleted='N' and D.college = (select T.unitId From TTeacher T where T.teaCode =:code)";
            if (null != jqId && !jqId.trim().equals("")) {
                queryString += " and D.TJieqi.jqId =:jqId";
            }

            else  {
                if(null != jqYear && !jqYear.trim().equals(""))
                {
                    queryString += " and D.TJieqi.jqId in (select J.jqId from TJieqi J where J.jqYear=:jqYear)";
                }
            }

            if (null != leaderCode && !leaderCode.trim().equals("")) {
                queryString += " and D.TStudentByLeaderCode.studentId in (select s.studentId from TStudent s where s.isdeleted='N' and s.studentNumber like :leaderCode)";
            }


            if(null != professionName && !professionName.trim().equals("")) {
                queryString += " and D.TStudentByLeaderCode.studentId in " +
                        "(select S.studentId from TStudent S Where S.TProfession.professionId in" +
                        "(select P.professionId from TProfession P where P.professionName=:professionName))";
            }


            if (null != checkState && !checkState.trim().equals("00") && !checkState.trim().equals("ALL") && !checkState.trim().equals("all")){
                queryString += " and D.checkState =:checkState";
            }
            else if(checkState.trim().equals("00")){
                queryString += " and D.checkState >= '02' and D.checkState <='05'";
            }
            else if(checkState.trim().equals("all")){
                queryString += " and D.checkState >= '02' and D.checkState <='03'";
            }
            else {
                queryString += " and D.checkState >= '02' and D.checkState <='09'";
            }

            if (null != proSerial && !proSerial.trim().equals("")){
                queryString += " and D.proSerial like :proSerial";
            }

            if (null != proName && !proName.trim().equals("")){
                queryString += " and D.proName like :proName";
            }

            queryString += " order by D.declTime desc";

            Query query = getSessionFactory().getCurrentSession().createQuery(queryString);

            query.setString("code", teaCode);

            if (null != jqId && !jqId.trim().equals("")) {
                query.setString("jqId", jqId);
            }
            else {
                if(null != jqYear && !jqYear.trim().equals(""))
                {
                    query.setString("jqYear", jqYear);
                }
            }

            if (null != leaderCode && !leaderCode.toString().trim().equals("")) {
                query.setString("leaderCode", "%" + leaderCode + "%");
            }

            if(null != professionName && !professionName.trim().equals(""))
            {
                query.setString("professionName",professionName);
            }


            if (null != checkState && !checkState.trim().equals("00")&& !checkState.trim().equals("ALL")&& !checkState.trim().equals("all")) {
                query.setString("checkState", checkState);
            }

            if (null != proSerial && !proSerial.trim().equals("")&& !proSerial.trim().equals("ALL")) {
                query.setString("proSerial", "%" + proSerial + "%");
            }

            if (null != proName && !proName.trim().equals("")&& !proName.trim().equals("ALL")) {
                query.setString("proName", "%" + proName + "%");
            }
            //query.setFetchSize(pageBean.getBeginIndex());
            //pageBean.setCurrPage(1);
            query.setFirstResult(pageBean.getBeginIndex());
            query.setMaxResults(pageBean.getPageCapibility());
            System.out.println(query.getQueryString());
            return query.list();
        } catch (RuntimeException e) {
            log.error("find unit declaration " + e);
            throw e;
        }
    }

    
    public int findUnitDeclarationCount(String teaCode, String jqYear, String jqId, String professionName, String leaderCode, String checkState, String proSerial, String proName) {
        log.debug("find unit declaration count ");
        try {
            String queryString = "Select count(*) From TDeclaration D Where D.isdeleted='N' and D.college = (select T.unitId From TTeacher T where T.teaCode =:code)";
            if (null != jqId && !jqId.trim().equals("")) {
                queryString += " and D.TJieqi.jqId =:jqId";
            }

            else  {
                if(null != jqYear && !jqYear.trim().equals(""))
                {
                    queryString += " and D.TJieqi.jqId in (select J.jqId from TJieqi J where J.jqYear=:jqYear)";
                }
            }

            if (null != checkState && !checkState.trim().equals("00") && !checkState.trim().equals("ALL")&& !checkState.trim().equals("all")){
                queryString += " and D.checkState =:checkState";
            }
            else if(checkState.trim().equals("00")){
                queryString += " and D.checkState >= '02' and D.checkState <='05'";
            }
            else if(checkState.trim().equals("all")){
                queryString += " and D.checkState >= '02' and D.checkState <='03'";
            }
            else {
                queryString += " and D.checkState >= '02' and D.checkState <='09'";
            }

            if (null != proSerial && !proSerial.trim().equals("")){
                queryString += " and D.proSerial like :proSerial";
            }

            if (null != proName && !proName.trim().equals("")){
                queryString += " and D.proName like :proName";
            }

            if (null != leaderCode && !leaderCode.trim().equals("")) {
                queryString += " and D.TStudentByLeaderCode.studentId in (select s.studentId from TStudent as s where s.isdeleted='N' and s.studentNumber like :leaderCode)";
            }


            if(null != professionName && !professionName.trim().equals("")) {
                queryString += " and D.TStudentByLeaderCode.studentId in " +
                        "(select S.studentId from TStudent S Where S.TProfession.professionId in" +
                        "(select P.professionId from TProfession P where P.professionName=:professionName))";
            }


            Query query = getSessionFactory().getCurrentSession().createQuery(queryString);
            query.setString("code", teaCode);

            if (null != jqId && !jqId.trim().equals("")) {
                query.setString("jqId", jqId);
            }
            else {
                if(null != jqYear && !jqYear.trim().equals(""))
                {
                    query.setString("jqYear", jqYear);
                }
            }

            if (null != leaderCode && !leaderCode.toString().trim().equals("")) {
                query.setString("leaderCode", "%" + leaderCode + "%");
            }

            if(null != professionName && !professionName.trim().equals(""))
            {
                query.setString("professionName",professionName);
            }


            if (null != checkState && !checkState.trim().equals("00")&& !checkState.trim().equals("ALL") && !checkState.trim().equals("all")) {
                query.setString("checkState", checkState);
            }

            if (null != proSerial && !proSerial.trim().equals("")&& !proSerial.trim().equals("ALL")) {
                query.setString("proSerial", "%" + proSerial + "%");
            }

            if (null != proName && !proName.trim().equals("")&& !proName.trim().equals("ALL")) {
                query.setString("proName", "%" + proName + "%");
            }

            List list = query.list();
            int count = 0;
            if (list.size() > 0) {
                count = new Integer("" + list.get(0));
            }

            return count;
        } catch (RuntimeException e) {
            log.error("find unit declaration count " + e);
            System.out.println("-->"+e);
            throw e;
        }
    }

    /*
     * 多条件查询教务处申报列表
     */
    
    public List findSchoolDeclaration(String proName, String jqYear, String jqId, String checkState, String college, PageBean pageBean) {
        log.debug("find school declaration");
        try {
            String queryString = "From TDeclaration D Where D.isdeleted='N'";
            if (null != proName && !proName.trim().equals("")){
                queryString += " and D.proName like :proName";
            }

            if (null != jqId && !jqId.trim().equals("")) {
                queryString += " and D.TJieqi.jqId =:jqId";
            }

            else  {
                if(null != jqYear && !jqYear.trim().equals(""))
                {
                    queryString += " and D.TJieqi.jqId in (select J.jqId from TJieqi J where J.jqYear=:jqYear)";
                }
            }

            if (null != checkState && !checkState.trim().equals("00") && !checkState.trim().equals("ALL")){
                queryString += " and D.checkState =:checkState";
            }
            else if(checkState.trim().equals("00")) {
                queryString += " and D.checkState >='06' and D.checkState<='09'";
            }
            else {
                queryString += " and D.checkState >='02' and D.checkState<='09'";
            }

            if (null != college && !college.trim().equals("")){
                queryString += " and D.TUnit.unitName like :college";
            }

            queryString +=" order by D.declTime desc";

            Query query = getSessionFactory().getCurrentSession().createQuery(queryString);

            if (null != proName && !proName.trim().equals("")){
                query.setString("proName",  "%" + proName + "%");
            }

            if (null != jqId && !jqId.trim().equals("")) {
                query.setString("jqId", jqId);
            }
            else {
                if(null != jqYear && !jqYear.trim().equals(""))
                {
                    query.setString("jqYear", jqYear);
                }
            }

            if (null != checkState && !checkState.trim().equals("00") && !checkState.trim().equals("ALL")) {
                query.setString("checkState", checkState);
            }

            if (null != college && !college.trim().equals("")&& !college.trim().equals("ALL")) {
                query.setString("college", "%" + college + "%");
            }
            query.setFirstResult(pageBean.getBeginIndex());
            query.setMaxResults(pageBean.getPageCapibility());
            System.out.println(query.getQueryString());
            return query.list();
        } catch (RuntimeException e) {
            log.error("find unit declaration " + e);
            throw e;
        }
    }

    
    public int findSchoolDeclarationCount(String proName, String jqYear, String jqId, String checkState, String college) {
        log.debug("find unit declaration count ");
        try {
            String queryString = "Select count(*) From TDeclaration D Where D.isdeleted='N'";
            if (null != proName && !proName.trim().equals("")){
                queryString += " and D.proName like :proName";
            }

            if (null != jqId && !jqId.trim().equals("")) {
                queryString += " and D.TJieqi.jqId =:jqId";
            }

            else  {
                if(null != jqYear && !jqYear.trim().equals(""))
                {
                    queryString += " and D.TJieqi.jqId in (select J.jqId from TJieqi J where J.jqYear=:jqYear)";
                }
            }

            if (null != checkState && !checkState.trim().equals("00") && !checkState.trim().equals("ALL")){
                queryString += " and D.checkState =:checkState";
            }
            else if(checkState.trim().equals("00")){
                queryString += " and D.checkState<='09' and D.checkState>='06'";
            }
            else {
                queryString += " and D.checkState<='09' and D.checkState>='02'";
            }

            if (null != college && !college.trim().equals("")){
                queryString += " and D.TUnit.unitName like :college";
            }

            Query query = getSessionFactory().getCurrentSession().createQuery(queryString);

            if (null != proName && !proName.trim().equals("")){
                query.setString("proName", "%" + proName + "%");
            }

            if (null != jqId && !jqId.trim().equals("")) {
                query.setString("jqId", jqId);
            }
            else {
                if(null != jqYear && !jqYear.trim().equals(""))
                {
                    query.setString("jqYear", jqYear);
                }
            }

            if (null != checkState && !checkState.trim().equals("00")&& !checkState.trim().equals("ALL")) {
                query.setString("checkState", checkState);
            }

            if (null != college && !college.trim().equals("")&& !college.trim().equals("ALL")) {
                query.setString("college", "%" + college + "%");
            }

            List list = query.list();
            int count = 0;
            if (list.size() > 0) {
                count = new Integer("" + list.get(0));
            }

            return count;
        } catch (RuntimeException e) {
            log.error("find unit declaration count " + e);
            System.out.println("-->"+e);
            throw e;
        }
    }

    /*
     * 多条件查询评审专家个人相关申报
     */
    
    public List findReviewTeaDeclaration(String teaCode, String jqYear, String jqId, String professionName, String leaderCode, String compEval, PageBean pageBean) {
        log.debug("find review teacher declaration");
        try {



            String queryString = " select count(*) from TDeclComment dc where dc.isdeleted = 'N' and dc.exReviewId in" +
                    "(select er.exReviewId from TExpertReview er where er.isdeleted = 'N' and er.exTeaId in" +
                    "(select et.exTeaId from TExpertTeacher et where et.isdeleted = 'N' and et.teaId=" +
                    "(select tt.teaId from TTeacher tt where tt.teaCode=:teaCode)))";
            if (null != jqId && !jqId.trim().equals("")) {
                queryString += " and D.TJieqi.jqId =:jqId";
            }

            else  {
                if(null != jqYear && !jqYear.trim().equals(""))
                {
                    queryString += " and dc.TExpertReview.TDeclaration.TJieqi.jqId in (select J.jqId from TJieqi J where J.jqYear=:jqYear)";
                }
            }

            if (null != leaderCode && !leaderCode.trim().equals("")) {
                queryString += " and dc.TExpertReview.TDeclaration.TStudentByLeaderCode.studentId in (select s.studentId from TStudent s where s.isdeleted='N' and s.studentNumber like :leaderCode)";
            }


            if(null != professionName && !professionName.trim().equals("")) {
                queryString += " and dc.TExpertReview.TDeclaration.TStudentByLeaderCode.studentId in " +
                        "(select S.studentId from TStudent S Where S.TProfession.professionId in" +
                        "(select P.professionId from TProfession P where P.professionName=:professionName))";
            }



            if (null != compEval && !compEval.trim().equals("")){
                queryString += " and dc.compEval=:compEval";
            }

            Query query = getSessionFactory().getCurrentSession().createQuery(queryString);

            query.setString("teaCode", teaCode);

            if (null != jqId && !jqId.trim().equals("")) {
                query.setString("jqId", jqId);
            }
            else {
                if(null != jqYear && !jqYear.trim().equals(""))
                {
                    query.setString("jqYear", jqYear);
                }
            }

            if (null != leaderCode && !leaderCode.toString().trim().equals("")) {
                query.setString("leaderCode", "%" + leaderCode + "%");
            }

            if(null != professionName && !professionName.trim().equals(""))
            {
                query.setString("professionName",professionName);
            }



            if (null != compEval && !compEval.trim().equals("")&& !compEval.trim().equals("ALL")) {
                query.setString("compEval", compEval);
            }
            query.setFirstResult(pageBean.getBeginIndex());
            query.setMaxResults(pageBean.getPageCapibility());
            System.out.println(query.getQueryString());
            return query.list();
        } catch (RuntimeException e) {
            log.error("find review teacher declaration " + e);
            throw e;
        }
    }

    
    public int findReviewTeaDeclarationCount(String teaCode, String jqYear, String jqId, String professionName, String leaderCode, String compEval) {
        log.debug("find review teacher declaration count ");
        try {
			/*
			 * String queryStr = " select count(*) from TDeclComment dc where dc.isdeleted = 'N' and dc.TExpertReview.exReviewId in" +
					"(select er.exReviewId from TExpertReview er where er.isdeleted = 'N' and er.TExpertTeacher.exTeaId in" + 
			        "(select et.exTeaId from TExpertTeacher et where et.isdeleted = 'N' and et.TTeacher.teaId=(select tt.teaId from TTeacher tt where tt.teaCode=:teaCode)))";
			 * */

            String queryString = " select count(*) from TDeclComment dc where dc.isdeleted = 'N' and dc.exReviewId in" +
                    "(select er.exReviewId from TExpertReview er where er.isdeleted = 'N' and er.exTeaId in" +
                    "(select et.exTeaId from TExpertTeacher et where et.isdeleted = 'N' and et.teaId=" +
                    "(select tt.teaId from TTeacher tt where tt.teaCode=:teaCode)))";

            if (null != jqId && !jqId.trim().equals("")) {
                queryString += " and dc.TExpertReview.TDeclaration.TJieqi.jqId =:jqId";
            }

            else  {
                if(null != jqYear && !jqYear.trim().equals(""))
                {
                    queryString += " and dc.TExpertReview.TDeclaration.TJieqi.jqId in (select J.jqId from TJieqi J where J.jqYear=:jqYear)";
                }
            }

            if (null != leaderCode && !leaderCode.trim().equals("")) {
                queryString += " and dc.TExpertReview.TDeclaration.TStudentByLeaderCode.studentId in (select s.studentId from TStudent s where s.isdeleted='N' and s.studentNumber like :leaderCode)";
            }


            if(null != professionName && !professionName.trim().equals("")) {
                queryString += " and dc.TExpertReview.TDeclaration.TStudentByLeaderCode.studentId in " +
                        "(select S.studentId from TStudent S Where S.TProfession.professionId in" +
                        "(select P.professionId from TProfession P where P.professionName=:professionName))";
            }




            if (null != compEval && !compEval.trim().equals("")){
                queryString += " and dc.compEval=:compEval";
            }

            Query query = getSessionFactory().getCurrentSession().createQuery(queryString);

            query.setString("teaCode", teaCode);

            if (null != jqId && !jqId.trim().equals("")) {
                query.setString("jqId", jqId);
            }
            else {
                if(null != jqYear && !jqYear.trim().equals(""))
                {
                    query.setString("jqYear", jqYear);
                }
            }

            if (null != leaderCode && !leaderCode.toString().trim().equals("")) {
                query.setString("leaderCode", "%" + leaderCode + "%");
            }

            if(null != professionName && !professionName.trim().equals(""))
            {
                query.setString("professionName",professionName);
            }




            if (null != compEval && !compEval.trim().equals("")&& !compEval.trim().equals("ALL")) {
                query.setString("compEval", compEval);
            }

            List list = query.list();
            int count = 0;
            if (list.size() > 0) {
                count = new Integer("" + list.get(0));
            }

            return count;
        } catch (RuntimeException e) {
            log.error("find review teacher declaration count " + e);
            System.out.println("-->"+e);
            throw e;
        }
    }

    /**
     *
     *TODO 根据申报状态查询学院申报
     *authoy lzh
     *@param teaCode 学院主管老师的教职工号
     *@param state  申报状态
     *@return
     */
    
    public List findUnitDecByState(String teaCode, String state, PageBean pageBean){
        try {
            log.error("find unit declaration by state");
            String sqlquery ="From TDeclaration D Where D.isdeleted='N' and D.checkState=:state and D.college =(select T.unitId from TTeacher T where T.teaCode=:code)";
            Query query = getSessionFactory().getCurrentSession().createQuery(sqlquery);
            query.setString("state", state);
            query.setString("code", teaCode);

            query.setFirstResult(pageBean.getBeginIndex());
            query.setMaxResults(pageBean.getPageCapibility());

            //query.setFirstResult(pageBean.getBeginIndex());
            //query.setMaxResults(pageBean.getPageCapibility());
            return query.list();
        } catch (RuntimeException e) {
            log.error("find unit declaration by state " + e);
            throw e;
        }
    }

    
    public int findUnitDecByStateCount(String teaCode, String state){
        try {
            log.error("find unit declaration count by state");
            String sqlquery ="select count(*) From TDeclaration D Where D.isdeleted='N' and D.checkState=:state and D.college =(select T.unitId from TTeacher T where T.teaCode=:code)";
            Query query = getSessionFactory().getCurrentSession().createQuery(sqlquery);
            query.setString("state", state);
            query.setString("code", teaCode);
            List list = query.list();
            int count = 0;
            if(list.size()>0){
                count = new Integer(""+list.get(0));
            }
            return count;
        } catch (RuntimeException e) {
            log.error("find unit declaration count by state " + e);
            throw e;
        }
    }

    //获取普通教师的个人申报列表
    
    public List getTeaDeclaration(String teaCode, PageBean pageBean)
    {
        log.error("find teacher personal declaration ");
        try {
            String queryString = "From TDeclaration T Where T.isdeleted='N' and (T.teacher1Code=(select S.teaId from TTeacher S where S.isdeleted='N' and S.teaCode=:number) OR T.teacher2Code=(select S.teaId from TTeacher S where S.isdeleted='N' and S.teaCode = :number))";
            Query query = getSessionFactory().getCurrentSession().createQuery(queryString);
            query.setString("number", teaCode);

            query.setFirstResult(pageBean.getBeginIndex());
            query.setMaxResults(pageBean.getPageCapibility());

            List list = null;
            if(null!=query.list())
            {
                list = query.list();
            }
            return list;

        } catch (RuntimeException e) {
            log.error("find unit declaration count by state" + e);
            throw e;
            // TODO: handle exception
        }
    }

    
    public int getTeaDeclarationCount(String teaCode){
        log.debug("find student project ");
        try {
            String queryString = "select count(*) From TDeclaration T Where T.isdeleted='N' and (T.teacher1Code=(select S.teaId from TTeacher S where S.isdeleted='N' and S.teaCode=:number) OR T.teacher2Code=(select S.teaId from TTeacher S where S.isdeleted='N' and S.teaCode = :number))";
            Query query = getSessionFactory().getCurrentSession().createQuery(queryString);
            query.setString("number", teaCode);

            int count = 0;
            List list = query.list();
            if(list.size()>0)
            {
                count = new Integer(""+list.get(0));
            }
            return count;

        } catch (RuntimeException e) {
            // TODO: handle exception
            log.error("find student project " + e);
            throw e;
        }
    }

    //多条件查询教师个人申报
    
    public List findTeaDeclaration(String teaCode, String projectName, String stuCode, PageBean pageBean){
        log.debug("find teacher project ");
        try{
            String queryString = "From TDeclaration T Where T.isdeleted='N' and (T.teacher1Code=(select S.teaId from TTeacher S where S.isdeleted='N' and S.teaCode=:number) OR T.teacher2Code=(select S.teaId from TTeacher S where S.isdeleted='N' and S.teaCode = :number))";

            if (null != projectName && !projectName.trim().equals("")){
                queryString += " and D.projectName like :projectName";
            }

            if (null != stuCode && !stuCode.trim().equals("")) {
                queryString += " and D.TStudentByProjectLeader.studentId in (select s.studentId from TStudent as s where s.isdeleted='N' and s.studentNumber like :stuCode)";
            }

            Query query = getSessionFactory().getCurrentSession().createQuery(queryString);
            query.setString("number", teaCode);

            if (null != stuCode && !stuCode.toString().trim().equals("")) {
                query.setString("stuCode", "%" + stuCode + "%");
            }

            if (null != projectName && !projectName.trim().equals("")) {
                query.setString("projectName", "%" + projectName + "%");
            }

            query.setFirstResult(pageBean.getBeginIndex());
            query.setMaxResults(pageBean.getPageCapibility());
            return query.list();
        } catch (RuntimeException e) {
            log.error("find unit project " + e);
            throw e;
        }
    }

    
    public int findTeaDeclarationCount(String teaCode, String projectName, String stuCode)
    {
        log.debug("find teacher project count");
        try{
            String queryString = "select count(*) From TDeclaration T Where T.isdeleted='N' and (T.teacher1Code=(select S.teaId from TTeacher S where S.isdeleted='N' and S.teaCode=:number) OR T.teacher2Code=(select S.teaId from TTeacher S where S.isdeleted='N' and S.teaCode=:number))";

            if (null != projectName && !projectName.trim().equals("")){
                queryString += " and D.projectName like :projectName";
            }

            if (null != stuCode && !stuCode.trim().equals("")) {
                queryString += " and D.TStudentByProjectLeader.studentId in (select s.studentId from TStudent as s where s.isdeleted='N' and s.studentNumber like :stuCode)";
            }

            Query query = getSessionFactory().getCurrentSession().createQuery(queryString);
            query.setString("number", teaCode);

            if (null != stuCode && !stuCode.toString().trim().equals("")) {
                query.setString("stuCode", "%" + stuCode + "%");
            }

            if (null != projectName && !projectName.trim().equals("")) {
                query.setString("projectName", "%" + projectName + "%");
            }

            int count = 0;
            List list = query.list();
            if(list.size()>0)
            {
                count = new Integer(""+list.get(0));
            }
            return count;

        } catch (RuntimeException e) {
            log.error("find teacher project count" + e);
            throw e;
        }
    }

    
    public List findByProSerial(Object proSerial) {
        return findByProperty(PRO_SERIAL, proSerial);
    }

    
    public List findByProName(Object proName) {
        return findByProperty(PRO_NAME, proName);
    }

    
    public List findByLabLevel(Object labLevel) {
        return findByProperty(LAB_LEVEL, labLevel);
    }

    
    public List findByLabName(Object labName) {
        return findByProperty(LAB_NAME, labName);
    }

    
    public List findByLeaderCode(Object leaderCode) {
        return findByProperty(LEADER_CODE, leaderCode);
    }

    
    public List findByMember1Code(Object member1Code) {
        return findByProperty(MEMBER1_CODE, member1Code);
    }

    
    public List findByMember2Code(Object member2Code) {
        return findByProperty(MEMBER2_CODE, member2Code);
    }

    
    public List findByTeacher1Code(Object teacher1Code) {
        return findByProperty(TEACHER1_CODE, teacher1Code);
    }

    
    public List findByTeacher2Code(Object teacher2Code) {
        return findByProperty(TEACHER2_CODE, teacher2Code);
    }

    
    public List findByCollege(Object college) {
        return findByProperty(COLLEGE, college);
    }

    
    public List findByCheckState(Object checkState) {
        return findByProperty(CHECK_STATE, checkState);
    }

    
    public List findByProIntro(Object proIntro) {
        return findByProperty(PRO_INTRO, proIntro);
    }

    
    public List findByResContent(Object resContent) {
        return findByProperty(RES_CONTENT, resContent);
    }

    
    public List findByProAdv(Object proAdv) {
        return findByProperty(PRO_ADV, proAdv);
    }

    
    public List findByResProgram(Object resProgram) {
        return findByProperty(RES_PROGRAM, resProgram);
    }

    
    public List findByInnoPoint(Object innoPoint) {
        return findByProperty(INNO_POINT, innoPoint);
    }

    
    public List findByResCondition(Object resCondition) {
        return findByProperty(RES_CONDITION, resCondition);
    }

    
    public List findByProPlan(Object proPlan) {
        return findByProperty(PRO_PLAN, proPlan);
    }

    
    public List findByExpResult(Object expResult) {
        return findByProperty(EXP_RESULT, expResult);
    }

    
    public List findByExpTarget(Object expTarget) {
        return findByProperty(EXP_TARGET, expTarget);
    }

    
    public List findByIsdeleted(Object isdeleted) {
        return findByProperty(ISDELETED, isdeleted);
    }

    
    public List findByProType(Object proType) {
        return findByProperty(PRO_TYPE, proType);
    }

    
    public List findByProFund(Object proFund) {
        return findByProperty(PRO_FUND, proFund);
    }

    public static TDeclarationDAO getFromApplicationContext(
            ApplicationContext ctx) {
        return (TDeclarationDAO) ctx.getBean("TDeclarationDAO");
    }

    
    public List findAll(final PageBean pageBean, String studentId) {
        log.debug("finding all TDeclaration instances");
        try {

            String queryStr =
                    "Select *\n" +
                            "  From T_Declaration d\n" +
                            " Where D.Isdeleted = 'N'\n" +
                            "   And ((D.Member1_Code In\n" +
                            "       (Select S.Student_Id\n" +
                            "            From T_Student s\n" +
                            "           Where S.Student_Number = :code)) Or\n" +
                            "       (D.Leader_Code In\n" +
                            "       (Select S.Student_Id\n" +
                            "            From T_Student s\n" +
                            "           Where S.Student_Number = :code))\n" +
                            "           Or (d.member2_code In (Select S.Student_Id\n" +
                            "            From T_Student s\n" +
                            "           Where S.Student_Number = :code)))";

			
			/*Query query = getSessionFactory().getCurrentSession().createQuery(queryStr);*/
            Query query = getSessionFactory().getCurrentSession().createSQLQuery(queryStr).addEntity(TDeclaration.class);
            query.setString("code", studentId);
            query.setFirstResult(pageBean.getBeginIndex());
            query.setMaxResults(pageBean.getPageCapibility());

            return query.list();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }
    }
    
    public int getAllTDeclarationCount(String studentId)
    {
        log.debug("finding all TDeclaration counts");
        try {

            String hql = "select count(*) from TDeclaration where isdeleted = 'N' and" +
                    " member1Code in (select studentId from TStudent where studentNumber = :code) or" +
                    " leaderCode in (select studentId from TStudent where studentNumber = :code) or" +
                    " member2Code in (select studentId from TStudent where studentNumber = :code)";
            Query query = getSessionFactory().getCurrentSession().createQuery(hql);
            query.setString("code", studentId);
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
    
    public String getDeclarationSerial(String unitId){
        log.debug("getDeclarationSerial");
        try {
            // TODO
            String queryStr = "Select Extract(Year From Sysdate) || '-' || " +
                    "Decode(U.Unit_Code, Null, 'cqu', U.Unit_Code) || '-' || " +
                    "(Count(D.Declar_Id)+1000) As Serial From T_Unit u, T_Declaration d " +
                    "Where D.College = U.Unit_Id Group By U.Unit_Id,u.unit_code Having U.Unit_Id=:unitid";
            Query query = getSessionFactory().getCurrentSession().createSQLQuery(queryStr);
            query.setString("unitid", unitId);
            List tmpList = query.list();
            String serial = "";
            if(tmpList.size()>0)
            {
                serial = ""+tmpList.get(0);
            }
            return serial;
        } catch (RuntimeException re) {
            log.error("getDeclarationSerial", re);
            throw re;
        }
    }
}
