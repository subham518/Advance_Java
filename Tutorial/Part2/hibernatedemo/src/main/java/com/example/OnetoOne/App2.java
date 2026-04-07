package com.example.OnetoOne;

import com.example.hibernatedemo.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class App2 {
    public static void main(String[] args) {
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction tx=session.beginTransaction();

        ID_Card card=new ID_Card();
        card.setCardNumber("24CSE236");

        Student std=new Student();
        std.setName("Subham");
        std.setIDCard(card);

        session.persist(card);
        session.persist(std);

        tx.commit();
        session.close();
        System.out.println("Data Inserted!!");
    }
}




