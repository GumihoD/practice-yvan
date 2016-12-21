package com.yvan.practice.test.proxy;

import org.junit.Test;

import java.lang.reflect.Proxy;

/**
 * Created by yvan on 2016/12/19.
 */
public class ForumServiceImplTest {

    @Test
    public void testJDKProxy() {
        /** 希望被代理的目标业务类 */
        ForumService target = new ForumServiceImpl();
        /** 将目标业务类和横切代码编织到一起 */
        PerformanceHandle handle = new PerformanceHandle(target);
        /** 根据 编织了目标业务类逻辑和性能监视横切逻辑的InvocationHandler 实例创建代理实例
         *  第二个参数为 需要代理的实例实现的接口列表 此为JDK动态代理的局限性：只能为接口创建代理实例
         */
        ForumService proxy = (ForumService) Proxy.newProxyInstance(
                target.getClass().getClassLoader(), target.getClass().getInterfaces(), handle);
        proxy.removeForum(10);
        proxy.removeTopic(11);
    }

    @Test
    public void testCglibProxy() {
        CglibProxy cglibProxy = new CglibProxy();
        /** 通过动态生成子类的方式创建代理类 */
        ForumServiceImpl obj = (ForumServiceImpl) cglibProxy.getProxy(ForumServiceImpl.class);
        obj.removeTopic(1);
        obj.removeForum(2);

    }

}