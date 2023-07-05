package com.test;

import com.test.configuration.SchedulerConfig;
import com.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class SchedulerDemo implements ApplicationRunner {

    private SchedulerConfig schedulerConfig;
    private TaskScheduler task1scheduler;
    private TestService testService;

    @Autowired
    public SchedulerDemo(@Qualifier("task1scheduler")TaskScheduler tesk1Scheduler,
                         SchedulerConfig schedulerConfig,
                         TestService testService){
        this.task1scheduler = tesk1Scheduler;
        this.schedulerConfig = schedulerConfig;
        this.testService = testService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        task1scheduler.scheduleWithFixedDelay(() ->{
            testService.testScheduler1();
        },schedulerConfig.getInterval());

        //Below code is if you want to excute multiple methods asynchronously
//        CompletableFuture.runAsync(() ->{
//            testService.testScheduler1();
//            testService.testScheduler2();
//        });

    }
}
