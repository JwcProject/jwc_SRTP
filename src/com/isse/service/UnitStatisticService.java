package com.isse.service;

import java.util.List;

import com.isse.model.ResultDistribut;
import com.util.PageBean;

public interface UnitStatisticService {
	
	public List unitProjectScore(String unitId, String jqId);
	public List<ResultDistribut> getUnitResultDistribut(String unitId,PageBean pageBean);
	public int getUnitResultDistributCount(String unitId);
}
