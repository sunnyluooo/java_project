package com.java.design.factory;

/**
 * 抽象工厂模式
 *
 * [优] 根据子类创建对应的工厂类，易添加，不用改动原来代码
 */
public abstract class AbstractFactory {
    public abstract Parent make();
}
