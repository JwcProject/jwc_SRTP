package edu.cqu.no1.dao.impl;

import edu.cqu.no1.dao.UnitStatisticDAO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Huxley on 5/30/15.
 */
@ContextConfiguration(locations = "/applicationContext.xml")
public class UnitStatisticDAOImplTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    UnitStatisticDAO dao;

    @Test
    public void testUnitProjectScore() throws Exception {
        List list = dao.unitProjectScore("unitId", "jqId");
        assertEquals(null, list);
    }

    @Test
    public void testGetUnitResultDistribut() throws Exception {
        List list = dao.getUnitResultDistribut("unitId", null);
        assertEquals(null, list);
    }

    @Test
    public void testGetUnitResultDistributCount() throws Exception {
        int val = dao.getUnitResultDistributCount("unitId");
        assertEquals(0, val);
    }
}