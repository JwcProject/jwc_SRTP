package edu.cqu.no1.service.impl;

import edu.cqu.no1.dao.UserDao;
import edu.cqu.no1.domain.User;
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
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public int checkUser(String username, String password) {
        User user = null;
        try {
            user = userDao.findByUsername(username);
        } catch (ExistMultiUserException e) {
            return MULTI_USER;
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (user == null) {
            return No_THIS_USER;
        }
        if (!user.getPassword().equals(password)) {
            return PASSWORD_WORRY;
        }
        return SUCCESS;
    }

    public int addUser(String username, String password) {
        User user = new User();
        user.setPassword(password);
        user.setUsername(username);
        user.setLevel(0);
        try {
            userDao.save(user);
        } catch (Exception e) {
            e.printStackTrace();
            return MULTI_USER;
        }
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

    public List<User> getAllUser() {
        return userDao.findAll(User.class);
    }
}
