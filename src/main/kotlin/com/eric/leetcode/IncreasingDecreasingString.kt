package com.eric.leetcode

class IncreasingDecreasingString {
    fun sortString(s: String): String {
        val arr = IntArray(26) {
            0
        }
        for (ch in s) {
            arr[ch - 'a'] += 1
        }
        val result = StringBuilder()
        while (result.length != s.length) {
            for (el in arr.withIndex()) {
                if (el.value != 0) {
                    arr[el.index] -= 1
                    result.append('a'.plus(el.index))
                }
            }
            for (index in arr.lastIndex downTo 0) {
                val count = arr[index]
                if (count != 0) {
                    arr[index] -= 1
                    result.append('a'.plus(index))
                }
            }
        }
        return result.toString()
    }
}

fun main() {
    val increasingDecreasingString = IncreasingDecreasingString()
    print(increasingDecreasingString.sortString("rat"))
}