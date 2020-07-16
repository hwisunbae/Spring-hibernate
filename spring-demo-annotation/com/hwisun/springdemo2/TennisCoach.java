package com.hwisun.springdemo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Scope("singleton")
@Component
public class TennisCoach implements Coach {

    @Autowired
    @Qualifier("randomFortuneService")
    private FortuneService fortuneService;

    public TennisCoach() {
        System.out.println("TennisCoach default constructor");
    }

    @PostConstruct
    public void domyStartUp(){
        System.out.println(">> TennisCoach: doMyStartUp");
    }

    @PreDestroy
    public void domyCleanUp() {
        System.out.println(">> TeenisCoach : doMyCleanUp");
    }

    /*
    @Autowired
    public TennisCoach(FortuneService fortuneService){
        this.fortuneService = fortuneService;
    }


    @Autowired
    public void doSomeCrazyStuff(FortuneService fortuneService) {
        System.out.println("inside setFortuneService - doSomeCrazyStuff");
        this.fortuneService = fortuneService;
    }

     */

    @Override
    public String getDailyWorkout() {
        return "Workout : Tennis";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
