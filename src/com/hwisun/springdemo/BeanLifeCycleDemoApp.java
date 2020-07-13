package com.hwisun.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleDemoApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("beanLifeCycle-applicationContext.xml");

        TrackCoach coach = context.getBean("myCoach", TrackCoach.class);

        System.out.println(coach.getDailyFortune());
        context.close();
    }
}
