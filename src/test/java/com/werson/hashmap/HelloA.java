package com.werson.hashmap;

/**
 * Created by wersom on 2018/3/6.
 */
public abstract class HelloA {

    public void method(){
    }

    public abstract void method(int a);

    public HelloA(){
        System.out.println("A");
    }
    {
        System.out.println("A1");
    }
    static {
        System.out.println("A2");
    }

}
