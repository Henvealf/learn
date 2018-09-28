package com.henvealf.learn.java.test;

/**
 * @author hongliang.yin/Henvealf on 2018/9/19
 */
public class TestThreadInMain {


    public static void main(String[] args) {
//
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(10000);
//                    System.out.println("I am in thread");
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        };
//        System.out.println("I am out of thread");
//        runnable.run();

//        System.out.println(Integer.parseInt(""));
        Integer a = new Integer(1);
        add(a);
        System.out.println(a);
    }

    public static void add(Integer a) {
        a +=1;
    }
}
