package edu.cqu.no1.dao;

import edu.cqu.no1.util.PageBean;

import java.util.Date;
import java.util.List;

/**
 * Created by ZKQ on 2015/5/27.
 */
public interface TJournalDAO {
    List findByUserName(Object userName);

    List findByJournalRemark(Object journalRemark);

    List findByIsdeleted(Object isdeleted);

    List findByJournalLoginip(Object journalLoginip);

    List findByQueryString(String queryString);

    //多条件查询获取查询列表
    List findByMultiCondition(String userId, String userName, String journalLoginip, Date journalLogintime, Date journalQuitime, PageBean pageBean);

    //多条件查询获取查询列表长度
    int findByMultiConditionCount(String userId, String userName, String journalLoginip, Date journalLogintime, Date journalQuitime);

    int getAllTJournalCount();

    List findAll(PageBean pageBean);
}
