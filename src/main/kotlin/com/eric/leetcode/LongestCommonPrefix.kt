package com.eric.leetcode

class LongestCommonPrefix {
    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.isEmpty()) {
            return ""
        }
        if (strs.size == 1) {
            return strs[0]
        }
        return lcp(strs[0], 1, strs)
    }

    private fun lcp(s1: String, cur: Int, strs: Array<String>): String {
        val s2 = strs[cur]
        var index = 0
        var commonPrefix = "";
        while (index <= s1.lastIndex && index <= s2.lastIndex) {
            if (s1[index] == s2[index]) {
                commonPrefix += s1[index]
            } else {
                break
            }
            index++
        }
        if (cur == strs.lastIndex) {
            return commonPrefix
        }
        return lcp(commonPrefix, cur + 1, strs)
    }
}