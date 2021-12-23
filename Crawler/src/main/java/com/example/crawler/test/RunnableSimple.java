package com.example.crawler.test;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ducduongn
 */

@Slf4j
public class RunnableSimple implements Runnable{

    @Override
    public void run() {
      log.info("Thread is running!");
    }

    public static void main(String[] args) {
        RunnableSimple runnableSimple = new RunnableSimple();
        Thread thread1 = new Thread(runnableSimple);

        thread1.start();
    }
}
