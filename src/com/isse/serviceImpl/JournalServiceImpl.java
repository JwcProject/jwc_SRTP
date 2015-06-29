package com.isse.serviceImpl;

import java.util.Date;
import java.util.List;

import com.isse.dao.TJournalDAO;
import com.isse.model.TJournal;
import com.isse.service.JournalService;
import com.util.PageBean;

public class JournalServiceImpl implements JournalService {
	
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
	public List<TJournal> getSelectedTJournal(String userId,String userName,String journalLoginip,Date journalLogintime,Date journalQuitime,final PageBean pageBean) {
		// TODO Auto-generated method stub
		return this.tJournalDAO.findByMultiCondition(userId,userName,journalLoginip,journalLogintime,journalQuitime, pageBean);
	}
	
	@Override
	public int getSelectedTJournalCount(String userId,String userName,String journalLoginip,Date journalLogintime,Date journalQuitime) {
		// TODO Auto-generated method stub
		return this.tJournalDAO.findByMultiConditionCount(userId, userName, journalLoginip, journalLogintime, journalQuitime);
	}
	

}
