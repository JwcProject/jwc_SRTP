package edu.cqu.no1.dao.impl;

import edu.cqu.no1.dao.TTeacherDAO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Huxley on 5/28/15.
 */
@ContextConfiguration(locations = "/applicationContext.xml")
public class TTeacherDAOImplTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    TTeacherDAO tTeacherDAO;

    @Test
    public void testGetCommonTeachers() throws Exception {
        List list = tTeacherDAO.getCommonTeachers("code", "01");
        assertEquals(0, list.size());
    }

    @Test
    public void testFindTeachers() throws Exception {

    }
}