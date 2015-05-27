package edu.cqu.no1.dao;

import java.util.List;

/**
 * Created by ZKQ on 2015/5/27.
 */
public interface TUserRoleDAO {
    List findByIsdeleted(Object isdeleted);
}
