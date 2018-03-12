package com.werson.springtest.factory;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

/**
 * Created by wersom on 2017/10/18 0018.
 */
public class MySessionFactory {

    private static final ThreadLocal<Session> sessionLocal = new ThreadLocal<Session>();
    private static SessionFactory sessionFactory;

    static {
        //创建服务注册对象
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
        //创建会话工厂对象
        sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();

    }

    public static Session getSession() throws HibernateException {
        Session session = (Session) sessionLocal.get();

        if (session == null || !session.isOpen()) {
            if (sessionFactory == null) {
                rebuildSessionFactory();
            }
            session = (sessionFactory != null) ? sessionFactory.openSession() : null;
            sessionLocal.set(session);
        }
        return session;
    }

    public static void rebuildSessionFactory() {
        //创建服务注册对象
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
        //创建会话工厂对象
        sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
    }

    public static void closeSession() throws HibernateException {
        Session session = (Session) sessionLocal.get();
        sessionLocal.set(null);
        if (session != null) {
            session.close();
        }
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            rebuildSessionFactory();
        }
        return sessionFactory;
    }

}
