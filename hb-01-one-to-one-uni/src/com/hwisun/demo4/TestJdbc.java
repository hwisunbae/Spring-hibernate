package com.hwisun.demo4;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {
    public static void main(String[] args) {
        String jdbcUrl="jdbc:mysql://localhost:3306/hb_student_tracker?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
        String user ="hbstudent";
        String pw = "hbstudent";

        try{
            System.out.println("Connecting to database: " +jdbcUrl);
            Connection connection = DriverManager.getConnection(jdbcUrl, user, pw);
            System.out.println("connection successful");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
