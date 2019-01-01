package com.eric.leetcode

class CountBinarySubstrings {
    fun countBinarySubstrings(s: String): Int {
        var pre = s[0]
        var curLen = 0
        var preLen = 0
        var result = 0
        for (ch in s) {
            if (ch == pre) {
                curLen++
            } else {
                result += minOf(preLen, curLen)
                pre = ch
                preLen = curLen
                curLen = 1
            }
        }
        result += minOf(preLen, curLen)
        return result
    }
}

fun main(args: Array<String>) {
    val countBinarySubstrings = CountBinarySubstrings()
    val result = countBinarySubstrings.countBinarySubstrings("10101")
    println("result: " + result)
}