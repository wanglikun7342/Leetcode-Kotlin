package com.eric.leetcode

class MinimumOperationsToMakeArrayEqual {
    fun minOperations(n: Int): Int {
        if (n % 2 != 0) {
            return (n - 1) * (n / 2 + 1) / 2
        } else {
            return n * n * 2 / 8
        }
    }
}