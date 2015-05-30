package edu.cqu.no1.dao.impl;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;
import edu.cqu.no1.dao.*;
import edu.cqu.no1.domain.TExpertReview;
import org.hibernate.Query;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ZKQ on 2015/5/27.
 */

@Repository
public class TExpertReviewDAOImpl extends BaseDaoImpl<TExpertReview> implements TExpertReviewDAO {

    private static final Logger log = LoggerFactory
            .getLogger(TExpertReviewDAO.class);
    // property constants
    public static final String ISDELETED = "isdeleted";


    public List findByIsdeleted(Object isdeleted) {
        return findByProperty(ISDELETED, isdeleted);
    }


    /**
     *
     *根据届期ID,教师教职工号，申报ID，专家库类别
     *     获取对应的专家评审
     *authoy lzh
     *@param jqId
     *@param teaCode
     *@param declId
     *@param type
     *@return
     */

    public TExpertReview getTExpertReview(String jqId, String teaCode, String declId, String type){
        log.debug("get TExpertREview By jqId,teaCode,declId,type");
        try {
            String queryString  = "From TExpertReview ER where ER.TDeclaration.declarId=:declId and ER.TExpertTeacher.exTeaId =" +
                    " (select ET.exTeaId From TExpertTeacher ET where ET.TTeacher.teaId=(select TT.teaId from TTeacher TT where TT.teaCode=:teaCode)" +
                    "and ET.TExpertLib.libId=(select EL.libId from TExpertLib EL where EL.TJieqi.jqId=:jqId and EL.type=:type))";
            Query query = getSessionFactory().getCurrentSession().createQuery(queryString);
            query.setString("declId", declId);
            query.setString("teaCode", teaCode);
            query.setString("jqId", jqId);
            query.setString("type", type);
            List list = query.list();
            TExpertReview tExpertReview = null;
            if(list.size()>0){
                tExpertReview = (TExpertReview) list.get(0);
            }
            return tExpertReview;
        } catch (RuntimeException e) {
            log.error("get TExpertREview By jqId,teaCode,declId,type failed" +e);
            throw e;
        }
    }

    public static TExpertReviewDAO getFromApplicationContext(
            ApplicationContext ctx) {
        return (TExpertReviewDAO) ctx.getBean("TExpertReviewDAO");
    }
}
