package com.java.design.factory;

public class Child1AbstractFactory extends AbstractFactory {
    @Override
    public Parent make() {
        return new Child1();
    }
}
