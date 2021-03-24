package com.eric.leetcode

class CountSortedVowelStrings {
    fun countVowelStrings(n: Int): Int {
        var a = 1
        var e = 1
        var i = 1
        var o = 1
        val u = 1
        for (index in 1 until n) {
            a += e + i + o + u
            e += i + o + u
            i += o + u
            o += u
        }
        return a + e + i + o + u
    }
}

fun main() {
    val countSortedVowelStrings = CountSortedVowelStrings()
    print(countSortedVowelStrings.countVowelStrings(2))
}