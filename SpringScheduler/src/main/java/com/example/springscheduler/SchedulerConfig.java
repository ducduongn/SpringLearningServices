package com.example.springscheduler;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author ducduongn
 */

@EnableScheduling
@Configuration
@ConditionalOnProperty(name = "scheduler.enable", matchIfMissing = true)
public class SchedulerConfig {

}
