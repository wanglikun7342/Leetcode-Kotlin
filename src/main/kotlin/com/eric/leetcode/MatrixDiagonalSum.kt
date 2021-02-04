package com.eric.leetcode

class MatrixDiagonalSum {
    fun diagonalSum(mat: Array<IntArray>): Int {
        var sum = 0
        for (index in mat[0].indices) {
            sum += mat[index][index]
        }
        for (index in mat[0].lastIndex downTo 0) {
            sum += mat[index][mat.lastIndex - index]
        }
        if (mat[0].size % 2 != 0) {
            sum -= mat[mat[0].lastIndex / 2][mat[0].lastIndex / 2]
        }
        return sum
    }
}