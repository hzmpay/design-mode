package com.hzm.并发编程.并发编程基础;

import java.util.concurrent.locks.LockSupport;

/**
 * @author Hezeming
 * @version 1.0
 * @date 2020年12月02日
 */
public class LockSupportTest2 {

    public static void main(String[] args) throws Exception {

        Thread parkThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("park begin");

                //等待获取许可
                LockSupport.park();
                //输出thread over.true
                System.out.println("thread over." + Thread.currentThread().isInterrupted());

            }
        });
        parkThread.start();

        Thread.sleep(2000);

        // 中断线程
        parkThread.interrupt();

        System.out.println("main over");
    }

}
