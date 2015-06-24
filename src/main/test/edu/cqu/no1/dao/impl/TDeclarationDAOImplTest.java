package edu.cqu.no1.dao.impl;

import edu.cqu.no1.dao.TDeclarationDAO;
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
public class TDeclarationDAOImplTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    TDeclarationDAO dao;

    @Test
    public void testGetDeclarationSerial() throws Exception {
        String val = dao.getDeclarationSerial("unitId");
        assertEquals("", val);
    }

    @Test
    public void testFindAll() throws Exception {
        List list = dao.findAll(null, "studentId");
        assertEquals(0, list.size());
    }
}