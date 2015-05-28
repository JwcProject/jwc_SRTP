package edu.cqu.no1.dao.impl;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;
import edu.cqu.no1.dao.*;
import edu.cqu.no1.domain.TDeclComment;
import org.hibernate.Query;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ZKQ on 2015/5/27.
 */

@Repository
public class TDeclCommentDAOImpl extends BaseDaoImpl<TDeclComment> implements edu.cqu.no1.dao.TDeclCommentDAO {
    private static final Logger log = LoggerFactory
            .getLogger(TDeclCommentDAO.class);
    // property constants
    public static final String DECL_ARGUMENT = "declArgument";
    public static final String COMP_EVAL = "compEval";
    public static final String ISDELETED = "isdeleted";

    //通过专家评审id得到网评对象
    public TDeclComment findByExpertReview(String exReviewId)
    {
        log.debug("get TDeclComment by expertReview");
        try {
            String queryString = "from TDeclComment td where td.isdeleted = 'N' and td.exReviewId=:exReviewId";
            Query query = getSessionFactory().getCurrentSession().createQuery(queryString);
            query.setString("exReviewId", exReviewId);
            TDeclComment tDeclComment = null;
            List tempL = query.list();
            if(tempL.size()>0)
            {
                tDeclComment =(TDeclComment)tempL.get(0);
            }
            return tDeclComment;
        } catch (RuntimeException e) {
            // TODO: handle exception
            log.error("get TDeclComment by expertReview failed", e);
            throw e;
        }
    }

    public List findByDeclArgument(Object declArgument) {
        return findByProperty(DECL_ARGUMENT, declArgument);
    }

    public List findByCompEval(Object compEval) {
        return findByProperty(COMP_EVAL, compEval);
    }

    public List findByIsdeleted(Object isdeleted) {
        return findByProperty(ISDELETED, isdeleted);
    }

    public static TDeclCommentDAO getFromApplicationContext(
            ApplicationContext ctx) {
        return (TDeclCommentDAO) ctx.getBean("TDeclCommentDAO");
    }
}
