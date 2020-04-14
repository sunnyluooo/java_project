package com.java.design.singleton;

/**
 * 单例模式懒汉模式
 */
public class SingletonLanHan {

    /**无法通过new来创建对象*/
    private SingletonLanHan(){

    };

    private static SingletonLanHan instanceV1;

    /**线程不安全，可能会构造多个实例*/
    public static SingletonLanHan getInstanceV1(){
        if (instanceV1==null) instanceV1 = new SingletonLanHan();
        return instanceV1;
    }

    private static SingletonLanHan instanceV2;

    /**线程安全，同步锁代码块，效率偏低*/
    public synchronized static SingletonLanHan getInstanceV2(){
        if (instanceV2==null) instanceV2 = new SingletonLanHan();
        return instanceV2;
    }

    private static SingletonLanHan instanceV3;

    /**线程不安全，锁内没有再次检验，因此仍会出现构造多个实例的情况*/
    public static SingletonLanHan getInstanceV3(){
        if (instanceV3==null) {
            synchronized (SingletonLanHan.class){
                instanceV3 = new SingletonLanHan();
            }
        }
        return instanceV3;
    }

    private static SingletonLanHan instanceV4;

    /**线程安全，双重检验，保证了延迟加载和线程安全*/
    public static SingletonLanHan getInsanceV4(){
        if(instanceV4==null){
            synchronized (SingletonLanHan.class){
                if(instanceV4==null){
                    instanceV4 = new SingletonLanHan();
                }
            }
        }
        return instanceV4;
    }

}
