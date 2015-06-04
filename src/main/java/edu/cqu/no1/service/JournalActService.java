package edu.cqu.no1.service;

import edu.cqu.no1.domain.TJournalAct;
import edu.cqu.no1.util.PageBean;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


/**
 * Created by ZKQ on 2015/6/4.
 */

public interface JournalActService {
    public void addTJournalAct(TJournalAct journalAct);

    public void updateTJournalAct(TJournalAct journalAct);

    public void deleteTJournalAct(String id);

    public TJournalAct getTJournalAct(String id);

    public List<TJournalAct> getAllTJournalAct(final PageBean pageBean);

    public int getAllTJournalActCount();

    public List<TJournalAct> getSelectedTJournalAct(String userId, String journalactType, String journalactIntroduction, Date time, final PageBean pageBean);

    public int getSelectedTJournalActCount(String userId, String journalactType, String journalactIntroduction, Date time);
}
