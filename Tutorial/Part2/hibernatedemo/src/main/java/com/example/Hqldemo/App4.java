package com.example.Hqldemo;

import com.example.hibernatedemo.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.List;

public class App4 {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

//        insertData(session);
//        fetchAllEmployees(session);
//        fetchHignSalaryEmployee(session);
//        fetchByDepartment(session);
//        updateSalary(session);
//        deleteLowSalaryEmployees(session);

        tx.commit();
        session.close();
    }

//    private static void insertData(Session session) {
//        session.persist(new Employee("Alice", 70000, "IT"));
//        session.persist(new Employee("Bob", 45000, "HR"));
//        session.persist(new Employee("Charlie", 85000, "IT"));
//        session.persist(new Employee("David", 30000, "Sales"));
//    }

//    private static void fetchAllEmployees(Session session) {
//        String hql = "from Employee";
//        Query<Employee> query = session.createQuery(hql, Employee.class);
//        List<Employee> employees = query.list();
//        System.out.println("All Employees: ");
//        for(Employee e: employees){
//            System.out.println(e.getName() + " " + e.getSalary());
//        }
    // or
//        List<Employee> list = session.createQuery("from Employee", Employee.class).list();
//        System.out.println("All Employees: " + list);
//    }

//    private static void fetchHignSalaryEmployee(Session session) {
//        Query<Employee> query = session.createQuery("from Employee where salary > 50000", Employee.class);
//        System.out.println("High Salary: " + query.list());
//    }
//
//    private static void fetchByDepartment(Session session) {
//        String hql = "from Employee where dept = :d";
//        Query<Employee> query = session.createQuery(hql, Employee.class);
//        query.setParameter("d", "IT");
//        List<Employee> employees = query.list();
//        System.out.println("All employees of IT department:");
//        for(Employee e : employees) {
//            System.out.println(e.getName()+ " " + e.getDept());
//        }
        // or
//        Query<Employee> query = session.createQuery("from Employee where dept = :d", Employee.class);
//        query.setParameter("d", "IT");
//        System.out.println("IT Dept: " + query.list());
//    }
//
//    private static void updateSalary(Session session) {
//        Query query = session.createQuery("update Employee set salary = salary + 5000 where name = 'Alice'");
//        query.executeUpdate();
//        System.out.println("Salary updated for Alice.");
//    }
//
//    private static void deleteLowSalaryEmployees(Session session) {
//        Query query = session.createQuery("delete from Employee where salary < 35000");
//        int rows = query.executeUpdate();
//        System.out.println("Deleted " + rows + " low salary employees.");
//    }
}
