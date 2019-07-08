package com.eric.leetcode

class FindPeakElement {
    fun findPeakElement(nums: IntArray): Int {
        return findPeakElement(nums, 0, nums.lastIndex)
    }

    private fun findPeakElement(nums: IntArray, startIndex: Int, endIndex: Int): Int {
        val midIndex = (endIndex + startIndex) / 2
        val midVal = nums[midIndex]
        val leftIndex = midIndex - 1
        val leftVal = when (midIndex) {
            0 -> Long.MIN_VALUE
            else -> nums[leftIndex].toLong()
        }
        val rightIndex = midIndex + 1
        val rightVal = when (midIndex) {
            nums.lastIndex -> Long.MIN_VALUE
            else -> nums[rightIndex].toLong()
        }
        return if (midVal > leftVal && midVal > rightVal) {
            midIndex
        } else if (midVal < leftVal) {
            findPeakElement(nums, startIndex, leftIndex)
        } else {
            findPeakElement(nums, rightIndex, endIndex)
        }
    }
}

fun main(args: Array<String>) {
    val input = intArrayOf(1, 2, 4, 2)
    val findPeakElement = FindPeakElement()
    println(findPeakElement.findPeakElement(input))
}