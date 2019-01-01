package com.eric.leetcode

import com.eric.leetcode.util.CommonUtils

class FlippingAnImage {
    fun flipAndInvertImage(A: Array<IntArray>): Array<IntArray> {
        for (i in A.indices) {
            for (j in 0..A.lastIndex / 2) {
                val temp = A[i][j]
                A[i][j] = invert(A[i][A.lastIndex - j])
                A[i][A.lastIndex - j] = invert(temp)
            }
        }
        return A
    }

    private fun invert(num: Int): Int {
        if (num == 0) {
            return 1
        } else {
            return 0
        }
    }
}

fun main(args: Array<String>) {
    val array = arrayOf(intArrayOf(1, 1, 0), intArrayOf(1, 0, 1), intArrayOf(0, 0, 0))
    val flippingAnImage = FlippingAnImage()
    flippingAnImage.flipAndInvertImage(array)
    CommonUtils.print2DIntArray(array)
}