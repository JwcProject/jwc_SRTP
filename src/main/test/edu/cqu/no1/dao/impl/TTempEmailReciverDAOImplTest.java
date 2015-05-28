package edu.cqu.no1.dao.impl;

import edu.cqu.no1.dao.TTempEmailReciverDAO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Huxley on 5/28/15.
 */
@ContextConfiguration(locations = "/applicationContext.xml")
public class TTempEmailReciverDAOImplTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    TTempEmailReciverDAO tTempEmailReciverDAO;

    @Test
    public void testFindTempEmailRecivers() throws Exception {
        List list = tTempEmailReciverDAO.findTempEmailRecivers("jqId", "teaCode", "null");
        assertEquals(0, list.size());
    }
}