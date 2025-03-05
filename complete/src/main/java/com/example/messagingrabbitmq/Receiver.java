package com.example.messagingrabbitmq;

import java.util.concurrent.CountDownLatch;

import org.springframework.stereotype.Component;

@Component
public class Receiver {
    //每当一个线程完成了自己的任务，就调用 countDown() 方法使计数器减一；
    // 当计数器减为 0 时，所有因调用 await() 而等待的线程都会被唤醒，从而继续执行后续任务。
    private CountDownLatch latch = new CountDownLatch(1);

    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }

}
