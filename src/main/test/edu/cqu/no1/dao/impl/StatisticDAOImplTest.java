package edu.cqu.no1.dao.impl;

import edu.cqu.no1.dao.StatisticDAO;
import edu.cqu.no1.domain.TJieqi;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Huxley on 5/28/15.
 */
@ContextConfiguration(locations = "/applicationContext.xml")
public class StatisticDAOImplTest extends AbstractJUnit4SpringContextTests {

    @Autowired
    StatisticDAO statisticDAO;

    @Test
    public void testSchooleProjectScore() throws Exception {
        List list = statisticDAO.SchooleProjectScore("01");
        assertEquals(null, list);
    }

    @Test
    public void testGetSchoolResultDistributCount() throws Exception {
        int val = statisticDAO.getSchoolResultDistributCount("college", "jqYear", "jqQici");
        assertEquals(0, val);
    }

    @Test
    public void testGetSchoolResultDistribut() throws Exception {
        List list = statisticDAO.getSchoolResultDistribut("college", "jqYear", "jqQici", null);
        assertEquals(null, list);
    }

    @Test
    public void testGetSchoolStatisticsData() throws Exception {
        List list = statisticDAO.getSchoolStatisticsData("jqQici");
        assertEquals(null, list);
    }

    @Test
    public void testGetSchoolStatisticDataByCollege() throws Exception {
        List list = statisticDAO.getSchoolStatisticDataByCollege("college");
        assertEquals(null, list);
    }

    @Test
    public void testGetJieqiById() throws Exception {
        TJieqi tJieqi = statisticDAO.getJieqiById("id");
        assertEquals(null, tJieqi);
    }

    @Test
    public void testGetCurrentJieqi() throws Exception {
        TJieqi tJieqi = statisticDAO.getCurrentJieqi();
        assertEquals(null, tJieqi);
    }
}