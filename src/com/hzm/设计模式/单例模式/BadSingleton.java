package com.hzm.设计模式.单例模式;

/**
 * 普通单例
 *
 * @author Hezeming
 * @version 1.0
 * @date 2019-01-07
 */
public class BadSingleton {

    private volatile static BadSingleton SINGLETON;

    /**
     * 私有化构造函数
     *
     * @param
     * @return
     * @author Hezeming
     */
    private BadSingleton() {
    }

    public static BadSingleton getInstance() {
        if (SINGLETON == null) {
            SINGLETON = new BadSingleton();
        }
        return SINGLETON;
    }


}
