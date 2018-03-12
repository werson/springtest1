package com.werson.huarongroad;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by wersom on 2018/2/2.
 */
public class MainRoad {

    private static int x=3, y=3;//横坐标 纵坐标
    //private static int[][] road = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,0}};
    private static int[][] road = {{1,2,3,4},{5,6,7,8},{0, 10, 11, 12},{9, 13, 14, 15}};

    @Test
    public void mainRoad(){
        int action = getRandomNum(1,5);
        for(;;){
            doAction(action);
            action = getRandomNum(1,5);
            if(isComplete()){
                showRoad();
                break;
            }
        }
        showRoad();
    }

    public static void doAction(int action){
        switch (action){
            case 1: up();break;
            case 2: down();break;
            case 3: left();break;
            case 4: right();break;
            default:break;
        }
    }

    public static void up(){
        if(x > 0){
            System.out.println("上");
            int thisNum = road[x-1][y];
            road[x-1][y] = 0;
            road[x][y] = thisNum;
            x -= 1;
        }
    }

    public static void down(){
        if(x < 3){
            System.out.println("下");
            int thisNum = road[x+1][y];
            road[x+1][y] = 0;
            road[x][y] = thisNum;
            x += 1;
        }
    }

    public static void left(){
        if(y > 0){
            System.out.println("左");
            int thisNum = road[x][y-1];
            road[x][y-1] = 0;
            road[x][y] = thisNum;
            y -= 1;
        }
    }

    public static void right(){
        if(y < 3){
            System.out.println("右");
            int thisNum = road[x][y+1];
            road[x][y+1] = 0;
            road[x][y] = thisNum;
            y += 1;
        }
    }

    public static boolean isComplete(){
        int gridNum = 1;
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                if((road[i][j] != gridNum && gridNum < 16 )|| (gridNum == 16 && road[i][j] != 0)){
                    return false;
                }
                gridNum++;
            }
        }
        return true;
    }

    public static void showRoad(){
        System.out.println("***********************************");
        for(int i = 0; i < 4; i++){
            System.out.println(Arrays.toString(road[i]));
        }
        System.out.println("***********************************");
    }

    public static int getRandomNum (int fromNum, int toNum) {
        Random random = new Random();
        int res = random.nextInt(toNum - fromNum);
        return res+fromNum;
    }

}
