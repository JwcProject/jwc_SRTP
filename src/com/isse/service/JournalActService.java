package com.isse.service;

import java.util.Date;
import java.util.List;

import com.isse.model.TJournalAct;
import com.util.PageBean;

public interface JournalActService {
	public void addTJournalAct(TJournalAct journalAct);
	public void updateTJournalAct(TJournalAct journalAct);
	public void deleteTJournalAct(String id);
	public TJournalAct getTJournalAct(String id);
	public List<TJournalAct> getAllTJournalAct(final PageBean pageBean);
	public int getAllTJournalActCount();

	public List<TJournalAct> getSelectedTJournalAct(String userId,String journalactType,String journalactIntroduction,Date time,final PageBean pageBean);
	public int getSelectedTJournalActCount(String userId,String journalactType,String journalactIntroduction,Date time);
	}
