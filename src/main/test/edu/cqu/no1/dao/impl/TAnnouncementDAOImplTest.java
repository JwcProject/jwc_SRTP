package edu.cqu.no1.dao.impl;

import edu.cqu.no1.dao.TAnnouncementDAO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Huxley on 5/29/15.
 */
@ContextConfiguration(locations = "/applicationContext.xml")
public class TAnnouncementDAOImplTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    TAnnouncementDAO dao;

    @Test
    public void testFindIndexSchoolAnnoument() throws Exception {
        List list = dao.findIndexSchoolAnnoument("announTitle", new Date(), "typeName", null);
        assertEquals(0, list.size());
    }

    @Test
    public void testFindUnitAnnoun() throws Exception {
        dao.findIndexSchoolAnnoument("announTitle", new Date(), "typeName", null);
    }
}