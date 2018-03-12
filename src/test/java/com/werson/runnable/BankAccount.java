package com.werson.runnable;

import java.util.concurrent.CountDownLatch;

/**
 * Created by wersom on 2018/1/19.
 */
public class BankAccount {

    String holderName;
    double amount;

    public BankAccount (String name, double amt) {
        holderName = name;
        amount = amt;
    }

    public void deposit(double amt) {
        amount += amt;
    }

    public void withdraw(double amt) {
        amount -= amt;
    }

    public double checkBalance() {
        return amount;
    }


    public static void main(String[] args) {
        int count = 0;
        for(int i=0; i < 100; i++){
            BankAccount A = new BankAccount("A", 2000d);
            final CountDownLatch latch = new CountDownLatch(1000);
            for(int j=0; j < 1000; j++){
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        A.deposit(2d);
                        latch.countDown();
                    }
                }).start();
            }
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(A.checkBalance());
            if(A.checkBalance() != 4000) count++;
        }
        System.out.println(count);
    }

}
