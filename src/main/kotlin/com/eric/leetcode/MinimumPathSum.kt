package com.eric.leetcode

class MinimumPathSum {
    fun minPathSum(grid: Array<IntArray>): Int {
        val dp = Array(grid.size) { Array(grid[0].size) { 0 } }
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                if (i == 0 && j == 0) {
                    dp[0][0] = grid[0][0]
                } else if (i == 0) {
                    dp[0][j] = dp[0][j - 1] + grid[i][j]
                } else if (j == 0) {
                    dp[i][0] = dp[i - 1][0] + grid[i][j]
                } else {
                    dp[i][j] = minOf(dp[i - 1][j] + grid[i][j], dp[i][j - 1] + grid[i][j])
                }
            }
        }
        return dp[dp.lastIndex][dp[0].lastIndex]
    }
}

fun main(args: Array<String>) {
    val input = arrayOf(intArrayOf(1, 3, 1), intArrayOf(1, 5, 1), intArrayOf(4, 2, 1))
    val minimumPathSum = MinimumPathSum()
    println(minimumPathSum.minPathSum(input))
}