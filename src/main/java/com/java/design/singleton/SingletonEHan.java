package com.java.design.singleton;

/**
 * 单例模式饿汉模式
 * 1.私有化该类的构造函数
 * 2.定义一个公共方法返回唯一实例
 *
 * [优] 不会产生线程问题
 * [缺] 在类加载的时候就已经初始化，造成内存浪费
 */
public class SingletonEHan {

    /**无法通过new来创建对象*/
    private SingletonEHan(){

    }
    private static SingletonEHan instanceV1 = new SingletonEHan();

    public static SingletonEHan getInstanceV1(){
        return instanceV1;
    }


    private static SingletonEHan instanceV2 = null;

    /**
     * 静态代码块在类被加载的时候就运行了，而且只运行一次，并且优先于各种代码块以及构造函数。
     * 如果一个类中有多个静态代码块，会按照书写顺序依次执行。
     */
    static {
        instanceV2 = new SingletonEHan();
    }

    public static SingletonEHan getInstanceV2(){
        // （可忽略）if(instanceV2 == null) instanceV2 = new SingletonEHan();
        return instanceV2;
    }

}
