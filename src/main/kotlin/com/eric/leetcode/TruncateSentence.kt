package com.eric.leetcode

class TruncateSentence {
    fun truncateSentence(s: String, k: Int): String {
        var counts = 0
        for(el in s.withIndex()) {
            val index = el.index
            val ch = el.value
            if (ch == ' ') {
                counts++
                if (counts == k) {
                    return s.substring(0, index)
                }
            }
        }
        return s
    }
}