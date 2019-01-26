package com.hzm.设计模式.代理模式.dynamic_proxy;

import com.hzm.设计模式.代理模式.ParentService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 父类具体实现代理类（动态代理）
 *
 * @author Hezeming
 * @version 1.0
 * @date 2019年01月26日
 */
public class DynamicProxyParentService implements InvocationHandler {


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        ParentService parentService = getDynamicProxyParentService();
        method.invoke(parentService, args);
        return null;
    }

    public ParentService getDynamicProxyParentService() {
        return (ParentService) Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{ParentService.class}, this);
    }
}
