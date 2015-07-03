package edu.cqu.no1.service.impl;


import java.util.Date;
import java.util.List;

import edu.cqu.no1.dao.TAnnounTypeDAO;
import edu.cqu.no1.dao.TAnnouncementDAO;
import edu.cqu.no1.dao.TAttachmentDAO;
import edu.cqu.no1.dao.TAttchmentTypeDAO;
import edu.cqu.no1.domain.*;
import edu.cqu.no1.service.AnnouncementService;
import edu.cqu.no1.util.PageBean;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * Created by ZKQ on 2015/6/4.
 */

@Service
public class AnnouncementServiceImpl implements AnnouncementService {

    @Resource
    private TAnnouncementDAO tAnnouncementDAO;
    @Resource
    private TAttachmentDAO attachmentDAO;
    @Resource
    private TAttchmentTypeDAO tAttchmentTypeDAO;
    @Resource
    private TAnnounTypeDAO tAnnounTypeDAO;


    public TAnnounType getTAnnounTypeByName(String announName) {
        return this.tAnnounTypeDAO.findByAnnounName(announName);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<TAttachment> getAttachmentsByAnnounceId(String annouceId) {
        return this.attachmentDAO.findByObjectCode(annouceId);
    }

    @Override
    public TAnnouncement addTAnnouncement(List<TAttachment> attachments,
                                          TAnnouncement announcement) throws Exception {
        Session session = this.tAnnouncementDAO.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {
            transaction.begin();
            this.tAnnouncementDAO.save(announcement);
            TAttchmentType tAttchmentType = this.tAttchmentTypeDAO.findById("2");
            for (TAttachment tAttachment : attachments) {
                tAttachment.setTAttchmentType(tAttchmentType);
                tAttachment.setObjectCode(announcement.getAnnounId());
                this.attachmentDAO.save(tAttachment);
            }
            transaction.commit();
            return announcement;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            throw e;
//			return null;
        }
    }


    @Override
    public TAnnouncement addTAnnouncement(TAnnouncement tAnnouncement) {
        this.tAnnouncementDAO.save(tAnnouncement);
        return tAnnouncement;
    }

    @Override
    public void updateTAnnouncement(TAnnouncement tAnnouncement) {
        this.tAnnouncementDAO.merge(tAnnouncement);
    }

    @Override
    public void updateTAnnouncement(List<TAttachment> attachments,
                                    TAnnouncement tAnnouncement) {
        Session session = this.tAnnouncementDAO.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {
            transaction.begin();
            TAttchmentType tAttchmentType = this.tAttchmentTypeDAO.findById("2");
            this.attachmentDAO.deleteTAttachmentsByObjectCode(tAnnouncement.getAnnounId());
            for (TAttachment tAttachment : attachments) {
                tAttachment.setTAttchmentType(tAttchmentType);
                tAttachment.setObjectCode(tAnnouncement.getAnnounId());
                this.attachmentDAO.save(tAttachment);
            }
            this.tAnnouncementDAO.merge(tAnnouncement);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    @Override
    public void deleteTAnnouncement(String id) {
        TAnnouncement tAnnouncement = tAnnouncementDAO.findById(id);
        tAnnouncement.setIsdeleted("Y");
        this.updateTAnnouncement(tAnnouncement);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<TAnnouncement> queryStuTeaAnnoun(String number,
                                                      String announName, Date announDate, PageBean pageBean) {
        return this.tAnnouncementDAO.getStuTeatAnnoun(number, announName, announDate, pageBean);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<TAnnouncement> queryUnitAnnoun(String teaCode,
                                                    String announName, Date announDate, PageBean pageBean) {
        return this.tAnnouncementDAO.getUnitAnnoun(teaCode, announName, announDate, pageBean);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<TAnnouncement> querySchoolAnnoun(String announName, String checkState,
                                                      Date announDate, String publisherName, String typeName,
                                                      PageBean pageBean) {
        return this.tAnnouncementDAO.getSchoolAnnoun(announName, checkState, announDate, publisherName, typeName, pageBean);
    }

    @Override
    public int queryStuTeaAnnounCount(String number, String announName,
                                      Date announDate) {
        return this.tAnnouncementDAO.getStuTeaAnnounCount(number, announName, announDate);
    }

    @Override
    public int queryUnitAnnounCount(String teaCode, String announName,
                                    Date announDate) {
        return this.tAnnouncementDAO.getUnitAnnounCount(teaCode, announName, announDate);
    }

    @Override
    public int querySchoolAnnounCount(String announName, String checkState, Date announDate,
                                      String publisherName, String typeName) {
        return this.tAnnouncementDAO.getSchoolAnnounCount(announName, checkState, announDate, publisherName, typeName);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<TAnnouncement> getAnnounByType(String typeName,
                                                    PageBean pageBean) {
        return this.tAnnouncementDAO.findAnnounByType(typeName, pageBean);
    }

    @Override
    public int getAnnounByTypeCount(String typeName) {
        return this.tAnnouncementDAO.findAnnounByTypeCount(typeName);
    }


    //通过当前学生所在学院获取学院公告
    @Override
    public List<TAnnouncement> getTAnnouncementByStuCode(String stuCode, PageBean pageBean) {
        return this.tAnnouncementDAO.getUnitAnnounctmentByStuCode(stuCode, null, null, pageBean);
    }


    //获取普通学生和教师的公告
    @Override
    public List<TAnnouncement> getCommonStuAndTeaAnnoun(PageBean pageBean) {
        return this.tAnnouncementDAO.getCommonStuAndTeaAnnoun(null, null, null, pageBean);
    }


    //查询当前学生所在学院获取学院公告
    @Override
    public List<TAnnouncement> findTAnnouncementByStuCode(String stuCode, String announTitle, Date publishTime, PageBean pageBean) {
        return this.tAnnouncementDAO.getUnitAnnounctmentByStuCode(stuCode, announTitle, publishTime, pageBean);
    }

    @Override
    public int findTAnnouncementByStuCodeCount(String stuCode, String announTitle, Date publishTime) {
        return this.tAnnouncementDAO.getUnitAnnounctmentByStuCodeCount(stuCode, announTitle, publishTime);
    }

    //查询普通学生和教师的公告
    @Override
    public List<TAnnouncement> findCommonStuAndTeaAnnoun(String announTitle, String announContent, Date publishTime, PageBean pageBean) {
        return this.tAnnouncementDAO.getCommonStuAndTeaAnnoun(announTitle, announContent, publishTime, pageBean);
    }

    @Override
    public int findCommonStuAndTeaAnnounCount(String announTitle, String announContent, Date publishTime) {
        return this.tAnnouncementDAO.getCommonStuAndTeaAnnounCount(announTitle, announContent, publishTime);
    }

    //查询主页学校公告列表
    @Override
    public List<TAnnouncement> findIndexSchoolAnnoument(String announTitle, Date publishTime, String typeName, PageBean pageBean) {
        return this.tAnnouncementDAO.findIndexSchoolAnnoument(announTitle, publishTime, typeName, pageBean);
    }

    @Override
    public int findIndexSchoolAnnoumentCount(String announTitle, Date publishTime, String typeName) {
        return this.tAnnouncementDAO.findIndexSchoolAnnoumentCount(announTitle, publishTime, typeName);
    }

    @Override
    public TAnnouncement getAnnounById(String announId) {
        return this.tAnnouncementDAO.findById(announId);
    }


    /**
     * ***************************************
     * set and get methods
     * ***************************************
     */
    public TAnnouncementDAO gettAnnouncementDAO() {
        return tAnnouncementDAO;
    }

    public void settAnnouncementDAO(TAnnouncementDAO tAnnouncementDAO) {
        this.tAnnouncementDAO = tAnnouncementDAO;
    }


    public TAttachmentDAO getAttachmentDAO() {
        return attachmentDAO;
    }

    public void setAttachmentDAO(TAttachmentDAO attachmentDAO) {
        this.attachmentDAO = attachmentDAO;
    }

    public TAttchmentTypeDAO gettAttchmentTypeDAO() {
        return tAttchmentTypeDAO;
    }

    public void settAttchmentTypeDAO(TAttchmentTypeDAO tAttchmentTypeDAO) {
        this.tAttchmentTypeDAO = tAttchmentTypeDAO;
    }

    public TAnnounTypeDAO gettAnnounTypeDAO() {
        return tAnnounTypeDAO;
    }

    public void settAnnounTypeDAO(TAnnounTypeDAO tAnnounTypeDAO) {
        this.tAnnounTypeDAO = tAnnounTypeDAO;
    }


}
