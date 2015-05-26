package edu.cqu.no1.service;

import edu.cqu.no1.domain.User;

import java.util.List;

/**
 * Created by ZKQ on 2015/5/26.
 */
public interface UserService {
    int SUCCESS=0;
    int PASSWORD_WORRY=1;
    int No_THIS_USER=2;
    int MULTI_USER =3;

    int checkUser(String username, String password);
    int addUser(String username, String password);
    int checkUser(Integer uid,String password);
    int changePassword(String username,String newPassword);
    int changePassword(Integer uId,String newPassword);

    List<User> getAllUser();
}
