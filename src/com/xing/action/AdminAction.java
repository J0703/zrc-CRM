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


    private int pageCode;
    private List<Department> departments;
    private String deptId;
    private String postId;
    private String staffName;
    private List<Post> posts;

    private Staff staff;

    public String saveInfo() {
        Staff staff = new Staff("zhangsan", "123","张三","男");
        Staff staff1 = new Staff("lisi", "123","李四","男");
        Staff staff2 = new Staff("1", "1","1","男");
        Staff staff3 = new Staff("2", "2","2","男");
        Staff staff4 = new Staff("3", "3","3","男");
        Staff staff5 = new Staff("4", "4","4","男");
        Staff staff6 = new Staff("5", "5","5","男");
        Staff staff7 = new Staff("6", "6","6","男");

        Post post = new Post("java讲师");
        Post post2 = new Post("H5讲师");
        Post post3 = new Post("职规总监");
        Post post4 = new Post("班主任");

        Department department = new Department("教学部");
        Department department1 = new Department("职规部");

        staff.setPost(post);
        staff1.setPost(post);
        staff2.setPost(post2);
        staff3.setPost(post2);

        staff4.setPost(post3);
        staff5.setPost(post3);
        staff6.setPost(post4);
        staff7.setPost(post4);

        post.getStaffs().add(staff);
        post.getStaffs().add(staff1);
        post2.getStaffs().add(staff2);
        post2.getStaffs().add(staff3);

        post3.getStaffs().add(staff5);
        post3.getStaffs().add(staff6);
        post4.getStaffs().add(staff7);
        post4.getStaffs().add(staff4);

        post.setDepartment(department);
        post2.setDepartment(department);
        post4.setDepartment(department1);
        post3.setDepartment(department1);

        department.getPosts().add(post);
        department.getPosts().add(post2);

        department1.getPosts().add(post3);
        department1.getPosts().add(post4);

        adminService.saveInfo(department);
        adminService.saveInfo(department1);

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
        ServletActionContext.getRequest().setAttribute("dps",departments);
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
        ServletActionContext.getRequest().setAttribute("staff",staff);
        return SUCCESS;
    }

    public String find(){
        Map<String,Object> params = new HashMap<>(10);
        int pageCode = getPc();
        int pageSize = 3;
        if (!"-1".equals(deptId) && !"".equals(deptId) && deptId !=null){
            params.put("depId",deptId);
            if (!"-1".equals(postId) && !"".equals(postId) && postId !=null){
                params.put("postId",postId);
            }
        }
        if (!"".equals(staff.getStaffName())  && staff.getStaffName() !=null ){
            params.put("staffName",staff.getStaffName());
        }
        PageBean<Staff> pb =  staffService.higherQuery(pageCode,pageSize,params);
        pb.setPageCode(pageCode);
        pb.setPageSize(pageSize);
        ServletActionContext.getRequest().setAttribute("pb",pb);
        ServletActionContext.getRequest().setAttribute("ps",params);
        return SUCCESS;
    }

    public String updateStaff(){
        System.out.println(postId);
        Post post =  postService.findPostByPid(postId);
        staff.setPost(post);
        staffService.updateStaff(staff);
        return SUCCESS;
    }

    private int getPc() {
		/*
			1. 得到 pageCode
				> 如果pc参数不存在,pc=1
				> 如果pc存在,就转成int类型
		 */
        System.out.println(pageCode);

        if (pageCode == 0){
            return 1;
        }
        return pageCode;
    }


    public int getPageCode() {
        return pageCode;
    }

    public void setPageCode(int pageCode) {
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
