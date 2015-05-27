package edu.cqu.no1.dao;

import edu.cqu.no1.domain.TExpertLib;
import edu.cqu.no1.util.PageBean;

import java.util.List;

/**
 * Created by ZKQ on 2015/5/27.
 */
public interface TExpertLibDAO {
    List findByIsAssigned(Object isAssigned);

    List findByIsdeleted(Object isdeleted);

    List findByTYPE(Object type);

    @SuppressWarnings("unchecked")
    List<TExpertLib> findExpsByUnitTeaCode(String teaCode, String type, PageBean pageBean);

    int findExpsCountByUnitTeaCode(String teaCode, String type);

    TExpertLib findNowJieQiExpLib(String type);

    List findExpertLibByQici(String jieqiId, String unitId, String type);
}
