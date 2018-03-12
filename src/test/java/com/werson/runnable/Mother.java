package com.werson.runnable;

/**
 * Created by wersom on 2018/1/19.
 */
public class Mother implements Runnable {

    @Override
    public void run() {
        System.out.println("mom is cooking... ");
        int cost = ThreadTest.getRandomNum(3000, 6000);
        try {
            Thread.sleep(cost);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("mom has done, cost time : " + cost);
    }
}
