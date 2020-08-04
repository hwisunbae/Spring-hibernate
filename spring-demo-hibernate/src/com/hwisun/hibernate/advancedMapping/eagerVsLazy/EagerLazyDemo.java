package com.hwisun.hibernate.advancedMapping.eagerVsLazy;

import com.hwisun.hibernate.advancedMapping.oneToMany.entity.Course;
import com.hwisun.hibernate.advancedMapping.oneToMany.entity.Instructor;
import com.hwisun.hibernate.advancedMapping.oneToMany.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EagerLazyDemo {
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

            int id = 4;
            Instructor instructor = session.get(Instructor.class, id);
            System.out.println("instructor " + instructor);
            System.out.println(instructor.getCourses());

            session.getTransaction().commit();
            session.close();

            System.out.println("\nThe session is now closed \n");
            // option 1 : call getter method while session is open

            System.out.println(instructor.getCourses());
            System.out.println("Done!");
        }finally {
            session.close();
            factory.close();
        }
    }
}
