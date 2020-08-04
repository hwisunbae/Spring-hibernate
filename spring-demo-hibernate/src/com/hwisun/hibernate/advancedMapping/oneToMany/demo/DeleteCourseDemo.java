package com.hwisun.hibernate.advancedMapping.oneToMany.demo;

import com.hwisun.hibernate.advancedMapping.oneToMany.entity.Course;
import com.hwisun.hibernate.advancedMapping.oneToMany.entity.Instructor;
import com.hwisun.hibernate.advancedMapping.oneToMany.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCourseDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            session.beginTransaction();

            Course course = session.get(Course.class, 10);
            session.delete(course);

            session.getTransaction().commit();
            System.out.println("Done!");
        }finally {
            session.close();
            factory.close();
        }
    }
}
