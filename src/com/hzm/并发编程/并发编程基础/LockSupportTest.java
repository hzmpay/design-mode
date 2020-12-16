package com.hzm.并发编程.并发编程基础;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @author Hezeming
 * @version 1.0
 * @date 2020年12月02日
 */
public class LockSupportTest {

    public static void main(String[] args) throws Exception {

        Thread thread = Thread.currentThread();
        Object blocker = LockSupport.getBlocker(thread);
        new Thread(() -> {
            try {
                Thread.sleep(3 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            LockSupport.unpark(thread);
            System.out.println("解锁成功 ============>");
        }).start();

        System.out.println("开始上锁 ============>");
        LockSupport.park(blocker);

//        TimeUnit.HOURS.sleep(1);

    }
}
