package com.eric.leetcode

import kotlin.math.abs

class ScoreAfterFlippingMatrix {
    fun matrixScore(A: Array<IntArray>): Int {
        for (i in A.indices) {
            if (A[i][0] == 0) {
                for (j in A[0].indices) {
                    A[i][j] = abs(A[i][j] - 1)
                }
            }
        }
        for (j in 1..A[0].lastIndex) {
            var zeroNum = 0
            for (i in A.indices) {
                if (A[i][j] == 0) {
                    zeroNum++
                }
            }
            if (zeroNum * 2 > A.size) {
                for (i in A.indices) {
                    A[i][j] = abs(A[i][j] - 1)
                }
            }
        }
        var sum = 0
        for (i in A.indices) {
            for (j in A[0].indices) {
                sum += A[i][j] shl (A[0].lastIndex - j)
            }
        }
        return sum
    }
}

fun main(args: Array<String>) {
    val array = arrayOf(intArrayOf(0, 0, 1, 1), intArrayOf(1,0 ,1, 0), intArrayOf(1, 1, 0, 0))
//    val array = arrayOf(intArrayOf(0, 1), intArrayOf(1,1))
    val scoreAfterFlippingMatrix = ScoreAfterFlippingMatrix()
    val result = scoreAfterFlippingMatrix.matrixScore(array)
    print("result: $result")
}