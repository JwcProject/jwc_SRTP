package com.isse.serviceImpl;


import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.isse.dao.TAnnounTypeDAO;
import com.isse.dao.TAnnouncementDAO;
import com.isse.dao.TAttachmentDAO;
import com.isse.dao.TAttchmentTypeDAO;
import com.isse.model.TAnnounType;
import com.isse.model.TAnnouncement;
import com.isse.model.TAnnouncementModel;
import com.isse.model.TAttachment;
import com.isse.model.TAttchmentType;
import com.isse.model.TJieqi;
import com.isse.model.TTempEmailReciver;
import com.isse.model.TUser;
import com.isse.service.AnnouncementService;
import com.util.PageBean;

/**
 * @Create Date：2013-7-22下午03:02:49
 * @Update Date：
 * @Author：lzh
 * TODO
 */
public class AnnouncementServiceImpl implements AnnouncementService{
	
	private TAnnouncementDAO tAnnouncementDAO;
	private TAttachmentDAO attachmentDAO;
	private TAttchmentTypeDAO tAttchmentTypeDAO;
	private TAnnounTypeDAO tAnnounTypeDAO;
	
	
	public TAnnounType getTAnnounTypeByName(String announName)
	{
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
	@SuppressWarnings("unchecked")
	@Override
	public List<TAnnouncementModel> listStuTeaAnnouncements(String code, PageBean pageBean) {
		return this.tAnnouncementDAO.getStuTeaAnnounctment(code, pageBean);
	}
	
	@Override
	public int getStuTeaAnnouncementCount(String code) {
		return this.tAnnouncementDAO.getStuTeaAnnouncementCount(code);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TAnnouncementModel> listUnitAnnouncements(String unitTeaCode,
			PageBean pageBean) {
		return this.tAnnouncementDAO.getUnitAnnounctment(unitTeaCode, pageBean);
	}

	@Override
	public int getUnitAnnouncementCount(String unitTeaCode) {
		return this.tAnnouncementDAO.getUnitAnnounctmentCount(unitTeaCode);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TAnnouncementModel> listSchoolAnnouncements(PageBean pageBean) {
		return this.tAnnouncementDAO.getSchoolAnnounctment(pageBean);
	}

	@Override
	public int getSchoolAnnouncementCount() {
		return this.tAnnouncementDAO.getSchoolAnnounctmentCount();
	}

	@Override
	public TAnnouncement getAnnouncement(String id) {
		return this.tAnnouncementDAO.findById(id);
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
		TAnnouncement tAnnouncement = this.getAnnouncement(id);
		tAnnouncement.setIsdeleted("Y");
		this.updateTAnnouncement(tAnnouncement);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TAnnouncementModel> queryStuTeaAnnoun(String number,
			String announName, Date announDate, PageBean pageBean) {
		return this.tAnnouncementDAO.findStuTeatAnnoun(number, announName, announDate, pageBean);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TAnnouncementModel> queryUnitAnnoun(String teaCode,
			String announName, Date announDate, PageBean pageBean) {
		return this.tAnnouncementDAO.findUnitAnnoun(teaCode, announName, announDate, pageBean);
	}

	/* (non-Javadoc)
	 * @see com.isse.service.AnnouncementService#querySchoolAnnoun(java.lang.String, java.sql.Date, java.lang.String, java.lang.String, com.util.PageBean)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<TAnnouncementModel> querySchoolAnnoun(String announName,String checkState,
			Date announDate, String publisherName, String typeName,
			PageBean pageBean) {
		return this.tAnnouncementDAO.findSchoolAnnoun(announName,checkState, announDate, publisherName, typeName, pageBean);
	}

	/* (non-Javadoc)
	 * @see com.isse.service.AnnouncementService#queryStuTeaAnnounCount(java.lang.String, java.lang.String, java.sql.Date)
	 */
	@Override
	public int queryStuTeaAnnounCount(String number, String announName,
			Date announDate) {
		return this.tAnnouncementDAO.findStuTeaAnnounCount(number, announName, announDate);
	}

	/* (non-Javadoc)
	 * @see com.isse.service.AnnouncementService#queryUnitAnnounCount(java.lang.String, java.lang.String, java.sql.Date)
	 */
	@Override
	public int queryUnitAnnounCount(String teaCode, String announName,
			Date announDate) {
		return this.tAnnouncementDAO.findUnitAnnounCount(teaCode, announName, announDate);
	}

	/* (non-Javadoc)
	 * @see com.isse.service.AnnouncementService#querySchoolAnnounCount(java.lang.String, java.sql.Date, java.lang.String, java.lang.String)
	 */
	@Override
	public int querySchoolAnnounCount(String announName,String checkState, Date announDate,
			String publisherName, String typeName) {
		return this.tAnnouncementDAO.findSchoolAnnounCount(announName, checkState, announDate, publisherName, typeName);
	}
	
	/* (non-Javadoc)
	 * @see com.isse.service.AnnouncementService#getAnnounByType(java.lang.String, com.util.PageBean)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<TAnnouncementModel> getAnnounByType(String typeName,
			PageBean pageBean) {
		return this.tAnnouncementDAO.findAnnounByType(typeName, pageBean);
	}

	/* (non-Javadoc)
	 * @see com.isse.service.AnnouncementService#getAnnounByTypeCount(java.lang.String)
	 */
	@Override
	public int getAnnounByTypeCount(String typeName) {
		return this.tAnnouncementDAO.findAnnounByTypeCount(typeName);
	}
	
	//通过当前学生所在学院获取学院公告
	public List<TAnnouncement> getTAnnouncementByStuCode(String stuCode, PageBean pageBean)
	{
		return this.tAnnouncementDAO.getUnitAnnounctmentByStuCode(stuCode, pageBean);
	}
	
	public int getTAnnouncementByStuCodeCount(String stuCode)
	{
		return this.tAnnouncementDAO.getUnitAnnounctmentByStuCodeCount(stuCode);
	}
	
	//获取普通学生和教师的公告
	public List<TAnnouncement> getCommonStuAndTeaAnnoun(PageBean pageBean)
	{
		return this.tAnnouncementDAO.getCommonStuAndTeaAnnoun(pageBean);
	}
	
	public int getCommonStuAndTeaAnnounCount()
	{
		return this.tAnnouncementDAO.getCommonStuAndTeaAnnounCount();
	}
	
	//查询当前学生所在学院获取学院公告
	public List<TAnnouncement> findTAnnouncementByStuCode (String stuCode, String announTitle, Date publishTime, PageBean pageBean)
	{
		return this.tAnnouncementDAO.findUnitAnnounctmentByStuCode(stuCode, announTitle, publishTime, pageBean);
	}
	public int findTAnnouncementByStuCodeCount(String stuCode, String announTitle, Date publishTime)
	{
		return this.tAnnouncementDAO.findUnitAnnounctmentByStuCodeCount(stuCode, announTitle, publishTime);
	}
	
	//查询普通学生和教师的公告
	public List<TAnnouncement> findCommonStuAndTeaAnnoun(String announTitle, String announContent, Date publishTime, PageBean pageBean)
	{
		return this.tAnnouncementDAO.findCommonStuAndTeaAnnoun(announTitle, announContent, publishTime, pageBean);
	}
	public int findCommonStuAndTeaAnnounCount(String announTitle, String announContent, Date publishTime)
	{
		return this.tAnnouncementDAO.findCommonStuAndTeaAnnounCount(announTitle, announContent, publishTime);
	}
	
	//查询主页学校公告列表
	public List<TAnnouncementModel> findIndexSchoolAnnoument(String announTitle, Date publishTime, String typeName, PageBean pageBean)
	{
		return this.tAnnouncementDAO.findIndexSchoolAnnoument(announTitle, publishTime, typeName, pageBean);
	}
	public int findIndexSchoolAnnoumentCount(String announTitle, Date publishTime, String typeName)
	{
		return this.tAnnouncementDAO.findIndexSchoolAnnoumentCount(announTitle, publishTime, typeName);
	}
	/******************************************
	 * set and get methods
	 *****************************************/
	public TAnnouncementDAO gettAnnouncementDAO() {
		return tAnnouncementDAO;
	}

	public void settAnnouncementDAO(TAnnouncementDAO tAnnouncementDAO) {
		this.tAnnouncementDAO = tAnnouncementDAO;
	}

	/* (non-Javadoc)
	 * @see com.isse.service.AnnouncementService#getAnnounById(java.lang.String)
	 */
	@Override
	public TAnnouncementModel getAnnounById(String announId) {
		return this.tAnnouncementDAO.getAnnounById(announId);
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
