package com.eric.leetcode

import kotlin.math.abs

class ThreeSumClosest {
    // -4, -1, 2, 1,
    // 双逼近算法
    fun threeSumClosest(nums: IntArray, target: Int): Int {
        var sum = nums[0] + nums[1] + nums[2]
        nums.sort()
        for (x in nums.indices) {
            var i = x + 1
            var j = nums.lastIndex
            while (i < j) {
                val curSum = nums[i] + nums[j] + nums[x]
                val curDiff = abs(sum - target)
                val diff  = abs(curSum - target)
                if (diff < curDiff) {
                    sum = curSum
                }
                if (curSum - target > 0) {
                    j--
                } else if(curSum - target < 0) {
                    i++
                } else {
                    return sum
                }
            }
        }
        return sum
    }
}

fun main(args: Array<String>) {
    val nums = intArrayOf(0,2,1,-3)
    val target = 1
    val threeSumClosest = ThreeSumClosest()
    println(threeSumClosest.threeSumClosest(nums, target))
}