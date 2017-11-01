package com.xing.action;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.xing.domain.Staff;
import org.apache.struts2.ServletActionContext;

/**
 * Created by dllo on 17/10/31.
 */
public class LoginInterceptor extends AbstractInterceptor {
    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        Staff staff = (Staff) ServletActionContext.getContext().getApplication().get("user");
        if (staff!= null){
            return actionInvocation.invoke();
        }
        ServletActionContext.getContext().getSession().put("msg","你还没登陆呢,你咋知道这种操作的");
        return "error";
    }
}
