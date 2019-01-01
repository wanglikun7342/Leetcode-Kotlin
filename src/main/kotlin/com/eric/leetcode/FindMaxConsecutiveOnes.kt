package com.eric.leetcode

class FindMaxConsecutiveOnes {
    fun findMaxConsecutiveOnes(nums: IntArray): Int {
        var maxNum = 0
        var curNum = 0
        for (i in nums.indices) {
            if (nums[i] == 0) {
                if (curNum > maxNum) {
                    maxNum = curNum
                }
                curNum = 0
            } else if (nums[i] == 1) {
                curNum++
                if (i == nums.lastIndex) {
                    if (curNum > maxNum) {
                        maxNum = curNum
                    }
                }
            }
        }
        return maxNum
    }
}

fun main(args: Array<String>) {
    val intArray = intArrayOf(1, 1, 0, 1, 1, 1)
    val f = FindMaxConsecutiveOnes()
    val result = f.findMaxConsecutiveOnes(intArray)
    println("result: " + result)
}