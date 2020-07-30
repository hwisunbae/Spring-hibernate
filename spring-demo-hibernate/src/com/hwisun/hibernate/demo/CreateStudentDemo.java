package com.hwisun.hibernate.demo;

import com.hwisun.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {
    public static void main(String[] args) {
//        create Session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

//        create Session
        Session session = sessionFactory.getCurrentSession();

        try{
            System.out.println("Creating new Student obj");
            Student student = new Student("Hwisun", "Bae", "hwisun.bae1@gmail.com");
            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();
            System.out.println("Done saving into DB");
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            sessionFactory.close();
        }
    }
}
