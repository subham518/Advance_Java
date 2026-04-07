package com.example.ManytoMany;

import com.example.hibernatedemo.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class App3 {
    public static void main(String[] args) {
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();




        session.close();
    }
}