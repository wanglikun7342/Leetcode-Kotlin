package com.eric.leetcode

class ArithmeticSubarrays {
    fun checkArithmeticSubarrays(nums: IntArray, l: IntArray, r: IntArray): List<Boolean> {
        val result = mutableListOf<Boolean>()

        for (index in 0..l.lastIndex) {
            val start = l[index]
            val end = r[index]
            result.add(isArithmetic(nums.slice(start..end).sorted()))
        }
        return result
    }

    private fun isArithmetic(sorted: List<Int>): Boolean {
        if (sorted.size >= 2) {
            val delta = sorted[1] - sorted[0]
            for (index in 1 until sorted.lastIndex) {
                if (sorted[index + 1] - sorted[index] != delta) {
                    return false
                }
            }
        }
        return true
    }
}