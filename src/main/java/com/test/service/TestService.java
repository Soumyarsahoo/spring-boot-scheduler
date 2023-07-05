package com.test.service;

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

    public void testScheduler2(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/uuuu HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println("DATE2: "+dtf.format(now));
    }
}
