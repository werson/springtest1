package com.werson.hashmap;

import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static javafx.scene.input.KeyCode.T;

/**
 * Created by wersom on 2018/2/24.
 */
public class TestMain {

    @Test
    public void test1(){
        int a = 4;
        int b = a & 1;
        System.out.println(b);
    }

    @Test
    public void test2(){
        Set<String> a = new HashSet();
        a.add("aaa");

    }

    @Test
    public void test3(){
        String str1 = "hello";
        String str2 = "he" + new String("llo");
        System.out.println(str1 == str2);
        str2 = "he" + "llo";
        System.out.println(str1 == str2);
        System.out.println(Integer.valueOf("127")==Integer.valueOf("127"));
        System.out.println(Integer.valueOf("128")==Integer.valueOf("128"));
        System.out.println(Integer.parseInt("128")==Integer.valueOf("128"));
    }


    @Test
    public void testInt(){
        int a = 2;
        for(int i = 1; i< 31; i++){
            System.out.println("a = " + a);
            a = a * 2;
            System.out.println("bit = " + Integer.toBinaryString(a));
        }
        System.out.println("a = " + a);
    }

    @Test
    public void testMaxInt(){
        //int max = (int)(2147483648L - 1);
        /*int max = 8;
        String bit = Integer.toBinaryString(max);
        int countZero = Integer.numberOfLeadingZeros(max);
        System.out.println("bit = " + bit);
        System.out.println("countZero = " + countZero);*/


        int resMax = Integer.reverse(-1155530752);
        System.out.println("resMax = " + resMax);


        /*int min = -2147483648;
        String bitMin = Integer.toBinaryString(min);
        System.out.println("bit = " + bitMin);
        System.out.println(new StringBuilder(bitMin).reverse().toString());*/
    }

    @Test
    public void encrypt(){
        String logStr = "type=SYSCALL msg=audit(1434371271.277:135496) arch=c000003e syscall=2 success=yes exit=3 a0=7fff0054e929 a1=0 a2=1fffffffffff0000 a3=7fff0054c390 items=1 ppid=6265 pid=6266 auid=1000 uid=0 gid=0 euid=0 suid=0 fsuid=0 egid=0 sgid=0 fsgid=0 tty=pts0 ses=113 comm=\"cat\" exe=\"/usr/bin/cat\" key=\"ssh config change\"";
        String regEx = "[a-z]+=(([\"][^\"]+[\"])|[\\S]+)";
        Pattern pat = Pattern.compile(regEx);
        Matcher mat = pat.matcher(logStr);
        HashMap<String, Object> result = new HashMap<>();
        while(mat.find()) {
            String str = mat.group();
            String key = str.substring(0, str.indexOf("="));
            String value = str.substring(str.indexOf("=")+1, str.length());
            if(NumberUtils.isNumber(value)){
                result.put(key, Integer.parseInt(value));
            }else{
                result.put(key, value.replaceAll("\"", ""));
            }
        }
    }

    @Test
    public void testRegEx(){
        String regEx = "<a>([\\d]*?)</a>";
        String s = "<a>123</a><a>456</a><a>789</a>";
        Pattern pat = Pattern.compile(regEx);
        Matcher mat = pat.matcher(s);
        while(mat.find()) {
            System.out.println(mat.group());
        }
    }

    @Test
    public void testRegEx2(){
        String str = "2015/07/20 11:01 来源: 测试 2015/07/20 11:04";
        String regex = "\\d{4}[-|/]\\d{2}[-|/]\\d{2} \\d{2}:\\d{2}";
        Pattern p = Pattern.compile(regex);
        Matcher matcher = p.matcher(str);
        while(matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    @Test
    public void testInteger(){
        int a = 0;
        Integer b = 0;
        int c = new Integer(0);
        Integer d = new Integer(0);
        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(b == c);
        System.out.println(b == d);
        System.out.println(c == d);
    }

    @Test
    public void testList(){
        List<String> nameList = new ArrayList<>();
        nameList.add("werson");
        nameList.add("gejian");
        System.out.println(nameList.get(1));
        Iterator a = nameList.iterator();
        if(a.hasNext()){
            System.out.println(a.next());
        }

        Map<String, String> map = new HashMap<>();
        map.put("aaa", "1111");
        map.put("bbb", "2222");

        String s = null;
        System.out.println("s=" + s);
    }

    @Test
    public void testLock() throws InterruptedException{

    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread() {
            @Override
            public void run() {
                System.out.print("pong");
            }
        };
        t.start();
        //Thread.sleep(3L);
        System.out.print("ping");
    }

    public static void pong(){
        System.out.print("pong");
    }

    /*public static void main(String[] args) throws InterruptedException {
        final ExecutorService exec = Executors.newFixedThreadPool(4);
        final ReentrantLock lock = new ReentrantLock();
        //final Condition con = lock.newCondition();
        final int time = 5;

        final Runnable add = new Runnable() {
            public void run() {
                System.out.println("Pre " + lock);

                lock.lock();
                try {
                    //con.await(time, TimeUnit.SECONDS);
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("Post " + lock.toString());
                    lock.unlock();
                }
            }
        };

        for(int index = 0; index < 4; index++)
            exec.submit(add);
        exec.shutdown();
    }*/


}
