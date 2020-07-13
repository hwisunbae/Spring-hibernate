package com.hwisun.springdemo;

public class HappyFortuneService implements FortuneService {
    @Override
    public String getFortune() {
        return "todya is your lucky day";
    }
}
