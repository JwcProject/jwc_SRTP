package edu.cqu.no1.dao;

import edu.cqu.no1.domain.TTempEmailReciver;

import java.util.List;

/**
 * Created by ZKQ on 2015/5/27.
 */
public interface TTempEmailReciverDAO extends BaseDao<TTempEmailReciver> {
    List findTempEmailReciverByJQid(String jqId);

    @SuppressWarnings("unchecked")
    List<TTempEmailReciver> findTempEmailRecivers(String jqId,
                                                  String teaCode, String type);

    // 通过届期ID和主管教师教职工号查找临时邮件接收人的邮箱
    List findEmailByJQid(String jqId, String teaCode, String type);

    // 通过届期和教师工号得到临时邮件收信人
    TTempEmailReciver findTempEmailReciver(String jqId, String teaCode);

    List findByDepartId(Object departId);

    List findByJqId(Object jqId);

    List findByCode(Object code);

    List findByName(Object name);

    List findByEmail(Object email);

    List findByIsdeleted(Object isdeleted);
}
