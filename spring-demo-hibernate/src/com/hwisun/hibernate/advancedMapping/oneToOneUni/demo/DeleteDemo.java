package com.hwisun.hibernate.advancedMapping.oneToOneUni.demo;

import com.hwisun.hibernate.advancedMapping.oneToOneUni.entity.Instructor;
import com.hwisun.hibernate.advancedMapping.oneToOneUni.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            session.beginTransaction();
            Instructor instructor = session.get(Instructor.class, 2);
            if(instructor == null) {
                System.out.println("No insturctor found");
            } else {
                session.delete(instructor);
            }
            session.getTransaction().commit();

        }finally {
            factory.close();
        }
    }
}
