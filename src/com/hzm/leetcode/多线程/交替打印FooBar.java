package com.hzm.leetcode.多线程;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * https://leetcode-cn.com/problems/print-foobar-alternately/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2020年12月02日
 */
public class 交替打印FooBar {

    public static void main(String[] args) {

    }

    /**
     * Condition方式
     *
     * @author Hezeming
     * @version 1.0
     * @data 2020年12月02日
     */
    static class FooBar3 {

        private Lock lock = new ReentrantLock();

        private Condition condition = lock.newCondition();

        private boolean isFoo = true;

        private int n;

        public FooBar3(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {

                // printFoo.run() outputs "foo". Do not change or remove this line.
                lock.lock();
                try {
                    while (!isFoo) {
                        condition.await();
                    }
                    printFoo.run();
                    isFoo = false;
                    condition.signalAll();
                } finally {
                    lock.unlock();
                }
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {

                // printBar.run() outputs "bar". Do not change or remove this line.
                lock.lock();
                try {
                    while (isFoo) {
                        condition.await();
                    }
                    printBar.run();
                    isFoo = true;
                    condition.signalAll();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    /**
     * Semaphore方式
     *
     * @author Hezeming
     * @version 1.0
     * @data 2020年12月02日
     */
    static class FooBar2 {

        private Semaphore fooSemaphore = new Semaphore(1);
        private Semaphore barSemaphore = new Semaphore(0);

        private int n;

        public FooBar2(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {

                // printFoo.run() outputs "foo". Do not change or remove this line.
                fooSemaphore.acquire();
                printFoo.run();
                barSemaphore.release();
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {

                // printBar.run() outputs "bar". Do not change or remove this line.
                barSemaphore.acquire();
                printBar.run();
                fooSemaphore.release();
            }
        }
    }

    /**
     * wait,notify方式
     *
     * @author Hezeming
     * @version 1.0
     * @data 2020年12月02日
     */
    static class FooBar {

        private Object lock = new Object();

        private boolean isFoo = true;

        private int n;

        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {

                // printFoo.run() outputs "foo". Do not change or remove this line.
                synchronized (lock) {
                    while (!isFoo) {
                        lock.wait();
                    }
                    printFoo.run();
                    isFoo = false;
                    lock.notifyAll();
                }
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {

                // printBar.run() outputs "bar". Do not change or remove this line.
                synchronized (lock) {
                    while (isFoo) {
                        lock.wait();
                    }
                    printBar.run();
                    isFoo = true;
                    lock.notifyAll();
                }
            }
        }
    }
}
