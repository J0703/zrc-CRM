package com.xing.test;

import com.xing.action.AdminAction;
import com.xing.dao.StaffDao;
import com.xing.domain.Department;
import com.xing.domain.PageBean;
import com.xing.domain.Post;
import com.xing.domain.Staff;
import com.xing.service.DepartmentService;
import com.xing.service.PostService;
import com.xing.service.StaffService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 17/10/24.
 */
public class AdminTest {

    private ApplicationContext context;

    @Before
    public void init() {
        context = new ClassPathXmlApplicationContext("application.xml");
    }


    @Test
    public void saveInfo() {
        AdminAction adminAction = (AdminAction) context.getBean("adminAction");
        adminAction.saveInfo();
    }

    @Test
    public void findAllDept(){
        AdminAction adminAction = (AdminAction) context.getBean("adminAction");;
    }

    @Test
    public void findPstById(){
        PostService postService = (PostService) context.getBean("postService");
        List<Post> ps = postService.findPostsByDid("2c9090275f562650015f562669e00000");
        for (Post p : ps) {
            System.out.println(p);
        }

    }
    @Test
    public void gaojichaxun(){
        StaffService staffService = (StaffService) context.getBean("staffService");
//        PageBean<Staff> staffPageBean = staffService.higherQuery(1,2);
//        for (Staff staff : staffPageBean.getBeanlist()) {
//            System.out.println(staff);
//        }
    }


}
