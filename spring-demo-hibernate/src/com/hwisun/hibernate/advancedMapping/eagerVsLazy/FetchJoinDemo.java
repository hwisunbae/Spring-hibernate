package com.hwisun.hibernate.advancedMapping.eagerVsLazy;

import com.hwisun.hibernate.advancedMapping.oneToMany.entity.Course;
import com.hwisun.hibernate.advancedMapping.oneToMany.entity.Instructor;
import com.hwisun.hibernate.advancedMapping.oneToMany.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchJoinDemo {
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

            Query<Instructor>query =
                    session.createQuery("SELECT i FROM Instructor i JOIN FETCH i.courses WHERE i.id=:instructorId"
                            , Instructor.class);
            query.setParameter("instructorId", id);
            Instructor instructor = query.getSingleResult();
            System.out.println("instructor " + instructor);

            session.getTransaction().commit();
            session.close();

            System.out.println("\nThe session is now closed \n");
            // option 1 : call getter method while session is open
            // option 2 : Hibernate query with HQL

            System.out.println(instructor.getCourses());
            System.out.println("Done!");
        }finally {
            session.close();
            factory.close();
        }
    }
}
