package edu.cqu.no1.action;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.cqu.no1.domain.TUnit;
import edu.cqu.no1.domain.TUser;
import edu.cqu.no1.util.ActionRedirect;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport {

	private TUser tuser;
	private String userType;
	private String userId;
	private TUnit tunit;
	private String toPath ="";

	public String getUserId() throws IOException {
		tuser =  (TUser)ActionContext.getContext().getSession().get("user"); 
		if (null != tuser)
		{
			return tuser.getUserId();
		}
		else
		{
			return null;
		}
	}

	public String getUsertype() throws IOException {
		tuser =  (TUser)ActionContext.getContext().getSession().get("user"); 
		if (null != tuser)
		{
			return tuser.getUserType();
		}
		else
		{
			return null;
		}
	}

	public TUser getSessionUser() throws IOException {

		if(ActionContext.getContext().getSession().get("user")==null) {
		    return null; 
		}else { 
			return (TUser)ActionContext.getContext().getSession().get("user"); 
	    }
	}
	
	public TUnit getSessionUnit() throws IOException 
	{
		tunit = (TUnit)ActionContext.getContext().getSession().get("unit");
		
		if(null != tunit)
		{
			return tunit;
		}
		else
		{
			return null;
		}
	}

	 public void toLogin() throws IOException
	 {
		HttpServletResponse response = (HttpServletResponse)ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE);
		HttpServletRequest request=(HttpServletRequest) (ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST));
		String path = request.getContextPath();
		String ToPath = toPath;
		String redirectPageUrl = path + "/?url="+URLEncoder.encode(ToPath,"UTF-8")+"&Message="+URLEncoder.encode("未登录或用户已过期，请重新登录","UTF-8"); 
		//response.sendRedirect(redirectPageUrl);	
		
		ActionRedirect.redirect("", "未登录或用户已过期，请重新登录!");
		return;
	 }

	public String getToPath() {
		return toPath;
	}

	public void setToPath(String toPath) {
		this.toPath = toPath;
	}

	public TUser getTuser() {
		return tuser;
	}

	public void setTuser(TUser tuser) {
		this.tuser = tuser;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public TUnit getTunit() {
		return tunit;
	}

	public void setTunit(TUnit tunit) {
		this.tunit = tunit;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	 
}
