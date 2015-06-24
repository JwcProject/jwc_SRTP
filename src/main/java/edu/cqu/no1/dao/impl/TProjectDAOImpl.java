package edu.cqu.no1.dao.impl;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;
import edu.cqu.no1.dao.TProjectDAO;
import edu.cqu.no1.domain.TProject;
import edu.cqu.no1.util.PageBean;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ZKQ on 2015/5/27.
 */

@Repository
public class TProjectDAOImpl extends BaseDaoImpl<TProject> implements TProjectDAO {
    private static final Logger log = LoggerFactory
            .getLogger(TProjectDAO.class);
    // property constants
    public static final String PROJECT_LINE = "projectLine";
    public static final String PROJECT_STATE = "projectState";
    public static final String PROJECT_NUMBER = "projectNumber";
    public static final String PROJECT_SENSE = "projectSense";
    public static final String PROJECT_CONTENT = "projectContent";
    public static final String PROJECT_LABTYPE = "projectLabtype";
    public static final String PROJECT_LABNAME = "projectLabname";
    public static final String PROJECT_NAME = "projectName";
    public static final String PROJECT_INTRODUCTION = "projectIntroduction";
    public static final String PROJECT_FUND = "projectFund";
    public static final String PROJECT_INNOVATE = "projectInnovate";
    public static final String PROJECT_CONDITION = "projectCondition";
    public static final String PROJECT_PROGRESS = "projectProgress";
    public static final String PROJECT_GOAL = "projectGoal";
    public static final String PROJECT_ACHIEVEMENT = "projectAchievement";
    public static final String PROJECT_WORK = "projectWork";
    public static final String REDMINE_PROJECTID = "redmineProjectid";
    public static final String PROJECT_SCORE = "projectScore";
    public static final String ISDELETED = "isdeleted";

