package edu.cqu.no1.dao;

import edu.cqu.no1.domain.TProfession;

import java.util.List;

/**
 * Created by ZKQ on 2015/5/27.
 */
public interface TProfessionDAO extends BaseDao<TProfession> {
    //根据学院主管教师的工号获取该学院所有专业列表
    List findProfessionsByTeaCode(String teaCode);

    @SuppressWarnings("unchecked")
    List<TProfession> getProfessionsByTeacherId(String teacherId);

    List findByProfessionName(Object professionName);

    List findByProfessionSession(Object professionSession);

    List findByProfessionClass(Object professionClass);

    List findByProfessionRemark(Object professionRemark);

    List findByProfessionIsdeleted(Object professionIsdeleted);
}
