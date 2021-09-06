package com.eric.leetcode

class CombinationSum {
    private var candidates = intArrayOf()
    private val result = mutableListOf<List<Int>>()
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        this.candidates = candidates
        result.clear()
        backtrace(target, 0, mutableListOf())
        return result
    }

    private fun backtrace(sum: Int, index: Int, arr: MutableList<Int>) {
        if (index > candidates.lastIndex) {
            return
        }
        if (sum < 0) {
            return
        }
        if (sum == 0) {
            result.add(arr.toList())
        }
        for (i in index..candidates.lastIndex) {
            arr.add(candidates[i])
            backtrace(sum - candidates[i], i, arr)
            arr.remove(candidates[i])
        }
    }
}

fun main() {
    val combinationSum = CombinationSum()
    combinationSum.combinationSum(intArrayOf(2, 3, 6, 7), 7)
}