    public void createProject(String jqId) {
        log.debug("add TProject");
        try {
            // TODO: Convert `queryString` to HQL.
            // TODO: The following code using a SQL native variable.
            String queryString = "Insert Into T_Project\n"
                    + "  (\n"
                    + "\n"
                    + "   Declar_Id,\n"
                    + "   Unit_Id,\n"
                    + "   Jq_Id,\n"
                    + "   Project_Line,\n"
                    + "   Project_Number,\n"
                    + "   Project_Sense,\n"
                    + "   Project_Content,\n"
                    + "   Project_Labtype,\n"
                    + "   Project_Labname,\n"
                    + "   Project_Name,\n"
                    + "   Project_Introduction,\n"
                    + "   Project_Fund,\n"
                    + "   Project_Begintime,\n"
                    + "   Project_Endtime,\n"
                    + "   Project_Leader,\n"
                    + "   Project_Innovate,\n"
                    + "   Project_Condition,\n"
                    + "   Project_Progress,\n"
                    + "   Project_Goal,\n"
                    + "   Project_Achievement,\n"
                    + "   Redmine_Projectid,\n"
                    + "   Project_User1,\n"
                    + "   Project_User2,\n"
                    + "   Project_Teacher1,\n"
                    + "   Project_Teacher2)\n"
                    + "\n"
                    + "  Select D.Declar_Id,\n"
                    + "         D.College,\n"
                    + "         D.Jq_Id,\n"
                    + "         D.Res_Program,\n"
                    + "         (Select Extract(Year From Sysdate) || '-' ||\n"
                    + "                 Decode(U.Unit_Code, Null, 'cqu', U.Unit_Code) As Serial\n"
                    + "            From T_Unit u\n"
                    + "           Where U.Unit_Id = D.College) || '-' || Projectid.Nextval,\n"
                    + "         D.Pro_Adv,\n" + "         D.Res_Content,\n"
                    + "         D.Lab_Level,\n" + "         D.Lab_Name,\n"
                    + "         D.Pro_Name,\n" + "         D.Pro_Intro,\n"
                    + "         D.Pro_Fund,\n" + "         D.Start_On,\n"
                    + "         D.End_On,\n" + "         D.Leader_Code,\n"
                    + "         D.Inno_Point,\n"
                    + "         D.Res_Condition,\n" + "         D.Pro_Plan,\n"
                    + "         D.Exp_Target,\n" + "         D.Exp_Result,\n"
                    + "         Redmineid.Nextval,\n"
                    + "         D.Member1_Code,\n"
                    + "         D.Member2_Code,\n"
                    + "         D.Teacher1_Code,\n"
                    + "         D.Teacher2_Code\n"
                    + "    From T_Declaration d\n"
                    + "   Where D.Jq_Id =:jqId\n"
                    + "     And D.Check_State = '08'";
            // String hql = "from TDeclaration d join d.TUnit tu where d.TJieqi.jqId = :jqId and d.checkState = '08'";
            String hql1 = "select count(*) from TProject p join p.TDeclaration d" +
                    " where d.TJieqi.jqId = :jqId and d.checkState = '09'";
            Session session =  this.getSessionFactory().getCurrentSession();

            Transaction transaction = session.getTransaction();
            try {

                transaction.begin();

                Query query1 = session.createQuery(hql1);
                query1.setString("jqId", jqId);
                List list = query1.list();
                int count = 0;
                if (list.size() > 0) {
                    count = new Integer("" + list.get(0));
                }
                if(count==0) {
                    // TODO: Here we notice a SQL native function `Projectid_Reset()`
                    SQLQuery query = session.createSQLQuery("{Call Projectid_Reset()}");
                    query.executeUpdate();
                }

                Query query = session.createQuery(queryString);
                query.setString("jqId", jqId);
                query.executeUpdate();

                queryString = "update TDeclaration set checkState = '09' where TJieqi.jqId = :jqId and TProjects.size > 0";
                Query sqlQuery2 = session.createQuery(queryString);
                sqlQuery2.setString("jqId", jqId);
                sqlQuery2.executeUpdate();

                //修改申报成员的用户类型
                String hql_update1 = "update TUser u set u.userType = '08' where u.userId in (select userId from TStudent" +
                        " where studentId in (select TStudentByLeaderCode.studentNumber from TDeclaration where" +
                        " TJieqi.jqId = :jqId and checkState = '09'))";

                String hql_update2 = "update TUser u set u.userType = '07' where u.userId in (select userId from TStudent" +
                        " where studentId in (select TStudentByMember1Code.studentNumber from TDeclaration where" +
                        " TJieqi.jqId = :jqId and checkState = '09') or studentId in (select TStudentByMember2Code from" +
                        " TDeclaration where TJieqi.jqId = :jqId and checkState = '09'))";

                Query sQuery1 = session.createQuery(hql_update1);
                Query sQuery2 = session.createQuery(hql_update2);
                sQuery1.setString("jqId", jqId);
                sQuery2.setString("jqId", jqId);
                sQuery1.executeUpdate();
                sQuery2.executeUpdate();

                transaction.commit();

            } catch (Exception e1) {
                e1.printStackTrace();
                transaction.rollback();
            }
        } catch (RuntimeException e2) {
            log.debug("add TProject failed");
            throw e2;
        }
    }

    //根据当前教师工号得到所在学院项目列表

    public List getProjectByTeaCode(String unitTeaCode, PageBean pageBean) {
        log.debug("finding unit all TProject instances by pageBean");
        try {
            String queryStr = "From TProject p Where p.isdeleted='N' and p.TUnit.unitId = (select T.TUnit.unitId From TTeacher T where T.teaCode =:code)";
            Query query = getSessionFactory().getCurrentSession().createQuery(queryStr);
            query.setString("code", unitTeaCode);

            query.setFirstResult(pageBean.getBeginIndex());
            query.setMaxResults(pageBean.getPageCapibility());
            return query.list();
        } catch (RuntimeException e) {
            log.error("find unit all TDeclaration failed", e);
            throw e;
        }
    }

