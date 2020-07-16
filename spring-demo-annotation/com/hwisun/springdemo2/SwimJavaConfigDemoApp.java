package com.hwisun.springdemo2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {
    public static void main(String[] args) {
//        read spring config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SportConfig.class);

//        get the bean from container
        SwimCoach coach = context.getBean("swimCoach", SwimCoach.class);

//        call a method on a bean
        System.out.println(coach.getDailyWorkout());
        System.out.println(coach.getDailyFortune());
        System.out.println(coach.getTeam());
        System.out.println(coach.getEmail());


//        close context
        context.close();
    }
}
