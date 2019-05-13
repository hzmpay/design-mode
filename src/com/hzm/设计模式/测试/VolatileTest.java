package com.hzm.设计模式.测试;

/**
 * volatile测试
 *
 * @author Hezeming
 * @version 1.0
 * @date 2019年05月13日
 */
public class VolatileTest extends Thread {

    public static boolean flag = false;

    @Override
    public void run() {
        while (!flag) {
            System.out.println("执行中");
        }
    }

    public static void main(String[] args) throws InterruptedException {

        new VolatileTest().start();
        Thread.sleep(100);
        flag = true;
        System.out.println("flag改变成功");
        Thread.sleep(1000);
        // 32位的机器可以设置JVM以client模式执行，此时while循环不会退出，
        // 64位的机器只能是Server模式
        System.out.println("程序执行结束");

    }
}

