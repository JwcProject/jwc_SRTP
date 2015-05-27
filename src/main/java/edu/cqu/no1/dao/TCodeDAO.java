package edu.cqu.no1.dao;

import java.util.List;

/**
 * Created by ZKQ on 2015/5/27.
 */
public interface TCodeDAO {
    List findByEncodeValue(Object encodeValue);

    List findByEncodeDesc(Object encodeDesc);

    List findByEncodeRemark(Object encodeRemark);

    List findByIsdeleted(Object isdeleted);
}