    public int getProjectCount(String unitTeaCode) {
        log.debug("finding all person TDeclaration count");
        try {

            String queryStr = "select count(*) From TProject p Where p.isdeleted='N' and p.TUnit.unitId = (select T.TUnit.unitId From TTeacher T where T.teaCode =:code)";
            Query query =  getSessionFactory().getCurrentSession().createQuery(queryStr);
            query.setString("code", unitTeaCode);

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

    //多条件查询学院项目
    public int findProjectByTeaCodeCount(String teacherCode, String jqYear, String jqId, String professionName, String studentNums, String projectNumber, String projectName)
    {
        log.debug("find unit project count ");
        try {
            String queryString = "Select count(*) From TProject D Where D.isdeleted='N' and D.TUnit.unitId = (select T.TUnit.unitId From TTeacher T where T.teaCode =:code)";
            if (null != jqId && !jqId.trim().equals("")) {
                queryString += " and D.TJieqi.jqId =:jqId";
            }

            else  {
                if(null != jqYear && !jqYear.trim().equals(""))
                {
                    queryString += " and D.TJieqi.jqId in (select J.jqId from TJieqi J where J.jqYear=:jqYear)";
                }
            }

            if (null != projectNumber && !projectNumber.trim().equals("")){
                queryString += " and D.projectNumber like :projectNumber";
            }

            if (null != projectName && !projectName.trim().equals("")){
                queryString += " and D.projectName like :projectName";
            }

            if (null != studentNums && !studentNums.trim().equals("")) {
                queryString += " and D.TStudentByProjectLeader.studentId in (select s.studentId from TStudent as s where s.isdeleted='N' and s.studentNumber like :studentNums)";
            }


            if(null != professionName && !professionName.trim().equals("")) {
                queryString += " and D.TStudentByProjectLeader.studentId in " +
                        "(select S.studentId from TStudent S Where S.TProfession.professionId in" +
                        "(select P.professionId from TProfession P where P.professionName=:professionName))";
            }

            Query query =  getSessionFactory().getCurrentSession().createQuery(queryString);
            query.setString("code", teacherCode);

            if (null != jqId && !jqId.trim().equals("")) {
                query.setString("jqId", jqId);
            }
            else {
                if(null != jqYear && !jqYear.trim().equals(""))
                {
                    query.setString("jqYear", jqYear);
                }
            }

            if (null != studentNums && !studentNums.toString().trim().equals("")) {
                query.setString("studentNums", "%" + studentNums + "%");
            }

            if(null != professionName && !professionName.trim().equals(""))
            {
                query.setString("professionName",professionName);
            }


            if (null != projectNumber && !projectNumber.trim().equals("")) {
                query.setString("projectNumber", "%" + projectNumber + "%");
            }

            if (null != projectName && !projectName.trim().equals("")) {
                query.setString("projectName", "%" + projectName + "%");
            }

            List list = query.list();
            int count = 0;
            if (list.size() > 0) {
                count = new Integer("" + list.get(0));
            }

            return count;
        } catch (RuntimeException e) {
            log.error("find unit project count " + e);
            throw e;
        }
    }


    public List findProjectByTeaCode(String teacherCode, String jqYear, String jqId, String professionName, String studentNums, String projectNumber, String projectName, PageBean pageBean)
    {
        log.debug("find unit project ");
        try {
            String queryString = "From TProject D Where D.isdeleted='N' and D.TUnit.unitId = (select T.TUnit.unitId From TTeacher T where T.teaCode =:code)";
            if (null != jqId && !jqId.trim().equals("")) {
                queryString += " and D.TJieqi.jqId =:jqId";
            }

            else  {
                if(null != jqYear && !jqYear.trim().equals(""))
                {
                    queryString += " and D.TJieqi.jqId in (select J.jqId from TJieqi J where J.jqYear=:jqYear)";
                }
            }

            if (null != projectNumber && !projectNumber.trim().equals("")){
                queryString += " and D.projectNumber like :projectNumber";
            }

            if (null != projectName && !projectName.trim().equals("")){
                queryString += " and D.projectName like :projectName";
            }

            if (null != studentNums && !studentNums.trim().equals("")) {
                queryString += " and D.TStudentByProjectLeader.studentId in (select s.studentId from TStudent as s where s.isdeleted='N' and s.studentNumber like :studentNums)";
            }


            if(null != professionName && !professionName.trim().equals("")) {
                queryString += " and D.TStudentByProjectLeader.studentId in " +
                        "(select S.studentId from TStudent S Where S.TProfession.professionId in" +
                        "(select P.professionId from TProfession P where P.professionName=:professionName))";
            }

            Query query =  getSessionFactory().getCurrentSession().createQuery(queryString);
            query.setString("code", teacherCode);

            if (null != jqId && !jqId.trim().equals("")) {
                query.setString("jqId", jqId);
            }
            else {
                if(null != jqYear && !jqYear.trim().equals(""))
                {
                    query.setString("jqYear", jqYear);
                }
            }

            if (null != studentNums && !studentNums.toString().trim().equals("")) {
                query.setString("studentNums", "%" + studentNums + "%");
            }

            if(null != professionName && !professionName.trim().equals(""))
            {
                query.setString("professionName",professionName);
            }


            if (null != projectNumber && !projectNumber.trim().equals("")) {
                query.setString("projectNumber", "%" + projectNumber + "%");
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

    //获取学校所有项目

    public List listSchoolProject(PageBean pageBean){
        log.debug("finding school all TProject instances by pageBean");
        try {
            String queryStr = "From TProject p Where p.isdeleted='N'";
            Query query =  getSessionFactory().getCurrentSession().createQuery(queryStr);

            query.setFirstResult(pageBean.getBeginIndex());
            query.setMaxResults(pageBean.getPageCapibility());
            return query.list();
        } catch (RuntimeException e) {
            log.error("find school all TDeclaration failed", e);
            throw e;
        }
    }


    public int listSchoolProjectCount(){
        log.debug("finding school all TProject count instances by pageBean");
        try {
            String queryStr = "select count(*) From TProject p Where p.isdeleted='N'";
            Query query =  getSessionFactory().getCurrentSession().createQuery(queryStr);

            List list = query.list();
            int count = 0;
            if (list.size() > 0) {
                count = new Integer("" + list.get(0));
            }
            return count;

        } catch (RuntimeException e) {
            log.error("finding school all TProject count failed", e);
            throw e;
        }
    }


    //多条件查询学校项目

    public List findSchoolProject(String jqYear, String jqId, String unitName, String studentNums, String projectName, PageBean pageBean)
    {
        log.debug("find unit project ");
        try {
            String queryString = "From TProject D Where D.isdeleted='N'";
            if (null != jqId && !jqId.trim().equals("")) {
                queryString += " and D.TJieqi.jqId =:jqId";
            }

            else  {
                if(null != jqYear && !jqYear.trim().equals(""))
                {
                    queryString += " and D.TJieqi.jqId in (select J.jqId from TJieqi J where J.jqYear=:jqYear)";
                }
            }

            if (null != projectName && !projectName.trim().equals("")){
                queryString += " and D.projectName like :projectName";
            }

            if (null != unitName && !unitName.trim().equals("")){
                queryString += " and D.TUnit.unitName like :unitName";
            }

            if (null != studentNums && !studentNums.trim().equals("")) {
                queryString += " and D.TStudentByProjectLeader.studentId in (select s.studentId from TStudent as s where s.isdeleted='N' and s.studentNumber like :studentNums)";
            }

            Query query =  getSessionFactory().getCurrentSession().createQuery(queryString);

            if (null != jqId && !jqId.trim().equals("")) {
                query.setString("jqId", jqId);
            }
            else {
                if(null != jqYear && !jqYear.trim().equals(""))
                {
                    query.setString("jqYear", jqYear);
                }
            }

            if (null != studentNums && !studentNums.toString().trim().equals("")) {
                query.setString("studentNums", "%" + studentNums + "%");
            }

            if (null != unitName && !unitName.toString().trim().equals("")) {
                query.setString("unitName", "%" + unitName + "%");
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


    public int findSchoolProjectCount(String jqYear, String jqId, String unitName, String studentNums, String projectName)
    {
        log.debug("find school project count ");
        try {
            String queryString = "Select count(*) From TProject D Where D.isdeleted='N'";
            if (null != jqId && !jqId.trim().equals("")) {
                queryString += " and D.TJieqi.jqId =:jqId";
            }

            else  {
                if(null != jqYear && !jqYear.trim().equals(""))
                {
                    queryString += " and D.TJieqi.jqId in (select J.jqId from TJieqi J where J.jqYear=:jqYear)";
                }
            }

            if (null != projectName && !projectName.trim().equals("")){
                queryString += " and D.projectName like :projectName";
            }

            if (null != unitName && !unitName.trim().equals("")){
                queryString += " and D.TUnit.unitName like :unitName";
            }

            if (null != studentNums && !studentNums.trim().equals("")) {
                queryString += " and D.TStudentByProjectLeader.studentId in (select s.studentId from TStudent as s where s.isdeleted='N' and s.studentNumber like :studentNums)";
            }

            Query query =  getSessionFactory().getCurrentSession().createQuery(queryString);

            if (null != jqId && !jqId.trim().equals("")) {
                query.setString("jqId", jqId);
            }
            else {
                if(null != jqYear && !jqYear.trim().equals(""))
                {
                    query.setString("jqYear", jqYear);
                }
            }

            if (null != studentNums && !studentNums.toString().trim().equals("")) {
                query.setString("studentNums", "%" + studentNums + "%");
            }

            if (null != unitName && !unitName.toString().trim().equals("")) {
                query.setString("unitName", "%" + unitName + "%");
            }

            if (null != projectName && !projectName.trim().equals("")) {
                query.setString("projectName", "%" + projectName + "%");
            }

            List list = query.list();
            int count = 0;
            if (list.size() > 0) {
                count = new Integer("" + list.get(0));
            }

            return count;
        } catch (RuntimeException e) {
            log.error("find school project count " + e);
            throw e;
        }
    }

    //获取学生个人项目列表
    public List getStuProject(String stuCode){
        log.debug("find student project ");
        try {
            String queryString = "From TProject T Where T.isdeleted='N' and (T.TStudentByProjectLeader.studentId=(select S.studentId from TStudent S where S.isdeleted='N' and S.studentNumber=:number) OR T.TStudentByProjectUser2.studentId=(select S.studentId from TStudent S where S.isdeleted='N' and S.studentNumber=:number) OR T.TStudentByProjectUser1.studentId=(select S.studentId from TStudent S where S.isdeleted='N' and S.studentNumber=:number))";
            Query query =  getSessionFactory().getCurrentSession().createQuery(queryString);
            query.setString("number", stuCode);

            List list = null;
            if(null!=query.list())
            {
                list = query.list();
            }
            return list;

        } catch (RuntimeException e) {
            log.error("find student project " + e);
            throw e;
        }
    }

    //获取教师个人项目列表

    public List getTeaProject(String teaCode, PageBean pageBean){
        log.debug("find student project ");
        try {
            String queryString = "From TProject T Where T.isdeleted='N' and (T.TTeacherByProjectTeacher2.teaId=(select S.teaId from TTeacher S where S.isdeleted='N' and S.teaCode=:number) OR T.TTeacherByProjectTeacher1.teaId=(select S.teaId from TTeacher S where S.isdeleted='N' and S.teaCode=:number))";
            Query query =  getSessionFactory().getCurrentSession().createQuery(queryString);
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
            log.error("find student project " + e);
            throw e;
        }
    }


    public int getTeaProjectCount(String teaCode){
        log.debug("find student project ");
        try {
            String queryString = "select count(*) From TProject T Where T.isdeleted='N' and (T.TTeacherByProjectTeacher2.teaId=(select S.teaId from TTeacher S where S.isdeleted='N' and S.teaCode=:number) OR T.TTeacherByProjectTeacher1.teaId=(select S.teaId from TTeacher S where S.isdeleted='N' and S.teaCode=:number))";
            Query query =  getSessionFactory().getCurrentSession().createQuery(queryString);
            query.setString("number", teaCode);

            int count = 0;
            List list = query.list();
            if(list.size()>0)
            {
                count = new Integer(""+list.get(0));
            }
            return count;

        } catch (RuntimeException e) {
            log.error("find student project " + e);
            throw e;
        }
    }

    //多条件查询教师个人项目

    public List findTeaProject(String teaCode, String projectName, String stuCode, PageBean pageBean){
        log.debug("find teacher project ");
        try{
            String queryString = "From TProject D Where D.isdeleted='N' and (D.TTeacherByProjectTeacher2.teaId=(select S.teaId from TTeacher S where S.isdeleted='N' and S.teaCode=:number) OR D.TTeacherByProjectTeacher1.teaId=(select S.teaId from TTeacher S where S.isdeleted='N' and S.teaCode=:number))";

            if (null != projectName && !projectName.trim().equals("")){
                queryString += " and D.projectName like :projectName";
            }

            if (null != stuCode && !stuCode.trim().equals("")) {
                queryString += " and D.TStudentByProjectLeader.studentId in (select s.studentId from TStudent as s where s.isdeleted='N' and s.studentNumber like :stuCode)";
            }

            Query query =  getSessionFactory().getCurrentSession().createQuery(queryString);
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


    public int findTeaProjectCount(String teaCode, String projectName, String stuCode)
    {
        log.debug("find teacher project count");
        try{
            String queryString = "select count(*) From TProject D Where D.isdeleted='N' and (D.TTeacherByProjectTeacher2.teaId=(select S.teaId from TTeacher S where S.isdeleted='N' and S.teaCode=:number) OR D.TTeacherByProjectTeacher1.teaId=(select S.teaId from TTeacher S where S.isdeleted='N' and S.teaCode=:number))";

            if (null != projectName && !projectName.trim().equals("")){
                queryString += " and D.projectName like :projectName";
            }

            if (null != stuCode && !stuCode.trim().equals("")) {
                queryString += " and D.TStudentByProjectLeader.studentId in (select s.studentId from TStudent as s where s.isdeleted='N' and s.studentNumber like :stuCode)";
            }

            Query query =  getSessionFactory().getCurrentSession().createQuery(queryString);
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

    /**
     *
     *根据项目组长的学号获取未申请结题的项目信息项目信息
     *authoy lzh
     *@param leaderCode 项目组长的学号
     *@return
     */

    public TProject findByLeaderCode(String leaderCode){
        try {
            log.debug("find project by leader code");
            String sql ="From TProject T where T.TStudentByProjectLeader.studentNumber=:leaderCode and T.isdeleted='N' and T.projectId not in (select TE.TProject.projectId from TEndProject TE where TE.isdeleted='N' and TE.endProjectState > '01')";
            Query query =  getSessionFactory().getCurrentSession().createQuery(sql);
            query.setString("leaderCode", leaderCode);
            List<TProject> list = query.list();
            TProject project = null;
            if(list.size()>0){
                project = list.get(0);
            }
            return project;
        } catch (RuntimeException e) {
            log.error("find project by leader code failed "+e);
            throw e;
        }
    }


    public List findByProjectLine(Object projectLine) {
        return findByProperty(PROJECT_LINE, projectLine);
    }


    public List findByProjectState(Object projectState) {
        return findByProperty(PROJECT_STATE, projectState);
    }


    public List findByProjectNumber(Object projectNumber) {
        return findByProperty(PROJECT_NUMBER, projectNumber);
    }


    public List findByProjectSense(Object projectSense) {
        return findByProperty(PROJECT_SENSE, projectSense);
    }


    public List findByProjectContent(Object projectContent) {
        return findByProperty(PROJECT_CONTENT, projectContent);
    }


    public List findByProjectLabtype(Object projectLabtype) {
        return findByProperty(PROJECT_LABTYPE, projectLabtype);
    }


    public List findByProjectLabname(Object projectLabname) {
        return findByProperty(PROJECT_LABNAME, projectLabname);
    }


    public List findByProjectName(Object projectName) {
        return findByProperty(PROJECT_NAME, projectName);
    }


    public List findByProjectIntroduction(Object projectIntroduction) {
        return findByProperty(PROJECT_INTRODUCTION, projectIntroduction);
    }


    public List findByProjectFund(Object projectFund) {
        return findByProperty(PROJECT_FUND, projectFund);
    }


    public List findByProjectInnovate(Object projectInnovate) {
        return findByProperty(PROJECT_INNOVATE, projectInnovate);
    }


    public List findByProjectCondition(Object projectCondition) {
        return findByProperty(PROJECT_CONDITION, projectCondition);
    }


    public List findByProjectProgress(Object projectProgress) {
        return findByProperty(PROJECT_PROGRESS, projectProgress);
    }


    public List findByProjectGoal(Object projectGoal) {
        return findByProperty(PROJECT_GOAL, projectGoal);
    }


    public List findByProjectAchievement(Object projectAchievement) {
        return findByProperty(PROJECT_ACHIEVEMENT, projectAchievement);
    }


    public List findByProjectWork(Object projectWork) {
        return findByProperty(PROJECT_WORK, projectWork);
    }


    public List findByRedmineProjectid(Object redmineProjectid) {
        return findByProperty(REDMINE_PROJECTID, redmineProjectid);
    }


    public List findByProjectScore(Object projectScore) {
        return findByProperty(PROJECT_SCORE, projectScore);
    }


    public List findByIsdeleted(Object isdeleted) {
        return findByProperty(ISDELETED, isdeleted);
    }

    public static TProjectDAO getFromApplicationContext(ApplicationContext ctx) {
        return (TProjectDAO) ctx.getBean("TProjectDAO");
    }
}
