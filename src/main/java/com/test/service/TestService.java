package com.test.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class TestService {

    // @Async
    public void testScheduler1(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/uuuu HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(Thread.currentThread().getName());
        System.out.println("DATE1: "+dtf.format(now));
    }

    //@Scheduled(cron = "0 0/30 15-18 * * *") every 30 minutes from 15 to 18
    public void testScheduler2(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/uuuu HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println("DATE2: "+dtf.format(now));
    }
}
