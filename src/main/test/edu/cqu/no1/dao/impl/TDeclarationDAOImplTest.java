package edu.cqu.no1.dao.impl;

import edu.cqu.no1.dao.TDeclarationDAO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import static org.junit.Assert.*;

/**
 * Created by Huxley on 5/29/15.
 */
@ContextConfiguration(locations = "/applicationContext.xml")
public class TDeclarationDAOImplTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    TDeclarationDAO dao;

    @Test
    public void testGetDeclarationSerial() throws Exception {
        String val = dao.getDeclarationSerial("unitId");
        assertEquals("", val);
    }
}