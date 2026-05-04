package com.example.spring_hibernate;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        StudentDAO dao = (StudentDAO) context.getBean("StudentDAO");

        Student s = new Student();
        s.setName("Rahul");
        s.setCourse("Java");

        dao.saveStudent(s);

        System.out.println("Student saved !!");
    }
}