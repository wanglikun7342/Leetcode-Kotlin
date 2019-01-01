package com.eric.leetcode

class MaxIncreaseToKeepCitySkyline {
    fun maxIncreaseKeepingSkyline(grid: Array<IntArray>): Int {
        val skyLine = mutableMapOf<String, Int>()
        for (i in grid.indices) {
            var rowMax = grid[i][0]
            for (j in grid[0].indices) {
                if (grid[i][j] > rowMax) {
                    rowMax = grid[i][j]
                }
            }
            skyLine.put("row$i", rowMax)
        }
        for (j in grid[0].indices) {
            var colMax = grid[0][j]
            for (i in grid.indices) {
                if (grid[i][j] > colMax) {
                    colMax = grid[i][j]
                }
            }
            skyLine.put("col$j", colMax)
        }
        var maxIncrease = 0
        for(i in grid.indices) {
            for (j in grid[0].indices) {
                val skyline = minOf(skyLine["row$i"]!!, skyLine["col$j"]!!)
                maxIncrease += (skyline - grid[i][j])
            }
        }
        return maxIncrease
    }
}

fun main(args: Array<String>) {
    val grid = arrayOf(intArrayOf(3, 0, 8, 4), intArrayOf(2, 4, 5, 7), intArrayOf(9, 2, 6, 3), intArrayOf(0, 3, 1, 0))
    val maxIncreaseToKeepCitySkyline = MaxIncreaseToKeepCitySkyline()
    print(maxIncreaseToKeepCitySkyline.maxIncreaseKeepingSkyline(grid))
}