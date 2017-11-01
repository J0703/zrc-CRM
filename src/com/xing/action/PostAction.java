package com.xing.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.xing.domain.Department;
import com.xing.domain.Post;
import com.xing.service.AdminService;
import com.xing.service.DepartmentService;
import com.xing.service.PostService;
import com.xing.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created by dllo on 17/11/1.
 */
public class PostAction extends ActionSupport implements ModelDriven<Post> {
    private Post post;
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
    private String depId;

    public String savePost() {
        Department department = departmentService.findDeptById(depId);
        Post post2 = postService.findPostByPid(post.getPostId());
        for (Post post1 : postService.findAllPost()) {
            String depID = post1.getDepartment().getDepId();
            if (post1.getPostName().equals(post.getPostName()) && depID.equals(depId)) {
                addActionError("这个职务存在了哟");
                return ERROR;
            }
        }
        if (!post2.getPostName().equals(post.getPostName())) {
            postService.updatePost(post);
            return SUCCESS;
        }
        if (!post2.getDepartment().getDepId().equals(depId)) {
            post.setDepartment(department);
            post.setStaffs(post2.getStaffs());
            postService.updatePost(post);
            return SUCCESS;
        }
//        postService.saveInfo(post);
        return SUCCESS;
    }

    public String getDepId() {
        return depId;
    }

    public void setDepId(String depId) {
        this.depId = depId;
    }

    @Override
    public Post getModel() {
        post = new Post();
        return post;
    }
}
