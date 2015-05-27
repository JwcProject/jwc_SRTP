package edu.cqu.no1.dao;

import edu.cqu.no1.domain.TEndProjectExport;
import edu.cqu.no1.util.PageBean;

import java.util.List;

/**
 * Created by ZKQ on 2015/5/27.
 */
public interface TEndProjectExportDAO {
    List<TEndProjectExport> findMyReviewEndPros(String teaCode, String jieqiId, PageBean pageBean);

    TEndProjectExport findEndProExp(String teaCode, String endProId);

    int findMyReviewEndPros(String teaCode, String jieqiId);

    List findByIsdeleted(Object isdeleted);
}
