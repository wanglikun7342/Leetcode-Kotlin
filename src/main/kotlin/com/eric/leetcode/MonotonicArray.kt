package com.eric.leetcode

class MonotonicArray {
    fun isMonotonic(A: IntArray): Boolean {
        if (A.size <= 1) {
            return true
        }
        if (A.last() > A.first()) {
            // 单调增
            for (index in 1..A.lastIndex) {
                if (A[index] - A[index - 1] < 0) {
                    return false
                }
            }
            return true
        } else {
            // 单调减
            for (index in 1..A.lastIndex) {
                if (A[index] - A[index - 1] > 0) {
                    return false
                }
            }
            return true
        }
    }
}