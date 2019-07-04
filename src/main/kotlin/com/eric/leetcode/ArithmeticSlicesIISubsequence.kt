package com.eric.leetcode

import java.util.HashMap



/**
 * 暴力解法，DFS
 */
//class ArithmeticSlicesIISubsequence {
//
//    var num = 0
//
//
//    fun numberOfArithmeticSlices(A: IntArray): Int {
//        num = 0
//        for (index in A.indices) {
//            dfs(A, index, Long.MIN_VALUE, 1)
//        }
//        return num
//    }
//
//    private fun dfs(A: IntArray, s: Int, gap: Long, arraySize: Int) {
//        if (gap == Long.MIN_VALUE) {
//            for (index in s + 1..A.lastIndex) {
//
//                dfs(A, index, A[index].toLong() - A[s].toLong(), arraySize + 1)
//            }
//        } else {
//            for (index in s + 1..A.lastIndex) {
//                if (gap != A[index].toLong() - A[s].toLong()) {
//                    continue
//                } else {
//                    if (arraySize >= 2) {
//                        num++
//                    }
//                }
//                dfs(A, index, gap, arraySize + 1)
//            }
//        }
//    }
//}

class ArithmeticSlicesIISubsequence {

    fun numberOfArithmeticSlices(A: IntArray): Int {
        var result = 0
        val cnt = Array(A.size, { mutableMapOf<Int, Int>()})
        for (i in A.indices) {
            for (j in 0 until i) {
                val delta = A[i].toLong() - A[j].toLong()
                if (delta < Integer.MIN_VALUE || delta > Integer.MAX_VALUE) {
                    continue
                }
                val diff = delta.toInt()
                val sum = cnt[j].getOrDefault(diff, 0)
                val origin = cnt[i].getOrDefault(diff, 0)
                cnt[i].put(delta.toInt(), origin + sum + 1)
                result += sum
            }
        }
        return result
    }
}

fun main(args: Array<String>) {
    val input = intArrayOf(2,2,3,3,4,5)
    val arithmeticSlicesIISubsequence = ArithmeticSlicesIISubsequence()
    println(arithmeticSlicesIISubsequence.numberOfArithmeticSlices(input))
}