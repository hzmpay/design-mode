package com.hzm.设计模式.代理模式;

/**
 * 代理模式测试
 *
 * @author Hezeming
 * @version 1.0
 * @date 2019年01月25日
 */
public class ParentServiceTest {

    public static void main(String[] args) {

        ParentService parentService = new ProxyParentService();

        parentService.test();
    }
}
