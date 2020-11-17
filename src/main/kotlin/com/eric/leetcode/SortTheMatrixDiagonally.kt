package com.eric.leetcode

class SortTheMatrixDiagonally {
    fun diagonalSort(mat: Array<IntArray>): Array<IntArray> {
        val list = mutableListOf<Int>()
        for (index in mat.indices) {
            list.clear()
            var i = 0
            while (index+i <= mat.lastIndex && i <= mat[0].lastIndex) {
                list.add(mat[index+i][i])
                i++
            }
            list.sort()
            i = 0
            while (index+i <= mat.lastIndex && i <= mat[0].lastIndex) {
                mat[index+i][i] = list[i]
                i++
            }
        }
        for (index in 1..mat[0].lastIndex) {
            list.clear()
            var i = 0
            while (i <= mat.lastIndex && i + index <= mat[0].lastIndex) {
                list.add(mat[i][i + index])
                i++
            }
            list.sort()
            i = 0
            while (i <= mat.lastIndex && i + index <= mat[0].lastIndex) {
                mat[i][i + index] = list[i]
                i++
            }
        }
        return mat
    }
}

fun main() {
    val input = arrayOf(intArrayOf(3,3,1,1), intArrayOf(2,2,1,2), intArrayOf(1,1,1,2))
    val sortTheMatrixDiagonally = SortTheMatrixDiagonally()
    sortTheMatrixDiagonally.diagonalSort(input)
}