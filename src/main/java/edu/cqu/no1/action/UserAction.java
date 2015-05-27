package edu.cqu.no1.action;

import com.opensymphony.xwork2.ActionSupport;
import edu.cqu.no1.domain.User;
import edu.cqu.no1.service.UserService;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ZKQ on 2015/5/26.
 */

@Controller

@Namespace("/user")
@Scope("prototype")
@ParentPackage("base")
public class UserAction extends ActionSupport {
    @Resource
    private UserService userServer;

    private User user;
    public static final String WORRY = "worry";
    private List<User> users;

    @Action(value = "login", results = {
            @Result(name = SUCCESS, location = "/loginResult.jsp"),
            @Result(name = NONE, location = "/noThisUser.jsp"),
            @Result(name = WORRY, location = "/passwordWrong.jsp")})
    public String login() {
        switch (userServer.checkUser(user.getUsername(), user.getPassword())) {
            case UserService.SUCCESS:
                return SUCCESS;
            case UserService.MULTI_USER:
                return ERROR;
            case UserService.No_THIS_USER:
                return NONE;
            case UserService.PASSWORD_WORRY:
                return WORRY;
        }
        return ERROR;
    }


    @Action(value = "register", results = {
            @Result(name = SUCCESS, location = "/login.jsp")})
    public String register() {
        userServer.addUser(user.getUsername(), user.getPassword());
        return SUCCESS;
    }

    @Action(value = "list", results = {
            @Result(name = SUCCESS, type = "json")})
    public String list() {
        users = userServer.getAllUser();
        return SUCCESS;
    }

    public void setUserServer(UserService userService) {
        this.userServer = userService;
    }

    @JSON(serialize = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
