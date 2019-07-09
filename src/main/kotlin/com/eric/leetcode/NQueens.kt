package com.eric.leetcode

class NQueens {
    private val results = mutableListOf<List<String>>()
    fun solveNQueens(n: Int): List<List<String>> {
        results.clear()
        val area = Array(n, { IntArray(n, { 0 }) })
        for (col in 0 until n) {
            reset(area, 0)
            place(area, 0, col)
        }
        return results
    }

    private fun reset(area: Array<IntArray>, index: Int) {
        for (row in index..area.lastIndex) {
            for (col in area[0].indices) {
                area[row][col] = 0
            }
        }
    }

    private fun ouput(area: Array<IntArray>) {
        val result = mutableListOf<String>()
        for (row in 0..area.lastIndex) {
            var line = ""
            for (col in 0..area[0].lastIndex) {
                if (area[row][col] != 1) {
                    line += "."
                } else {
                    line += "Q"
                }
            }
            result.add(line)
        }
        results.add(result)
    }

    private fun place(area: Array<IntArray>, rowIndex: Int, colIndex: Int) {
        area[rowIndex][colIndex] = 1
        for (row in 0 until rowIndex) {
            if (area[row][colIndex] == 1) {
                area[rowIndex][colIndex] = 0
                return
            }
            val leftCol = rowIndex - row + colIndex
            if (leftCol >= 0 && leftCol <= area.lastIndex) {
                if (area[row][leftCol] == 1) {
                    area[rowIndex][colIndex] = 0
                    return
                }
            }
            val rightCol = row - rowIndex + colIndex
            if (rightCol >= 0 && rightCol <= area.lastIndex) {
                if (area[row][rightCol] == 1) {
                    area[rowIndex][colIndex] = 0
                    return
                }
            }
        }
        for (col in area[0].indices) {
            val newRow = rowIndex + 1
            if (newRow == area.size) {
                ouput(area)
                return
            }
            reset(area, newRow)
            place(area, newRow, col)
        }
    }
}

fun main(args: Array<String>) {
    val nQueens = NQueens()
    nQueens.solveNQueens(4)
}