package com.java.design.observer;

import java.util.HashSet;
import java.util.Set;

/**
 * 观察者模式
 *
 */
public class SubjectImpl implements Subject {

    private static Set<Observer> observers = new HashSet<>();

    @Override
    public void registObs(Observer obs) {
        observers.add(obs);

    }

    @Override
    public void removeObs(Observer obs) {
        observers.remove(obs);
    }

    @Override
    public void notifyAllObs() {
        observers.forEach(e->{
            e.update("you have a new msg");
        });
    }

    public static void main(String[] args) {
        Subject subject = new SubjectImpl();
        ObserverImpl obs1 = new ObserverImpl();
        ObserverImpl obs2 = new ObserverImpl();
        subject.registObs(obs1);
        subject.registObs(obs2);
        subject.notifyAllObs();
    }
}
