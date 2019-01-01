package com.eric.leetcode;

import com.eric.leetcode.util.CommonUtils

class SortArrayByParityII {
    fun sortArrayByParityII(A: IntArray): IntArray {
        var oddIndex = 1
        var evenIndex = 0
        var temp : Int
        while(oddIndex <= A.lastIndex && evenIndex <= A.lastIndex) {
            if (A[evenIndex] % 2 != 0 && A[oddIndex] % 2 != 1) {
                temp = A[oddIndex]
                A[oddIndex] = A[evenIndex]
                A[evenIndex] = temp
            }
            if (A[evenIndex] % 2 == 0) {
                evenIndex += 2
            }
            if (A[oddIndex] % 2 == 1) {
                oddIndex += 2
            }
        }
        return A
    }
}

fun main(args: Array<String>) {
    val array = intArrayOf(4,2,5,7)
    val sortArrayByParityII = SortArrayByParityII()
    CommonUtils.printArray(sortArrayByParityII.sortArrayByParityII(array).toTypedArray())
}