package com.java.design.proxy;

/**
 * 代理模式
 *
 * 通过代理对象获取源对象实例，获取对应的功能
 */
public class ProxyTarget implements Target {

    @Override
    public void doSomething() {
        TargetImpl target = new TargetImpl();
        target.doSomething();
    }

    public static void main(String[] args) {
        ProxyTarget proxyTarget = new ProxyTarget();
        proxyTarget.doSomething();
    }
}
