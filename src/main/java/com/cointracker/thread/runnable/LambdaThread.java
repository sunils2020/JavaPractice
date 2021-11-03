package com.cointracker.thread.runnable;

public class LambdaThread {
    public static void main(String[] args) {
        Thread[] threads = new Thread[100];
        for (int i=0;i<threads.length;i++){
            threads[i] = new Thread(()-> System.out.println("Thread-ID "+ Thread.currentThread().getName()));
        }

        for (int i=0;i<threads.length;i++){
            threads[i].start();
        }
    }
}
