package com.hwisun.springdemo2;

import org.springframework.stereotype.Component;

@Component
public class RESTFortuneService implements FortuneService {

    @Override
    public String getFortune() {
        return "Rest fortune";
    }
}
