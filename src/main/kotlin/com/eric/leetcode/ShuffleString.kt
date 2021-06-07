package com.eric.leetcode

import java.lang.StringBuilder

class ShuffleString {
    fun restoreString(s: String, indices: IntArray): String {
        val map = mutableMapOf<Int, Char>()
        for (index in s.indices) {
            map[indices[index]] = s[index]
        }
        val result = StringBuilder()
        for (index in map.keys.indices) {
            result.append(map[index])
        }
        return result.toString()
    }
}