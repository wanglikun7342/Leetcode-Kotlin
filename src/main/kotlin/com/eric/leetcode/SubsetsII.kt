package com.eric.leetcode

class SubsetsII {
    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        val result = mutableSetOf<List<Int>>()
        result.add(mutableListOf())
        for (index in nums.indices) {
            dfs(nums, index, mutableListOf(), result)
        }
        return result.toList()
    }

    private fun dfs(nums: IntArray, cur: Int, list: MutableList<Int>, result: MutableSet<List<Int>>) {
        val newList = mutableListOf<Int>()
        newList.addAll(list)
        newList.add(nums[cur])
        newList.sort()
        result.add(newList)
        for (index in cur + 1..nums.lastIndex) {
            dfs(nums, index, newList, result)
        }
    }
}

fun main() {
    val input = intArrayOf(1, 2, 2)
    val subsetsII = SubsetsII()
    subsetsII.subsetsWithDup(input)
}