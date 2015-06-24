package edu.cqu.no1.service;

import edu.cqu.no1.domain.TTempEmailReciver;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ZKQ on 2015/6/4.
 */

public interface TempEmailReciverService {
    public void saveTempEmailReciver(TTempEmailReciver tempEmailReciver);

    public List<TTempEmailReciver> findTempEmailReciversByJQid(String jqId);

    public List<String> findEmailByJQid(String jqId, String teaCode, String type);

    //通过届期和教师工号得到临时邮件收信人
    public TTempEmailReciver findTempEmailReciver(String jqId, String teaCode);

    //通过届期ID和学院主管教师教职工号获取临时邮件接收人
    public List<TTempEmailReciver> findTempEmailRecivers(String jqId,
                                                         String teaCode, String type);
}
