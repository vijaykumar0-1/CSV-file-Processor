package com.csvFileProcessor.Scheduler;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyScheduledTaskToKeepAlive {

    @Scheduled(fixedRate = 840000)
    public void keepAlive()
    {
        System.out.println("Scheduled task executed to keep server Alive");
    }
}
