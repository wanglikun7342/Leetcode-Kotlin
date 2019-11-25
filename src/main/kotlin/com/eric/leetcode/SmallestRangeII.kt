package com.eric.leetcode

class SmallestRangeII {
    fun smallestRangeII(A: IntArray, K: Int): Int {
        A.sort()
        var res = A.last() - A.first()
        for (index in 1..A.lastIndex) {
            val min = minOf(A.first() + K, A[index] - K)
            val max = maxOf(A.last() - K, A[index - 1] + K)
            res = minOf(res, max - min)
        }
        return res
    }
}

fun main(args: Array<String>) {
    val A = intArrayOf(0, 10)
    val K = 2
    val smallestRangeII = SmallestRangeII()
    println(smallestRangeII.smallestRangeII(A, K))
}