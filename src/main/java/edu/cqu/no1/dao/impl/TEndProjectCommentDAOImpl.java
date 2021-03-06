package edu.cqu.no1.dao.impl;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;
import edu.cqu.no1.dao.*;
import edu.cqu.no1.domain.TEndProjectComment;
import edu.cqu.no1.util.PageBean;
import org.hibernate.Query;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ZKQ on 2015/5/27.
 */

@Repository
public class TEndProjectCommentDAOImpl extends BaseDaoImpl<TEndProjectComment> implements TEndProjectCommentDAO {

    private static final Logger log = LoggerFactory
            .getLogger(TEndProjectCommentDAO.class);
    // property constants
    public static final String ENDPROJECTCOMMENT_ADVISE = "endprojectcommentAdvise";
    public static final String ENDPROJECTCOMMENT_CONTENT = "endprojectcommentContent";
    public static final String ISDELETED = "isdeleted";


    //获取一个教师可以评审的结题

    public List<TEndProjectComment> findMyReviewEndPros(String teaCode, PageBean pageBean){
        log.debug("finding teacher review TEndProjectComment by pageBean");
        try {
            String sql = "From TEndProjectComment T where T.isdeleted='N' and T.TEndProjectExport.TExpertTeacher.TTeacher.teaCode=:code";
            Query query = getSessionFactory().getCurrentSession().createQuery(sql);
            query.setString("code", teaCode);
            query.setFirstResult(pageBean.getBeginIndex());
            query.setMaxResults(pageBean.getPageCapibility());
            return query.list();
        } catch (RuntimeException e) {
            log.error("finding teacher review TEndProjectComment by pageBean failed", e);
            throw e;
        }
    }

    public int findMyReviewEndProsCount(String teaCode){
        log.debug("finding teacher review TEndProjectComment count");
        try {
            String sql = "select count(*) From TEndProjectComment T where T.isdeleted='N' and T.TEndProjectExport.TExpertTeacher.TTeacher.teaCode=:code";
            Query query = getSessionFactory().getCurrentSession().createQuery(sql);
            query.setString("code", teaCode);
            List list = query.list();
            int count = 0;
            if(list.size()>0){
                count = new Integer(""+list.get(0));
            }
            return count;
        } catch (RuntimeException e) {
            log.error("finding teacher review TEndProjectComment count failed", e);
            throw e;
        }
    }


    public List findByEndprojectcommentAdvise(Object endprojectcommentAdvise) {
        return findByProperty(ENDPROJECTCOMMENT_ADVISE, endprojectcommentAdvise);
    }


    public List findByEndprojectcommentContent(Object endprojectcommentContent) {
        return findByProperty(ENDPROJECTCOMMENT_CONTENT,
                endprojectcommentContent);
    }


    public List findByIsdeleted(Object isdeleted) {
        return findByProperty(ISDELETED, isdeleted);
    }


    public static TEndProjectCommentDAO getFromApplicationContext(
            ApplicationContext ctx) {
        return (TEndProjectCommentDAO) ctx.getBean("TEndProjectCommentDAO");
    }
}
