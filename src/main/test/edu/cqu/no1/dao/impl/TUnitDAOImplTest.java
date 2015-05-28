package edu.cqu.no1.dao.impl;

import edu.cqu.no1.dao.TUnitDAO;
import edu.cqu.no1.domain.TUnit;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import static org.junit.Assert.*;

/**
 * Created by Huxley on 5/28/15.
 */
@ContextConfiguration(locations = "/applicationContext.xml")
public class TUnitDAOImplTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    TUnitDAO tUnitDAO;

    @Test
    public void testGetUnitByTeacherId() throws Exception {
        TUnit tUnit = tUnitDAO.getUnitByTeacherId("testID");
        assertEquals(null, tUnit);
    }
}