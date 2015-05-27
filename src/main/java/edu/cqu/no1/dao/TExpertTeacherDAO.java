package edu.cqu.no1.dao;

import edu.cqu.no1.domain.TExpertLib;
import edu.cqu.no1.domain.TExpertTeacher;
import edu.cqu.no1.util.PageBean;

import java.util.List;

/**
 * Created by ZKQ on 2015/5/27.
 */
public interface TExpertTeacherDAO {
    List findByIsdeleted(Object isdeleted);

    //根据届期id，专家库类型，获取专家库
    List<TExpertLib> findExpertLibByJqid(String jqId, String type);

    //根据届期id，专家库类型，登陆教师ID，获取本学院专家库
    List<TExpertLib> findUnitExpertLibByJqid(String jqId, String type, String teacherCode);

    //通过单个老师的id找到最近的专家教师对象
    TExpertTeacher getExpertTeachersByTeaId(String teaId, String type);

    //通过届期找到对应的专家教师
    List findExpertTeachersByJQid(String jqId);

    //获取本届期已经分配的专家教师
    List findAssignedExpertTeachers(String jqId, String type, String teaCode);

    //通过专家库id得到专家教师
    List getExpetTeachersByExpertLib(String libId);

    List findExpTeaByExpLibId(String expLibId, PageBean pageBean);

    int findExpTeaCountByExpLibId(String expLibId);

    List findExpTeaByExpLibId(String expLibId);

    //修改评审教师的用户类型
    void changeReviewUserType(String libId);

    TExpertTeacher findExpTeaByCode(String teaCode);

    int getExpTeaCountByQici(String jieqiId, String type);

    List getExpertTeachersByQici(String jieqiId,
                                 String type, PageBean pageBean);
}
