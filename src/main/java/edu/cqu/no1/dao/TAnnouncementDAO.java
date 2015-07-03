package edu.cqu.no1.dao;

import edu.cqu.no1.domain.TAnnouncement;
import edu.cqu.no1.util.PageBean;

import java.util.Date;
import java.util.List;

/**
 * Created by ZKQ on 2015/5/27.
 */
public interface TAnnouncementDAO extends BaseDao<TAnnouncement> {

    List findByAnnounTitle(Object announTitle);

    List findByAnnounContent(Object announContent);

    List findByPublisherCode(Object publisherCode);

    List findByPublisherRole(Object publisherRole);

    List findByPublishState(Object publishState);

    List findByCheckerCode(Object checkerCode);

    List findByCheckState(Object checkState);

    List findByIsdeleted(Object isdeleted);




    TAnnouncement findById(String announId);


    List findAnnounByType(String typeName, PageBean pageBean);

    int findAnnounByTypeCount(String typeName);

    //查询主页学校公告
    List findIndexSchoolAnnoument(String announTitle, Date publishTime, String typeName, PageBean pageBean);

    int findIndexSchoolAnnoumentCount(String announTitle, Date publishTime, String typeName);


    List getStuTeatAnnoun(String number, String announName,
                          Date announDate, PageBean pageBean);

    int getStuTeaAnnounCount(String number, String announName,
                             Date announDate);

    List getUnitAnnoun(String teaCode, String announName,
                       Date announDate, PageBean pageBean);

    int getUnitAnnounCount(String teaCode, String announName,
                           Date announDate);

    List getSchoolAnnoun(String announName, String checkState,
                         Date announDate, String publisherName, String typeName,
                         PageBean pageBean);

    int getSchoolAnnounCount(String announName, String checkState,
                             Date announDate, String publisherName, String typeName);


    //查询当前学生所在学院的学院公告
    List getUnitAnnounctmentByStuCode(String unitStuCode, String announTitle, Date publishTime, PageBean pageBean);

    int getUnitAnnounctmentByStuCodeCount(String unitStuCode, String announTitle, Date publishTime);

    //查询普通学生和普通教师的公告
    List getCommonStuAndTeaAnnoun(String announTitle, String announContent, Date publishTime, PageBean pageBean);

    int getCommonStuAndTeaAnnounCount(String announTitle, String announContent, Date publishTime);


}
