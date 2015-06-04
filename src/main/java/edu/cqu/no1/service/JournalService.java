package edu.cqu.no1.service;

import edu.cqu.no1.domain.TJournal;
import edu.cqu.no1.util.PageBean;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


/**
 * Created by ZKQ on 2015/6/4.
 */

public interface JournalService {
    public void addTJournal(TJournal journal);

    public void updateTJournal(TJournal journal);

    public void deleteTJournal(String id);

    public TJournal getTJournal(String id);

    public List<TJournal> getAllTJournal(final PageBean pageBean);

    public int getAllTJournalCount();

    public List<TJournal> getSelectedTJournal(String queryString);

    public List<TJournal> getSelectedTJournal(String userId, String userName, String journalLoginip, Date journalLogintime, Date journalQuitime, final PageBean pageBean);

    public int getSelectedTJournalCount(String userId, String userName, String journalLoginip, Date journalLogintime, Date journalQuitime);
}
