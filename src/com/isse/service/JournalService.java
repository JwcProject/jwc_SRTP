package com.isse.service;

import java.util.Date;
import java.util.List;

import com.isse.model.TJournal;
import com.util.PageBean;

public interface JournalService {
	public void addTJournal(TJournal journal);
	public void updateTJournal(TJournal journal);
	public void deleteTJournal(String id);
	public TJournal getTJournal(String id);
	public List<TJournal> getAllTJournal(final PageBean pageBean);
	public int getAllTJournalCount();

	public List<TJournal> getSelectedTJournal(String queryString);
	public List<TJournal> getSelectedTJournal(String userId,String userName,String journalLoginip,Date journalLogintime,Date journalQuitime,final PageBean pageBean);
	public int getSelectedTJournalCount(String userId,String userName,String journalLoginip,Date journalLogintime,Date journalQuitime);
}
