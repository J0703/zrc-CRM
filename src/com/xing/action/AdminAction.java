package com.xing.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sun.net.httpserver.Authenticator;
import com.xing.domain.*;
import com.xing.service.AdminService;
import com.xing.service.DepartmentService;
import com.xing.service.PostService;
import com.xing.service.StaffService;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
@Controller("adminAction")
@Scope("prototype")
public class AdminAction extends ActionSupport implements ModelDriven<Staff>{
    @Autowired
    @Qualifier("adminService")
    private AdminService adminService;
    @Autowired
    @Qualifier("staffService")
    private StaffService staffService;
    @Autowired
    @Qualifier("postService")
    private PostService postService;
    @Autowired
    @Qualifier("departmentService")
    private DepartmentService departmentService;


    private String pageCode;
    private List<Department> departments;
    private String deptId;
    private String postId;
    private String staffName;
    private List<Post> posts;

    private Staff staff;

    public String saveInfo() {
        Staff staff = new Staff("zhangsan", "123","张三","男");
        Staff staff1 = new Staff("lisi", "123");
        Post post = new Post("java讲师");
        Post post2 = new Post("H5讲师");
        Department department = new Department("教学部");
        staff.setPost(post);
        staff1.setPost(post2);
        post.getStaffs().add(staff);
        post2.getStaffs().add(staff1);
        post.setDepartment(department);
        post2.setDepartment(department);
        department.getPosts().add(post);
        department.getPosts().add(post2);
        adminService.saveInfo(department);
        return ERROR;
    }

    public String login() {
        String loginName = staff.getLoginName();
        String loginPwd = staff.getLoginPwd();
        Staff staff = staffService.login(loginName);
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
        PageBean<Staff> pb = staffService.findAll(pageCode,pageSize);
        ServletActionContext.getRequest().setAttribute("pb",pb);
        return SUCCESS;
    }

    public String findAllDept(){
        departments = departmentService.findAllDept();
        return SUCCESS;
    }

    public String findPostById(){
        System.out.println(deptId);
        posts = postService.findPostsByDid(deptId);
        return SUCCESS;
    }

    public String addStaff(){
        Post post = postService.findPostByPid(postId);
        staff.setPost(post);
        staffService.saveStaff(staff);
        return SUCCESS;
    }

    public String findStaffById(){
        String staffId = staff.getStaffId();
        Staff staff = staffService.findStaffById(staffId);
        System.out.println(staff);
        ServletActionContext.getRequest().setAttribute("staff",staff);
        return SUCCESS;
    }

    public String find(){
        Map<String,Object> params = new HashMap<>(10);
        int pageCode = getPc();
        int pageSize = 3;
        if (!"-1".equals(deptId)){
            params.put("depId",deptId);
            if (!"-1".equals(postId)){
                params.put("postId",postId);
            }
        }
        if (!"".equals(staff.getStaffName())){
            params.put("staffName",staff.getStaffName());
        }
        System.out.println(params.size());
        PageBean<Staff> pb =  staffService.higherQuery(pageCode,pageSize,params);
        pb.setPageCode(pageCode);
        pb.setPageSize(pageSize);
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


    public String getPageCode() {
        return pageCode;
    }

    public void setPageCode(String pageCode) {
        this.pageCode = pageCode;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }


    @Override
    public Staff getModel() {
        staff = new Staff();
        return staff;
    }
}
