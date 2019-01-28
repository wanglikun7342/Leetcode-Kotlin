package com.eric.leetcode

class FibonacciNumber {
    fun fib(N: Int): Int {
        val list = mutableListOf(0, 1)
        for (i in 2..N) {
            list.add(list[i - 1] + list[i - 2])
        }
        return list[N]
    }
}

fun main(args: Array<String>) {
    val num = 2
    val fibonacciNumber = FibonacciNumber()
    println(fibonacciNumber.fib(num))
}