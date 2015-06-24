package edu.cqu.no1.dao;

import edu.cqu.no1.domain.TUser;
import edu.cqu.no1.util.PageBean;

import java.util.List;

/**
 * Created by ZKQ on 2015/5/27.
 */
public interface TUserDAO extends BaseDao<TUser> {
    List<TUser> findByUserName(Object userName);

    List<TUser> findByUserPassword(Object userPassword);

    List<TUser> findByUserState(Object userState);

    List<TUser> findByUserIntroduction(Object userIntroduction);

    List<TUser> findByIsdeleted(Object isdeleted);

    List<TUser> findByUserType(Object userType);

    int getAllTUserCount();

    List findAll(PageBean pageBean);

    int getTUserCountByMutiProperty(String userId, String userName, String userType, String userState);

    List getTUserByMutiProperty(String userId, String userName, String userType, String userState, PageBean pageBean);

    List findByUserIdAndPwd(String userId, String password);
}
