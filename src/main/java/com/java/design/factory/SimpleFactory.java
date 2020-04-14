package com.java.design.factory;

/**
 * 简单工厂模式
 *
 * [缺] 如果添加实例，需要改动原来代码
 */
public class SimpleFactory {

    enum ChildType {
        child1,child2,child3;
    }

    public Parent make(ChildType childType){

        switch (childType){
            case child1:
                return new Child1();
            case child2:
                return new Child2();
            case child3:
                return new Child3();
            default:
                return null;
        }
    }


    public static void main(String[] args) {
        //简单工厂
        SimpleFactory factory = new SimpleFactory();
        Parent make = factory.make(ChildType.child1);

        //抽象工厂
        Child1AbstractFactory child1AbstractFactory = new Child1AbstractFactory();
        Parent make1 = child1AbstractFactory.make();
    }
}
