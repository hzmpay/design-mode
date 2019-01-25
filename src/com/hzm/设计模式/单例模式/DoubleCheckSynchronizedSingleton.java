package com.hzm.设计模式.单例模式;

/**
 * 双重锁单例
 *
 * @author Hezeming
 * @version 1.0
 * @date 2019-01-07
 */
public class DoubleCheckSynchronizedSingleton {

    private volatile static DoubleCheckSynchronizedSingleton SINGLETON;

    /**
     * 私有化构造函数
     *
     * @param
     * @return
     * @author Hezeming
     */
    private DoubleCheckSynchronizedSingleton() {
    }

    /**
     * 双重检查加锁
     *
     * @param
     * @return com.hzm.设计模式.单例模式.DoubleCheckSynchronizedSingleton
     * @author Hezeming
     */
    public static DoubleCheckSynchronizedSingleton getInstance() {
        if (SINGLETON == null) {
            synchronized (DoubleCheckSynchronizedSingleton.class) {
                if (SINGLETON == null) {
                    SINGLETON = new DoubleCheckSynchronizedSingleton();
                }
            }
        }
        return SINGLETON;
    }
}
