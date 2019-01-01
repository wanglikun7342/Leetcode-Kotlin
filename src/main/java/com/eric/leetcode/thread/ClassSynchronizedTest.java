package com.eric.leetcode.thread;

public class ClassSynchronizedTest {

    public synchronized void a() throws InterruptedException {
        System.out.println("a()");
        Thread.sleep(1000);
    }

    public synchronized void b() throws InterruptedException {
        System.out.println("b()");
        Thread.sleep(1000);
    }

    public static synchronized void c() throws InterruptedException {
        System.out.println("c()");
        Thread.sleep(1000);
    }

    public static synchronized void d() throws InterruptedException {
        System.out.println("d()");
        Thread.sleep(1000);
    }

    public void e() throws InterruptedException {
        synchronized (ClassSynchronizedTest.class) {
            System.out.println("e()");
            Thread.sleep(1000);
        }
    }

    public static void main(String args[]) {
        System.out.println("main start");
        ClassSynchronizedTest classSynchronizedTest = new ClassSynchronizedTest();

        new Thread(() -> {
            try {
                classSynchronizedTest.e();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                ClassSynchronizedTest.c();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                ClassSynchronizedTest.d();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                classSynchronizedTest.b();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                classSynchronizedTest.a();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        System.out.println("main finish");
    }
}
