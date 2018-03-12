package com.werson.springtest.dao;

import com.werson.springtest.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by wersom on 2017/10/20 0020.
 */
@Repository
public class UserDao {

    public UserDao(){
        System.out.println("init UserDao");
    }

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    private Session getSession(){
        System.out.println("haha=" + sessionFactory.toString());
        return sessionFactory.getCurrentSession();
    }

    public void addNewUser(User newUser){
        //Session session = MySessionFactory.getSession();
        //开启事物
        //Transaction transaction = session.beginTransaction();

        //session.save(newUser);

        //提交事物
        //transaction.commit();
        getSession().save(newUser);
    }

}
