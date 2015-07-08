package edu.cqu.no1.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import edu.cqu.no1.domain.TAuthority;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by zl on 2015/7/3.
 */
@Component
@Scope("prototype")
public class AuthorityInterceptor extends AbstractInterceptor {
    HttpServletRequest request;
    Map<String, Object> session;

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        session = invocation.getInvocationContext().getSession();
        request = ServletActionContext.getRequest();



        if (session.get("user") == null || session.get("authorities") == null || session.get("role") == null)
            return ActionSupport.LOGIN;


//        String uri = request.getRequestURI();
//        ActionContext actionContext = invocation.getInvocationContext();

        //TODO: check the authority

        return invocation.invoke();

    }

}
