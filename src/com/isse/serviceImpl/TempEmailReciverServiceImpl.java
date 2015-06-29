/**
 * 
 */
package com.isse.serviceImpl;

import java.util.List;

import com.isse.dao.TTempEmailReciverDAO;
import com.isse.model.TTempEmailReciver;
import com.isse.service.TempEmailReciverService;
import com.sun.org.apache.regexp.internal.recompile;

/**
 * @author ming
 *
 */
public class TempEmailReciverServiceImpl implements TempEmailReciverService {
    TTempEmailReciverDAO tempEmailReciverDAO;
	/* (non-Javadoc)
	 * @see com.isse.service.TempEmailReciverService#saveTempEmailReciver(com.isse.model.TTempEmailReciver)
	 */
	@Override
	
	//添加一个临时邮件收件人
	public void saveTempEmailReciver(TTempEmailReciver tempEmailReciver) {
		// TODO Auto-generated method stub
        this.tempEmailReciverDAO.save(tempEmailReciver);
	}
	
	//通过届期id查找所有收件人
	public List<TTempEmailReciver> findTempEmailReciversByJQid(String jqId){
		return this.tempEmailReciverDAO.findTempEmailReciverByJQid(jqId);
	}
	
	//通过届期ID和学院主管教师教职工号获取临时邮件接收人
    public List<TTempEmailReciver> findTempEmailRecivers(String jqId,
			String teaCode,String type){
    	return this.tempEmailReciverDAO.findTempEmailRecivers(jqId, teaCode,type);
    }
	
	//通过届期id查找所有收件人的邮箱
	public List<String> findEmailByJQid(String jqId,String teaCode,String type){
		return this.tempEmailReciverDAO.findEmailByJQid(jqId,teaCode,type);
	}
	
	//通过届期和教师工号得到临时邮件收信人
    public TTempEmailReciver findTempEmailReciver(String jqId, String teaCode)
    {
    	return this.tempEmailReciverDAO.findTempEmailReciver(jqId, teaCode);
    }
	
	public TTempEmailReciverDAO getTempEmailReciverDAO() {
		return tempEmailReciverDAO;
	}
	public void setTempEmailReciverDAO(TTempEmailReciverDAO tempEmailReciverDAO) {
		this.tempEmailReciverDAO = tempEmailReciverDAO;
	}

}
