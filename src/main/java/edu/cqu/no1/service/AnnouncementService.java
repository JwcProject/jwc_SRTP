package edu.cqu.no1.service;


import edu.cqu.no1.domain.TAnnounType;
import edu.cqu.no1.domain.TAnnouncement;
import edu.cqu.no1.domain.TAttachment;
import edu.cqu.no1.util.PageBean;

import java.util.Date;
import java.util.List;

/**
 * Created by ZKQ on 2015/6/4.
 */

public interface AnnouncementService {

	public TAnnouncement getAnnounById(String id);
	public TAnnouncement addTAnnouncement(TAnnouncement tAnnouncement);
	public TAnnouncement addTAnnouncement(List<TAttachment> attachments, TAnnouncement announcement) throws Exception;
	public void deleteTAnnouncement(String id);
	public void updateTAnnouncement(TAnnouncement tAnnouncement);
	
	public List<TAnnouncement> queryStuTeaAnnoun(String number, String announName, Date announDate, PageBean pageBean);
	public List<TAnnouncement> queryUnitAnnoun(String teaCode, String announName, Date announDate, PageBean pageBean);
	public List<TAnnouncement> querySchoolAnnoun(String announName, String checkState, Date announDate, String publisherName, String typeName, PageBean pageBean);
	
	public int queryStuTeaAnnounCount(String number, String announName, Date announDate);
	public int queryUnitAnnounCount(String teaCode, String announName, Date announDate);
	public int querySchoolAnnounCount(String announName, String checkState, Date announDate, String publisherName, String typeName);
	
	public List<TAnnouncement> getAnnounByType(String typeName, PageBean pageBean);
	public int getAnnounByTypeCount(String typeName);
	
	//查询主页学校公告列表
	public List<TAnnouncement> findIndexSchoolAnnoument(String announTitle, Date publishTime, String typeName, PageBean pageBean);
	public int findIndexSchoolAnnoumentCount(String announTitle, Date publishTime, String typeName);

	/**
	 * lsp  获取公告附件
	 */
	public List<TAttachment> getAttachmentsByAnnounceId(String annouceId);
	public void updateTAnnouncement(List<TAttachment> attachments, TAnnouncement tAnnouncement);
	
	public TAnnounType getTAnnounTypeByName(String announName);
	
	
	//通过当前学生所在学院获取学院公告
	public List<TAnnouncement> getTAnnouncementByStuCode(String stuCode, PageBean pageBean);
	
	//获取普通学生和教师的公告
	public List<TAnnouncement> getCommonStuAndTeaAnnoun(PageBean pageBean);
	
	//查询当前学生所在学院获取学院公告
	public List<TAnnouncement> findTAnnouncementByStuCode(String stuCode, String announTitle, Date publishTime, PageBean pageBean);
	public int findTAnnouncementByStuCodeCount(String stuCode, String announTitle, Date publishTime);
	
	//查询普通学生和教师的公告
	public List<TAnnouncement> findCommonStuAndTeaAnnoun(String announTitle, String announContent, Date publishTime, PageBean pageBean);
	public int findCommonStuAndTeaAnnounCount(String announTitle, String announContent, Date publishTime);
}
