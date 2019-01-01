package com.eric.leetcode.thread;

public class B {
    private A a;
    private int count;

    private final Object lock = new Object();

    public synchronized void setA(A a) {
        this.a = a;
    }

    public void increaseCount(){
        synchronized (lock) {
            count++;
            System.out.println("B count: " + count);
        }
    }

    public void increaseACount(){
        // 死锁 B锁 A锁
        synchronized (lock) {
            a.increaseCount();
        }
    }
}
