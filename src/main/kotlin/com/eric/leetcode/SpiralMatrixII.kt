package com.eric.leetcode

import com.eric.leetcode.util.CommonUtils

class SpiralMatrixII {
    fun generateMatrix(n: Int): Array<IntArray> {
        val result = Array(n, { IntArray(n, { 0 }) })
        var i = 0
        var j = 0
        var dj = 1
        var di = 0
        var value = 1
        while (value <= n*n) {
            result[i][j] = value
            value++
            j+=dj
            i+=di
            if (j >= n || i >= n || j < 0 || i <0 || result[i][j] != 0 ) {
                j-=dj
                i-=di
                if (dj == 1) {
                    dj = 0
                    di = 1
                } else if (dj == -1) {
                    dj = 0
                    di = -1
                } else if (di == 1) {
                    dj = -1
                    di = 0
                } else if (di == -1) {
                    dj = 1
                    di = 0
                }
                j+=dj
                i+=di
            }
        }
        return result
    }
}

fun main(args: Array<String>) {
    val spiralMatrixII = SpiralMatrixII()
    CommonUtils.print2DIntArray(spiralMatrixII.generateMatrix(3))
}