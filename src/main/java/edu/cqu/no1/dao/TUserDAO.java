package edu.cqu.no1.dao;

import edu.cqu.no1.domain.TAuthority;
import edu.cqu.no1.domain.TUser;
import edu.cqu.no1.exception.RedundancyEmailException;
import edu.cqu.no1.exception.RedundancyUserException;
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

    List<TUser> findByUserType(Object userRole);

    int getAllTUserCount();

    List findAll(PageBean pageBean);

    int getTUserCountByMutiProperty(String userId, String userName, String userRole, String userState);

    List getTUserByMutiProperty(String userId, String userName, String userRole, String userState, PageBean pageBean);

    List findByUserIdAndPwd(String userId, String password);


    TUser findByUsername(String username) throws RedundancyUserException;

    TUser findByEmail(String email) throws RedundancyEmailException;

    boolean saveUser(TUser user);

    List<TAuthority> getUserAuthorities(TUser user);

    List<TUser> findAllUserByPage(int pageNo, int pageSize);


}
