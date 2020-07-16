package com.hwisun.springdemo2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("com.hwisun.springdemo2")
@PropertySource("classpath:sport.properties")
public class SportConfig {

//    define bean for fortune service
    @Bean
    public FortuneService sadFortuneService() {
        return new SadFortuneService();
    }

//    define bean for swim coach and inject dependency
    @Bean
    public Coach swimCoach() {
        return new SwimCoach(sadFortuneService());
    }
}
