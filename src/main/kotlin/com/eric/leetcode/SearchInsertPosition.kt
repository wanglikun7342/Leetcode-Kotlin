package com.eric.leetcode

class SearchInsertPosition {
    fun searchInsert(nums: IntArray, target: Int): Int {
        var start = 0
        var end = nums.lastIndex
        while (true) {
            val mid = (start + end) / 2
            if (nums[mid] > target) {
                if (mid == 0) {
                    return 0
                } else if (nums[mid - 1] < target) {
                    return mid - 1
                }
                end = mid - 1
            } else if (nums[mid] < target) {
                if (mid == nums.lastIndex) {
                    return nums.lastIndex + 1
                } else if (nums[mid + 1] > target) {
                    return mid + 1
                }
                start = mid + 1
            } else {
                break
            }
        }
        return (start + end) / 2
    }
}

fun main() {
    val nums = intArrayOf(1, 3)
    val target = 2
    val searchInsertPosition = SearchInsertPosition();
    searchInsertPosition.searchInsert(nums, target)
}