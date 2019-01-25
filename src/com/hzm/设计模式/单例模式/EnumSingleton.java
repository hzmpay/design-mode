package com.hzm.设计模式.单例模式;

import java.lang.reflect.Constructor;

/**
 * 枚举单例
 *
 * @author Hezeming
 * @version 1.0
 * @date 2019年01月24日
 */
public enum EnumSingleton {

    INSTANCE;

    EnumSingleton(){}

    public static EnumSingleton getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) throws Exception {
        EnumSingleton singletonOne = EnumSingleton.getInstance();
        EnumSingleton singletonTwo = EnumSingleton.getInstance();
        System.out.println("One和Two是否是同一个实例？ " + (singletonOne == singletonTwo));
        //利用反射来破坏单例模式
        Constructor<EnumSingleton> constructor = EnumSingleton.class.getDeclaredConstructor(String.class, int.class);
        constructor.setAccessible(true);
        System.out.println(constructor.newInstance());
        EnumSingleton singletonThree = (EnumSingleton) constructor.newInstance(EnumSingleton.class);
        System.out.println("One和three是否是同一个实例？ "+(singletonOne==singletonThree));
    }
}
