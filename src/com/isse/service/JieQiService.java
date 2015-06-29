/**
 * 
 */
package com.isse.service;

import java.math.BigDecimal;
import java.util.List;

import com.isse.model.TJieqi;
import com.util.PageBean;

/**
 * @author ming
 *
 */
public interface JieQiService {
     public TJieqi findTJieqiByQici(String qici);
     
 	 // 获取当前申报届期
     public TJieqi findCurrentJieQi();
     // 获取当前结题届期
     public TJieqi findJieQiNow();
     public List<BigDecimal> findUnassignYears();
     public TJieqi findTjieqiById(String id);
     public List<TJieqi> findAllJieqis(String jqName,String jqYear,String jqQici,PageBean pageBean);
     public int findAllJieqicount(String jqName,String jqYear,String jqQici);
     public void addJieqi(TJieqi jieqi);
     public void updateJieqi(TJieqi jieqi);
     public void deleteJieqi(String jieqiId);
     public List<BigDecimal> findAllYears();
     public List<TJieqi> findJieqiByYear(String year);
}
