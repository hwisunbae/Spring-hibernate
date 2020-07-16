package com.hwisun.springdemo2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JavaConfigDemoApp {
    public static void main(String[] args) {
//        read spring config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SportConfig.class);

//        get the bean from container
        Coach coach = context.getBean("tennisCoach", Coach.class);

//        call a method on a bean
        System.out.println(coach.getDailyWorkout());
        System.out.println(coach.getDailyFortune());


//        close context
        context.close();
    }
}
