package com.eric.leetcode.thread;

public class WaitTest {
    public void waitTest() {
        Thread thread = new Thread(() -> {
            System.out.println(Thread.currentThread() + " start");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread() + " end");
        });
        thread.start();
        synchronized (thread) {
            try {
                thread.wait();
                System.out.println("wait end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String args[]) {
        System.out.println("main start");
        WaitTest waitTest = new WaitTest();
        waitTest.waitTest();
        System.out.println("main finish");
    }
}
