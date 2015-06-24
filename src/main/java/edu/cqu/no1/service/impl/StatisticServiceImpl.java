package edu.cqu.no1.service.impl;

import edu.cqu.no1.dao.StatisticDAO;
import edu.cqu.no1.domain.TJieqi;
import edu.cqu.no1.domain.TResultDistribut;
import edu.cqu.no1.service.StatisticService;
import edu.cqu.no1.util.PageBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ZKQ on 2015/6/4.
 */

@Service
public class StatisticServiceImpl implements StatisticService {

    @Resource
    private StatisticDAO statisticDAO;

    // 全校项目成绩分布统计
    @Override
    public List SchooleProjectScore(String jqQici) {

        return statisticDAO.SchooleProjectScore(jqQici);
    }

    // 全校数据指标 数据条数
    public int getSchoolResultDistributCount(String college, String jqYear, String jqQici) {
        return statisticDAO.getSchoolResultDistributCount(college, jqYear, jqQici);
    }

    // 全校数据指标 List
    public List<TResultDistribut> getSchoolResultDistribut(String college, String jqYear, String jqQici, PageBean pageBean) {
        return statisticDAO.getSchoolResultDistribut(college, jqYear, jqQici, pageBean);
    }

    // 按期次查看各学院数据
    public List<TResultDistribut> getSchoolStatisticsData(String jqQici) {
        return statisticDAO.getSchoolStatisticsData(jqQici);
    }

    // 按学院查看各期次统计数据
    public List<TResultDistribut> getSchoolStatisticDataByCollege(String college) {
        return statisticDAO.getSchoolStatisticDataByCollege(college);
    }


    // 根据学院名称参数，判断参数是否合法
    public int getCollegeCountByName(String college) {
        return statisticDAO.getCollegeCountByName(college);
    }

    // 根据届期id获取当前届期信息
    public TJieqi getJieqiById(String id) {
        return statisticDAO.getJieqiById(id);
    }

    // 获取当前结题届期
    public TJieqi getCurrentJieqi() {
        return statisticDAO.getCurrentJieqi();
    }

    public StatisticDAO getStatisticDAO() {
        return statisticDAO;
    }

    public void setStatisticDAO(StatisticDAO statisticDAO) {
        this.statisticDAO = statisticDAO;
    }


}
