package edu.cqu.no1.dao;

import edu.cqu.no1.util.PageBean;

import java.util.Date;
import java.util.List;

/**
 * Created by ZKQ on 2015/5/27.
 */
public interface TJournalActDAO {
    int getAllTJournalActCount();

    List findAll(PageBean pageBean);

    //多条件查询获取查询列表
    List findByMultiCondition(String userId, String journalactType, String journalactIntroduction, Date time, PageBean pageBean);

    //多条件查询获取查询列表长度
    int findByMultiConditionCount(String userId, String journalactType, String journalactIntroduction, Date time);

    List findByJournalactType(Object journalactType);

    List findByJournalactIntroduction(Object journalactIntroduction);

    List findByJournalactRemark(Object journalactRemark);

    List findByIsdeleted(Object isdeleted);

    List findByUserId(Object userId);
}
