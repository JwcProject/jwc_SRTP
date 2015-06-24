package edu.cqu.no1.service;

import edu.cqu.no1.domain.TJieqi;
import edu.cqu.no1.domain.TResultDistribut;
import edu.cqu.no1.util.PageBean;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ZKQ on 2015/6/4.
 */

public interface StatisticService {
    public List SchooleProjectScore(String jqQici);

    // 全校数据指标 数据条数
    public int getSchoolResultDistributCount(String college, String jqYear, String jqQici);

    // 全校数据指标 List
    public List<TResultDistribut> getSchoolResultDistribut(String college, String jqYear, String jqQici, PageBean pageBean);

    // 按期次查看各学院数据
    public List<TResultDistribut> getSchoolStatisticsData(String jqQici);

    // 按学院查看各期次统计数据
    public List<TResultDistribut> getSchoolStatisticDataByCollege(String college);

    // 根据学院名称参数，判断参数是否合法
    public int getCollegeCountByName(String college);

    // 根据届期id获取当前届期信息
    public TJieqi getJieqiById(String id);

    // 获取当前结题届期
    public TJieqi getCurrentJieqi();
}
