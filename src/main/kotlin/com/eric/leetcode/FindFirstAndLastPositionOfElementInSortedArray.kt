package com.eric.leetcode

class FindFirstAndLastPositionOfElementInSortedArray {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        var resultStartIndex = -1
        var resultEndIndex = -1
        var startIndex = 0
        var endIndex = nums.lastIndex
        var midIndex = (startIndex + endIndex) / 2
        while (startIndex <= endIndex) {
            val mid = nums[midIndex]
            if (mid == target) {
                val start = nums.getOrNull(midIndex - 1)
                if (start == mid) {
                    endIndex = midIndex - 1
                } else {
                    resultStartIndex = midIndex
                    break
                }
            } else if (mid > target) {
                endIndex = midIndex - 1
            } else {
                startIndex = midIndex + 1
            }
            midIndex = (startIndex + endIndex) / 2
        }
        startIndex = 0
        endIndex = nums.lastIndex
        midIndex = (startIndex + endIndex) / 2
        while (startIndex <= endIndex) {
            val mid = nums[midIndex]
            if (mid == target) {
                val end = nums.getOrNull(midIndex + 1)
                if (end == mid) {
                    startIndex = midIndex + 1
                } else {
                    resultEndIndex = midIndex
                    break
                }
            } else if (mid > target) {
                endIndex = midIndex - 1
            } else {
                startIndex = midIndex + 1
            }
            midIndex = (startIndex + endIndex) / 2
        }
        return intArrayOf(resultStartIndex, resultEndIndex)
    }
}

fun main() {
    val input = intArrayOf(5,7,7,8,8,10)
    val findFirstAndLastPositionOfElementInSortedArray = FindFirstAndLastPositionOfElementInSortedArray()
    findFirstAndLastPositionOfElementInSortedArray.searchRange(input, 8)
}