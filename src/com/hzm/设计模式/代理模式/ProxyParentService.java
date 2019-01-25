package com.hzm.设计模式.代理模式;

/**
 * 父类实际实现代理类
 *
 * @author Hezeming
 * @version 1.0
 * @date 2019年01月25日
 */
public class ProxyParentService implements ParentService {

    private ParentService parentService = new ParentServiceImpl();

    @Override
    public void test() {
        System.out.println("代理类中间处理====================>");
        parentService.test();
    }
}
