package com.cointracker.thread.runnable;

public class JoinThread {
    public static void main(String[] args) throws Exception {
        Thread t = new Thread(
                ()->{
                    for(int i=0;i<1000;i++)
                        System.out.println("In child thread "+i);
                    Thread.currentThread().notify();
                }
        );
        t.start();
        t.join(); // Main thread executes this statement - Hence it goes on wait , providing opportunity for Child thread to complete
        for(int i=0;i<1000;i++)
            System.out.println("In Main thread "+i);
    }
}
