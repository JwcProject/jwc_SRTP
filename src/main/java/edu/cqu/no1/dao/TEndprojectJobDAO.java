package edu.cqu.no1.dao;

import edu.cqu.no1.domain.TEndProjectJob;

import java.util.List;

/**
 * Created by ZKQ on 2015/5/27.
 */
public interface TEndprojectJobDAO extends BaseDao<TEndProjectJob> {
    List findEndProJobsByEndProId(String endprojectId);

    List findByJobContent(Object jobContent
    );

    List findByFinished(Object finished
    );

    List findByIsdeleted(Object isdeleted
    );
}
