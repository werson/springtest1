package com.werson.springtest;

import com.werson.springtest.model.Person;
import com.werson.springtest.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * Created by wersom on 2017/10/17 0017.
 */
public class HibernateTest {

    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;

    @Before
    public void init() {
        //创建服务注册对象
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
        //创建会话工厂对象
        sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
        //会话对象
        session = sessionFactory.openSession();
        //开启事物
        transaction = session.beginTransaction();
    }

    @Test
    public void test1(){

        User p = new User();
        p.setName("werson");
        session.save(p);
        System.out.println(session);
    }

    @Test
    public void test2(){

        Person p = new Person();
        p.setName("test");
        session.save(p);

    }

    @After
    public void destory() {

        //关闭会话
        session.close();
        //关闭会话工厂
        sessionFactory.close();
    }
}
