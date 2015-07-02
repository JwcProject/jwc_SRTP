package edu.cqu.no1.util.project;

import edu.cqu.no1.domain.TProject;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class RedmineManagerTest {
	private BeanFactory beanFactory = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml","redmineConnectContext.xml"});
	
	private RedmineManager redmineManager;
	private TProject project1;
	private TProject project2;

	@Test
	public void testCreateProject() {
		project1 = new TProject();
		project1.setProjectId("F67CCB53614A467383ADCE953C5E7A60");
		project1.setProjectName("8141618");
		project1.setProjectIntroduction("project introduction");
		project1.setRedmineProjectid("100");
		
		/*
		project1.setProjectLeader("1356E9192A354075BD991BB40B8B7363");
		project1.setProjectUser1("E44834BBFB5F4F23B5B5B1D478CA1356");
		//project1.setProjectTeacher1("F67CCB53614A467383ADCE953C5E7A60");
		project1.setProjectTeacher2("EA709AAD2BD241A58670BC9171F82C08");
		*/
		
		/*project2 = new TProject();
		project2.setProjectName("8141200");
		project2.setProjectIntroduction("project introduction");
		project2.setRedmineProjectid("101");*/
		
		List<TProject> listProjects = new ArrayList<TProject>();
		listProjects.add(project1);
		//listProjects.add(project2);
		
		redmineManager = (RedmineManager) beanFactory.getBean("RedmineManager");
		redmineManager.setListProjects(listProjects);

		String result = redmineManager.createProjects();
		//String result = redmineManager.createUsers();
		assertEquals("插入redmine数据库返回值", "success", result);
	}

}
