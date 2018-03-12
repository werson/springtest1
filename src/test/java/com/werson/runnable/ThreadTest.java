package com.werson.runnable;

import org.junit.Test;

import java.util.Random;

/**
 * Created by wersom on 2018/1/19.
 */
public class ThreadTest {

    @Test
    public void sendMsgTest(){
        Thread father = new Thread(new Father());
        //Thread xiaoMing = new Thread(new XiaoMing());
        father.start();
        //xiaoMing.start();
    }

    public static void main(String[] args) {
        System.out.println("######################################");
        Father father = new Father();
        father.setAction(Father.fatherActionWrite);
        Thread fatherThread = new Thread(father);
        Thread xiaoMing = new Thread(new XiaoMing());
        Thread mom = new Thread(new Mother());
        fatherThread.start();
        xiaoMing.start();
        mom.start();
        try {
            fatherThread.join();
            if (!fatherThread.isAlive()) {//如果父亲写完了信
                xiaoMing.join();
                if (!xiaoMing.isAlive()) {
                    father.setAction(Father.fatherActionPutStamp);
                    Thread fatherThread2 = new Thread(father);
                    fatherThread2.start();
                    fatherThread2.join();
                    if (!fatherThread2.isAlive()) {
                        if (mom.isAlive()) {
                            System.out.println("妈妈还没做完饭");
                            father.setAction(Father.fatherActionSend);
                            Thread fatherThread3 = new Thread(father);
                            fatherThread3.start();
                            fatherThread3.join();
                            mom.join();
                        } else {
                            System.out.println("妈妈做完了饭，开始吃饭。");
                        }
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("######################################");
    }

    public static int getRandomNum (int fromNum, int toNum) {
        Random random = new Random();
        int res = random.nextInt(toNum - fromNum);
        return res+fromNum;
    }

}
