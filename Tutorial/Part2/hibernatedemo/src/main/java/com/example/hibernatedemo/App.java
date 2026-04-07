package com.example.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class App
{
//    public static void main( String[] args )
//    {
//
//        Session session = HibernateUtil.getSessionFactory().openSession();
//
//        Transaction tx = session.beginTransaction();
//
//        User user1 = new User();
//        user1.setId(1);
//        user1.setUsername("subham");
//        user1.setEmail("subham@123.com");
//
//        session.persist(user1);
//
//        User user2 = new User();
//        user2.setId(2);
//        user2.setUsername("subham2");
//        user2.setEmail("subham@1234.com");
//
//        session.persist(user2);
//
//        tx.commit();
//        session.close();
//
//        System.out.println("Data inserterd successfullly!");
//    }
//    public static void main(String[] args){
//        // 1. Obtain the session from your HibernateUtil
//        Session session = HibernateUtil.getSessionFactory().openSession();
//
//        // 2. Begin transaction
//        Transaction tx = session.beginTransaction();
//
//        try {
//            // 3. Create and populate the User object
//            User user = new User();
//            user.setUsername("subham_dev");
//            user.setEmail("subham@example.com");
//            user.setBio("Learning Hibernate 6 with MySQL.");
//            user.setRole(UserRole.ADMIN);
//            user.setAge(25); // This will be ignored by DB due to @Transient
//
//            // Note: Since you are using Hibernate 6.x (from your pom.xml),
//            // persist() is the standard method for saving.
//            session.persist(user);
//
//            // 4. Commit the transaction
//            tx.commit();
//            System.out.println("Success! User saved with ID: " + user.getId());
//
//        } catch (Exception e) {
//            if (tx != null) tx.rollback();
//            System.err.println("Transaction failed. Rolling back.");
//            e.printStackTrace();
//        } finally {
//            // 5. Always close the session
//            session.close();
//            // Optional: Close factory if the application is shutting down
//            HibernateUtil.getFactory().close();
//        }
//    }

    public static void main(String[] args){

    }
}
