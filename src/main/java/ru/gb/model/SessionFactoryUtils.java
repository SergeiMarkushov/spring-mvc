package ru.gb.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

@Component
public class SessionFactoryUtils {
//    private SessionFactory factory;

//    public void init() {
       private SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
//    }

    public Session getSession() {
        return factory.getCurrentSession();
    }

    public void shutDown() {
        if(factory != null) {
            factory.close();
        }
    }

}
