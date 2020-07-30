package com.hwisun.hibernate.demo;

import com.hwisun.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            System.out.println("Creating 3 students");
            Student student1 = new Student("John", "Doe", "john.doe@gmail.com");
            Student student2 = new Student("Marry", "Public", "marry.public@gmail.com");
            Student student3 = new Student("Bonita", "Apple", "bonita.apple@gmail.com");

            session.beginTransaction();
            session.save(student1);
            session.save(student2);
            session.save(student3);

            session.getTransaction().commit();
            System.out.println("Done saving!");
        } finally {
            factory.close();
        }
    }
}
