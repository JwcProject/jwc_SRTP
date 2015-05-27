package edu.cqu.no1.dao;

import edu.cqu.no1.domain.TTeacher;

import java.util.List;

/**
 * Created by ZKQ on 2015/5/27.
 */
public interface TTeacherDAO extends BaseDao<TTeacher> {
    //通过学院主管教师的id找到本学院所有的教师
    List getTeachers(String code);

    /*
* 得到不是专家教师的教师
* type 为类别，01 为申报的专家教师，02为结题的专家教师
*/
    List getCommonTeachers(String code, String type);

    //多条件查询当前主管教师所在学院的所有教师
    List findTeachers(String teaCode, String teaName, String teaTitle);

    List findTeacherByCode(String code);

    List findByTeaName(Object teaName);

    List findByTeaCode(Object teaCode);

    List findByTeaSex(Object teaSex);

    List findByTeaTitle(Object teaTitle);

    List findByTeaTele(Object teaTele);

    List findByTeaEmail(Object teaEmail);

    List findByTeaState(Object teaState);

    List findByTeaIntro(Object teaIntro);

    List findByTeaRemark(Object teaRemark);

    List findByIsdeleted(Object isdeleted);

    List findTeachersByName(String name);
}
