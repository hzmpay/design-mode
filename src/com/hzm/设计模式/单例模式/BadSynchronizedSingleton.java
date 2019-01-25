package com.hzm.设计模式.单例模式;

/**
 * 加锁单例
 *
 * @author Hezeming
 * @version 1.0
 * @date 2019-01-07
 */
public class BadSynchronizedSingleton {

    private volatile static BadSynchronizedSingleton SINGLETON;

    /**
     * 私有化构造函数
     *
     * @param
     * @return
     * @author Hezeming
     */
    private BadSynchronizedSingleton() {
    }

    /**
     * 加同步关键字锁方法
     *
     * @param
     * @return com.hzm.设计模式.单例模式.BadSynchronizedSingleton
     * @author Hezeming
     */
    public synchronized static BadSynchronizedSingleton getInstance() {
        if (SINGLETON == null) {
            SINGLETON = new BadSynchronizedSingleton();
        }
        return SINGLETON;
    }
}
