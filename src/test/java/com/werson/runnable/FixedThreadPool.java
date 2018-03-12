package com.werson.runnable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by wersom on 2018/1/20.
 */
public class FixedThreadPool {
    public static List<Double> queue;
    public ExecutorService threadPool;

    public FixedThreadPool(){
        queue = new ArrayList<>();
        threadPool = Executors.newFixedThreadPool(5);
    }

    public static void main(String[] args) {
        FixedThreadPool outer = new FixedThreadPool();
        FixedThreadPool.Manager inner = outer.new Manager();
        Thread consumer = new Thread(inner);
        Thread producer = new Thread(){
            public void run(){
                while(true){
                    synchronized (queue) {
                        double time = 1d;
                        long startTime = System.currentTimeMillis();
                        if(System.currentTimeMillis() - startTime >= time){
                            startTime = System.currentTimeMillis();
                            for(int i = 0; i < 10; i++){
                                queue.add((Math.random() * 10000));
                            }
                            queue.notify();
                        }
                    }
                }
            }
        };
        consumer.start();
        producer.start();
    }

    class Manager implements Runnable {
        int num = 0;
        public void run(){
            while (true) {
                try {
                    synchronized (queue) {
                        System.out.println("队列长度为：" + queue.size());
                        while (queue.isEmpty()){
                            queue.wait();
                        }
                        double result = queue.remove(0);
                        num++;
                        System.out.println("成功取到数据：" + num);
                        threadPool.execute(new ExecutorThread(result));
                    }
                } catch (InterruptedException t){
                    break;
                }
            }
            threadPool.shutdown();
        }
    }

    class ExecutorThread implements Runnable {
        private double value;
        public ExecutorThread(double value){
            this.value = value;
        }
        public void run(){
            System.out.println("this is " + Thread.currentThread().getName()+""+ value);
        }
    }

}
