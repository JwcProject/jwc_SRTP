package edu.cqu.no1.dao;

import edu.cqu.no1.domain.TAnnouncement;
import edu.cqu.no1.domain.TAnnouncementModel;
import edu.cqu.no1.util.PageBean;

import java.util.Date;
import java.util.List;

/**
 * Created by ZKQ on 2015/5/27.
 */
public interface TAnnouncementDAO extends BaseDao<TAnnouncement>{

    List findByAnnounTitle(Object announTitle);

    List findByAnnounContent(Object announContent);

    List findByPublisherCode(Object publisherCode);

    List findByPublisherRole(Object publisherRole);

    List findByPublishState(Object publishState);

    List findByCheckerCode(Object checkerCode);

    List findByCheckState(Object checkState);

    List findByIsdeleted(Object isdeleted);

    TAnnouncementModel getAnnounById(String announId);

    List findStuTeatAnnoun(String number, String announName,
                           Date announDate, PageBean pageBean);

    int findStuTeaAnnounCount(String number, String announName,
                              Date announDate);

    List findUnitAnnoun(String teaCode, String announName,
                        Date announDate, PageBean pageBean);

    int findUnitAnnounCount(String teaCode, String announName,
                            Date announDate);

    List findSchoolAnnoun(String announName, String checkState,
                          Date announDate, String publisherName, String typeName,
                          PageBean pageBean);

    int findSchoolAnnounCount(String announName, String checkState,
                              Date announDate, String publisherName, String typeName);

    List getStuTeaAnnounctment(String code, PageBean pageBean);

    int getStuTeaAnnouncementCount(String code);

    List getUnitAnnounctment(String unitTeaCode, PageBean pageBean);

    int getUnitAnnounctmentCount(String unitTeaCode);

    //通过当前学生所在学院获取学院公告
    List getUnitAnnounctmentByStuCode(String unitStuCode, PageBean pageBean);

    int getUnitAnnounctmentByStuCodeCount(String unitStuCode);

    //查询当前学生所在学院的学院公告
    List findUnitAnnounctmentByStuCode(String unitStuCode, String announTitle, Date publishTime, PageBean pageBean);

    int findUnitAnnounctmentByStuCodeCount(String unitStuCode, String announTitle, Date publishTime);

    //获取普通学生和普通教师的公告
    List getCommonStuAndTeaAnnoun(PageBean pageBean);

    int getCommonStuAndTeaAnnounCount();

    //查询普通学生和普通教师的公告
    List findCommonStuAndTeaAnnoun(String announTitle, String announContent, Date publishTime, PageBean pageBean);

    int findCommonStuAndTeaAnnounCount(String announTitle, String announContent, Date publishTime);

    List getSchoolAnnounctment(PageBean pageBean);

    int getSchoolAnnounctmentCount();

    List findAnnounByType(String typeName, PageBean pageBean);

    int findAnnounByTypeCount(String typeName);

    //查询主页学校公告
    List findIndexSchoolAnnoument(String announTitle, Date publishTime, String typeName, PageBean pageBean);

    int findIndexSchoolAnnoumentCount(String announTitle, Date publishTime, String typeName);

}
