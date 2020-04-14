package com.java.design.observer;

public class ObserverImpl implements Observer{

    @Override
    public void update(String msg) {
        System.out.println("i got some msg like that "+msg);
    }
}
