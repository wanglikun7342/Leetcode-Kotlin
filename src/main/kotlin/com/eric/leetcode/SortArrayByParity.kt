package com.eric.leetcode

import com.eric.leetcode.util.CommonUtils

class SortArrayByParity {
    fun sortArrayByParity(A: IntArray): IntArray {
        var i = 0
        var j = A.lastIndex
        var temp: Int
        while (i < j) {
            if (A[i].rem(2) != 1) {
                i++
                continue
            }
            if (A[j].rem(2) != 0) {
                j--
                continue
            }
            temp = A[i]
            A[i] = A[j]
            A[j] = temp
        }
        return A
    }
}

fun main(args: Array<String>) {
    val array = intArrayOf(3, 1, 2, 4)
    val sortArrayByParity = SortArrayByParity()
    CommonUtils.printArray(sortArrayByParity.sortArrayByParity(array).toTypedArray())
}