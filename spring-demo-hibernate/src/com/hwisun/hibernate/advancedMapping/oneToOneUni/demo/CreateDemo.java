package com.hwisun.hibernate.advancedMapping.oneToOneUni.demo;

import com.hwisun.hibernate.advancedMapping.oneToOneUni.entity.Instructor;
import com.hwisun.hibernate.advancedMapping.oneToOneUni.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{

            Instructor instructor =
                    new Instructor("Chad", "Darby", "chad.darby@gamil.com");
            InstructorDetail instructorDetail =
                    new InstructorDetail("chad.youtube", "swimming");
            instructor.setInstructorDetail(instructorDetail);

            session.beginTransaction();
            session.save(instructor); // also save the detail obj due to CascadeType.ALL
            session.getTransaction().commit();
        }finally {
            factory.close();
        }
    }
}
