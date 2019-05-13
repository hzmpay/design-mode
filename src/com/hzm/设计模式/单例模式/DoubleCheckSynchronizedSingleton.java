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
                /*
                 * 此处在并发情况下，可能A线程刚好执行完
                 * JVM进行SINGLETON的加载：
                 * 1.给SINGLETON对象分配内存空间
                 * 2.在对应的内存空间初始化对象
                 * 3.SINGLETON指向分配的内存地址
                 * 这时2，3步JVM可能进行重排序，这时将导致A,B线程并发时，在A线程赋值操作后，
                 * 可能3在2之前执行，SINGLETON还未进行初始化，但是又指向了内存地址，
                 * 此时B线程在null判断不为空，就返回了一个还未初始化的对象
                 *
                 * 解决方案：
                 * 1.加volatile关键字，禁止重排序（JDK1.5以上版本）
                 */
                if (SINGLETON == null) {
                    SINGLETON = new DoubleCheckSynchronizedSingleton();
                }
            }
        }
        return SINGLETON;
    }
}
