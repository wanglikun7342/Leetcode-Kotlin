package com.eric.leetcode

import java.util.*

class MinimumAddToMakeParenthesesValid {
    fun minAddToMakeValid(S: String): Int {
        val stack = ArrayDeque<Char>()
        for (ch in S) {
            if (stack.isEmpty()) {
                stack.push(ch)
                continue
            }
            if (ch == ')' && stack.first == '(') {
                stack.pop()
            } else {
                stack.push(ch)
            }
        }
        return stack.size
    }
}

fun main(args: Array<String>) {
    val input = "())"
    val minimumAddToMakeParenthesesValid = MinimumAddToMakeParenthesesValid()
    println(minimumAddToMakeParenthesesValid.minAddToMakeValid(input))
}