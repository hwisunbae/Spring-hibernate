package com.hwisun.springdemo2;

import org.springframework.stereotype.Component;


public class SadFortuneService implements FortuneService {
    @Override
    public String getFortune() {
        return "Today is bad luck!";
    }
}
