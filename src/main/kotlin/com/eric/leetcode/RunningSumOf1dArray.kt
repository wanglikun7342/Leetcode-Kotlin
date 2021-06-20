package com.eric.leetcode

import com.eric.leetcode.util.CommonUtils

class RunningSumOf1dArray {
    fun runningSum(nums: IntArray): IntArray {
        for (index in 1..nums.lastIndex) {
            nums[index] += nums[index-1]
        }
        return nums
    }
}

fun main() {
    val input = intArrayOf(1,2,3,4)
    val runningSumOf1dArray = RunningSumOf1dArray()
    CommonUtils.printArray(runningSumOf1dArray.runningSum(input).toTypedArray())
}