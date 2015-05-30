package edu.cqu.no1.dao.impl;

import edu.cqu.no1.dao.TAnnouncementDAO;
import edu.cqu.no1.domain.TAnnouncement;
import edu.cqu.no1.domain.TAnnouncementModel;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Huxley on 5/30/15.
 */
@ContextConfiguration(locations = "/applicationContext.xml")
public class TAnnouncementDAOImplTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    TAnnouncementDAO dao;

    @Test
    public void testFindStuTeatAnnoun() throws Exception {
        List list = dao.findStuTeatAnnoun("number", "announName", new Date(), null);
        assertEquals(0, list.size());
    }

    @Test
    public void testFindSchoolAnnoun() throws Exception {
        List list = dao.findSchoolAnnoun("announName", "checkState", new Date(), "publisherName", "typeName", null);
        assertEquals(0, list.size());
    }

    @Test
    public void testFindAnnounByType() throws Exception {
        List list = dao.findAnnounByType("typeName", null);
        assertEquals(0, list.size());
    }

    @Test
    public void testGetSchoolAnnounctment() throws Exception {
        List list = dao.getSchoolAnnounctment(null);
        assertEquals(0, list.size());
    }

    @Test
    public void testFindUnitAnnoun() throws Exception {
        List list = dao.findUnitAnnoun("teaCode", "announName", new Date(), null);
        assertEquals(0, list.size());
    }

    @Test
    public void testGetAnnounById() throws Exception {
        TAnnouncementModel val = dao.getAnnounById("announId");
        assertEquals(null, val);
    }
}