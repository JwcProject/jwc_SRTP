package edu.cqu.no1.dao.impl;

import edu.cqu.no1.dao.TExpertLibDAO;
import edu.cqu.no1.domain.TExpertLib;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import static org.junit.Assert.*;

/**
 * Created by Huxley on 5/28/15.
 */
@ContextConfiguration(locations = "/applicationContext.xml")
public class TExpertLibDAOImplTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    TExpertLibDAO tExpertLibDAO;

    @Test
    public void testFindNowJieQiExpLib() throws Exception {
        TExpertLib lib = tExpertLibDAO.findNowJieQiExpLib("01");
        assertEquals(null, lib);
    }
}