package com.eric.leetcode.thread;

import java.util.concurrent.atomic.AtomicReference;

public class ReentrySpinLock {
    private AtomicReference<Thread> reference = new AtomicReference<>();
    private int count;

    public void lock() {
        Thread currentThread = Thread.currentThread();
        if (currentThread == reference.get()) {
            count++;
            return;
        }
        while (!reference.compareAndSet(null, currentThread)) {
            System.out.println("等待获取锁");
        }
    }

    public void unLock() {
        if (count != 0) {
            count--;
            return;
        }
        reference.set(null);
    }
}
