package com.eric.leetcode

class LongestPalindromicSubsequence {
    fun longestPalindromeSubseq(s: String): Int {
        if (s.isEmpty()) {
            return 0
        }
        val dp = Array(s.length) { Array(s.length) { 0 } }
        for (i in s.lastIndex downTo 0) {
            dp[i][i] = 1
            for (j in (i + 1)..s.lastIndex) {
                if (s[i] == s[j]) {
                    dp[i][j] = dp[i+1][j-1] + 2
                } else {
                    dp[i][j] = maxOf(dp[i+1][j], dp[i][j-1])
                }
            }
        }
        return dp[0][s.lastIndex]
    }
}

fun main(args: Array<String>) {
    val input = "bbbab"
    val longestPalindromicSubsequence = LongestPalindromicSubsequence()
    println(longestPalindromicSubsequence.longestPalindromeSubseq(input))
}