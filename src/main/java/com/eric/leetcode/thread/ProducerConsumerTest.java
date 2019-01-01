package com.eric.leetcode.thread;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumerTest {
    private final Object lock = new Object();
    private List<Integer> list = new ArrayList<>();

    public void producerConsumerTest() {
        Thread thread1 = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    while (list.isEmpty()) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    int e = list.remove(0);
                    System.out.println("consume an element： " + e);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                    lock.notifyAll();
                }
            }
        });
        thread1.start();

        Thread thread2 = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    while (!list.isEmpty()) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    list.add(250);
                    System.out.println("add an element： " + 250);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                    lock.notifyAll();
                }
            }
        });
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        System.out.println("main start");
        ProducerConsumerTest producerConsumerTest = new ProducerConsumerTest();
        producerConsumerTest.producerConsumerTest();
        System.out.println("main finish");
    }
}
