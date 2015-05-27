package edu.cqu.no1.dao.impl;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;
import edu.cqu.no1.dao.TProjectChangeContentDAO;
import edu.cqu.no1.domain.TProjectChangeContent;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ZKQ on 2015/5/27.
 */

@Repository
public class TProjectChangeContentDAOImpl extends BaseDaoImpl<TProjectChangeContent> implements TProjectChangeContentDAO {
    private static final Logger log = LoggerFactory
            .getLogger(TProjectChangeContentDAO.class);
    // property constants
    public static final String PROJECTCHANGECONTENT_FIELD = "projectchangecontentField";
    public static final String PROJECTCHANGECONTENT_FIELDNAME = "projectchangecontentFieldname";
    public static final String PROJECTCHANGECONTENT_OVALUE = "projectchangecontentOvalue";
    public static final String PROJECTCHANGECONTENT_NVALUE = "projectchangecontentNvalue";
    public static final String ISDELETED = "isdeleted";



    @Override
    public List findByProjectchangecontentField(Object projectchangecontentField) {
        return findByProperty(PROJECTCHANGECONTENT_FIELD,
                projectchangecontentField);
    }

    @Override
    public List findByProjectchangecontentFieldname(
            Object projectchangecontentFieldname) {
        return findByProperty(PROJECTCHANGECONTENT_FIELDNAME,
                projectchangecontentFieldname);
    }

    @Override
    public List findByProjectchangecontentOvalue(
            Object projectchangecontentOvalue) {
        return findByProperty(PROJECTCHANGECONTENT_OVALUE,
                projectchangecontentOvalue);
    }

    @Override
    public List findByProjectchangecontentNvalue(
            Object projectchangecontentNvalue) {
        return findByProperty(PROJECTCHANGECONTENT_NVALUE,
                projectchangecontentNvalue);
    }

    @Override
    public List findByIsdeleted(Object isdeleted) {
        return findByProperty(ISDELETED, isdeleted);
    }



    public static TProjectChangeContentDAO getFromApplicationContext(
            ApplicationContext ctx) {
        return (TProjectChangeContentDAO) ctx
                .getBean("TProjectChangeContentDAO");
    }
}
