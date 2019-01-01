package com.eric.leetcode.thread;

public class A {
    private B b;
    private int count;

    private final Object lock = new Object();

    public synchronized void setB(B b) {
        this.b = b;
    }

    public synchronized int getCount() {
        return count;
    }

    public synchronized void setCount(int count) {
        this.count = count;
    }

    public void increaseCount() {
        synchronized (lock) {
            count++;
            System.out.println("A count: " + count);
        }
    }

    public void increaseBCount() {
        // 死锁  A 锁  B锁
        synchronized (lock) {
            b.increaseCount();
        }
    }
}
