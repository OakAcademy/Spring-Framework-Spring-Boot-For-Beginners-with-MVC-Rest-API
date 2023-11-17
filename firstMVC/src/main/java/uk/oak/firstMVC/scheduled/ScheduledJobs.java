package uk.oak.firstMVC.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ScheduledJobs {
//    @Scheduled(fixedRate = 1000,initialDelay = 4000)
//    @Scheduled(fixedDelay = 3000)
    @Scheduled(cron = "0 21 22 * * ?")
    public void scheduledjob()
    {
        System.out.println("Job running at:"+new Date());
    }
}
