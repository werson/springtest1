package com.werson.runnable;

import com.werson.runnable.ThreadTest;

/**
 * Created by wersom on 2018/1/19.
 */
public class Father implements Runnable {
    public static String fatherActionWrite = "write";
    public static String fatherActionSend = "send";
    public static String fatherActionPutStamp = "putstamp";
    private String action;

    public void setAction(String action){
        this.action = action;
    }

    private boolean isWriteOver = false;
    private boolean letterOk = false;

    @Override
    public void run() {
        if(fatherActionWrite.equals(action)){
            System.out.println("father start writting a letter...");
            int cost = ThreadTest.getRandomNum(2000, 4000);
            try {
                Thread.sleep(cost);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("father has written done, cost time " + cost);
            isWriteOver = true;
        }else if(fatherActionSend.equals(action)){
            System.out.println("father go to sending a letter...");
            int cost = ThreadTest.getRandomNum(1000, 2000);
            try {
                Thread.sleep(cost);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("father send done, cost time " + cost);
        }else if (fatherActionPutStamp.equals(action)) {
            if(isWriteOver){
                System.out.println("father put the stamp on the letter");
                letterOk = true;
            }else{
                System.out.println("The letter has not wirtten over");
            }
        } else {
            System.out.println("father has nothing to do");
        }
    }
}
