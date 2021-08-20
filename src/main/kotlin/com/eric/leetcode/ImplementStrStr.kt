package com.eric.leetcode

class ImplementStrStr {
    fun strStr(haystack: String, needle: String): Int {
        if (needle.isEmpty()) {
            return 0
        }
        loop@ for (el in haystack.withIndex()) {
            if (el.value == needle[0]) {
                for (index in needle.indices) {
                    if (el.index + index > haystack.lastIndex && needle[index] != haystack[el.index + index]) {
                        continue@loop
                    }
                }
                return el.index
            }
        }
        return -1
    }
}