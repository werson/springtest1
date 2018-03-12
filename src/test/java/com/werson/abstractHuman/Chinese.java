package com.werson.abstractHuman;

/**
 * Created by wersom on 2018/2/28.
 */
public class Chinese extends Human {

    public void speaking(){
        System.out.println("你好！");
    }

    public void doing(){
        System.out.println("用筷子");
    }

    public static void main(String[] args) {
        Human chinese = new Chinese();
        chinese.speaking();
    }

}
