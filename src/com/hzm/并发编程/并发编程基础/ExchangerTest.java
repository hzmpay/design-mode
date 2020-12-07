package com.hzm.并发编程.并发编程基础;

import java.util.concurrent.Exchanger;

/**
 * @author Hezeming
 * @version 1.0
 * @date 2020年12月07日
 */
public class ExchangerTest {

    public static final Exchanger<String> exchanger = new Exchanger();
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                String a = exchanger.exchange("A");
                System.out.println("t1线程等待结果：" + a);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                String b = exchanger.exchange("B");
                System.out.println("t2线程等待结果：" + b);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
