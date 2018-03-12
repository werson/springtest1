package com.werson.springtest;

import com.werson.springtest.dao.UserDao;
import com.werson.springtest.model.User;
import org.apache.logging.log4j.ThreadContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by wersom on 2017/10/17 0017.
 */
public class DemoTest1 {

    @Test
    public void testSpring(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        HelloWorld helloWorld = (HelloWorld) context.getBean("helloBean");
        System.out.println(helloWorld.getName());
        System.out.println(helloWorld.getType());
    }

    @Test
    public void testHibernate(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        User user = new User();
        user.setName("gaga");
        session.save(user);
        transaction.commit();
    }

    @Test
    public void testStruts2(){

    }

}
