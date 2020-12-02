package com.hzm.leetcode.多线程;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * https://leetcode-cn.com/problems/building-h2o/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2020年12月02日
 */
public class H2O生成 {

    public static void main(String[] args) throws Exception {
        H2O2 h2O2 = new H2O2();
        h2O2.hydrogen(() -> System.out.println("H"));
        h2O2.hydrogen(() -> System.out.println("H"));
        h2O2.hydrogen(() -> System.out.println("H"));
        h2O2.hydrogen(() -> System.out.println("H"));
        h2O2.oxygen(() -> System.out.println("O"));
        h2O2.hydrogen(() -> System.out.println("H"));
    }

    static class H2O2 {

        private volatile int hCount = 2;

        private volatile int oCount = 1;

        private Object lock = new Object();

        public H2O2() {

        }

        public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {

            // releaseHydrogen.run() outputs "H". Do not change or remove this line.
            synchronized (lock) {
                while (hCount == 0) {
                    lock.wait();
                }
                releaseHydrogen.run();
                if (hCount-- == 0) {
                    oCount = 1;
                }
                lock.notifyAll();
            }
        }

        public void oxygen(Runnable releaseOxygen) throws InterruptedException {

            // releaseOxygen.run() outputs "O". Do not change or remove this line.
            synchronized (lock) {
                while (oCount == 0) {
                    lock.wait();
                }
                releaseOxygen.run();
                oCount--;
                hCount = 2;
                lock.notifyAll();
            }
        }
    }

    class H2O {

        private Semaphore hSemaphore = new Semaphore(2);
        private Semaphore oSemaphore = new Semaphore(2);

        public H2O() {

        }

        public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {

            // releaseHydrogen.run() outputs "H". Do not change or remove this line.
            hSemaphore.acquire();
            releaseHydrogen.run();
            oSemaphore.release();
        }

        public void oxygen(Runnable releaseOxygen) throws InterruptedException {

            // releaseOxygen.run() outputs "O". Do not change or remove this line.
            oSemaphore.acquire(2);
            releaseOxygen.run();
            hSemaphore.release(2);
        }
    }
}
