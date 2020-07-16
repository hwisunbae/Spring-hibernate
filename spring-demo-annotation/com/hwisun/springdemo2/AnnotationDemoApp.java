package com.hwisun.springdemo2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {
    public static void main(String[] args) {
//        read spring config file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

//        get the bean from container
        Coach coach = context.getBean("tennisCoach", Coach.class);

//        call a method on a bean
        System.out.println(coach.getDailyWorkout());
        System.out.println(coach.getDailyFortune());



//        close context
        context.close();
    }
}
