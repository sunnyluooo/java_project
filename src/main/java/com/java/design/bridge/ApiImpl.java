package com.java.design.bridge;

/**
 * 桥接模式
 *
 * 是用于把抽象化与实现化解耦，使得二者可以独立变化
 */
public class ApiImpl extends ApiAbrstract {

    public ApiImpl(ApiInterface apiInterface){
        super(apiInterface);
    }

    @Override
    public void doSomething() {
        apiInterface.doSomething();
    }
}
