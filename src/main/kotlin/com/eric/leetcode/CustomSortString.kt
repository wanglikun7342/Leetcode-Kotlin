package com.eric.leetcode

class CustomSortString {
    fun customSortString(S: String, T: String): String {
        val map = mutableMapOf<Char, Int>()
        for (el in S) {
            map[el] = 0
        }
        for (el in T) {
            var num = map[el]
            if (num == null || num == 0) {
                num = 1
            } else {
                num++
            }
            map[el] = num
        }
        val result = StringBuilder()
        for (el in map.keys) {
            val num = map[el]
            if (num == null) {
                continue
            } else {
                for (i in 1..num) {
                    result.append(el)
                }
            }
        }
        return result.toString()
    }
}

fun main(args: Array<String>) {
    val S = "cba"
    val T = "abcd"
    val customSortString = CustomSortString()
    val result = customSortString.customSortString(S, T)
    println(result)
}