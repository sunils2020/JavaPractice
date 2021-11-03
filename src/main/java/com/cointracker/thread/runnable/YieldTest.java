package com.cointracker.thread.runnable;



public class YieldTest {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {

            for (int i=0;i<Integer.MAX_VALUE;i++){
                    System.out.println(i+"Thread1");
                }
            },"Thread--1"
        );
        Thread t2 = new Thread(() -> {
            try {
                Thread.yield(); // Not used - depends on the operating system
                //Thread.currentThread().join();  // This is used widely
            } catch (Exception e) {
                e.printStackTrace();
            }

            for (int i=0;i<Integer.MAX_VALUE;i++){
                System.out.println(i+"Thread2");
            }
        },"Thread--2"
        );

        t1.start();
        t2.start();

    }
}
