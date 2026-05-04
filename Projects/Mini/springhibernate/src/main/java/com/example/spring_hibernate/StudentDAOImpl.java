package com.example.spring_hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class StudentDAOImpl implements StudentDAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void saveStudent(Student student) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.persist(student);

        session.getTransaction().commit();
        session.close();
    }
}
