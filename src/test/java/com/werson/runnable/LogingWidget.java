package com.werson.runnable;

/**
 * Created by wersom on 2018/3/4.
 */
public class LogingWidget extends Widget {

    public synchronized void doSomething(){
        System.out.println("sub doSomething..");
        System.out.println("sub.." + Thread.currentThread().getName());
        super.doSomthing();
    }

    public static void main(String[] args) {
        new LogingWidget().doSomething();
    }

}
