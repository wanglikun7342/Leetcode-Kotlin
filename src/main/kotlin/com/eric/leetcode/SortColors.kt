package com.eric.leetcode

import com.eric.leetcode.util.CommonUtils

class SortColors {
    fun sortColors(nums: IntArray) {
        var zeroNum = 0;
        var oneNum = 0;
        var twoNum = 0;
        for (num in nums) {
            if (num == 0) {
                zeroNum++
            } else if (num == 1) {
                oneNum++
            } else if (num == 2) {
                twoNum++
            }
        }
        for (i in nums.indices) {
            if (i < zeroNum) {
                nums[i] = 0
            } else if (i < zeroNum + oneNum) {
                nums[i] = 1
            } else if (i < zeroNum + oneNum + twoNum) {
                nums[i] = 2
            }
        }
    }
}

fun main(args: Array<String>) {
    val array = intArrayOf(2,0,2,1,1,0)
    val sortColors  = SortColors()
    sortColors.sortColors(array)
    CommonUtils.printArray(array.toTypedArray())
}