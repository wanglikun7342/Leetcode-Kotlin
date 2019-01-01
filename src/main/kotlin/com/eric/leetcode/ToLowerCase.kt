package com.eric.leetcode

class ToLowerCase {
    fun toLowerCase(str: String): String {
        val result = StringBuilder()
        for(ch in str) {
            if (ch in 'A'..'Z') {
                result.append(ch + ('a' - 'A') )
            } else {
                result.append(ch)
            }
        }
        return result.toString()
    }
}

fun main(args: Array<String>) {
    val input = "Hello"
    val toLowerCase = ToLowerCase()
    print(toLowerCase.toLowerCase(input))
}