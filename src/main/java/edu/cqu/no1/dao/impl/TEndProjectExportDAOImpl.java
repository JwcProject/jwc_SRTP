package edu.cqu.no1.dao.impl;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;
import edu.cqu.no1.dao.*;
import edu.cqu.no1.domain.TEndProjectExport;
import edu.cqu.no1.util.PageBean;
import org.hibernate.Query;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ZKQ on 2015/5/27.
 */

@Repository
public class TEndProjectExportDAOImpl extends BaseDaoImpl<TEndProjectExport> implements edu.cqu.no1.dao.TEndProjectExportDAO {
    private static final Logger log = LoggerFactory
            .getLogger(TEndProjectExportDAO.class);
    // property constants
    public static final String ISDELETED = "isdeleted";

    /**
     *
     *获取一个专家教师可以进行网评的结题列表
     *authoy lzh
     *@param teaCode
     *@param jieqiId
     *@return
     */
    public List<TEndProjectExport> findMyReviewEndPros(String teaCode, String jieqiId, PageBean pageBean){
        log.debug("find my review endprojects");
        try {
            String queryString = "From TEndProjectExport T where T.isdeleted='N' and" +
                    " T.expertId = (select teaId from TTeacher where teaCode = :code) and" +
                    " T.endProjectId = :id";
            Query query = getSessionFactory().getCurrentSession().createQuery(queryString);
            query.setString("code", teaCode);
            query.setString("id", jieqiId);
            query.setFirstResult(pageBean.getBeginIndex());
            query.setMaxResults(pageBean.getPageCapibility());
            return query.list();
        } catch (RuntimeException e) {
            log.error("find my review endprojects");
            throw e;
        }
    }

    /**
     *
     *根据结题ID和教职工号获取结题评审专家对象
     *authoy lzh
     *@param teaCode
     *@param endProId
     *@return
     */
    public TEndProjectExport findEndProExp(String teaCode, String endProId){
        log.debug("find TEndProjectExport by teaCode and endprojectId");
        try {
            String queryString="From TEndProjectExport T where T.isdeleted='N' and T.endProjectId=:id and" +
                    " T.expertId = (select teaId from TTeacher where teaCode = :code)";
            Query query = getSessionFactory().getCurrentSession().createQuery(queryString);
            query.setString("id", endProId);
            query.setString("code", teaCode);
            List list = query.list();
            TEndProjectExport tEndProjectExport = null;
            if(list.size()>0){
                tEndProjectExport = (TEndProjectExport) list.get(0);
            }
            return tEndProjectExport;
        } catch (RuntimeException e) {
            log.error("find TEndProjectExport by teaCode and endprojectId failed"+e);
            throw e;
        }
    }
    public int findMyReviewEndPros(String teaCode, String jieqiId){
        log.debug("find my review endprojects");
        try {
            String queryString = "select count(*) From TEndProjectExport T where T.isdeleted='N' and" +
                    " T.expertId = (select teaId from TTeacher where teaCode = :code) and" +
                    " T.endProjectId = :id";
            Query query = getSessionFactory().getCurrentSession().createQuery(queryString);
            query.setString("code", teaCode);
            query.setString("id", jieqiId);
            List list = query.list();
            int count =0;
            if(list.size()>0){
                count = new Integer(""+list.get(0));
            }
            return count;
        } catch (RuntimeException e) {
            log.error("find my review endprojects");
            throw e;
        }
    }


    public List findByIsdeleted(Object isdeleted) {
        return findByProperty(ISDELETED, isdeleted);
    }


    public static TEndProjectExportDAO getFromApplicationContext(
            ApplicationContext ctx) {
        return (TEndProjectExportDAO) ctx.getBean("TEndProjectExportDAO");
    }
}
