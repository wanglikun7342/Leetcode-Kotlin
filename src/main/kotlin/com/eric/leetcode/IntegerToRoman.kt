package com.eric.leetcode

class IntegerToRoman {
    fun intToRoman(num: Int): String {
        var cur = num
        val result = StringBuilder()
        while (cur != 0) {
            if (cur >= 1000) {
                val M = cur / 1000
                cur %= 1000
                result.append("M".repeat(M))
            } else if (cur >= 900) {
                cur -= 900
                result.append("CM")
            } else if (cur >= 500) {
                val D = cur / 500
                cur %= 500
                result.append("D".repeat(D))
            } else if (cur >= 400) {
                cur -= 400
                result.append("CD")
            } else if (cur >= 100) {
                val C = cur / 100
                cur %= 100
                result.append("C".repeat(C))
            } else if (cur >= 90) {
                cur -= 90
                result.append("XC")
            } else if (cur >= 50) {
                val L = cur / 50
                cur %= 50
                result.append("L".repeat(L))
            } else if (cur >= 40) {
                cur -= 40
                result.append("XL")
            } else if (cur >= 10) {
                val X = cur / 10
                cur %= 10
                result.append("X".repeat(X))
            } else if (cur == 9) {
                cur -= 9
                result.append("IX")
            } else if (cur >= 5) {
                val V = cur / 5
                cur %= 5
                result.append("V".repeat(V))
            } else if (cur == 4) {
                cur -= 4
                result.append("IV")
            } else {
                val I = cur / 1
                cur %= 1
                result.append("I".repeat(I))
            }
        }
        return result.toString()
    }
}

fun main() {
    val input = 9
    val integerToRoman = IntegerToRoman()
    print(integerToRoman.intToRoman(input))
}