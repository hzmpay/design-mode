package com.hzm.设计模式.代理模式;

/**
 * 父级实际实现类
 *
 * @author Hezeming
 * @version 1.0
 * @date 2019年01月25日
 */
public class ParentServiceImpl implements ParentService {

    @Override
    public void test() {
        System.out.println("具体ParentService实现.......");
    }
}
