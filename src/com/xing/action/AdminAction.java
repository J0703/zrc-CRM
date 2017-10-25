package com.xing.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.xing.domain.*;
import com.xing.service.AdminService;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by dllo on 17/10/24.
 */
@Controller("adminAction")
@Scope("prototype")
public class AdminAction extends ActionSupport {
    @Autowired
    @Qualifier("adminService")
    private AdminService adminService;
    private String loginName;
    private String loginPwd;
    private String pageCode;

    public String saveInfo() {
        Staff staff = new Staff("zhangsan", "123","张三","男");
        Staff staff1 = new Staff("lisi", "123");
        Post post = new Post("java讲师");
        Post post2 = new Post("H5讲师");
        post.getStaffs().add(staff);
        post2.getStaffs().add(staff1);
        Department department = new Department("教学部");
        department.getPosts().add(post);
        department.getPosts().add(post2);
        adminService.saveInfo(department);
        return ERROR;
    }

    public String login() {
        Staff staff = adminService.login(loginName);
        if (staff != null && staff.getLoginPwd().equals(loginPwd)) {
            ActionContext.getContext().getSession().put("user", staff);
            return SUCCESS;
        }
        addActionError("账号密码错误");
        return ERROR;
    }

    public String findAll() {
        int pageCode = getPc();
        int pageSize = 3;
        PageBean<Staff> pb = adminService.findAll(pageCode,pageSize);
        System.out.println(pb.getTotalPage());
        ServletActionContext.getRequest().setAttribute("pb",pb);
        return SUCCESS;
    }

    private int getPc() {
		/*
			1. 得到 pageCode
				> 如果pc参数不存在,pc=1
				> 如果pc存在,就转成int类型
		 */
        System.out.println(pageCode);

        if (pageCode == null || pageCode.trim().isEmpty() || Integer.valueOf(pageCode) <= 0){
            return 1;
        }
        return Integer.parseInt(pageCode);
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {

        this.loginPwd = loginPwd;
    }

    public AdminService getAdminService() {
        return adminService;
    }

    public void setAdminService(AdminService adminService) {

        this.adminService = adminService;
    }

    public String getPageCode() {
        return pageCode;
    }

    public void setPageCode(String pageCode) {
        this.pageCode = pageCode;
    }
}
