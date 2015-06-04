package edu.cqu.no1.service.impl;

import edu.cqu.no1.dao.UnitStatisticDAO;
import edu.cqu.no1.domain.TResultDistribut;
import edu.cqu.no1.service.UnitStatisticService;
import edu.cqu.no1.util.PageBean;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ZKQ on 2015/6/4.
 */

@Service
public class UnitStatisticServiceImpl implements UnitStatisticService {

    private UnitStatisticDAO unitStatisticDAO;

    @Override
    public List unitProjectScore(String unitId, String jqId) {
        // TODO Auto-generated method stub
        return this.unitStatisticDAO.unitProjectScore(unitId, jqId);
    }

    @Override
    public List<TResultDistribut> getUnitResultDistribut(String unitId, PageBean pageBean) {
        // TODO Auto-generated method stub
        return this.unitStatisticDAO.getUnitResultDistribut(unitId, pageBean);
    }

    @Override
    public int getUnitResultDistributCount(String unitId) {
        // TODO Auto-generated method stub
        return this.unitStatisticDAO.getUnitResultDistributCount(unitId);
    }

    public UnitStatisticDAO getUnitStatisticDAO() {
        return unitStatisticDAO;
    }

    public void setUnitStatisticDAO(UnitStatisticDAO unitStatisticDAO) {
        this.unitStatisticDAO = unitStatisticDAO;
    }


}
