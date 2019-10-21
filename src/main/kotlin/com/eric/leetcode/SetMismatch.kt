package com.eric.leetcode

import com.eric.leetcode.util.CommonUtils

class SetMismatch {
    fun findErrorNums(nums: IntArray): IntArray {
        val result = mutableListOf<Int>()
        var sum = 0
        for (value in nums) {
            val num = Math.abs(value)
            if (nums[num - 1] < 0) {
                result.add(num)
            } else {
                nums[num - 1] *= -1
            }
            sum += num
        }
        result.add(nums.size * (nums.size + 1) / 2 - sum + result[0])
        return result.toIntArray()
    }
}

fun main(args: Array<String>) {
    val setMismatch = SetMismatch()
    CommonUtils.printArray(setMismatch.findErrorNums(intArrayOf(8, 7, 3, 5, 3, 6, 1, 4)).toTypedArray())
}