package com.eric.leetcode

class SplitAStringInBalancedStrings {
    fun balancedStringSplit(s: String): Int {
        var result = 0
        var sumL = 0
        var sumR = 0
        for (ch in s) {
            if (ch == 'L') {
                sumL++
            } else if (ch == 'R') {
                sumR++
            }
            if (sumL != 0 && sumR != 0 && sumL == sumR) {
                result++
                sumL = 0
                sumR = 0
            }
        }
        return result
    }
}

fun main(args: Array<String>) {
    val input = "RLRRLLRLRL"
    val splitAStringInBalancedStrings = SplitAStringInBalancedStrings()
    println(splitAStringInBalancedStrings.balancedStringSplit(input))
}