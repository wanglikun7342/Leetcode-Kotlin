package com.eric.leetcode.thread;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {
    private Semaphore semaphore = new Semaphore(2);

    private void semaphoreTest() {
        Thread thread1 = new Thread(() -> {
            System.out.println(Thread.currentThread() + " start");
            try {
                semaphore.acquire();
                System.out.println("thread1 get Semaphore");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
            System.out.println(Thread.currentThread() + " end");
        });
        thread1.start();

        Thread thread2 = new Thread(() -> {
            System.out.println(Thread.currentThread() + " start");
            try {
                semaphore.acquire();
                System.out.println("thread2 get Semaphore");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
            System.out.println(Thread.currentThread() + " end");
        });
        thread2.start();

        Thread thread3 = new Thread(() -> {
            System.out.println(Thread.currentThread() + " start");
            try {
                semaphore.acquire();
                System.out.println("thread3 get Semaphore");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
            System.out.println(Thread.currentThread() + " end");
        });
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        System.out.println("main start");
        SemaphoreTest semaphoreTest = new SemaphoreTest();
        semaphoreTest.semaphoreTest();
        System.out.println("main finish");
    }
}
