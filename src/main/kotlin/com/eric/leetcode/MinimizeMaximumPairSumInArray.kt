package com.eric.leetcode

class MinimizeMaximumPairSumInArray {
    fun minPairSum(nums: IntArray): Int {
        nums.sort()
        var result = 0
        for (index in 0..nums.size / 2) {
            if (result < nums[index] + nums[nums.lastIndex - index]) {
                result = nums[index] + nums[nums.lastIndex - index]
            }
        }
        return result
    }
}

fun main() {
    val input = intArrayOf(3, 5, 2, 3)
    val minimizeMaximumPairSumInArray = MinimizeMaximumPairSumInArray()
    print(minimizeMaximumPairSumInArray.minPairSum(input))
}