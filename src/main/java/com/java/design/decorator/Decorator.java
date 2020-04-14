package com.java.design.decorator;

/**
 * 装饰者模式
 *
 * 动态拓展功能，类应该对扩展开放，对修改关闭。
 */
public class Decorator {
    private Thing thing;

    public Decorator(Thing thing){
        this.thing = thing;
    }

    public void  decorate(){
        System.out.println("i am ready to do something");
        thing.doSomething();
        System.out.println("ok, i did");
    }

    public static void main(String[] args) {
        Thing thing = new ThingImpl();
        Decorator decorator = new Decorator(thing);
        decorator.decorate();
    }
}
