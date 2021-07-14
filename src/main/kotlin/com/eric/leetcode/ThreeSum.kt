package com.eric.leetcode

class ThreeSum {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val xSet = nums.mapIndexed { index, it -> it to index }.toMap().toMutableMap()
        val result = mutableSetOf<List<Int>>()
        for (i in 0..nums.lastIndex) {
            for (j in i..nums.lastIndex) {
                val x = nums[i]
                val y = nums[j]
                if (xSet.containsKey(-x - y)) {
                    val k = xSet[-x - y]
                    if (i != j && i != k && k != j) {
                        result.add(listOf(x, y, -x - y).sorted())
                    }
                }
            }
        }
        return result.toList()
    }
}

fun main() {
    val input = intArrayOf(-1, 0, 1, 2, -1, -4)
    val threeSum = ThreeSum()
    threeSum.threeSum(input)
}