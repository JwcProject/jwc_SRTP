package edu.cqu.no1.service.impl;

import edu.cqu.no1.dao.TJournalActDAO;
import edu.cqu.no1.domain.TJournalAct;
import edu.cqu.no1.service.JournalActService;
import edu.cqu.no1.util.PageBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


/**
 * Created by ZKQ on 2015/6/4.
 */

@Service
public class JournalActServiceImpl implements JournalActService {

    @Resource
    private TJournalActDAO tJournalActDAO;

    public TJournalActDAO gettJournalActDAO() {
        return tJournalActDAO;
    }

    public void settJournalActDAO(TJournalActDAO tJournalActDAO) {
        this.tJournalActDAO = tJournalActDAO;
    }

    @Override
    public void addTJournalAct(TJournalAct JournalAct) {
        // TODO Auto-generated method stub
        this.tJournalActDAO.save(JournalAct);
    }

    @Override
    public void updateTJournalAct(TJournalAct JournalAct) {
        // TODO Auto-generated method stub
        this.tJournalActDAO.merge(JournalAct);
    }

    @Override
    public void deleteTJournalAct(String id) {
        // TODO Auto-generated method stub
        TJournalAct JournalAct = this.getTJournalAct(id);
        JournalAct.setIsdeleted("Y");
        this.updateTJournalAct(JournalAct);
    }

    @Override
    public TJournalAct getTJournalAct(String id) {
        // TODO Auto-generated method stub
        return this.tJournalActDAO.findById(id);
    }

    @Override
    public List<TJournalAct> getAllTJournalAct(PageBean pageBean) {
        // TODO Auto-generated method stub
        return this.tJournalActDAO.findAll(pageBean);
    }

    @Override
    public int getAllTJournalActCount() {
        // TODO Auto-generated method stub
        return this.tJournalActDAO.getAllTJournalActCount();
    }


    @Override
    public List<TJournalAct> getSelectedTJournalAct(String userId, String journalactType, String journalactIntroduction, Date time, final PageBean pageBean) {
        // TODO Auto-generated method stub
        return this.tJournalActDAO.findByMultiCondition(userId, journalactType, journalactIntroduction, time, pageBean);
    }

    @Override
    public int getSelectedTJournalActCount(String userId, String journalactType, String journalactIntroduction, Date time) {
        // TODO Auto-generated method stub
        return this.tJournalActDAO.findByMultiConditionCount(userId, journalactType, journalactIntroduction, time);
    }


}
