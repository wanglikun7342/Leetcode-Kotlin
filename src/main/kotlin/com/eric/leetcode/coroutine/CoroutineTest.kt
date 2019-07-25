package com.eric.leetcode.coroutine

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay

class CoroutineTest {

}

suspend fun main(args: Array<String>) {
    println("start: ${Thread.currentThread()}")
    delay(1000)
    println("delay: ${Thread.currentThread()}")
    val job1 = GlobalScope.async {
        println("job1: ${Thread.currentThread()}")
        return@async "job1 finish"
    }
    println(job1.await() + ", " + Thread.currentThread())
    val job2 = GlobalScope.async {
        println("job2: ${Thread.currentThread()}")
        return@async "job2 finish"
    }
    println(job2.await() + ", " + Thread.currentThread())

    delay(1000)
    println("delay: ${Thread.currentThread()}")

    val job3 = GlobalScope.async {
        println("job3: ${Thread.currentThread()}")
        return@async "job3 finish"
    }
    val job4 = GlobalScope.async {
        println("job4: ${Thread.currentThread()}")
        return@async "job4 finish"
    }
    println(job3.await() + ", " + job4.await() + ", " + Thread.currentThread())
    println("end: ${Thread.currentThread()}")
}