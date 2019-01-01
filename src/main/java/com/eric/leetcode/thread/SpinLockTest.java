package com.eric.leetcode.thread;

public class SpinLockTest {
    private SpinLock spinLock = new SpinLock();
    private ReentrySpinLock reentrySpinLock = new ReentrySpinLock();

    public void spinLockTest() {
        Thread thread = new Thread(() -> {
            System.out.println(Thread.currentThread() + " start");
            try {
//                spinLock.lock();
                reentrySpinLock.lock();
                reentrySpinLock.lock();
//                spinLock.lock(); // 死锁，非可重用
                Thread.sleep(1000);
                reentrySpinLock.unLock();
                reentrySpinLock.unLock();
//                spinLock.unLock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread() + " end");
        });
        thread.start();

        Thread thread2 = new Thread(() -> {
            System.out.println(Thread.currentThread() + " start");
            try {
//                spinLock.lock();
                reentrySpinLock.lock();
                Thread.sleep(1000);
                reentrySpinLock.unLock();
//                spinLock.unLock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread() + " end");
        });
        thread2.start();
    }

    public static void main(String args[]) {
        System.out.println("main start");
        SpinLockTest spinLockTest = new SpinLockTest();
        spinLockTest.spinLockTest();
        System.out.println("main finish");
    }
}
