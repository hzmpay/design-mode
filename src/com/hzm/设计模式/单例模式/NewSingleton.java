package com.hzm.设计模式.单例模式;

import java.lang.reflect.Constructor;

/**
 * 类初始化直接创建的单例
 *
 * @author Hezeming
 * @version 1.0
 * @date 2019-01-07
 */
public class NewSingleton {

    /**
     * 私有化构造函数
     *
     * @param
     * @return
     * @author Hezeming
     */
    private NewSingleton() {
    }

    public static NewSingleton getInstance() {
        return SingleTon.SINGLETON;
    }

    private static class SingleTon {
        private static final NewSingleton SINGLETON = new NewSingleton();
    }

    public static void main(String[] args) throws NoSuchMethodException {
        NewSingleton instance = NewSingleton.getInstance();
        NewSingleton instance1 = NewSingleton.getInstance();
        Constructor<NewSingleton> constructor = NewSingleton.class.getDeclaredConstructor(String.class, int.class);

    }


}
