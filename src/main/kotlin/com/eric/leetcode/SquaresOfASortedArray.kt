package com.eric.leetcode

import com.eric.leetcode.util.CommonUtils
import java.util.*

class SquaresOfASortedArray {
    fun sortedSquares(A: IntArray): IntArray {
        for (index in A.indices) {
            A[index] *= A[index]
        }
        Arrays.sort(A)
        return A
    }
}

fun main(args: Array<String>) {
    val input = intArrayOf(-4, -1, 0, 3, 10)
    val squaresOfASortedArray = SquaresOfASortedArray()
    CommonUtils.printArray(squaresOfASortedArray.sortedSquares(input).toTypedArray())
}