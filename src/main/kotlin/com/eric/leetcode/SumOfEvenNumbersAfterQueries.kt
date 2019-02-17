package com.eric.leetcode

import com.eric.leetcode.util.CommonUtils

class SumOfEvenNumbersAfterQueries {
    fun sumEvenAfterQueries(A: IntArray, queries: Array<IntArray>): IntArray {
        val result = mutableListOf<Int>()
        var sum = A.filter { it % 2 == 0 }.sum()
        for (query in queries) {
            val num = query[0]
            val index = query[1]
            if (A[index] % 2 == 0) {
                sum -= A[index]
            }
            A[index] += num
            if (A[index] % 2 == 0) {
                sum += A[index]
            }
            result.add(sum)
        }
        return result.toIntArray()
    }
}

fun main(args: Array<String>) {
    val A = intArrayOf(1, 2, 3, 4)
    val queries = arrayOf(intArrayOf(1, 0), intArrayOf(-3, 1), intArrayOf(-4, 0), intArrayOf(2, 3))
    val sumOfEvenNumbersAfterQueries = SumOfEvenNumbersAfterQueries()
    CommonUtils.printArray(sumOfEvenNumbersAfterQueries.sumEvenAfterQueries(A, queries).toTypedArray())
}