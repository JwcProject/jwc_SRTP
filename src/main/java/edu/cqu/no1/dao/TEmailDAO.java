package edu.cqu.no1.dao;

import edu.cqu.no1.domain.TEmail;

import java.util.List;

/**
 * Created by ZKQ on 2015/5/27.
 */
public interface TEmailDAO extends BaseDao<TEmail> {
    List findByEmailTitle(Object emailTitle);

    List findByEmailContent(Object emailContent);

    List findBySender(Object sender);

    List findByEmailSecret(Object emailSecret);

    List findBySendState(Object sendState);

    List findByIsdeleted(Object isdeleted);
}
