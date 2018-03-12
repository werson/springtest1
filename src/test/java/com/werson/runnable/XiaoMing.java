package com.werson.runnable;

/**
 * Created by wersom on 2018/1/19.
 */
public class XiaoMing implements Runnable {
    @Override
    public void run() {
        System.out.println("father asked Xiao Ming go to buy a stamp ");
        int cost = ThreadTest.getRandomNum(1000, 2000);
        try {
            Thread.sleep(cost);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Xiao Ming come back , cost time " + cost);
    }
}
