package com.werson.runnable;

/**
 * Created by wersom on 2018/3/4.
 */
public class Widget {
    public synchronized void doSomthing(){
        System.out.println("super doSomething...");
        System.out.println("super.." + Thread.currentThread().getName());
    }
}
