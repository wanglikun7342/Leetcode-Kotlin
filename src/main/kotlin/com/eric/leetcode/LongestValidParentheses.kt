package com.eric.leetcode

class LongestValidParentheses {
    fun longestValidParentheses(s: String): Int {
        var l = 0
        var r  = 0
        var length = 0
        for (ch in s) {
            if (ch == '(') {
                l++
            } else if (ch == ')') {
                r++
            }
            if (r > l) {
                l = 0
                r = 0
            } else if (r == l) {
                if (2 * r >= length) {
                    length = r + l
                }
            }
        }
        l = 0
        r = 0
        for (ch in s.reversed()) {
            if (ch == '(') {
                r++
            } else if (ch == ')') {
                l++
            }
            if (r > l) {
                l = 0
                r = 0
            } else if (r == l) {
                if (2 * r >= length) {
                    length = r + l
                }
            }
        }
        return length
    }
}

fun main(args: Array<String>) {
    val input = ")()())"
    val longestValidParentheses = LongestValidParentheses()
    print(longestValidParentheses.longestValidParentheses(input))
}