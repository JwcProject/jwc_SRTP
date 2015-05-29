package edu.cqu.no1.dao.impl;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;
import edu.cqu.no1.dao.TTempEmailReciverDAO;
import edu.cqu.no1.domain.TTempEmailReciver;
import org.hibernate.Query;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ZKQ on 2015/5/27.
 */

@Repository
public class TTempEmailReciverDAOImpl extends BaseDaoImpl<TTempEmailReciver> implements TTempEmailReciverDAO {

    private static final Logger log = LoggerFactory
            .getLogger(TTempEmailReciverDAO.class);
    // property constants
    public static final String DEPART_ID = "departId";
    public static final String JQ_ID = "jqId";
    public static final String CODE = "code";
    public static final String NAME = "name";
    public static final String EMAIL = "email";
    public static final String ISDELETED = "isdeleted";
    public static final String TYPE="type";


    public List findTempEmailReciverByJQid(String jqId) {
        log.debug("find tempEmailReciver by JQ id");
        try {
            String queryStr = "from TTempEmailReciver t where t.isdeleted = 'N' and t.jqId=:jqId";
            Query query = getSessionFactory().getCurrentSession().createQuery(queryStr);
            query.setString("jqId", jqId);

            return query.list();
        } catch (RuntimeException e) {
            log.error("find tempEmailReciver by JQ id failed", e);
            throw e;
        }
    }

    /**
     *
     *通过届期ID和学院主管教师教职工号获取临时邮件接收人
     *authoy lzh
     *@param jqId
     *@param teaCode
     *@return
     */
    @SuppressWarnings("unchecked")
    public List<TTempEmailReciver> findTempEmailRecivers(String jqId,
                                                         String teaCode, String type) {
        log.debug("find tempEmailRecivers by jieqi Id and teaCode ");
        try {
            String queryStr = "from TTempEmailReciver t where t.isdeleted = 'N' and t.type=:type and t.jqId=:jqId" +
                    " and t.departId=(select TT.unitId from TTeacher TT" +
                    " where TT.isdeleted='N' and TT.teaCode=:code)";
            Query query = getSessionFactory().getCurrentSession().createQuery(queryStr);
            query.setString("jqId", jqId);
            query.setString("type", type);
            query.setString("code", teaCode);
            return query.list();
        } catch (RuntimeException e) {
            log.error("find tempEmailReciver  by jieqi Id and teaCode failed", e);
            throw e;
        }
    }

    // 通过届期ID和主管教师教职工号查找临时邮件接收人的邮箱
    public List findEmailByJQid(String jqId, String teaCode, String type) {
        log.debug("find tempEmailReciver by JQ id and teaCode");
        try {
            String queryStr = "select distinct t.email from TTempEmailReciver t where t.isdeleted = 'N'" +
                    " and t.type=:type and t.jqId=:jqId and t.departId=(select TT.unitId from TTeacher TT" +
                    " where TT.isdeleted='N' and TT.teaCode=:code)";
            Query query = getSessionFactory().getCurrentSession().createQuery(queryStr);
            query.setString("jqId", jqId);
            query.setString("type", type);
            query.setString("code", teaCode);
            return query.list();
        } catch (RuntimeException e) {
            log.error("find tempEmailReciver by JQ id  and teaCode failed", e);
            throw e;
        }
    }

    // 通过届期和教师工号得到临时邮件收信人
    public TTempEmailReciver findTempEmailReciver(String jqId, String teaCode) {
        log.debug("find tempEmailReciver ");
        try {
            String queryStr = "from TTempEmailReciver t where t.isdeleted = 'N' and t.jqId=:jqId and t.code=:teaCode";
            Query query = getSessionFactory().getCurrentSession().createQuery(queryStr);
            query.setString("jqId", jqId);
            query.setString("teaCode", teaCode);
            TTempEmailReciver tTempEmailReciver = null;
            if (null != query.list() && query.list().size() > 0) {
                tTempEmailReciver = (TTempEmailReciver) query.list().get(0);
            }
            return tTempEmailReciver;

        } catch (RuntimeException e) {
            log.error("find tempEmailReciver  failed", e);
            throw e;
        }
    }

    public List findByDepartId(Object departId) {
        return findByProperty(DEPART_ID, departId);
    }

    public List findByJqId(Object jqId) {
        return findByProperty(JQ_ID, jqId);
    }

    public List findByCode(Object code) {
        return findByProperty(CODE, code);
    }

    public List findByName(Object name) {
        return findByProperty(NAME, name);
    }

    public List findByEmail(Object email) {
        return findByProperty(EMAIL, email);
    }

    public List findByIsdeleted(Object isdeleted) {
        return findByProperty(ISDELETED, isdeleted);
    }


    public static TTempEmailReciverDAO getFromApplicationContext(
            ApplicationContext ctx) {
        return (TTempEmailReciverDAO) ctx.getBean("TTempEmailReciverDAO");
    }
}
