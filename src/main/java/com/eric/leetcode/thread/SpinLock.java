package com.eric.leetcode.thread;

import java.util.concurrent.atomic.AtomicReference;

public class SpinLock {
    private AtomicReference<Thread> reference = new AtomicReference<>();

    public void lock() {
        Thread currentThread = Thread.currentThread();
        while (!reference.compareAndSet(null, currentThread)) {
            System.out.println("等待获取锁");
        }
    }

    public void unLock() {
        reference.set(null);
    }
}
