package edu.cqu.no1.dao.impl;

import edu.cqu.no1.dao.StatisticDAO;
import edu.cqu.no1.domain.TJieqi;
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
public class StatisticDAOImplTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    StatisticDAO dao;

    @Test
    public void testSchooleProjectScore() throws Exception {
        List list = dao.SchooleProjectScore("AA");
        assertEquals(1, list.size());
    }

    @Test
    public void testGetSchoolResultDistribut() throws Exception {
        List list = dao.getSchoolResultDistribut("college", "jqYear", "jqQici", null);
        assertEquals(null, list);
    }

    @Test
    public void testGetSchoolResultDistributCount() throws Exception {
        int val = dao.getSchoolResultDistributCount("college", "jqYear", "jqQici");
        assertEquals(0, val);
    }

    @Test
    public void testGetCurrentJieqi() throws Exception {
        TJieqi val = dao.getCurrentJieqi();
        assertEquals(null, val);
    }
}