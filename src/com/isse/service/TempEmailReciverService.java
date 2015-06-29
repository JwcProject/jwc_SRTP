/**
 * 
 */
package com.isse.service;

import java.util.List;

import com.isse.model.TTempEmailReciver;

/**
 * @author ming
 *
 */
public interface TempEmailReciverService {
     public void saveTempEmailReciver(TTempEmailReciver tempEmailReciver);
     public List<TTempEmailReciver> findTempEmailReciversByJQid(String jqId);
     public List<String> findEmailByJQid(String jqId,String teaCode,String type);
     
     //通过届期和教师工号得到临时邮件收信人
     public TTempEmailReciver findTempEmailReciver(String jqId, String teaCode);
     
     //通过届期ID和学院主管教师教职工号获取临时邮件接收人
     public List<TTempEmailReciver> findTempEmailRecivers(String jqId,
 			String teaCode,String type);
}
