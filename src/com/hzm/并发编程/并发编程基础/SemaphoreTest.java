package com.hzm.并发编程.并发编程基础;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Hezeming
 * @version 1.0
 * @date 2020年12月02日
 */
public class SemaphoreTest {

    public static final int count = 5;

    public static final Semaphore semaphore = new Semaphore(count);

    public static final Lock LOCK = new ReentrantLock();

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println("线程" + Thread.currentThread().getName() + "开始上厕所 ====>");
                    Thread.sleep(2000);
                    System.out.println(" ====> 线程" + Thread.currentThread().getName() + "上完厕所了");
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
