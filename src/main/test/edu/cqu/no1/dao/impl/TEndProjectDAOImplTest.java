package edu.cqu.no1.dao.impl;

import edu.cqu.no1.dao.TEndProjectDAO;
import edu.cqu.no1.domain.TEndProject;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Huxley on 5/29/15.
 */
@ContextConfiguration(locations = "/applicationContext.xml")
public class TEndProjectDAOImplTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    TEndProjectDAO dao;

    @Test
    public void testGetUnitEndProCount() throws Exception {
        int val = dao.getUnitEndProCount("unitTeaCode", "checkState");
        assertEquals(0, val);
    }

    @Test
    public void testFindMyEndProjects() throws Exception {
        List list = dao.findMyEndProjects("studentNumber");
        assertEquals(0, list.size());
    }
}