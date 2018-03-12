package com.werson.runnable.xiancheng;

/**
 * Created by wersom on 2018/3/4.
 */
public class Holder {
    private int n;

    public Holder(int n) { this.n = n;}

    public void check(){
        if(n != n){
            throw new AssertionError("holder error");
        }
    }

}
