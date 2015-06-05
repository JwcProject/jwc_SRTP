package edu.cqu.no1.service.impl;

import edu.cqu.no1.dao.TTempEmailReciverDAO;
import edu.cqu.no1.domain.TTempEmailReciver;
import edu.cqu.no1.service.TempEmailReciverService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ZKQ on 2015/6/4.
 */

@Service
public class TempEmailReciverServiceImpl implements TempEmailReciverService {

    @Resource
    TTempEmailReciverDAO tempEmailReciverDAO;

    @Override
    //添加一个临时邮件收件人
    public void saveTempEmailReciver(TTempEmailReciver tempEmailReciver) {
        // TODO Auto-generated method stub
        this.tempEmailReciverDAO.save(tempEmailReciver);
    }

    //通过届期id查找所有收件人
    public List<TTempEmailReciver> findTempEmailReciversByJQid(String jqId) {
        return this.tempEmailReciverDAO.findTempEmailReciverByJQid(jqId);
    }

    //通过届期ID和学院主管教师教职工号获取临时邮件接收人
    public List<TTempEmailReciver> findTempEmailRecivers(String jqId,
                                                         String teaCode, String type) {
        return this.tempEmailReciverDAO.findTempEmailRecivers(jqId, teaCode, type);
    }

    //通过届期id查找所有收件人的邮箱
    public List<String> findEmailByJQid(String jqId, String teaCode, String type) {
        return this.tempEmailReciverDAO.findEmailByJQid(jqId, teaCode, type);
    }

    //通过届期和教师工号得到临时邮件收信人
    public TTempEmailReciver findTempEmailReciver(String jqId, String teaCode) {
        return this.tempEmailReciverDAO.findTempEmailReciver(jqId, teaCode);
    }

    public TTempEmailReciverDAO getTempEmailReciverDAO() {
        return tempEmailReciverDAO;
    }

    public void setTempEmailReciverDAO(TTempEmailReciverDAO tempEmailReciverDAO) {
        this.tempEmailReciverDAO = tempEmailReciverDAO;
    }

}
