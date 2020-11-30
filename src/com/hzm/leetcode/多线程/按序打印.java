package com.hzm.leetcode.多线程;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * https://leetcode-cn.com/problems/print-in-order/solution/an-xu-da-yin-by-leetcode/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2020年11月27日
 */
public class 按序打印 {

    public static void main(String[] args) throws Exception {
        Foo foo = new Foo();
        foo.first(() -> System.out.println("A"));
        foo.third(() -> System.out.println("C"));
        foo.second(() -> System.out.println("B"));
    }


    static class Foo {

        private Object object = new Object();
        private boolean isFirst;
        private boolean isSecond;

        public Foo() {

        }

        public void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            synchronized (object) {
                printFirst.run();
                isFirst = true;
                object.notifyAll();
            }
        }

        public void second(Runnable printSecond) throws InterruptedException {

            // printSecond.run() outputs "second". Do not change or remove this line.
            synchronized (object) {
                while (!isFirst) {
                    object.wait();
                }
                printSecond.run();
                isSecond = true;
                object.notifyAll();
            }

        }

        public void third(Runnable printThird) throws InterruptedException {

            // printThird.run() outputs "third". Do not change or remove this line.
            synchronized (object) {
                while (!isSecond) {
                    object.wait();
                }
                printThird.run();
            }
        }
    }
}
