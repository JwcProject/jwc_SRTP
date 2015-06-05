package edu.cqu.no1.util;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;


public class ActionRedirect {

	static public void redirect(String action, String message) throws IOException {
		HttpServletResponse response = (HttpServletResponse) ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE);
		HttpServletRequest request = (HttpServletRequest) (ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST));
		String path = request.getContextPath();

		String redirectPageUrl = path + "/Redirect.jsp?Action=" + URLEncoder.encode(action, "UTF-8") + "&Message=" + URLEncoder.encode(message, "UTF-8");
		response.sendRedirect(redirectPageUrl);
		return;

	}

	static public void redirectURL(String URL, String message) throws IOException {
		HttpServletResponse response = (HttpServletResponse) ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE);
		HttpServletRequest request = (HttpServletRequest) (ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST));
		String path = request.getContextPath();

		String redirectPageUrl = path + "/Redirect.jsp?http=1&Action=" + URLEncoder.encode(URL, "UTF-8") + "&Message=" + URLEncoder.encode(message, "UTF-8");

		response.sendRedirect(redirectPageUrl);

		return;

	}

	static public void redirectOutURL(String URL, String message) throws IOException {
		HttpServletResponse response = (HttpServletResponse) ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE);
		HttpServletRequest request = (HttpServletRequest) (ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST));
		String path = request.getContextPath();

		String redirectPageUrl = /* "//" + */path + "/Redirect.jsp?http=1&Action=" + URLEncoder.encode(/* "//" + */URL, "UTF-8") + "&Message=" + URLEncoder.encode(message, "UTF-8");
		response.sendRedirect(redirectPageUrl);
		return;

	}

}
