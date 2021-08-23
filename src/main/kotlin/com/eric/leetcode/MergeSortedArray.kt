package com.eric.leetcode

class MergeSortedArray {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        var i = m - 1
        var j = n - 1
        var k = m + n -1
        while (j >= 0 && i >= 0) {
            if (nums1[i] >= nums2[j]) {
                nums1[k] = nums1[i]
                i--
                k--
            } else {
                nums1[k] = nums2[j]
                j--
                k--
            }
        }
        while (j >= 0)  {
            nums1[k] = nums2[j]
            j--
            k--
        }
    }
}

fun main() {
    val nums1 = intArrayOf(1, 2, 3, 0, 0, 0)
    val nums2 = intArrayOf(2, 5, 6)
    val m = 3
    val n = 3
    val mergeSortedArray = MergeSortedArray()
    mergeSortedArray.merge(nums1, m, nums2, n)
}