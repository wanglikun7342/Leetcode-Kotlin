package com.eric.leetcode

class Permutations {
    val result = mutableListOf<List<Int>>()
    fun permute(nums: IntArray): List<List<Int>> {
        result.clear()
        val array = IntArray(nums.size) { 0 }
        for (index in nums.indices) {
            array[index] = 1
            dfs(nums, listOf(nums[index]), array)
            array[index] = 0
        }
        return result
    }

    private fun dfs(nums: IntArray, list: List<Int>, array: IntArray) {
        if (array.all { it == 1 }) {
            result.add(list)
            return
        }
        for (i in nums.indices) {
            if (array[i] == 0) {
                array[i] = 1
                dfs(nums, listOf(nums[i], *list.toTypedArray()), array)
                array[i] = 0
            }
        }
    }
}

fun main() {
    val input = intArrayOf(1, 2, 3)
    val permutations = Permutations()
    permutations.permute(input)
}