package edu.cqu.no1.dao;

import java.util.List;

/**
 * Created by ZKQ on 2015/5/27.
 */
public interface TAttachmentDAO {
    List findAttachsByEndProId(String endproId);

    List findByFileName(Object fileName);

    List findByFileFormat(Object fileFormat);

    List findByFileUrl(Object fileUrl);

    List findByUploaderCode(Object uploaderCode);

    List findByUploaderRole(Object uploaderRole);

    List findByObjectCode(Object objectCode);

    List findByIsdeleted(Object isdeleted);

    void deleteTAttachmentsByObjectCode(String objectId);
}
