package com.java.design.bridge;

public abstract class ApiAbrstract {
    protected ApiInterface apiInterface;

    public ApiAbrstract(ApiInterface apiInterface){
        this.apiInterface = apiInterface;
    }

    public abstract void doSomething();
}
