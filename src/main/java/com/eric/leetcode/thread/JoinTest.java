package com.eric.leetcode.thread;

public class JoinTest {
    private Runnable mRunnable = () -> {
        System.out.println(Thread.currentThread() + "start");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread() + "end");
    };

    public void joinTest() {
        Thread thread = new Thread(mRunnable);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void joinTest(long millis) {
        Thread thread = new Thread(mRunnable);
        thread.start();
        try {
            thread.join(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void joinLockTest() {
        Thread thread = new Thread(mRunnable);
        thread.start();
        new Thread(() -> {
            synchronized (thread) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        try {
            thread.join(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        System.out.println("main start");
        JoinTest joinTest = new JoinTest();
//        joinTest.joinTest();
//        joinTest.joinTest(1000);
        joinTest.joinLockTest();
        System.out.println("main finish");
    }
}