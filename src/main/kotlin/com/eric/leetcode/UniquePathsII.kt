package com.eric.leetcode

class UniquePathsII {
    fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
        val dp = Array(obstacleGrid.size) { IntArray(obstacleGrid[0].size) { 0 } }
        if (obstacleGrid[0][0] == 1) {
            dp[0][0] = 0
        } else {
            dp[0][0] = 1
        }
        for (i in obstacleGrid.indices) {
            for (j in obstacleGrid[0].indices) {
                if (i == 0 && j == 0) {
                    continue
                } else if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0
                } else if (i - 1 < 0) {
                    dp[i][j] = dp[i][j - 1]
                } else if (j - 1 < 0) {
                    dp[i][j] = dp[i - 1][j]
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
                }
            }
        }
        return dp[dp.lastIndex][dp[0].lastIndex]
    }
}

fun main(args: Array<String>) {
    val input = arrayOf(intArrayOf(0, 0, 0), intArrayOf(0, 1, 0), intArrayOf(0, 0, 0))
    val uniquePathsII = UniquePathsII()
    println(uniquePathsII.uniquePathsWithObstacles(input))
}