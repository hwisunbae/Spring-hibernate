package com.hwisun.hibernate.demo;

import com.hwisun.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            Student student = new Student("Daffy", "duck", "daffy.duck@gmail.com");
            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();

//            find out the student's id : PK
            System.out.println("Saved student. PK : " + student.getId());

            session = factory.getCurrentSession();
            session.beginTransaction();
            System.out.println("\nGetting student with PK id: " + student.getId());
            Student myStudent = session.get(Student.class, student.getId());
            System.out.println("Complete :" + myStudent);
            session.getTransaction().commit();

        }finally{
            factory.close();
        }
    }
}
