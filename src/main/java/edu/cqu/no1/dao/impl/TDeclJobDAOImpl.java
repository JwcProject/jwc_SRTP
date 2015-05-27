package edu.cqu.no1.dao.impl;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;
import edu.cqu.no1.dao.TDeclJobDAO;
import edu.cqu.no1.domain.TDeclJob;
import org.hibernate.Query;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ZKQ on 2015/5/27.
 */

@Repository
public class TDeclJobDAOImpl extends BaseDaoImpl<TDeclJob> implements edu.cqu.no1.dao.TDeclJobDAO{

    private static final Logger log = LoggerFactory
            .getLogger(TDeclJobDAO.class);
    // property constants
    public static final String JOB_CONTENT = "jobContent";
    public static final String ISDELETED = "isdeleted";


    @Override
    public List findByJobContent(Object jobContent) {
        return findByProperty(JOB_CONTENT, jobContent);
    }

    @Override
    public List findByIsdeleted(Object isdeleted) {
        return findByProperty(ISDELETED, isdeleted);
    }


    public static TDeclJobDAO getFromApplicationContext(ApplicationContext ctx) {
        return (TDeclJobDAO) ctx.getBean("TDeclJobDAO");
    }

    @Override
    public List<TDeclJob> findByDeclarId(String declarId){
        log.debug("finding all TDeclJob instances");
        try {
            String queryStr = "from TDeclJob as a where a.isdeleted = 'N' " +
                    "and a.TDeclaration.declarId=:code ";

            Query query = getSessionFactory().getCurrentSession().createQuery(queryStr);
            query.setString("code", declarId);

            return query.list();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }
    }
    @Override
    public int deleteJobByDeclId(String declarId) throws Exception{
        log.debug("deleteJobByDeclId");
        try {
            List<TDeclJob> list = findByDeclarId(declarId);
            for (TDeclJob tDeclJob : list) {
                tDeclJob.setIsdeleted("Y");
                merge(tDeclJob);
            }
            return list == null ? 0:list.size();
        } catch (RuntimeException re) {
            log.error("deleteJobByDeclId failed", re);
            throw re;
        }
    }

}
