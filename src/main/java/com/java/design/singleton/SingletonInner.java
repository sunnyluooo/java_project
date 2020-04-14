package com.java.design.singleton;

/**
 * 单例模式内部类模式
 */
public class SingletonInner {

    private SingletonInner(){

    }

    private static class SingletonInnerHolder{
        private static SingletonInner instance = new SingletonInner();
    }

    /**
     * 类加载时不加载内部类，需要实例化时才会装载内部类，线程安全，延迟加载，效率高
     */
    public static SingletonInner getInstance(){
        return SingletonInnerHolder.instance;
    }
}
