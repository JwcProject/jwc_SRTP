package edu.cqu.no1.action;

import java.io.IOException;

import edu.cqu.no1.domain.TUnit;
import edu.cqu.no1.domain.TUser;
import edu.cqu.no1.util.ActionRedirect;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

abstract public class BaseAction extends ActionSupport {

    protected static final String MESSAGE = "message";
    protected static final String ERROR = "db_error";

    public String getUserId() throws IOException {
        TUser tuser = (TUser) ActionContext.getContext().getSession().get("user");
        if (null != tuser) {
            String userId = tuser.getUserId();
            return userId;
        } else {
            return null;
        }
    }

    public String getUsertype() throws IOException {
        TUser tuser = (TUser) ActionContext.getContext().getSession().get("user");
        if (null != tuser) {
            String userRole = tuser.getUserType();
            return userRole;
        } else {
            return null;
        }
    }


    public TUser getSessionUser() throws IOException {

        TUser tuser = (TUser) ActionContext.getContext().getSession().get("user");
        return tuser;
    }


    public TUnit getSessionUnit() throws IOException {
        TUnit tunit = (TUnit) ActionContext.getContext().getSession().get("unit");
        return tunit;
    }

    public void toLogin() throws IOException {
        ActionRedirect.redirect("", "未登录或用户已过期，请重新登录!");
    }


}
