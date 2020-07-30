package com.hwisun.hibernate.demo;

import com.hwisun.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();



        int studentId = 1;
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            Student student = session.get(Student.class, studentId);
            student.setFirstName("Scooby");
            session.getTransaction().commit();

            session = factory.getCurrentSession();
            session.beginTransaction();
            session.createQuery("UPDATE Student SET email='foo@gmail.com'")
                    .executeUpdate();
            session.getTransaction().commit();
            System.out.println("Updating student");

        }finally {
            factory.close();
        }
    }
}
