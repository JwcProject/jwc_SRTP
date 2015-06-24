package edu.cqu.no1.util.project;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.cqu.no1.dao.TStudentDAO;
import edu.cqu.no1.dao.TTeacherDAO;
import edu.cqu.no1.dao.TUserDAO;
import edu.cqu.no1.domain.TProject;
import edu.cqu.no1.domain.TStudent;
import edu.cqu.no1.domain.TTeacher;
import edu.cqu.no1.domain.TUser;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class RedmineManager {
	
	private static final String SUCCESS = "success";
	private static final String FAILURE = "failure";

	private SessionFactory sessionFactory;
	private TStudentDAO studentDAO;
	private TTeacherDAO teacherDAO;
	private TUserDAO userDAO;
	
	private Session session;
	private Transaction transation;
	private List<TProject> listProjects;
	
	public RedmineManager(){
		
	}
	
	public String createProjects() {
		this.session = this.sessionFactory.openSession();
		this.transation = this.session.beginTransaction();
		
		List<SQLQuery> tempSqlQueries = this.getAllQueries();
		int querySize = tempSqlQueries.size();
		try {
			transation.begin();
			for(int i=0; i<querySize; ++i){
				tempSqlQueries.get(i).executeUpdate();
			}
			transation.commit();
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			transation.rollback();
			return FAILURE;
		} finally {
			this.session.close();
		}
	}
	
	private List<SQLQuery> getAllQueries(){
		List<SQLQuery> listSqlQueries = new ArrayList<SQLQuery>();
		
		for(int i=0; i<listProjects.size(); ++i){
			TProject tempProject = listProjects.get(i);
			//project query
			listSqlQueries.add(this.createProjectSqlQuery(tempProject));
			
			//project trackers
			for(ProjectTracker tracker:ProjectTracker.values())
				listSqlQueries.add(this.createProjectTrackerSqlQuery(tempProject, tracker));
			
			//project modules
			for(RedmineModule mondule:RedmineModule.values())
				listSqlQueries.add(this.createProjectModuleSqlQuery(tempProject, mondule));
			
			//user member and member_role query
			if(tempProject.getTStudentByProjectLeader() != null && tempProject.getTStudentByProjectLeader().getStudentId() != ""){
				Map<String, Object> leaderInfoMap = getStudentInfo(tempProject.getTStudentByProjectLeader().getStudentId() );
				listSqlQueries.add(this.createUserSqlQuery(leaderInfoMap));
				listSqlQueries.add(this.createMemberSqlQuery((Integer) leaderInfoMap.get("id"), tempProject));
				listSqlQueries.add(this.createMemberRoleSqlQuery((Integer) leaderInfoMap.get("id"), RedmineRole.项目组长.getRoleId()));
			}
			if(tempProject.getTStudentByProjectUser1() != null && tempProject.getTStudentByProjectUser1().getStudentId() != ""){
				Map<String, Object> member1InfoMap = getStudentInfo(tempProject.getTStudentByProjectUser1().getStudentId());
				listSqlQueries.add(this.createUserSqlQuery(member1InfoMap));
				listSqlQueries.add(this.createMemberSqlQuery((Integer) member1InfoMap.get("id"), tempProject));
				listSqlQueries.add(this.createMemberRoleSqlQuery((Integer) member1InfoMap.get("id"), RedmineRole.项目成员.getRoleId()));
			}
			if(tempProject.getTStudentByProjectUser2() != null && tempProject.getTStudentByProjectUser2().getStudentId() != ""){
				Map<String, Object> member2InfoMap = getStudentInfo(tempProject.getTStudentByProjectUser2().getStudentId());
				listSqlQueries.add(this.createUserSqlQuery(member2InfoMap)); 
				listSqlQueries.add(this.createMemberSqlQuery((Integer) member2InfoMap.get("id"), tempProject));
				listSqlQueries.add(this.createMemberRoleSqlQuery((Integer) member2InfoMap.get("id"), RedmineRole.项目成员.getRoleId()));
			}
			if(tempProject.getTTeacherByProjectTeacher1() != null && tempProject.getTTeacherByProjectTeacher1().getTeaId() != ""){
				Map<String, Object> teacher1InfoMap = getTeacherInfo(tempProject.getTTeacherByProjectTeacher1().getTeaId() );
				listSqlQueries.add(this.createUserSqlQuery(teacher1InfoMap)); 
				listSqlQueries.add(this.createMemberSqlQuery((Integer) teacher1InfoMap.get("id"), tempProject));
				listSqlQueries.add(this.createMemberRoleSqlQuery((Integer) teacher1InfoMap.get("id"), RedmineRole.指导教师.getRoleId()));
			}
			if(tempProject.getTTeacherByProjectTeacher2() != null && tempProject.getTTeacherByProjectTeacher2().getTeaId() != ""){
				Map<String, Object> teacher2InfoMap = getTeacherInfo(tempProject.getTTeacherByProjectTeacher2().getTeaId());
				listSqlQueries.add(this.createUserSqlQuery(teacher2InfoMap)); 
				listSqlQueries.add(this.createMemberSqlQuery((Integer) teacher2InfoMap.get("id"), tempProject));
				listSqlQueries.add(this.createMemberRoleSqlQuery((Integer) teacher2InfoMap.get("id"), RedmineRole.指导教师.getRoleId()));
			}
		}
		return listSqlQueries;
	}

	//获取学生信息  作为用户字段
	private Map<String, Object> getStudentInfo(String studentId){
		TStudent student = this.studentDAO.findById(studentId);
		TUser user = student.getTUser();
		Map<String, Object> studentMap = new HashMap<String, Object>();
		studentMap.put("id", Integer.parseInt(student.getStudentNumber()));
		studentMap.put("login", student.getStudentNumber());
		studentMap.put("hashed_password", user.getUserPassword());
		studentMap.put("firstname", student.getStudentName());
		studentMap.put("lastname", "cqu");
		studentMap.put("mail", student.getStudentEmail());
		studentMap.put("language", "zh");
		studentMap.put("created_on", new Date());
		studentMap.put("updated_on", new Date());
		studentMap.put("type", "User");
		studentMap.put("mail_notification", "only_my_events");
		studentMap.put("salt", "");
		return studentMap;
	}
	
	//获取教师信息  作为用户字段
	private Map<String, Object> getTeacherInfo(String teacherId){
		TTeacher teacher = this.teacherDAO.findById(teacherId);
		System.out.println(teacherId.toString());
		TUser user = this.userDAO.findById(teacher.getTeaCode());
		Map<String, Object> teacherMap = new HashMap<String, Object>();
		teacherMap.put("id", Integer.parseInt(teacher.getTeaCode()));
		teacherMap.put("login", teacher.getTeaCode());
		teacherMap.put("hashed_password", user.getUserPassword());
		teacherMap.put("firstname", teacher.getTeaName());
		teacherMap.put("lastname", "cqu");
		teacherMap.put("mail", teacher.getTeaEmail());
		teacherMap.put("language", "zh");
		teacherMap.put("created_on", new Date());
		teacherMap.put("updated_on", new Date());
		teacherMap.put("type", "User");
		teacherMap.put("mail_notification", "only_my_events");
		teacherMap.put("salt", "");
		return teacherMap;
	}
	
	private SQLQuery createProjectSqlQuery(TProject project){
		String queryString = "INSERT INTO projects (id, name, description, is_public, parent_id, created_on, " +
				"updated_on, identifier, lft, rgt) VALUES (:id, :name, :description, :isPublic, null, " +
				":createdOn, :updateOn, :identifier, :lft, :rgt)";
		SQLQuery tempSqlQuery = this.session.createSQLQuery(queryString);
		tempSqlQuery = this.session.createSQLQuery(queryString);
		tempSqlQuery.setInteger("id", this.getProjcetId(project));
		tempSqlQuery.setString("name", this.getProjectName(project));
		tempSqlQuery.setString("description", this.getProjectDescription(project));
		tempSqlQuery.setInteger("isPublic", 0);
		//tempSqlQuery.setString("parentId", this.getProjectParentId());
		tempSqlQuery.setDate("createdOn", new Date());
		tempSqlQuery.setDate("updateOn", new Date());
		tempSqlQuery.setString("identifier", this.getProjectIdentifier(project));
		tempSqlQuery.setInteger("lft", this.getProjectLft(project));
		tempSqlQuery.setInteger("rgt", this.getProjectRgt(project));
		return tempSqlQuery;
	}
	
	private SQLQuery createProjectTrackerSqlQuery(TProject project, ProjectTracker tracker){
		String queryString = "INSERT INTO projects_trackers (project_id, tracker_id) VALUES (:project_id, :tracker_id)";
		SQLQuery tempSqlQuery = this.session.createSQLQuery(queryString);
		tempSqlQuery.setInteger("project_id", this.getProjcetId(project));
		tempSqlQuery.setInteger("tracker_id", tracker.getTrackersId());
		return tempSqlQuery;
	}
	
	private SQLQuery createProjectModuleSqlQuery(TProject project, RedmineModule mondule){
		String queryString = "INSERT INTO enabled_modules (project_id, name) VALUES (:project_id, :name)";
		SQLQuery tempSqlQuery = this.session.createSQLQuery(queryString);
		tempSqlQuery.setInteger("project_id", this.getProjcetId(project));
		tempSqlQuery.setString("name", mondule.getModuleName());
		return tempSqlQuery;
	}
	
	private SQLQuery createUserSqlQuery(Map<String, Object> userInfoMap){
		String queryString = "INSERT INTO users (id, login, hashed_password, firstname, lastname, mail, language, " +
				"created_on, updated_on, type, mail_notification, salt) VALUES (:id, :login, :hashed_password, " +
				":firstname, :lastname, :mail, :language, :created_on, :updated_on, :type, :mail_notification, :salt)";
		SQLQuery tempSqlQuery = this.session.createSQLQuery(queryString);
		tempSqlQuery.setInteger("id", (Integer) userInfoMap.get("id"));
		tempSqlQuery.setString("login", (String) userInfoMap.get("login"));
		tempSqlQuery.setString("hashed_password", (String) userInfoMap.get("hashed_password"));
		tempSqlQuery.setString("firstname", (String) userInfoMap.get("firstname"));
		tempSqlQuery.setString("lastname", (String) userInfoMap.get("lastname"));
		tempSqlQuery.setString("mail", (String) userInfoMap.get("mail"));
		tempSqlQuery.setString("language", (String) userInfoMap.get("language"));
		tempSqlQuery.setDate("created_on", (Date) userInfoMap.get("created_on"));
		tempSqlQuery.setDate("updated_on", (Date) userInfoMap.get("updated_on"));
		tempSqlQuery.setString("type", (String) userInfoMap.get("type"));
		tempSqlQuery.setString("mail_notification", (String) userInfoMap.get("mail_notification"));
		tempSqlQuery.setString("salt", (String) userInfoMap.get("salt"));
		return tempSqlQuery;
	}
	
	private SQLQuery createMemberSqlQuery(int userId, TProject project){
		String queryString = "INSERT INTO members (id, user_id, project_id, created_on) VALUES (:id, :user_id, :project_id, :created_on)";
		SQLQuery tempSqlQuery = this.session.createSQLQuery(queryString);
		tempSqlQuery.setInteger("id", userId);
		tempSqlQuery.setInteger("user_id", userId);
		tempSqlQuery.setInteger("project_id", this.getProjcetId(project));
		tempSqlQuery.setDate("created_on", new Date());
		return tempSqlQuery;
	}
	
	private SQLQuery createMemberRoleSqlQuery(int userId, int roleId){
		String queryString = "INSERT INTO member_roles (member_id, role_id) VALUES (:member_id, :role_id)";
		SQLQuery tempSqlQuery = this.session.createSQLQuery(queryString);
		tempSqlQuery.setInteger("member_id", userId);
		tempSqlQuery.setInteger("role_id", roleId);
		return tempSqlQuery;
	}
	//获取项目的一些字段
	private int getProjcetId(TProject project){
		return Integer.parseInt(project.getRedmineProjectid());
	}
	
	private String getProjectName(TProject project){
		return project.getProjectName();
	}
	
	private String getProjectDescription(TProject project){
		return project.getProjectIntroduction();
	}
	
	private String getProjectParentId(){
		return "";           //算法后面补充
	}
	
	private int getProjectLft(TProject project){
		return 2*getProjcetId(project)-1;
	}
	
	private int getProjectRgt(TProject project){
		return  2*getProjcetId(project);
	}

	private String getProjectIdentifier(TProject project){
		return project.getProjectId().toLowerCase();
	}

	// get & set methods
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public Transaction getTransation() {
		return transation;
	}

	public void setTransation(Transaction transation) {
		this.transation = transation;
	}

	public List<TProject> getListProjects() {
		return listProjects;
	}

	public void setListProjects(List<TProject> listProjects) {
		this.listProjects = listProjects;
	}

	public TStudentDAO getStudentDAO() {
		return studentDAO;
	}

	public void setStudentDAO(TStudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	public TTeacherDAO getTeacherDAO() {
		return teacherDAO;
	}

	public void setTeacherDAO(TTeacherDAO teacherDAO) {
		this.teacherDAO = teacherDAO;
	}

	public TUserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(TUserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
}
