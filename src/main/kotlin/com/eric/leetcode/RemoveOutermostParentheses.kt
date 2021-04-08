package com.eric.leetcode

class RemoveOutermostParentheses {
    fun removeOuterParentheses(S: String): String {
        var start = 0
        var left = 0
        var right = 0
        val result = StringBuilder()
        for (index in S.indices) {
            if (S[index] == '(') {
                left++
            } else {
                right++
            }
            if (left == right) {
                result.append(S.subSequence(start + 1, index))
                start = index + 1
            }
        }
        return result.toString();
    }
}

fun main() {
    val input = "()()"
    val removeOutermostParentheses = RemoveOutermostParentheses()
    print(removeOutermostParentheses.removeOuterParentheses(input))
}