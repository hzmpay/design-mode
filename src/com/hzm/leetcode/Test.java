package com.hzm.leetcode;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Hezeming
 * @version 1.0
 * @date 2020年11月13日
 */
public class Test {

    public static void main(String[] args) {
//        Method[] methods = Test.class.getMethods();
//        for (Method method : methods) {
//            System.out.println("方法:" + method.getName() + " 参数名有 ： ");
//            Parameter[] parameters = method.getParameters();
//            for (Parameter parameter : parameters) {
//                System.out.println(parameter.getName());
//            }
//        }

        System.out.println("AaAa".hashCode());
        System.out.println("BBBB".hashCode());

        //正常用法
        Map<String,String> map2 = new ConcurrentHashMap<>();
//        String value1 = map2.computeIfAbsent("AaAa",n->"123");
//        System.out.println(value1);
        //bug重现
        map2.computeIfAbsent("AaAa",(n)->{
            return map2.computeIfAbsent("BBBB",m->"123");
        });
    }
}
