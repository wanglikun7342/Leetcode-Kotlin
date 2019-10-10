package com.eric.leetcode

import com.eric.leetcode.util.CommonUtils

class SortAnArray {
    fun sortArray(nums: IntArray): IntArray {
        quickSort(nums, 0, nums.lastIndex)
        return nums
    }

    private fun quickSort(nums: IntArray, start: Int, end: Int) {
        if (start > end) {
            return
        }
        var head = start
        var tail = end
        var temp: Int
        while (head < tail) {
            while (head < tail && nums[tail] >= nums[start]) {
                tail--
            }
            while (head < tail && nums[head] <= nums[start]) {
                head++
            }
            if (head < tail) {
                temp = nums[head]
                nums[head] = nums[tail]
                nums[tail] = temp
            }
        }
        temp = nums[head]
        nums[head] = nums[start]
        nums[start] = temp
        quickSort(nums, start, head - 1)
        quickSort(nums, head + 1, end)
    }
}

fun main(args: Array<String>) {
    val input = intArrayOf(5, 1, 1, 2, 0, 0)
    val sortAnArray = SortAnArray()
    CommonUtils.printArray(sortAnArray.sortArray(input).toTypedArray())
}