package com.eric.leetcode


class BurstBalloons {
    fun maxCoins(nums: IntArray): Int {
        val fullNums = nums.toMutableList()
        fullNums.add(0, 1)
        fullNums.add(1)
        val dp = Array(fullNums.size) { Array(fullNums.size) { 0 } }
        for (len in 2..fullNums.lastIndex) {
            for (i in 0..fullNums.lastIndex - len) {
                val j = i + len
                for (k in i + 1..j - 1) {
                    dp[i][j] = maxOf(dp[i][j], fullNums[k] * fullNums[i] * fullNums[j] + dp[i][k] + dp[k][j])
                }
            }
        }
        return dp[0][dp.lastIndex]
    }
}

fun main(args: Array<String>) {
    val input = intArrayOf(3, 1, 5, 8)
    val burstBalloons = BurstBalloons()
    println(burstBalloons.maxCoins(input))
}