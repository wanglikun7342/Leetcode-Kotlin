package com.eric.leetcode

class PatchingArray {
    fun minPatches(nums: IntArray, n: Int): Int {
        var count = 0
        var miss = 1L
        var i = 0
        while (miss <= n) {
            if (i <= nums.lastIndex && nums[i] <= miss) {
                miss += nums[i++]
            } else {
                count++
                miss += miss
            }
        }
        return count
    }
}

fun main(args: Array<String>) {
    val nums = intArrayOf(1, 2, 31, 33)
    val n = 2147483647
    val patchingArray = PatchingArray()
    println(patchingArray.minPatches(nums, n))
}