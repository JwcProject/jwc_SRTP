package edu.cqu.no1.dao.impl;

import java.util.Date;
import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.isse.model.TProject;
import com.util.PageBean;

/**
 * A data access object (DAO) providing persistence and search support for
 * TProject entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.isse.model.TProject
 * @author MyEclipse Persistence Tools
 */

public class TProjectDAO extends HibernateDaoSupport {
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

	protected void initDao() {
		// do nothing
	}

	public void save(TProject transientInstance) {
		log.debug("saving TProject instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TProject persistentInstance) {
		log.debug("deleting TProject instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TProject findById(String id) {
		log.debug("getting TProject instance with id: " + id);
		try {
			TProject instance = (TProject) getHibernateTemplate().get(
					"com.isse.model.TProject", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TProject instance) {
		log.debug("finding TProject instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TProject instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TProject as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	public void createProject(String jqId) {
		log.debug("add TProject");
		try {
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
			String queryString1 = "Select Count(1) From t_project p Where p.declar_id In(Select d.declar_id From t_declaration d Where d.jq_id =:jqId And d.check_state='09')";
			Session session =  this.getSessionFactory().getCurrentSession();
			
			Transaction transaction = session.getTransaction();
			try {
				
				transaction.begin();
				
				SQLQuery sqlQuery1 = session.createSQLQuery(queryString1);
				sqlQuery1.setString("jqId", jqId);
				List list = sqlQuery1.list();
				int count = 0;
				if (list.size() > 0) {
					count = new Integer("" + list.get(0));
				}
				if(count==0)
				{
					SQLQuery query = session.createSQLQuery("{Call Projectid_Reset()}");
					query.executeUpdate();
				}
				
				SQLQuery sqlQuery = session.createSQLQuery(queryString);
				sqlQuery.setString("jqId", jqId);
				sqlQuery.executeUpdate();
				
				queryString = "update t_declaration d set d.check_state='09' where d.jq_id=:jqId and exists (select * from t_project p where d.declar_id=p.declar_id)";
				SQLQuery sqlQuery2 = session.createSQLQuery(queryString);
				sqlQuery2.setString("jqId", jqId);
				sqlQuery2.executeUpdate();
				
				//修改申报成员的用户类型
			    String qString1 = 
			    	"Update T_User u\n" +
			    	"   Set U.User_Type = '08'\n" + 
			    	" Where U.User_Id In\n" + 
			    	"       (Select s.user_id\n" + 
			    	"          From T_Student s\n" + 
			    	"         Where S.Student_Id In (Select D.Leader_Code\n" + 
			    	"                                  From T_Declaration d\n" + 
			    	"                                 Where D.Jq_Id =:jqId\n" + 
			    	"                                   and d.check_state = '09'))";

			    String qString2 = 
			    	"Update T_User u Set U.User_Type = '07'\n" +
			    	" Where U.User_Id In (Select s.user_id\n" + 
			    	"                       From T_Student s\n" + 
			    	"                      Where S.Student_Id In\n" + 
			    	"                            (Select D.MEMBER1_CODE\n" + 
			    	"                                From T_Declaration d\n" + 
			    	"                               Where D.Jq_Id =:jqId\n" + 
			    	"                                 and d.check_state = '09') or S.Student_Id In\n" + 
			    	"                             (Select D.Member2_Code\n" + 
			    	"                                From T_Declaration d\n" + 
			    	"                               Where D.Jq_Id =:jqId\n" + 
			    	"                                 and d.check_state = '09'))";

			    SQLQuery sQuery1 = session.createSQLQuery(qString1);
			    SQLQuery sQuery2 = session.createSQLQuery(qString2);
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
			Query query = this.getSession().createQuery(queryStr);
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
			Query query = this.getSession().createQuery(queryStr);
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
			
			Query query = this.getSession().createQuery(queryString);
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
			
			Query query = this.getSession().createQuery(queryString);
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
			Query query = this.getSession().createQuery(queryStr);
			
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
			Query query = this.getSession().createQuery(queryStr);
			
			List list = query.list();
			int count = 0;
			if (list.size() > 0) {
				count = new Integer("" + list.get(0));
			}
			return count;
			
		} catch (RuntimeException e) {
			// TODO: handle exception
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
			
			Query query = this.getSession().createQuery(queryString);

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
			
			Query query = this.getSession().createQuery(queryString);

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
			Query query = this.getSession().createQuery(queryString);
			query.setString("number", stuCode);
			
			List list = null;
			if(null!=query.list())
			{
				list = query.list();
			}
			return list;
			
		} catch (RuntimeException e) {
			// TODO: handle exception
			log.error("find student project " + e);
			throw e;
		}
	}
	
	//获取教师个人项目列表
	public List getTeaProject(String teaCode,PageBean pageBean){
		log.debug("find student project ");
		try {
			String queryString = "From TProject T Where T.isdeleted='N' and (T.TTeacherByProjectTeacher2.teaId=(select S.teaId from TTeacher S where S.isdeleted='N' and S.teaCode=:number) OR T.TTeacherByProjectTeacher1.teaId=(select S.teaId from TTeacher S where S.isdeleted='N' and S.teaCode=:number))";
			Query query = this.getSession().createQuery(queryString);
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
			// TODO: handle exception
			log.error("find student project " + e);
			throw e;
		}
	}
	
	public int getTeaProjectCount(String teaCode){
		log.debug("find student project ");
		try {
			String queryString = "select count(*) From TProject T Where T.isdeleted='N' and (T.TTeacherByProjectTeacher2.teaId=(select S.teaId from TTeacher S where S.isdeleted='N' and S.teaCode=:number) OR T.TTeacherByProjectTeacher1.teaId=(select S.teaId from TTeacher S where S.isdeleted='N' and S.teaCode=:number))";
			Query query = this.getSession().createQuery(queryString);
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
		
		Query query = this.getSession().createQuery(queryString);
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
			
			Query query = this.getSession().createQuery(queryString);
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
	 *TODO 根据项目组长的学号获取未申请结题的项目信息项目信息
	 *authoy lzh
	 *@param leaderCode 项目组长的学号
	 *@return
	 */
	public TProject findByLeaderCode(String leaderCode){
		try {
			log.debug("find project by leader code");
			String sql ="From TProject T where T.TStudentByProjectLeader.studentNumber=:leaderCode and T.isdeleted='N' and T.projectId not in (select TE.TProject.projectId from TEndProject TE where TE.isdeleted='N' and TE.endprojectState > 01)";
			Query query = this.getSession().createQuery(sql);
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

	public List findAll() {
		log.debug("finding all TProject instances");
		try {
			String queryString = "from TProject";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TProject merge(TProject detachedInstance) {
		log.debug("merging TProject instance");
		try {
			TProject result = (TProject) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TProject instance) {
		log.debug("attaching dirty TProject instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TProject instance) {
		log.debug("attaching clean TProject instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TProjectDAO getFromApplicationContext(ApplicationContext ctx) {
		return (TProjectDAO) ctx.getBean("TProjectDAO");
	}
}