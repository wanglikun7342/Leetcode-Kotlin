package com.eric.leetcode

class SelfDividingNumbers {
    fun selfDividingNumbers(left: Int, right: Int): List<Int> {
        val list = mutableListOf<Int>()
        outer@
        for (i in left..right) {
            val str = i.toString().toCharArray()
            for (ch in str) {
                val div = Integer.valueOf(ch.toString())
                if (div == 0
                        || i % div != 0) {
                    continue@outer
                }
            }
            list.add(i)
        }
        return list
    }
}

fun main(args: Array<String>) {
    val selfDividingNumbers = SelfDividingNumbers()
    val left = 1
    val right = 22
    val result = selfDividingNumbers.selfDividingNumbers(left, right)
    for (no in result) {
        print("$no  ")
    }
}