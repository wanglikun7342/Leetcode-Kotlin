package com.eric.leetcode

class SearchInRotatedSortedArray {
    fun search(nums: IntArray, target: Int): Int {
        var start = 0
        var end = nums.lastIndex
        while (start <= end) {
            val pivot = (start + end) / 2
            if (nums[pivot] == target) {
                return pivot
            } else if (nums[start] <= nums[pivot]) {
                if (target <= nums[pivot] && target >= nums[start]) {
                    end = pivot - 1
                } else {
                    start = pivot + 1
                }
            } else {
                if (target >= nums[pivot] && target <= nums[end]) {
                    start = pivot + 1
                } else {
                    end = pivot - 1
                }
            }
        }
        return -1
    }
}

fun main() {
    val input = intArrayOf(4, 5, 6, 7, 8, 1, 2, 3)
    val searchInRotatedSortedArray = SearchInRotatedSortedArray()
    searchInRotatedSortedArray.search(input, 8)
}