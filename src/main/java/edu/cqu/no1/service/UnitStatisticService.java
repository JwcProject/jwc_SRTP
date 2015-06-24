package edu.cqu.no1.service;

import edu.cqu.no1.domain.TResultDistribut;
import edu.cqu.no1.util.PageBean;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ZKQ on 2015/6/4.
 */

public interface UnitStatisticService {

    public List unitProjectScore(String unitId, String jqId);

    public List<TResultDistribut> getUnitResultDistribut(String unitId, PageBean pageBean);

    public int getUnitResultDistributCount(String unitId);
}
