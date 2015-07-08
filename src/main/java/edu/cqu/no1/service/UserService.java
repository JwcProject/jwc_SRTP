package edu.cqu.no1.service;

import edu.cqu.no1.domain.*;
import edu.cqu.no1.util.PageBean;

import java.util.List;

/**
 * Created by ZKQ on 2015/6/4.
 */

public interface UserService {
    public void addTUser(TUser user);

    public void updateTUser(TUser user);

    public void deleteTUser(String id);

    public TUser getTUser(String id);

    public List<TUser> getAllTUser(final PageBean pageBean);

    public int getAllTUserCount();

    public List<TUser> getTUserByMutiProperty(String userId, String userName, String userRole, String userState, final PageBean pageBean);

    public int getTUserCountByMutiProperty(String userId, String userName, String userRole, String userState);

    public TUser userLogin(String userId, String password);

    public TUnit getUnitByUserId(String userId, String userRole);

    TStudent getStudentByUserId(String userId);

    TTeacher getTeacherByUserId(String userId);

    TUser changePassword(String userId, String password);

    TUser changeLoginState(String userId, String state);

    int SUCCESS = 0;
    int PASSWORD_WORRY = 1;
    int NO_THIS_USER = 2;
    int EMAIL_WORRY = 3;
    int REDUNDANCY_USER = 4;
    int REDUNDANCY_EMAIL = 5;
    int DATABASE_ERROR = 6;


    int checkUser(String username, String password);

    int registerUser(TUser user);

    TUser getUser();

    List<TAuthority> getUserAuthorities(TUser user);

    TRole getUserRole(TUser user);

    List<TUser> listAllUserByPage(int pageNo, int pageNum);

    int resetPassword(String username, String email);

    TUser attachUser(TUser tUser);
}
