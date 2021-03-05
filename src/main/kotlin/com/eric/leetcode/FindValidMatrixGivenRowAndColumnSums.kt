package com.eric.leetcode

class FindValidMatrixGivenRowAndColumnSums {
    fun restoreMatrix(rowSum: IntArray, colSum: IntArray): Array<IntArray> {
        val result = Array(rowSum.size) {
            IntArray(colSum.size) { 0 }
        }
        for (row in result.indices) {
            for (col in result[0].indices) {
                result[row][col] = minOf(rowSum[row], colSum[col])
                rowSum[row] -= result[row][col]
                colSum[col] -= result[row][col]
            }
        }
        return result
    }
}
