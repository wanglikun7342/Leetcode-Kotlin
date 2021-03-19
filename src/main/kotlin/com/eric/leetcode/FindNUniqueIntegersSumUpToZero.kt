package com.eric.leetcode

class FindNUniqueIntegersSumUpToZero {
    fun sumZero(n: Int): IntArray {
        var sum = 0
        val result = IntArray(n) {
            0
        }
        for (index in result.indices) {
            if (index == result.lastIndex && sum == 0) {
                result[index] = 0
            } else if (sum != 0) {
                result[index] = -sum
                sum = 0
            } else {
                result[index] = index + 1
                sum = index + 1
            }
        }
        return result
    }
}