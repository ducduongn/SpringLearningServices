package com.example.springscheduler.jobs;

import lombok.extern.slf4j.Slf4j;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * @author ducduongn
 */
@Service
@Slf4j
public class Schedulers {

    @Scheduled(initialDelayString = "${initial-delay}" , fixedRateString = "${interval}")
    public void testFixRateJob() {
        log.info("Fix rate: " + LocalDateTime.now());
    }

    @Scheduled(fixedDelayString = "${interval}")
    public void testFixDelayJob() {
        log.info("Fix delay: " + LocalDateTime.now());
    }

    @Scheduled(cron = "${interval-in-cron}")
    @SchedulerLock(name = "schedule-lock")
    public void testSchedulerCron() throws InterruptedException {
        log.info("Schedule job is done at: " + LocalDateTime.now());
        Thread.sleep(4000);
    }

    @Bean
    public TaskScheduler taskScheduler() {
        final ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.setPoolSize(5);
        return taskScheduler;
    }

}
