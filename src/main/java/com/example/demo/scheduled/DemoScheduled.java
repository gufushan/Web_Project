package com.example.demo.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DemoScheduled {

    @Scheduled(cron = "0 0/1 * * * ?")
    public void sayHello(){
        System.out.println("hello world");
    }
}
