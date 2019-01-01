package com.eric.leetcode.thread;

public class YieldTest {

    public void yieldTest() {
        Thread thread = new Thread(() -> {
            System.out.println(Thread.currentThread() + " start");
            try {
                Thread.sleep(3000);
                Thread.yield();
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread() + " end");
        });
        Thread thread2 = new Thread(() -> {
            System.out.println(Thread.currentThread() + " start");
            try {
                Thread.sleep(3000);
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread() + " end");
        });
        thread.start();
        thread2.start();
    }

    public static void main(String args[]) {
        System.out.println("main start");
        YieldTest yieldTest = new YieldTest();
        yieldTest.yieldTest();
        System.out.println("main finish");
    }
}
