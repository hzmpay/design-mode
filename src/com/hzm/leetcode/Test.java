package com.hzm.leetcode;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * @author Hezeming
 * @version 1.0
 * @date 2020年11月13日
 */
public class Test {

    public static void main(String[] args) {
        Method[] methods = Test.class.getMethods();
        for (Method method : methods) {
            System.out.println("方法:" + method.getName() + " 参数名有 ： ");
            Parameter[] parameters = method.getParameters();
            for (Parameter parameter : parameters) {
                System.out.println(parameter.getName());
            }
        }
    }
}
