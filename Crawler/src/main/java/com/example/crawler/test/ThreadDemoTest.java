package com.example.crawler.test;

import com.example.crawler.thread.ThreadDemo;
import lombok.extern.slf4j.Slf4j;

/**
 * @author ducduongn
 */
@Slf4j
public class ThreadDemoTest {
    public static void main(String[] args) {
        log.info("Starting main thread...");

        ThreadDemo thread1 = new ThreadDemo("Thread1");
        thread1.start();

        ThreadDemo thread2 = new ThreadDemo("Thread2");
        thread2.start();

        log.info("Stop main thread.");
    }
}
