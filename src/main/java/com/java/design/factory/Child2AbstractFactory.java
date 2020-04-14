package com.java.design.factory;

public class Child2AbstractFactory extends AbstractFactory {
    @Override
    public Parent make() {
        return new Child2();
    }
}
