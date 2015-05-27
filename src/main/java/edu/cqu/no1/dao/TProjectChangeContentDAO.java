package edu.cqu.no1.dao;

import java.util.List;

/**
 * Created by ZKQ on 2015/5/27.
 */
public interface TProjectChangeContentDAO {
    List findByProjectchangecontentField(Object projectchangecontentField);

    List findByProjectchangecontentFieldname(
            Object projectchangecontentFieldname);

    List findByProjectchangecontentOvalue(
            Object projectchangecontentOvalue);

    List findByProjectchangecontentNvalue(
            Object projectchangecontentNvalue);

    List findByIsdeleted(Object isdeleted);
}
