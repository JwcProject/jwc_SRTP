package edu.cqu.no1.dao.impl;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;
import edu.cqu.no1.dao.*;
import edu.cqu.no1.domain.TEndprojectJob;
import org.hibernate.Query;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ZKQ on 2015/5/27.
 */

@Repository
public class TEndprojectJobDAOImpl extends BaseDaoImpl<TEndprojectJob> implements edu.cqu.no1.dao.TEndprojectJobDAO {

    private static final Logger log = LoggerFactory.getLogger(TEndprojectJobDAO.class);
    //property constants
    public static final String JOB_CONTENT = "jobContent";
    public static final String FINISHED = "finished";
    public static final String ISDELETED = "isdeleted";


    /**
     *
     *TODO 根据结题获取结题分工
     *authoy lzh
     *@param endprojectId
     *@return
     */
    public List findEndProJobsByEndProId(String endprojectId){
        log.debug("find endprojectjobs by endproject id");
        try {
            String queryString = "From TEndprojectJob T where T.isdeleted='N' and T.endprojectId=:id";
            Query query = getSessionFactory().getCurrentSession().createQuery(queryString);
            query.setString("id", endprojectId);
            return query.list();
        } catch (RuntimeException e) {
            log.error("find endprojectjobs by endprojects failed"+e);
            throw e;
        }
    }

    public List findByJobContent(Object jobContent
    ) {
        return findByProperty(JOB_CONTENT, jobContent
        );
    }

    public List findByFinished(Object finished
    ) {
        return findByProperty(FINISHED, finished
        );
    }

    public List findByIsdeleted(Object isdeleted
    ) {
        return findByProperty(ISDELETED, isdeleted
        );
    }

    public static TEndprojectJobDAO getFromApplicationContext(ApplicationContext ctx) {
        return (TEndprojectJobDAO) ctx.getBean("TEndprojectJobDAO");
    }
}
