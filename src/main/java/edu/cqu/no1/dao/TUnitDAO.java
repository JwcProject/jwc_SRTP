package edu.cqu.no1.dao;

import edu.cqu.no1.domain.TUnit;

import java.util.List;

/**
 * Created by ZKQ on 2015/5/27.
 */
public interface TUnitDAO {
    List findByUnitName(Object unitName);

    List findByUnitType(Object unitType);

    List findByUnitFatherid(Object unitFatherid);

    List findByUnitCode(Object unitCode);

    List findByUnitRemark(Object unitRemark);

    List findByIsdeleted(Object isdeleted);

    TUnit getUnitByTeacherId(String teaId);

    List getAllColleges();
}
