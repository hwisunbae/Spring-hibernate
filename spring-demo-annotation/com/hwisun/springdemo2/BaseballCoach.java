package com.hwisun.springdemo2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements  Coach {
    @Value("${foo.email}")
    private String email;

    @Value("${foo.team}")
    private String team;
    @Override
    public String getDailyWorkout() {
        return null;
    }

    @Override
    public String getDailyFortune() {
        return null;
    }

    public String getEmailandTeam() {
        return email + team;
    }
}
