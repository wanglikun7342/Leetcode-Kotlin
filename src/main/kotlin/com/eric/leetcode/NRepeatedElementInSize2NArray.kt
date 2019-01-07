package com.eric.leetcode

class NRepeatedElementInSize2NArray {
    fun repeatedNTimes(A: IntArray): Int {
        for(index in 0..A.lastIndex - 2) {
            if (A[index] == A[index + 1] || A[index] == A[index + 2]) {
                return A[index]
            }
        }
        return A[A.lastIndex]
    }
}

fun main(args: Array<String>) {
    val input = intArrayOf(2, 1, 2, 5, 3, 2)
    val nRepeatedElementInSize2NArray = NRepeatedElementInSize2NArray()
    println(nRepeatedElementInSize2NArray.repeatedNTimes(input))
}