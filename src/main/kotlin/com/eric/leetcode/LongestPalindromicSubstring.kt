package com.eric.leetcode

class LongestPalindromicSubstring {
    fun longestPalindrome(s: String): String {
        if (s.length < 2) {
            return s
        }
        var left = 0
        var maxLength = 1
        val dp = Array(s.length) {
            Array(s.length) {
                true
            }
        }
        for (L in 2..s.length) {
            for (i in 0..s.lastIndex) {
                val j = L + i - 1;
                if (j >= s.length) {
                    break
                }
                if (s[i] != s[j]) {
                    dp[i][j] = false
                } else {
                    dp[i][j] = dp[i+1][j-1]
                }
                if (dp[i][j] && L > maxLength) {
                    maxLength = L
                    left = i
                }
            }
        }
        return s.substring(left until left+maxLength)
    }
}

fun main() {

}