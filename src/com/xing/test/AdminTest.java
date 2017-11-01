package com.xing.test;

import com.xing.action.AdminAction;
import com.xing.dao.ClassesDao;
import com.xing.dao.StaffDao;
import com.xing.domain.*;
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
        adminAction.findAllDept();
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

    @Test
    public void findDepById(){
        DepartmentService departmentService = (DepartmentService) context.getBean("departmentService");
        System.out.println(departmentService.findDeptById("2c9090275f5cc4c3015f5cc4c9ca0000"));
    }


    @Test
    public void saveClasses(){
        ClassesDao classesDao = (ClassesDao) context.getBean("classesDao");
        Course course = new Course("java",18888,200);
        Course course1 = new Course("HTML",16666,150);
        Classes classes = new Classes("java0703");
        Classes classes1 = new Classes("java0804");
        Classes classes2 = new Classes("HTML0905");
        Classes classes3 = new Classes("HTML1006");
        Schedule schedule = new Schedule("课程1");
        Schedule schedule2 = new Schedule("课程2");

        schedule.getClasses().add(classes);
        schedule.getClasses().add(classes1);
        schedule2.getClasses().add(classes2);
        schedule2.getClasses().add(classes3);

        classes.setSchedule(schedule);
        classes1.setSchedule(schedule);
        classes2.setSchedule(schedule2);
        classes3.setSchedule(schedule2);

        course.getClasses().add(classes);
        course.getClasses().add(classes1);
        course1.getClasses().add(classes2);
        course1.getClasses().add(classes3);

        classes.setCourse(course);
        classes1.setCourse(course);
        classes2.setCourse(course1);
        classes3.setCourse(course1);

        classesDao.saveInfo(classes);
        classesDao.saveInfo(classes1);
        classesDao.saveInfo(classes2);
        classesDao.saveInfo(classes3);

    }

}
