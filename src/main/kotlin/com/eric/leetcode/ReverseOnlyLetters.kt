package com.eric.leetcode

class ReverseOnlyLetters {
    fun reverseOnlyLetters(S: String): String {
        val result = CharArray(S.length)
        var start = 0
        var end = S.lastIndex
        while (start <= end) {
            if (!S[start].isLetter()) {
                result[start] = S[start]
                start++
                continue
            }
            if (!S[end].isLetter()) {
                result[end] = S[end]
                end--
                continue
            }
            if (S[start].isLetter() && S[end].isLetter()) {
                result[start] = S[end]
                result[end] = S[start]
                start++
                end--
                continue
            }
        }
        return String(result)
    }
}

fun main(args: Array<String>) {
    val input = "-"
    val reverseOnlyLetters = ReverseOnlyLetters()
    print(reverseOnlyLetters.reverseOnlyLetters(input))
}