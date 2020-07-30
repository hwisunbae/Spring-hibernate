package com.hwisun.hibernate.demo;

import com.hwisun.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        try{
            Session session = factory.getCurrentSession();
            session.beginTransaction();
//            Student student = session.get(Student.class, 2);
//            System.out.println("Deleting student" + student);
//            session.delete(student);

//            delete student id = 3
            session.createQuery("DELETE FROM Student WHERE ID=3").executeUpdate();
            session.getTransaction().commit();




        }finally {
            factory.close();
        }


    }
}
