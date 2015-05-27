package edu.cqu.no1.dao.impl;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;
import edu.cqu.no1.dao.*;
import edu.cqu.no1.domain.TAttachment;
import org.hibernate.Query;
import org.springframework.context.ApplicationContext;

import java.util.List;

/**
 * Created by ZKQ on 2015/5/27.
 */
public class TAttachmentDAOImpl extends BaseDaoImpl<TAttachment> implements edu.cqu.no1.dao.TAttachmentDAO {
    private static final Logger log = LoggerFactory
            .getLogger(TAttachmentDAO.class);
    // property constants
    public static final String FILE_NAME = "fileName";
    public static final String FILE_FORMAT = "fileFormat";
    public static final String FILE_URL = "fileUrl";
    public static final String UPLOADER_CODE = "uploaderCode";
    public static final String UPLOADER_ROLE = "uploaderRole";
    public static final String OBJECT_CODE = "objectCode";
    public static final String ISDELETED = "isdeleted";


    /**
     *
     *TODO 根据结题ID 获取附件
     *authoy lzh
     *@param endproId
     *@return
     */
    @Override
    public List findAttachsByEndProId(String endproId){
        log.debug("find attachments by endproject id");
        try {
            String queryString = "From TAttachment T where T.isdeleted='N' and T.objectCode=:id";
            Query query = getSessionFactory().getCurrentSession().createQuery(queryString);
            query.setString("id", endproId);
            return query.list();
        } catch (RuntimeException e) {
            log.error("find attachments by endproject id failed"+e);
            throw e;
        }
    }

    @Override
    public List findByFileName(Object fileName) {
        return findByProperty(FILE_NAME, fileName);
    }

    @Override
    public List findByFileFormat(Object fileFormat) {
        return findByProperty(FILE_FORMAT, fileFormat);
    }

    @Override
    public List findByFileUrl(Object fileUrl) {
        return findByProperty(FILE_URL, fileUrl);
    }

    @Override
    public List findByUploaderCode(Object uploaderCode) {
        return findByProperty(UPLOADER_CODE, uploaderCode);
    }

    @Override
    public List findByUploaderRole(Object uploaderRole) {
        return findByProperty(UPLOADER_ROLE, uploaderRole);
    }

    @Override
    public List findByObjectCode(Object objectCode) {
        return findByProperty(OBJECT_CODE, objectCode);
    }

    @Override
    public List findByIsdeleted(Object isdeleted) {
        return findByProperty(ISDELETED, isdeleted);
    }

    public static TAttachmentDAO getFromApplicationContext(
            ApplicationContext ctx) {
        return (TAttachmentDAO) ctx.getBean("TAttachmentDAO");
    }
    @Override
    public void deleteTAttachmentsByObjectCode(String objectId){
        log.debug("deleteTAttachmentsByObjectCode");
        try {
            String hql = "update TAttachment set isdeleted='Y' where objectCode=?";
            Query query = getSessionFactory().getCurrentSession().createQuery(hql);
            query.setString(0, objectId);
            query.executeUpdate();
            log.debug("deleteTAttachmentsByObjectCode successful");
        } catch (RuntimeException re) {
            log.error("deleteTAttachmentsByObjectCode failed", re);
            throw re;
        }
    }
}
