package com.eric.leetcode

class PartitionArrayIntoThreePartsWithEqualSum {
    fun canThreePartsEqualSum(A: IntArray): Boolean {
        if (A.sum() % 3 != 0) {
            return false
        }
        val avg = A.sum() / 3
        var sum = 0
        var times = 0
        for (num in A) {
            sum += num
            if (sum == avg) {
                sum = 0
                times++
            }
        }
        return times == 3 || (times > 3 && avg == 0)
    }
}

fun main(args: Array<String>) {
    val input = intArrayOf(10, -10, 10, -10, 10, -10, 10, -10)
    val partitionArrayIntoThreePartsWithEqualSum = PartitionArrayIntoThreePartsWithEqualSum()
    partitionArrayIntoThreePartsWithEqualSum.canThreePartsEqualSum(input)
}