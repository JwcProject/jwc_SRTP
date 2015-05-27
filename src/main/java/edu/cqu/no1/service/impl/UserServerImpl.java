package edu.cqu.no1.service.impl;

import edu.cqu.no1.dao.TUserDAO;
import edu.cqu.no1.domain.TUser;
import edu.cqu.no1.exception.ExistMultiUserException;
import edu.cqu.no1.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ZKQ on 2015/5/26.
 */
@Service
public class UserServerImpl implements UserService {
    @Resource
    private TUserDAO userDao;

    public void setUserDao(TUserDAO userDao) {
        this.userDao = userDao;
    }

    public int checkUser(String username, String password) {
        TUser user = null;
        try {
            user = userDao.findByUserName(username).get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (user == null) {
            return No_THIS_USER;
        }
        return SUCCESS;
    }

    public int addUser(String username, String password) {
        TUser user = new TUser();
/*        user.setPassword(password);
        user.setUsername(username);
        user.setLevel(0);
        try {
            userDao.save(user);
        } catch (Exception e) {
            e.printStackTrace();
            return MULTI_USER;
        }*/
        return SUCCESS;
    }

    public int checkUser(Integer uid, String password) {
        return 0;
    }

    public int changePassword(String username, String newPassword) {
        return 0;
    }

    public int changePassword(Integer uId, String newPassword) {
        return 0;
    }

    public List<TUser> getAllUser() {
        return userDao.findAll(TUser.class);
    }
}
