package edu.cqu.no1.service;

import edu.cqu.no1.domain.TJieqi;
import edu.cqu.no1.util.PageBean;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;


/**
 * Created by ZKQ on 2015/6/4.
 */

public interface JieQiService {


    public TJieqi findTJieqiByQici(String qici);

    // 获取当前申报届期
    public TJieqi findDeclJieQiNow();

    // 获取当前结题届期
    public TJieqi findEndJieQiNow();

    public List<BigDecimal> findUnassignYears();

    public TJieqi findTjieqiById(String id);

    public List<TJieqi> findAllJieqis(String jqName, String jqYear, String jqQici, PageBean pageBean);

    public int findAllJieqicount(String jqName, String jqYear, String jqQici);

    public void addJieqi(TJieqi jieqi);

    public void updateJieqi(TJieqi jieqi);

    public void deleteJieqi(String jieqiId);

    public List<BigDecimal> findAllYears();

    public List<TJieqi> findJieqiByYear(String year);
}
