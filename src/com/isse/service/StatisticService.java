package com.isse.service;

import java.util.List;

import com.isse.model.ResultDistribut;
import com.isse.model.TJieqi;
import com.util.PageBean;

public interface StatisticService 
{
	public List SchooleProjectScore(String jqQici);
	
	// 全校数据指标 数据条数
	public int getSchoolResultDistributCount(String college, String jqYear, String jqQici);
	// 全校数据指标 List
	public List<ResultDistribut> getSchoolResultDistribut(String college, String jqYear,String jqQici,PageBean pageBean);

	// 按期次查看各学院数据
	public List<ResultDistribut> getSchoolStatisticsData(String jqQici);
	
	// 按学院查看各期次统计数据
	public List<ResultDistribut> getSchoolStatisticDataByCollege(String college);
	
	// 根据学院名称参数，判断参数是否合法
	public int getCollegeCountByName(String college);
	
	// 根据届期id获取当前届期信息
	public TJieqi getJieqiById(String id);
	
	// 获取当前结题届期
	public TJieqi getCurrentJieqi();
}
