package edu.cqu.no1.dao.impl;

import edu.cqu.no1.dao.TExpertTeacherDAO;
import edu.cqu.no1.domain.TExpertTeacher;
import edu.cqu.no1.domain.TTeacher;
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
public class TExpertTeacherDAOImplTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    TExpertTeacherDAO dao;

    @Test
    public void testFindExpertLibByJqid() throws Exception {
        List list = dao.findExpertLibByJqid("jqId", "type");
        assertEquals(null, list);
    }

    @Test
    public void testFindUnitExpertLibByJqid() throws Exception {
        List list = dao.findUnitExpertLibByJqid("jqId", "type", "teacherCode");
        assertEquals(null, list);
    }

    @Test
    public void testGetExpertTeachersByTeaId() throws Exception {
        TExpertTeacher val = dao.getExpertTeachersByTeaId("AA", "DF");
        assertNotEquals(null, val);
    }

    @Test
    public void testFindExpertTeachersByJQid() throws Exception {
        List list = dao.findExpertTeachersByJQid("jqId");
        assertNotEquals(null, list);
    }
}