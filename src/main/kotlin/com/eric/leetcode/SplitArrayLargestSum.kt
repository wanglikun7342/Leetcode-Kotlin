package com.eric.leetcode

class SplitArrayLargestSum {
    fun splitArray(nums: IntArray, m: Int): Int {
        var left = 0
        var right = nums.sum() + 1
        var ans = Int.MAX_VALUE
        while (left < right) {
            val mid = (left + right) / 2
            if (guess(nums, m, mid)) {
                ans = mid
                right = mid
            } else {
                left = mid + 1
            }
        }
        return ans
    }

    private fun guess(nums: IntArray, m: Int, mid: Int): Boolean {
        var sum = 0
        var innerM = m
        for (num in nums) {
            if (sum + num > mid) {
                innerM--
                sum = num
                if (num > mid) {
                    return false
                }
            } else {
                sum += num
            }
        }
        return innerM >= 1
    }
}

fun main(args: Array<String>) {
    val input = intArrayOf(2, 8)
    val m = 1
    val splitArrayLargestSum = SplitArrayLargestSum()
    println(splitArrayLargestSum.splitArray(input, m))
}