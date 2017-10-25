package com.xing.test;

import com.xing.action.AdminAction;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by dllo on 17/10/24.
 */
public class AdminTest {
    @Autowired
    @Qualifier("adminAction")
    private AdminAction adminAction;

    @Test
    public void saveInfo(){
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        adminAction = (AdminAction) context.getBean("adminAction");
        System.out.println(adminAction.saveInfo());
    }
}
