package com.werson.hashmap;

/**
 * Created by wersom on 2018/3/6.
 */
public class HelloB extends HelloA{

    public HelloB(){
        System.out.println("B");
    }
    {
        System.out.println("B1");
    }
    static {
        System.out.println("B2");
    }

    @Override
    public void method(int a) {

    }

    public static void main(String[] args) {
        //new HelloB();

        int i = 1;
        int result = 0;
        switch (i){
            case 1 :
                System.out.println(1);
                result = result + i;
            case 2 :
                System.out.println(2);
                result = result + i + 2;
            case 3 :
                System.out.println(3);
                result = result + i + 3;
        }
        System.out.println(result);
    }
}