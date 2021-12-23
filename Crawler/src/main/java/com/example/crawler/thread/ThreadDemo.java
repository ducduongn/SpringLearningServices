package com.example.crawler.thread;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ducduongn
 */

@Slf4j
public class ThreadDemo implements Runnable {
    private Thread thread;
    private String threadName;

    public ThreadDemo(String threadName) {
        this.threadName = threadName;
        log.info("Creating thread "+ this.threadName);
    }

    @Override
    public void run() {
        log.info("Runing thread " + this.threadName + "...");
        try {
            for (int i = 4; i >=0 ; i--) {
                log.info("Thread: " + threadName + ", " + i);
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            log.error("Thread " + threadName + " is interupted!");
        }
        log.info("Thread " + threadName + " is stop!");
    }

    public void start() {
        log.info("Start " + threadName);
        if (thread == null) {
            thread = new Thread(this, threadName);
            thread.start();
        }
    }
}
