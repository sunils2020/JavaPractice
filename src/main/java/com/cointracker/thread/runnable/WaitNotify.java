package com.cointracker.thread.runnable;

//  Wait, Notify and NotifyAll all are present as part of Object class
//  *** notify and notifyAll needs to be used inside a synchronized block
//  Typically used so that resources are properly utilized in Race condition
//  Ex: Same HashMap used by THread1, Thread2 and Main Thread
//  Each thread once it gets it cut, will go on wait until someone notifies it
//  After completing its job, it will notify other threads so that they can start the operation

public class WaitNotify {
    public static void main(String[] args) throws InterruptedException {
        WaitNotify obj = new WaitNotify();
        obj.childThread1();
        obj.childThread2();
        obj.mainThread();

    }

    public void mainThread() throws InterruptedException {
        synchronized (this){
            this.wait();
            for(int i=0;i<10;i++) {
            System.out.println("In Main thread "+i);
            }
            this.notify();
        }
    }

    public void childThread1(){
        Thread t1 = new Thread(()-> {
            try {
                synchronized (this) {
                    this.wait();
                    for (int i = 0; i < 10; i++)
                        System.out.println("In child thread 1 " + i);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        t1.start();
    }

    public void childThread2(){
        Thread t2 = new Thread(()-> {
            try {
                synchronized (this) {
                    this.notifyAll();
                    for (int i = 0; i < 10; i++)
                        System.out.println("In child thread 2 " + i);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        });
        t2.start();
    }





}
