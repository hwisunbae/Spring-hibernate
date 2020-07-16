package com.hwisun.springdemo2;

public class TrackCoach implements Coach {

    private FortuneService fortuneService;

    public TrackCoach() {
    }

    public TrackCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Run a hard 5k";
    }

    @Override
    public String getDailyFortune() {
        return "Just do it !" + this.fortuneService.getFortune();
    }

//    add an init method
    public void doMyStartUp(){
        System.out.println("TrackCoach : startup");
    }
//    add an destroy method
    public void doMyCleanUp() {
        System.out.println("TrackCoach : destroy");
    }
}
