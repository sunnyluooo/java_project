package com.java.design.observer;

public interface Subject {

    void registObs(Observer obs);

    void removeObs(Observer obs);

    void notifyAllObs();
}
