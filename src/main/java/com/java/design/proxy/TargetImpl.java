package com.java.design.proxy;

public class TargetImpl implements Target {
    @Override
    public void doSomething() {
        System.out.println("targer do something");
    }
}
