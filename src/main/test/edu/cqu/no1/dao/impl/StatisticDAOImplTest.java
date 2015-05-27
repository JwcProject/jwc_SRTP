package edu.cqu.no1.dao.impl;

import edu.cqu.no1.dao.StatisticDAO;
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
        for (Object obj: list) {
            System.out.println(obj);
        }
    }
}