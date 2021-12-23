package com.example.crawler.test;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ducduongn
 */
@Slf4j
public class ThreadSimple extends Thread{
    public void run() {
        log.info("Thread is running");
    };

    public static void main(String[] args) {
        ThreadSimple threadSimple = new ThreadSimple();

        threadSimple.start();
    }
}
