package com.hzm.leetcode.多线程;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * https://leetcode-cn.com/problems/print-zero-even-odd/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2020年12月01日
 */
public class 打印零与奇偶数 {

    public static void main(String[] args) throws Exception {

        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(5);
        zeroEvenOdd.zero(new IntConsumer() {
            @Override
            public void accept(int value) {
                System.out.println(value);
            }
        });

    }

    static class ZeroEvenOdd {
        private int n;

//        private volatile boolean isZero;
//        private volatile boolean isEven;
//        private volatile boolean isOdd;

        private Object zeroLock = new Object();

        private Object oddLock = new Object();

        private int num = 1;

        public ZeroEvenOdd(int n) {
            this.n = n;
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void zero(IntConsumer printNumber) throws InterruptedException {
            synchronized (zeroLock) {
                zeroLock.wait();
                printNumber.accept(0);
                zeroLock.notifyAll();
            }
        }

        public void even(IntConsumer printNumber) throws InterruptedException {
            synchronized (zeroLock) {
                zeroLock.wait();
                while (num / 2 == 0 && num > n) {
                    oddLock.wait();
                    printNumber.accept(num++);
                    oddLock.notifyAll();
                }
                zeroLock.notifyAll();
            }

        }

        public void odd(IntConsumer printNumber) throws InterruptedException {
            synchronized (zeroLock) {
                zeroLock.wait();
                while (num / 2 == 1 && num > n) {
                    oddLock.wait();
                    printNumber.accept(num++);
                    oddLock.notifyAll();
                }
                zeroLock.notifyAll();
            }
        }
    }
}
