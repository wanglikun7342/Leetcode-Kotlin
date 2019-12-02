package com.eric.leetcode

class CellsWithOddValuesInAMatrix {
    fun oddCells(n: Int, m: Int, indices: Array<IntArray>): Int {
        val rowNum = IntArray(n) {
            0
        }
        val colNum = IntArray(m) {
            0
        }
        for (els in indices) {
            val r = els[0]
            val c = els[1]
            rowNum[r] += 1
            colNum[c] += 1
        }
        var ans = 0
        for (i in rowNum.indices) {
            for (j in colNum.indices) {
                if ((rowNum[i] + colNum[j]).rem(2) == 1) {
                    ans++
                }
            }
        }
        return ans
    }
}

fun main(args: Array<String>) {
    val n = 2
    val m = 3
    val indices = arrayOf(intArrayOf(0, 1), intArrayOf(1, 1))
    val cellsWithOddValuesInAMatrix = CellsWithOddValuesInAMatrix()
    println(cellsWithOddValuesInAMatrix.oddCells(n, m, indices))
}