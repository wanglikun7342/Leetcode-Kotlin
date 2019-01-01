package com.eric.leetcode.thread;

public class SynchronizedTest {

    private final B b;
    private final A a;
    private final A a2;

    public SynchronizedTest() {
        a = new A();
        a2 = new A();
        b = new B();
        a2.setB(b);
        a.setB(b);
        b.setA(a);
    }

    public void synchronizedTest2() {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                System.out.println(Thread.currentThread());
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                a.increaseCount();

//                b.increaseCount();
                b.increaseACount();
            }
        });
        thread.start();
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                System.out.println(Thread.currentThread());
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                a.increaseCount();

//                a2.increaseBCount();
                a.increaseBCount();
            }
        });
        thread2.start();
        try {
            thread.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void deadLockTest() {
        Thread thread = new Thread(() -> {
            synchronized (a) {
                System.out.println("get a lock: " + Thread.currentThread());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (b) {
                    System.out.println("get b lock: " + Thread.currentThread());
                    try {
                        Thread.sleep(1000);
//                        b.notifyAll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
        Thread thread2 = new Thread(() -> {
            synchronized (b) {
                System.out.println("get b lock: " + Thread.currentThread());
                try {
                    Thread.sleep(1000);
//                    b.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (a) {
                    System.out.println("get a lock: " + Thread.currentThread());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread2.start();
        try {
            thread.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void synchronizedTest() {
        Thread thread = new Thread(() -> {
            synchronized (a) {
                for (int i = 0; i < 20; i++) {
                    System.out.println(Thread.currentThread());
                    int count = a.getCount();
                    System.out.println("a count: " + count);
                    count++;
                    a.setCount(count);
                }
            }
        });
        thread.start();
        Thread thread2 = new Thread(() -> {
            synchronized (a) {
                for (int i = 0; i < 20; i++) {
                    System.out.println(Thread.currentThread());
                    int count = a.getCount();
                    System.out.println("a count: " + count);
                    count++;
                    a.setCount(count);
                }
            }
        });
        thread2.start();
        try {
            thread.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("a final count: " + a.getCount());
    }

    public static void main(String args[]) {
        System.out.println("main start");
        SynchronizedTest synchronizedTest = new SynchronizedTest();
//        synchronizedTest.synchronizedTest();
//        synchronizedTest.deadLockTest();
        synchronizedTest.synchronizedTest2();
        System.out.println("main finish");
    }
}
