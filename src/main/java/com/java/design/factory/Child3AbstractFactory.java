package com.java.design.factory;

public class Child3AbstractFactory extends AbstractFactory {
    @Override
    public Parent make() {
        return new Child3();
    }
}
