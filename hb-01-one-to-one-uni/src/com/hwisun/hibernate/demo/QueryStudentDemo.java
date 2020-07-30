package com.hwisun.hibernate.demo;

import com.hwisun.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            session.beginTransaction();
            List<Student> students = session.createQuery("from Student").getResultList();
            System.out.println("All Students");
            displayStudents(students);

//            Query students : lastName:'Doe
            students = session.createQuery("from Student s where s.lastName='Doe'").getResultList();
            System.out.println("Querying Doe");
            displayStudents(students);

            students = session.createQuery("from Student s where s.lastName='Doe' OR s.firstName='Marry'").getResultList();
            System.out.println("Querying Doe or Marry");
            displayStudents(students);

            students = session.createQuery("from Student s where s.email LIKE '%cpd.com'").getResultList();
            System.out.println("Querying all gmail");
            displayStudents(students);

            session.getTransaction().commit();


        }finally {
            factory.close();
        }
    }

    private static void displayStudents(List<Student> students) {
        for(Student student: students){
            System.out.println(student);
        }
    }
}
