package edu.cqu.no1.dao.impl;

import edu.cqu.no1.dao.TEndProjectCommentDAO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Huxley on 5/29/15.
 */
@ContextConfiguration(locations = "/applicationContext.xml")
public class TEndProjectCommentDAOImplTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    TEndProjectCommentDAO tEndProjectCommentDAO;

    @Test
    public void testFindMyReviewEndPros() throws Exception {
        List list = tEndProjectCommentDAO.findMyReviewEndPros("teaCode", null);
        assertEquals(0, list.size());
    }

    @Test
    public void testFindMyReviewEndProsCount() throws Exception {
        int val = tEndProjectCommentDAO.findMyReviewEndProsCount("teaCode");
        assertEquals(0, val);
    }
}