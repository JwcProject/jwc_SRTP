package edu.cqu.no1.dao;

import edu.cqu.no1.domain.TJieqi;
import edu.cqu.no1.util.PageBean;

import java.util.List;

/**
 * Created by ZKQ on 2015/5/27.
 */
public interface TJieqiDAO {
    List findByJqName(Object jqName);

    List findByQici(Object qici);

    List findBySecondaryAssessment(Object secondaryAssessment);

    List findBySecondaryRespondent(Object secondaryRespondent);

    List findByIsdeleted(Object isdeleted);

    TJieqi getJieqiNow();

    // 获取当前结题届期
    TJieqi getCurrentJieqi();

    List getJieqiByYear(String year);

    List findAllYears();

    //获取未分派的专家库的年份
    List findUnassignYears();

    List findAllJieqis(String jqName, String jqYear, String jqQici, PageBean pageBean);

    int findAllJieqisCount(String jqName, String jqYear, String jqQici);
}
