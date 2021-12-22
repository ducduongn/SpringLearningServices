package com.example.springscheduler.jobs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * @author ducduongn
 */
@Service
@Slf4j
public class Schedulers {

    @Scheduled(initialDelay = 2000, fixedRate = 3000)
    public void testFixDelayScheduler() {
        log.info("The time is: " + LocalDateTime.now().toEpochSecond(ZoneOffset.UTC));
    }
}
