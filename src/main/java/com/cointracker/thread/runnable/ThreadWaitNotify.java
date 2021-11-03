package com.cointracker.thread.runnable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadWaitNotify {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        LinkedList<Integer> set = new LinkedList();


        Thread t1 = new Thread(() -> {
            //lock.lock();
            for (int i=0;i<1000000;i++){
                System.out.println(i+"Thread1");
                set.add(i);
                System.out.println(set.toString());
            }
            //lock.unlock();
            Thread.currentThread().notify();
        },"Thread--1"
        );
        Thread t2 = new Thread(() -> {
            try {
                    Thread.currentThread().wait();
                // Thread.yield(); // Not used - depends on the operating system
                //Thread.currentThread().join();  // This is used widely
            } catch (Exception e) {
                e.printStackTrace();





            }
            for (int i=0;i<Integer.MAX_VALUE;i++){
                for(int j=0;j<set.size();j++) System.out.println(set.get(j));
                set.remove(i);
                System.out.println(i+"Thread2");
            }
        },"Thread--2"
        );

        t1.start();
        t2.start();

    }
}
