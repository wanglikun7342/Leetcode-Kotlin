package com.eric.leetcode

class TwoKeysKeyboard {
    fun minSteps(n: Int): Int {
        for (i in n-1 downTo 1) {
            if(i == 1) {
                return n
            } else if (n % i == 0) {
                return minSteps(i) + (n / i)
            }
        }
        return 0
    }
}

fun main(args: Array<String>) {
    val twoKeysKeyboard = TwoKeysKeyboard()
    val result = twoKeysKeyboard.minSteps(8)
    println("result: $result")
}