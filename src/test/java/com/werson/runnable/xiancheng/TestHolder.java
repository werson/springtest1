package com.werson.runnable.xiancheng;

import java.util.Hashtable;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by wersom on 2018/3/4.
 */
public class TestHolder {

    public Holder holder;

    public void init(int num){
        holder = new Holder(num);
    }

    public static void main(String[] args) {
        Hashtable hashtable = new Hashtable();
        TestHolder testHolder = new TestHolder();
        testHolder.init(new Random().nextInt());
        for(int n = 0; n < 1000; n++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    TestHolder testHolder1 = new TestHolder();
                    testHolder1.init(new Random().nextInt());
                    testHolder1.holder.check();
                }
            }).start();
        }
    }

}
