package com.eric.leetcode

class ShuffleTheArray {
    fun shuffle(nums: IntArray, n: Int): IntArray {
        val result = mutableListOf<Int>()
        for (index in 0 until n) {
            result.add(nums[index])
            result.add(nums[n + index])
        }
        return result.toIntArray()
    }
}