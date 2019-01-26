package com.hzm.设计模式.代理模式;

/**
 * 父类具体实现代理类（实际代理）
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
