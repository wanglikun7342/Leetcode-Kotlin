package com.eric.leetcode

class FindDisappearedNumbers {
    fun findDisappearedNumbers(nums: IntArray): List<Int> {
        val list = mutableListOf<Int>()
        val n = nums.size
        for (i in nums.indices) {
            nums[(nums[i]-1) % n] += n
        }
        for (i in nums.indices) {
            if (nums[i] <= n) {
                list.add(i+1)
            }
        }
        return list
    }
}

fun main(args: Array<String>) {
    val array = intArrayOf(4, 3, 2, 7, 8, 2, 3, 1)
    val findDisappearedNumbers = FindDisappearedNumbers()
    val result = findDisappearedNumbers.findDisappearedNumbers(array)
    for (no in result) {
        println("$no ")
    }
}