/**
 * 
 */
package com.isse.dao;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ming
 *
 */
public class TProjectDAOTest {

	private BeanFactory beanFactory = new ClassPathXmlApplicationContext("applicationContext.xml");

	private TProjectDAO projectDAO;
	/**
	 * Test method for {@link com.isse.dao.TProjectDAO#createProject(java.lang.String)}.
	 */
	@Test
	public void testCreateProject() {
		projectDAO = (TProjectDAO) beanFactory.getBean("TProjectDAO");
		projectDAO.createProject("61B9B0A06FE04BB09F78BE173568DB1A");
	}

}
