package com.isse.serviceImpl;

import java.util.List;

import com.isse.dao.UnitStatisticDAO;
import com.isse.model.ResultDistribut;
import com.util.PageBean;

public class UnitStatisticServiceImpl implements
		com.isse.service.UnitStatisticService {

	private UnitStatisticDAO unitStatisticDAO;
	@Override
	public List unitProjectScore(String unitId,String jqId) {
		// TODO Auto-generated method stub
		return this.unitStatisticDAO.unitProjectScore(unitId,jqId);
	}
	
	@Override
	public List<ResultDistribut> getUnitResultDistribut(String unitId,PageBean pageBean) {
		// TODO Auto-generated method stub
		return this.unitStatisticDAO.getUnitResultDistribut(unitId,pageBean);
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
