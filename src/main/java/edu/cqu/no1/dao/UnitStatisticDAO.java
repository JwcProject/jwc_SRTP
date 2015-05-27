package edu.cqu.no1.dao;

import edu.cqu.no1.domain.ResultDistribut;
import edu.cqu.no1.util.PageBean;

import java.util.List;

/**
 * Created by ZKQ on 2015/5/27.
 */
public interface UnitStatisticDAO extends BaseDao {
    //获取学院项目成绩分布统计
    List unitProjectScore(String unitId, String jqId);

    List<ResultDistribut> getUnitResultDistribut(String unitId, PageBean pageBean);

    int getUnitResultDistributCount(String unitId);
}
