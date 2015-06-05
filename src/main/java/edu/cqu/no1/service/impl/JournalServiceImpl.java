package edu.cqu.no1.service.impl;

import edu.cqu.no1.dao.TJournalDAO;
import edu.cqu.no1.domain.TJournal;
import edu.cqu.no1.service.JournalService;
import edu.cqu.no1.util.PageBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


/**
 * Created by ZKQ on 2015/6/4.
 */

@Service
public class JournalServiceImpl implements JournalService {

    @Resource
    private TJournalDAO tJournalDAO;

    public TJournalDAO gettJournalDAO() {
        return tJournalDAO;
    }

    public void settJournalDAO(TJournalDAO tJournalDAO) {
        this.tJournalDAO = tJournalDAO;
    }

    @Override
    public void addTJournal(TJournal journal) {
        // TODO Auto-generated method stub
        this.tJournalDAO.save(journal);
    }

    @Override
    public void updateTJournal(TJournal journal) {
        // TODO Auto-generated method stub
        this.tJournalDAO.merge(journal);
    }

    @Override
    public void deleteTJournal(String id) {
        // TODO Auto-generated method stub
        TJournal journal = this.getTJournal(id);
        journal.setIsdeleted("Y");
        this.updateTJournal(journal);
    }

    @Override
    public TJournal getTJournal(String id) {
        // TODO Auto-generated method stub
        return this.tJournalDAO.findById(id);
    }

    @Override
    public List<TJournal> getAllTJournal(PageBean pageBean) {
        // TODO Auto-generated method stub
        return this.tJournalDAO.findAll(pageBean);
    }

    @Override
    public int getAllTJournalCount() {
        // TODO Auto-generated method stub
        return this.tJournalDAO.getAllTJournalCount();
    }

    @Override
    public List<TJournal> getSelectedTJournal(String queryString) {
        // TODO Auto-generated method stub
        return this.tJournalDAO.findByQueryString(queryString);
    }


    @Override
    public List<TJournal> getSelectedTJournal(String userId, String userName, String journalLoginip, Date journalLogintime, Date journalQuitime, final PageBean pageBean) {
        // TODO Auto-generated method stub
        return this.tJournalDAO.findByMultiCondition(userId, userName, journalLoginip, journalLogintime, journalQuitime, pageBean);
    }

    @Override
    public int getSelectedTJournalCount(String userId, String userName, String journalLoginip, Date journalLogintime, Date journalQuitime) {
        // TODO Auto-generated method stub
        return this.tJournalDAO.findByMultiConditionCount(userId, userName, journalLoginip, journalLogintime, journalQuitime);
    }


}
