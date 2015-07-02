package edu.cqu.no1.dao;

import edu.cqu.no1.domain.TJieqi;
import edu.cqu.no1.domain.TResultDistribut;
import edu.cqu.no1.util.PageBean;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ZKQ on 2015/5/27.
 */

public interface StatisticDAO extends BaseDao{
    // 全校项目成绩分布统计
    List SchooleProjectScore(String jqQici);

    // 全校数据指标 数据条数
    int getSchoolResultDistributCount(String college, String jqYear, String jqQici);

    // 全校数据指标 List
    List<TResultDistribut> getSchoolResultDistribut(String college, String jqYear, String jqQici, PageBean pageBean);

    // 按期次查看各学院数据
    List<TResultDistribut> getSchoolStatisticsData(String jqQici);

    // 按学院查看各期次统计数据
    List<TResultDistribut> getSchoolStatisticDataByCollege(String college);

    // 根据学院名称参数，判断参数是否合法
    int getCollegeCountByName(String college);

    // 根据届期id获取当前届期信息
    TJieqi getJieqiById(String id);

    // 获取当前结题届期id
    TJieqi getCurrentJieqi();
}
