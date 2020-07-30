package com.hwisun.hibernate.advancedMapping.oneToOneBi.demo;

import com.hwisun.hibernate.advancedMapping.oneToOneBi.entity.Instructor;
import com.hwisun.hibernate.advancedMapping.oneToOneBi.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDetailDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            InstructorDetail instructorDetail
                    = session.get(InstructorDetail.class, 1);
            session.delete(instructorDetail);
            System.out.println("Deleting.. " + instructorDetail);
            session.getTransaction().commit();
        }finally {
            factory.close();
        }
    }
}
