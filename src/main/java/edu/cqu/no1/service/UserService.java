package edu.cqu.no1.service;

import edu.cqu.no1.domain.TStudent;
import edu.cqu.no1.domain.TTeacher;
import edu.cqu.no1.domain.TUnit;
import edu.cqu.no1.domain.TUser;
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

    public List<TUser> getTUserByMutiProperty(String userId, String userName, String userType, String userState, final PageBean pageBean);

    public int getTUserCountByMutiProperty(String userId, String userName, String userType, String userState);

    public TUser userLogin(String userId, String password);

    public TUnit getUnitByUserId(String userId, String userType);

    TStudent getStudentByUserId(String userId);

    TTeacher getTeacherByUserId(String userId);

    TUser changePassword(String userId, String password);

    TUser changeLoginState(String userId, String state);
}
