package com.eric.leetcode

class SmallestRangeI {
    fun smallestRangeI(A: IntArray, K: Int): Int {
        val max = A.max()
        val min = A.min()
        if (max == null || min == null) {
            return 0
        }
        val result = if ((max - min - K * 2) >= 0) (max - min - K * 2) else 0
        return result
    }
}

fun main(args: Array<String>) {
    val A = intArrayOf(0, 10)
    val K = 2
    val smallestRangeI = SmallestRangeI()
    println(smallestRangeI.smallestRangeI(A, K))
}