package com.eric.leetcode

import kotlin.math.abs

class MinimumMovesToEqualArrayElementsII {
    fun minMoves2(nums: IntArray): Int {
        nums.sort()
        val mid = nums[nums.lastIndex / 2]
        var moves = 0
        for (num in nums) {
            moves += abs(num - mid)
        }
        return moves
    }
}

fun main(args: Array<String>) {
    val input = intArrayOf(1,2,3)
    val minimumMovesToEqualArrayElementsII = MinimumMovesToEqualArrayElementsII()
    print(minimumMovesToEqualArrayElementsII.minMoves2(input))
}